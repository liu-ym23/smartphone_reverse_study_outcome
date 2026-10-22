package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b1 extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public long f13427f;

    /* renamed from: g, reason: collision with root package name */
    public int f13428g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f13429h;
    public final /* synthetic */ o1.s i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(o1.s sVar, nb.c cVar) {
        super(cVar);
        this.i = sVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        b1 b1Var = new b1(this.i, cVar);
        b1Var.f13429h = obj;
        return b1Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((b1) create((o1.h0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003c -> B:12:0x003f). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            ob.a r0 = ob.a.f9351c
            int r1 = r7.f13428g
            r2 = 1
            if (r1 == 0) goto L1a
            if (r1 != r2) goto L13
            long r3 = r7.f13427f
            java.lang.Object r1 = r7.f13429h
            o1.h0 r1 = (o1.h0) r1
            id.c.I(r8)
            goto L3f
        L13:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            r7 = 0
            return r7
        L1a:
            id.c.I(r8)
            java.lang.Object r8 = r7.f13429h
            o1.h0 r8 = (o1.h0) r8
            o1.s r1 = r7.i
            long r3 = r1.f9072b
            v1.u1 r1 = r8.c()
            r1.getClass()
            r5 = 40
            long r5 = r5 + r3
            r1 = r8
            r3 = r5
        L31:
            r7.f13429h = r1
            r7.f13427f = r3
            r7.f13428g = r2
            r8 = 3
            java.lang.Object r8 = u.l1.c(r1, r7, r8)
            if (r8 != r0) goto L3f
            return r0
        L3f:
            o1.s r8 = (o1.s) r8
            long r5 = r8.f9072b
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 < 0) goto L31
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: u.b1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
