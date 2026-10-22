package R1;

import java.io.FileFilter;

/* loaded from: classes2.dex */
public final class a implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1140a;

    public /* synthetic */ a(int i) {
        this.f1140a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    @Override // java.io.FileFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean accept(java.io.File r8) {
        /*
            r7 = this;
            int r7 = r7.f1140a
            switch(r7) {
                case 0: goto L6f;
                case 1: goto L23;
                default: goto L5;
            }
        L5:
            java.lang.String r7 = r8.getName()
            java.lang.String r0 = ".log"
            boolean r0 = r7.endsWith(r0)
            if (r0 == 0) goto L13
            r7 = 1
            goto L22
        L13:
            java.lang.String r0 = ".txt"
            boolean r7 = r7.endsWith(r0)
            r0 = 0
            if (r7 == 0) goto L1e
        L1c:
            r7 = r0
            goto L22
        L1e:
            S0.b.G(r8)
            goto L1c
        L22:
            return r7
        L23:
            r7 = 0
            java.lang.String r0 = r8.getName()     // Catch: java.lang.Throwable -> L50
            java.lang.String r1 = ".bin"
            int r1 = r0.lastIndexOf(r1)     // Catch: java.lang.Throwable -> L50
            r2 = -1
            if (r1 == r2) goto L50
            java.lang.String r0 = r0.substring(r7, r1)     // Catch: java.lang.Throwable -> L50
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L50
            long r3 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L50
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L44
            goto L48
        L44:
            r0 = 16
            long r5 = r3 >> r0
        L48:
            long r1 = r1 - r5
            r3 = 604800000(0x240c8400, double:2.988109026E-315)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 < 0) goto L6e
        L50:
            boolean r0 = g1.AbstractC1451a.f4467a
            if (r0 == 0) goto L6b
            java.lang.String r0 = S0.a.f1163a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "deleteExpireHeader:"
            r1.<init>(r2)
            java.lang.String r2 = r8.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            H4.o.f(r0, r1)
        L6b:
            S0.b.G(r8)
        L6e:
            return r7
        L6f:
            boolean r7 = r8.isFile()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.a.accept(java.io.File):boolean");
    }
}
