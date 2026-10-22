package by5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements gy5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f21421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yu3.a<b> f21422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile m f21423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f21425e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f21426a = null;

        static {
            f21426a = new e();
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f21424d == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f21424d = true;     // Catch: Throwable -> L11
        gy5.a.b.f483331a.a(this);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void b() {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
        if (this.f21423c == null) goto L33;
        m r102 = this.f21423c;
        monitor-enter(r102);
        File r103 = r102.f21456a;     // Catch: Throwable -> L29
        if (r103 != null) goto L10;
        monitor-exit(r102);
    L13:
        ArrayList r104 = null;
    L27:
        if (xu3.e.b(r104) == true) goto L33;
        r100.addAll(r104);
        goto L33
    L10:
        File[] r105 = r103.listFiles(new k(r102));     // Catch: Throwable -> L29
        if (r105 != null) goto L14;
        monitor-exit(r102);
        goto L13
    L14:
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L29
        int r107 = r105.length;     // Catch: Throwable -> L29
        int r108 = 0;
    L15:
        if (r108 >= r107) goto L17;
        r106.add(r105[r108].getName());     // Catch: Throwable -> L29
        r108 = r108 + 1;     // Catch: Throwable -> L29
        goto L15
    L17:
        Collections.sort(r106, new l());     // Catch: Throwable -> L29
        if (n.f21462e == false) goto L20;
        fy5.c.a("reportFile: parsing " + r106.size() + " files. fileNameList" + r106);     // Catch: Throwable -> L29
    L20:
        r104 = new ArrayList();     // Catch: Throwable -> L29
        int r109 = 0;
    L21:
        if (r109 >= r106.size()) goto L25;
        r104.add(new PolarisFileWrapper(r102.f21456a, (String) ListProtector.get(r106, r109)));     // Catch: Throwable -> L29
        r109 = r109 + 1;
        goto L21
    L25:
        monitor-exit(r102);
    L29:
        th = move-exception;
        throw th;
    L33:
        if (xu3.e.b(r100) == false) goto L35;
        return;
    L35:
        ArrayList r110 = new ArrayList();
        int r111 = 0;
    L37:
        if (r101 >= r100.size()) goto L68;
        File r112 = (File) ListProtector.get(r100, r101);
        if (r112.exists() == true) goto L71;
        fy5.c.b("APM-SDK", "reportFile file is not exist:" + r112.getAbsolutePath());
    L66:
        r101 = r101 + 1;
        goto L37
    L71:
        byte[] r113 = xu3.b.b(r112);     // Catch: Throwable -> L50
        if (r113 == null) goto L48;
        b r114 = b.a(ByteBuffer.wrap(r113));     // Catch: Throwable -> L50
        if (r114 == null) goto L47;
        r114.f21402c = r112;     // Catch: Throwable -> L50
    L53:
        if (r114 == null) goto L55;
        int r115 = r114.f21401b;
        if (r111 != 0) goto L61;
    L65:
        r111 = r111 + r115;
        r110.add(r114);
        goto L66
    L61:
        if ((r111 + r115) < 1048576) goto L65;
        AtomicInteger r116 = f.f21427d;
        f.a.f21431a.e(r110);
        return;
    L55:
        if (n.f21462e == false) goto L57;
        fy5.c.a("logFile invalid. delete now.");
    L57:
        r112.delete();
        goto L66
    L47:
        fy5.c.b("APM-SDK", "fromMemory bytes is null");     // Catch: Throwable -> L50
        goto L53
    L48:
        fy5.c.b("APM-SDK", "fromFile bytes is null");     // Catch: Throwable -> L50
    L52:
        r114 = null;
    L50:
        th = move-exception;
        fy5.c.c("fromFile", th);
        goto L52
    L68:
        if (xu3.e.b(r110) == true) goto L82;
        AtomicInteger r117 = f.f21427d;
        f.a.f21431a.e(r110);
        return;
    }

    public final void c() {
        if (this.f21422b.a() == false) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList();
        int r101 = 0;
    L7:
        if (this.f21422b.a() == true) goto L18;
        r100.add(this.f21422b.b());
        b r102 = this.f21422b.b();
        if (r102 == null) goto L7;
        int r103 = r102.f21401b;
        if (r101 == 0) goto L17;
        if ((r101 + r103) < 1048576) goto L17;
        AtomicInteger r104 = f.f21427d;
        f.a.f21431a.e(r100);
        r100.clear();
        r100.add(r102);
        r101 = r103;
    L17:
        r101 = r101 + r103;
        r100.add(r102);
        goto L7
    L18:
        AtomicInteger r105 = f.f21427d;
        f.a.f21431a.e(r100);
    }

    public e() {
        this.f21421a = 60000;
        this.f21422b = new yu3.a(10);
    }

    public final synchronized void d(long r100) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (n.f21462e == false) goto L8;
        fy5.c.a("setLoopInterval:" + r100);     // Catch: Throwable -> L17
    L8:
        if (r100 > 0) goto L10;
    L15:
        monitor-exit(this);
        return;
    L10:
        if (this.f21421a == r100) goto L15;
        this.f21421a = Math.min(r100, this.f21421a);     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    @Override // gy5.b
    public final void onTimeEvent(long r100) {
        if ((r100 - this.f21425e) >= this.f21421a) goto L25;
        return;
    L25:
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L19
    L10:
        th = move-exception;
        fy5.c.c("flushBuffer", th);     // Catch: Throwable -> L19
    L12:
        c();     // Catch: Throwable -> L19
        if (n.d() == false) goto L16;
        b();     // Catch: Throwable -> L19
    L16:
        if (n.f21462e == false) goto L21;
        fy5.c.a("LogReporter One Loop Cost:" + (System.currentTimeMillis() - r101));     // Catch: Throwable -> L19
    L21:
        this.f21425e = System.currentTimeMillis();
        if (n.f21462e == false) goto L30;
        fy5.c.a("onTimeEvent");
        return;
    L30:
        return;
    L7:
        if (this.f21423c == null) goto L12;
        this.f21423c.a();     // Catch: Throwable -> L10
    L19:
        th = move-exception;
        fy5.c.c("report", th);
        goto L21
    }
}
