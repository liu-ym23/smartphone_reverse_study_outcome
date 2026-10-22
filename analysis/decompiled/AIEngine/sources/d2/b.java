package d2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import d2.r;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends i {
    public static final String[] E = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final a F = new a(PointF.class, "topLeft");
    public static final C0072b G = new C0072b(PointF.class, "bottomRight");
    public static final c H = new c(PointF.class, "bottomRight");
    public static final d I = new d(PointF.class, "topLeft");
    public static final e J = new e(PointF.class, "position");

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends Property<h, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(h hVar) {
            return null;
        }

        @Override // android.util.Property
        public final void set(h hVar, PointF pointF) {
            h hVar2 = hVar;
            PointF pointF2 = pointF;
            hVar2.getClass();
            hVar2.f8265a = Math.round(pointF2.x);
            int iRound = Math.round(pointF2.y);
            hVar2.f8266b = iRound;
            int i10 = hVar2.f8270f + 1;
            hVar2.f8270f = i10;
            if (i10 == hVar2.f8271g) {
                View view = hVar2.f8269e;
                int i11 = hVar2.f8265a;
                int i12 = hVar2.f8267c;
                int i13 = hVar2.f8268d;
                r.a aVar = r.f8328a;
                view.setLeftTopRightBottom(i11, iRound, i12, i13);
                hVar2.f8270f = 0;
                hVar2.f8271g = 0;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: d2.b$b, reason: collision with other inner class name */
    public class C0072b extends Property<h, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(h hVar) {
            return null;
        }

        @Override // android.util.Property
        public final void set(h hVar, PointF pointF) {
            h hVar2 = hVar;
            PointF pointF2 = pointF;
            hVar2.getClass();
            hVar2.f8267c = Math.round(pointF2.x);
            int iRound = Math.round(pointF2.y);
            hVar2.f8268d = iRound;
            int i10 = hVar2.f8271g + 1;
            hVar2.f8271g = i10;
            if (hVar2.f8270f == i10) {
                View view = hVar2.f8269e;
                int i11 = hVar2.f8265a;
                int i12 = hVar2.f8266b;
                int i13 = hVar2.f8267c;
                r.a aVar = r.f8328a;
                view.setLeftTopRightBottom(i11, i12, i13, iRound);
                hVar2.f8270f = 0;
                hVar2.f8271g = 0;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends Property<View, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int left = view2.getLeft();
            int top = view2.getTop();
            int iRound = Math.round(pointF2.x);
            int iRound2 = Math.round(pointF2.y);
            r.a aVar = r.f8328a;
            view2.setLeftTopRightBottom(left, top, iRound, iRound2);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends Property<View, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int iRound = Math.round(pointF2.x);
            int iRound2 = Math.round(pointF2.y);
            int right = view2.getRight();
            int bottom = view2.getBottom();
            r.a aVar = r.f8328a;
            view2.setLeftTopRightBottom(iRound, iRound2, right, bottom);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e extends Property<View, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int iRound = Math.round(pointF2.x);
            int iRound2 = Math.round(pointF2.y);
            int width = view2.getWidth() + iRound;
            int height = view2.getHeight() + iRound2;
            r.a aVar = r.f8328a;
            view2.setLeftTopRightBottom(iRound, iRound2, width, height);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f extends AnimatorListenerAdapter {
        private final h mViewBounds;

        public f(h hVar) {
            this.mViewBounds = hVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class g extends l {

        /* renamed from: a, reason: collision with root package name */
        public boolean f8263a = false;

        /* renamed from: b, reason: collision with root package name */
        public final ViewGroup f8264b;

        public g(ViewGroup viewGroup) {
            this.f8264b = viewGroup;
        }

        @Override // d2.l, d2.i.d
        public final void b() {
            q.b(this.f8264b, false);
        }

        @Override // d2.i.d
        public final void c(i iVar) {
            if (!this.f8263a) {
                q.b(this.f8264b, false);
            }
            iVar.x(this);
        }

        @Override // d2.l, d2.i.d
        public final void d() {
            q.b(this.f8264b, true);
        }

        @Override // d2.l, d2.i.d
        public final void e(i iVar) {
            q.b(this.f8264b, false);
            this.f8263a = true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public int f8265a;

        /* renamed from: b, reason: collision with root package name */
        public int f8266b;

        /* renamed from: c, reason: collision with root package name */
        public int f8267c;

        /* renamed from: d, reason: collision with root package name */
        public int f8268d;

        /* renamed from: e, reason: collision with root package name */
        public final View f8269e;

        /* renamed from: f, reason: collision with root package name */
        public int f8270f;

        /* renamed from: g, reason: collision with root package name */
        public int f8271g;

        public h(View view) {
            this.f8269e = view;
        }
    }

    public static void J(p pVar) {
        View view = pVar.f8326b;
        HashMap map = pVar.f8325a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", view.getParent());
    }

    @Override // d2.i
    public final void e(p pVar) {
        J(pVar);
    }

    @Override // d2.i
    public final void h(p pVar) {
        J(pVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d2.i
    public final Animator l(ViewGroup viewGroup, p pVar, p pVar2) {
        int i10;
        b bVar;
        ObjectAnimator objectAnimatorA;
        if (pVar == null) {
            return null;
        }
        HashMap map = pVar.f8325a;
        if (pVar2 == null) {
            return null;
        }
        HashMap map2 = pVar2.f8325a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = pVar2.f8326b;
        Rect rect = (Rect) map.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
        int i11 = rect.left;
        int i12 = rect2.left;
        int i13 = rect.top;
        int i14 = rect2.top;
        int i15 = rect.right;
        int i16 = rect2.right;
        int i17 = rect.bottom;
        int i18 = rect2.bottom;
        int i19 = i15 - i11;
        int i20 = i17 - i13;
        int i21 = i16 - i12;
        int i22 = i18 - i14;
        Rect rect3 = (Rect) map.get("android:changeBounds:clip");
        Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
        if ((i19 == 0 || i20 == 0) && (i21 == 0 || i22 == 0)) {
            i10 = 0;
        } else {
            i10 = (i11 == i12 && i13 == i14) ? 0 : 1;
            if (i15 != i16 || i17 != i18) {
                i10++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i10++;
        }
        int i23 = i10;
        if (i23 <= 0) {
            return null;
        }
        r.a aVar = r.f8328a;
        view.setLeftTopRightBottom(i11, i13, i15, i17);
        if (i23 != 2) {
            bVar = this;
            objectAnimatorA = (i11 == i12 && i13 == i14) ? d2.g.a(view, H, bVar.z.d(i15, i17, i16, i18)) : d2.g.a(view, I, bVar.z.d(i11, i13, i12, i14));
        } else if (i19 == i21 && i20 == i22) {
            bVar = this;
            objectAnimatorA = d2.g.a(view, J, bVar.z.d(i11, i13, i12, i14));
        } else {
            bVar = this;
            h hVar = new h(view);
            ObjectAnimator objectAnimatorA2 = d2.g.a(hVar, F, bVar.z.d(i11, i13, i12, i14));
            ObjectAnimator objectAnimatorA3 = d2.g.a(hVar, G, bVar.z.d(i15, i17, i16, i18));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
            animatorSet.addListener(new f(hVar));
            objectAnimatorA = animatorSet;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            q.b(viewGroup4, true);
            bVar.p().b(new g(viewGroup4));
        }
        return objectAnimatorA;
    }

    @Override // d2.i
    public final String[] r() {
        return E;
    }
}
