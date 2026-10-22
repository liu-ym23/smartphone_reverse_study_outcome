package h3;

import k3.InterfaceC0695j;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class X extends Z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f12835a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12836b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f12837c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f12838d;

    public X(M m4, byte[] bArr, int i4, int i5) {
        this.f12835a = m4;
        this.f12836b = i4;
        this.f12837c = bArr;
        this.f12838d = i5;
    }

    @Override // h3.Z
    public final long contentLength() {
        return this.f12836b;
    }

    @Override // h3.Z
    public final M contentType() {
        return this.f12835a;
    }

    @Override // h3.Z
    public final void writeTo(InterfaceC0695j sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        sink.B(this.f12838d, this.f12836b, this.f12837c);
    }
}
