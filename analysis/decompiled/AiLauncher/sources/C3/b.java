package C3;

/* loaded from: classes2.dex */
public final class b extends g {

    /* renamed from: c, reason: collision with root package name */
    public final int f1706c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1707d;

    public b(g gVar, int i10, int i11) {
        super(gVar);
        this.f1706c = i10;
        this.f1707d = i11;
    }

    @Override // C3.g
    public void c(D3.a aVar, byte[] bArr) {
        int i10 = this.f1707d;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 == 0 || (i11 == 31 && i10 <= 62)) {
                aVar.f(31, 5);
                if (i10 > 62) {
                    aVar.f(i10 - 31, 16);
                } else if (i11 == 0) {
                    aVar.f(Math.min(i10, 31), 5);
                } else {
                    aVar.f(i10 - 31, 5);
                }
            }
            aVar.f(bArr[this.f1706c + i11], 8);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(this.f1706c);
        sb2.append("::");
        sb2.append((this.f1706c + this.f1707d) - 1);
        sb2.append('>');
        return sb2.toString();
    }
}
