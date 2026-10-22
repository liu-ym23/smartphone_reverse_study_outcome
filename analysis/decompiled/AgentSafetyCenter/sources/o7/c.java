package o7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends m7.n {

    /* renamed from: a, reason: collision with root package name */
    public volatile m7.n f9241a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ boolean f9242b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f9243c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ m7.e f9244d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ t7.a f9245e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ d f9246f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0084 A[SYNTHETIC] */
    @Override // m7.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object read(u7.a r10) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r9.f9242b
            if (r0 == 0) goto L9
            r10.e0()
        L7:
            r9 = 0
            return r9
        L9:
            m7.n r0 = r9.f9241a
            if (r0 != 0) goto L94
            m7.e r0 = r9.f9244d
            o7.d r1 = r9.f9246f
            t7.a r2 = r9.f9245e
            p7.l r3 = r0.f8257d
            r3.getClass()
            java.util.concurrent.ConcurrentHashMap r4 = r3.f9879f
            p7.k r5 = p7.l.f9877g
            r6 = 1
            if (r1 != r5) goto L20
            goto L62
        L20:
            java.lang.Class r5 = r2.getRawType()
            java.lang.Object r7 = r4.get(r5)
            m7.o r7 = (m7.o) r7
            if (r7 == 0) goto L2f
            if (r7 != r1) goto L63
            goto L62
        L2f:
            java.lang.Class<n7.a> r7 = n7.a.class
            java.lang.annotation.Annotation r7 = r5.getAnnotation(r7)
            n7.a r7 = (n7.a) r7
            if (r7 != 0) goto L3a
            goto L63
        L3a:
            java.lang.Class r7 = r7.value()
            java.lang.Class<m7.o> r8 = m7.o.class
            boolean r8 = r8.isAssignableFrom(r7)
            if (r8 != 0) goto L47
            goto L63
        L47:
            p5.c r8 = r3.f9878c
            t7.a r7 = t7.a.get(r7)
            o7.o r7 = r8.k(r7, r6)
            java.lang.Object r7 = r7.b()
            m7.o r7 = (m7.o) r7
            java.lang.Object r4 = r4.putIfAbsent(r5, r7)
            m7.o r4 = (m7.o) r4
            if (r4 == 0) goto L60
            r7 = r4
        L60:
            if (r7 != r1) goto L63
        L62:
            r1 = r3
        L63:
            java.util.List r3 = r0.f8258e
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
        L6a:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L84
            java.lang.Object r5 = r3.next()
            m7.o r5 = (m7.o) r5
            if (r4 != 0) goto L7c
            if (r5 != r1) goto L6a
            r4 = r6
            goto L6a
        L7c:
            m7.n r5 = r5.a(r0, r2)
            if (r5 == 0) goto L6a
            r0 = r5
            goto L8a
        L84:
            if (r4 != 0) goto L8d
            m7.n r0 = r0.c(r2)
        L8a:
            r9.f9241a = r0
            goto L94
        L8d:
            java.lang.String r9 = "GSON cannot serialize or deserialize "
            g5.f.p(r2, r9)
            goto L7
        L94:
            java.lang.Object r9 = r0.read(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.c.read(u7.a):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083 A[SYNTHETIC] */
    @Override // m7.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void write(u7.c r10, java.lang.Object r11) {
        /*
            r9 = this;
            boolean r0 = r9.f9243c
            if (r0 == 0) goto L8
            r10.C()
            return
        L8:
            m7.n r0 = r9.f9241a
            if (r0 != 0) goto L92
            m7.e r0 = r9.f9244d
            o7.d r1 = r9.f9246f
            t7.a r2 = r9.f9245e
            p7.l r3 = r0.f8257d
            r3.getClass()
            java.util.concurrent.ConcurrentHashMap r4 = r3.f9879f
            p7.k r5 = p7.l.f9877g
            r6 = 1
            if (r1 != r5) goto L1f
            goto L61
        L1f:
            java.lang.Class r5 = r2.getRawType()
            java.lang.Object r7 = r4.get(r5)
            m7.o r7 = (m7.o) r7
            if (r7 == 0) goto L2e
            if (r7 != r1) goto L62
            goto L61
        L2e:
            java.lang.Class<n7.a> r7 = n7.a.class
            java.lang.annotation.Annotation r7 = r5.getAnnotation(r7)
            n7.a r7 = (n7.a) r7
            if (r7 != 0) goto L39
            goto L62
        L39:
            java.lang.Class r7 = r7.value()
            java.lang.Class<m7.o> r8 = m7.o.class
            boolean r8 = r8.isAssignableFrom(r7)
            if (r8 != 0) goto L46
            goto L62
        L46:
            p5.c r8 = r3.f9878c
            t7.a r7 = t7.a.get(r7)
            o7.o r7 = r8.k(r7, r6)
            java.lang.Object r7 = r7.b()
            m7.o r7 = (m7.o) r7
            java.lang.Object r4 = r4.putIfAbsent(r5, r7)
            m7.o r4 = (m7.o) r4
            if (r4 == 0) goto L5f
            r7 = r4
        L5f:
            if (r7 != r1) goto L62
        L61:
            r1 = r3
        L62:
            java.util.List r3 = r0.f8258e
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
        L69:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L83
            java.lang.Object r5 = r3.next()
            m7.o r5 = (m7.o) r5
            if (r4 != 0) goto L7b
            if (r5 != r1) goto L69
            r4 = r6
            goto L69
        L7b:
            m7.n r5 = r5.a(r0, r2)
            if (r5 == 0) goto L69
            r0 = r5
            goto L89
        L83:
            if (r4 != 0) goto L8c
            m7.n r0 = r0.c(r2)
        L89:
            r9.f9241a = r0
            goto L92
        L8c:
            java.lang.String r9 = "GSON cannot serialize or deserialize "
            g5.f.p(r2, r9)
            return
        L92:
            r0.write(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.c.write(u7.c, java.lang.Object):void");
    }
}
