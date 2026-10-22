package od;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class d extends k0 {

    /* renamed from: h, reason: collision with root package name */
    public static final ReentrantLock f9430h;
    public static final Condition i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f9431j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f9432k;

    /* renamed from: l, reason: collision with root package name */
    public static d f9433l;

    /* renamed from: e, reason: collision with root package name */
    public int f9434e;

    /* renamed from: f, reason: collision with root package name */
    public d f9435f;

    /* renamed from: g, reason: collision with root package name */
    public long f9436g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f9430h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        conditionNewCondition.getClass();
        i = conditionNewCondition;
        f9431j = 60000L;
        f9432k = TimeUnit.MILLISECONDS.toNanos(60000L);
    }

    public final void h() {
        long j10 = this.f9458c;
        boolean z10 = this.f9456a;
        if (j10 != 0 || z10) {
            ReentrantLock reentrantLock = f9430h;
            reentrantLock.lock();
            try {
                if (this.f9434e != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.f9434e = 1;
                f8.b.e(this, j10, z10);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean i() {
        ReentrantLock reentrantLock = f9430h;
        reentrantLock.lock();
        try {
            int i3 = this.f9434e;
            this.f9434e = 0;
            if (i3 != 1) {
                return i3 == 2;
            }
            d dVar = f9433l;
            while (dVar != null) {
                d dVar2 = dVar.f9435f;
                if (dVar2 == this) {
                    dVar.f9435f = this.f9435f;
                    this.f9435f = null;
                    return false;
                }
                dVar = dVar2;
            }
            throw new IllegalStateException("node was not found in the queue");
        } finally {
            reentrantLock.unlock();
        }
    }

    public void j() {
    }
}
