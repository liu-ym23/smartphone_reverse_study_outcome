package o4;

import com.bytedance.retrofit2.client.SsCall;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f22495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SsCall f22496b;

    public b(InputStream r10, SsCall r11) {
        this.f22495a = r10;
        this.f22496b = r11;
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream r10 = this.f22495a;
        if (r10 == null) goto L7;
        return r10.available();
    L7:
        return super.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream r10 = this.f22495a;     // Catch: Throwable -> L5
        if (r10 == null) goto L7;
        r10.close();     // Catch: Throwable -> L5
    L7:
        SsCall r11 = this.f22496b;     // Catch: Throwable -> L5
        if (r11 == null) goto L12;
        r11.cancel();     // Catch: Throwable -> L5
    L12:
        super.close();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r10) {
        monitor-enter(this);
        InputStream r11 = this.f22495a;     // Catch: Throwable -> L6
        if (r11 == null) goto L8;
        r11.mark(r10);     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        super.mark(r10);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream r10 = this.f22495a;
        if (r10 == null) goto L7;
        return r10.markSupported();
    L7:
        return super.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] r10) {
        InputStream r11 = this.f22495a;
        if (r11 == null) goto L7;
        return r11.read(r10);
    L7:
        return super.read(r10);
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        InputStream r10 = this.f22495a;     // Catch: Throwable -> L6
        if (r10 == null) goto L8;
        r10.reset();     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        super.reset();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r10) {
        InputStream r11 = this.f22495a;
        if (r11 == null) goto L7;
        return r11.skip(r10);
    L7:
        return super.skip(r10);
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        InputStream r13 = this.f22495a;
        if (r13 == null) goto L7;
        return r13.read(r10, r11, r12);
    L7:
        return super.read(r10, r11, r12);
    }

    @Override // java.io.InputStream
    public int read() {
        InputStream r10 = this.f22495a;
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.read();
    }
}
