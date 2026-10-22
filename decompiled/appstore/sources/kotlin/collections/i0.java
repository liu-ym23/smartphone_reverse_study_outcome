package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i0 {
    public static final Object a(Map r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof MapWithDefault) == true) goto L5;
        Object r12 = r10.get(r11);
        if (r12 == null) goto L9;
    L13:
        return r12;
    L9:
        if (r10.containsKey(r11) == true) goto L13;
        throw new NoSuchElementException("Key " + r11 + " is missing in the map.");
    L5:
        return ((MapWithDefault) r10).getOrImplicitDefault(r11);
    }
}
