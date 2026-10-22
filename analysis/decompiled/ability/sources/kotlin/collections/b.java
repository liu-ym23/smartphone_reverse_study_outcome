package kotlin.collections;

import D7.B;
import java.util.Iterator;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class b {
    public static final void a(int i, int i6) {
        if (i <= 0 || i6 <= 0) {
            throw new IllegalArgumentException((i != i6 ? androidx.compose.foundation.b.o(i, "Both size ", i6, " and step ", " must be greater than zero.") : androidx.appfunctions.metadata.a.i(i, "size ", " must be greater than zero.")).toString());
        }
    }

    public static final Iterator b(Iterator iterator, int i, int i6, boolean z10, boolean z11) {
        k.f(iterator, "iterator");
        return !iterator.hasNext() ? B.f392a : U7.a.K(new SlidingWindowKt$windowedIterator$1(i, i6, iterator, z11, z10, null));
    }
}
