package g9;

import android.content.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4601c;

    /* renamed from: f, reason: collision with root package name */
    public int f4602f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ xb.a f4603g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Context f4604h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(xb.a aVar, Context context, nb.c cVar, int i) {
        super(2, cVar);
        this.f4601c = i;
        this.f4603g = aVar;
        this.f4604h = context;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f4601c) {
            case 0:
                return new r(this.f4603g, this.f4604h, cVar, 0);
            default:
                return new r(this.f4603g, this.f4604h, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f4601c) {
        }
        return ((r) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a4, code lost:
    
        if (r0 == r15) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x014c, code lost:
    
        if (r0 == r6) goto L46;
     */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.r.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
