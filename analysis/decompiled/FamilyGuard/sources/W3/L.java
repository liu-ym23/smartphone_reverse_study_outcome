package W3;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
class L {
    public static final <T> Set<T> a(T t5) {
        Set<T> setSingleton = Collections.singleton(t5);
        j4.k.f(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
