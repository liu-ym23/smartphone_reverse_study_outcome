package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionManager {
    private static final String LOG_TAG = "TransitionManager";
    private static Transition sDefaultTransition;
    static ArrayList<ViewGroup> sPendingTransitions;
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions;
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions;
    private ArrayMap<Scene, Transition> mSceneTransitions;

    private static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        ViewGroup mSceneRoot;
        Transition mTransition;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
        }

        MultiListener(Transition r1, ViewGroup r2) {
            this.mTransition = r1;
            this.mSceneRoot = r2;
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r3) {
            removeListeners();
            TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList<Transition> r4 = TransitionManager.getRunningTransitions().get(this.mSceneRoot);
            if (r4 != null) goto L5;
        L10:
            this.mTransition.clearValues(true);
            return;
        L5:
            if (r4.size() <= 0) goto L10;
            Iterator<Transition> r5 = r4.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            r5.next().resume(this.mSceneRoot);
            goto L8
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            removeListeners();
            if (TransitionManager.sPendingTransitions.remove(this.mSceneRoot) == true) goto L5;
            return true;
        L5:
            final ArrayMap<ViewGroup, ArrayList<Transition>> r0 = TransitionManager.getRunningTransitions();
            ArrayList<Transition> r2 = r0.get(this.mSceneRoot);
            ArrayList r3 = null;
            if (r2 != null) goto L9;
            r2 = new ArrayList();
            r0.put(this.mSceneRoot, r2);
        L11:
            r2.add(this.mTransition);
            this.mTransition.addListener(new AnonymousClass1(this, r0));
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (r3 == null) goto L17;
            Iterator r1 = r3.iterator();
        L15:
            if (r1.hasNext() == false) goto L17;
            ((Transition) r1.next()).resume(this.mSceneRoot);
        L17:
            this.mTransition.playTransition(this.mSceneRoot);
            return true;
        L9:
            if (r2.size() <= 0) goto L11;
            r3 = new ArrayList(r2);
            goto L11
        }
    }

    public TransitionManager() {
        this.mSceneTransitions = new ArrayMap();
        this.mScenePairTransitions = new ArrayMap();
    }

    static {
        sDefaultTransition = new AutoTransition();
        sRunningTransitions = new ThreadLocal();
        sPendingTransitions = new ArrayList();
    }

    public void setTransition(Scene r1, Transition r2) {
        this.mSceneTransitions.put(r1, r2);
    }

    public void setTransition(Scene r2, Scene r3, Transition r4) {
        ArrayMap<Scene, Transition> r0 = this.mScenePairTransitions.get(r3);
        if (r0 != null) goto L5;
        r0 = new ArrayMap();
        this.mScenePairTransitions.put(r3, r0);
    L5:
        r0.put(r2, r4);
    }

    private Transition getTransition(Scene r3) {
        ViewGroup r0 = r3.getSceneRoot();
        if (r0 == null) goto L11;
        Scene r1 = Scene.getCurrentScene(r0);
        if (r1 == null) goto L11;
        ArrayMap<Scene, Transition> r2 = this.mScenePairTransitions.get(r3);
        if (r2 == null) goto L11;
        Transition r4 = r2.get(r1);
        if (r4 == null) goto L11;
        return r4;
    L11:
        Transition r5 = this.mSceneTransitions.get(r3);
        if (r5 == null) goto L15;
        return r5;
    L15:
        return sDefaultTransition;
    }

    private static void changeScene(Scene r3, Transition r4) {
        ViewGroup r0 = r3.getSceneRoot();
        if (sPendingTransitions.contains(r0) == true) goto L16;
        Scene r1 = Scene.getCurrentScene(r0);
        if (r4 != null) goto L9;
        if (r1 == null) goto L8;
        r1.exit();
    L8:
        r3.enter();
        return;
    L9:
        sPendingTransitions.add(r0);
        Transition r5 = r4.clone();
        if (r1 != null) goto L12;
    L14:
        sceneChangeSetup(r0, r5);
        r3.enter();
        sceneChangeRunTransition(r0, r5);
        return;
    L12:
        if (r1.isCreatedFromLayoutResource() == false) goto L14;
        r5.setCanRemoveViews(true);
        goto L14
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> r0 = sRunningTransitions.get();
        if (r0 == null) goto L7;
        ArrayMap<ViewGroup, ArrayList<Transition>> r1 = r0.get();
        if (r1 == null) goto L7;
        return r1;
    L7:
        ArrayMap<ViewGroup, ArrayList<Transition>> r2 = new ArrayMap();
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> r3 = new WeakReference(r2);
        sRunningTransitions.set(r3);
        return r2;
    }

    private static void sceneChangeRunTransition(ViewGroup r1, Transition r2) {
        if (r2 == null) goto L6;
        if (r1 == null) goto L7;
        MultiListener r0 = new MultiListener(r2, r1);
        r1.addOnAttachStateChangeListener(r0);
        r1.getViewTreeObserver().addOnPreDrawListener(r0);
        return;
    L7:
        return;
    }

    private static void sceneChangeSetup(ViewGroup r2, Transition r3) {
        ArrayList<Transition> r0 = getRunningTransitions().get(r2);
        if (r0 != null) goto L5;
    L10:
        if (r3 == null) goto L12;
        r3.captureValues(r2, true);
    L12:
        Scene r4 = Scene.getCurrentScene(r2);
        if (r4 == null) goto L17;
        r4.exit();
        return;
    L17:
        return;
    L5:
        if (r0.size() <= 0) goto L10;
        Iterator<Transition> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().pause(r2);
        goto L8
    }

    public void transitionTo(Scene r1) {
        changeScene(r1, getTransition(r1));
    }

    public static void go(Scene r1) {
        changeScene(r1, sDefaultTransition);
    }

    public static void go(Scene r0, Transition r1) {
        changeScene(r0, r1);
    }

    public static void beginDelayedTransition(ViewGroup r1) {
        beginDelayedTransition(r1, null);
    }

    public static void beginDelayedTransition(ViewGroup r1, Transition r2) {
        if (sPendingTransitions.contains(r1) == false) goto L5;
        return;
    L5:
        if (ViewCompat.isLaidOut(r1) == false) goto L12;
        sPendingTransitions.add(r1);
        if (r2 != null) goto L9;
        r2 = sDefaultTransition;
    L9:
        Transition r3 = r2.clone();
        sceneChangeSetup(r1, r3);
        Scene.setCurrentScene(r1, null);
        sceneChangeRunTransition(r1, r3);
        return;
    }

    public static void endTransitions(ViewGroup r3) {
        sPendingTransitions.remove(r3);
        ArrayList<Transition> r0 = getRunningTransitions().get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L11;
        ArrayList r1 = new ArrayList(r0);
        int r2 = r1.size() - 1;
    L7:
        if (r2 < 0) goto L12;
        ((Transition) r1.get(r2)).forceToEnd(r3);
        r2 = r2 - 1;
        goto L7
    L12:
        return;
    }
}
