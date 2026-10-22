package n7;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c extends ByteArrayOutputStream {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6858f = 1;

    public /* synthetic */ c() {
    }

    public synchronized byte[] a(sb.d dVar) {
        byte[] bArr;
        bArr = new byte[64];
        dVar.J(((ByteArrayOutputStream) this).buf, ((ByteArrayOutputStream) this).count, bArr);
        reset();
        return bArr;
    }

    public byte[] b() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        q7.k.d(bArr, "buf");
        return bArr;
    }

    @Override // java.io.ByteArrayOutputStream
    public synchronized void reset() {
        switch (this.f6858f) {
            case 1:
                synchronized (this) {
                    Arrays.fill(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, (byte) 0);
                    ((ByteArrayOutputStream) this).count = 0;
                }
                return;
            default:
                super.reset();
                return;
        }
    }

    public /* synthetic */ c(int i2) {
        super(i2);
    }
}
