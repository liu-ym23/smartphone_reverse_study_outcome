package Y6;

import a.AbstractC0291a;
import a7.f;
import com.volcengine.tos.TosClientException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

/* loaded from: classes3.dex */
public final class b extends CheckedInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1566a = 0;
    public Object b;

    public /* synthetic */ b(InputStream inputStream, Checksum checksum) {
        super(inputStream, checksum);
    }

    public void b() {
        long value = getChecksum().getValue();
        String str = (String) this.b;
        if (!AbstractC0291a.s(U7.a.M(value), str)) {
            throw new TosClientException(B7.a.n("tos: expect crc64 ", str, ", actual crc64 ", U7.a.M(value)), null);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        switch (this.f1566a) {
            case 1:
                synchronized (this) {
                    super.mark(i);
                    a aVar = (a) this.b;
                    aVar.b = aVar.f1565a;
                }
                return;
            default:
                super.mark(i);
                return;
        }
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        switch (this.f1566a) {
            case 0:
                int i = super.read();
                if (i == -1) {
                    b();
                }
                return i;
            default:
                return super.read();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        switch (this.f1566a) {
            case 1:
                synchronized (this) {
                    super.reset();
                    if (((a) this.b) != null) {
                        f.e.debug("tos: call TosCheckedInputStream reset");
                        ((a) this.b).reset();
                    }
                }
                return;
            default:
                super.reset();
                return;
        }
    }

    public b(InputStream inputStream, a aVar, String str) {
        super(inputStream, aVar);
        this.b = str;
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i6) throws IOException {
        switch (this.f1566a) {
            case 0:
                int i10 = super.read(bArr, i, i6);
                if (i10 == -1) {
                    b();
                }
                return i10;
            default:
                return super.read(bArr, i, i6);
        }
    }
}
