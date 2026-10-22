package d7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class t extends s {
    public static int A0(Iterable iterable, int i2) {
        q7.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }

    public static ArrayList B0(Iterable iterable) {
        q7.k.e(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            x.D0(arrayList, (Iterable) it.next());
        }
        return arrayList;
    }
}
