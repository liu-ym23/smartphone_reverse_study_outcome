package q7;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class a implements g, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Object f8789f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f8790g;

    /* renamed from: h, reason: collision with root package name */
    public final String f8791h;

    /* renamed from: i, reason: collision with root package name */
    public final String f8792i;

    /* renamed from: k, reason: collision with root package name */
    public final int f8794k;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f8793j = false;

    /* renamed from: l, reason: collision with root package name */
    public final int f8795l = 4;

    public a(int i2, Class cls, Object obj, String str, String str2) {
        this.f8789f = obj;
        this.f8790g = cls;
        this.f8791h = str;
        this.f8792i = str2;
        this.f8794k = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8793j == aVar.f8793j && this.f8794k == aVar.f8794k && this.f8795l == aVar.f8795l && this.f8789f.equals(aVar.f8789f) && this.f8790g.equals(aVar.f8790g) && this.f8791h.equals(aVar.f8791h) && this.f8792i.equals(aVar.f8792i);
    }

    @Override // q7.g
    public final int getArity() {
        return this.f8794k;
    }

    public final int hashCode() {
        return ((((m.x.g(this.f8792i, m.x.g(this.f8791h, (this.f8790g.hashCode() + (this.f8789f.hashCode() * 31)) * 31, 31), 31) + (this.f8793j ? 1231 : 1237)) * 31) + this.f8794k) * 31) + this.f8795l;
    }

    public final String toString() {
        return w.f8821a.g(this);
    }
}
