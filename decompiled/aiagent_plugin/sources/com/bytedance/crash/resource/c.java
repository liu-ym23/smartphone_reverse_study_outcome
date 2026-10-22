package com.bytedance.crash.resource;

import com.bytedance.security.zenmobile.io.SensitiveType;
import java.io.File;

/* JADX INFO: compiled from: ResourceMonitorConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f7710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f7711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f7712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f7713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f7714e;
    protected int f;
    protected File g;

    private static String b(int r1) {
        if (r1 != 0) goto L4;
        return "gwp_asan.guard";
    L4:
        if (r1 != 1) goto L6;
        return "heap_track.guard";
    L6:
        if (r1 != 2) goto L8;
        return "fd_track.guard";
    L8:
        if (r1 != 3) goto L10;
        return "vm_monitor.guard";
    L10:
        if (r1 != 4) goto L12;
        return "tls_monitor.guard";
    L12:
        if (r1 == 5) goto L15;
        return SensitiveType.UNKNOWN;
    L15:
        return "ref_monitor.guard";
    }

    private static String c(int r0) {
        switch(r0) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return SensitiveType.UNKNOWN;
    L5:
        return "npth_setpriority";
    L7:
        return "npth_ref_monitor";
    L9:
        return "npth_tls_monitor";
    L11:
        return "npth_vm_monitor";
    L13:
        return "npth_fd_tracker";
    L15:
        return "npth_heap_tracker";
    L17:
        return "npth_xasan";
    }

    private static String d(int r1) {
        if (r1 != 0) goto L4;
        return "xasan.config";
    L4:
        if (r1 != 1) goto L6;
        return "heap_track.config";
    L6:
        if (r1 != 2) goto L8;
        return "fd_track.config";
    L8:
        if (r1 != 3) goto L10;
        return "vmm.config";
    L10:
        if (r1 != 4) goto L12;
        return "tls_monitor.config";
    L12:
        if (r1 == 5) goto L15;
        return SensitiveType.UNKNOWN;
    L15:
        return "ref_monitor.config";
    }

    public String toString() {
        return "";
    }

    public c(int r2, int r3, int r4) {
        this.f7712c = null;
        this.f7713d = null;
        this.f7714e = null;
        this.g = null;
        this.f7711b = r3;
        this.f7710a = r2;
        this.f = r4;
    }

    public int a() {
        return this.f7711b;
    }

    public int b() {
        return this.f7710a;
    }

    public String c() {
        if (this.f7712c != null) goto L6;
        this.f7712c = b(this.f);
    L6:
        return this.f7712c;
    }

    public String d() {
        if (this.f7713d != null) goto L6;
        this.f7713d = c(this.f);
    L6:
        return this.f7713d;
    }

    public String e() {
        if (this.f7714e != null) goto L6;
        this.f7714e = d(this.f);
    L6:
        return this.f7714e;
    }

    public String f() {
        return "lib" + d() + ".so";
    }

    public int g() {
        return this.f;
    }

    public File h() {
        if (this.g != null) goto L6;
        this.g = a(this.f);
    L6:
        return this.g;
    }

    public static File a(int r0) {
        switch(r0) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return com.bytedance.crash.resource.f.b.h();
    L8:
        return com.bytedance.crash.resource.f.b.f();
    L10:
        return com.bytedance.crash.resource.f.b.g();
    L12:
        return com.bytedance.crash.resource.f.b.d();
    L14:
        return com.bytedance.crash.resource.f.b.e();
    L16:
        return com.bytedance.crash.resource.f.b.b();
    L18:
        return com.bytedance.crash.resource.f.b.c();
    }
}
