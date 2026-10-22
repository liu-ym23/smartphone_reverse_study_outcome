package t3;

import B3.l;
import androidx.room.AbstractC0351g;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
public abstract class g implements h {

    /* renamed from: a, reason: collision with root package name */
    public final l f15444a;

    /* renamed from: b, reason: collision with root package name */
    public final g f15445b;

    /* renamed from: c, reason: collision with root package name */
    public d f15446c;

    /* renamed from: d, reason: collision with root package name */
    public long f15447d;

    public g() {
        this(null, false);
    }

    @Override // t3.h
    public final boolean a() {
        return this.f15444a.a();
    }

    @Override // t3.h
    public final void c() {
        this.f15444a.c();
    }

    public final void d(h hVar) {
        this.f15444a.b(hVar);
    }

    public abstract void e();

    public abstract void f(Throwable th);

    public abstract void g(Object obj);

    public final void h(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException(AbstractC0351g.n("number requested cannot be negative: ", j4));
        }
        synchronized (this) {
            d dVar = this.f15446c;
            if (dVar != null) {
                dVar.c(j4);
                return;
            }
            long j5 = this.f15447d;
            if (j5 == Long.MIN_VALUE) {
                this.f15447d = j4;
            } else {
                long j6 = j5 + j4;
                if (j6 < 0) {
                    this.f15447d = LongCompanionObject.MAX_VALUE;
                } else {
                    this.f15447d = j6;
                }
            }
        }
    }

    public void i(d dVar) {
        long j4;
        g gVar;
        boolean z4;
        synchronized (this) {
            j4 = this.f15447d;
            this.f15446c = dVar;
            gVar = this.f15445b;
            z4 = gVar != null && j4 == Long.MIN_VALUE;
        }
        if (z4) {
            gVar.i(dVar);
        } else if (j4 == Long.MIN_VALUE) {
            dVar.c(LongCompanionObject.MAX_VALUE);
        } else {
            dVar.c(j4);
        }
    }

    public g(g gVar, boolean z4) {
        this.f15447d = Long.MIN_VALUE;
        this.f15445b = gVar;
        this.f15444a = (!z4 || gVar == null) ? new l(0) : gVar.f15444a;
    }
}
