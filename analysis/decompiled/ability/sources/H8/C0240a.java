package H8;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: H8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0240a extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f767a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0240a(InputStream inputStream, int i, int i6) {
        super(inputStream);
        this.f767a = i6;
        this.b = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        switch (this.f767a) {
        }
        return Math.min(super.available(), this.b);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        switch (this.f767a) {
            case 0:
                if (this.b <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i >= 0) {
                    this.b--;
                }
                return i;
            default:
                if (this.b <= 0) {
                    return -1;
                }
                int i6 = super.read();
                if (i6 >= 0) {
                    this.b--;
                }
                return i6;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j5) throws IOException {
        switch (this.f767a) {
            case 0:
                long jSkip = super.skip(Math.min(j5, this.b));
                if (jSkip >= 0) {
                    this.b = (int) (this.b - jSkip);
                }
                return jSkip;
            default:
                int iSkip = (int) super.skip(Math.min(j5, this.b));
                if (iSkip >= 0) {
                    this.b -= iSkip;
                }
                return iSkip;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) throws IOException {
        switch (this.f767a) {
            case 0:
                int i10 = this.b;
                if (i10 <= 0) {
                    return -1;
                }
                int i11 = super.read(bArr, i, Math.min(i6, i10));
                if (i11 >= 0) {
                    this.b -= i11;
                }
                return i11;
            default:
                int i12 = this.b;
                if (i12 <= 0) {
                    return -1;
                }
                int i13 = super.read(bArr, i, Math.min(i6, i12));
                if (i13 >= 0) {
                    this.b -= i13;
                }
                return i13;
        }
    }
}
