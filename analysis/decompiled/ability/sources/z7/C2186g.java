package z7;

import java.io.FilterOutputStream;
import java.io.IOException;
import org.json.HTTP;

/* renamed from: z7.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2186g extends FilterOutputStream {
    public final void b() throws IOException {
        ((FilterOutputStream) this).out.write("0\r\n\r\n".getBytes());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i6) throws IOException {
        if (i6 == 0) {
            return;
        }
        ((FilterOutputStream) this).out.write(String.format("%x\r\n", Integer.valueOf(i6)).getBytes());
        ((FilterOutputStream) this).out.write(bArr, i, i6);
        ((FilterOutputStream) this).out.write(HTTP.CRLF.getBytes());
    }
}
