package D7;

import java.util.Collection;

/* loaded from: classes3.dex */
public abstract class w extends H4.o {
    public static int c0(Iterable iterable, int i) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
