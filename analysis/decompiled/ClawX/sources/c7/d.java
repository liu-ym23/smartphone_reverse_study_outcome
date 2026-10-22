package c7;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class d extends x {

    /* renamed from: h, reason: collision with root package name */
    public static final b0.j f1148h;

    /* renamed from: i, reason: collision with root package name */
    public static d f1149i;

    /* renamed from: j, reason: collision with root package name */
    public static final ReentrantLock f1150j;

    /* renamed from: k, reason: collision with root package name */
    public static final Condition f1151k;

    /* renamed from: l, reason: collision with root package name */
    public static final long f1152l;

    /* renamed from: m, reason: collision with root package name */
    public static final long f1153m;

    /* renamed from: e, reason: collision with root package name */
    public int f1154e;

    /* renamed from: f, reason: collision with root package name */
    public int f1155f = -1;

    /* renamed from: g, reason: collision with root package name */
    public long f1156g;

    static {
        b0.j jVar = new b0.j();
        jVar.f833b = new d[8];
        f1148h = jVar;
        ReentrantLock reentrantLock = new ReentrantLock();
        f1150j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.p.d(conditionNewCondition, "newCondition(...)");
        f1151k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f1152l = millis;
        f1153m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void i() {
        long j4 = this.f1200c;
        boolean z = this.f1198a;
        if (j4 != 0 || z) {
            ReentrantLock reentrantLock = f1150j;
            reentrantLock.lock();
            try {
                if (this.f1154e != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.f1154e = 1;
                t1.f.c(this);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean j() {
        ReentrantLock reentrantLock = f1150j;
        reentrantLock.lock();
        try {
            int i8 = this.f1154e;
            this.f1154e = 0;
            if (i8 != 1) {
                return i8 == 2;
            }
            f1148h.e(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException k(IOException iOException) {
        throw null;
    }

    public void l() {
    }
}
