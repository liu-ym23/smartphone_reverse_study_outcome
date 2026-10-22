package com.bytedance.apm6.java_alloc;

import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.PerfMonitorManager;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f6804d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.apm6.java_alloc.b f6805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.apm6.java_alloc.b f6806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6807c;

    /* JADX INFO: renamed from: com.bytedance.apm6.java_alloc.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0084a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6808a = null;

        static {
            f6808a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f6808a;
        }
    }

    static {
    }

    public /* synthetic */ a(C0084a r10) {
        this();
    }

    public static a b() {
        return b.a();
    }

    public com.bytedance.apm6.java_alloc.b a() {
        com.bytedance.apm6.java_alloc.b r10 = this.f6806b;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.f6805a;
    }

    public void c() {
        if (this.f6807c == true) goto L9;
        JavaAllocConfigService r10 = (JavaAllocConfigService) o3.a.a(JavaAllocConfigService.class);
        if (r10 == null) goto L7;
        e(r10.getConfig());
    L7:
        d();
        this.f6807c = true;
        return;
    }

    public final boolean d() {
        com.bytedance.apm6.java_alloc.b r10 = a();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.f6809a == true) goto L8;
        return false;
    L8:
        if ((-1) != f6804d) goto L13;
        if (PerfMonitorManager.u() == false) goto L13;
        f6804d = MonitorJni.initJavaMem() ? 1 : 0;
    L13:
        if (f6804d == 1) goto L15;
        return false;
    L15:
        return true;
    }

    public void e(com.bytedance.apm6.java_alloc.b r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f6805a = r10;
    }

    public a() {
    }
}
