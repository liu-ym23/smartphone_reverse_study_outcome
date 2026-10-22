package by5;

import com.xiaomi.mipush.sdk.Constants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long[] f21407m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f21408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f21409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f21410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f21411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f21412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f21413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f21414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f21415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicLong f21416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f21417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f21418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f21419l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f21420a = null;

        static {
            f21420a = new d();
        }
    }

    static {
        f21407m = new long[]{120000, 300000, 600000, 1800000, 3600000};
    }

    public final boolean b() {
        if (this.f21414g == true) goto L16;
        long r100 = System.currentTimeMillis() - this.f21415h.get();
        if (this.f21409b <= this.f21411d) goto L7;
        int r101 = this.f21409b;
    L8:
        long r102 = r101;
        if (r102 > this.f21412e) goto L13;
        r102 = this.f21412e;
    L13:
        if (r100 > r102) goto L16;
        return false;
    L7:
        r101 = this.f21411d;
    L16:
        return true;
    }

    public final void c() {
        if (this.f21408a != 0) goto L6;
        this.f21408a = 1;
        this.f21409b = 300000;
    L13:
        if (n.f21462e == false) goto L15;
        fy5.c.a("longBackOff:" + this.f21409b + " netFailCount:" + this.f21408a);
    L15:
        this.f21414g = false;
        this.f21415h.set(System.currentTimeMillis());
        return;
    L6:
        if (this.f21408a != 1) goto L9;
        this.f21408a = 2;
        this.f21409b = Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST;
        goto L13
    L9:
        if (this.f21408a != 2) goto L11;
        this.f21408a = 3;
        this.f21409b = 1800000;
        goto L13
    L11:
        this.f21408a = 4;
        this.f21409b = 1800000;
        goto L13
    }

    public final void e() {
        if (this.f21410c != 0) goto L6;
        this.f21410c = 1;
        this.f21411d = 30000;
    L16:
        if (n.f21462e == false) goto L18;
        fy5.c.a("shortStopInterval:" + this.f21411d + " shortFailCount:" + this.f21410c);
    L18:
        this.f21414g = false;
        this.f21415h.set(System.currentTimeMillis());
        return;
    L6:
        if (this.f21410c != 1) goto L9;
        this.f21410c = 2;
        this.f21411d = 60000;
        goto L16
    L9:
        if (this.f21410c != 2) goto L12;
        this.f21410c = 3;
        this.f21411d = 120000;
        goto L16
    L12:
        if (this.f21410c != 3) goto L14;
        this.f21410c = 4;
        this.f21411d = 240000;
        goto L16
    L14:
        this.f21410c = 5;
        this.f21411d = 300000;
        goto L16
    }

    public d() {
        this.f21410c = 0;
        this.f21414g = true;
        this.f21417j = new ConcurrentHashMap();
        this.f21418k = true;
        this.f21415h = new AtomicLong(0);
        this.f21416i = new AtomicLong();
    }

    public static long a(int r100) {
        int r101 = r100 - 1;
        if (r101 >= 0) goto L6;
        return 0;
    L6:
        long[] r102 = f21407m;
        if (r101 < 5) goto L11;
        return r102[4];
    L11:
        return r102[r101];
    }

    public final void d(List r100) {
        if (xu3.e.b(r100) == false) goto L5;
        return;
    L5:
        if (xu3.e.b(this.f21413f) == false) goto L24;
        LinkedList r101 = new LinkedList();
        Iterator r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L15;
        r101.add(("https://" + new URL((String) r102.next()).getHost()) + "/monitor/collect/batch/");     // Catch: MalformedURLException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L15:
        this.f21413f = r101;
        return;
    }
}
