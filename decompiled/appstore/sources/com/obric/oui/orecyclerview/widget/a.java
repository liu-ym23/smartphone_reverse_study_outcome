package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class a extends com.obric.oui.orecyclerview.widget.j {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f15598s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static TimeInterpolator f15599t;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f15600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f15601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f15602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f15603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f15604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f15605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f15606n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f15607o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f15608p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f15609q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f15610r;

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.a$a, reason: collision with other inner class name */
    public class RunnableC0198a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f15611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f15612b;

        public RunnableC0198a(a r10, ArrayList r11) {
            this.f15612b = r10;
            this.f15611a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f15611a.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            j r11 = (j) r10.next();
            this.f15612b.T(r11.f15645a, r11.f15646b, r11.f15647c, r11.f15648d, r11.f15649e);
            goto L4
        L6:
            this.f15611a.clear();
            this.f15612b.f15605m.remove(this.f15611a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f15613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f15614b;

        public b(a r10, ArrayList r11) {
            this.f15614b = r10;
            this.f15613a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f15613a.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            i r11 = (i) r10.next();
            this.f15614b.S(r11);
            goto L4
        L6:
            this.f15613a.clear();
            this.f15614b.f15606n.remove(this.f15613a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f15615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f15616b;

        public c(a r10, ArrayList r11) {
            this.f15616b = r10;
            this.f15615a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f15615a.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            RecyclerView.t r11 = (RecyclerView.t) r10.next();
            this.f15616b.R(r11);
            goto L4
        L6:
            this.f15615a.clear();
            this.f15616b.f15604l.remove(this.f15615a);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.t f15617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f15618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f15619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f15620d;

        public d(a r10, RecyclerView.t r11, View r12, ViewPropertyAnimator r13) {
            this.f15620d = r10;
            this.f15617a = r11;
            this.f15618b = r12;
            this.f15619c = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f15619c.setListener(null);
            this.f15618b.setAlpha(1.0f);
            this.f15620d.G(this.f15617a);
            this.f15620d.f15609q.remove(this.f15617a);
            this.f15618b.animate().setInterpolator(a.Q());
            this.f15620d.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f15620d.H(this.f15617a);
            this.f15618b.animate().setInterpolator(a.Q());
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.t f15621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f15622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f15623c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f15624d;

        public e(a r10, RecyclerView.t r11, View r12, ViewPropertyAnimator r13) {
            this.f15624d = r10;
            this.f15621a = r11;
            this.f15622b = r12;
            this.f15623c = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f15622b.setAlpha(1.0f);
            this.f15622b.animate().setInterpolator(a.Q());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f15623c.setListener(null);
            this.f15624d.A(this.f15621a);
            this.f15624d.f15607o.remove(this.f15621a);
            this.f15622b.animate().setInterpolator(a.Q());
            this.f15624d.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f15624d.B(this.f15621a);
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.t f15625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f15627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f15628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f15629e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f15630f;

        public f(a r10, RecyclerView.t r11, int r12, View r13, int r14, ViewPropertyAnimator r15) {
            this.f15630f = r10;
            this.f15625a = r11;
            this.f15626b = r12;
            this.f15627c = r13;
            this.f15628d = r14;
            this.f15629e = r15;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            if (this.f15626b == 0) goto L6;
            this.f15627c.setTranslationX(0.0f);
        L6:
            if (this.f15628d == 0) goto L9;
            this.f15627c.setTranslationY(0.0f);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f15629e.setListener(null);
            this.f15630f.E(this.f15625a);
            this.f15630f.f15608p.remove(this.f15625a);
            this.f15630f.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f15630f.F(this.f15625a);
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f15631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f15632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f15633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f15634d;

        public g(a r10, i r11, ViewPropertyAnimator r12, View r13) {
            this.f15634d = r10;
            this.f15631a = r11;
            this.f15632b = r12;
            this.f15633c = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f15632b.setListener(null);
            this.f15633c.setAlpha(1.0f);
            this.f15633c.setTranslationX(0.0f);
            this.f15633c.setTranslationY(0.0f);
            this.f15634d.C(this.f15631a.f15639a, true);
            this.f15634d.f15610r.remove(this.f15631a.f15639a);
            this.f15634d.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f15634d.D(this.f15631a.f15639a, true);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f15635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f15636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f15637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f15638d;

        public h(a r10, i r11, ViewPropertyAnimator r12, View r13) {
            this.f15638d = r10;
            this.f15635a = r11;
            this.f15636b = r12;
            this.f15637c = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f15636b.setListener(null);
            this.f15637c.setAlpha(1.0f);
            this.f15637c.setTranslationX(0.0f);
            this.f15637c.setTranslationY(0.0f);
            this.f15638d.C(this.f15635a.f15640b, false);
            this.f15638d.f15610r.remove(this.f15635a.f15640b);
            this.f15638d.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f15638d.D(this.f15635a.f15640b, false);
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.t f15639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.t f15640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15644f;

        public i(RecyclerView.t r10, RecyclerView.t r11) {
            this.f15639a = r10;
            this.f15640b = r11;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f15639a + ", newHolder=" + this.f15640b + ", fromX=" + this.f15641c + ", fromY=" + this.f15642d + ", toX=" + this.f15643e + ", toY=" + this.f15644f + '}';
        }

        public i(RecyclerView.t r10, RecyclerView.t r11, int r12, int r13, int r14, int r15) {
            this(r10, r11);
            this.f15641c = r12;
            this.f15642d = r13;
            this.f15643e = r14;
            this.f15644f = r15;
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.t f15645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15648d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15649e;

        public j(RecyclerView.t r10, int r11, int r12, int r13, int r14) {
            this.f15645a = r10;
            this.f15646b = r11;
            this.f15647c = r12;
            this.f15648d = r13;
            this.f15649e = r14;
        }
    }

    public a() {
        this.f15600h = new ArrayList();
        this.f15601i = new ArrayList();
        this.f15602j = new ArrayList();
        this.f15603k = new ArrayList();
        this.f15604l = new ArrayList();
        this.f15605m = new ArrayList();
        this.f15606n = new ArrayList();
        this.f15607o = new ArrayList();
        this.f15608p = new ArrayList();
        this.f15609q = new ArrayList();
        this.f15610r = new ArrayList();
    }

    public static /* synthetic */ TimeInterpolator Q() {
        return f15598s;
    }

    public void R(RecyclerView.t r10) {
        View r11 = r10.f15566a;
        ViewPropertyAnimator r12 = r11.animate();
        this.f15607o.add(r10);
        r12.alpha(1.0f).setDuration(l()).setInterpolator(f15599t).setListener(new e(this, r10, r11, r12)).start();
    }

    public void S(i r10) {
        RecyclerView.t r11 = r10.f15639a;
        View r12 = null;
        if (r11 != null) goto L5;
        View r13 = null;
    L6:
        RecyclerView.t r14 = r10.f15640b;
        if (r14 == null) goto L10;
        r12 = r14.f15566a;
    L10:
        if (r13 == null) goto L12;
        ViewPropertyAnimator r15 = r13.animate().setDuration(m());
        this.f15610r.add(r10.f15639a);
        r15.translationX(r10.f15643e - r10.f15641c);
        r15.translationY(r10.f15644f - r10.f15642d);
        r15.alpha(0.0f).setListener(new g(this, r10, r15, r13)).start();
    L12:
        if (r12 == null) goto L15;
        ViewPropertyAnimator r16 = r12.animate();
        this.f15610r.add(r10.f15640b);
        r16.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(this, r10, r16, r12)).start();
        return;
    L15:
        return;
    L5:
        r13 = r11.f15566a;
        goto L6
    }

    public void T(RecyclerView.t r10, int r11, int r12, int r13, int r14) {
        View r15 = r10.f15566a;
        int r16 = r13 - r11;
        int r17 = r14 - r12;
        if (r16 == 0) goto L5;
        r15.animate().translationX(0.0f);
    L5:
        if (r17 == 0) goto L7;
        r15.animate().translationY(0.0f);
    L7:
        ViewPropertyAnimator r18 = r15.animate();
        this.f15608p.add(r10);
        r18.setDuration(n()).setListener(new f(this, r10, r16, r15, r17, r18)).start();
    }

    public final void U(RecyclerView.t r10) {
        View r11 = r10.f15566a;
        ViewPropertyAnimator r12 = r11.animate();
        this.f15609q.add(r10);
        r12.setDuration(o()).alpha(0.0f).setInterpolator(f15599t).setListener(new d(this, r10, r11, r12)).start();
    }

    public void V(List r10) {
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        ((RecyclerView.t) r10.get(r11)).f15566a.animate().cancel();
        r11 = r11 - 1;
        goto L3
    }

    public void W() {
        if (p() == true) goto L6;
        i();
        return;
    }

    public final void X(List r10, RecyclerView.t r11) {
        int r12 = r10.size() - 1;
    L3:
        if (r12 < 0) goto L12;
        i r13 = (i) r10.get(r12);
        if (Z(r13, r11) == false) goto L11;
        if (r13.f15639a != null) goto L11;
        if (r13.f15640b != null) goto L11;
        r10.remove(r13);
    L11:
        r12 = r12 - 1;
        goto L3
    }

    public final void Y(i r10) {
        RecyclerView.t r11 = r10.f15639a;
        if (r11 == null) goto L5;
        Z(r10, r11);
    L5:
        RecyclerView.t r12 = r10.f15640b;
        if (r12 == null) goto L9;
        Z(r10, r12);
        return;
    }

    public final boolean Z(i r10, RecyclerView.t r11) {
        boolean r12 = false;
        if (r10.f15640b != r11) goto L6;
        r10.f15640b = null;
    L8:
        r11.f15566a.setAlpha(1.0f);
        r11.f15566a.setTranslationX(0.0f);
        r11.f15566a.setTranslationY(0.0f);
        C(r11, r12);
        return true;
    L6:
        if (r10.f15639a != r11) goto L10;
        r10.f15639a = null;
        r12 = true;
        goto L8
    L10:
        return false;
    }

    public final void a0(RecyclerView.t r10) {
        if (f15598s != null) goto L6;
        f15598s = new com.obric.oui.orecyclerview.base.f();
    L6:
        if (f15599t != null) goto L8;
        f15599t = new LinearInterpolator();
    L8:
        r10.f15566a.animate().setInterpolator(f15598s);
        j(r10);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public boolean g(RecyclerView.t r10, List r11) {
        if (r11.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super.g(r10, r11) == true) goto L8;
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public void j(RecyclerView.t r10) {
        View r11 = r10.f15566a;
        r11.animate().cancel();
        int r12 = this.f15602j.size();
    L3:
        r12 = r12 - 1;
        if (r12 < 0) goto L9;
        if (((j) this.f15602j.get(r12)).f15645a != r10) goto L3;
        r11.setTranslationY(0.0f);
        r11.setTranslationX(0.0f);
        E(r10);
        this.f15602j.remove(r12);
        goto L3
    L9:
        X(this.f15603k, r10);
        if (this.f15600h.remove(r10) == false) goto L13;
        r11.setAlpha(1.0f);
        G(r10);
    L13:
        if (this.f15601i.remove(r10) == false) goto L15;
        r11.setAlpha(1.0f);
        A(r10);
    L15:
        int r13 = this.f15606n.size() - 1;
    L16:
        if (r13 < 0) goto L21;
        ArrayList r14 = (ArrayList) this.f15606n.get(r13);
        X(r14, r10);
        if (r14.isEmpty() == false) goto L20;
        this.f15606n.remove(r13);
    L20:
        r13 = r13 - 1;
        goto L16
    L21:
        int r15 = this.f15605m.size() - 1;
    L22:
        if (r15 < 0) goto L32;
        ArrayList r16 = (ArrayList) this.f15605m.get(r15);
        int r17 = r16.size() - 1;
    L24:
        if (r17 < 0) goto L31;
        if (((j) r16.get(r17)).f15645a == r10) goto L27;
        r17 = r17 - 1;
        goto L24
    L27:
        r11.setTranslationY(0.0f);
        r11.setTranslationX(0.0f);
        E(r10);
        r16.remove(r17);
        if (r16.isEmpty() == false) goto L31;
        this.f15605m.remove(r15);
    L31:
        r15 = r15 - 1;
        goto L22
    L32:
        int r18 = this.f15604l.size() - 1;
    L33:
        if (r18 < 0) goto L40;
        ArrayList r19 = (ArrayList) this.f15604l.get(r18);
        if (r19.remove(r10) == false) goto L39;
        r11.setAlpha(1.0f);
        A(r10);
        if (r19.isEmpty() == false) goto L39;
        this.f15604l.remove(r18);
    L39:
        r18 = r18 - 1;
        goto L33
    L40:
        this.f15609q.remove(r10);
        this.f15607o.remove(r10);
        this.f15610r.remove(r10);
        this.f15608p.remove(r10);
        W();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public void k() {
        int r10 = this.f15602j.size();
    L3:
        r10 = r10 - 1;
        if (r10 < 0) goto L6;
        j r11 = (j) this.f15602j.get(r10);
        View r12 = r11.f15645a.f15566a;
        r12.setTranslationY(0.0f);
        r12.setTranslationX(0.0f);
        E(r11.f15645a);
        this.f15602j.remove(r10);
        goto L3
    L6:
        int r13 = this.f15600h.size() - 1;
    L7:
        if (r13 < 0) goto L9;
        G((RecyclerView.t) this.f15600h.get(r13));
        this.f15600h.remove(r13);
        r13 = r13 - 1;
        goto L7
    L9:
        int r14 = this.f15601i.size();
    L10:
        r14 = r14 - 1;
        if (r14 < 0) goto L13;
        RecyclerView.t r15 = (RecyclerView.t) this.f15601i.get(r14);
        r15.f15566a.setAlpha(1.0f);
        A(r15);
        this.f15601i.remove(r14);
        goto L10
    L13:
        int r16 = this.f15603k.size() - 1;
    L14:
        if (r16 < 0) goto L16;
        Y((i) this.f15603k.get(r16));
        r16 = r16 - 1;
        goto L14
    L16:
        this.f15603k.clear();
        if (p() == true) goto L19;
        return;
    L19:
        int r17 = this.f15605m.size() - 1;
    L20:
        if (r17 < 0) goto L28;
        ArrayList r18 = (ArrayList) this.f15605m.get(r17);
        int r19 = r18.size() - 1;
    L22:
        if (r19 < 0) goto L27;
        j r20 = (j) r18.get(r19);
        View r21 = r20.f15645a.f15566a;
        r21.setTranslationY(0.0f);
        r21.setTranslationX(0.0f);
        E(r20.f15645a);
        r18.remove(r19);
        if (r18.isEmpty() == false) goto L26;
        this.f15605m.remove(r18);
    L26:
        r19 = r19 - 1;
        goto L22
    L27:
        r17 = r17 - 1;
        goto L20
    L28:
        int r22 = this.f15604l.size() - 1;
    L29:
        if (r22 < 0) goto L37;
        ArrayList r23 = (ArrayList) this.f15604l.get(r22);
        int r24 = r23.size() - 1;
    L31:
        if (r24 < 0) goto L36;
        RecyclerView.t r25 = (RecyclerView.t) r23.get(r24);
        r25.f15566a.setAlpha(1.0f);
        A(r25);
        r23.remove(r24);
        if (r23.isEmpty() == false) goto L35;
        this.f15604l.remove(r23);
    L35:
        r24 = r24 - 1;
        goto L31
    L36:
        r22 = r22 - 1;
        goto L29
    L37:
        int r26 = this.f15606n.size() - 1;
    L38:
        if (r26 < 0) goto L46;
        ArrayList r27 = (ArrayList) this.f15606n.get(r26);
        int r28 = r27.size() - 1;
    L40:
        if (r28 < 0) goto L45;
        Y((i) r27.get(r28));
        if (r27.isEmpty() == false) goto L44;
        this.f15606n.remove(r27);
    L44:
        r28 = r28 - 1;
        goto L40
    L45:
        r26 = r26 - 1;
        goto L38
    L46:
        V(this.f15609q);
        V(this.f15608p);
        V(this.f15607o);
        V(this.f15610r);
        i();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public boolean p() {
        if (this.f15601i.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.f15603k.isEmpty() == false) goto L26;
        if (this.f15602j.isEmpty() == false) goto L26;
        if (this.f15600h.isEmpty() == false) goto L26;
        if (this.f15608p.isEmpty() == false) goto L26;
        if (this.f15609q.isEmpty() == false) goto L26;
        if (this.f15607o.isEmpty() == false) goto L26;
        if (this.f15610r.isEmpty() == false) goto L26;
        if (this.f15605m.isEmpty() == false) goto L26;
        if (this.f15604l.isEmpty() == false) goto L26;
        if (this.f15606n.isEmpty() == false) goto L26;
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public void u() {
        boolean r10 = this.f15600h.isEmpty();
        boolean r11 = this.f15602j.isEmpty();
        boolean r12 = this.f15603k.isEmpty();
        boolean r13 = this.f15601i.isEmpty();
        if (r10 == false) goto L8;
        if (r11 == false) goto L8;
        if (r13 == false) goto L8;
        if (r12 == false) goto L8;
        return;
    L8:
        Iterator r14 = this.f15600h.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        U((RecyclerView.t) r14.next());
        goto L10
    L12:
        this.f15600h.clear();
        if (r11 == true) goto L18;
        ArrayList r15 = new ArrayList();
        r15.addAll(this.f15602j);
        this.f15605m.add(r15);
        this.f15602j.clear();
        RunnableC0198a r16 = new RunnableC0198a(this, r15);
        if (r10 == true) goto L17;
        ViewCompat.i0(((j) r15.get(0)).f15645a.f15566a, r16, o());
        goto L18
    L17:
        r16.run();
    L18:
        if (r12 == true) goto L23;
        ArrayList r17 = new ArrayList();
        r17.addAll(this.f15603k);
        this.f15606n.add(r17);
        this.f15603k.clear();
        b r18 = new b(this, r17);
        if (r10 == true) goto L22;
        ViewCompat.i0(((i) r17.get(0)).f15639a.f15566a, r18, o());
        goto L23
    L22:
        r18.run();
    L23:
        if (r13 == true) goto L42;
        ArrayList r19 = new ArrayList();
        r19.addAll(this.f15601i);
        this.f15604l.add(r19);
        this.f15601i.clear();
        c r20 = new c(this, r19);
        if (r10 == false) goto L30;
        if (r11 == false) goto L30;
        if (r12 == false) goto L30;
        r20.run();
        return;
    L30:
        long r21 = 0;
        if (r10 == true) goto L33;
        long r22 = o();
    L34:
        if (r11 == true) goto L36;
        long r23 = n();
    L37:
        if (r12 == true) goto L39;
        r21 = m();
    L39:
        ViewCompat.i0(((RecyclerView.t) r19.get(0)).f15566a, r20, r22 + Math.max(r23, r21));
        return;
    L36:
        r23 = 0;
        goto L37
    L33:
        r22 = 0;
        goto L34
    }

    @Override // com.obric.oui.orecyclerview.widget.j
    public boolean w(RecyclerView.t r10) {
        a0(r10);
        r10.f15566a.setAlpha(0.0f);
        this.f15601i.add(r10);
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.j
    public boolean x(RecyclerView.t r10, RecyclerView.t r11, int r12, int r13, int r14, int r15) {
        if (r10 == r11) goto L4;
        float r16 = r10.f15566a.getTranslationX();
        float r17 = r10.f15566a.getTranslationY();
        float r18 = r10.f15566a.getAlpha();
        a0(r10);
        int r19 = (int) ((r14 - r12) - r16);
        int r20 = (int) ((r15 - r13) - r17);
        r10.f15566a.setTranslationX(r16);
        r10.f15566a.setTranslationY(r17);
        r10.f15566a.setAlpha(r18);
        if (r11 == null) goto L8;
        a0(r11);
        r11.f15566a.setTranslationX(-r19);
        r11.f15566a.setTranslationY(-r20);
        r11.f15566a.setAlpha(0.0f);
    L8:
        this.f15603k.add(new i(r10, r11, r12, r13, r14, r15));
        return true;
    L4:
        return y(r10, r12, r13, r14, r15);
    }

    @Override // com.obric.oui.orecyclerview.widget.j
    public boolean y(RecyclerView.t r10, int r11, int r12, int r13, int r14) {
        View r15 = r10.f15566a;
        int r16 = r11 + ((int) r15.getTranslationX());
        int r17 = r12 + ((int) r10.f15566a.getTranslationY());
        a0(r10);
        int r18 = r13 - r16;
        int r19 = r14 - r17;
        if (r18 != 0) goto L7;
        if (r19 != 0) goto L7;
        E(r10);
        return false;
    L7:
        if (r18 == 0) goto L9;
        r15.setTranslationX(-r18);
    L9:
        if (r19 == 0) goto L11;
        r15.setTranslationY(-r19);
    L11:
        this.f15602j.add(new j(r10, r16, r17, r13, r14));
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.j
    public boolean z(RecyclerView.t r10) {
        a0(r10);
        this.f15600h.add(r10);
        return true;
    }
}
