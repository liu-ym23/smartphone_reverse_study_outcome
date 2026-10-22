package c2;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final l f1875b = new l(0);

    /* renamed from: c, reason: collision with root package name */
    public static final l f1876c = new l(1);

    /* renamed from: a, reason: collision with root package name */
    public final int f1877a;

    public l(int i2) {
        this.f1877a = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            return this.f1877a == ((l) obj).f1877a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f1877a;
    }

    public final String toString() {
        int i2 = this.f1877a;
        if (i2 == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((i2 & 1) != 0) {
            arrayList.add("Underline");
        }
        if ((i2 & 2) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() != 1) {
            return a1.a.l(new StringBuilder("TextDecoration["), f2.a.a(arrayList, ", ", null, 62), ']');
        }
        return "TextDecoration." + ((String) arrayList.get(0));
    }
}
