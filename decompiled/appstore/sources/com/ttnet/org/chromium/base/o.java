package com.ttnet.org.chromium.base;

import android.os.StrictMode;
import java.io.Closeable;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f18334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StrictMode.VmPolicy f18335b;

    public o(StrictMode.ThreadPolicy r10, StrictMode.VmPolicy r11) {
        this.f18334a = r10;
        this.f18335b = r11;
    }

    public static o a() {
        StrictMode.VmPolicy r10 = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        return new o(r10);
    }

    public static o b() {
        return new o(StrictMode.allowThreadDiskReads());
    }

    public static o c() {
        return new o(StrictMode.allowThreadDiskWrites());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        StrictMode.ThreadPolicy r10 = this.f18334a;
        if (r10 == null) goto L5;
        StrictMode.setThreadPolicy(r10);
    L5:
        StrictMode.VmPolicy r11 = this.f18335b;
        if (r11 == null) goto L9;
        StrictMode.setVmPolicy(r11);
        return;
    }

    public o(StrictMode.ThreadPolicy r10) {
        this(r10, null);
    }

    public o(StrictMode.VmPolicy r10) {
        this(null, r10);
    }
}
