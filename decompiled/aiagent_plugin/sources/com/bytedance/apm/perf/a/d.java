package com.bytedance.apm.perf.a;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NewTrafficStatisticsImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements b {
    private static final String TAG = "NewTrafficStatisticsImp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long[] f4762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long[] f4763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f4764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f4765e;
    private volatile long f;
    private volatile long g;
    private volatile long h;
    private volatile long i;
    private volatile long j;
    private volatile long k;
    private volatile long l;
    private volatile boolean m;
    private NetworkStatsManager n;
    private int o;

    public d() {
        this.f4761a = false;
        this.f4764d = 0;
        this.f4765e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = -1;
        this.m = true;
        this.o = -1;
    }

    static /* synthetic */ void a(d r0) {
        r0.m();
    }

    static /* synthetic */ boolean a(d r0, boolean r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ void b(d r0) {
        r0.n();
    }

    @Override // com.bytedance.apm.perf.a.b
    public void a() {
        if (com.bytedance.apm.thread.b.a().b() == false) goto L5;
        m();
        return;
    L5:
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1(this));
    }

    private void m() {
        if (this.f4761a == false) goto L5;
        return;
    L5:
        this.f4761a = true;
        this.f4762b = a(0, 4611686018427387903L, 1);
        this.f4763c = a(0, 4611686018427387903L, 0);
        this.l = SystemClock.elapsedRealtime();
        if (com.bytedance.apm.c.i() == false) goto L9;
        com.bytedance.apm6.util.c.b.a(TAG, "initTrafficData: mTotalWifiBytes:" + this.f4762b[0] + " mTotalWifiPackets:" + this.f4762b[1] + " mTotalMobileBytes:" + this.f4763c[0] + " mTotalMobilePackets:" + this.f4763c[1]);
        return;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long b() {
        n();
        return this.f4765e + this.g;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long c() {
        n();
        return this.f4764d + this.f;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long d() {
        n();
        return this.f4765e + this.f4764d;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long e() {
        n();
        return this.i + this.h;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long f() {
        n();
        return this.g + this.f;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long g() {
        n();
        return this.k + this.j;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long h() {
        n();
        return this.g;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long i() {
        n();
        return this.f4765e;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long j() {
        n();
        return this.f;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long k() {
        n();
        return this.f4764d;
    }

    @Override // com.bytedance.apm.perf.a.b
    public long l() {
        return b() + c();
    }

    @Override // com.bytedance.apm.perf.a.b
    public void a(final boolean r3) {
        com.bytedance.apm.thread.b.a().b(new AnonymousClass2(this, r3));
    }

    private void n() {
        long r7 = SystemClock.elapsedRealtime();
        if ((r7 - this.l) >= 1000) goto L5;
        return;
    L5:
        if (this.l == (-1)) goto L21;
        long[] r9 = a(0, 4611686018427387903L, 1);
        long[] r0 = a(0, 4611686018427387903L, 0);
        long r2 = r0[0] - this.f4763c[0];
        long r10 = r0[1] - this.f4763c[1];
        this.f4763c = r0;
        long r12 = r9[0] - this.f4762b[0];
        long r14 = r9[1] - this.f4762b[1];
        this.f4762b = r9;
        if (com.bytedance.apm.c.i() == false) goto L10;
        String r1 = "mTotalWifiBytes:" + this.f4762b[0] + " mTotalWifiPackets:" + this.f4762b[1] + " mTotalMobileBytes:" + this.f4763c[0] + " mTotalMobilePackets:" + this.f4763c[1];
        String r3 = TAG;
        com.bytedance.apm6.util.c.b.a(r3, r1);
    L12:
        if (this.m == false) goto L14;
        this.g += r2;
        this.k += r10;
        this.f += r12;
        this.j += r14;
    L16:
        if (com.bytedance.apm.c.i() == false) goto L18;
        com.bytedance.apm6.util.c.b.a(r3, "periodWifiBytes" + r12 + " periodMobileBytes:" + r2 + " mMobileBackBytes:" + this.f4765e + " mWifiBackBytes:" + this.f4764d);
    L18:
        this.l = r7;
        return;
    L14:
        this.f4765e += r2;
        this.i += r10;
        this.f4764d += r12;
        this.h += r14;
        goto L16
    L10:
        r3 = TAG;
        goto L12
    }

    private long[] a(long r17, long r19, int r21) {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (this.n != null) goto L6;
        this.n = (NetworkStatsManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("netstats"), NetworkStatsManager.class, "com.obric.aiagent.plugin");
    L6:
        if (this.n == null) goto L8;
        NetworkStats r4 = null;
        NetworkStats.Bucket r5 = new NetworkStats.Bucket();
        long r6 = 0;
        r4 = this.n.querySummary(r21, null, r17, r19);     // Catch: Exception -> L12
    L14:
        long r8 = 0;
        long r10 = 0;
        long r12 = 0;
    L15:
        if (r4 == null) goto L21;
        if (r4.hasNextBucket() == false) goto L21;
        r4.getNextBucket(r5);
        if (a(r3) != r5.getUid()) goto L15;
        r6 = r6 + r5.getRxBytes();
        r8 = r8 + r5.getTxBytes();
        r10 = r10 + r5.getRxPackets();
        r12 = r12 + r5.getTxPackets();
    L21:
        if (r4 == null) goto L24;
        r4.close();
    L24:
        return new long[]{r6 + r8, r10 + r12};
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L8:
        return new long[]{0, 0};
    }

    private int a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (this.o != (-1)) goto L12;
        PackageManager r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager();
        PackageInfo r6 = r0.getPackageInfo(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r6 == null) goto L12;
        this.o = r6.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return this.o;
    }
}
