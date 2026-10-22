package a1;

import android.animation.ObjectAnimator;
import android.view.View;
import com.stepos.stepclaw.R;
import java.util.HashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends o {
    public static final String[] C = {"android:visibility:visibility", "android:visibility:parent"};
    public final int B;

    public h(int i8) {
        this();
        this.B = i8;
    }

    public static void I(v vVar) {
        View view = vVar.f72b;
        int visibility = view.getVisibility();
        HashMap map = vVar.f71a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static float K(v vVar, float f3) {
        Float f7;
        return (vVar == null || (f7 = (Float) vVar.f71a.get("android:fade:transitionAlpha")) == null) ? f3 : f7.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a1.d0 L(a1.v r8, a1.v r9) {
        /*
            a1.d0 r0 = new a1.d0
            r0.<init>()
            r1 = 0
            r0.f13a = r1
            r0.f14b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f71a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f15c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f16e = r6
            goto L33
        L2f:
            r0.f15c = r3
            r0.f16e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f71a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f17f = r2
            goto L56
        L52:
            r0.d = r3
            r0.f17f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f15c
            int r9 = r0.d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f16e
            android.view.ViewGroup r4 = r0.f17f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f14b = r1
            r0.f13a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.f14b = r2
            r0.f13a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f17f
            if (r8 != 0) goto L81
            r0.f14b = r1
            r0.f13a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.f16e
            if (r8 != 0) goto L9f
            r0.f14b = r2
            r0.f13a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.d
            if (r8 != 0) goto L95
            r0.f14b = r2
            r0.f13a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f15c
            if (r8 != 0) goto L9f
            r0.f14b = r1
            r0.f13a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.h.L(a1.v, a1.v):a1.d0");
    }

    public final ObjectAnimator J(View view, float f3, float f7) {
        if (f3 == f7) {
            return null;
        }
        b bVar = y.f78a;
        view.setTransitionAlpha(f3);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, y.f78a, f7);
        g gVar = new g(view);
        objectAnimatorOfFloat.addListener(gVar);
        o().a(gVar);
        return objectAnimatorOfFloat;
    }

    @Override // a1.o
    public final void d(v vVar) {
        I(vVar);
    }

    @Override // a1.o
    public final void g(v vVar) {
        I(vVar);
        View view = vVar.f72b;
        Float fValueOf = (Float) view.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            if (view.getVisibility() == 0) {
                b bVar = y.f78a;
                fValueOf = Float.valueOf(view.getTransitionAlpha());
            } else {
                fValueOf = Float.valueOf(0.0f);
            }
        }
        vVar.f71a.put("android:fade:transitionAlpha", fValueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        if (L(n(r3, false), r(r3, false)).f13a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ef  */
    @Override // a1.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator k(android.view.ViewGroup r24, a1.v r25, a1.v r26) {
        /*
            Method dump skipped, instructions count: 685
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.h.k(android.view.ViewGroup, a1.v, a1.v):android.animation.Animator");
    }

    @Override // a1.o
    public final String[] q() {
        return C;
    }

    @Override // a1.o
    public final boolean s(v vVar, v vVar2) {
        if (vVar == null && vVar2 == null) {
            return false;
        }
        if (vVar != null && vVar2 != null && vVar2.f71a.containsKey("android:visibility:visibility") != vVar.f71a.containsKey("android:visibility:visibility")) {
            return false;
        }
        d0 d0VarL = L(vVar, vVar2);
        if (d0VarL.f13a) {
            return d0VarL.f15c == 0 || d0VarL.d == 0;
        }
        return false;
    }

    public h() {
        this.B = 3;
    }
}
