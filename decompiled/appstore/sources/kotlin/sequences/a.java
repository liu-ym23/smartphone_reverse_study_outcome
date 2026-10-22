package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Sequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f21207a;

    public a(Sequence r10) {
        q.g(r10, "sequence");
        this.f21207a = new AtomicReference(r10);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        Sequence r10 = (Sequence) this.f21207a.getAndSet(null);
        if (r10 == null) goto L7;
        return r10.iterator();
    L7:
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
