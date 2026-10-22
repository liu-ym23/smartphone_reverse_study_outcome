package ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n implements Iterable, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final String[] f548c;

    public n(String[] strArr) {
        this.f548c = strArr;
    }

    public final String a(String str) {
        str.getClass();
        String[] strArr = this.f548c;
        int length = strArr.length - 2;
        int iR = com.stepos.statsrpk.h.r(length, 0, -2);
        if (iR > length) {
            return null;
        }
        while (!str.equalsIgnoreCase(strArr[length])) {
            if (length == iR) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final String b(int i) {
        return this.f548c[i * 2];
    }

    public final ne.b c() {
        ne.b bVar = new ne.b();
        ArrayList arrayList = bVar.f8958c;
        arrayList.getClass();
        String[] strArr = this.f548c;
        strArr.getClass();
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        arrayList.addAll(listAsList);
        return bVar;
    }

    public final String d(int i) {
        return this.f548c[(i * 2) + 1];
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return Arrays.equals(this.f548c, ((n) obj).f548c);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f548c);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        jb.g[] gVarArr = new jb.g[size];
        for (int i = 0; i < size; i++) {
            gVarArr[i] = new jb.g(b(i), d(i));
        }
        return yb.k.d(gVarArr);
    }

    public final int size() {
        return this.f548c.length / 2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strB = b(i);
            String strD = d(i);
            sb2.append(strB);
            sb2.append(": ");
            if (bd.b.p(strB)) {
                strD = "██";
            }
            sb2.append(strD);
            sb2.append("\n");
        }
        return sb2.toString();
    }
}
