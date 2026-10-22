package W0;

import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;
import com.zyql.common.utils.upload.TOSUploader;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class g {
    public static final long[] n = {120000, TaskTimeouts.TAKEOVER_IDLE_MS, 600000, TOSUploader.EXPIRED_TIMES, 3600000};

    /* renamed from: a, reason: collision with root package name */
    public volatile int f1477a;
    public volatile int b;
    public volatile int c;
    public volatile int d;
    public volatile int e;
    public ArrayList f;
    public ArrayList g;
    public ArrayList h;
    public volatile boolean i;

    /* renamed from: j, reason: collision with root package name */
    public AtomicLong f1478j;
    public AtomicLong k;
    public T0.a l;
    public volatile boolean m;

    public static long a(int i) {
        int i6 = i - 1;
        if (i6 < 0) {
            return 0L;
        }
        long[] jArr = n;
        return i6 >= 5 ? jArr[4] : jArr[i6];
    }

    public final boolean b() {
        if (this.i) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f1478j.get();
        long j5 = this.b > this.d ? this.b : this.d;
        if (j5 <= this.e) {
            j5 = this.e;
        }
        return jCurrentTimeMillis > j5;
    }

    public final void c() {
        if (this.f1477a == 0) {
            this.f1477a = 1;
            this.b = 300000;
        } else if (this.f1477a == 1) {
            this.f1477a = 2;
            this.b = 900000;
        } else if (this.f1477a == 2) {
            this.f1477a = 3;
            this.b = 1800000;
        } else {
            this.f1477a = 4;
            this.b = 1800000;
        }
        if (AbstractC1451a.f4467a) {
            H4.o.f(S0.a.f1163a, "longBackOff:" + this.b + " netFailCount:" + this.f1477a);
        }
        this.i = false;
        this.f1478j.set(System.currentTimeMillis());
    }

    public final void d() {
        if (this.c == 0) {
            this.c = 1;
            this.d = 30000;
        } else if (this.c == 1) {
            this.c = 2;
            this.d = 60000;
        } else if (this.c == 2) {
            this.c = 3;
            this.d = 120000;
        } else if (this.c == 3) {
            this.c = 4;
            this.d = 240000;
        } else {
            this.c = 5;
            this.d = 300000;
        }
        if (AbstractC1451a.f4467a) {
            H4.o.f(S0.a.f1163a, "shortStopInterval:" + this.d + " shortFailCount:" + this.c);
        }
        this.i = false;
        this.f1478j.set(System.currentTimeMillis());
    }
}
