package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import m9.AbstractC1683A;
import s9.AbstractC1921a;
import s9.o;

/* loaded from: classes4.dex */
public final class b extends o {
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(b.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    @Override // s9.o, kotlinx.coroutines.c
    public final void x(Object obj) {
        y(obj);
    }

    @Override // s9.o, kotlinx.coroutines.c
    public final void y(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = e;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                AbstractC1921a.h(U7.a.I(this.d), AbstractC1683A.p(obj));
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
