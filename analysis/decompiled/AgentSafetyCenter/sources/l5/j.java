package l5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements nc.g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7748c;

    /* renamed from: f, reason: collision with root package name */
    public Object f7749f;

    public /* synthetic */ j(int i) {
        this.f7748c = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Type inference failed for: r9v11, types: [pb.i, xb.p] */
    @Override // nc.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(nc.h r10, nb.c r11) throws java.lang.Throwable {
        /*
            r9 = this;
            int r0 = r9.f7748c
            r1 = 0
            jb.v r2 = jb.v.f6774a
            switch(r0) {
                case 0: goto L85;
                case 1: goto L21;
                default: goto L8;
            }
        L8:
            java.lang.Object r9 = r9.f7749f
            nc.n r9 = (nc.n) r9
            u5.j r0 = new u5.j
            r1 = 2
            r0.<init>(r1)
            r0.f14063f = r10
            java.lang.invoke.VarHandle.storeStoreFence()
            java.lang.Object r9 = r9.collect(r0, r11)
            ob.a r10 = ob.a.f9351c
            if (r9 != r10) goto L20
            r2 = r9
        L20:
            return r2
        L21:
            boolean r0 = r11 instanceof nc.a
            if (r0 == 0) goto L34
            r0 = r11
            nc.a r0 = (nc.a) r0
            int r3 = r0.f8817h
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L34
            int r3 = r3 - r4
            r0.f8817h = r3
            goto L39
        L34:
            nc.a r0 = new nc.a
            r0.<init>(r9, r11)
        L39:
            java.lang.Object r11 = r0.f8815f
            ob.a r3 = ob.a.f9351c
            int r4 = r0.f8817h
            r5 = 1
            if (r4 == 0) goto L53
            if (r4 != r5) goto L4d
            oc.u r9 = r0.f8814c
            id.c.I(r11)     // Catch: java.lang.Throwable -> L4a
            goto L74
        L4a:
            r0 = move-exception
            r10 = r0
            goto L81
        L4d:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r9)
            goto L78
        L53:
            id.c.I(r11)
            oc.u r11 = new oc.u
            nb.g r1 = r0.getContext()
            r11.<init>(r10, r1)
            r0.f8814c = r11     // Catch: java.lang.Throwable -> L7e
            r0.f8817h = r5     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r9 = r9.f7749f     // Catch: java.lang.Throwable -> L79
            pb.i r9 = (pb.i) r9     // Catch: java.lang.Throwable -> L79
            java.lang.Object r9 = r9.invoke(r11, r0)     // Catch: java.lang.Throwable -> L79
            if (r9 != r3) goto L6e
            goto L6f
        L6e:
            r9 = r2
        L6f:
            if (r9 != r3) goto L73
            r1 = r3
            goto L78
        L73:
            r9 = r11
        L74:
            r9.releaseIntercepted()
            r1 = r2
        L78:
            return r1
        L79:
            r0 = move-exception
            r9 = r0
            r10 = r9
        L7c:
            r9 = r11
            goto L81
        L7e:
            r0 = move-exception
            r10 = r0
            goto L7c
        L81:
            r9.releaseIntercepted()
            throw r10
        L85:
            java.lang.Object r9 = r9.f7749f
            r4 = r9
            nc.g[] r4 = (nc.g[]) r4
            ad.l r5 = new ad.l
            r9 = 14
            r5.<init>(r4, r9)
            l5.i r6 = new l5.i
            r9 = 3
            r6.<init>(r9, r1)
            oc.o r3 = new oc.o
            r8 = 0
            r7 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            oc.q r9 = new oc.q
            nb.g r10 = r11.getContext()
            r9.<init>(r11, r10)
            java.lang.Object r9 = ac.a.Y(r9, r9, r3)
            ob.a r10 = ob.a.f9351c
            if (r9 != r10) goto Lb0
            goto Lb1
        Lb0:
            r9 = r2
        Lb1:
            if (r9 != r10) goto Lb4
            r2 = r9
        Lb4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.j.collect(nc.h, nb.c):java.lang.Object");
    }
}
