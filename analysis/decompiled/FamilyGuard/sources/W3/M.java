package W3;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class M extends L {
    public static <T> Set<T> b() {
        return B.f5745a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> set) {
        j4.k.g(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : L.a(set.iterator().next()) : b();
    }
}
