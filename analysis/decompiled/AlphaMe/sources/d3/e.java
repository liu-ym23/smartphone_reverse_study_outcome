package d3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12449a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12450b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev");

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    @Nullable
    private volatile Object _prev;

    public e(e eVar) {
        this._prev = eVar;
    }

    public final void a() {
        f12450b.lazySet(this, null);
    }

    public final e b() {
        Object obj = f12449a.get(this);
        if (obj == AbstractC0542d.f12448a) {
            return null;
        }
        return (e) obj;
    }

    public abstract boolean c();

    public final void d() {
        Object obj;
        e eVarB;
        if (b() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12450b;
            e eVar = (e) atomicReferenceFieldUpdater.get(this);
            while (eVar != null && eVar.c()) {
                eVar = (e) atomicReferenceFieldUpdater.get(eVar);
            }
            e eVarB2 = b();
            Intrinsics.checkNotNull(eVarB2);
            while (eVarB2.c() && (eVarB = eVarB2.b()) != null) {
                eVarB2 = eVarB;
            }
            do {
                obj = atomicReferenceFieldUpdater.get(eVarB2);
            } while (!atomicReferenceFieldUpdater.compareAndSet(eVarB2, obj, ((e) obj) == null ? null : eVar));
            if (eVar != null) {
                f12449a.set(eVar, eVarB2);
            }
            if (!eVarB2.c() || eVarB2.b() == null) {
                if (eVar == null || !eVar.c()) {
                    return;
                }
            }
        }
    }
}
