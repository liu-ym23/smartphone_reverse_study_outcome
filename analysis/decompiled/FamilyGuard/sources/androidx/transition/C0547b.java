package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.k;
import java.util.Map;

/* renamed from: androidx.transition.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0547b extends k {

    /* renamed from: Q, reason: collision with root package name */
    private static final String[] f11363Q = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: R, reason: collision with root package name */
    private static final Property<i, PointF> f11364R = new a(PointF.class, "topLeft");

    /* renamed from: S, reason: collision with root package name */
    private static final Property<i, PointF> f11365S = new C0147b(PointF.class, "bottomRight");

    /* renamed from: T, reason: collision with root package name */
    private static final Property<View, PointF> f11366T = new c(PointF.class, "bottomRight");

    /* renamed from: U, reason: collision with root package name */
    private static final Property<View, PointF> f11367U = new d(PointF.class, "topLeft");

    /* renamed from: V, reason: collision with root package name */
    private static final Property<View, PointF> f11368V = new e(PointF.class, "position");

    /* renamed from: W, reason: collision with root package name */
    private static final androidx.transition.i f11369W = new androidx.transition.i();

    /* renamed from: M, reason: collision with root package name */
    private boolean f11370M = false;

    /* renamed from: androidx.transition.b$a */
    class a extends Property<i, PointF> {
        a(Class cls, String str) {
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

    /* renamed from: androidx.transition.b$b, reason: collision with other inner class name */
    class C0147b extends Property<i, PointF> {
        C0147b(Class cls, String str) {
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

    /* renamed from: androidx.transition.b$c */
    class c extends Property<View, PointF> {
        c(Class cls, String str) {
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
            y.d(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* renamed from: androidx.transition.b$d */
    class d extends Property<View, PointF> {
        d(Class cls, String str) {
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
            y.d(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: androidx.transition.b$e */
    class e extends Property<View, PointF> {
        e(Class cls, String str) {
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
            y.d(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* renamed from: androidx.transition.b$f */
    class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f11371a;
        private final i mViewBounds;

        f(i iVar) {
            this.f11371a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* renamed from: androidx.transition.b$g */
    private static class g extends AnimatorListenerAdapter implements k.f {

        /* renamed from: a, reason: collision with root package name */
        private final View f11373a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f11374b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f11375c;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f11376d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f11377e;

        /* renamed from: f, reason: collision with root package name */
        private final int f11378f;

        /* renamed from: g, reason: collision with root package name */
        private final int f11379g;

        /* renamed from: h, reason: collision with root package name */
        private final int f11380h;

        /* renamed from: i, reason: collision with root package name */
        private final int f11381i;

        /* renamed from: j, reason: collision with root package name */
        private final int f11382j;

        /* renamed from: k, reason: collision with root package name */
        private final int f11383k;

        /* renamed from: l, reason: collision with root package name */
        private final int f11384l;

        /* renamed from: m, reason: collision with root package name */
        private final int f11385m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f11386n;

        g(View view, Rect rect, boolean z5, Rect rect2, boolean z6, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f11373a = view;
            this.f11374b = rect;
            this.f11375c = z5;
            this.f11376d = rect2;
            this.f11377e = z6;
            this.f11378f = i5;
            this.f11379g = i6;
            this.f11380h = i7;
            this.f11381i = i8;
            this.f11382j = i9;
            this.f11383k = i10;
            this.f11384l = i11;
            this.f11385m = i12;
        }

        @Override // androidx.transition.k.f
        public void a(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void b(k kVar) {
            this.f11373a.setTag(androidx.transition.h.f11418b, this.f11373a.getClipBounds());
            this.f11373a.setClipBounds(this.f11377e ? null : this.f11376d);
        }

        @Override // androidx.transition.k.f
        public void d(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void e(k kVar) {
            this.f11386n = true;
        }

        @Override // androidx.transition.k.f
        public void g(k kVar) {
            View view = this.f11373a;
            int i5 = androidx.transition.h.f11418b;
            Rect rect = (Rect) view.getTag(i5);
            this.f11373a.setTag(i5, null);
            this.f11373a.setClipBounds(rect);
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
        public void onAnimationEnd(Animator animator, boolean z5) {
            if (this.f11386n) {
                return;
            }
            Rect rect = null;
            if (z5) {
                if (!this.f11375c) {
                    rect = this.f11374b;
                }
            } else if (!this.f11377e) {
                rect = this.f11376d;
            }
            this.f11373a.setClipBounds(rect);
            if (z5) {
                y.d(this.f11373a, this.f11378f, this.f11379g, this.f11380h, this.f11381i);
            } else {
                y.d(this.f11373a, this.f11382j, this.f11383k, this.f11384l, this.f11385m);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z5) {
            int iMax = Math.max(this.f11380h - this.f11378f, this.f11384l - this.f11382j);
            int iMax2 = Math.max(this.f11381i - this.f11379g, this.f11385m - this.f11383k);
            int i5 = z5 ? this.f11382j : this.f11378f;
            int i6 = z5 ? this.f11383k : this.f11379g;
            y.d(this.f11373a, i5, i6, iMax + i5, iMax2 + i6);
            this.f11373a.setClipBounds(z5 ? this.f11376d : this.f11374b);
        }
    }

    /* renamed from: androidx.transition.b$h */
    private static class h extends q {

        /* renamed from: a, reason: collision with root package name */
        boolean f11387a = false;

        /* renamed from: b, reason: collision with root package name */
        final ViewGroup f11388b;

        h(ViewGroup viewGroup) {
            this.f11388b = viewGroup;
        }

        @Override // androidx.transition.q, androidx.transition.k.f
        public void b(k kVar) {
            x.a(this.f11388b, false);
        }

        @Override // androidx.transition.k.f
        public void d(k kVar) {
            if (!this.f11387a) {
                x.a(this.f11388b, false);
            }
            kVar.X(this);
        }

        @Override // androidx.transition.q, androidx.transition.k.f
        public void e(k kVar) {
            x.a(this.f11388b, false);
            this.f11387a = true;
        }

        @Override // androidx.transition.q, androidx.transition.k.f
        public void g(k kVar) {
            x.a(this.f11388b, true);
        }
    }

    /* renamed from: androidx.transition.b$i */
    private static class i {

        /* renamed from: a, reason: collision with root package name */
        private int f11389a;

        /* renamed from: b, reason: collision with root package name */
        private int f11390b;

        /* renamed from: c, reason: collision with root package name */
        private int f11391c;

        /* renamed from: d, reason: collision with root package name */
        private int f11392d;

        /* renamed from: e, reason: collision with root package name */
        private final View f11393e;

        /* renamed from: f, reason: collision with root package name */
        private int f11394f;

        /* renamed from: g, reason: collision with root package name */
        private int f11395g;

        i(View view) {
            this.f11393e = view;
        }

        private void b() {
            y.d(this.f11393e, this.f11389a, this.f11390b, this.f11391c, this.f11392d);
            this.f11394f = 0;
            this.f11395g = 0;
        }

        void a(PointF pointF) {
            this.f11391c = Math.round(pointF.x);
            this.f11392d = Math.round(pointF.y);
            int i5 = this.f11395g + 1;
            this.f11395g = i5;
            if (this.f11394f == i5) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f11389a = Math.round(pointF.x);
            this.f11390b = Math.round(pointF.y);
            int i5 = this.f11394f + 1;
            this.f11394f = i5;
            if (i5 == this.f11395g) {
                b();
            }
        }
    }

    private void k0(v vVar) {
        View view = vVar.f11493b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        vVar.f11492a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        vVar.f11492a.put("android:changeBounds:parent", vVar.f11493b.getParent());
        if (this.f11370M) {
            vVar.f11492a.put("android:changeBounds:clip", view.getClipBounds());
        }
    }

    @Override // androidx.transition.k
    public String[] J() {
        return f11363Q;
    }

    @Override // androidx.transition.k
    public void i(v vVar) {
        k0(vVar);
    }

    @Override // androidx.transition.k
    public void l(v vVar) {
        Rect rect;
        k0(vVar);
        if (!this.f11370M || (rect = (Rect) vVar.f11493b.getTag(androidx.transition.h.f11418b)) == null) {
            return;
        }
        vVar.f11492a.put("android:changeBounds:clip", rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.k
    public Animator s(ViewGroup viewGroup, v vVar, v vVar2) {
        int i5;
        int i6;
        int i7;
        int i8;
        ObjectAnimator objectAnimatorA;
        int i9;
        Rect rect;
        ObjectAnimator objectAnimatorOfObject;
        Animator animatorC;
        if (vVar == null || vVar2 == null) {
            return null;
        }
        Map<String, Object> map = vVar.f11492a;
        Map<String, Object> map2 = vVar2.f11492a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = vVar2.f11493b;
        Rect rect2 = (Rect) vVar.f11492a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) vVar2.f11492a.get("android:changeBounds:bounds");
        int i10 = rect2.left;
        int i11 = rect3.left;
        int i12 = rect2.top;
        int i13 = rect3.top;
        int i14 = rect2.right;
        int i15 = rect3.right;
        int i16 = rect2.bottom;
        int i17 = rect3.bottom;
        int i18 = i14 - i10;
        int i19 = i16 - i12;
        int i20 = i15 - i11;
        int i21 = i17 - i13;
        Rect rect4 = (Rect) vVar.f11492a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) vVar2.f11492a.get("android:changeBounds:clip");
        if ((i18 == 0 || i19 == 0) && (i20 == 0 || i21 == 0)) {
            i5 = 0;
        } else {
            i5 = (i10 == i11 && i12 == i13) ? 0 : 1;
            if (i14 != i15 || i16 != i17) {
                i5++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i5++;
        }
        int i22 = i5;
        if (i22 <= 0) {
            return null;
        }
        if (this.f11370M) {
            y.d(view, i10, i12, Math.max(i18, i20) + i10, i12 + Math.max(i19, i21));
            if (i10 == i11 && i12 == i13) {
                objectAnimatorA = null;
                i6 = i17;
                i8 = i11;
                i7 = i15;
            } else {
                i6 = i17;
                i7 = i15;
                i8 = i11;
                objectAnimatorA = androidx.transition.f.a(view, f11368V, A().a(i10, i12, i11, i13));
            }
            boolean z5 = rect4 == null;
            if (z5) {
                i9 = 0;
                rect = new Rect(0, 0, i18, i19);
            } else {
                i9 = 0;
                rect = rect4;
            }
            int i23 = rect5 == null ? 1 : i9;
            Rect rect6 = i23 != 0 ? new Rect(i9, i9, i20, i21) : rect5;
            if (rect.equals(rect6)) {
                objectAnimatorOfObject = null;
            } else {
                view.setClipBounds(rect);
                objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", f11369W, rect, rect6);
                g gVar = new g(view, rect, z5, rect6, i23, i10, i12, i14, i16, i8, i13, i7, i6);
                objectAnimatorOfObject.addListener(gVar);
                b(gVar);
            }
            animatorC = u.c(objectAnimatorA, objectAnimatorOfObject);
        } else {
            y.d(view, i10, i12, i14, i16);
            if (i22 != 2) {
                animatorC = (i10 == i11 && i12 == i13) ? androidx.transition.f.a(view, f11366T, A().a(i14, i16, i15, i17)) : androidx.transition.f.a(view, f11367U, A().a(i10, i12, i11, i13));
            } else if (i18 == i20 && i19 == i21) {
                animatorC = androidx.transition.f.a(view, f11368V, A().a(i10, i12, i11, i13));
            } else {
                i iVar = new i(view);
                ObjectAnimator objectAnimatorA2 = androidx.transition.f.a(iVar, f11364R, A().a(i10, i12, i11, i13));
                ObjectAnimator objectAnimatorA3 = androidx.transition.f.a(iVar, f11365S, A().a(i14, i16, i15, i17));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new f(iVar));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            x.a(viewGroup4, true);
            C().b(new h(viewGroup4));
        }
        return animatorC;
    }
}
