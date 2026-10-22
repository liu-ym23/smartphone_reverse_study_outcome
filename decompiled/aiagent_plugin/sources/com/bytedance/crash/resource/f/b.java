package com.bytedance.crash.resource.f;

import com.bytedance.crash.config.e;
import java.io.File;

/* JADX INFO: compiled from: LogPath.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f7719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f7720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f7721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f7722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f7723e;
    private File f;
    private File g;
    private File h;
    private File i;

    static {
        f7719a = new b();
    }

    private static b i() {
        return f7719a;
    }

    private b() {
        this.i = e.a();
        a();
    }

    public void a() {
        this.f7720b = new File(this.i, "xasanReport");
        this.f7721c = new File(this.i, "NativeHeapReport");
        this.f7722d = new File(this.i, "VmMonitor");
        this.f7723e = new File(this.i, "FdTrack");
        this.f = new File(this.i, "RefMonitor");
        this.g = new File(this.i, "TLSMonitor");
        this.h = new File(this.i, "PriorityMonitor");
    }

    public static File b() {
        return i().f7721c;
    }

    public static File c() {
        return i().f7720b;
    }

    public static File d() {
        return i().f7722d;
    }

    public static File e() {
        return i().f7723e;
    }

    public static File f() {
        return i().f;
    }

    public static File g() {
        return i().g;
    }

    public static File h() {
        return i().h;
    }
}
