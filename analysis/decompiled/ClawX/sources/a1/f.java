package a1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends o {
    public static final String[] B = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final b C = new b(0, PointF.class, "topLeft");
    public static final b D = new b(1, PointF.class, "bottomRight");
    public static final b E = new b(2, PointF.class, "bottomRight");
    public static final b F = new b(3, PointF.class, "topLeft");
    public static final b G = new b(4, PointF.class, "position");

    public static void I(v vVar) {
        View view = vVar.f72b;
        HashMap map = vVar.f71a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", view.getParent());
    }

    @Override // a1.o
    public final void d(v vVar) {
        I(vVar);
    }

    @Override // a1.o
    public final void g(v vVar) {
        I(vVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a1.o
    public final Animator k(ViewGroup viewGroup, v vVar, v vVar2) {
        int i8;
        f fVar;
        ObjectAnimator objectAnimatorA;
        if (vVar == null) {
            return null;
        }
        HashMap map = vVar.f71a;
        if (vVar2 == null) {
            return null;
        }
        HashMap map2 = vVar2.f71a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = vVar2.f72b;
        Rect rect = (Rect) map.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
        int i9 = rect.left;
        int i10 = rect2.left;
        int i11 = rect.top;
        int i12 = rect2.top;
        int i13 = rect.right;
        int i14 = rect2.right;
        int i15 = rect.bottom;
        int i16 = rect2.bottom;
        int i17 = i13 - i9;
        int i18 = i15 - i11;
        int i19 = i14 - i10;
        int i20 = i16 - i12;
        Rect rect3 = (Rect) map.get("android:changeBounds:clip");
        Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
        if ((i17 == 0 || i18 == 0) && (i19 == 0 || i20 == 0)) {
            i8 = 0;
        } else {
            i8 = (i9 == i10 && i11 == i12) ? 0 : 1;
            if (i13 != i14 || i15 != i16) {
                i8++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i8++;
        }
        int i21 = i8;
        if (i21 <= 0) {
            return null;
        }
        b bVar = y.f78a;
        view.setLeftTopRightBottom(i9, i11, i13, i15);
        if (i21 != 2) {
            fVar = this;
            if (i9 == i10 && i11 == i12) {
                fVar.f61w.getClass();
                objectAnimatorA = i.a(view, E, t1.f.i(i13, i15, i14, i16));
            } else {
                fVar.f61w.getClass();
                objectAnimatorA = i.a(view, F, t1.f.i(i9, i11, i10, i12));
            }
        } else if (i17 == i19 && i18 == i20) {
            fVar = this;
            fVar.f61w.getClass();
            objectAnimatorA = i.a(view, G, t1.f.i(i9, i11, i10, i12));
        } else {
            fVar = this;
            e eVar = new e(view);
            fVar.f61w.getClass();
            ObjectAnimator objectAnimatorA2 = i.a(eVar, C, t1.f.i(i9, i11, i10, i12));
            fVar.f61w.getClass();
            ObjectAnimator objectAnimatorA3 = i.a(eVar, D, t1.f.i(i13, i15, i14, i16));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
            animatorSet.addListener(new c(eVar));
            objectAnimatorA = animatorSet;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            x.b(viewGroup4, true);
            fVar.o().a(new d(viewGroup4));
        }
        return objectAnimatorA;
    }

    @Override // a1.o
    public final String[] q() {
        return B;
    }
}
