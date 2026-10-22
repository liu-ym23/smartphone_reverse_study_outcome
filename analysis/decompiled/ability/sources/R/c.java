package R;

/* loaded from: classes2.dex */
public final class c implements T.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1134a;
    public final /* synthetic */ V.a b;
    public final /* synthetic */ d c;

    public /* synthetic */ c(d dVar, V.a aVar, int i) {
        this.f1134a = i;
        this.c = dVar;
        this.b = aVar;
    }

    @Override // T.c
    public final void a(cc.dd.dd.cc.dd.dd.c cVar) throws NumberFormatException {
        switch (this.f1134a) {
            case 0:
                V.a aVar = this.b;
                if (!aVar.b()) {
                    d dVar = this.c;
                    long contentLength = dVar.f1135a.getContentLength();
                    long j5 = cVar.f2133a;
                    if (contentLength < 0) {
                        contentLength = j5;
                    }
                    aVar.a(contentLength);
                    dVar.b(aVar);
                    break;
                }
                break;
            default:
                V.a aVar2 = this.b;
                if (!aVar2.b()) {
                    d dVar2 = this.c;
                    String requestProperty = dVar2.f1135a.getRequestProperty("content-length");
                    long j6 = cVar.f2133a;
                    if (requestProperty != null) {
                        try {
                            j6 = Long.parseLong(requestProperty);
                        } catch (NumberFormatException unused) {
                        }
                    }
                    aVar2.c(j6);
                    dVar2.b(aVar2);
                    break;
                }
                break;
        }
    }

    @Override // T.c
    public final void b(cc.dd.dd.cc.dd.dd.c cVar) {
        switch (this.f1134a) {
            case 0:
                V.a aVar = this.b;
                if (!aVar.b()) {
                    aVar.a(cVar.f2133a);
                }
                this.c.c(cVar.b);
                break;
            default:
                V.a aVar2 = this.b;
                if (!aVar2.b()) {
                    aVar2.c(cVar.f2133a);
                }
                this.c.c(cVar.b);
                break;
        }
    }
}
