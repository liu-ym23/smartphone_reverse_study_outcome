package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e0 extends f0 {

    public class a extends Transition.EpicenterCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f3326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e0 f3327b;

        public a(e0 r10, Rect r11) {
            this.f3327b = r10;
            this.f3326a = r11;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition r10) {
            return this.f3326a;
        }
    }

    public class b implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e0 f3330c;

        public b(e0 r10, View r11, ArrayList r12) {
            this.f3330c = r10;
            this.f3328a = r11;
            this.f3329b = r12;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r10) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            r10.removeListener(this);
            this.f3328a.setVisibility(8);
            int r11 = this.f3329b.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            ((View) this.f3329b.get(r12)).setVisibility(0);
            r12 = r12 + 1;
            goto L3
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r10) {
            r10.removeListener(this);
            r10.addListener(this);
        }
    }

    public class c implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f3331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f3333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3334d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f3335e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3336f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ e0 f3337g;

        public c(e0 r10, Object r11, ArrayList r12, Object r13, ArrayList r14, Object r15, ArrayList r16) {
            this.f3337g = r10;
            this.f3331a = r11;
            this.f3332b = r12;
            this.f3333c = r13;
            this.f3334d = r14;
            this.f3335e = r15;
            this.f3336f = r16;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r10) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            r10.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r10) {
            Object r11 = this.f3331a;
            if (r11 == null) goto L5;
            this.f3337g.w(r11, this.f3332b, null);
        L5:
            Object r12 = this.f3333c;
            if (r12 == null) goto L8;
            this.f3337g.w(r12, this.f3334d, null);
        L8:
            Object r13 = this.f3335e;
            if (r13 == null) goto L12;
            this.f3337g.w(r13, this.f3336f, null);
            return;
        }
    }

    public class d implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f3338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e0 f3339b;

        public d(e0 r10, Runnable r11) {
            this.f3339b = r10;
            this.f3338a = r11;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r10) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            this.f3338a.run();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r10) {
        }
    }

    public class e extends Transition.EpicenterCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f3340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e0 f3341b;

        public e(e0 r10, Rect r11) {
            this.f3341b = r10;
            this.f3340a = r11;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition r10) {
            Rect r11 = this.f3340a;
            if (r11 != null) goto L5;
            return null;
        L5:
            if (r11.isEmpty() == false) goto L8;
            return null;
        L8:
            return this.f3340a;
        }
    }

    public e0() {
    }

    public static boolean v(Transition r10) {
        if (f0.i(r10.getTargetIds()) == true) goto L5;
    L10:
        return true;
    L5:
        if (f0.i(r10.getTargetNames()) == false) goto L10;
        if (f0.i(r10.getTargetTypes()) == false) goto L10;
        return false;
    }

    @Override // androidx.fragment.app.f0
    public void a(Object r10, View r11) {
        if (r10 == null) goto L5;
        ((Transition) r10).addTarget(r11);
        return;
    }

    @Override // androidx.fragment.app.f0
    public void b(Object r10, ArrayList r11) {
        Transition r12 = (Transition) r10;
        if (r12 != null) goto L5;
        return;
    L5:
        int r13 = 0;
        if ((r12 instanceof TransitionSet) == false) goto L11;
        TransitionSet r14 = (TransitionSet) r12;
        int r15 = r14.getTransitionCount();
    L8:
        if (r13 >= r15) goto L21;
        b(r14.getTransitionAt(r13), r11);
        r13 = r13 + 1;
        goto L8
    L21:
        return;
    L11:
        if (v(r12) == false) goto L13;
        return;
    L13:
        if (f0.i(r12.getTargets()) == false) goto L20;
        int r16 = r11.size();
    L15:
        if (r13 >= r16) goto L22;
        r12.addTarget((View) r11.get(r13));
        r13 = r13 + 1;
        goto L15
    L22:
        return;
    }

    @Override // androidx.fragment.app.f0
    public void c(ViewGroup r10, Object r11) {
        TransitionManager.beginDelayedTransition(r10, (Transition) r11);
    }

    @Override // androidx.fragment.app.f0
    public boolean e(Object r10) {
        return r10 instanceof Transition;
    }

    @Override // androidx.fragment.app.f0
    public Object f(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return ((Transition) r10).clone();
    }

    @Override // androidx.fragment.app.f0
    public Object j(Object r10, Object r11, Object r12) {
        Transition r13 = (Transition) r10;
        Transition r14 = (Transition) r11;
        Transition r15 = (Transition) r12;
        if (r13 == null) goto L6;
        if (r14 == null) goto L6;
        r13 = new TransitionSet().addTransition(r13).addTransition(r14).setOrdering(1);
    L11:
        if (r15 == null) goto L17;
        TransitionSet r16 = new TransitionSet();
        if (r13 == null) goto L15;
        r16.addTransition(r13);
    L15:
        r16.addTransition(r15);
        return r16;
    L17:
        return r13;
    L6:
        if (r13 != null) goto L11;
        if (r14 == null) goto L10;
        r13 = r14;
        goto L11
    L10:
        r13 = null;
        goto L11
    }

    @Override // androidx.fragment.app.f0
    public Object k(Object r10, Object r11, Object r12) {
        TransitionSet r13 = new TransitionSet();
        if (r10 == null) goto L5;
        r13.addTransition((Transition) r10);
    L5:
        if (r11 == null) goto L7;
        r13.addTransition((Transition) r11);
    L7:
        if (r12 == null) goto L9;
        r13.addTransition((Transition) r12);
    L9:
        return r13;
    }

    @Override // androidx.fragment.app.f0
    public void m(Object r10, View r11, ArrayList r12) {
        ((Transition) r10).addListener(new b(this, r11, r12));
    }

    @Override // androidx.fragment.app.f0
    public void n(Object r11, Object r12, ArrayList r13, Object r14, ArrayList r15, Object r16, ArrayList r17) {
        ((Transition) r11).addListener(new c(this, r12, r13, r14, r15, r16, r17));
    }

    @Override // androidx.fragment.app.f0
    public void o(Object r10, Rect r11) {
        if (r10 == null) goto L5;
        ((Transition) r10).setEpicenterCallback(new e(this, r11));
        return;
    }

    @Override // androidx.fragment.app.f0
    public void p(Object r10, View r11) {
        if (r11 == null) goto L5;
        Rect r12 = new Rect();
        h(r11, r12);
        ((Transition) r10).setEpicenterCallback(new a(this, r12));
        return;
    }

    @Override // androidx.fragment.app.f0
    public void q(Fragment r10, Object r11, CancellationSignal r12, Runnable r13) {
        ((Transition) r11).addListener(new d(this, r13));
    }

    @Override // androidx.fragment.app.f0
    public void s(Object r10, View r11, ArrayList r12) {
        TransitionSet r13 = (TransitionSet) r10;
        List<View> r14 = r13.getTargets();
        r14.clear();
        int r15 = r12.size();
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L5;
        f0.d(r14, (View) r12.get(r16));
        r16 = r16 + 1;
        goto L3
    L5:
        r14.add(r11);
        r12.add(r11);
        b(r13, r12);
    }

    @Override // androidx.fragment.app.f0
    public void t(Object r10, ArrayList r11, ArrayList r12) {
        TransitionSet r13 = (TransitionSet) r10;
        if (r13 == null) goto L6;
        r13.getTargets().clear();
        r13.getTargets().addAll(r12);
        w(r13, r11, r12);
        return;
    }

    @Override // androidx.fragment.app.f0
    public Object u(Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        TransitionSet r11 = new TransitionSet();
        r11.addTransition((Transition) r10);
        return r11;
    }

    public void w(Object r10, ArrayList r11, ArrayList r12) {
        Transition r13 = (Transition) r10;
        int r14 = 0;
        if ((r13 instanceof TransitionSet) == false) goto L8;
        TransitionSet r15 = (TransitionSet) r13;
        int r16 = r15.getTransitionCount();
    L5:
        if (r14 >= r16) goto L31;
        w(r15.getTransitionAt(r14), r11, r12);
        r14 = r14 + 1;
        goto L5
    L31:
        return;
    L8:
        if (v(r13) == true) goto L23;
        List<View> r17 = r13.getTargets();
        if (r17 != null) goto L12;
        return;
    L12:
        if (r17.size() == r11.size()) goto L14;
        return;
    L14:
        if (r17.containsAll(r11) == false) goto L30;
        if (r12 != null) goto L17;
        int r18 = 0;
    L18:
        if (r14 >= r18) goto L20;
        r13.addTarget((View) r12.get(r14));
        r14 = r14 + 1;
        goto L18
    L20:
        int r19 = r11.size() - 1;
    L21:
        if (r19 < 0) goto L32;
        r13.removeTarget((View) r11.get(r19));
        r19 = r19 - 1;
        goto L21
    L32:
        return;
    L17:
        r18 = r12.size();
        goto L18
    L30:
        return;
    }
}
