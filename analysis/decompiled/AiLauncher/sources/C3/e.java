package C3;

/* loaded from: classes2.dex */
public final class e extends g {

    /* renamed from: c, reason: collision with root package name */
    public final short f1716c;

    /* renamed from: d, reason: collision with root package name */
    public final short f1717d;

    public e(g gVar, int i10, int i11) {
        super(gVar);
        this.f1716c = (short) i10;
        this.f1717d = (short) i11;
    }

    @Override // C3.g
    public void c(D3.a aVar, byte[] bArr) {
        aVar.f(this.f1716c, this.f1717d);
    }

    public String toString() {
        short s10 = this.f1716c;
        short s11 = this.f1717d;
        return '<' + Integer.toBinaryString((1 << this.f1717d) | (s10 & ((1 << s11) - 1)) | (1 << s11)).substring(1) + '>';
    }
}
