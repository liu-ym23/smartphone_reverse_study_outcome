package s9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: s9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1922b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5996a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1922b.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(AbstractC1922b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public AbstractC1922b(p pVar) {
        this._prev$volatile = pVar;
    }

    public final void a() {
        b.set(this, null);
    }

    public final AbstractC1922b c() {
        Object obj = f5996a.get(this);
        if (obj == AbstractC1921a.f5995a) {
            return null;
        }
        return (AbstractC1922b) obj;
    }

    public abstract boolean d();

    public final void e() {
        Object obj;
        AbstractC1922b abstractC1922bC;
        if (c() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            AbstractC1922b abstractC1922b = (AbstractC1922b) atomicReferenceFieldUpdater.get(this);
            while (abstractC1922b != null && abstractC1922b.d()) {
                abstractC1922b = (AbstractC1922b) atomicReferenceFieldUpdater.get(abstractC1922b);
            }
            AbstractC1922b abstractC1922bC2 = c();
            kotlin.jvm.internal.k.c(abstractC1922bC2);
            while (abstractC1922bC2.d() && (abstractC1922bC = abstractC1922bC2.c()) != null) {
                abstractC1922bC2 = abstractC1922bC;
            }
            do {
                obj = atomicReferenceFieldUpdater.get(abstractC1922bC2);
            } while (!atomicReferenceFieldUpdater.compareAndSet(abstractC1922bC2, obj, ((AbstractC1922b) obj) == null ? null : abstractC1922b));
            if (abstractC1922b != null) {
                f5996a.set(abstractC1922b, abstractC1922bC2);
            }
            if (!abstractC1922bC2.d() || abstractC1922bC2.c() == null) {
                if (abstractC1922b == null || !abstractC1922b.d()) {
                    return;
                }
            }
        }
    }
}
