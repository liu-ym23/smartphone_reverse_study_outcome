package d7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class w extends v {
    public static void C0(List list, Comparator comparator) {
        q7.k.e(list, "<this>");
        q7.k.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
