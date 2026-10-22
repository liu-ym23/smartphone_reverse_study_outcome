package u5;

import d5.u;
import ia.b0;

/* loaded from: classes.dex */
public final class p extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public u f10154f;

    /* renamed from: g, reason: collision with root package name */
    public int f10155g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s f10156h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c5.b f10157i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(s sVar, c5.b bVar, g7.d dVar) {
        super(2, dVar);
        this.f10156h = sVar;
        this.f10157i = bVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new p(this.f10156h, this.f10157i, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((p) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
    
        if (r7 == r0) goto L15;
     */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws ia.k0 {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.p.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
