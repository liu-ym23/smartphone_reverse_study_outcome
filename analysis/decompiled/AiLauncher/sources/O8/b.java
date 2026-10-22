package O8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class b {
    @SafeVarargs
    public static <T> List<T> a(T... tArr) {
        int length = tArr != null ? tArr.length : 0;
        ArrayList arrayList = new ArrayList(length);
        if (length > 0) {
            Collections.addAll(arrayList, tArr);
        }
        return arrayList;
    }
}
