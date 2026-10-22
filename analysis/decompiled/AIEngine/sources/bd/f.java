package bd;

import ad.s;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ad.l f3225a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ByteString f3226b;

    public f(ad.l lVar, ByteString byteString) {
        this.f3225a = lVar;
        this.f3226b = byteString;
    }

    @Override // ad.s
    public final long contentLength() {
        return this.f3226b.d();
    }

    @Override // ad.s
    public final ad.l contentType() {
        return this.f3225a;
    }

    @Override // ad.s
    public final void writeTo(sd.g sink) {
        kotlin.jvm.internal.g.f(sink, "sink");
        sink.z0(this.f3226b);
    }
}
