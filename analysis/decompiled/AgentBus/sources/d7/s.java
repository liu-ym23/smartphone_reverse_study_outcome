package d7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class s extends a.a {
    public static ArrayList q0(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new l(objArr, true));
    }

    public static int r0(ArrayList arrayList, Comparable comparable) {
        int size = arrayList.size();
        q7.k.e(arrayList, "<this>");
        int size2 = arrayList.size();
        int i2 = 0;
        if (size < 0) {
            throw new IllegalArgumentException("fromIndex (0) is greater than toIndex (" + size + ").");
        }
        if (size > size2) {
            throw new IndexOutOfBoundsException("toIndex (" + size + ") is greater than size (" + size2 + ").");
        }
        int i10 = size - 1;
        while (i2 <= i10) {
            int i11 = (i2 + i10) >>> 1;
            int iQ = ib.k.q((Comparable) arrayList.get(i11), comparable);
            if (iQ < 0) {
                i2 = i11 + 1;
            } else {
                if (iQ <= 0) {
                    return i11;
                }
                i10 = i11 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static v7.d s0(Collection collection) {
        q7.k.e(collection, "<this>");
        return new v7.d(0, collection.size() - 1, 1);
    }

    public static int t0(List list) {
        q7.k.e(list, "<this>");
        return list.size() - 1;
    }

    public static List u0(Object... objArr) {
        q7.k.e(objArr, "elements");
        return objArr.length > 0 ? n.S(objArr) : z.f2978f;
    }

    public static ArrayList v0(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static List w0(Object obj) {
        return obj != null ? a.a.S(obj) : z.f2978f;
    }

    public static ArrayList x0(Object... objArr) {
        q7.k.e(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new l(objArr, true));
    }

    public static final List y0(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : a.a.S(list.get(0)) : z.f2978f;
    }

    public static void z0() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
