package cb;

import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3334a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f3335b;

    public /* synthetic */ h(i iVar, int i10) {
        this.f3334a = i10;
        this.f3335b = iVar;
    }

    @Override // zb.a
    public final Object invoke() throws IOException {
        int i10 = this.f3334a;
        i iVar = this.f3335b;
        switch (i10) {
            case 0:
                try {
                    iVar.f3340e.close();
                } catch (Exception e10) {
                    iVar.f3341f.b("exception occurred whiles shutting down Fetch with namespace:" + iVar.f3336a, e10);
                }
                break;
            default:
                iVar.f3340e.t0();
                break;
        }
        return lb.n.f10413a;
    }
}
