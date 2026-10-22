package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class c2 extends CoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c2 f21320c = null;

    static {
        f21320c = new c2();
    }

    public c2() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void a(CoroutineContext r10, Runnable r11) {
        f2 r12 = (f2) r10.get(f2.f21424c);
        if (r12 == null) goto L7;
        r12.f21425b = true;
        return;
    L7:
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean c(CoroutineContext r10) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
