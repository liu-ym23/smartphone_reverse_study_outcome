package m8;

import com.stepos.agentsafetycenter.ledger.LedgerProvider;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8363c = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f8364f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f8365g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f8366h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(String str, LedgerProvider ledgerProvider, boolean z10, nb.c cVar) {
        super(2, cVar);
        this.f8365g = str;
        this.i = ledgerProvider;
        this.f8366h = z10;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8363c) {
            case 0:
                return new g0((k0) this.i, this.f8366h, this.f8365g, cVar);
            default:
                return new g0(this.f8365g, (LedgerProvider) this.i, this.f8366h, cVar);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f8363c) {
        }
        return ((g0) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b2, code lost:
    
        if (r12 == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012e, code lost:
    
        if (m8.k0.f(r12, r11) == r3) goto L53;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.g0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(k0 k0Var, boolean z10, String str, nb.c cVar) {
        super(2, cVar);
        this.i = k0Var;
        this.f8366h = z10;
        this.f8365g = str;
    }
}
