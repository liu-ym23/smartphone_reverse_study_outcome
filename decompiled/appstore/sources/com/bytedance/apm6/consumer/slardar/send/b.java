package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm6.util.ListUtils;
import com.bytedanceos.common.ad.common.AdConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long[] f6697n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f6698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f6699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f6700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f6701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f6702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f6703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f6704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f6705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f6706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AtomicLong f6707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AtomicLong f6708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o2.a f6709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f6710m;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.bytedance.apm6.consumer.slardar.send.b$b, reason: collision with other inner class name */
    public static class C0079b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static b f6711a;

        static {
            f6711a = new b(null);
        }
    }

    static {
        f6697n = new long[]{120000, 300000, AdConstant.SPLASH_AD_INTERVAL, 1800000, 3600000};
    }

    public /* synthetic */ b(a r10) {
        this();
    }

    public static b e() {
        return C0079b.f6711a;
    }

    public void a(long r10) {
        this.f6702e = (int) (r10 * 1000);
        o();
    }

    public void b() {
        l();
        this.f6710m = true;
        this.f6708k.set(System.currentTimeMillis());
    }

    public final long c() {
        if (this.f6699b <= this.f6701d) goto L6;
        int r10 = this.f6699b;
    L5:
        long r11 = r10;
        if (r11 <= this.f6702e) goto L11;
        return r11;
    L11:
        return this.f6702e;
    L6:
        r10 = this.f6701d;
        goto L5
    }

    public List d() {
        o2.a r10 = this.f6709l;
        if (r10 == null) goto L9;
        if (ListUtils.b(r10.b()) == true) goto L9;
        return this.f6709l.b();
    L9:
        return this.f6705h;
    }

    public List f() {
        o2.a r10 = this.f6709l;
        if (r10 == null) goto L9;
        if (ListUtils.b(r10.h()) == true) goto L9;
        return this.f6709l.h();
    L9:
        return this.f6703f;
    }

    public long g(int r10) {
        int r11 = r10 - 1;
        if (r11 >= 0) goto L6;
        return 0;
    L6:
        long[] r12 = f6697n;
        if (r11 < r12.length) goto L11;
        return r12[r12.length - 1];
    L11:
        return r12[r11];
    }

    public List h() {
        o2.a r10 = this.f6709l;
        if (r10 == null) goto L9;
        if (ListUtils.b(r10.i()) == true) goto L9;
        return this.f6709l.i();
    L9:
        return this.f6704g;
    }

    public boolean i() {
        o2.a r10 = this.f6709l;
        if (r10 != null) goto L5;
        return true;
    L5:
        return r10.j();
    }

    public boolean j() {
        if (this.f6706i == false) goto L5;
        return true;
    L5:
        if ((System.currentTimeMillis() - this.f6707j.get()) > c()) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean k() {
        if (this.f6710m == false) goto L10;
        if ((System.currentTimeMillis() - this.f6708k.get()) > c()) goto L7;
        return true;
    L7:
        return false;
    L10:
        return this.f6710m;
    }

    public void l() {
        if (this.f6698a != 0) goto L6;
        this.f6698a = 1;
        this.f6699b = 300000;
    L13:
        if (r3.a.c() == false) goto L15;
        s3.a.a(n2.a.f22354a, "longBackOff:" + this.f6699b + " netFailCount:" + this.f6698a);
    L15:
        o();
        return;
    L6:
        if (this.f6698a != 1) goto L9;
        this.f6698a = 2;
        this.f6699b = 900000;
        goto L13
    L9:
        if (this.f6698a != 2) goto L11;
        this.f6698a = 3;
        this.f6699b = 1800000;
        goto L13
    L11:
        this.f6698a = 4;
        this.f6699b = 1800000;
        goto L13
    }

    public void m() {
        this.f6710m = false;
    }

    public void n() {
        this.f6706i = true;
        this.f6710m = false;
        this.f6698a = 0;
        this.f6699b = 0;
        this.f6700c = 0;
        this.f6701d = 0;
        this.f6702e = 0;
        this.f6708k.set(0);
        this.f6707j.set(0);
    }

    public final void o() {
        this.f6706i = false;
        this.f6707j.set(System.currentTimeMillis());
    }

    public void p(List r10) {
        if (ListUtils.b(r10) == false) goto L5;
        return;
    L5:
        this.f6705h.clear();
        this.f6705h.addAll(r10);
    }

    public void q(List r10) {
        if (ListUtils.b(r10) == false) goto L5;
        return;
    L5:
        this.f6703f.clear();
        this.f6703f.addAll(r10);
    }

    public void r(List r10) {
        if (ListUtils.b(r10) == false) goto L5;
        return;
    L5:
        this.f6704g.clear();
        this.f6704g.addAll(r10);
    }

    public void s() {
        if (this.f6700c != 0) goto L6;
        this.f6700c = 1;
        this.f6701d = 30000;
    L16:
        if (r3.a.c() == false) goto L18;
        s3.a.a(n2.a.f22354a, "shortStopInterval:" + this.f6701d + " shortFailCount:" + this.f6700c);
    L18:
        o();
        return;
    L6:
        if (this.f6700c != 1) goto L9;
        this.f6700c = 2;
        this.f6701d = 60000;
        goto L16
    L9:
        if (this.f6700c != 2) goto L12;
        this.f6700c = 3;
        this.f6701d = 120000;
        goto L16
    L12:
        if (this.f6700c != 3) goto L14;
        this.f6700c = 4;
        this.f6701d = 240000;
        goto L16
    L14:
        this.f6700c = 5;
        this.f6701d = 300000;
        goto L16
    }

    public void t(o2.a r10) {
        this.f6709l = r10;
    }

    public b() {
        this.f6700c = 0;
        this.f6706i = true;
        this.f6703f = new ArrayList();
        this.f6704g = new ArrayList();
        this.f6705h = new ArrayList();
        this.f6707j = new AtomicLong(0);
        this.f6708k = new AtomicLong();
    }
}
