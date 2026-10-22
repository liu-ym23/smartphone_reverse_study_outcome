package o4;

import androidx.room.c0;
import androidx.room.d0;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q implements d0, r {

    /* renamed from: a, reason: collision with root package name */
    public f f9219a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9220b;

    /* renamed from: c, reason: collision with root package name */
    public kb.j f9221c;

    /* renamed from: d, reason: collision with root package name */
    public AtomicBoolean f9222d;

    @Override // androidx.room.d0
    public final Object a(c0 c0Var, xb.p pVar, pb.i iVar) {
        if (this.f9222d.get()) {
            t0.a.l(21, "Connection is recycled");
            throw null;
        }
        a aVar = (a) iVar.getContext().get(a.f9154f);
        if (aVar != null && aVar.f9155c == this) {
            return g(c0Var, pVar, iVar);
        }
        t0.a.l(21, "Attempted to use connection on a different coroutine");
        throw null;
    }

    @Override // o4.r
    public final x4.a b() {
        return this.f9219a;
    }

    @Override // androidx.room.d0
    public final Object c(pb.i iVar) {
        if (this.f9222d.get()) {
            t0.a.l(21, "Connection is recycled");
            throw null;
        }
        a aVar = (a) iVar.getContext().get(a.f9154f);
        if (aVar != null && aVar.f9155c == this) {
            return Boolean.valueOf(!this.f9221c.isEmpty());
        }
        t0.a.l(21, "Attempted to use connection on a different coroutine");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.room.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r7, xb.l r8, pb.c r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof o4.p
            if (r0 == 0) goto L13
            r0 = r9
            o4.p r0 = (o4.p) r0
            int r1 = r0.f9218k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9218k = r1
            goto L18
        L13:
            o4.p r0 = new o4.p
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.i
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f9218k
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L32
            o4.f r6 = r0.f9216h
            xb.l r8 = r0.f9215g
            java.lang.String r7 = r0.f9214f
            o4.q r0 = r0.f9213c
            id.c.I(r9)
            r9 = r6
            r6 = r0
            goto L6c
        L32:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            return r4
        L38:
            id.c.I(r9)
            java.util.concurrent.atomic.AtomicBoolean r9 = r6.f9222d
            boolean r9 = r9.get()
            r2 = 21
            if (r9 != 0) goto La5
            nb.g r9 = r0.getContext()
            f8.b r5 = o4.a.f9154f
            nb.e r9 = r9.get(r5)
            o4.a r9 = (o4.a) r9
            if (r9 == 0) goto L9f
            o4.q r9 = r9.f9155c
            if (r9 != r6) goto L9f
            o4.f r9 = r6.f9219a
            r0.f9213c = r6
            r0.f9214f = r7
            r0.f9215g = r8
            r0.f9216h = r9
            r0.f9218k = r3
            sc.a r2 = r9.f9173f
            java.lang.Object r0 = r2.d(r0)
            if (r0 != r1) goto L6c
            return r1
        L6c:
            o4.j r0 = new o4.j     // Catch: java.lang.Throwable -> L92
            o4.f r1 = r6.f9219a     // Catch: java.lang.Throwable -> L92
            x4.c r7 = r1.K(r7)     // Catch: java.lang.Throwable -> L92
            r0.<init>()     // Catch: java.lang.Throwable -> L92
            r7.getClass()     // Catch: java.lang.Throwable -> L92
            r0.f9194g = r6     // Catch: java.lang.Throwable -> L92
            r0.f9192c = r7     // Catch: java.lang.Throwable -> L92
            long r6 = id.c.n()     // Catch: java.lang.Throwable -> L92
            r0.f9193f = r6     // Catch: java.lang.Throwable -> L92
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L92
            java.lang.Object r6 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L94
            t2.a.h(r0, r4)     // Catch: java.lang.Throwable -> L92
            r9.e(r4)
            return r6
        L92:
            r6 = move-exception
            goto L9b
        L94:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L96
        L96:
            r7 = move-exception
            t2.a.h(r0, r6)     // Catch: java.lang.Throwable -> L92
            throw r7     // Catch: java.lang.Throwable -> L92
        L9b:
            r9.e(r4)
            throw r6
        L9f:
            java.lang.String r6 = "Attempted to use connection on a different coroutine"
            t0.a.l(r2, r6)
            throw r4
        La5:
            java.lang.String r6 = "Connection is recycled"
            t0.a.l(r2, r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.q.d(java.lang.String, xb.l, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(androidx.room.c0 r7, pb.c r8) {
        /*
            r6 = this;
            java.lang.String r0 = "SAVEPOINT '"
            boolean r1 = r8 instanceof o4.m
            if (r1 == 0) goto L15
            r1 = r8
            o4.m r1 = (o4.m) r1
            int r2 = r1.f9202j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f9202j = r2
            goto L1a
        L15:
            o4.m r1 = new o4.m
            r1.<init>(r6, r8)
        L1a:
            java.lang.Object r8 = r1.f9201h
            ob.a r2 = ob.a.f9351c
            int r3 = r1.f9202j
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L38
            if (r3 != r4) goto L32
            o4.f r6 = r1.f9200g
            androidx.room.c0 r7 = r1.f9199f
            o4.q r1 = r1.f9198c
            id.c.I(r8)
            r8 = r6
            r6 = r1
            goto L4e
        L32:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            return r5
        L38:
            id.c.I(r8)
            o4.f r8 = r6.f9219a
            r1.f9198c = r6
            r1.f9199f = r7
            r1.f9200g = r8
            r1.f9202j = r4
            sc.a r3 = r8.f9173f
            java.lang.Object r1 = r3.d(r1)
            if (r1 != r2) goto L4e
            return r2
        L4e:
            kb.j r1 = r6.f9221c     // Catch: java.lang.Throwable -> L6b
            o4.f r6 = r6.f9219a     // Catch: java.lang.Throwable -> L6b
            int r2 = r1.f7402g     // Catch: java.lang.Throwable -> L6b
            boolean r3 = r1.isEmpty()     // Catch: java.lang.Throwable -> L6b
            if (r3 == 0) goto L7f
            int r7 = r7.ordinal()     // Catch: java.lang.Throwable -> L6b
            if (r7 == 0) goto L79
            if (r7 == r4) goto L73
            r0 = 2
            if (r7 != r0) goto L6d
            java.lang.String r7 = "BEGIN EXCLUSIVE TRANSACTION"
            t0.a.d(r6, r7)     // Catch: java.lang.Throwable -> L6b
            goto L93
        L6b:
            r6 = move-exception
            goto La6
        L6d:
            androidx.fragment.app.d r6 = new androidx.fragment.app.d     // Catch: java.lang.Throwable -> L6b
            r6.<init>()     // Catch: java.lang.Throwable -> L6b
            throw r6     // Catch: java.lang.Throwable -> L6b
        L73:
            java.lang.String r7 = "BEGIN IMMEDIATE TRANSACTION"
            t0.a.d(r6, r7)     // Catch: java.lang.Throwable -> L6b
            goto L93
        L79:
            java.lang.String r7 = "BEGIN DEFERRED TRANSACTION"
            t0.a.d(r6, r7)     // Catch: java.lang.Throwable -> L6b
            goto L93
        L7f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L6b
            r7.append(r2)     // Catch: java.lang.Throwable -> L6b
            r0 = 39
            r7.append(r0)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L6b
            t0.a.d(r6, r7)     // Catch: java.lang.Throwable -> L6b
        L93:
            o4.l r6 = new o4.l     // Catch: java.lang.Throwable -> L6b
            r6.<init>()     // Catch: java.lang.Throwable -> L6b
            r6.f9197a = r2     // Catch: java.lang.Throwable -> L6b
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L6b
            r1.addLast(r6)     // Catch: java.lang.Throwable -> L6b
            jb.v r6 = jb.v.f6774a     // Catch: java.lang.Throwable -> L6b
            r8.e(r5)
            return r6
        La6:
            r8.e(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.q.e(androidx.room.c0, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(boolean r7, pb.c r8) {
        /*
            r6 = this;
            java.lang.String r0 = "ROLLBACK TRANSACTION TO SAVEPOINT '"
            java.lang.String r1 = "RELEASE SAVEPOINT '"
            boolean r2 = r8 instanceof o4.n
            if (r2 == 0) goto L17
            r2 = r8
            o4.n r2 = (o4.n) r2
            int r3 = r2.f9207j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f9207j = r3
            goto L1c
        L17:
            o4.n r2 = new o4.n
            r2.<init>(r6, r8)
        L1c:
            java.lang.Object r8 = r2.f9206h
            ob.a r3 = ob.a.f9351c
            int r4 = r2.f9207j
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L33
            boolean r7 = r2.f9205g
            o4.f r6 = r2.f9204f
            o4.q r2 = r2.f9203c
            id.c.I(r8)
            r8 = r6
            r6 = r2
            goto L50
        L33:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L3a:
            id.c.I(r8)
            o4.f r8 = r6.f9219a
            r2.f9203c = r6
            r2.f9204f = r8
            r2.f9205g = r7
            r2.f9207j = r5
            sc.a r4 = r8.f9173f
            java.lang.Object r2 = r4.d(r2)
            if (r2 != r3) goto L50
            return r3
        L50:
            r2 = 0
            kb.j r3 = r6.f9221c     // Catch: java.lang.Throwable -> L74
            o4.f r6 = r6.f9219a     // Catch: java.lang.Throwable -> L74
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Throwable -> L74
            if (r4 != 0) goto Lb1
            java.lang.Object r4 = kb.q.q0(r3)     // Catch: java.lang.Throwable -> L74
            o4.l r4 = (o4.l) r4     // Catch: java.lang.Throwable -> L74
            r5 = 39
            if (r7 == 0) goto L8b
            r4.getClass()     // Catch: java.lang.Throwable -> L74
            boolean r7 = r3.isEmpty()     // Catch: java.lang.Throwable -> L74
            if (r7 == 0) goto L76
            java.lang.String r7 = "END TRANSACTION"
            t0.a.d(r6, r7)     // Catch: java.lang.Throwable -> L74
            goto Lab
        L74:
            r6 = move-exception
            goto Lb9
        L76:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r7.<init>(r1)     // Catch: java.lang.Throwable -> L74
            int r0 = r4.f9197a     // Catch: java.lang.Throwable -> L74
            r7.append(r0)     // Catch: java.lang.Throwable -> L74
            r7.append(r5)     // Catch: java.lang.Throwable -> L74
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L74
            t0.a.d(r6, r7)     // Catch: java.lang.Throwable -> L74
            goto Lab
        L8b:
            boolean r7 = r3.isEmpty()     // Catch: java.lang.Throwable -> L74
            if (r7 == 0) goto L97
            java.lang.String r7 = "ROLLBACK TRANSACTION"
            t0.a.d(r6, r7)     // Catch: java.lang.Throwable -> L74
            goto Lab
        L97:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L74
            int r0 = r4.f9197a     // Catch: java.lang.Throwable -> L74
            r7.append(r0)     // Catch: java.lang.Throwable -> L74
            r7.append(r5)     // Catch: java.lang.Throwable -> L74
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L74
            t0.a.d(r6, r7)     // Catch: java.lang.Throwable -> L74
        Lab:
            jb.v r6 = jb.v.f6774a     // Catch: java.lang.Throwable -> L74
            r8.e(r2)
            return r6
        Lb1:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L74
            java.lang.String r7 = "Not in a transaction"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L74
            throw r6     // Catch: java.lang.Throwable -> L74
        Lb9:
            r8.e(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.q.f(boolean, pb.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(androidx.room.c0 r11, xb.p r12, pb.c r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.q.g(androidx.room.c0, xb.p, pb.c):java.lang.Object");
    }
}
