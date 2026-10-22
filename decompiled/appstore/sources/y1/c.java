package y1;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.bytedance.apm.perf.traffic.ITrafficStatistics;
import com.bytedance.apm.thread.AsyncEventManager;

/* JADX INFO: loaded from: classes.dex */
public class c implements ITrafficStatistics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long[] f25992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long[] f25993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f25994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f25995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f25996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f25997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f25998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f25999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f26000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f26001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f26002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f26003m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public NetworkStatsManager f26004n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f26005o;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f26006a;

        public a(c r10) {
            this.f26006a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f26006a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f26007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f26008b;

        public b(c r10, boolean r11) {
            this.f26008b = r10;
            this.f26007a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b(this.f26008b);
            c.c(this.f26008b, !this.f26007a);
        }
    }

    public c() {
        this.f25991a = false;
        this.f25994d = 0;
        this.f25995e = 0;
        this.f25996f = 0;
        this.f25997g = 0;
        this.f25998h = 0;
        this.f25999i = 0;
        this.f26000j = 0;
        this.f26001k = 0;
        this.f26002l = -1;
        this.f26003m = true;
        this.f26005o = -1;
    }

    public static /* synthetic */ void a(c r10) {
        r10.f();
    }

    public static /* synthetic */ void b(c r10) {
        r10.g();
    }

    public static /* synthetic */ boolean c(c r10, boolean r11) {
        r10.f26003m = r11;
        return r11;
    }

    public final int d(Context r10) {
        if (this.f26005o != (-1)) goto L12;
        PackageManager r11 = r10.getApplicationContext().getPackageManager();
        PackageInfo r12 = r11.getPackageInfo(r10.getApplicationContext().getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r12 == null) goto L12;
        this.f26005o = r12.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return this.f26005o;
    }

    public final long[] e(long r16, long r18, int r20) {
        Context r10 = w0.c.g();
        if (this.f26004n != null) goto L5;
        this.f26004n = (NetworkStatsManager) r10.getApplicationContext().getSystemService("netstats");
    L5:
        long r11 = 0;
        if (this.f26004n == null) goto L8;
        NetworkStats.Bucket r12 = new NetworkStats.Bucket();
        NetworkStats r13 = this.f26004n.querySummary(r20, null, r16, r18);     // Catch: Exception -> L12
    L11:
        long r14 = 0;
        long r15 = 0;
        long r17 = 0;
    L14:
        if (r13 == null) goto L20;
        if (r13.hasNextBucket() == false) goto L20;
        r13.getNextBucket(r12);
        if (d(r10) != r12.getUid()) goto L14;
        r11 = r11 + r12.getRxBytes();
        r14 = r14 + r12.getTxBytes();
        r15 = r15 + r12.getRxPackets();
        r17 = r17 + r12.getTxPackets();
    L20:
        if (r13 == null) goto L23;
        r13.close();
    L23:
        return new long[]{r11 + r14, r15 + r17};
    L12:
        e = move-exception;
        e.printStackTrace();
        r13 = null;
        goto L11
    L8:
        return new long[]{0, 0};
    }

    public final void f() {
        if (this.f25991a == false) goto L5;
        return;
    L5:
        this.f25991a = true;
        this.f25992b = e(0, 4611686018427387903L, 1);
        this.f25993c = e(0, 4611686018427387903L, 0);
        this.f26002l = SystemClock.elapsedRealtime();
        if (w0.c.B() == false) goto L9;
        s3.a.a("NewTrafficStatisticsImp", "initTrafficData: mTotalWifiBytes:" + this.f25992b[0] + " mTotalWifiPackets:" + this.f25992b[1] + " mTotalMobileBytes:" + this.f25993c[0] + " mTotalMobilePackets:" + this.f25993c[1]);
        return;
    }

    public final void g() {
        long r10 = SystemClock.elapsedRealtime();
        if ((r10 - this.f26002l) >= 1000) goto L5;
        return;
    L5:
        if (this.f26002l == (-1)) goto L21;
        long[] r11 = e(0, 4611686018427387903L, 1);
        long[] r12 = e(0, 4611686018427387903L, 0);
        long r13 = r12[0] - this.f25993c[0];
        long r14 = r12[1] - this.f25993c[1];
        this.f25993c = r12;
        long r15 = r11[0] - this.f25992b[0];
        long r16 = r11[1] - this.f25992b[1];
        this.f25992b = r11;
        if (w0.c.B() == false) goto L10;
        String r17 = "NewTrafficStatisticsImp";
        s3.a.a(r17, "mTotalWifiBytes:" + this.f25992b[0] + " mTotalWifiPackets:" + this.f25992b[1] + " mTotalMobileBytes:" + this.f25993c[0] + " mTotalMobilePackets:" + this.f25993c[1]);
    L12:
        if (this.f26003m == false) goto L14;
        this.f25997g += r13;
        this.f26001k += r14;
        this.f25996f += r15;
        this.f26000j += r16;
    L16:
        if (w0.c.B() == false) goto L18;
        s3.a.a(r17, "periodWifiBytes" + r15 + " periodMobileBytes:" + r13 + " mMobileBackBytes:" + this.f25995e + " mWifiBackBytes:" + this.f25994d);
    L18:
        this.f26002l = r10;
        return;
    L14:
        this.f25995e += r13;
        this.f25999i += r14;
        this.f25994d += r15;
        this.f25998h += r16;
        goto L16
    L10:
        r17 = "NewTrafficStatisticsImp";
        goto L12
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getBackBytes() {
        g();
        return this.f25995e + this.f25994d;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getBackPackets() {
        g();
        return this.f25999i + this.f25998h;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getFrontBytes() {
        g();
        return this.f25997g + this.f25996f;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getFrontPackets() {
        g();
        return this.f26001k + this.f26000j;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileBackBytes() {
        g();
        return this.f25995e;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileBytes() {
        g();
        return this.f25995e + this.f25997g;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileFrontBytes() {
        g();
        return this.f25997g;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getTotalBytes() {
        return getMobileBytes() + getWifiBytes();
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiBackBytes() {
        g();
        return this.f25994d;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiBytes() {
        g();
        return this.f25994d + this.f25996f;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiFrontBytes() {
        g();
        return this.f25996f;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public void init() {
        if (AsyncEventManager.e().f() == false) goto L5;
        f();
        return;
    L5:
        AsyncEventManager.e().h(new a(this));
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public void onStatusChange(boolean r10) {
        AsyncEventManager.e().c(new b(this, r10));
    }
}
