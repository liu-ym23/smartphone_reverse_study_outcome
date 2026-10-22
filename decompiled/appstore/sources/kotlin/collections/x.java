package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class x extends w {
    public static final void t(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.size() <= 1) goto L6;
        Collections.sort(r10);
        return;
    }

    public static void u(List r10, Comparator r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "comparator");
        if (r10.size() <= 1) goto L6;
        Collections.sort(r10, r11);
        return;
    }
}
