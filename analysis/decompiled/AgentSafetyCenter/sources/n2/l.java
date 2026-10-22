package n2;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final l f8663b = new l(0);

    /* renamed from: c, reason: collision with root package name */
    public static final l f8664c = new l(1);

    /* renamed from: a, reason: collision with root package name */
    public final int f8665a;

    public l(int i) {
        this.f8665a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            return this.f8665a == ((l) obj).f8665a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f8665a;
    }

    public final String toString() {
        int i = this.f8665a;
        if (i == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            arrayList.add("Underline");
        }
        if ((i & 2) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() != 1) {
            return k0.a.s(new StringBuilder("TextDecoration["), q2.a.a(arrayList, ", ", null, 62), ']');
        }
        return "TextDecoration." + ((String) arrayList.get(0));
    }
}
