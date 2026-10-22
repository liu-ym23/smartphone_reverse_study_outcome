package E0;

import H.h;
import H4.o;
import L0.d;
import android.app.Application;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f451a;
    public long[] b;
    public long[] c;
    public volatile long d;
    public volatile long e;
    public volatile long f;
    public volatile long g;
    public long h;
    public volatile boolean i;

    /* renamed from: j, reason: collision with root package name */
    public NetworkStatsManager f452j;
    public int k;

    @Override // E0.a
    public final long a() {
        e();
        return this.f;
    }

    @Override // E0.a
    public final long b() {
        e();
        return this.g;
    }

    @Override // E0.a
    public final long c() {
        e();
        return this.e + this.g;
    }

    @Override // E0.a
    public final long d() {
        e();
        return this.d + this.f;
    }

    public final void e() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = this.h;
        if (jElapsedRealtime - j5 < 1000 || j5 == -1) {
            return;
        }
        long[] jArrC = c(1);
        long[] jArrC2 = c(0);
        long j6 = jArrC2[0];
        long[] jArr = this.c;
        long j10 = j6 - jArr[0];
        long j11 = jArrC2[1];
        long j12 = jArr[1];
        this.c = jArrC2;
        long j13 = jArrC[0];
        long[] jArr2 = this.b;
        long j14 = j13 - jArr2[0];
        long j15 = jArrC[1];
        long j16 = jArr2[1];
        this.b = jArrC;
        if (h.b) {
            o.f("NewTrafficStatisticsImp", "mTotalWifiBytes:" + this.b[0] + " mTotalWifiPackets:" + this.b[1] + " mTotalMobileBytes:" + this.c[0] + " mTotalMobilePackets:" + this.c[1]);
        }
        if (this.i) {
            this.g += j10;
            this.f += j14;
        } else {
            this.e += j10;
            this.d += j14;
        }
        if (h.b) {
            o.f("NewTrafficStatisticsImp", "periodWifiBytes" + j14 + " periodMobileBytes:" + j10 + " mMobileBackBytes:" + this.e + " mWifiBackBytes:" + this.d);
        }
        this.h = jElapsedRealtime;
    }

    @Override // E0.a
    public final void f() {
        if (this.f451a) {
            return;
        }
        this.f451a = true;
        this.h = SystemClock.elapsedRealtime();
        this.b = c(1);
        this.c = c(0);
        if (h.b) {
            o.f("NewTrafficStatisticsImp", "initTrafficData: mTotalWifiBytes:" + this.b[0] + " mTotalWifiPackets:" + this.b[1] + " mTotalMobileBytes:" + this.c[0] + " mTotalMobilePackets:" + this.c[1]);
        }
    }

    @Override // E0.a
    public final long g() {
        e();
        long j5 = this.e + this.g;
        e();
        return this.d + this.f + j5;
    }

    @Override // E0.a
    public final long h() {
        e();
        return this.e;
    }

    @Override // E0.a
    public final long k() {
        e();
        return this.d;
    }

    public final long[] c(int i) throws PackageManager.NameNotFoundException, RemoteException, SecurityException {
        NetworkStats networkStatsQuerySummary;
        Application application = h.f711a;
        if (this.f452j == null) {
            this.f452j = (NetworkStatsManager) application.getApplicationContext().getSystemService("netstats");
        }
        if (this.f452j == null) {
            return new long[]{0, 0};
        }
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();
        try {
            networkStatsQuerySummary = this.f452j.querySummary(i, null, 0L, 4611686018427387903L);
        } catch (Exception e) {
            e.printStackTrace();
            networkStatsQuerySummary = null;
        }
        long txBytes = 0;
        long rxPackets = 0;
        long txPackets = 0;
        NetworkStats networkStats = networkStatsQuerySummary;
        long rxBytes = 0;
        while (networkStats != null && networkStats.hasNextBucket()) {
            networkStats.getNextBucket(bucket);
            int uid = bucket.getUid();
            if (this.k == -1) {
                try {
                    PackageInfo packageInfo = application.getApplicationContext().getPackageManager().getPackageInfo(application.getApplicationContext().getPackageName(), 128);
                    if (packageInfo != null) {
                        this.k = packageInfo.applicationInfo.uid;
                    }
                } catch (PackageManager.NameNotFoundException e6) {
                    e6.printStackTrace();
                }
            }
            if (this.k == uid) {
                rxBytes += bucket.getRxBytes();
                txBytes += bucket.getTxBytes();
                rxPackets += bucket.getRxPackets();
                txPackets += bucket.getTxPackets();
            }
        }
        if (networkStats != null) {
            networkStats.close();
        }
        return new long[]{rxBytes + txBytes, rxPackets + txPackets};
    }

    @Override // E0.a
    public final void f(boolean z10) {
        d.f925a.b(new b(this, z10));
    }
}
