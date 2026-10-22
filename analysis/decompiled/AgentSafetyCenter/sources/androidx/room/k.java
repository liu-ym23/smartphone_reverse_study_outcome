package androidx.room;

import nc.t0;
import v3.q0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public t0 f1564a;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(androidx.room.g0 r5, pb.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.room.j
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.j r0 = (androidx.room.j) r0
            int r1 = r0.f1554g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1554g = r1
            goto L18
        L13:
            androidx.room.j r0 = new androidx.room.j
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f1552c
            ob.a r1 = ob.a.f9351c
            int r1 = r0.f1554g
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 == r2) goto L29
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            return
        L29:
            id.c.I(r6)
            androidx.fragment.app.d r4 = new androidx.fragment.app.d
            r4.<init>()
            throw r4
        L32:
            id.c.I(r6)
            nc.t0 r4 = r4.f1564a
            r0.f1554g = r2
            r4.collect(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.k.a(androidx.room.g0, pb.c):void");
    }

    public q0 b() {
        return (q0) this.f1564a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Type inference failed for: r2v4, types: [pc.t] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(v3.q0 r5) {
        /*
            r4 = this;
            r5.getClass()
            nc.t0 r4 = r4.f1564a
        L5:
            java.lang.Object r0 = r4.getValue()
            r1 = r0
            v3.q0 r1 = (v3.q0) r1
            boolean r2 = r1 instanceof v3.l0
            if (r2 == 0) goto L12
            r2 = 1
            goto L18
        L12:
            v3.r0 r2 = v3.r0.f14714b
            boolean r2 = yb.k.a(r1, r2)
        L18:
            if (r2 == 0) goto L1b
            goto L25
        L1b:
            boolean r2 = r1 instanceof v3.c
            if (r2 == 0) goto L27
            int r2 = r5.f14709a
            int r3 = r1.f14709a
            if (r2 <= r3) goto L2b
        L25:
            r1 = r5
            goto L2b
        L27:
            boolean r2 = r1 instanceof v3.j0
            if (r2 == 0) goto L3a
        L2b:
            pc.t r2 = oc.c.f9367b
            if (r0 != 0) goto L30
            r0 = r2
        L30:
            if (r1 != 0) goto L33
            r1 = r2
        L33:
            boolean r0 = r4.g(r0, r1)
            if (r0 == 0) goto L5
            return
        L3a:
            g5.f.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.k.c(v3.q0):void");
    }
}
