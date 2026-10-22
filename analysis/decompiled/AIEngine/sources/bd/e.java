package bd;

import ad.s;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ad.l f3221a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3222b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f3223c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3224d;

    public e(ad.l lVar, byte[] bArr, int i10, int i11) {
        this.f3221a = lVar;
        this.f3222b = i10;
        this.f3223c = bArr;
        this.f3224d = i11;
    }

    @Override // ad.s
    public final long contentLength() {
        return this.f3222b;
    }

    @Override // ad.s
    public final ad.l contentType() {
        return this.f3221a;
    }

    @Override // ad.s
    public final void writeTo(sd.g sink) {
        kotlin.jvm.internal.g.f(sink, "sink");
        sink.write(this.f3223c, this.f3224d, this.f3222b);
    }
}
