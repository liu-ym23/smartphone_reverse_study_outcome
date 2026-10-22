package X0;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes.dex */
public class d extends InputStream {

    /* renamed from: c, reason: collision with root package name */
    private static final Queue<d> f5784c = k.f(0);

    /* renamed from: a, reason: collision with root package name */
    private InputStream f5785a;

    /* renamed from: b, reason: collision with root package name */
    private IOException f5786b;

    d() {
    }

    public static d c(InputStream inputStream) {
        d dVarPoll;
        Queue<d> queue = f5784c;
        synchronized (queue) {
            dVarPoll = queue.poll();
        }
        if (dVarPoll == null) {
            dVarPoll = new d();
        }
        dVarPoll.m(inputStream);
        return dVarPoll;
    }

    public IOException a() {
        return this.f5786b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f5785a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5785a.close();
    }

    public void f() {
        this.f5786b = null;
        this.f5785a = null;
        Queue<d> queue = f5784c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    void m(InputStream inputStream) {
        this.f5785a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i5) {
        this.f5785a.mark(i5);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f5785a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f5785a.read(bArr);
        } catch (IOException e6) {
            this.f5786b = e6;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f5785a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j5) {
        try {
            return this.f5785a.skip(j5);
        } catch (IOException e6) {
            this.f5786b = e6;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        try {
            return this.f5785a.read(bArr, i5, i6);
        } catch (IOException e6) {
            this.f5786b = e6;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f5785a.read();
        } catch (IOException e6) {
            this.f5786b = e6;
            return -1;
        }
    }
}
