package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.ag;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: CronetOutputStream.java */
/* JADX INFO: loaded from: classes4.dex */
abstract class f extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IOException f38289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f38290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f38291c;

    abstract void a();

    abstract void b();

    abstract ag c();

    f() {
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f38290b = true;
    }

    void a(IOException r1) {
        this.f38289a = r1;
        this.f38291c = true;
    }

    public void d() {
        if (this.f38291c == false) goto L5;
        e();
        throw new IOException("Writing after request completed.");
    L5:
        if (this.f38290b == true) goto L8;
        return;
    L8:
        throw new IOException("Stream has been closed.");
    }

    public void e() {
        IOException r0 = this.f38289a;
        if (r0 != null) goto L5;
        return;
    L5:
        throw r0;
    }
}
