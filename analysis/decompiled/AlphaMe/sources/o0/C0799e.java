package o0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.T0;
import com.stepos.alphame.suggest.AppSuggestStorable;
import java.util.HashMap;

/* renamed from: o0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0799e extends s {

    /* renamed from: B, reason: collision with root package name */
    public static final String[] f13703B = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: C, reason: collision with root package name */
    public static final T0 f13704C = new T0(PointF.class, "topLeft", 1);

    /* renamed from: D, reason: collision with root package name */
    public static final T0 f13705D = new T0(PointF.class, "bottomRight", 2);

    /* renamed from: E, reason: collision with root package name */
    public static final T0 f13706E = new T0(PointF.class, "bottomRight", 3);

    /* renamed from: F, reason: collision with root package name */
    public static final T0 f13707F = new T0(PointF.class, "topLeft", 4);

    /* renamed from: G, reason: collision with root package name */
    public static final T0 f13708G = new T0(PointF.class, AppSuggestStorable.COLUMN_POSITION, 5);

    public static void K(C0785A c0785a) {
        View view = c0785a.f13674b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap map = c0785a.f13673a;
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", c0785a.f13674b.getParent());
    }

    @Override // o0.s
    public final void d(C0785A c0785a) {
        K(c0785a);
    }

    @Override // o0.s
    public final void g(C0785A c0785a) {
        K(c0785a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // o0.s
    public final Animator k(ViewGroup viewGroup, C0785A c0785a, C0785A c0785a2) {
        int i4;
        ObjectAnimator objectAnimatorA;
        if (c0785a == null || c0785a2 == null) {
            return null;
        }
        HashMap map = c0785a.f13673a;
        HashMap map2 = c0785a2.f13673a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        Rect rect = (Rect) map.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
        int i5 = rect.left;
        int i6 = rect2.left;
        int i7 = rect.top;
        int i8 = rect2.top;
        int i9 = rect.right;
        int i10 = rect2.right;
        int i11 = rect.bottom;
        int i12 = rect2.bottom;
        int i13 = i9 - i5;
        int i14 = i11 - i7;
        int i15 = i10 - i6;
        int i16 = i12 - i8;
        Rect rect3 = (Rect) map.get("android:changeBounds:clip");
        Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
        if ((i13 == 0 || i14 == 0) && (i15 == 0 || i16 == 0)) {
            i4 = 0;
        } else {
            i4 = (i5 == i6 && i7 == i8) ? 0 : 1;
            if (i9 != i10 || i11 != i12) {
                i4++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i4++;
        }
        if (i4 <= 0) {
            return null;
        }
        T0 t02 = AbstractC0787C.f13676a;
        View view = c0785a2.f13674b;
        view.setLeftTopRightBottom(i5, i7, i9, i11);
        if (i4 == 2) {
            if (i13 == i15 && i14 == i16) {
                this.f13765w.getClass();
                objectAnimatorA = n.a(view, f13708G, E3.b.f(i5, i7, i6, i8));
            } else {
                C0798d c0798d = new C0798d(view);
                this.f13765w.getClass();
                ObjectAnimator objectAnimatorA2 = n.a(c0798d, f13704C, E3.b.f(i5, i7, i6, i8));
                this.f13765w.getClass();
                ObjectAnimator objectAnimatorA3 = n.a(c0798d, f13705D, E3.b.f(i9, i11, i10, i12));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new C0796b(c0798d));
                objectAnimatorA = animatorSet;
            }
        } else if (i5 == i6 && i7 == i8) {
            this.f13765w.getClass();
            objectAnimatorA = n.a(view, f13706E, E3.b.f(i9, i11, i10, i12));
        } else {
            this.f13765w.getClass();
            objectAnimatorA = n.a(view, f13707F, E3.b.f(i5, i7, i6, i8));
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            AbstractC0786B.b(viewGroup4, true);
            o().a(new C0797c(viewGroup4));
        }
        return objectAnimatorA;
    }

    @Override // o0.s
    public final String[] q() {
        return f13703B;
    }
}
