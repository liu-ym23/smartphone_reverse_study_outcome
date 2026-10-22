package b5;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j implements e, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f896c = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "b");

    /* renamed from: a, reason: collision with root package name */
    public volatile p5.a f897a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f898b;

    @Override // b5.e
    public final boolean a() {
        return this.f898b != w.f917a;
    }

    @Override // b5.e
    public final Object getValue() {
        Object obj = this.f898b;
        w wVar = w.f917a;
        if (obj != wVar) {
            return obj;
        }
        p5.a aVar = this.f897a;
        if (aVar != null) {
            Object objInvoke = aVar.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f896c;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, wVar, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(this) != wVar) {
                }
            }
            this.f897a = null;
            return objInvoke;
        }
        return this.f898b;
    }

    public final String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
