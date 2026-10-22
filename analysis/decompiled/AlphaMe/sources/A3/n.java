package A3;

import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public final class n implements t3.h {

    /* renamed from: a, reason: collision with root package name */
    public final Future f120a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f121b;

    public n(p pVar, Future future) {
        this.f121b = pVar;
        this.f120a = future;
    }

    @Override // t3.h
    public final boolean a() {
        return this.f120a.isCancelled();
    }

    @Override // t3.h
    public final void c() {
        Object obj = this.f121b.get();
        Thread threadCurrentThread = Thread.currentThread();
        Future future = this.f120a;
        if (obj != threadCurrentThread) {
            future.cancel(true);
        } else {
            future.cancel(false);
        }
    }
}
