package c7;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class n implements f, Serializable {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1976h = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "g");

    /* renamed from: f, reason: collision with root package name */
    public volatile p7.a f1977f;

    /* renamed from: g, reason: collision with root package name */
    public volatile Object f1978g;

    @Override // c7.f
    public final Object getValue() {
        Object obj = this.f1978g;
        q qVar = q.f1985a;
        if (obj != qVar) {
            return obj;
        }
        p7.a aVar = this.f1977f;
        if (aVar != null) {
            Object objC = aVar.c();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1976h;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, qVar, objC)) {
                if (atomicReferenceFieldUpdater.get(this) != qVar) {
                }
            }
            this.f1977f = null;
            return objC;
        }
        return this.f1978g;
    }

    public final String toString() {
        return this.f1978g != q.f1985a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
