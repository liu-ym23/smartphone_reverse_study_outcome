package Z2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class Y implements Runnable, Comparable, T {

    @Nullable
    private volatile Object _heap;

    /* renamed from: a, reason: collision with root package name */
    public long f2200a;

    /* renamed from: b, reason: collision with root package name */
    public int f2201b = -1;

    public Y(long j4) {
        this.f2200a = j4;
    }

    public final d3.C a() {
        Object obj = this._heap;
        if (obj instanceof d3.C) {
            return (d3.C) obj;
        }
        return null;
    }

    public final int c(long j4, Z z4, AbstractC0115a0 abstractC0115a0) {
        synchronized (this) {
            if (this._heap == I.f2171d) {
                return 2;
            }
            synchronized (z4) {
                try {
                    Y[] yArr = z4.f12438a;
                    Y y4 = yArr != null ? yArr[0] : null;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = AbstractC0115a0.f2204e;
                    abstractC0115a0.getClass();
                    if (AbstractC0115a0.f2206g.get(abstractC0115a0) != 0) {
                        return 1;
                    }
                    if (y4 == null) {
                        z4.f2202c = j4;
                    } else {
                        long j5 = y4.f2200a;
                        if (j5 - j4 < 0) {
                            j4 = j5;
                        }
                        if (j4 - z4.f2202c > 0) {
                            z4.f2202c = j4;
                        }
                    }
                    long j6 = this.f2200a;
                    long j7 = z4.f2202c;
                    if (j6 - j7 < 0) {
                        this.f2200a = j7;
                    }
                    z4.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j4 = this.f2200a - ((Y) obj).f2200a;
        if (j4 > 0) {
            return 1;
        }
        return j4 < 0 ? -1 : 0;
    }

    public final void d(Z z4) {
        if (this._heap == I.f2171d) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this._heap = z4;
    }

    @Override // Z2.T
    public final void dispose() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                X.r rVar = I.f2171d;
                if (obj == rVar) {
                    return;
                }
                Z z4 = obj instanceof Z ? (Z) obj : null;
                if (z4 != null) {
                    synchronized (z4) {
                        if (a() != null) {
                            z4.b(this.f2201b);
                        }
                    }
                }
                this._heap = rVar;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.f2200a + ']';
    }
}
