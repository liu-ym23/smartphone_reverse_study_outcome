package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ak<T> implements d.h.b.a.a, Iterator<ai<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterator<T> f38351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f38352b;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ak(Iterator<? extends T> r3) {
        Iterator<T> r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "iterator");
        this.f38351a = r4;
    }

    @Override // java.util.Iterator
    public /* synthetic */ Object next() {
        return a();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f38351a.hasNext();
    }

    public final ai<T> a() {
        int r1 = this.f38352b;
        this.f38352b = r1 + 1;
        if (r1 >= 0) goto L6;
        p.c();
    L6:
        return new ai(r1, this.f38351a.next());
    }
}
