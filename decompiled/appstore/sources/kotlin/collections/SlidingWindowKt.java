package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SlidingWindowKt {
    public static final void a(int r10, int r11) {
        if (r10 <= 0) goto L6;
        if (r11 <= 0) goto L6;
        return;
    L6:
        if (r10 == r11) goto L8;
        String r12 = "Both size " + r10 + " and step " + r11 + " must be greater than zero.";
    L10:
        throw new IllegalArgumentException(r12.toString());
    L8:
        r12 = "size " + r10 + " must be greater than zero.";
        goto L10
    }

    public static final Iterator b(Iterator r10, int r11, int r12, boolean r13, boolean r14) {
        kotlin.jvm.internal.q.g(r10, "iterator");
        if (r10.hasNext() == true) goto L7;
        return d0.f21090a;
    L7:
        return kotlin.sequences.h.a(new SlidingWindowKt$windowedIterator$1(r11, r12, r10, r14, r13, null));
    }
}
