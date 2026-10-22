package E4;

import C4.C0274d;
import C4.D;
import C4.F;
import C4.v;
import G4.d;
import G4.e;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final D f1604a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final F f1605b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long f1606a;

        /* renamed from: b, reason: collision with root package name */
        final D f1607b;

        /* renamed from: c, reason: collision with root package name */
        final F f1608c;

        /* renamed from: d, reason: collision with root package name */
        private Date f1609d;

        /* renamed from: e, reason: collision with root package name */
        private String f1610e;

        /* renamed from: f, reason: collision with root package name */
        private Date f1611f;

        /* renamed from: g, reason: collision with root package name */
        private String f1612g;

        /* renamed from: h, reason: collision with root package name */
        private Date f1613h;

        /* renamed from: i, reason: collision with root package name */
        private long f1614i;

        /* renamed from: j, reason: collision with root package name */
        private long f1615j;

        /* renamed from: k, reason: collision with root package name */
        private String f1616k;

        /* renamed from: l, reason: collision with root package name */
        private int f1617l;

        public a(long j5, D d6, F f5) {
            this.f1617l = -1;
            this.f1606a = j5;
            this.f1607b = d6;
            this.f1608c = f5;
            if (f5 != null) {
                this.f1614i = f5.L();
                this.f1615j = f5.G();
                v vVarV = f5.v();
                int iH = vVarV.h();
                for (int i5 = 0; i5 < iH; i5++) {
                    String strE = vVarV.e(i5);
                    String strI = vVarV.i(i5);
                    if ("Date".equalsIgnoreCase(strE)) {
                        this.f1609d = d.b(strI);
                        this.f1610e = strI;
                    } else if ("Expires".equalsIgnoreCase(strE)) {
                        this.f1613h = d.b(strI);
                    } else if ("Last-Modified".equalsIgnoreCase(strE)) {
                        this.f1611f = d.b(strI);
                        this.f1612g = strI;
                    } else if ("ETag".equalsIgnoreCase(strE)) {
                        this.f1616k = strI;
                    } else if ("Age".equalsIgnoreCase(strE)) {
                        this.f1617l = e.d(strI, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.f1609d;
            long jMax = date != null ? Math.max(0L, this.f1615j - date.getTime()) : 0L;
            int i5 = this.f1617l;
            if (i5 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i5));
            }
            long j5 = this.f1615j;
            return jMax + (j5 - this.f1614i) + (this.f1606a - j5);
        }

        private long b() {
            if (this.f1608c.c().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            if (this.f1613h != null) {
                Date date = this.f1609d;
                long time = this.f1613h.getTime() - (date != null ? date.getTime() : this.f1615j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f1611f != null && this.f1608c.I().i().z() == null) {
                Date date2 = this.f1609d;
                long time2 = (date2 != null ? date2.getTime() : this.f1614i) - this.f1611f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private b d() {
            String str;
            if (this.f1608c == null) {
                return new b(this.f1607b, null);
            }
            if ((!this.f1607b.e() || this.f1608c.o() != null) && b.a(this.f1608c, this.f1607b)) {
                C0274d c0274dB = this.f1607b.b();
                if (c0274dB.h() || e(this.f1607b)) {
                    return new b(this.f1607b, null);
                }
                C0274d c0274dC = this.f1608c.c();
                long jA = a();
                long jB = b();
                if (c0274dB.d() != -1) {
                    jB = Math.min(jB, TimeUnit.SECONDS.toMillis(c0274dB.d()));
                }
                long millis = 0;
                long millis2 = c0274dB.f() != -1 ? TimeUnit.SECONDS.toMillis(c0274dB.f()) : 0L;
                if (!c0274dC.g() && c0274dB.e() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(c0274dB.e());
                }
                if (!c0274dC.h()) {
                    long j5 = millis2 + jA;
                    if (j5 < millis + jB) {
                        F.a aVarC = this.f1608c.C();
                        if (j5 >= jB) {
                            aVarC.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jA > 86400000 && f()) {
                            aVarC.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new b(null, aVarC.c());
                    }
                }
                String str2 = this.f1616k;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.f1611f != null) {
                        str2 = this.f1612g;
                    } else {
                        if (this.f1609d == null) {
                            return new b(this.f1607b, null);
                        }
                        str2 = this.f1610e;
                    }
                    str = "If-Modified-Since";
                }
                v.a aVarF = this.f1607b.d().f();
                D4.a.f1202a.b(aVarF, str, str2);
                return new b(this.f1607b.g().d(aVarF.e()).b(), this.f1608c);
            }
            return new b(this.f1607b, null);
        }

        private static boolean e(D d6) {
            return (d6.c("If-Modified-Since") == null && d6.c("If-None-Match") == null) ? false : true;
        }

        private boolean f() {
            return this.f1608c.c().d() == -1 && this.f1613h == null;
        }

        public b c() {
            b bVarD = d();
            return (bVarD.f1604a == null || !this.f1607b.b().j()) ? bVarD : new b(null, null);
        }
    }

    b(D d6, F f5) {
        this.f1604a = d6;
        this.f1605b = f5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.c().b() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(C4.F r3, C4.D r4) {
        /*
            int r0 = r3.m()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.r(r0)
            if (r0 != 0) goto L5a
            C4.d r0 = r3.c()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            C4.d r0 = r3.c()
            boolean r0 = r0.c()
            if (r0 != 0) goto L5a
            C4.d r0 = r3.c()
            boolean r0 = r0.b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            C4.d r3 = r3.c()
            boolean r3 = r3.i()
            if (r3 != 0) goto L70
            C4.d r3 = r4.b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L70
            r3 = 1
            return r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: E4.b.a(C4.F, C4.D):boolean");
    }
}
