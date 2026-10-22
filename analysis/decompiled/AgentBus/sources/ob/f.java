package ob;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class f extends m0 {

    /* renamed from: h, reason: collision with root package name */
    public static final ReentrantLock f7967h;

    /* renamed from: i, reason: collision with root package name */
    public static final Condition f7968i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f7969j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f7970k;

    /* renamed from: l, reason: collision with root package name */
    public static f f7971l;

    /* renamed from: e, reason: collision with root package name */
    public int f7972e;

    /* renamed from: f, reason: collision with root package name */
    public f f7973f;

    /* renamed from: g, reason: collision with root package name */
    public long f7974g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f7967h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        q7.k.d(conditionNewCondition, "newCondition(...)");
        f7968i = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f7969j = millis;
        f7970k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void i() {
        long j2 = this.f8010c;
        boolean z4 = this.f8008a;
        if (j2 != 0 || z4) {
            ReentrantLock reentrantLock = f7967h;
            reentrantLock.lock();
            try {
                if (this.f7972e != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.f7972e = 1;
                h4.n.d(this, j2, z4);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean j() {
        ReentrantLock reentrantLock = f7967h;
        reentrantLock.lock();
        try {
            int i2 = this.f7972e;
            this.f7972e = 0;
            if (i2 != 1) {
                return i2 == 2;
            }
            f fVar = f7971l;
            while (fVar != null) {
                f fVar2 = fVar.f7973f;
                if (fVar2 == this) {
                    fVar.f7973f = this.f7973f;
                    this.f7973f = null;
                    return false;
                }
                fVar = fVar2;
            }
            throw new IllegalStateException("node was not found in the queue");
        } finally {
            reentrantLock.unlock();
        }
    }

    public void k() {
    }
}
