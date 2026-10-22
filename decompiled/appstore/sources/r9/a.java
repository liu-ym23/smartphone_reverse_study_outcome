package r9;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class a extends FilterOutputStream {
    public a(OutputStream r10) {
        super(r10);
    }

    public void a() {
        ((FilterOutputStream) this).out.write("0\r\n\r\n".getBytes());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r10) {
        write(new byte[]{(byte) r10}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r10) {
        write(r10, 0, r10.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) {
        if (r12 != 0) goto L4;
        return;
    L4:
        ((FilterOutputStream) this).out.write(String.format("%x\r\n", new Object[]{Integer.valueOf(r12)}).getBytes());
        ((FilterOutputStream) this).out.write(r10, r11, r12);
        ((FilterOutputStream) this).out.write("\r\n".getBytes());
    }
}
