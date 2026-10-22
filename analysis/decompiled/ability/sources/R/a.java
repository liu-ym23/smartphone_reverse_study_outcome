package R;

/* loaded from: classes2.dex */
public final class a implements T.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1132a;
    public final /* synthetic */ V.a b;
    public final /* synthetic */ b c;

    public /* synthetic */ a(b bVar, V.a aVar, int i) {
        this.f1132a = i;
        this.c = bVar;
        this.b = aVar;
    }

    @Override // T.c
    public final void a(cc.dd.dd.cc.dd.dd.c cVar) throws NumberFormatException {
        switch (this.f1132a) {
            case 0:
                V.a aVar = this.b;
                if (!aVar.b()) {
                    b bVar = this.c;
                    long contentLength = bVar.f1133a.getContentLength();
                    long j5 = cVar.f2133a;
                    if (contentLength < 0) {
                        contentLength = j5;
                    }
                    aVar.a(contentLength);
                    bVar.b(aVar);
                    break;
                }
                break;
            default:
                V.a aVar2 = this.b;
                if (!aVar2.b()) {
                    b bVar2 = this.c;
                    String requestProperty = bVar2.f1133a.getRequestProperty("content-length");
                    long j6 = cVar.f2133a;
                    if (requestProperty != null) {
                        try {
                            j6 = Long.parseLong(requestProperty);
                        } catch (NumberFormatException unused) {
                        }
                    }
                    aVar2.c(j6);
                    bVar2.b(aVar2);
                    break;
                }
                break;
        }
    }

    @Override // T.c
    public final void b(cc.dd.dd.cc.dd.dd.c cVar) {
        switch (this.f1132a) {
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
