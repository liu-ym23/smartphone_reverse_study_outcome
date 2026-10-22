package okhttp3;

import androidx.datastore.preferences.protobuf.b1;
import bd.i;
import gc.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import mb.l;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements Iterable<Pair<? extends String, ? extends String>>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f10975a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f10976a = new ArrayList(20);

        public final void a(String name, String value) {
            kotlin.jvm.internal.g.f(name, "name");
            kotlin.jvm.internal.g.f(value, "value");
            bd.b.b(name);
            bd.b.c(value, name);
            bd.b.a(this, name, value);
        }

        public final f b() {
            return new f((String[]) this.f10976a.toArray(new String[0]));
        }

        public final void c(String name) {
            kotlin.jvm.internal.g.f(name, "name");
            int i10 = 0;
            while (true) {
                ArrayList arrayList = this.f10976a;
                if (i10 >= arrayList.size()) {
                    return;
                }
                if (name.equalsIgnoreCase((String) arrayList.get(i10))) {
                    arrayList.remove(i10);
                    arrayList.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
        public static f a(String... strArr) {
            String[] inputNamesAndValues = (String[]) Arrays.copyOf(strArr, strArr.length);
            kotlin.jvm.internal.g.f(inputNamesAndValues, "inputNamesAndValues");
            if (inputNamesAndValues.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr2 = (String[]) Arrays.copyOf(inputNamesAndValues, inputNamesAndValues.length);
            int length = strArr2.length;
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (strArr2[i11] == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr2[i11] = q.L0(inputNamesAndValues[i11]).toString();
            }
            int iZ = y.z(0, strArr2.length - 1, 2);
            if (iZ >= 0) {
                while (true) {
                    String str = strArr2[i10];
                    String str2 = strArr2[i10 + 1];
                    bd.b.b(str);
                    bd.b.c(str2, str);
                    if (i10 == iZ) {
                        break;
                    }
                    i10 += 2;
                }
            }
            return new f(strArr2);
        }
    }

    public f(String[] namesAndValues) {
        kotlin.jvm.internal.g.f(namesAndValues, "namesAndValues");
        this.f10975a = namesAndValues;
    }

    public final String a(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        String[] namesAndValues = this.f10975a;
        kotlin.jvm.internal.g.f(namesAndValues, "namesAndValues");
        int length = namesAndValues.length - 2;
        int iZ = y.z(length, 0, -2);
        if (iZ > length) {
            return null;
        }
        while (!name.equalsIgnoreCase(namesAndValues[length])) {
            if (length == iZ) {
                return null;
            }
            length -= 2;
        }
        return namesAndValues[length + 1];
    }

    public final String b(int i10) {
        String str = (String) l.g0(this.f10975a, i10 * 2);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i10 + ']');
    }

    public final Set<String> c() {
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.g.e(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        TreeSet treeSet = new TreeSet(CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(b(i10));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        kotlin.jvm.internal.g.e(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public final a e() {
        a aVar = new a();
        ArrayList arrayList = aVar.f10976a;
        kotlin.jvm.internal.g.f(arrayList, "<this>");
        String[] elements = this.f10975a;
        kotlin.jvm.internal.g.f(elements, "elements");
        arrayList.addAll(b1.g(elements));
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return Arrays.equals(this.f10975a, ((f) obj).f10975a);
        }
        return false;
    }

    public final TreeMap f() {
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.g.e(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        TreeMap treeMap = new TreeMap(CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String strB = b(i10);
            Locale US = Locale.US;
            kotlin.jvm.internal.g.e(US, "US");
            String lowerCase = strB.toLowerCase(US);
            kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(g(i10));
        }
        return treeMap;
    }

    public final String g(int i10) {
        String str = (String) l.g0(this.f10975a, (i10 * 2) + 1);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i10 + ']');
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f10975a);
    }

    @Override // java.lang.Iterable
    public final Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i10 = 0; i10 < size; i10++) {
            pairArr[i10] = new Pair(b(i10), g(i10));
        }
        return b1.O(pairArr);
    }

    public final int size() {
        return this.f10975a.length / 2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String strB = b(i10);
            String strG = g(i10);
            sb2.append(strB);
            sb2.append(": ");
            if (i.k(strB)) {
                strG = "██";
            }
            sb2.append(strG);
            sb2.append("\n");
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }
}
