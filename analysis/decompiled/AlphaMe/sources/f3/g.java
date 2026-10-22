package f3;

import Z2.AbstractC0123e0;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public abstract class g extends AbstractC0123e0 {

    /* renamed from: a, reason: collision with root package name */
    public final b f12569a;

    public g(long j4, int i4, int i5, String str) {
        this.f12569a = new b(j4, i4, i5, str);
    }

    @Override // Z2.A
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b.e(this.f12569a, runnable, false, 6);
    }

    @Override // Z2.A
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        b.e(this.f12569a, runnable, true, 2);
    }
}
