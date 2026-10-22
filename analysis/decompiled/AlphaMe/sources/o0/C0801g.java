package o0;

import android.animation.ObjectAnimator;
import android.view.View;
import androidx.appcompat.widget.T0;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.HashMap;

/* renamed from: o0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0801g extends s {

    /* renamed from: C, reason: collision with root package name */
    public static final String[] f13711C = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: B, reason: collision with root package name */
    public int f13712B;

    public C0801g(int i4) {
        this.f13712B = i4;
    }

    public static void K(C0785A c0785a) {
        int visibility = c0785a.f13674b.getVisibility();
        HashMap map = c0785a.f13673a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = c0785a.f13674b;
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static float M(C0785A c0785a, float f4) {
        Float f5;
        return (c0785a == null || (f5 = (Float) c0785a.f13673a.get("android:fade:transitionAlpha")) == null) ? f4 : f5.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static o0.C0794J N(o0.C0785A r8, o0.C0785A r9) {
        /*
            o0.J r0 = new o0.J
            r0.<init>()
            r1 = 0
            r0.f13688a = r1
            r0.f13689b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f13673a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f13690c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f13692e = r6
            goto L33
        L2f:
            r0.f13690c = r3
            r0.f13692e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f13673a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f13691d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f13693f = r2
            goto L56
        L52:
            r0.f13691d = r3
            r0.f13693f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f13690c
            int r9 = r0.f13691d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f13692e
            android.view.ViewGroup r4 = r0.f13693f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f13689b = r1
            r0.f13688a = r2
            goto L9f
        L71:
            if (r9 != 0) goto L9f
            r0.f13689b = r2
            r0.f13688a = r2
            goto L9f
        L78:
            android.view.ViewGroup r8 = r0.f13693f
            if (r8 != 0) goto L81
            r0.f13689b = r1
            r0.f13688a = r2
            goto L9f
        L81:
            android.view.ViewGroup r8 = r0.f13692e
            if (r8 != 0) goto L9f
            r0.f13689b = r2
            r0.f13688a = r2
            goto L9f
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f13691d
            if (r8 != 0) goto L95
            r0.f13689b = r2
            r0.f13688a = r2
            goto L9f
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f13690c
            if (r8 != 0) goto L9f
            r0.f13689b = r1
            r0.f13688a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C0801g.N(o0.A, o0.A):o0.J");
    }

    public final ObjectAnimator L(View view, float f4, float f5) {
        if (f4 == f5) {
            return null;
        }
        T0 t02 = AbstractC0787C.f13676a;
        view.setTransitionAlpha(f4);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, AbstractC0787C.f13676a, f5);
        C0800f c0800f = new C0800f(view);
        objectAnimatorOfFloat.addListener(c0800f);
        o().a(c0800f);
        return objectAnimatorOfFloat;
    }

    @Override // o0.s
    public final void d(C0785A c0785a) {
        K(c0785a);
    }

    @Override // o0.s
    public final void g(C0785A c0785a) {
        K(c0785a);
        View view = c0785a.f13674b;
        Float fValueOf = (Float) view.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            if (view.getVisibility() == 0) {
                T0 t02 = AbstractC0787C.f13676a;
                fValueOf = Float.valueOf(view.getTransitionAlpha());
            } else {
                fValueOf = Float.valueOf(Property.DEFAULT_FLOAT_VALUE);
            }
        }
        c0785a.f13673a.put("android:fade:transitionAlpha", fValueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (N(n(r3, false), r(r3, false)).f13688a != false) goto L96;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01dc  */
    @Override // o0.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator k(android.view.ViewGroup r21, o0.C0785A r22, o0.C0785A r23) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C0801g.k(android.view.ViewGroup, o0.A, o0.A):android.animation.Animator");
    }

    @Override // o0.s
    public final /* bridge */ /* synthetic */ String[] q() {
        return f13711C;
    }

    @Override // o0.s
    public final boolean t(C0785A c0785a, C0785A c0785a2) {
        if (c0785a == null && c0785a2 == null) {
            return false;
        }
        if (c0785a != null && c0785a2 != null && c0785a2.f13673a.containsKey("android:visibility:visibility") != c0785a.f13673a.containsKey("android:visibility:visibility")) {
            return false;
        }
        C0794J c0794jN = N(c0785a, c0785a2);
        if (c0794jN.f13688a) {
            return c0794jN.f13690c == 0 || c0794jN.f13691d == 0;
        }
        return false;
    }
}
