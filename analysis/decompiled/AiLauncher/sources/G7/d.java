package G7;

import kotlin.Metadata;
import tb.w;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LG7/d;", "Ltb/w;", "<init>", "()V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d implements w {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    @Override // tb.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public tb.C5530C intercept(tb.w.a r24) {
        /*
            r23 = this;
            r0 = r24
            java.lang.String r1 = "chain"
            kotlin.jvm.internal.p.i(r0, r1)
            boolean r1 = G7.b.c()
            if (r1 != 0) goto L16
            tb.A r1 = r0.getRequest()
            tb.C r0 = r0.i(r1)
            return r0
        L16:
            tb.A r1 = r0.getRequest()
            G7.b r2 = G7.b.f2814a
            long r4 = r2.d()
            long r19 = android.os.SystemClock.elapsedRealtime()
            java.lang.String r3 = "X-Request-Id"
            java.lang.String r14 = r1.e(r3)
            tb.B r3 = r1.getBody()
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L45
            long r9 = r3.a()
            java.lang.Long r3 = java.lang.Long.valueOf(r9)
            long r9 = r3.longValue()
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 < 0) goto L45
            r11 = r3
            goto L46
        L45:
            r11 = r8
        L46:
            tb.C r0 = r0.i(r1)     // Catch: java.lang.Throwable -> L80
            r9 = r6
            java.lang.String r6 = r1.getMethod()     // Catch: java.lang.Throwable -> L80
            tb.v r3 = r1.getUrl()     // Catch: java.lang.Throwable -> L80
            java.lang.String r7 = r3.getUrl()     // Catch: java.lang.Throwable -> L80
            int r3 = r0.getCode()     // Catch: java.lang.Throwable -> L80
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L80
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L80
            long r12 = r12 - r19
            tb.D r15 = r0.getBody()     // Catch: java.lang.Throwable -> L80
            if (r15 == 0) goto L7e
            long r15 = r15.getContentLength()     // Catch: java.lang.Throwable -> L80
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch: java.lang.Throwable -> L80
            long r16 = r15.longValue()     // Catch: java.lang.Throwable -> L80
            int r9 = (r16 > r9 ? 1 : (r16 == r9 ? 0 : -1))
            if (r9 < 0) goto L7e
            r9 = r3
            r8 = r15
            goto L82
        L7e:
            r9 = r3
            goto L82
        L80:
            r0 = move-exception
            goto L98
        L82:
            G7.b$a r3 = new G7.b$a     // Catch: java.lang.Throwable -> L80
            r21 = r12
            r12 = r8
            r8 = r9
            r9 = r21
            r13 = 0
            r15 = 0
            r17 = 640(0x280, float:8.97E-43)
            r18 = 0
            r3.<init>(r4, r6, r7, r8, r9, r11, r12, r13, r14, r15, r17, r18)     // Catch: java.lang.Throwable -> L80
            r2.e(r3)     // Catch: java.lang.Throwable -> L80
            return r0
        L98:
            G7.b r2 = G7.b.f2814a
            G7.b$a r3 = new G7.b$a
            java.lang.String r6 = r1.getMethod()
            tb.v r1 = r1.getUrl()
            java.lang.String r7 = r1.getUrl()
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r9 = r8 - r19
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r8 = r0.getMessage()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r1)
            java.lang.String r1 = ": "
            r12.append(r1)
            r12.append(r8)
            java.lang.String r13 = r12.toString()
            r17 = 584(0x248, float:8.18E-43)
            r18 = 0
            r8 = 0
            r12 = 0
            r15 = 0
            r3.<init>(r4, r6, r7, r8, r9, r11, r12, r13, r14, r15, r17, r18)
            r2.e(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: G7.d.intercept(tb.w$a):tb.C");
    }
}
