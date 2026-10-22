package com.bytedance.apm6.consumer.slardar.send;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long[] f190711n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f190712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f190713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f190714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f190715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f190716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f190717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f190718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f190719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f190720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicLong f190721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f190722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public nt3.a f190723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f190724m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f190725a = null;

        static {
            f190725a = new d();
        }
    }

    static {
        f190711n = new long[]{120000, 300000, 600000, 1800000, 3600000};
    }

    public final boolean b() {
        if (this.f190720i == true) goto L16;
        long r100 = System.currentTimeMillis() - this.f190721j.get();
        if (this.f190713b <= this.f190715d) goto L7;
        int r101 = this.f190713b;
    L8:
        long r102 = r101;
        if (r102 > this.f190716e) goto L13;
        r102 = this.f190716e;
    L13:
        if (r100 > r102) goto L16;
        return false;
    L7:
        r101 = this.f190715d;
    L16:
        return true;
    }

    public final void c() {
        if (this.f190712a != 0) goto L6;
        this.f190712a = 1;
        this.f190713b = 300000;
    L13:
        if (xu3.a.a() == false) goto L15;
        List<String> r100 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "longBackOff:" + this.f190713b + " netFailCount:" + this.f190712a);
    L15:
        this.f190720i = false;
        this.f190721j.set(System.currentTimeMillis());
        return;
    L6:
        if (this.f190712a != 1) goto L9;
        this.f190712a = 2;
        this.f190713b = Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST;
        goto L13
    L9:
        if (this.f190712a != 2) goto L11;
        this.f190712a = 3;
        this.f190713b = 1800000;
        goto L13
    L11:
        this.f190712a = 4;
        this.f190713b = 1800000;
        goto L13
    }

    public final void d() {
        if (this.f190714c != 0) goto L6;
        this.f190714c = 1;
        this.f190715d = 30000;
    L16:
        if (xu3.a.a() == false) goto L18;
        List<String> r100 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "shortStopInterval:" + this.f190715d + " shortFailCount:" + this.f190714c);
    L18:
        this.f190720i = false;
        this.f190721j.set(System.currentTimeMillis());
        return;
    L6:
        if (this.f190714c != 1) goto L9;
        this.f190714c = 2;
        this.f190715d = 60000;
        goto L16
    L9:
        if (this.f190714c != 2) goto L12;
        this.f190714c = 3;
        this.f190715d = 120000;
        goto L16
    L12:
        if (this.f190714c != 3) goto L14;
        this.f190714c = 4;
        this.f190715d = 240000;
        goto L16
    L14:
        this.f190714c = 5;
        this.f190715d = 300000;
        goto L16
    }

    public d() {
        this.f190714c = 0;
        this.f190720i = true;
        this.f190717f = new ArrayList();
        this.f190718g = new ArrayList();
        this.f190719h = new ArrayList();
        this.f190721j = new AtomicLong(0);
        this.f190722k = new AtomicLong();
    }

    public static long a(int r100) {
        int r101 = r100 - 1;
        if (r101 >= 0) goto L6;
        return 0;
    L6:
        long[] r102 = f190711n;
        if (r101 < 5) goto L11;
        return r102[4];
    L11:
        return r102[r101];
    }
}
