package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends b {
    public a() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        if (c() != a()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode r10 = c();
        LinkedQueueNode r11 = a();
        int r12 = 0;
    L3:
        if (r10 == r11) goto L10;
        if (r12 >= Integer.MAX_VALUE) goto L10;
    L6:
        LinkedQueueNode r13 = r10.lvNext();
        if (r13 == null) goto L6;
        r12 = r12 + 1;
        r10 = r13;
    L10:
        return r12;
    }
}
