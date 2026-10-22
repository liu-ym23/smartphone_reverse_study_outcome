package c7;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class o implements f, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public p7.a f1979f;

    /* renamed from: g, reason: collision with root package name */
    public volatile Object f1980g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f1981h;

    public o(p7.a aVar) {
        q7.k.e(aVar, "initializer");
        this.f1979f = aVar;
        this.f1980g = q.f1985a;
        this.f1981h = this;
    }

    @Override // c7.f
    public final Object getValue() {
        Object objC;
        Object obj = this.f1980g;
        q qVar = q.f1985a;
        if (obj != qVar) {
            return obj;
        }
        synchronized (this.f1981h) {
            objC = this.f1980g;
            if (objC == qVar) {
                p7.a aVar = this.f1979f;
                q7.k.b(aVar);
                objC = aVar.c();
                this.f1980g = objC;
                this.f1979f = null;
            }
        }
        return objC;
    }

    public final String toString() {
        return this.f1980g != q.f1985a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
