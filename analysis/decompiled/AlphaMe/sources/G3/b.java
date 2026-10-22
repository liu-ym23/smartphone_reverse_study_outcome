package G3;

import java.util.concurrent.atomic.AtomicReference;
import t3.h;

/* loaded from: classes2.dex */
public final class b implements h {

    /* renamed from: b, reason: collision with root package name */
    public static final a f648b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f649a;

    public b() {
        this.f649a = new AtomicReference();
    }

    @Override // t3.h
    public final boolean a() {
        return this.f649a.get() == f648b;
    }

    @Override // t3.h
    public final void c() {
        x3.a aVar;
        AtomicReference atomicReference = this.f649a;
        x3.a aVar2 = (x3.a) atomicReference.get();
        a aVar3 = f648b;
        if (aVar2 == aVar3 || (aVar = (x3.a) atomicReference.getAndSet(aVar3)) == null || aVar == aVar3) {
            return;
        }
        aVar.b();
    }

    public b(y3.f fVar) {
        this.f649a = new AtomicReference(fVar);
    }
}
