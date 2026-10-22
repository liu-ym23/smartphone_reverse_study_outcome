package W3;

import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends s {
    public static <T extends Comparable<? super T>> void s(List<T> list) {
        j4.k.g(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
