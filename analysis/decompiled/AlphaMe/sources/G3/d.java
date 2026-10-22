package G3;

import java.util.concurrent.atomic.AtomicReference;
import t3.h;

/* loaded from: classes2.dex */
public final class d implements h {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f652a = new AtomicReference(new c(false, new b()));

    @Override // t3.h
    public final boolean a() {
        return ((c) this.f652a.get()).f650a;
    }

    public final void b(h hVar) {
        c cVar;
        boolean z4;
        AtomicReference atomicReference = this.f652a;
        do {
            cVar = (c) atomicReference.get();
            z4 = cVar.f650a;
            if (z4) {
                hVar.c();
                return;
            }
        } while (!atomicReference.compareAndSet(cVar, new c(z4, hVar)));
    }

    @Override // t3.h
    public final void c() {
        c cVar;
        h hVar;
        AtomicReference atomicReference = this.f652a;
        do {
            cVar = (c) atomicReference.get();
            if (cVar.f650a) {
                return;
            } else {
                hVar = cVar.f651b;
            }
        } while (!atomicReference.compareAndSet(cVar, new c(true, hVar)));
        hVar.c();
    }
}
