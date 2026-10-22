package A2;

import java.io.OutputStream;

/* renamed from: A2.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0611g extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f670a = 0;

    public final long b() {
        return this.f670a;
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        this.f670a++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f670a += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        int length;
        int i12;
        if (i10 >= 0 && i10 <= (length = bArr.length) && i11 >= 0 && (i12 = i10 + i11) <= length && i12 >= 0) {
            this.f670a += i11;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
