package com.bytedance.vmsdk.a.a;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.io.IOException;
import java.io.InputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CompositeInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends InputStream {
    private static final String TAG = "CompositeInputStream";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream[] f11673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11674b;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public a(InputStream[] r3) {
        if (r3 == null) goto L9;
        if (r3.length < 2) goto L9;
        this.f11673a = r3;
        this.f11674b = 0;
        return;
    L9:
        throw new IllegalArgumentException("Streams must be non-null and have more than 1 entry");
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f11673a[this.f11674b].available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(this.f11674b);
    }

    private void a(int r6) {
        IOException r0 = null;
        int r1 = 0;
    L3:
        InputStream[] r2 = this.f11673a;
        if (r1 >= r2.length) goto L17;
        r2[r1].close();     // Catch: IOException -> L7
    L16:
        r1 = r1 + 1;
    L7:
        e = e;
        if (r1 == r6) goto L12;
        if (r0 == null) goto L12;
        e = r0;
    L12:
        if (r0 == null) goto L15;
        if (r0 == e) goto L15;
        a(TAG, "Suppressing exception", r0);
    L15:
        r0 = e;
        goto L16
    }

    @Override // java.io.InputStream
    public void mark(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
    L2:
        int r0 = this.f11673a[this.f11674b].read(r3, r4, r5);
        if (r0 != (-1)) goto L6;
        if (a() == true) goto L2;
    L6:
        return r0;
    }

    @Override // java.io.InputStream
    public int read() {
    L2:
        int r0 = this.f11673a[this.f11674b].read();
        if (r0 != (-1)) goto L6;
        if (a() == true) goto L2;
    L6:
        return r0;
    }

    private boolean a() {
        int r0 = this.f11674b;
        if ((r0 + 1) >= this.f11673a.length) goto L6;
        this.f11674b = r0 + 1;
        return true;
    L6:
        return false;
    }

    @Override // java.io.InputStream
    public long skip(long r1) {
        int r0 = read(new byte[(int) r1]);
        if (r0 >= 0) goto L7;
        return -1;
    L7:
        return r0;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
