package g4;

import i5.l;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import t3.k;
import t3.o;

/* loaded from: classes.dex */
public final class b extends InputStream {

    /* renamed from: f, reason: collision with root package name */
    public boolean f3839f;

    /* renamed from: g, reason: collision with root package name */
    public InputStream f3840g;

    /* renamed from: h, reason: collision with root package name */
    public InputStream f3841h;

    /* renamed from: i, reason: collision with root package name */
    public l f3842i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f3843j;

    @Override // java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream = this.f3840g;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f3841h.close();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) != 1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] bArr, int i2, int i10) {
        if (i10 == 0) {
            return 0;
        }
        InputStream inputStream = this.f3840g;
        if (inputStream != null) {
            return inputStream.read(bArr, i2, i10);
        }
        if (!this.f3839f) {
            this.f3839f = true;
            Iterator it = this.f3842i.B(t3.b.f9705a).iterator();
            while (it.hasNext()) {
                try {
                    try {
                        InputStream inputStreamA = ((o) ((k) it.next()).f9718b).a(this.f3841h, this.f3843j);
                        int i11 = inputStreamA.read(bArr, i2, i10);
                        if (i11 != 0) {
                            this.f3840g = inputStreamA;
                            this.f3841h.mark(0);
                            return i11;
                        }
                        throw new IOException("Could not read bytes from the ciphertext stream");
                    } catch (IOException unused) {
                        this.f3841h.reset();
                    }
                } catch (GeneralSecurityException unused2) {
                    this.f3841h.reset();
                }
            }
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
    }
}
