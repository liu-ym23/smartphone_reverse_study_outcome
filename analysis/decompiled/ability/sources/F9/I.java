package F9;

/* loaded from: classes4.dex */
public final class I extends K {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f628a;
    public final /* synthetic */ int b;
    public final /* synthetic */ byte[] c;
    public final /* synthetic */ int d;

    public I(B b, byte[] bArr, int i, int i6) {
        this.f628a = b;
        this.b = i;
        this.c = bArr;
        this.d = i6;
    }

    @Override // F9.K
    public final long contentLength() {
        return this.b;
    }

    @Override // F9.K
    public final B contentType() {
        return this.f628a;
    }

    @Override // F9.K
    public final void writeTo(V9.h sink) {
        kotlin.jvm.internal.k.f(sink, "sink");
        sink.write(this.c, this.d, this.b);
    }
}
