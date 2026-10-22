package am3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f4355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0087a f4356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4357c;

    /* JADX INFO: renamed from: am3.a$a, reason: collision with other inner class name */
    public static final class C0087a extends ByteArrayOutputStream {
        public C0087a() {
        }

        public final byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public final int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        int r100 = this.f4356b.getCount();
        int r101 = this.f4357c;
        if (r101 >= r100) goto L5;
        int r102 = r100 - r101;
    L7:
        return r102 + this.f4355a.available();
    L5:
        r102 = 0;
        goto L7
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f4355a.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f4357c >= this.f4356b.getCount()) goto L6;
        byte[] r100 = this.f4356b.a();
        int r101 = this.f4357c;
        this.f4357c = r101 + 1;
        return r100[r101];
    L6:
        int r102 = this.f4355a.read();
        if (r102 < 0) goto L9;
        this.f4356b.write(r102);
        this.f4357c++;
    L9:
        return r102;
    }

    public a(InputStream r100) {
        this.f4355a = r100;
        this.f4356b = new C0087a();
        this.f4357c = 0;
    }

    @Override // java.io.InputStream
    public final long skip(long r100) throws IOException {
        int r101 = (int) r100;
        int r102 = this.f4356b.getCount();
        int r103 = this.f4357c;
        if (r103 >= r102) goto L5;
        int r104 = r102 - r103;
    L6:
        if (r101 > r104) goto L9;
        this.f4357c = r103 + r101;
        return r100;
    L9:
        this.f4357c = r103 + r104;
        byte[] r105 = new byte[r101 - r104];
        int r106 = this.f4355a.read(r105);
        if (r106 <= 0) goto L13;
        this.f4356b.write(r105, 0, r106);
        this.f4357c += r106;
    L13:
        return r106;
    L5:
        r104 = 0;
        goto L6
    }

    public a(a r100, int r101) {
        this.f4355a = r100.f4355a;
        this.f4356b = r100.f4356b;
        this.f4357c = r101;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.f4356b.getCount();
        int r104 = this.f4357c;
        if (r104 >= r103) goto L5;
        int r105 = r103 - r104;
    L6:
        if (r105 > 0) goto L11;
        r102 = this.f4355a.read(r100, r101, r102);
        if (r102 <= 0) goto L10;
        this.f4356b.write(r100, r101, r102);
    L17:
        this.f4357c += r102;
        return r102;
    L10:
        r102 = 0;
        goto L17
    L11:
        if (r105 < r102) goto L13;
        System.arraycopy(this.f4356b.a(), this.f4357c, r100, r101, r102);
        goto L17
    L13:
        System.arraycopy(this.f4356b.a(), this.f4357c, r100, r101, r105);
        int r106 = this.f4355a.read(r100, r101, r102 - r105);
        if (r106 <= 0) goto L16;
        this.f4356b.write(r100, r101, r106);
        r102 = r106 + r105;
        goto L17
    L16:
        r102 = r105;
        goto L17
    L5:
        r105 = 0;
        goto L6
    }
}
