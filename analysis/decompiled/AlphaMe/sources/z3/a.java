package z3;

import Z2.I;
import java.util.concurrent.atomic.AtomicBoolean;
import t3.d;
import t3.g;

/* loaded from: classes2.dex */
public final class a extends AtomicBoolean implements d {

    /* renamed from: a, reason: collision with root package name */
    public final g f16417a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f16418b;

    public a(g gVar, Object obj) {
        this.f16417a = gVar;
        this.f16418b = obj;
    }

    @Override // t3.d
    public final void c(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j4 != 0 && compareAndSet(false, true)) {
            g gVar = this.f16417a;
            if (gVar.f15444a.a()) {
                return;
            }
            Object obj = this.f16418b;
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
    }
}
