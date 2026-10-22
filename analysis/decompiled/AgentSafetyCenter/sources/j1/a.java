package j1;

import a1.g;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public XmlResourceParser f6536a;

    /* renamed from: b, reason: collision with root package name */
    public int f6537b;

    /* renamed from: c, reason: collision with root package name */
    public g f6538c;

    public final float a(TypedArray typedArray, String str, int i, float f5) {
        if (e3.b.d(this.f6536a, str)) {
            f5 = typedArray.getFloat(i, f5);
        }
        b(typedArray.getChangingConfigurations());
        return f5;
    }

    public final void b(int i) {
        this.f6537b = i | this.f6537b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f6536a, aVar.f6536a) && this.f6537b == aVar.f6537b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f6537b) + (this.f6536a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AndroidVectorParser(xmlParser=");
        sb2.append(this.f6536a);
        sb2.append(", config=");
        return androidx.activity.b.l(sb2, this.f6537b, ')');
    }
}
