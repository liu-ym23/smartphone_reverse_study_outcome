package S0;

import D9.l;
import g1.AbstractC1451a;
import java.io.File;
import s1.AbstractRunnableC1911a;

/* loaded from: classes2.dex */
public final class e implements Y0.c {

    /* renamed from: a, reason: collision with root package name */
    public volatile long f1167a;
    public volatile long b;
    public l c;
    public volatile C5.b d;
    public volatile AbstractRunnableC1911a e;

    /* JADX WARN: Removed duplicated region for block: B:58:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(S0.e r14) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S0.e.d(S0.e):void");
    }

    @Override // Y0.c
    public final String a() {
        return "first_log_dir";
    }

    @Override // Y0.c
    public final long b() {
        String[] strArrD = this.d.d();
        long length = 0;
        if (strArrD != null && strArrD.length != 0) {
            for (String str : strArrD) {
                length += new File(b.i(), str).length();
            }
        }
        return length;
    }

    @Override // Y0.c
    public final void c(long j5) throws NumberFormatException {
        String[] strArrD;
        long j6;
        if (this.d == null || (strArrD = this.d.d()) == null || strArrD.length == 0) {
            return;
        }
        for (String str : strArrD) {
            File file = new File(b.i(), str);
            String name = file.getName();
            int iIndexOf = name.indexOf("_");
            if (iIndexOf == -1) {
                j6 = -1;
            } else {
                try {
                    j6 = Long.parseLong(name.substring(0, iIndexOf));
                } catch (Exception unused) {
                }
            }
            if (j6 == -1) {
                b.G(file);
            } else if (j6 <= j5) {
                b.G(file);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0071 A[SYNTHETIC] */
    @Override // Y0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(long r12) {
        /*
            r11 = this;
            C5.b r0 = r11.d
            if (r0 != 0) goto L6
            goto L74
        L6:
            C5.b r11 = r11.d
            java.lang.String[] r11 = r11.d()
            if (r11 == 0) goto L74
            int r0 = r11.length
            if (r0 != 0) goto L12
            goto L74
        L12:
            java.util.Arrays.sort(r11)
            int r0 = r11.length
            r1 = 0
            r3 = 0
            r5 = r1
            r4 = r3
        L1b:
            if (r4 >= r0) goto L3c
            r7 = r11[r4]
            java.io.File r8 = new java.io.File
            java.io.File r9 = S0.b.i()
            r8.<init>(r9, r7)
            boolean r7 = r8.exists()
            if (r7 == 0) goto L39
            boolean r7 = r8.isFile()
            if (r7 == 0) goto L39
            long r7 = r8.length()
            long r5 = r5 + r7
        L39:
            int r4 = r4 + 1
            goto L1b
        L3c:
            int r0 = r11.length
            r4 = r3
        L3e:
            if (r4 >= r0) goto L74
            r7 = r11[r4]
            long r8 = r5 - r1
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 <= 0) goto L74
            java.io.File r8 = new java.io.File
            java.io.File r9 = S0.b.i()
            r8.<init>(r9, r7)
            boolean r7 = r8.exists()
            if (r7 == 0) goto L71
            boolean r7 = r8.isFile()
            if (r7 == 0) goto L71
            long r9 = r8.length()
            boolean r7 = r8.exists()
            if (r7 != 0) goto L68
            goto L6d
        L68:
            boolean r7 = r8.delete()     // Catch: java.lang.Throwable -> L6d
            goto L6e
        L6d:
            r7 = r3
        L6e:
            if (r7 == 0) goto L71
            long r1 = r1 + r9
        L71:
            int r4 = r4 + 1
            goto L3e
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S0.e.e(long):void");
    }

    public final synchronized void f() {
        this.e = new c(this, this.f1167a);
        cc.dd.ee.kk.ff.c cVar = cc.dd.ee.kk.ff.c.f2142a;
        s1.b.a(cVar).c(this.e);
        if (AbstractC1451a.P()) {
            s1.b.a(cVar).c(new M0.c(this));
        }
    }
}
