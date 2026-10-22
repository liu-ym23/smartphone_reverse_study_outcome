package V9;

/* loaded from: classes4.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1426a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public s f;
    public s g;

    public s() {
        this.f1426a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final s a() {
        s sVar = this.f;
        if (sVar == this) {
            sVar = null;
        }
        s sVar2 = this.g;
        kotlin.jvm.internal.k.c(sVar2);
        sVar2.f = this.f;
        s sVar3 = this.f;
        kotlin.jvm.internal.k.c(sVar3);
        sVar3.g = this.g;
        this.f = null;
        this.g = null;
        return sVar;
    }

    public final void b(s segment) {
        kotlin.jvm.internal.k.f(segment, "segment");
        segment.g = this;
        segment.f = this.f;
        s sVar = this.f;
        kotlin.jvm.internal.k.c(sVar);
        sVar.g = segment;
        this.f = segment;
    }

    public final s c() {
        this.d = true;
        return new s(this.f1426a, this.b, this.c, true);
    }

    public final void d(s sink, int i) {
        kotlin.jvm.internal.k.f(sink, "sink");
        byte[] bArr = sink.f1426a;
        if (!sink.e) {
            throw new IllegalStateException("only owner can write");
        }
        int i6 = sink.c;
        int i10 = i6 + i;
        if (i10 > 8192) {
            if (sink.d) {
                throw new IllegalArgumentException();
            }
            int i11 = sink.b;
            if (i10 - i11 > 8192) {
                throw new IllegalArgumentException();
            }
            D7.q.S(bArr, 0, i11, bArr, i6);
            sink.c -= sink.b;
            sink.b = 0;
        }
        int i12 = sink.c;
        int i13 = this.b;
        D7.q.S(this.f1426a, i12, i13, bArr, i13 + i);
        sink.c += i;
        this.b += i;
    }

    public s(byte[] data, int i, int i6, boolean z10) {
        kotlin.jvm.internal.k.f(data, "data");
        this.f1426a = data;
        this.b = i;
        this.c = i6;
        this.d = z10;
        this.e = false;
    }
}
