package androidx.room;

import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f1585k = {"INSERT", "UPDATE", "DELETE"};

    /* renamed from: a, reason: collision with root package name */
    public u f1586a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f1587b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1588c;

    /* renamed from: d, reason: collision with root package name */
    public d f1589d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedHashMap f1590e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f1591f;

    /* renamed from: g, reason: collision with root package name */
    public ab.c f1592g;

    /* renamed from: h, reason: collision with root package name */
    public k f1593h;
    public AtomicBoolean i;

    /* renamed from: j, reason: collision with root package name */
    public xb.a f1594j;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(androidx.room.n0 r4, androidx.room.m r5, pb.c r6) {
        /*
            boolean r0 = r6 instanceof androidx.room.e0
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.e0 r0 = (androidx.room.e0) r0
            int r1 = r0.f1523h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1523h = r1
            goto L18
        L13:
            androidx.room.e0 r0 = new androidx.room.e0
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f1521f
            ob.a r6 = ob.a.f9351c
            int r1 = r0.f1523h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3d
            if (r1 == r3) goto L35
            if (r1 != r2) goto L2e
            java.lang.Object r5 = r0.f1520c
            java.util.Set r5 = (java.util.Set) r5
            id.c.I(r4)
            return r5
        L2e:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L35:
            java.lang.Object r5 = r0.f1520c
            androidx.room.m r5 = (androidx.room.m) r5
            id.c.I(r4)
            goto L54
        L3d:
            id.c.I(r4)
            a9.d r4 = new a9.d
            r1 = 13
            r4.<init>(r1)
            r0.f1520c = r5
            r0.f1523h = r3
            java.lang.String r1 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r4 = r5.d(r1, r4, r0)
            if (r4 != r6) goto L54
            goto L6b
        L54:
            java.util.Set r4 = (java.util.Set) r4
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L6c
            r0.f1520c = r4
            r0.f1523h = r2
            java.lang.String r1 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r5 = q8.g.c(r5, r1, r0)
            if (r5 != r6) goto L6c
        L6b:
            return r6
        L6c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.n0.a(androidx.room.n0, androidx.room.m, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(androidx.room.n0 r11, pb.c r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.n0.b(androidx.room.n0, pb.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
    
        if (q8.g.c(r1, r3, r4) == r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00de, code lost:
    
        if (q8.g.c(r10, r3, r4) == r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e0, code lost:
    
        return r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00de -> B:28:0x00e1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(androidx.room.n0 r17, androidx.room.d0 r18, int r19, pb.c r20) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.n0.c(androidx.room.n0, androidx.room.d0, int, pb.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.room.m] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008c -> B:19:0x008f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(androidx.room.n0 r8, androidx.room.d0 r9, int r10, pb.c r11) {
        /*
            r8.getClass()
            boolean r0 = r11 instanceof androidx.room.k0
            if (r0 == 0) goto L16
            r0 = r11
            androidx.room.k0 r0 = (androidx.room.k0) r0
            int r1 = r0.f1571l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f1571l = r1
            goto L1b
        L16:
            androidx.room.k0 r0 = new androidx.room.k0
            r0.<init>(r8, r11)
        L1b:
            java.lang.Object r11 = r0.f1569j
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f1571l
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L36
            int r8 = r0.i
            int r9 = r0.f1568h
            java.lang.String[] r10 = r0.f1567g
            java.lang.String r2 = r0.f1566f
            androidx.room.m r4 = r0.f1565c
            id.c.I(r11)
            r11 = r10
            r10 = r4
            goto L8f
        L36:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r8)
            r8 = 0
            return r8
        L3d:
            id.c.I(r11)
            java.lang.String[] r8 = r8.f1591f
            r8 = r8[r10]
            java.lang.String[] r10 = androidx.room.n0.f1585k
            r11 = 0
            r2 = 3
            r7 = r2
            r2 = r8
            r8 = r7
            r7 = r10
            r10 = r9
            r9 = r11
            r11 = r7
        L4f:
            if (r9 >= r8) goto L91
            r4 = r11[r9]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "room_table_modification_trigger_"
            r5.<init>(r6)
            r5.append(r2)
            r6 = 95
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "DROP TRIGGER IF EXISTS `"
            r5.<init>(r6)
            r5.append(r4)
            r4 = 96
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r0.f1565c = r10
            r0.f1566f = r2
            r0.f1567g = r11
            r0.f1568h = r9
            r0.i = r8
            r0.f1571l = r3
            java.lang.Object r4 = q8.g.c(r10, r4, r0)
            if (r4 != r1) goto L8f
            return r1
        L8f:
            int r9 = r9 + r3
            goto L4f
        L91:
            jb.v r8 = jb.v.f6774a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.n0.d(androidx.room.n0, androidx.room.d0, int, pb.c):java.lang.Object");
    }

    public final void e(xb.a aVar, xb.a aVar2) {
        aVar.getClass();
        aVar2.getClass();
        if (this.i.compareAndSet(false, true)) {
            aVar.invoke();
            pc.c cVar = this.f1586a.f1628a;
            nb.c cVar2 = null;
            if (cVar == null) {
                yb.k.f("coroutineScope");
                throw null;
            }
            kc.s sVar = new kc.s(kc.s.f7477f);
            sVar.f7478c = "Room Invalidation Tracker Refresh";
            VarHandle.storeStoreFence();
            kc.w.u(cVar, sVar, null, new androidx.lifecycle.h0(this, aVar2, cVar2, 2), 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(pb.c r9) {
        /*
            r8 = this;
            androidx.room.u r0 = r8.f1586a
            boolean r1 = r9 instanceof androidx.room.l0
            if (r1 == 0) goto L15
            r1 = r9
            androidx.room.l0 r1 = (androidx.room.l0) r1
            int r2 = r1.f1575h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f1575h = r2
            goto L1a
        L15:
            androidx.room.l0 r1 = new androidx.room.l0
            r1.<init>(r8, r9)
        L1a:
            java.lang.Object r9 = r1.f1573f
            ob.a r2 = ob.a.f9351c
            int r3 = r1.f1575h
            r4 = 1
            if (r3 == 0) goto L34
            if (r3 != r4) goto L2d
            p5.c r8 = r1.f1572c
            id.c.I(r9)     // Catch: java.lang.Throwable -> L2b
            goto L53
        L2b:
            r9 = move-exception
            goto L5b
        L2d:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r8)
            r8 = 0
            return r8
        L34:
            id.c.I(r9)
            p5.c r9 = r0.f1634g
            boolean r3 = r9.f()
            if (r3 == 0) goto L5f
            androidx.room.i0 r3 = new androidx.room.i0     // Catch: java.lang.Throwable -> L57
            r5 = 0
            r6 = 2
            r3.<init>(r8, r5, r6)     // Catch: java.lang.Throwable -> L57
            r1.f1572c = r9     // Catch: java.lang.Throwable -> L57
            r1.f1575h = r4     // Catch: java.lang.Throwable -> L57
            r8 = 0
            java.lang.Object r8 = r0.w(r8, r3, r1)     // Catch: java.lang.Throwable -> L57
            if (r8 != r2) goto L52
            return r2
        L52:
            r8 = r9
        L53:
            r8.s()
            goto L5f
        L57:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L5b:
            r8.s()
            throw r9
        L5f:
            jb.v r8 = jb.v.f6774a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.n0.f(pb.c):java.lang.Object");
    }
}
