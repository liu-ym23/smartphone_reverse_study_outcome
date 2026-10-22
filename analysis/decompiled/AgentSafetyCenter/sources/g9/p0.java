package g9;

import android.content.Context;
import com.fasterxml.jackson.core.JsonPointer;
import java.lang.invoke.VarHandle;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: h, reason: collision with root package name */
    public static final s f4573h = new s();
    public static volatile p0 i;

    /* renamed from: a, reason: collision with root package name */
    public final Context f4574a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f4575b;

    /* renamed from: c, reason: collision with root package name */
    public final d1 f4576c;

    /* renamed from: d, reason: collision with root package name */
    public final b0 f4577d;

    /* renamed from: e, reason: collision with root package name */
    public final nc.t0 f4578e;

    /* renamed from: f, reason: collision with root package name */
    public final nc.f0 f4579f;

    /* renamed from: g, reason: collision with root package name */
    public p f4580g;

    public p0(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f4574a = applicationContext;
        applicationContext.getClass();
        g0 g0Var = new g0();
        g0Var.f4462a = applicationContext.getApplicationContext();
        this.f4575b = g0Var;
        d1 d1Var = new d1();
        d1Var.f4429a = applicationContext.getApplicationContext();
        VarHandle.storeStoreFence();
        this.f4576c = d1Var;
        String strP = t1.e.p(applicationContext);
        strP.getClass();
        b0 b0Var = new b0();
        b0Var.f4408a = k0.a.n(hc.h.x0(strP, JsonPointer.SEPARATOR), "/v1/tool_security/device/permission");
        ad.v vVar = new ad.v();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        vVar.a(30L, timeUnit);
        vVar.f601t = bd.b.b(30L, timeUnit);
        vVar.f602u = bd.b.b(30L, timeUnit);
        vVar.f588f = true;
        b0Var.f4409b = new ad.w(vVar);
        Pattern pattern = ad.s.f568d;
        b0Var.f4410c = id.k.t("application/json; charset=utf-8");
        VarHandle.storeStoreFence();
        this.f4577d = b0Var;
        nc.t0 t0VarA = nc.k0.a(new y0(kb.s.f7404c, true, false, false));
        this.f4578e = t0VarA;
        this.f4579f = new nc.f0(t0VarA);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099 A[LOOP:0: B:31:0x0093->B:33:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(g9.p0 r7, java.lang.String r8, pb.c r9) {
        /*
            boolean r0 = r9 instanceof g9.l0
            if (r0 == 0) goto L13
            r0 = r9
            g9.l0 r0 = (g9.l0) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            g9.l0 r0 = new g9.l0
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f4521g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L45
            if (r2 == r6) goto L3f
            if (r2 == r5) goto L37
            if (r2 != r4) goto L30
            g9.p r7 = r0.f4520f
            id.c.I(r9)
            goto L7d
        L30:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            r7 = 0
            return r7
        L37:
            id.c.I(r9)
            jb.i r9 = (jb.i) r9
            java.lang.Object r8 = r9.f6762c
            goto L67
        L3f:
            java.lang.String r8 = r0.f4519c
            id.c.I(r9)
            goto L53
        L45:
            id.c.I(r9)
            r0.f4519c = r8
            r0.i = r6
            java.lang.Object r9 = r7.b(r0)
            if (r9 != r1) goto L53
            goto L7b
        L53:
            g9.r0 r9 = g9.r0.f4605a
            android.content.Context r2 = r7.f4574a
            r2.getClass()
            g9.b0 r6 = r7.f4577d
            r0.f4519c = r3
            r0.i = r5
            java.lang.Object r8 = r9.a(r2, r6, r8, r0)
            if (r8 != r1) goto L67
            goto L7b
        L67:
            boolean r9 = r8 instanceof jb.h
            if (r9 != 0) goto Lc6
            g9.p r8 = (g9.p) r8
            g9.d1 r7 = r7.f4576c
            r0.f4519c = r3
            r0.f4520f = r8
            r0.i = r4
            java.lang.Object r9 = r7.a(r0)
            if (r9 != r1) goto L7c
        L7b:
            return r1
        L7c:
            r7 = r8
        L7d:
            java.util.List r9 = (java.util.List) r9
            r7.getClass()
            r9.getClass()
            g9.i0 r8 = new g9.i0
            r0 = 0
            r8.<init>(r0)
            java.util.List r8 = kb.l.I0(r9, r8)
            java.util.Iterator r8 = r8.iterator()
        L93:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto La8
            java.lang.Object r0 = r8.next()
            g9.a1 r0 = (g9.a1) r0
            java.lang.String r1 = r0.f4403a
            java.lang.String r0 = r0.f4404b
            g9.p r7 = com.stepos.statsrpk.h.E(r7, r1, r0)
            goto L93
        La8:
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto Lc5
            int r8 = r9.size()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "list merged leftover pending="
            r9.<init>(r0)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "PermissionCloudRepo"
            android.util.Log.i(r9, r8)
        Lc5:
            return r7
        Lc6:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.p0.a(g9.p0, java.lang.String, pb.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        if (r1 == r3) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f8, code lost:
    
        if (r5 != r3) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fb, code lost:
    
        if (r7 != r3) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0119 -> B:41:0x011a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(pb.c r19) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.p0.b(pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r7, pb.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof g9.k0
            if (r0 == 0) goto L13
            r0 = r8
            g9.k0 r0 = (g9.k0) r0
            int r1 = r0.f4512g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4512g = r1
            goto L18
        L13:
            g9.k0 r0 = new g9.k0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f4510c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f4512g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L2e
            if (r2 != r4) goto L28
            id.c.I(r8)
            goto L44
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            return r3
        L2e:
            id.c.I(r8)
            rc.e r8 = kc.e0.f7430a
            rc.d r8 = rc.d.f10552f
            androidx.lifecycle.h0 r2 = new androidx.lifecycle.h0
            r5 = 6
            r2.<init>(r6, r7, r3, r5)
            r0.f4512g = r4
            java.lang.Object r8 = kc.w.E(r8, r2, r0)
            if (r8 != r1) goto L44
            return r1
        L44:
            jb.i r8 = (jb.i) r8
            java.lang.Object r6 = r8.f6762c
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.p0.c(java.lang.String, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r6, g9.z0 r7, pb.c r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof g9.n0
            if (r0 == 0) goto L13
            r0 = r8
            g9.n0 r0 = (g9.n0) r0
            int r1 = r0.f4542g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4542g = r1
            goto L18
        L13:
            g9.n0 r0 = new g9.n0
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f4540c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f4542g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L28
            id.c.I(r8)
            goto L43
        L28:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            return r4
        L2e:
            id.c.I(r8)
            rc.e r8 = kc.e0.f7430a
            rc.d r8 = rc.d.f10552f
            g9.o0 r2 = new g9.o0
            r2.<init>(r7, r6, r5, r4)
            r0.f4542g = r3
            java.lang.Object r8 = kc.w.E(r8, r2, r0)
            if (r8 != r1) goto L43
            return r1
        L43:
            jb.i r8 = (jb.i) r8
            java.lang.Object r5 = r8.f6762c
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.p0.d(java.lang.String, g9.z0, pb.c):java.lang.Object");
    }
}
