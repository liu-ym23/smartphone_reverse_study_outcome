package c7;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class s implements f, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public p7.a f1987f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1988g;

    @Override // c7.f
    public final Object getValue() {
        if (this.f1988g == q.f1985a) {
            p7.a aVar = this.f1987f;
            q7.k.b(aVar);
            this.f1988g = aVar.c();
            this.f1987f = null;
        }
        return this.f1988g;
    }

    public final String toString() {
        return this.f1988g != q.f1985a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
