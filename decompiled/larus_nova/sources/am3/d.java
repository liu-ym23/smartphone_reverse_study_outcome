package am3;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes14.dex */
public class d<T extends InputStream> extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f4362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4364e;

    @Override // am3.f
    public void a() {
        throw new UnsupportedOperationException("reread not supported");
    }

    @Override // am3.f
    public f b() {
        throw new UnsupportedOperationException("buffered not supported");
    }

    @Override // am3.f
    public final boolean d() {
        if ((this.f4363d - this.f4364e) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // am3.f
    public final byte readByte() throws IOException {
        this.f4364e++;
        return (byte) this.f4362c.read();
    }

    @Override // am3.f
    public final void c(long r100) throws IOException {
        this.f4364e = (int) (((long) this.f4364e) + r100);
        this.f4362c.skip(r100);
    }

    @Override // am3.f
    public final byte[] readByteArray(long r100) throws IOException {
        this.f4364e = (int) (((long) this.f4364e) + r100);
        byte[] r101 = new byte[(int) r100];
        this.f4362c.read(r101);
        return r101;
    }

    @Override // am3.f
    public final String readUtf8(long r100) throws IOException {
        this.f4364e = (int) (((long) this.f4364e) + r100);
        int r101 = (int) r100;
        if (r100 <= 256) goto L5;
        byte[] r102 = new byte[r101];
        this.f4362c.read(r102, 0, r101);
    L7:
        return new String(r102, 0, r101, e.f4365a);
    L5:
        this.f4362c.read(this.f4361b, 0, r101);
        r102 = this.f4361b;
        goto L7
    }

    @Override // am3.f
    public final void skip(long r100) throws IOException {
        this.f4364e = (int) (((long) this.f4364e) + r100);
        this.f4362c.skip(r100);
    }

    public d(T r100, int r101, int r102) {
        this.f4361b = new byte[256];
        this.f4362c = r100;
        this.f4364e = r101;
        this.f4363d = r102;
    }
}
