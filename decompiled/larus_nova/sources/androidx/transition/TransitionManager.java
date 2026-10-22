package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class TransitionManager {
    private static final String LOG_TAG = "TransitionManager";
    private static Transition sDefaultTransition;
    static ArrayList<ViewGroup> sPendingTransitions;
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions;
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions;
    private ArrayMap<Scene, Transition> mSceneTransitions;

    public static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        ViewGroup mSceneRoot;
        Transition mTransition;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r100) {
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            removeListeners();
            if (TransitionManager.sPendingTransitions.remove(this.mSceneRoot) == true) goto L5;
            return true;
        L5:
            final ArrayMap<ViewGroup, ArrayList<Transition>> r100 = TransitionManager.getRunningTransitions();
            ArrayList<Transition> r101 = r100.get(this.mSceneRoot);
            ArrayList r102 = null;
            if (r101 != null) goto L9;
            r101 = new ArrayList();
            r100.put(this.mSceneRoot, r101);
        L11:
            r101.add(this.mTransition);
            this.mTransition.addListener(new AnonymousClass1(this, r100));
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (r102 == null) goto L17;
            Iterator r103 = r102.iterator();
        L15:
            if (r103.hasNext() == false) goto L17;
            ((Transition) r103.next()).resume(this.mSceneRoot);
        L17:
            this.mTransition.playTransition(this.mSceneRoot);
            return true;
        L9:
            if (r101.size() <= 0) goto L11;
            r102 = new ArrayList(r101);
            goto L11
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r100) {
            removeListeners();
            TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList<Transition> r101 = TransitionManager.getRunningTransitions().get(this.mSceneRoot);
            if (r101 != null) goto L5;
        L10:
            this.mTransition.clearValues(true);
            return;
        L5:
            if (r101.size() <= 0) goto L10;
            Iterator<Transition> r102 = r101.iterator();
        L8:
            if (r102.hasNext() == false) goto L10;
            r102.next().resume(this.mSceneRoot);
            goto L8
        }

        public MultiListener(Transition r100, ViewGroup r101) {
            this.mTransition = r100;
            this.mSceneRoot = r101;
        }
    }

    static {
        sDefaultTransition = new AutoTransition();
        sRunningTransitions = new ThreadLocal();
        sPendingTransitions = new ArrayList();
    }

    public static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> r100 = sRunningTransitions.get();
        if (r100 == null) goto L7;
        ArrayMap<ViewGroup, ArrayList<Transition>> r101 = r100.get();
        if (r101 == null) goto L7;
        return r101;
    L7:
        ArrayMap<ViewGroup, ArrayList<Transition>> r102 = new ArrayMap();
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> r103 = new WeakReference(r102);
        sRunningTransitions.set(r103);
        return r102;
    }

    public TransitionManager() {
        this.mSceneTransitions = new ArrayMap();
        this.mScenePairTransitions = new ArrayMap();
    }

    public static void beginDelayedTransition(ViewGroup r100) {
        beginDelayedTransition(r100, null);
    }

    public static void endTransitions(ViewGroup r100) {
        sPendingTransitions.remove(r100);
        ArrayList<Transition> r101 = getRunningTransitions().get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L11;
        ArrayList r102 = new ArrayList(r101);
        int r103 = r102.size() - 1;
    L7:
        if (r103 < 0) goto L12;
        ((Transition) ListProtector.get(r102, r103)).forceToEnd(r100);
        r103 = r103 - 1;
        goto L7
    L12:
        return;
    }

    private Transition getTransition(Scene r100) {
        ViewGroup r101 = r100.getSceneRoot();
        if (r101 == null) goto L11;
        Scene r102 = Scene.getCurrentScene(r101);
        if (r102 == null) goto L11;
        ArrayMap<Scene, Transition> r103 = this.mScenePairTransitions.get(r100);
        if (r103 == null) goto L11;
        Transition r104 = r103.get(r102);
        if (r104 == null) goto L11;
        return r104;
    L11:
        Transition r105 = this.mSceneTransitions.get(r100);
        if (r105 == null) goto L15;
        return r105;
    L15:
        return sDefaultTransition;
    }

    public static void go(Scene r100) {
        changeScene(r100, sDefaultTransition);
    }

    public void transitionTo(Scene r100) {
        changeScene(r100, getTransition(r100));
    }

    public static void beginDelayedTransition(ViewGroup r100, Transition r101) {
        if (sPendingTransitions.contains(r100) == false) goto L5;
        return;
    L5:
        if (ViewCompat.isLaidOut(r100) == false) goto L12;
        sPendingTransitions.add(r100);
        if (r101 != null) goto L9;
        r101 = sDefaultTransition;
    L9:
        Transition r102 = r101.clone();
        sceneChangeSetup(r100, r102);
        Scene.setCurrentScene(r100, null);
        sceneChangeRunTransition(r100, r102);
        return;
    }

    private static void changeScene(Scene r100, Transition r101) {
        ViewGroup r102 = r100.getSceneRoot();
        if (sPendingTransitions.contains(r102) == true) goto L13;
        if (r101 != null) goto L6;
        r100.enter();
        return;
    L6:
        sPendingTransitions.add(r102);
        Transition r103 = r101.clone();
        r103.setSceneRoot(r102);
        Scene r104 = Scene.getCurrentScene(r102);
        if (r104 != null) goto L9;
    L11:
        sceneChangeSetup(r102, r103);
        r100.enter();
        sceneChangeRunTransition(r102, r103);
        return;
    L9:
        if (r104.isCreatedFromLayoutResource() == false) goto L11;
        r103.setCanRemoveViews(true);
        goto L11
    }

    public static void go(Scene r100, Transition r101) {
        changeScene(r100, r101);
    }

    private static void sceneChangeRunTransition(ViewGroup r100, Transition r101) {
        if (r101 == null) goto L6;
        if (r100 == null) goto L7;
        MultiListener r102 = new MultiListener(r101, r100);
        r100.addOnAttachStateChangeListener(r102);
        r100.getViewTreeObserver().addOnPreDrawListener(r102);
        return;
    L7:
        return;
    }

    private static void sceneChangeSetup(ViewGroup r100, Transition r101) {
        ArrayList<Transition> r102 = getRunningTransitions().get(r100);
        if (r102 != null) goto L5;
    L10:
        if (r101 == null) goto L12;
        r101.captureValues(r100, true);
    L12:
        Scene r103 = Scene.getCurrentScene(r100);
        if (r103 == null) goto L17;
        r103.exit();
        return;
    L17:
        return;
    L5:
        if (r102.size() <= 0) goto L10;
        Iterator<Transition> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r104.next().pause(r100);
        goto L8
    }

    public void setTransition(Scene r100, Transition r101) {
        this.mSceneTransitions.put(r100, r101);
    }

    public void setTransition(Scene r100, Scene r101, Transition r102) {
        ArrayMap<Scene, Transition> r103 = this.mScenePairTransitions.get(r101);
        if (r103 != null) goto L5;
        r103 = new ArrayMap();
        this.mScenePairTransitions.put(r101, r103);
    L5:
        r103.put(r100, r102);
    }
}
