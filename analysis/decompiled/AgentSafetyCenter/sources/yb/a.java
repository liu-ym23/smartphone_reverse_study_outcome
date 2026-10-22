package yb;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class a implements h, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Object f16075c;

    /* renamed from: f, reason: collision with root package name */
    public final Class f16076f;

    /* renamed from: g, reason: collision with root package name */
    public final String f16077g;

    /* renamed from: h, reason: collision with root package name */
    public final String f16078h;
    public final boolean i = false;

    /* renamed from: j, reason: collision with root package name */
    public final int f16079j;

    /* renamed from: k, reason: collision with root package name */
    public final int f16080k;

    public a(int i, int i3, Class cls, Object obj, String str, String str2) {
        this.f16075c = obj;
        this.f16076f = cls;
        this.f16077g = str;
        this.f16078h = str2;
        this.f16079j = i;
        this.f16080k = i3 >> 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.i == aVar.i && this.f16079j == aVar.f16079j && this.f16080k == aVar.f16080k && this.f16075c.equals(aVar.f16075c) && this.f16076f.equals(aVar.f16076f) && this.f16077g.equals(aVar.f16077g) && this.f16078h.equals(aVar.f16078h);
    }

    @Override // yb.h
    public final int getArity() {
        return this.f16079j;
    }

    public final int hashCode() {
        return ((((androidx.activity.b.d(androidx.activity.b.d((this.f16076f.hashCode() + (this.f16075c.hashCode() * 31)) * 31, 31, this.f16077g), 31, this.f16078h) + (this.i ? 1231 : 1237)) * 31) + this.f16079j) * 31) + this.f16080k;
    }

    public final String toString() {
        v.f16099a.getClass();
        return w.a(this);
    }
}
