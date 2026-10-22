package W3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o {
    public static final <T> Object[] a(T[] tArr, boolean z5) {
        j4.k.g(tArr, "<this>");
        if (z5 && j4.k.b(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        j4.k.f(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static <T> List<T> b(T t5) {
        List<T> listSingletonList = Collections.singletonList(t5);
        j4.k.f(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static final <T> T[] c(int i5, T[] tArr) {
        j4.k.g(tArr, "array");
        if (i5 < tArr.length) {
            tArr[i5] = null;
        }
        return tArr;
    }
}
