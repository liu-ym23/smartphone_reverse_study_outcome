package F9;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Pair;

/* loaded from: classes4.dex */
public final class w implements Iterable, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f657a;

    public w(String[] strArr) {
        this.f657a = strArr;
    }

    public final String b(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        String[] strArr = this.f657a;
        int length = strArr.length - 2;
        int iD = Z6.k.D(length, 0, -2);
        if (iD > length) {
            return null;
        }
        while (!name.equalsIgnoreCase(strArr[length])) {
            if (length == iD) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final String e(int i) {
        return this.f657a[i * 2];
    }

    public final boolean equals(Object obj) {
        if (obj instanceof w) {
            return Arrays.equals(this.f657a, ((w) obj).f657a);
        }
        return false;
    }

    public final Set f() {
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.k.e(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        TreeSet treeSet = new TreeSet(CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(e(i));
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        kotlin.jvm.internal.k.e(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final v g() {
        v vVar = new v(0);
        D7.A.g0(vVar.f656a, this.f657a);
        return vVar;
    }

    public final String h(int i) {
        return this.f657a[(i * 2) + 1];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f657a);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = new Pair(e(i), h(i));
        }
        return kotlin.jvm.internal.k.j(pairArr);
    }

    public final int size() {
        return this.f657a.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strE = e(i);
            String strH = h(i);
            sb.append(strE);
            sb.append(": ");
            if (G9.b.o(strE)) {
                strH = "██";
            }
            sb.append(strH);
            sb.append("\n");
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
