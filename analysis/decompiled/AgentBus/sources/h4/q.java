package h4;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class q implements t3.o {
    @Override // t3.o
    public final InputStream a(InputStream inputStream, byte[] bArr) {
        return new x(this, inputStream, bArr);
    }

    @Override // t3.o
    public final OutputStream b(FileOutputStream fileOutputStream, byte[] bArr) {
        return new y(this, fileOutputStream, bArr);
    }

    public abstract int c();

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract v g();

    public abstract w h(byte[] bArr);
}
