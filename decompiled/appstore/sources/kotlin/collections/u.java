package kotlin.collections;

import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u extends t {
    public static int r(Iterable r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == true) goto L5;
        return r11;
    L5:
        return ((Collection) r10).size();
    }

    public static final Integer s(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(((Collection) r10).size());
    }
}
