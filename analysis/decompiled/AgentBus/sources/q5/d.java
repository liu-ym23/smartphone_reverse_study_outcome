package q5;

import ia.f1;
import ia.g1;
import ia.w1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final d5.e f8669a;

    /* renamed from: b, reason: collision with root package name */
    public final ka.g f8670b;

    /* renamed from: c, reason: collision with root package name */
    public final w1 f8671c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f8672d = new AtomicBoolean();

    public d(d5.e eVar, ka.g gVar, w1 w1Var) {
        this.f8669a = eVar;
        this.f8670b = gVar;
        this.f8671c = w1Var;
    }

    public final boolean a() {
        if (!this.f8672d.compareAndSet(false, true)) {
            return false;
        }
        ka.v.cancel$default((ka.x) this.f8670b, (CancellationException) null, 1, (Object) null);
        f1.cancel$default((g1) this.f8671c, (CancellationException) null, 1, (Object) null);
        return true;
    }
}
