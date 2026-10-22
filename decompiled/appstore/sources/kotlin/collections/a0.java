package kotlin.collections;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a0 extends z {
    public static void O(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Collections.reverse(r10);
    }

    public static SortedSet P(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return (SortedSet) b0.v0(r10, new TreeSet());
    }
}
