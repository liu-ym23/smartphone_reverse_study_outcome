package com.bytedance.apm6.consumer.slardar.d;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: LogReportController.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long[] f5139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f5140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f5141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f5142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f5143e;
    private volatile int f;
    private List<String> g;
    private List<String> h;
    private List<String> i;
    private volatile boolean j;
    private AtomicLong k;
    private AtomicLong l;
    private com.bytedance.apm6.consumer.slardar.a.a m;
    private volatile boolean n;

    /* JADX INFO: renamed from: com.bytedance.apm6.consumer.slardar.d.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: LogReportController.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: LogReportController.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static c f5144a;

        static {
            f5144a = new c(null);
        }
    }

    /* synthetic */ c(AnonymousClass1 r1) {
        this();
    }

    static {
        f5139a = new long[]{120000, 300000, 600000, 1800000, DownloadConstants.HOUR};
    }

    private c() {
        this.f5142d = 0;
        this.j = true;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.k = new AtomicLong(0);
        this.l = new AtomicLong();
    }

    public static c a() {
        return a.f5144a;
    }

    public void a(com.bytedance.apm6.consumer.slardar.a.a r1) {
        this.m = r1;
    }

    public void a(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (com.bytedance.apm6.util.f.a(r4) == false) goto L5;
        return;
    L5:
        this.g.clear();
        this.g.addAll(r4);
    }

    public void b(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (com.bytedance.apm6.util.f.a(r4) == false) goto L5;
        return;
    L5:
        this.i.clear();
        this.i.addAll(r4);
    }

    public void c(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (com.bytedance.apm6.util.f.a(r4) == false) goto L5;
        return;
    L5:
        this.h.clear();
        this.h.addAll(r4);
    }

    void b() {
        if (this.f5140b != 0) goto L6;
        this.f5140b = 1;
        this.f5141c = 300000;
    L13:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L15;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "longBackOff:" + this.f5141c + " netFailCount:" + this.f5140b);
    L15:
        m();
        return;
    L6:
        if (this.f5140b != 1) goto L9;
        this.f5140b = 2;
        this.f5141c = 900000;
        goto L13
    L9:
        if (this.f5140b != 2) goto L11;
        this.f5140b = 3;
        this.f5141c = 1800000;
        goto L13
    L11:
        this.f5140b = 4;
        this.f5141c = 1800000;
        goto L13
    }

    void c() {
        if (this.f5142d != 0) goto L6;
        this.f5142d = 1;
        this.f5143e = 30000;
    L16:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L18;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "shortStopInterval:" + this.f5143e + " shortFailCount:" + this.f5142d);
    L18:
        m();
        return;
    L6:
        if (this.f5142d != 1) goto L9;
        this.f5142d = 2;
        this.f5143e = 60000;
        goto L16
    L9:
        if (this.f5142d != 2) goto L12;
        this.f5142d = 3;
        this.f5143e = 120000;
        goto L16
    L12:
        if (this.f5142d != 3) goto L14;
        this.f5142d = 4;
        this.f5143e = 240000;
        goto L16
    L14:
        this.f5142d = 5;
        this.f5143e = 300000;
        goto L16
    }

    long a(int r2) {
        int r3 = r2 - 1;
        if (r3 >= 0) goto L6;
        return 0;
    L6:
        long[] r1 = f5139a;
        if (r3 < r1.length) goto L11;
        return r1[r1.length - 1];
    L11:
        return r1[r3];
    }

    void d() {
        this.j = true;
        this.n = false;
        this.f5140b = 0;
        this.f5141c = 0;
        this.f5142d = 0;
        this.f5143e = 0;
        this.f = 0;
        this.l.set(0);
        this.k.set(0);
    }

    boolean e() {
        if (this.j == false) goto L5;
        return true;
    L5:
        if ((System.currentTimeMillis() - this.k.get()) > n()) goto L10;
        return false;
    L10:
        return true;
    }

    void f() {
        b();
        this.n = true;
        this.l.set(System.currentTimeMillis());
    }

    void g() {
        this.n = false;
    }

    boolean h() {
        if (this.n == false) goto L10;
        if ((System.currentTimeMillis() - this.l.get()) > n()) goto L7;
        return true;
    L7:
        return false;
    L10:
        return this.n;
    }

    void a(long r3) {
        this.f = (int) (r3 * 1000);
        m();
    }

    private void m() {
        this.j = false;
        this.k.set(System.currentTimeMillis());
    }

    private long n() {
        if (this.f5141c <= this.f5143e) goto L5;
        int r0 = this.f5141c;
    L6:
        long r1 = r0;
        if (r1 <= this.f) goto L10;
        return r1;
    L10:
        return this.f;
    L5:
        r0 = this.f5143e;
        goto L6
    }

    List<String> i() {
        com.bytedance.apm6.consumer.slardar.a.a r0 = this.m;
        if (r0 == null) goto L9;
        if (com.bytedance.apm6.util.f.a(r0.b()) == true) goto L9;
        return this.m.b();
    L9:
        return this.g;
    }

    List<String> j() {
        com.bytedance.apm6.consumer.slardar.a.a r0 = this.m;
        if (r0 == null) goto L9;
        if (com.bytedance.apm6.util.f.a(r0.c()) == true) goto L9;
        return this.m.c();
    L9:
        return this.h;
    }

    List<String> k() {
        com.bytedance.apm6.consumer.slardar.a.a r0 = this.m;
        if (r0 == null) goto L9;
        if (com.bytedance.apm6.util.f.a(r0.d()) == true) goto L9;
        return this.m.d();
    L9:
        return this.i;
    }

    boolean l() {
        com.bytedance.apm6.consumer.slardar.a.a r0 = this.m;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.e();
    }
}
