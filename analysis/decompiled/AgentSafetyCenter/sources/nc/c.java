package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends oc.e {

    /* renamed from: h, reason: collision with root package name */
    public final pb.i f8827h;
    public final pb.i i;

    /* JADX WARN: Multi-variable type inference failed */
    public c(xb.p pVar, nb.g gVar, int i, mc.a aVar) {
        super(gVar, i, aVar);
        pb.i iVar = (pb.i) pVar;
        this.f8827h = iVar;
        this.i = iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v1, types: [pb.i, xb.p] */
    @Override // oc.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(mc.r r6, nb.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof nc.b
            if (r0 == 0) goto L13
            r0 = r7
            nc.b r0 = (nc.b) r0
            int r1 = r0.f8822h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8822h = r1
            goto L1a
        L13:
            nc.b r0 = new nc.b
            pb.c r7 = (pb.c) r7
            r0.<init>(r5, r7)
        L1a:
            java.lang.Object r7 = r0.f8820f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8822h
            jb.v r3 = jb.v.f6774a
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2d
            mc.r r6 = r0.f8819c
            id.c.I(r7)
            goto L48
        L2d:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
        L32:
            r5 = 0
            return r5
        L34:
            id.c.I(r7)
            r0.f8819c = r6
            r0.f8822h = r4
            pb.i r5 = r5.f8827h
            java.lang.Object r5 = r5.invoke(r6, r0)
            if (r5 != r1) goto L44
            goto L45
        L44:
            r5 = r3
        L45:
            if (r5 != r1) goto L48
            return r1
        L48:
            mc.e r5 = r6.f8603h
            boolean r5 = r5.x()
            if (r5 == 0) goto L51
            return r3
        L51:
            java.lang.String r5 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            od.f.e(r5)
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.c.b(mc.r, nb.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [pb.i, xb.p] */
    @Override // oc.e
    public final oc.e c(nb.g gVar, int i, mc.a aVar) {
        return new c(this.i, gVar, i, aVar);
    }

    @Override // oc.e
    public final String toString() {
        return "block[" + this.f8827h + "] -> " + super.toString();
    }
}
