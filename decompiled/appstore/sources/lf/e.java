package lf;

import com.ttnet.org.chromium.net.y;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IOException f21984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21986c;

    public e() {
    }

    public void a() {
        IOException r10 = this.f21984a;
        if (r10 != null) goto L5;
        return;
    L5:
        throw r10;
    }

    public void b() {
        if (this.f21986c == false) goto L5;
        a();
        throw new IOException("Writing after request completed.");
    L5:
        if (this.f21985b == true) goto L8;
        return;
    L8:
        throw new IOException("Stream has been closed.");
    }

    public abstract void c();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f21985b = true;
    }

    public abstract y d();

    public abstract void e();

    public void f(IOException r10) {
        this.f21984a = r10;
        this.f21986c = true;
    }
}
