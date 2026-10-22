package y4;

import o4.k0;

/* loaded from: classes.dex */
public final class k extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11589f;

    /* renamed from: g, reason: collision with root package name */
    public int f11590g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ m f11591h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ k0 f11592i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(m mVar, k0 k0Var, g7.d dVar, int i2) {
        super(2, dVar);
        this.f11589f = i2;
        this.f11591h = mVar;
        this.f11592i = k0Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f11589f) {
            case 0:
                return new k(this.f11591h, this.f11592i, dVar, 0);
            default:
                return new k(this.f11591h, this.f11592i, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f11589f) {
        }
        return ((k) create(str, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0208 A[Catch: all -> 0x020d, TryCatch #5 {all -> 0x020d, blocks: (B:107:0x01e0, B:109:0x0208, B:113:0x0212, B:115:0x0249, B:119:0x0258, B:122:0x0263, B:124:0x0273, B:133:0x0280, B:130:0x027b, B:131:0x027e, B:120:0x025d, B:139:0x0289, B:140:0x028c, B:114:0x0232, B:123:0x026f, B:137:0x0287, B:128:0x0279), top: B:159:0x01e0, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x025d A[Catch: all -> 0x020d, TryCatch #5 {all -> 0x020d, blocks: (B:107:0x01e0, B:109:0x0208, B:113:0x0212, B:115:0x0249, B:119:0x0258, B:122:0x0263, B:124:0x0273, B:133:0x0280, B:130:0x027b, B:131:0x027e, B:120:0x025d, B:139:0x0289, B:140:0x028c, B:114:0x0232, B:123:0x026f, B:137:0x0287, B:128:0x0279), top: B:159:0x01e0, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0263 A[Catch: all -> 0x020d, TRY_LEAVE, TryCatch #5 {all -> 0x020d, blocks: (B:107:0x01e0, B:109:0x0208, B:113:0x0212, B:115:0x0249, B:119:0x0258, B:122:0x0263, B:124:0x0273, B:133:0x0280, B:130:0x027b, B:131:0x027e, B:120:0x025d, B:139:0x0289, B:140:0x028c, B:114:0x0232, B:123:0x026f, B:137:0x0287, B:128:0x0279), top: B:159:0x01e0, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019f  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
