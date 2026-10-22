package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
final class k<T> extends l<T> implements d.c.d<x>, d.h.b.a.a, Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f38593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f38594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Iterator<? extends T> f38595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.c.d<? super x> f38596d;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public k() {
    }

    public final void a(d.c.d<? super x> r3) {
        this.f38596d = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
    L2:
        int r0 = this.f38593a;
        if (r0 == 0) goto L21;
        if (r0 != 1) goto L6;
        Iterator<? extends T> r1 = this.f38595c;
        d.h.b.o.a(r1);
        if (r1.hasNext() == true) goto L18;
        this.f38595c = null;
        goto L21
    L18:
        this.f38593a = 2;
        return true;
    L6:
        if (r0 != 2) goto L8;
    L15:
        return true;
    L8:
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L14;
        return false;
    L14:
        throw b();
    L21:
        this.f38593a = 5;
        d.c.d<? super x> r2 = this.f38596d;
        d.h.b.o.a(r2);
        this.f38596d = null;
        d.n.a r3 = d.n.f38560a;
        r2.resumeWith(d.n.f(x.f38692a));
        goto L2
    }

    @Override // java.util.Iterator
    public T next() {
        int r0 = this.f38593a;
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L17;
        if (r0 != 2) goto L9;
        this.f38593a = 1;
        Iterator<? extends T> r3 = this.f38595c;
        d.h.b.o.a(r3);
        return r3.next();
    L9:
        if (r0 != 3) goto L13;
        this.f38593a = 0;
        T r1 = this.f38594b;
        this.f38594b = null;
        return r1;
    L13:
        throw b();
    L17:
        return a();
    }

    private final T a() {
        if (hasNext() == false) goto L7;
        return next();
    L7:
        throw new NoSuchElementException();
    }

    private final Throwable b() {
        int r0 = this.f38593a;
        if (r0 == 4) goto L9;
        if (r0 == 5) goto L11;
        return (Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Unexpected state of the iterator: " + this.f38593a), Throwable.class, "com.obric.aiagent.plugin");
    L11:
        return (Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Iterator has failed."), Throwable.class, "com.obric.aiagent.plugin");
    L9:
        return (Throwable) ZeusTransformUtils.preCheckCast(new NoSuchElementException(), Throwable.class, "com.obric.aiagent.plugin");
    }

    @Override // d.n.l
    public Object a(T r3, d.c.d<? super x> r4) {
        d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        this.f38594b = r3;
        this.f38593a = 3;
        this.f38596d = r5;
        Object r2 = d.c.a.b.a();
        if (r2 != d.c.a.b.a()) goto L6;
        d.c.b.a.h.c(r5);
    L6:
        if (r2 != d.c.a.b.a()) goto L9;
        return r2;
    L9:
        return x.f38692a;
    }

    @Override // d.n.l
    public Object a(Iterator<? extends T> r3, d.c.d<? super x> r4) {
        Iterator<? extends T> r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (r5.hasNext() == false) goto L5;
        this.f38595c = r5;
        this.f38593a = 2;
        this.f38596d = r6;
        Object r2 = d.c.a.b.a();
        if (r2 != d.c.a.b.a()) goto L10;
        d.c.b.a.h.c(r6);
    L10:
        if (r2 != d.c.a.b.a()) goto L13;
        return r2;
    L13:
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    @Override // d.c.d
    public void resumeWith(Object r1) {
        d.o.a(r1);
        this.f38593a = 4;
    }

    @Override // d.c.d
    public d.c.g getContext() {
        return (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    }
}
