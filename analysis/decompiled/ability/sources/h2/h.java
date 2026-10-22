package h2;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f4560a;
    public static g0.d b;
    public static final CopyOnWriteArrayList c = new CopyOnWriteArrayList();

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.lang.String r6, boolean r7) {
        /*
            long r0 = java.lang.System.nanoTime()
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r2
            h2.e.c = r0
            android.os.SystemClock.currentThreadTimeMillis()
            java.util.concurrent.CopyOnWriteArrayList r0 = h2.h.c
            r1 = 0
        L10:
            int r2 = r0.size()
            if (r1 >= r2) goto L45
            java.lang.Object r2 = r0.get(r1)
            h2.e r2 = (h2.e) r2
            if (r2 == 0) goto L3b
            if (r7 == 0) goto L33
            boolean r3 = r2.f4556a
            if (r3 != 0) goto L42
            h2.g r3 = r2.b
            r3.f4559j = r6
            r3 = 1
            r2.f4556a = r3
            h2.g r2 = r2.b
            long r4 = h2.e.c
            h2.g.c(r2, r3, r4)
            goto L42
        L33:
            boolean r3 = r2.f4556a
            if (r3 == 0) goto L42
        L37:
            r2.a()
            goto L42
        L3b:
            if (r7 != 0) goto L42
            boolean r3 = r2.f4556a
            if (r3 == 0) goto L42
            goto L37
        L42:
            int r1 = r1 + 1
            goto L10
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.h.a(java.lang.String, boolean):void");
    }
}
