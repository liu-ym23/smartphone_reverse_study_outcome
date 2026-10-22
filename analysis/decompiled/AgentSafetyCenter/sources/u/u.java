package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final float f13592a = ((float) 0.125d) / 18;

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00be, code lost:
    
        if (c1.b.c(o1.q.d(r11, true), 0) == false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005f -> B:22:0x0064). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(o1.h0 r17, long r18, pb.c r20) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.u.a(o1.h0, long, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(o1.h0 r4, long r5, xb.l r7, pb.a r8) {
        /*
            boolean r0 = r8 instanceof u.t
            if (r0 == 0) goto L13
            r0 = r8
            u.t r0 = (u.t) r0
            int r1 = r0.f13585h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13585h = r1
            goto L18
        L13:
            u.t r0 = new u.t
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f13584g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f13585h
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2d
            xb.l r4 = r0.f13583f
            o1.h0 r5 = r0.f13582c
            id.c.I(r8)
            r7 = r4
            r4 = r5
            goto L44
        L2d:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L34:
            id.c.I(r8)
        L37:
            r0.f13582c = r4
            r0.f13583f = r7
            r0.f13585h = r3
            java.lang.Object r8 = a(r4, r5, r0)
            if (r8 != r1) goto L44
            return r1
        L44:
            o1.s r8 = (o1.s) r8
            if (r8 != 0) goto L4b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L4b:
            boolean r5 = o1.q.b(r8)
            if (r5 == 0) goto L54
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        L54:
            r7.invoke(r8)
            long r5 = r8.f9071a
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: u.u.b(o1.h0, long, xb.l, pb.a):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, java.util.List] */
    public static final boolean c(o1.j jVar, long j10) {
        Object obj;
        ?? r62 = jVar.f9056a;
        int size = r62.size();
        boolean z10 = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = r62.get(i);
            if (o1.r.a(((o1.s) obj).f9071a, j10)) {
                break;
            }
            i++;
        }
        o1.s sVar = (o1.s) obj;
        if (sVar != null && sVar.f9074d) {
            z10 = true;
        }
        return true ^ z10;
    }
}
