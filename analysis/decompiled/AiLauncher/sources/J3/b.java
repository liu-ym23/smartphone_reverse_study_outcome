package J3;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3709a;

    /* renamed from: b, reason: collision with root package name */
    public int f3710b = 0;

    public b(int i10) {
        this.f3709a = new byte[i10];
    }

    public void a(boolean z10, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f3710b;
            this.f3710b = i12 + 1;
            c(i12, z10);
        }
    }

    public byte[] b(int i10) {
        int length = this.f3709a.length * i10;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = this.f3709a[i11 / i10];
        }
        return bArr;
    }

    public final void c(int i10, boolean z10) {
        this.f3709a[i10] = z10 ? (byte) 1 : (byte) 0;
    }
}
