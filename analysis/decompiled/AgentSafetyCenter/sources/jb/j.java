package jb;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements d, Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f6763g = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "f");

    /* renamed from: c, reason: collision with root package name */
    public volatile xb.a f6764c;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f6765f;

    @Override // jb.d
    public final Object getValue() {
        Object obj = this.f6765f;
        s sVar = s.f6773a;
        if (obj != sVar) {
            return obj;
        }
        xb.a aVar = this.f6764c;
        if (aVar != null) {
            Object objInvoke = aVar.invoke();
            if (f6763g.compareAndSet(this, sVar, objInvoke)) {
                this.f6764c = null;
                return objInvoke;
            }
        }
        return this.f6765f;
    }

    public final String toString() {
        return this.f6765f != s.f6773a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
