package com.bytedance.framwork.core.sdklib.a;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: LogReportController.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long[] f8605a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f8606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f8607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f8608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f8609e;
    private volatile int f;
    private List<String> g;
    private volatile boolean h;
    private AtomicLong i;
    private AtomicLong j;
    private final ConcurrentHashMap<String, Boolean> k;
    private volatile boolean l;
    private volatile boolean m;

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.a.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: LogReportController.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: LogReportController.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static d f8610a;

        static {
            f8610a = new d(null);
        }
    }

    long d() {
        return 5;
    }

    /* synthetic */ d(AnonymousClass1 r1) {
        this();
    }

    static {
        f8605a = new long[]{120000, 300000, 600000, 1800000, DownloadConstants.HOUR};
    }

    private d() {
        this.f8608d = 0;
        this.h = true;
        this.k = new ConcurrentHashMap();
        this.l = true;
        this.i = new AtomicLong(0);
        this.j = new AtomicLong();
    }

    public static d a() {
        return a.f8610a;
    }

    public void a(String r2, List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (com.bytedance.apm6.util.f.a(r4) == false) goto L5;
        return;
    L5:
        if (com.bytedance.apm6.util.f.a(this.g) == false) goto L10;
        this.g = a(r4);
        return;
    }

    public void a(String r3, boolean r4) {
        this.k.put(r3, Boolean.valueOf(r4));
        Iterator<Boolean> r5 = this.k.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.next(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L4;
        boolean r6 = true;
    L9:
        this.l = r6;
        return;
    L8:
        r6 = false;
        goto L9
    }

    void b() {
        if (this.f8606b != 0) goto L6;
        this.f8606b = 1;
        this.f8607c = 300000;
    L13:
        if (k.d() == false) goto L15;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "longBackOff:" + this.f8607c + " netFailCount:" + this.f8606b);
    L15:
        l();
        return;
    L6:
        if (this.f8606b != 1) goto L9;
        this.f8606b = 2;
        this.f8607c = 900000;
        goto L13
    L9:
        if (this.f8606b != 2) goto L11;
        this.f8606b = 3;
        this.f8607c = 1800000;
        goto L13
    L11:
        this.f8606b = 4;
        this.f8607c = 1800000;
        goto L13
    }

    void c() {
        if (this.f8608d != 0) goto L6;
        this.f8608d = 1;
        this.f8609e = 30000;
    L16:
        if (k.d() == false) goto L18;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "shortStopInterval:" + this.f8609e + " shortFailCount:" + this.f8608d);
    L18:
        l();
        return;
    L6:
        if (this.f8608d != 1) goto L9;
        this.f8608d = 2;
        this.f8609e = 60000;
        goto L16
    L9:
        if (this.f8608d != 2) goto L12;
        this.f8608d = 3;
        this.f8609e = 120000;
        goto L16
    L12:
        if (this.f8608d != 3) goto L14;
        this.f8608d = 4;
        this.f8609e = 240000;
        goto L16
    L14:
        this.f8608d = 5;
        this.f8609e = 300000;
        goto L16
    }

    long a(int r2) {
        int r3 = r2 - 1;
        if (r3 >= 0) goto L6;
        return 0;
    L6:
        long[] r1 = f8605a;
        if (r3 < r1.length) goto L11;
        return r1[r1.length - 1];
    L11:
        return r1[r3];
    }

    void e() {
        this.h = true;
        this.m = false;
        this.f8606b = 0;
        this.f8607c = 0;
        this.f8608d = 0;
        this.f8609e = 0;
        this.f = 0;
        this.j.set(0);
        this.i.set(0);
    }

    boolean f() {
        if (this.h == false) goto L5;
        return true;
    L5:
        if ((System.currentTimeMillis() - this.i.get()) > m()) goto L10;
        return false;
    L10:
        return true;
    }

    void g() {
        b();
        this.m = true;
        this.j.set(System.currentTimeMillis());
    }

    void h() {
        this.m = false;
    }

    boolean i() {
        if (this.m == false) goto L10;
        if ((System.currentTimeMillis() - this.j.get()) > m()) goto L7;
        return true;
    L7:
        return false;
    L10:
        return this.m;
    }

    void a(long r3) {
        this.f = (int) (r3 * 1000);
        l();
    }

    private void l() {
        this.h = false;
        this.i.set(System.currentTimeMillis());
    }

    private long m() {
        if (this.f8607c <= this.f8609e) goto L5;
        int r0 = this.f8607c;
    L6:
        long r1 = r0;
        if (r1 <= this.f) goto L10;
        return r1;
    L10:
        return this.f;
    L5:
        r0 = this.f8609e;
        goto L6
    }

    List<String> j() {
        if (com.bytedance.apm6.util.f.a(this.g) == false) goto L7;
        return com.bytedance.apm6.util.b.a.f5459a;
    L7:
        return this.g;
    }

    boolean k() {
        return this.l;
    }

    private static List<String> a(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        LinkedList r0 = new LinkedList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        r0.add(("https://" + new URL((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin")).getHost()) + "/monitor/collect/batch/");     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r0;
    }
}
