package q8;

import android.content.Context;
import java.io.File;
import java.lang.invoke.VarHandle;
import java.time.LocalDate;
import java.time.ZoneId;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final h f10186a;

    /* renamed from: b, reason: collision with root package name */
    public final p5.l f10187b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneId f10188c;

    /* renamed from: d, reason: collision with root package name */
    public final u f10189d;

    public t(h hVar, File file, Context context, ZoneId zoneId) {
        hVar.getClass();
        context.getClass();
        zoneId.getClass();
        p5.e eVar = new p5.e(9);
        eVar.f9722f = context.getApplicationContext();
        eVar.f9723g = new Object();
        VarHandle.storeStoreFence();
        p5.l lVar = new p5.l();
        lVar.f9738c = file;
        lVar.f9739f = eVar;
        VarHandle.storeStoreFence();
        u uVar = new u();
        VarHandle.storeStoreFence();
        this.f10186a = hVar;
        this.f10187b = lVar;
        this.f10188c = zoneId;
        this.f10189d = uVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r6, pb.c r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof q8.k
            if (r0 == 0) goto L13
            r0 = r8
            q8.k r0 = (q8.k) r0
            int r1 = r0.f10133h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10133h = r1
            goto L18
        L13:
            q8.k r0 = new q8.k
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f10131f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f10133h
            jb.v r3 = jb.v.f6774a
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2d
            long r6 = r0.f10130c
            id.c.I(r8)     // Catch: java.lang.Throwable -> L2b
            goto L44
        L2b:
            r8 = move-exception
            goto L46
        L2d:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            r5 = 0
            return r5
        L34:
            id.c.I(r8)
            q8.h r8 = r5.f10186a     // Catch: java.lang.Throwable -> L2b
            r0.f10130c = r6     // Catch: java.lang.Throwable -> L2b
            r0.f10133h = r4     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r8 = r8.a(r6, r0)     // Catch: java.lang.Throwable -> L2b
            if (r8 != r1) goto L44
            return r1
        L44:
            r8 = r3
            goto L4a
        L46:
            jb.h r8 = id.c.l(r8)
        L4a:
            java.lang.Throwable r8 = jb.i.b(r8)
            if (r8 == 0) goto L63
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "deleteDay failed "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "DashboardLocal"
            android.util.Log.e(r1, r0, r8)
        L63:
            p5.l r5 = r5.f10187b
            r5.g(r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.t.a(long, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r11, pb.c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof q8.l
            if (r0 == 0) goto L13
            r0 = r13
            q8.l r0 = (q8.l) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            q8.l r0 = new q8.l
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f10136g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            r3 = 0
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L37
            if (r2 != r4) goto L31
            long r10 = r0.f10135f
            long r0 = r0.f10134c
            id.c.I(r13)     // Catch: java.lang.Throwable -> L2e
            goto L85
        L2e:
            r12 = move-exception
            goto L9f
        L31:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            return r3
        L37:
            id.c.I(r13)
            p5.l r13 = r10.f10187b
            java.io.File r2 = r13.i(r11)
            boolean r7 = r2.isFile()
            if (r7 == 0) goto L47
            goto L48
        L47:
            r2 = r3
        L48:
            if (r2 == 0) goto L4f
            long r7 = r2.length()
            goto L50
        L4f:
            r7 = r5
        L50:
            java.io.File r13 = r13.m(r11)
            boolean r2 = r13.isFile()
            if (r2 == 0) goto L5b
            r3 = r13
        L5b:
            if (r3 == 0) goto L62
            long r2 = r3.length()
            goto L63
        L62:
            r2 = r5
        L63:
            q8.h r10 = r10.f10186a     // Catch: java.lang.Throwable -> L9d
            r0.f10134c = r7     // Catch: java.lang.Throwable -> L9d
            r0.f10135f = r2     // Catch: java.lang.Throwable -> L9d
            r0.i = r4     // Catch: java.lang.Throwable -> L9d
            java.lang.String r13 = "SELECT COALESCE(LENGTH(result_json), 0) FROM dashboard_days WHERE day_start_millis = ? LIMIT 1"
            androidx.room.u r10 = r10.f10119a     // Catch: java.lang.Throwable -> L98
            q8.f r9 = new q8.f     // Catch: java.lang.Throwable -> L98
            r9.<init>()     // Catch: java.lang.Throwable -> L98
            r9.f10116c = r13     // Catch: java.lang.Throwable -> L98
            r9.f10117f = r11     // Catch: java.lang.Throwable -> L98
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L98
            r11 = 0
            java.lang.Object r13 = td.h.B(r10, r0, r9, r4, r11)     // Catch: java.lang.Throwable -> L98
            if (r13 != r1) goto L83
            return r1
        L83:
            r10 = r2
            r0 = r7
        L85:
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch: java.lang.Throwable -> L2e
            if (r13 == 0) goto L8f
            int r12 = r13.intValue()     // Catch: java.lang.Throwable -> L2e
            long r12 = (long) r12     // Catch: java.lang.Throwable -> L2e
            goto L90
        L8f:
            r12 = r5
        L90:
            java.lang.Long r2 = new java.lang.Long     // Catch: java.lang.Throwable -> L2e
            r2.<init>(r12)     // Catch: java.lang.Throwable -> L2e
            goto La3
        L96:
            r12 = r10
            goto L9a
        L98:
            r10 = move-exception
            goto L96
        L9a:
            r10 = r2
            r0 = r7
            goto L9f
        L9d:
            r12 = move-exception
            goto L9a
        L9f:
            jb.h r2 = id.c.l(r12)
        La3:
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r5)
            boolean r13 = r2 instanceof jb.h
            if (r13 == 0) goto Lad
            r2 = r12
        Lad:
            java.lang.Number r2 = (java.lang.Number) r2
            long r12 = r2.longValue()
            long r0 = r0 + r10
            r10 = 4096(0x1000, double:2.0237E-320)
            long r10 = java.lang.Math.max(r12, r10)
            long r10 = r10 + r0
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.t.b(long, pb.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0133, code lost:
    
        if (r0 != r7) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0152, code lost:
    
        if (r0 != r7) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0 A[Catch: Exception -> 0x00f9, SQLiteBlobTooBigException -> 0x00fb, TRY_LEAVE, TryCatch #5 {SQLiteBlobTooBigException -> 0x00fb, Exception -> 0x00f9, blocks: (B:37:0x00ba, B:39:0x00c0, B:49:0x00fd, B:36:0x00a5, B:33:0x0087), top: B:72:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd A[Catch: Exception -> 0x00f9, SQLiteBlobTooBigException -> 0x00fb, TRY_ENTER, TRY_LEAVE, TryCatch #5 {SQLiteBlobTooBigException -> 0x00fb, Exception -> 0x00f9, blocks: (B:37:0x00ba, B:39:0x00c0, B:49:0x00fd, B:36:0x00a5, B:33:0x0087), top: B:72:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00e4 -> B:43:0x00ec). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(long r19, long r21, pb.c r23) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.t.c(long, long, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(q8.i r16, pb.c r17) {
        /*
            r15 = this;
            r6 = r16
            r1 = r17
            boolean r2 = r1 instanceof q8.n
            if (r2 == 0) goto L18
            r2 = r1
            q8.n r2 = (q8.n) r2
            int r3 = r2.i
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.i = r3
        L16:
            r5 = r2
            goto L1e
        L18:
            q8.n r2 = new q8.n
            r2.<init>(r15, r1)
            goto L16
        L1e:
            java.lang.Object r1 = r5.f10149g
            ob.a r7 = ob.a.f9351c
            int r2 = r5.i
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L32
            java.lang.String r0 = r5.f10148f
            q8.i r2 = r5.f10147c
            id.c.I(r1)
            r6 = r0
            goto L66
        L32:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r0)
            r0 = 0
            return r0
        L39:
            id.c.I(r1)
            long r1 = r6.f10121a
            java.lang.String r4 = r6.f10122b
            p5.l r8 = r15.f10187b
            java.lang.String r1 = r8.w(r4, r1)
            long r11 = r6.f10121a
            q8.j r4 = new q8.j
            int r9 = r6.f10123c
            int r10 = r6.f10124d
            long r13 = r6.f10125e
            r8 = r4
            r8.<init>(r9, r10, r11, r13)
            r5.f10147c = r6
            r5.f10148f = r1
            r5.i = r3
            r0 = r15
            r3 = r1
            r1 = r11
            java.lang.Object r0 = r0.h(r1, r3, r4, r5)
            if (r0 != r7) goto L64
            return r7
        L64:
            r2 = r6
            r6 = r3
        L66:
            java.lang.String r0 = r2.f10122b
            boolean r0 = yb.k.a(r6, r0)
            if (r0 == 0) goto L6f
            return r2
        L6f:
            long r4 = r2.f10121a
            int r7 = r2.f10123c
            int r8 = r2.f10124d
            long r9 = r2.f10125e
            r6.getClass()
            q8.i r3 = new q8.i
            r3.<init>(r4, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.t.d(q8.i, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(q8.j r23, pb.c r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.t.e(q8.j, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009a -> B:30:0x009b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable f(long r9, long r11, pb.c r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof q8.p
            if (r0 == 0) goto L13
            r0 = r13
            q8.p r0 = (q8.p) r0
            int r1 = r0.f10161l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10161l = r1
            goto L18
        L13:
            q8.p r0 = new q8.p
            r0.<init>(r8, r13)
        L18:
            java.lang.Object r13 = r0.f10159j
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f10161l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L34
            long r9 = r0.f10156f
            long r11 = r0.f10155c
            java.util.ArrayList r2 = r0.i
            java.util.Iterator r4 = r0.f10158h
            java.util.ArrayList r5 = r0.f10157g
            id.c.I(r13)
            goto L9b
        L34:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r8)
            r8 = 0
            return r8
        L3b:
            long r11 = r0.f10156f
            long r9 = r0.f10155c
            id.c.I(r13)     // Catch: java.lang.Exception -> La1
            goto L68
        L43:
            id.c.I(r13)
            q8.h r13 = r8.f10186a     // Catch: java.lang.Exception -> La1
            r0.f10155c = r9     // Catch: java.lang.Exception -> La1
            r0.f10156f = r11     // Catch: java.lang.Exception -> La1
            r0.f10161l = r4     // Catch: java.lang.Exception -> La1
            java.lang.String r2 = "\n        SELECT day_start_millis AS dayStartMillis,\n               ops_count AS opsCount,\n               risks_count AS risksCount,\n               synced_at_millis AS syncedAtMillis\n        FROM dashboard_days\n        WHERE day_start_millis >= ? AND day_start_millis <= ?\n        ORDER BY day_start_millis ASC\n        "
            androidx.room.u r13 = r13.f10119a     // Catch: java.lang.Exception -> La1
            q8.c r5 = new q8.c     // Catch: java.lang.Exception -> La1
            r5.<init>()     // Catch: java.lang.Exception -> La1
            r5.f10109c = r2     // Catch: java.lang.Exception -> La1
            r5.f10110f = r9     // Catch: java.lang.Exception -> La1
            r5.f10111g = r11     // Catch: java.lang.Exception -> La1
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Exception -> La1
            r2 = 0
            java.lang.Object r13 = td.h.B(r13, r0, r5, r4, r2)     // Catch: java.lang.Exception -> La1
            if (r13 != r1) goto L68
            goto L99
        L68:
            java.util.List r13 = (java.util.List) r13     // Catch: java.lang.Exception -> La1
            java.util.ArrayList r2 = new java.util.ArrayList
            int r4 = r13.size()
            r2.<init>(r4)
            java.util.Iterator r13 = r13.iterator()
            r6 = r11
            r11 = r9
            r9 = r6
            r4 = r13
        L7b:
            boolean r13 = r4.hasNext()
            if (r13 == 0) goto La0
            java.lang.Object r13 = r4.next()
            q8.j r13 = (q8.j) r13
            r0.f10157g = r2
            r0.f10158h = r4
            r0.i = r2
            r0.f10155c = r11
            r0.f10156f = r9
            r0.f10161l = r3
            java.lang.Object r13 = r8.e(r13, r0)
            if (r13 != r1) goto L9a
        L99:
            return r1
        L9a:
            r5 = r2
        L9b:
            r2.add(r13)
            r2 = r5
            goto L7b
        La0:
            return r2
        La1:
            r8 = move-exception
            java.lang.String r9 = "DashboardLocal"
            java.lang.String r10 = "inDayRangeMeta failed; return empty"
            android.util.Log.e(r9, r10, r8)
            kb.s r8 = kb.s.f7404c
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.t.f(long, long, pb.c):java.io.Serializable");
    }

    public final Object g(pb.c cVar) {
        androidx.room.u uVar = this.f10186a.f10119a;
        d2.y yVar = new d2.y(23);
        VarHandle.storeStoreFence();
        return td.h.B(uVar, cVar, yVar, true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(long r23, java.lang.String r25, q8.j r26, pb.c r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.t.h(long, java.lang.String, q8.j, pb.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0171, code lost:
    
        r2.f10167c = r8;
        r2.f10168f = null;
        r2.f10169g = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0178, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0179, code lost:
    
        r2.f10175n = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x017c, code lost:
    
        r2.f10179r = 3;
        r0 = r15.f10119a;
        r4 = new d2.y(24);
        java.lang.invoke.VarHandle.storeStoreFence();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x018a, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x018c, code lost:
    
        r0 = td.h.B(r0, r2, r4, true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0190, code lost:
    
        if (r0 != r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0194, code lost:
    
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x019a, code lost:
    
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0171 A[EDGE_INSN: B:135:0x0171->B:57:0x0171 BREAK  A[LOOP:4: B:50:0x0146->B:155:0x0146], EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024e  */
    /* JADX WARN: Type inference failed for: r26v0, types: [q8.t] */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.time.LocalDate] */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.time.LocalDate] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.time.LocalDate] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x0241 -> B:95:0x0247). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(pb.c r27) {
        /*
            Method dump skipped, instructions count: 789
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.t.i(pb.c):java.lang.Object");
    }

    public final long j(LocalDate localDate) {
        localDate.getClass();
        return localDate.atStartOfDay(this.f10188c).toInstant().toEpochMilli();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Type inference failed for: r0v5, types: [jb.h] */
    /* JADX WARN: Type inference failed for: r18v0, types: [q8.t] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(long r19, java.lang.String r21, int r22, int r23, long r24, pb.c r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.t.k(long, java.lang.String, int, int, long, pb.c):java.lang.Object");
    }
}
