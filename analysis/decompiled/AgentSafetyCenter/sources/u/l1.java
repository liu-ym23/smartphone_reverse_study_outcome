package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l1 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f13522a = new b0(3, null, 2);

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c A[LOOP:0: B:19:0x004a->B:20:0x004c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003d -> B:18:0x0040). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(o1.h0 r8, pb.a r9) {
        /*
            boolean r0 = r9 instanceof u.c1
            if (r0 == 0) goto L13
            r0 = r9
            u.c1 r0 = (u.c1) r0
            int r1 = r0.f13436g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13436g = r1
            goto L18
        L13:
            u.c1 r0 = new u.c1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f13435f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f13436g
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L29
            o1.h0 r8 = r0.f13434c
            id.c.I(r9)
            goto L40
        L29:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r8)
            r8 = 0
            return r8
        L30:
            id.c.I(r9)
        L33:
            r0.f13434c = r8
            r0.f13436g = r3
            o1.k r9 = o1.k.f9060f
            java.lang.Object r9 = r8.b(r9, r0)
            if (r9 != r1) goto L40
            return r1
        L40:
            o1.j r9 = (o1.j) r9
            java.lang.Object r2 = r9.f9056a
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L4a:
            if (r6 >= r4) goto L58
            java.lang.Object r7 = r2.get(r6)
            o1.s r7 = (o1.s) r7
            r7.a()
            int r6 = r6 + 1
            goto L4a
        L58:
            java.lang.Object r9 = r9.f9056a
            int r2 = r9.size()
        L5e:
            if (r5 >= r2) goto L6e
            java.lang.Object r4 = r9.get(r5)
            o1.s r4 = (o1.s) r4
            boolean r4 = r4.f9074d
            if (r4 == 0) goto L6b
            goto L33
        L6b:
            int r5 = r5 + 1
            goto L5e
        L6e:
            jb.v r8 = jb.v.f6774a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: u.l1.a(o1.h0, pb.a):java.lang.Object");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0047 -> B:18:0x004a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(o1.h0 r10, boolean r11, o1.k r12, pb.a r13) {
        /*
            boolean r0 = r13 instanceof u.a1
            if (r0 == 0) goto L13
            r0 = r13
            u.a1 r0 = (u.a1) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            u.a1 r0 = new u.a1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f13425h
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L31
            boolean r10 = r0.f13424g
            o1.k r11 = r0.f13423f
            o1.h0 r12 = r0.f13422c
            id.c.I(r13)
            r9 = r11
            r11 = r10
            r10 = r12
            r12 = r9
            goto L4a
        L31:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            r10 = 0
            return r10
        L38:
            id.c.I(r13)
        L3b:
            r0.f13422c = r10
            r0.f13423f = r12
            r0.f13424g = r11
            r0.i = r3
            java.lang.Object r13 = r10.b(r12, r0)
            if (r13 != r1) goto L4a
            return r1
        L4a:
            o1.j r13 = (o1.j) r13
            java.lang.Object r2 = r13.f9056a
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L54:
            if (r6 >= r4) goto L7b
            java.lang.Object r7 = r2.get(r6)
            o1.s r7 = (o1.s) r7
            if (r11 == 0) goto L70
            boolean r8 = r7.b()
            if (r8 != 0) goto L6e
            boolean r8 = r7.f9078h
            if (r8 != 0) goto L6e
            boolean r7 = r7.f9074d
            if (r7 == 0) goto L6e
            r7 = r3
            goto L74
        L6e:
            r7 = r5
            goto L74
        L70:
            boolean r7 = o1.q.a(r7)
        L74:
            if (r7 != 0) goto L78
            r2 = r5
            goto L7c
        L78:
            int r6 = r6 + 1
            goto L54
        L7b:
            r2 = r3
        L7c:
            if (r2 == 0) goto L3b
            java.lang.Object r10 = r13.f9056a
            java.lang.Object r10 = r10.get(r5)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: u.l1.b(o1.h0, boolean, o1.k, pb.a):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0112 -> B:42:0x0117). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(o1.h0 r21, o1.k r22, pb.a r23) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.l1.d(o1.h0, o1.k, pb.a):java.lang.Object");
    }
}
