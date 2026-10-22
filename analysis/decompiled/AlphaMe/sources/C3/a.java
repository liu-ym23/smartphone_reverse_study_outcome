package C3;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public abstract class a extends AbstractQueue {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f348a;

    /* renamed from: b, reason: collision with root package name */
    public final int f349b;

    public a(int i4) {
        int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(i4 - 1));
        this.f349b = iNumberOfLeadingZeros - 1;
        this.f348a = new AtomicReferenceArray(iNumberOfLeadingZeros);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        while (true) {
            if (((b) this).poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}
