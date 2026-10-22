package androidx.recyclerview.widget;

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

/* JADX INFO: loaded from: classes.dex */
public class d extends m {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f4329s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static TimeInterpolator f4330t;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f4331h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f4332i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f4333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f4334k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f4335l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f4336m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f4337n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f4338o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f4339p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f4340q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f4341r;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f4343b;

        public a(d r10, ArrayList r11) {
            this.f4343b = r10;
            this.f4342a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f4342a.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            j r11 = (j) r10.next();
            this.f4343b.Z(r11.f4376a, r11.f4377b, r11.f4378c, r11.f4379d, r11.f4380e);
            goto L4
        L6:
            this.f4342a.clear();
            this.f4343b.f4336m.remove(this.f4342a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f4345b;

        public b(d r10, ArrayList r11) {
            this.f4345b = r10;
            this.f4344a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f4344a.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            i r11 = (i) r10.next();
            this.f4345b.Y(r11);
            goto L4
        L6:
            this.f4344a.clear();
            this.f4345b.f4337n.remove(this.f4344a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f4347b;

        public c(d r10, ArrayList r11) {
            this.f4347b = r10;
            this.f4346a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f4346a.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            RecyclerView.ViewHolder r11 = (RecyclerView.ViewHolder) r10.next();
            this.f4347b.X(r11);
            goto L4
        L6:
            this.f4346a.clear();
            this.f4347b.f4335l.remove(this.f4346a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    public class C0043d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f4348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f4349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f4350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f4351d;

        public C0043d(d r10, RecyclerView.ViewHolder r11, View r12, ViewPropertyAnimator r13) {
            this.f4351d = r10;
            this.f4348a = r11;
            this.f4349b = r12;
            this.f4350c = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            super.onAnimationCancel(r10);
            this.f4349b.animate().setInterpolator(d.W());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f4350c.setListener(null);
            this.f4349b.setAlpha(1.0f);
            this.f4351d.L(this.f4348a);
            this.f4351d.f4340q.remove(this.f4348a);
            this.f4349b.animate().setInterpolator(d.W());
            this.f4351d.c0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f4351d.M(this.f4348a);
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f4352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f4353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f4354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f4355d;

        public e(d r10, RecyclerView.ViewHolder r11, View r12, ViewPropertyAnimator r13) {
            this.f4355d = r10;
            this.f4352a = r11;
            this.f4353b = r12;
            this.f4354c = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f4353b.setAlpha(1.0f);
            this.f4353b.animate().setInterpolator(d.W());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f4354c.setListener(null);
            this.f4355d.F(this.f4352a);
            this.f4355d.f4338o.remove(this.f4352a);
            this.f4353b.animate().setInterpolator(d.W());
            this.f4355d.c0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f4355d.G(this.f4352a);
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f4356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f4358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f4359d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f4360e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ d f4361f;

        public f(d r10, RecyclerView.ViewHolder r11, int r12, View r13, int r14, ViewPropertyAnimator r15) {
            this.f4361f = r10;
            this.f4356a = r11;
            this.f4357b = r12;
            this.f4358c = r13;
            this.f4359d = r14;
            this.f4360e = r15;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            if (this.f4357b == 0) goto L6;
            this.f4358c.setTranslationX(0.0f);
        L6:
            if (this.f4359d == 0) goto L9;
            this.f4358c.setTranslationY(0.0f);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f4360e.setListener(null);
            this.f4361f.J(this.f4356a);
            this.f4361f.f4339p.remove(this.f4356a);
            this.f4361f.c0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f4361f.K(this.f4356a);
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f4362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f4363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f4364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f4365d;

        public g(d r10, i r11, ViewPropertyAnimator r12, View r13) {
            this.f4365d = r10;
            this.f4362a = r11;
            this.f4363b = r12;
            this.f4364c = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f4363b.setListener(null);
            this.f4364c.setAlpha(1.0f);
            this.f4364c.setTranslationX(0.0f);
            this.f4364c.setTranslationY(0.0f);
            this.f4365d.H(this.f4362a.f4370a, true);
            this.f4365d.f4341r.remove(this.f4362a.f4370a);
            this.f4365d.c0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f4365d.I(this.f4362a.f4370a, true);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f4366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f4367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f4368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f4369d;

        public h(d r10, i r11, ViewPropertyAnimator r12, View r13) {
            this.f4369d = r10;
            this.f4366a = r11;
            this.f4367b = r12;
            this.f4368c = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f4367b.setListener(null);
            this.f4368c.setAlpha(1.0f);
            this.f4368c.setTranslationX(0.0f);
            this.f4368c.setTranslationY(0.0f);
            this.f4369d.H(this.f4366a.f4371b, false);
            this.f4369d.f4341r.remove(this.f4366a.f4371b);
            this.f4369d.c0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f4369d.I(this.f4366a.f4371b, false);
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f4370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.ViewHolder f4371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4373d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4374e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4375f;

        public i(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11) {
            this.f4370a = r10;
            this.f4371b = r11;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f4370a + ", newHolder=" + this.f4371b + ", fromX=" + this.f4372c + ", fromY=" + this.f4373d + ", toX=" + this.f4374e + ", toY=" + this.f4375f + '}';
        }

        public i(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11, int r12, int r13, int r14, int r15) {
            this(r10, r11);
            this.f4372c = r12;
            this.f4373d = r13;
            this.f4374e = r14;
            this.f4375f = r15;
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f4376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4379d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4380e;

        public j(RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14) {
            this.f4376a = r10;
            this.f4377b = r11;
            this.f4378c = r12;
            this.f4379d = r13;
            this.f4380e = r14;
        }
    }

    public d() {
        this.f4331h = new ArrayList();
        this.f4332i = new ArrayList();
        this.f4333j = new ArrayList();
        this.f4334k = new ArrayList();
        this.f4335l = new ArrayList();
        this.f4336m = new ArrayList();
        this.f4337n = new ArrayList();
        this.f4338o = new ArrayList();
        this.f4339p = new ArrayList();
        this.f4340q = new ArrayList();
        this.f4341r = new ArrayList();
    }

    public static /* synthetic */ TimeInterpolator W() {
        return f4329s;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean B(RecyclerView.ViewHolder r10) {
        g0(r10);
        r10.itemView.setAlpha(0.0f);
        this.f4332i.add(r10);
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean C(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11, int r12, int r13, int r14, int r15) {
        if (r10 == r11) goto L4;
        float r16 = r10.itemView.getTranslationX();
        float r17 = r10.itemView.getTranslationY();
        float r18 = r10.itemView.getAlpha();
        g0(r10);
        int r19 = (int) ((r14 - r12) - r16);
        int r20 = (int) ((r15 - r13) - r17);
        r10.itemView.setTranslationX(r16);
        r10.itemView.setTranslationY(r17);
        r10.itemView.setAlpha(r18);
        if (r11 == null) goto L8;
        g0(r11);
        r11.itemView.setTranslationX(-r19);
        r11.itemView.setTranslationY(-r20);
        r11.itemView.setAlpha(0.0f);
    L8:
        this.f4334k.add(new i(r10, r11, r12, r13, r14, r15));
        return true;
    L4:
        return D(r10, r12, r13, r14, r15);
    }

    @Override // androidx.recyclerview.widget.m
    public boolean D(RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14) {
        View r15 = r10.itemView;
        int r16 = r11 + ((int) r15.getTranslationX());
        int r17 = r12 + ((int) r10.itemView.getTranslationY());
        g0(r10);
        int r18 = r13 - r16;
        int r19 = r14 - r17;
        if (r18 != 0) goto L7;
        if (r19 != 0) goto L7;
        J(r10);
        return false;
    L7:
        if (r18 == 0) goto L9;
        r15.setTranslationX(-r18);
    L9:
        if (r19 == 0) goto L11;
        r15.setTranslationY(-r19);
    L11:
        this.f4333j.add(new j(r10, r16, r17, r13, r14));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean E(RecyclerView.ViewHolder r10) {
        g0(r10);
        this.f4331h.add(r10);
        return true;
    }

    public void X(RecyclerView.ViewHolder r10) {
        View r11 = r10.itemView;
        ViewPropertyAnimator r12 = r11.animate();
        this.f4338o.add(r10);
        r12.alpha(1.0f).setDuration(l()).setInterpolator(f4330t).setListener(new e(this, r10, r11, r12)).start();
    }

    public void Y(i r10) {
        RecyclerView.ViewHolder r11 = r10.f4370a;
        View r12 = null;
        if (r11 != null) goto L5;
        View r13 = null;
    L6:
        RecyclerView.ViewHolder r14 = r10.f4371b;
        if (r14 == null) goto L10;
        r12 = r14.itemView;
    L10:
        if (r13 == null) goto L12;
        ViewPropertyAnimator r15 = r13.animate().setDuration(m());
        this.f4341r.add(r10.f4370a);
        r15.translationX(r10.f4374e - r10.f4372c);
        r15.translationY(r10.f4375f - r10.f4373d);
        r15.alpha(0.0f).setListener(new g(this, r10, r15, r13)).start();
    L12:
        if (r12 == null) goto L15;
        ViewPropertyAnimator r16 = r12.animate();
        this.f4341r.add(r10.f4371b);
        r16.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(this, r10, r16, r12)).start();
        return;
    L15:
        return;
    L5:
        r13 = r11.itemView;
        goto L6
    }

    public void Z(RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14) {
        View r15 = r10.itemView;
        int r16 = r13 - r11;
        int r17 = r14 - r12;
        if (r16 == 0) goto L5;
        r15.animate().translationX(0.0f);
    L5:
        if (r17 == 0) goto L7;
        r15.animate().translationY(0.0f);
    L7:
        ViewPropertyAnimator r18 = r15.animate();
        this.f4339p.add(r10);
        r18.setDuration(n()).setListener(new f(this, r10, r16, r15, r17, r18)).start();
    }

    public final void a0(RecyclerView.ViewHolder r10) {
        View r11 = r10.itemView;
        ViewPropertyAnimator r12 = r11.animate();
        this.f4340q.add(r10);
        r12.setDuration(o()).alpha(0.0f).setInterpolator(f4330t).setListener(new C0043d(this, r10, r11, r12)).start();
    }

    public void b0(List r10) {
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        ((RecyclerView.ViewHolder) r10.get(r11)).itemView.animate().cancel();
        r11 = r11 - 1;
        goto L3
    }

    public void c0() {
        if (p() == true) goto L6;
        i();
        return;
    }

    public final void d0(List r10, RecyclerView.ViewHolder r11) {
        int r12 = r10.size() - 1;
    L3:
        if (r12 < 0) goto L12;
        i r13 = (i) r10.get(r12);
        if (f0(r13, r11) == false) goto L11;
        if (r13.f4370a != null) goto L11;
        if (r13.f4371b != null) goto L11;
        r10.remove(r13);
    L11:
        r12 = r12 - 1;
        goto L3
    }

    public final void e0(i r10) {
        RecyclerView.ViewHolder r11 = r10.f4370a;
        if (r11 == null) goto L5;
        f0(r10, r11);
    L5:
        RecyclerView.ViewHolder r12 = r10.f4371b;
        if (r12 == null) goto L9;
        f0(r10, r12);
        return;
    }

    public final boolean f0(i r10, RecyclerView.ViewHolder r11) {
        boolean r12 = false;
        if (r10.f4371b != r11) goto L6;
        r10.f4371b = null;
    L8:
        r11.itemView.setAlpha(1.0f);
        r11.itemView.setTranslationX(0.0f);
        r11.itemView.setTranslationY(0.0f);
        H(r11, r12);
        return true;
    L6:
        if (r10.f4370a != r11) goto L10;
        r10.f4370a = null;
        r12 = true;
        goto L8
    L10:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean g(RecyclerView.ViewHolder r10, List r11) {
        if (r11.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super.g(r10, r11) == true) goto L8;
        return false;
    }

    public final void g0(RecyclerView.ViewHolder r10) {
        if (f4329s != null) goto L6;
        f4329s = new androidx.recyclerview.base.e();
    L6:
        if (f4330t != null) goto L8;
        f4330t = new LinearInterpolator();
    L8:
        r10.itemView.animate().setInterpolator(f4329s);
        j(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void j(RecyclerView.ViewHolder r10) {
        View r11 = r10.itemView;
        r11.animate().cancel();
        int r12 = this.f4333j.size();
    L3:
        r12 = r12 - 1;
        if (r12 < 0) goto L9;
        if (((j) this.f4333j.get(r12)).f4376a != r10) goto L3;
        r11.setTranslationY(0.0f);
        r11.setTranslationX(0.0f);
        J(r10);
        this.f4333j.remove(r12);
        goto L3
    L9:
        d0(this.f4334k, r10);
        if (this.f4331h.remove(r10) == false) goto L13;
        r11.setAlpha(1.0f);
        L(r10);
    L13:
        if (this.f4332i.remove(r10) == false) goto L15;
        r11.setAlpha(1.0f);
        F(r10);
    L15:
        int r13 = this.f4337n.size() - 1;
    L16:
        if (r13 < 0) goto L21;
        ArrayList r14 = (ArrayList) this.f4337n.get(r13);
        d0(r14, r10);
        if (r14.isEmpty() == false) goto L20;
        this.f4337n.remove(r13);
    L20:
        r13 = r13 - 1;
        goto L16
    L21:
        int r15 = this.f4336m.size() - 1;
    L22:
        if (r15 < 0) goto L32;
        ArrayList r16 = (ArrayList) this.f4336m.get(r15);
        int r17 = r16.size() - 1;
    L24:
        if (r17 < 0) goto L31;
        if (((j) r16.get(r17)).f4376a == r10) goto L27;
        r17 = r17 - 1;
        goto L24
    L27:
        r11.setTranslationY(0.0f);
        r11.setTranslationX(0.0f);
        J(r10);
        r16.remove(r17);
        if (r16.isEmpty() == false) goto L31;
        this.f4336m.remove(r15);
    L31:
        r15 = r15 - 1;
        goto L22
    L32:
        int r18 = this.f4335l.size() - 1;
    L33:
        if (r18 < 0) goto L40;
        ArrayList r19 = (ArrayList) this.f4335l.get(r18);
        if (r19.remove(r10) == false) goto L39;
        r11.setAlpha(1.0f);
        F(r10);
        if (r19.isEmpty() == false) goto L39;
        this.f4335l.remove(r18);
    L39:
        r18 = r18 - 1;
        goto L33
    L40:
        this.f4340q.remove(r10);
        this.f4338o.remove(r10);
        this.f4341r.remove(r10);
        this.f4339p.remove(r10);
        c0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void k() {
        int r10 = this.f4333j.size();
    L3:
        r10 = r10 - 1;
        if (r10 < 0) goto L6;
        j r11 = (j) this.f4333j.get(r10);
        View r12 = r11.f4376a.itemView;
        r12.setTranslationY(0.0f);
        r12.setTranslationX(0.0f);
        J(r11.f4376a);
        this.f4333j.remove(r10);
        goto L3
    L6:
        int r13 = this.f4331h.size() - 1;
    L7:
        if (r13 < 0) goto L9;
        L((RecyclerView.ViewHolder) this.f4331h.get(r13));
        this.f4331h.remove(r13);
        r13 = r13 - 1;
        goto L7
    L9:
        int r14 = this.f4332i.size();
    L10:
        r14 = r14 - 1;
        if (r14 < 0) goto L13;
        RecyclerView.ViewHolder r15 = (RecyclerView.ViewHolder) this.f4332i.get(r14);
        r15.itemView.setAlpha(1.0f);
        F(r15);
        this.f4332i.remove(r14);
        goto L10
    L13:
        int r16 = this.f4334k.size() - 1;
    L14:
        if (r16 < 0) goto L16;
        e0((i) this.f4334k.get(r16));
        r16 = r16 - 1;
        goto L14
    L16:
        this.f4334k.clear();
        if (p() == true) goto L19;
        return;
    L19:
        int r17 = this.f4336m.size() - 1;
    L20:
        if (r17 < 0) goto L28;
        ArrayList r18 = (ArrayList) this.f4336m.get(r17);
        int r19 = r18.size() - 1;
    L22:
        if (r19 < 0) goto L27;
        j r20 = (j) r18.get(r19);
        View r21 = r20.f4376a.itemView;
        r21.setTranslationY(0.0f);
        r21.setTranslationX(0.0f);
        J(r20.f4376a);
        r18.remove(r19);
        if (r18.isEmpty() == false) goto L26;
        this.f4336m.remove(r18);
    L26:
        r19 = r19 - 1;
        goto L22
    L27:
        r17 = r17 - 1;
        goto L20
    L28:
        int r22 = this.f4335l.size() - 1;
    L29:
        if (r22 < 0) goto L37;
        ArrayList r23 = (ArrayList) this.f4335l.get(r22);
        int r24 = r23.size() - 1;
    L31:
        if (r24 < 0) goto L36;
        RecyclerView.ViewHolder r25 = (RecyclerView.ViewHolder) r23.get(r24);
        r25.itemView.setAlpha(1.0f);
        F(r25);
        r23.remove(r24);
        if (r23.isEmpty() == false) goto L35;
        this.f4335l.remove(r23);
    L35:
        r24 = r24 - 1;
        goto L31
    L36:
        r22 = r22 - 1;
        goto L29
    L37:
        int r26 = this.f4337n.size() - 1;
    L38:
        if (r26 < 0) goto L46;
        ArrayList r27 = (ArrayList) this.f4337n.get(r26);
        int r28 = r27.size() - 1;
    L40:
        if (r28 < 0) goto L45;
        e0((i) r27.get(r28));
        if (r27.isEmpty() == false) goto L44;
        this.f4337n.remove(r27);
    L44:
        r28 = r28 - 1;
        goto L40
    L45:
        r26 = r26 - 1;
        goto L38
    L46:
        b0(this.f4340q);
        b0(this.f4339p);
        b0(this.f4338o);
        b0(this.f4341r);
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean p() {
        if (this.f4332i.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.f4334k.isEmpty() == false) goto L26;
        if (this.f4333j.isEmpty() == false) goto L26;
        if (this.f4331h.isEmpty() == false) goto L26;
        if (this.f4339p.isEmpty() == false) goto L26;
        if (this.f4340q.isEmpty() == false) goto L26;
        if (this.f4338o.isEmpty() == false) goto L26;
        if (this.f4341r.isEmpty() == false) goto L26;
        if (this.f4336m.isEmpty() == false) goto L26;
        if (this.f4335l.isEmpty() == false) goto L26;
        if (this.f4337n.isEmpty() == false) goto L26;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void v() {
        boolean r10 = this.f4331h.isEmpty();
        boolean r11 = this.f4333j.isEmpty();
        boolean r12 = this.f4334k.isEmpty();
        boolean r13 = this.f4332i.isEmpty();
        if (r10 == false) goto L8;
        if (r11 == false) goto L8;
        if (r13 == false) goto L8;
        if (r12 == false) goto L8;
        return;
    L8:
        Iterator r14 = this.f4331h.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        a0((RecyclerView.ViewHolder) r14.next());
        goto L10
    L12:
        this.f4331h.clear();
        if (r11 == true) goto L18;
        ArrayList r15 = new ArrayList();
        r15.addAll(this.f4333j);
        this.f4336m.add(r15);
        this.f4333j.clear();
        a r16 = new a(this, r15);
        if (r10 == true) goto L17;
        ViewCompat.i0(((j) r15.get(0)).f4376a.itemView, r16, o());
        goto L18
    L17:
        r16.run();
    L18:
        if (r12 == true) goto L23;
        ArrayList r17 = new ArrayList();
        r17.addAll(this.f4334k);
        this.f4337n.add(r17);
        this.f4334k.clear();
        b r18 = new b(this, r17);
        if (r10 == true) goto L22;
        ViewCompat.i0(((i) r17.get(0)).f4370a.itemView, r18, o());
        goto L23
    L22:
        r18.run();
    L23:
        if (r13 == true) goto L42;
        ArrayList r19 = new ArrayList();
        r19.addAll(this.f4332i);
        this.f4335l.add(r19);
        this.f4332i.clear();
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
        ViewCompat.i0(((RecyclerView.ViewHolder) r19.get(0)).itemView, r20, r22 + Math.max(r23, r21));
        return;
    L36:
        r23 = 0;
        goto L37
    L33:
        r22 = 0;
        goto L34
    }
}
