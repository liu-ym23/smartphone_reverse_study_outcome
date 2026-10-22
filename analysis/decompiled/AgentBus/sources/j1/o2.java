package j1;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class o2 {

    /* renamed from: a, reason: collision with root package name */
    public static final ViewGroup.LayoutParams f5293a = new ViewGroup.LayoutParams(-2, -2);

    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.Collection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final j1.n2 a(j1.b r6, b0.u r7, j0.d r8) {
        /*
            java.util.concurrent.atomic.AtomicBoolean r0 = j1.m1.f5252a
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            r3 = 0
            if (r0 == 0) goto L40
            r0 = 6
            ka.g r0 = a.a.b(r2, r0, r3)
            c7.o r2 = j1.s0.f5312r
            java.lang.Object r2 = r2.getValue()
            g7.l r2 = (g7.l) r2
            na.d r2 = ia.d0.b(r2)
            b0.f2 r4 = new b0.f2
            r5 = 6
            r4.<init>(r0, r3, r5)
            r5 = 3
            ia.d0.s(r2, r3, r3, r4, r5)
            c1.w r2 = new c1.w
            r4 = 11
            r2.<init>(r4, r0)
            java.lang.Object r0 = l0.m.f5774c
            monitor-enter(r0)
            java.lang.Object r4 = l0.m.f5780i     // Catch: java.lang.Throwable -> L3d
            java.util.ArrayList r2 = d7.r.d1(r4, r2)     // Catch: java.lang.Throwable -> L3d
            l0.m.f5780i = r2     // Catch: java.lang.Throwable -> L3d
            monitor-exit(r0)
            l0.m.a()
            goto L40
        L3d:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        L40:
            int r0 = r6.getChildCount()
            if (r0 <= 0) goto L53
            android.view.View r0 = r6.getChildAt(r1)
            boolean r1 = r0 instanceof j1.y
            if (r1 == 0) goto L51
            j1.y r0 = (j1.y) r0
            goto L57
        L51:
            r0 = r3
            goto L57
        L53:
            r6.removeAllViews()
            goto L51
        L57:
            if (r0 != 0) goto L70
            j1.y r0 = new j1.y
            android.content.Context r1 = r6.getContext()
            r2 = r7
            b0.j2 r2 = (b0.j2) r2
            g7.l r2 = r2.f1227v
            r0.<init>(r1, r2)
            android.view.View r1 = r0.getView()
            android.view.ViewGroup$LayoutParams r2 = j1.o2.f5293a
            r6.addView(r1, r2)
        L70:
            android.view.View r6 = r0.getView()
            r1 = 2131034203(0x7f05005b, float:1.7678917E38)
            java.lang.Object r6 = r6.getTag(r1)
            boolean r2 = r6 instanceof j1.n2
            if (r2 == 0) goto L82
            r3 = r6
            j1.n2 r3 = (j1.n2) r3
        L82:
            if (r3 != 0) goto L9e
            j1.n2 r3 = new j1.n2
            i5.l r6 = new i5.l
            i1.f0 r2 = r0.getRoot()
            r6.<init>(r2)
            b0.x r2 = new b0.x
            r2.<init>(r7, r6)
            r3.<init>(r0, r2)
            android.view.View r6 = r0.getView()
            r6.setTag(r1, r3)
        L9e:
            r3.f(r8)
            g7.l r6 = r0.getCoroutineContext()
            b0.j2 r7 = (b0.j2) r7
            g7.l r8 = r7.f1227v
            boolean r6 = q7.k.a(r6, r8)
            if (r6 != 0) goto Lb4
            g7.l r6 = r7.f1227v
            r0.setCoroutineContext(r6)
        Lb4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.o2.a(j1.b, b0.u, j0.d):j1.n2");
    }
}
