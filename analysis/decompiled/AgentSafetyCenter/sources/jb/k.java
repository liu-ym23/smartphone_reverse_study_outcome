package jb;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements d, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public xb.a f6766c;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f6767f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f6768g;

    public k(xb.a aVar) {
        aVar.getClass();
        this.f6766c = aVar;
        this.f6767f = s.f6773a;
        this.f6768g = this;
    }

    @Override // jb.d
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.f6767f;
        s sVar = s.f6773a;
        if (obj != sVar) {
            return obj;
        }
        synchronized (this.f6768g) {
            objInvoke = this.f6767f;
            if (objInvoke == sVar) {
                xb.a aVar = this.f6766c;
                aVar.getClass();
                objInvoke = aVar.invoke();
                this.f6767f = objInvoke;
                this.f6766c = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this.f6767f != s.f6773a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
