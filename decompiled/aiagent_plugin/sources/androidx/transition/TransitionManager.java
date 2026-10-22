package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static ArrayList<ViewGroup> f2763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static s f2764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ThreadLocal<WeakReference<androidx.b.a<ViewGroup, ArrayList<s>>>> f2765c;

    private static class MultiListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
        ViewGroup mSceneRoot;
        s mTransition;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
        }

        MultiListener(s r1, ViewGroup r2) {
            this.mTransition = r1;
            this.mSceneRoot = r2;
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r4) {
            removeListeners();
            TransitionManager.f2763a.remove(this.mSceneRoot);
            ArrayList r5 = (ArrayList) ZeusTransformUtils.preCheckCast(TransitionManager.a().get(this.mSceneRoot), ArrayList.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L5;
        L10:
            this.mTransition.a(true);
            return;
        L5:
            if (r5.size() <= 0) goto L10;
            Iterator r6 = r5.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            ((s) ZeusTransformUtils.preCheckCast(r6.next(), s.class, "com.obric.aiagent.plugin")).d(this.mSceneRoot);
            goto L8
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            removeListeners();
            if (TransitionManager.f2763a.remove(this.mSceneRoot) == true) goto L5;
            return true;
        L5:
            final androidx.b.a<ViewGroup, ArrayList<s>> r0 = TransitionManager.a();
            ArrayList<s> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(r0.get(this.mSceneRoot), ArrayList.class, "com.obric.aiagent.plugin");
            ArrayList r3 = null;
            if (r2 != null) goto L9;
            r2 = new ArrayList();
            r0.put(this.mSceneRoot, r2);
        L11:
            r2.add(this.mTransition);
            this.mTransition.a(new AnonymousClass1(this, r0));
            this.mTransition.a(this.mSceneRoot, false);
            if (r3 == null) goto L17;
            Iterator r1 = r3.iterator();
        L15:
            if (r1.hasNext() == false) goto L17;
            ((s) ZeusTransformUtils.preCheckCast(r1.next(), s.class, "com.obric.aiagent.plugin")).d(this.mSceneRoot);
        L17:
            this.mTransition.a(this.mSceneRoot);
            return true;
        L9:
            if (r2.size() <= 0) goto L11;
            r3 = new ArrayList(r2);
            goto L11
        }
    }

    static {
        f2764b = new c();
        f2765c = new ThreadLocal();
        f2763a = new ArrayList();
    }

    static androidx.b.a<ViewGroup, ArrayList<s>> a() {
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(f2765c.get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        androidx.b.a<ViewGroup, ArrayList<s>> r1 = (androidx.b.a) ZeusTransformUtils.preCheckCast(r0.get(), androidx.b.a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return r1;
    L7:
        androidx.b.a<ViewGroup, ArrayList<s>> r2 = new androidx.b.a();
        WeakReference<androidx.b.a<ViewGroup, ArrayList<s>>> r3 = new WeakReference(r2);
        f2765c.set(r3);
        return r2;
    }

    private static void b(ViewGroup r1, s r2) {
        if (r2 == null) goto L6;
        if (r1 == null) goto L7;
        MultiListener r0 = new MultiListener(r2, r1);
        r1.addOnAttachStateChangeListener(r0);
        r1.getViewTreeObserver().addOnPreDrawListener(r0);
        return;
    L7:
        return;
    }

    private static void c(ViewGroup r4, s r5) {
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(a().get(r4), ArrayList.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L10:
        if (r5 == null) goto L12;
        r5.a(r4, true);
    L12:
        r r6 = r.a(r4);
        if (r6 == null) goto L17;
        r6.a();
        return;
    L17:
        return;
    L5:
        if (r0.size() <= 0) goto L10;
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((s) ZeusTransformUtils.preCheckCast(r1.next(), s.class, "com.obric.aiagent.plugin")).c(r4);
        goto L8
    }

    public static void a(ViewGroup r1) {
        a(r1, null);
    }

    public static void a(ViewGroup r1, s r2) {
        if (f2763a.contains(r1) == false) goto L5;
        return;
    L5:
        if (ViewCompat.F(r1) == false) goto L12;
        f2763a.add(r1);
        if (r2 != null) goto L9;
        r2 = f2764b;
    L9:
        s r3 = r2.l();
        c(r1, r3);
        r.a(r1, null);
        b(r1, r3);
        return;
    }
}
