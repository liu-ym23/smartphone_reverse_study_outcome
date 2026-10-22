package k9;

import android.content.Context;
import java.time.LocalDate;
import java.time.ZoneId;
import pb.i;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f7378a = new h();

    public static /* synthetic */ Object b(Context context, LocalDate localDate, l lVar, i iVar, int i) {
        if ((i & 2) != 0) {
            localDate = LocalDate.now(ZoneId.systemDefault());
            localDate.getClass();
        }
        if ((i & 4) != 0) {
            lVar = null;
        }
        return f7378a.a(context, localDate, lVar, iVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
    
        if (r0 == r2) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(android.content.Context r14, java.time.LocalDate r15, xb.l r16, pb.c r17) throws java.lang.Throwable {
        /*
            r13 = this;
            r0 = r17
            boolean r1 = r0 instanceof k9.f
            if (r1 == 0) goto L15
            r1 = r0
            k9.f r1 = (k9.f) r1
            int r2 = r1.f7373j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f7373j = r2
            goto L1a
        L15:
            k9.f r1 = new k9.f
            r1.<init>(r13, r0)
        L1a:
            java.lang.Object r0 = r1.f7372h
            ob.a r2 = ob.a.f9351c
            int r3 = r1.f7373j
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L43
            if (r3 == r5) goto L33
            if (r3 != r4) goto L2d
            id.c.I(r0)     // Catch: java.lang.Throwable -> L97
            goto L94
        L2d:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r13)
            return r6
        L33:
            android.content.Context r13 = r1.f7371g
            xb.l r14 = r1.f7370f
            java.time.LocalDate r3 = r1.f7369c
            id.c.I(r0)
            jb.i r0 = (jb.i) r0
            java.lang.Object r0 = r0.f6762c
            r9 = r13
            r8 = r14
            goto L5f
        L43:
            id.c.I(r0)
            android.content.Context r0 = r14.getApplicationContext()
            r1.f7369c = r15
            r7 = r16
            r1.f7370f = r7
            r1.f7371g = r0
            r1.f7373j = r5
            java.lang.Object r13 = r13.c(r14, r1)
            if (r13 != r2) goto L5b
            goto L93
        L5b:
            r3 = r15
            r9 = r0
            r8 = r7
            r0 = r13
        L5f:
            boolean r13 = r0 instanceof jb.h
            if (r13 == 0) goto L6f
            java.lang.Throwable r13 = jb.i.b(r0)
            r13.getClass()
            jb.h r13 = id.c.l(r13)
            return r13
        L6f:
            id.c.I(r0)
            r11 = r0
            z8.c r11 = (z8.c) r11
            java.time.format.DateTimeFormatter r13 = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
            java.lang.String r10 = r3.format(r13)
            rc.e r13 = kc.e0.f7430a     // Catch: java.lang.Throwable -> L97
            rc.d r13 = rc.d.f10552f     // Catch: java.lang.Throwable -> L97
            g9.y r7 = new g9.y     // Catch: java.lang.Throwable -> L97
            r12 = 0
            r7.<init>(r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L97
            r1.f7369c = r6     // Catch: java.lang.Throwable -> L97
            r1.f7370f = r6     // Catch: java.lang.Throwable -> L97
            r1.f7371g = r6     // Catch: java.lang.Throwable -> L97
            r1.f7373j = r4     // Catch: java.lang.Throwable -> L97
            java.lang.Object r0 = kc.w.E(r13, r7, r1)     // Catch: java.lang.Throwable -> L97
            if (r0 != r2) goto L94
        L93:
            return r2
        L94:
            k9.e r0 = (k9.e) r0     // Catch: java.lang.Throwable -> L97
            return r0
        L97:
            r0 = move-exception
            r13 = r0
            jb.h r13 = id.c.l(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: k9.h.a(android.content.Context, java.time.LocalDate, xb.l, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(android.content.Context r9, pb.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k9.h.c(android.content.Context, pb.c):java.lang.Object");
    }
}
