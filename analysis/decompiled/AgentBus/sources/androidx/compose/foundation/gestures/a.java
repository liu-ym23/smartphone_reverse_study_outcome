package androidx.compose.foundation.gestures;

import n0.m;
import p.e0;
import p.k0;
import p.l0;
import p.m0;
import p.t0;
import q.i;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final l0 f727a = new l0();

    /* renamed from: b, reason: collision with root package name */
    public static final k0 f728b = new k0();

    /* renamed from: c, reason: collision with root package name */
    public static final m0 f729c = new m0();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(p.y0 r11, long r12, i7.c r14) {
        /*
            boolean r0 = r14 instanceof p.n0
            if (r0 == 0) goto L13
            r0 = r14
            p.n0 r0 = (p.n0) r0
            int r1 = r0.f8142i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8142i = r1
            goto L18
        L13:
            p.n0 r0 = new p.n0
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.f8141h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8142i
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            q7.s r11 = r0.f8140g
            p.y0 r12 = r0.f8139f
            w7.e0.N(r14)
            r8 = r11
            r11 = r12
            goto L54
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            w7.e0.N(r14)
            q7.s r8 = new q7.s
            r8.<init>()
            o.a r4 = new o.a
            r9 = 0
            r10 = 1
            r5 = r11
            r6 = r12
            r4.<init>(r5, r6, r8, r9, r10)
            r0.f8139f = r5
            r0.f8140g = r8
            r0.f8142i = r3
            java.lang.Object r11 = r5.e(r3, r4, r0)
            if (r11 != r1) goto L53
            return r1
        L53:
            r11 = r5
        L54:
            float r12 = r8.f8817f
            long r11 = r11.g(r12)
            t0.b r13 = new t0.b
            r13.<init>(r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.a.a(p.y0, long, i7.c):java.lang.Object");
    }

    public static final m b(m mVar, t0 t0Var, e0 e0Var, o.t0 t0Var2, boolean z4, i iVar) {
        return mVar.c(new ScrollableElement(t0Var2, e0Var, t0Var, iVar, z4));
    }
}
