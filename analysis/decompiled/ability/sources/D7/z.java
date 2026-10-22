package D7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class z extends y {
    public static void d0(Comparator comparator, List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        kotlin.jvm.internal.k.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
