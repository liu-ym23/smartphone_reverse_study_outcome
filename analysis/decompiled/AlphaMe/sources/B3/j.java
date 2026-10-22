package B3;

import Z2.I;
import androidx.room.AbstractC0351g;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class j extends AtomicBoolean implements t3.d, x3.a {

    /* renamed from: a, reason: collision with root package name */
    public final t3.g f231a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f232b;

    /* renamed from: c, reason: collision with root package name */
    public final x3.e f233c;

    public j(t3.g gVar, Object obj, x3.e eVar) {
        this.f231a = gVar;
        this.f232b = obj;
        this.f233c = eVar;
    }

    @Override // x3.a
    public final void b() {
        t3.g gVar = this.f231a;
        if (gVar.f15444a.a()) {
            return;
        }
        Object obj = this.f232b;
        try {
            gVar.g(obj);
            if (gVar.f15444a.a()) {
                return;
            }
            gVar.e();
        } catch (Throwable th) {
            I.E(th, gVar, obj);
        }
    }

    @Override // t3.d
    public final void c(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException(AbstractC0351g.n("n >= 0 required but it was ", j4));
        }
        if (j4 == 0 || !compareAndSet(false, true)) {
            return;
        }
        this.f231a.d((t3.h) this.f233c.call(this));
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ScalarAsyncProducer[" + this.f232b + ", " + get() + "]";
    }
}
