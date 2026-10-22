package p1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;
import java.util.Map;
import p1.j;

/* renamed from: p1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5041b extends j {

    /* renamed from: Q, reason: collision with root package name */
    public static final String[] f38081Q = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: R, reason: collision with root package name */
    public static final Property<i, PointF> f38082R = new a(PointF.class, "topLeft");

    /* renamed from: S, reason: collision with root package name */
    public static final Property<i, PointF> f38083S = new C0493b(PointF.class, "bottomRight");

    /* renamed from: T, reason: collision with root package name */
    public static final Property<View, PointF> f38084T = new c(PointF.class, "bottomRight");

    /* renamed from: U, reason: collision with root package name */
    public static final Property<View, PointF> f38085U = new d(PointF.class, "topLeft");

    /* renamed from: V, reason: collision with root package name */
    public static final Property<View, PointF> f38086V = new e(PointF.class, "position");

    /* renamed from: W, reason: collision with root package name */
    public static final p1.h f38087W = new p1.h();

    /* renamed from: P, reason: collision with root package name */
    public boolean f38088P = false;

    /* renamed from: p1.b$a */
    public class a extends Property<i, PointF> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.c(pointF);
        }
    }

    /* renamed from: p1.b$b, reason: collision with other inner class name */
    public class C0493b extends Property<i, PointF> {
        public C0493b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.a(pointF);
        }
    }

    /* renamed from: p1.b$c */
    public class c extends Property<View, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            C5038A.d(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* renamed from: p1.b$d */
    public class d extends Property<View, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            C5038A.d(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: p1.b$e */
    public class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            C5038A.d(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* renamed from: p1.b$f */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f38089a;
        private final i mViewBounds;

        public f(i iVar) {
            this.f38089a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* renamed from: p1.b$g */
    public static class g extends AnimatorListenerAdapter implements j.h {

        /* renamed from: a, reason: collision with root package name */
        public final View f38091a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f38092b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f38093c;

        /* renamed from: d, reason: collision with root package name */
        public final Rect f38094d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f38095e;

        /* renamed from: f, reason: collision with root package name */
        public final int f38096f;

        /* renamed from: g, reason: collision with root package name */
        public final int f38097g;

        /* renamed from: h, reason: collision with root package name */
        public final int f38098h;

        /* renamed from: i, reason: collision with root package name */
        public final int f38099i;

        /* renamed from: j, reason: collision with root package name */
        public final int f38100j;

        /* renamed from: k, reason: collision with root package name */
        public final int f38101k;

        /* renamed from: l, reason: collision with root package name */
        public final int f38102l;

        /* renamed from: m, reason: collision with root package name */
        public final int f38103m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f38104n;

        public g(View view, Rect rect, boolean z10, Rect rect2, boolean z11, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f38091a = view;
            this.f38092b = rect;
            this.f38093c = z10;
            this.f38094d = rect2;
            this.f38095e = z11;
            this.f38096f = i10;
            this.f38097g = i11;
            this.f38098h = i12;
            this.f38099i = i13;
            this.f38100j = i14;
            this.f38101k = i15;
            this.f38102l = i16;
            this.f38103m = i17;
        }

        @Override // p1.j.h
        public void c(j jVar) {
            this.f38104n = true;
        }

        @Override // p1.j.h
        public void e(j jVar) {
        }

        @Override // p1.j.h
        public void f(j jVar) {
        }

        @Override // p1.j.h
        public void i(j jVar) {
            this.f38091a.setTag(R$id.transition_clip, this.f38091a.getClipBounds());
            this.f38091a.setClipBounds(this.f38095e ? null : this.f38094d);
        }

        @Override // p1.j.h
        public void k(j jVar) {
            View view = this.f38091a;
            int i10 = R$id.transition_clip;
            Rect rect = (Rect) view.getTag(i10);
            this.f38091a.setTag(i10, null);
            this.f38091a.setClipBounds(rect);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (this.f38104n) {
                return;
            }
            Rect rect = null;
            if (z10) {
                if (!this.f38093c) {
                    rect = this.f38092b;
                }
            } else if (!this.f38095e) {
                rect = this.f38094d;
            }
            this.f38091a.setClipBounds(rect);
            if (z10) {
                C5038A.d(this.f38091a, this.f38096f, this.f38097g, this.f38098h, this.f38099i);
            } else {
                C5038A.d(this.f38091a, this.f38100j, this.f38101k, this.f38102l, this.f38103m);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            int iMax = Math.max(this.f38098h - this.f38096f, this.f38102l - this.f38100j);
            int iMax2 = Math.max(this.f38099i - this.f38097g, this.f38103m - this.f38101k);
            int i10 = z10 ? this.f38100j : this.f38096f;
            int i11 = z10 ? this.f38101k : this.f38097g;
            C5038A.d(this.f38091a, i10, i11, iMax + i10, iMax2 + i11);
            this.f38091a.setClipBounds(z10 ? this.f38094d : this.f38092b);
        }
    }

    /* renamed from: p1.b$h */
    public static class h extends q {

        /* renamed from: a, reason: collision with root package name */
        public boolean f38105a = false;

        /* renamed from: b, reason: collision with root package name */
        public final ViewGroup f38106b;

        public h(ViewGroup viewGroup) {
            this.f38106b = viewGroup;
        }

        @Override // p1.q, p1.j.h
        public void c(j jVar) {
            z.a(this.f38106b, false);
            this.f38105a = true;
        }

        @Override // p1.q, p1.j.h
        public void f(j jVar) {
            if (!this.f38105a) {
                z.a(this.f38106b, false);
            }
            jVar.g0(this);
        }

        @Override // p1.q, p1.j.h
        public void i(j jVar) {
            z.a(this.f38106b, false);
        }

        @Override // p1.q, p1.j.h
        public void k(j jVar) {
            z.a(this.f38106b, true);
        }
    }

    /* renamed from: p1.b$i */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public int f38107a;

        /* renamed from: b, reason: collision with root package name */
        public int f38108b;

        /* renamed from: c, reason: collision with root package name */
        public int f38109c;

        /* renamed from: d, reason: collision with root package name */
        public int f38110d;

        /* renamed from: e, reason: collision with root package name */
        public final View f38111e;

        /* renamed from: f, reason: collision with root package name */
        public int f38112f;

        /* renamed from: g, reason: collision with root package name */
        public int f38113g;

        public i(View view) {
            this.f38111e = view;
        }

        public void a(PointF pointF) {
            this.f38109c = Math.round(pointF.x);
            this.f38110d = Math.round(pointF.y);
            int i10 = this.f38113g + 1;
            this.f38113g = i10;
            if (this.f38112f == i10) {
                b();
            }
        }

        public final void b() {
            C5038A.d(this.f38111e, this.f38107a, this.f38108b, this.f38109c, this.f38110d);
            this.f38112f = 0;
            this.f38113g = 0;
        }

        public void c(PointF pointF) {
            this.f38107a = Math.round(pointF.x);
            this.f38108b = Math.round(pointF.y);
            int i10 = this.f38112f + 1;
            this.f38112f = i10;
            if (i10 == this.f38113g) {
                b();
            }
        }
    }

    @Override // p1.j
    public String[] P() {
        return f38081Q;
    }

    @Override // p1.j
    public boolean S() {
        return true;
    }

    @Override // p1.j
    public void k(w wVar) {
        u0(wVar);
    }

    @Override // p1.j
    public void p(w wVar) {
        Rect rect;
        u0(wVar);
        if (!this.f38088P || (rect = (Rect) wVar.f38222b.getTag(R$id.transition_clip)) == null) {
            return;
        }
        wVar.f38221a.put("android:changeBounds:clip", rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p1.j
    public Animator t(ViewGroup viewGroup, w wVar, w wVar2) {
        int i10;
        int i11;
        int i12;
        int i13;
        ObjectAnimator objectAnimatorA;
        int i14;
        Rect rect;
        ObjectAnimator objectAnimatorOfObject;
        Animator animatorC;
        if (wVar == null || wVar2 == null) {
            return null;
        }
        Map<String, Object> map = wVar.f38221a;
        Map<String, Object> map2 = wVar2.f38221a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = wVar2.f38222b;
        Rect rect2 = (Rect) wVar.f38221a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) wVar2.f38221a.get("android:changeBounds:bounds");
        int i15 = rect2.left;
        int i16 = rect3.left;
        int i17 = rect2.top;
        int i18 = rect3.top;
        int i19 = rect2.right;
        int i20 = rect3.right;
        int i21 = rect2.bottom;
        int i22 = rect3.bottom;
        int i23 = i19 - i15;
        int i24 = i21 - i17;
        int i25 = i20 - i16;
        int i26 = i22 - i18;
        Rect rect4 = (Rect) wVar.f38221a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) wVar2.f38221a.get("android:changeBounds:clip");
        if ((i23 == 0 || i24 == 0) && (i25 == 0 || i26 == 0)) {
            i10 = 0;
        } else {
            i10 = (i15 == i16 && i17 == i18) ? 0 : 1;
            if (i19 != i20 || i21 != i22) {
                i10++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i10++;
        }
        int i27 = i10;
        if (i27 <= 0) {
            return null;
        }
        if (this.f38088P) {
            C5038A.d(view, i15, i17, Math.max(i23, i25) + i15, i17 + Math.max(i24, i26));
            if (i15 == i16 && i17 == i18) {
                objectAnimatorA = null;
                i11 = i22;
                i13 = i16;
                i12 = i20;
            } else {
                i11 = i22;
                i12 = i20;
                i13 = i16;
                objectAnimatorA = C5045f.a(view, f38086V, D().a(i15, i17, i16, i18));
            }
            boolean z10 = rect4 == null;
            if (z10) {
                i14 = 0;
                rect = new Rect(0, 0, i23, i24);
            } else {
                i14 = 0;
                rect = rect4;
            }
            int i28 = rect5 == null ? 1 : i14;
            Rect rect6 = i28 != 0 ? new Rect(i14, i14, i25, i26) : rect5;
            if (rect.equals(rect6)) {
                objectAnimatorOfObject = null;
            } else {
                view.setClipBounds(rect);
                objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", f38087W, rect, rect6);
                g gVar = new g(view, rect, z10, rect6, i28, i15, i17, i19, i21, i13, i18, i12, i11);
                objectAnimatorOfObject.addListener(gVar);
                f(gVar);
            }
            animatorC = v.c(objectAnimatorA, objectAnimatorOfObject);
        } else {
            C5038A.d(view, i15, i17, i19, i21);
            if (i27 != 2) {
                animatorC = (i15 == i16 && i17 == i18) ? C5045f.a(view, f38084T, D().a(i19, i21, i20, i22)) : C5045f.a(view, f38085U, D().a(i15, i17, i16, i18));
            } else if (i23 == i25 && i24 == i26) {
                animatorC = C5045f.a(view, f38086V, D().a(i15, i17, i16, i18));
            } else {
                i iVar = new i(view);
                ObjectAnimator objectAnimatorA2 = C5045f.a(iVar, f38082R, D().a(i15, i17, i16, i18));
                ObjectAnimator objectAnimatorA3 = C5045f.a(iVar, f38083S, D().a(i19, i21, i20, i22));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new f(iVar));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            z.a(viewGroup4, true);
            F().f(new h(viewGroup4));
        }
        return animatorC;
    }

    public final void u0(w wVar) {
        View view = wVar.f38222b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        wVar.f38221a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        wVar.f38221a.put("android:changeBounds:parent", wVar.f38222b.getParent());
        if (this.f38088P) {
            wVar.f38221a.put("android:changeBounds:clip", view.getClipBounds());
        }
    }
}
