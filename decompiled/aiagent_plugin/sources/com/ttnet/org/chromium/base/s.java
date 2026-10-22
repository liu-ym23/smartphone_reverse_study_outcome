package com.ttnet.org.chromium.base;

import android.os.StrictMode;
import java.io.Closeable;

/* JADX INFO: compiled from: StrictModeContext.java */
/* JADX INFO: loaded from: classes4.dex */
public final class s implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StrictMode.ThreadPolicy f37732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StrictMode.VmPolicy f37733b;

    private s(StrictMode.ThreadPolicy r1, StrictMode.VmPolicy r2) {
        this.f37732a = r1;
        this.f37733b = r2;
    }

    private s(StrictMode.ThreadPolicy r2) {
        this(r2, null);
    }

    private s(StrictMode.VmPolicy r2) {
        this(null, r2);
    }

    public static s a() {
        StrictMode.VmPolicy r0 = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        return new s(r0);
    }

    public static s b() {
        return new s(StrictMode.allowThreadDiskWrites());
    }

    public static s c() {
        return new s(StrictMode.allowThreadDiskReads());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        StrictMode.ThreadPolicy r0 = this.f37732a;
        if (r0 == null) goto L5;
        StrictMode.setThreadPolicy(r0);
    L5:
        StrictMode.VmPolicy r1 = this.f37733b;
        if (r1 == null) goto L9;
        StrictMode.setVmPolicy(r1);
        return;
    }
}
