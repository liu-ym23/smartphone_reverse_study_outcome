package ab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n implements Iterable, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final String[] f578f;

    public n(String[] strArr) {
        this.f578f = strArr;
    }

    public final String a(String str) {
        q7.k.e(str, "name");
        String[] strArr = this.f578f;
        int length = strArr.length - 2;
        int iB = ib.c.B(length, 0, -2);
        if (iB > length) {
            return null;
        }
        while (!str.equalsIgnoreCase(strArr[length])) {
            if (length == iB) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return Arrays.equals(this.f578f, ((n) obj).f578f);
        }
        return false;
    }

    public final String f(int i2) {
        return this.f578f[i2 * 2];
    }

    public final m h() {
        m mVar = new m();
        ArrayList arrayList = mVar.f577f;
        q7.k.e(arrayList, "<this>");
        String[] strArr = this.f578f;
        q7.k.e(strArr, "elements");
        arrayList.addAll(d7.n.S(strArr));
        return mVar;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f578f);
    }

    public final String i(int i2) {
        return this.f578f[(i2 * 2) + 1];
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        c7.j[] jVarArr = new c7.j[size];
        for (int i2 = 0; i2 < size; i2++) {
            jVarArr[i2] = new c7.j(f(i2), i(i2));
        }
        return q7.k.h(jVarArr);
    }

    public final int size() {
        return this.f578f.length / 2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String strF = f(i2);
            String strI = i(i2);
            sb2.append(strF);
            sb2.append(": ");
            if (bb.b.q(strF)) {
                strI = "██";
            }
            sb2.append(strI);
            sb2.append("\n");
        }
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
