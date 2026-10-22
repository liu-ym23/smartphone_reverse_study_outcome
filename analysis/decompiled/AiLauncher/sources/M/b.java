package M;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class b extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final OutputStream f4461a;

    /* renamed from: b, reason: collision with root package name */
    public ByteOrder f4462b;

    public b(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.f4461a = outputStream;
        this.f4462b = byteOrder;
    }

    public void b(ByteOrder byteOrder) {
        this.f4462b = byteOrder;
    }

    public void e(int i10) throws IOException {
        this.f4461a.write(i10);
    }

    public void g(long j10) throws IOException {
        writeInt((int) j10);
    }

    public void i(int i10) throws IOException {
        writeShort((short) i10);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f4461a.write(bArr);
    }

    public void writeInt(int i10) throws IOException {
        ByteOrder byteOrder = this.f4462b;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.f4461a.write(i10 & 255);
            this.f4461a.write((i10 >>> 8) & 255);
            this.f4461a.write((i10 >>> 16) & 255);
            this.f4461a.write((i10 >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.f4461a.write((i10 >>> 24) & 255);
            this.f4461a.write((i10 >>> 16) & 255);
            this.f4461a.write((i10 >>> 8) & 255);
            this.f4461a.write(i10 & 255);
        }
    }

    public void writeShort(short s10) throws IOException {
        ByteOrder byteOrder = this.f4462b;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.f4461a.write(s10 & 255);
            this.f4461a.write((s10 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.f4461a.write((s10 >>> 8) & 255);
            this.f4461a.write(s10 & 255);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f4461a.write(bArr, i10, i11);
    }
}
