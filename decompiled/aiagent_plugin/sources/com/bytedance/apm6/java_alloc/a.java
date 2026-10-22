package com.bytedance.apm6.java_alloc;

import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JavaAllocCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "APM-JavaAlloc";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f5419d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f5420e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f5421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f5422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5423c;

    /* JADX INFO: renamed from: com.bytedance.apm6.java_alloc.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: JavaAllocCollector.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.apm6.java_alloc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JavaAllocCollector.java */
    private static class C0131a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f5424a = null;

        static /* synthetic */ a a() {
            return f5424a;
        }

        static {
            f5424a = new a(null);
        }
    }

    static {
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    private a() {
    }

    public static a a() {
        return C0131a.a();
    }

    public void b() {
        if (this.f5423c == true) goto L9;
        c r0 = (c) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(c.class), c.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        a(r0.a());
    L7:
        d();
        this.f5423c = true;
        return;
    }

    public void a(b r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.f5422b = r1;
    }

    public b c() {
        b r0 = this.f5421a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.f5422b;
    }

    private boolean d() {
        b r2 = c();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.f5425a == true) goto L8;
        return false;
    L8:
        if ((-1) != f5419d) goto L13;
        if (k.b() == false) goto L13;
        f5419d = MonitorJni.initJavaMem() ? 1 : 0;
    L13:
        if (f5419d == 1) goto L15;
        return false;
    L15:
        return true;
    }
}
