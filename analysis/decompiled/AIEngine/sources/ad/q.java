package ad;

import sd.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q extends s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f168a;

    public q(s sVar) {
        this.f168a = sVar;
    }

    @Override // ad.s
    public final long contentLength() {
        return -1L;
    }

    @Override // ad.s
    public final l contentType() {
        return this.f168a.contentType();
    }

    @Override // ad.s
    public final boolean isOneShot() {
        return this.f168a.isOneShot();
    }

    @Override // ad.s
    public final void writeTo(sd.g sink) {
        kotlin.jvm.internal.g.f(sink, "sink");
        y yVarI = jd.b.i(new sd.p(sink));
        try {
            this.f168a.writeTo(yVarI);
            lb.n nVar = lb.n.f10413a;
            yVarI.close();
        } finally {
        }
    }
}
