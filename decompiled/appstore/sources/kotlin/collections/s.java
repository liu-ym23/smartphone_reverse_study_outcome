package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;

/* JADX INFO: loaded from: classes4.dex */
public abstract class s {
    public static List a(List r10) {
        kotlin.jvm.internal.q.g(r10, "builder");
        return ((ListBuilder) r10).build();
    }

    public static final Object[] b(Object[] r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 == true) goto L5;
    L7:
        Object[] r12 = Arrays.copyOf(r10, r10.length, Object[].class);
        kotlin.jvm.internal.q.f(r12, "copyOf(...)");
        return r12;
    L5:
        if (kotlin.jvm.internal.q.b(r10.getClass(), Object[].class) == false) goto L7;
        return r10;
    }

    public static List c() {
        return new ListBuilder();
    }

    public static List d(int r10) {
        return new ListBuilder(r10);
    }

    public static List e(Object r10) {
        List r11 = Collections.singletonList(r10);
        kotlin.jvm.internal.q.f(r11, "singletonList(...)");
        return r11;
    }

    public static Object[] f(int r10, Object[] r11) {
        kotlin.jvm.internal.q.g(r11, "array");
        if (r10 >= r11.length) goto L5;
        r11[r10] = null;
    L5:
        return r11;
    }
}
