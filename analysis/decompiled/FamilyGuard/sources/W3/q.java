package W3;

import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends p {
    public static <T> int r(Iterable<? extends T> iterable, int i5) {
        j4.k.g(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i5;
    }
}
