package pc;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9950a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9951b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public b(r rVar) {
        this._prev$volatile = rVar;
    }

    public final void a() {
        f9951b.set(this, null);
    }

    public final b b() {
        Object obj = f9950a.get(this);
        if (obj == a.f9943a) {
            return null;
        }
        return (b) obj;
    }

    public abstract boolean c();

    public final void d() {
        Object obj;
        b bVarB;
        if (b() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9951b;
            b bVar = (b) atomicReferenceFieldUpdater.get(this);
            while (bVar != null && bVar.c()) {
                bVar = (b) atomicReferenceFieldUpdater.get(bVar);
            }
            b bVarB2 = b();
            bVarB2.getClass();
            while (bVarB2.c() && (bVarB = bVarB2.b()) != null) {
                bVarB2 = bVarB;
            }
            do {
                obj = atomicReferenceFieldUpdater.get(bVarB2);
            } while (!atomicReferenceFieldUpdater.compareAndSet(bVarB2, obj, ((b) obj) == null ? null : bVar));
            if (bVar != null) {
                f9950a.set(bVar, bVarB2);
            }
            if (!bVarB2.c() || bVarB2.b() == null) {
                if (bVar == null || !bVar.c()) {
                    return;
                }
            }
        }
    }
}
