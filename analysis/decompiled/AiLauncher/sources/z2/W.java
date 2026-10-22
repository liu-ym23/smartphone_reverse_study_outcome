package z2;

import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class W extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f44931a = 0;

    public final long b() {
        return this.f44931a;
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        this.f44931a++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f44931a += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        int length;
        int i12;
        if (i10 >= 0 && i10 <= (length = bArr.length) && i11 >= 0 && (i12 = i10 + i11) <= length && i12 >= 0) {
            this.f44931a += i11;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
