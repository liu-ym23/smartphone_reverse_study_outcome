package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends g implements Iterator, Continuation, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f21228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f21229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Continuation f21230d;

    public f() {
    }

    @Override // kotlin.sequences.g
    public Object a(Object r10, Continuation r11) {
        this.f21228b = r10;
        this.f21227a = 3;
        this.f21230d = r11;
        Object r12 = kotlin.coroutines.intrinsics.a.d();
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        tf.d.c(r11);
    L6:
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L9;
        return r12;
    L9:
        return Unit.f21064a;
    }

    @Override // kotlin.sequences.g
    public Object b(Iterator r10, Continuation r11) {
        if (r10.hasNext() == false) goto L5;
        this.f21229c = r10;
        this.f21227a = 2;
        this.f21230d = r11;
        Object r12 = kotlin.coroutines.intrinsics.a.d();
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L10;
        tf.d.c(r11);
    L10:
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L13;
        return r12;
    L13:
        return Unit.f21064a;
    L5:
        return Unit.f21064a;
    }

    public final Throwable d() {
        int r10 = this.f21227a;
        if (r10 == 4) goto L9;
        if (r10 == 5) goto L11;
        return new IllegalStateException("Unexpected state of the iterator: " + this.f21227a);
    L11:
        return new IllegalStateException("Iterator has failed.");
    L9:
        return new NoSuchElementException();
    }

    public final Object e() {
        if (hasNext() == false) goto L7;
        return next();
    L7:
        throw new NoSuchElementException();
    }

    public final void f(Continuation r10) {
        this.f21230d = r10;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
    L2:
        int r10 = this.f21227a;
        if (r10 == 0) goto L21;
        if (r10 != 1) goto L6;
        Iterator r11 = this.f21229c;
        q.d(r11);
        if (r11.hasNext() == true) goto L18;
        this.f21229c = null;
        goto L21
    L18:
        this.f21227a = 2;
        return true;
    L6:
        if (r10 != 2) goto L8;
    L15:
        return true;
    L8:
        if (r10 == 3) goto L15;
        if (r10 != 4) goto L14;
        return false;
    L14:
        throw d();
    L21:
        this.f21227a = 5;
        Continuation r12 = this.f21230d;
        q.d(r12);
        this.f21230d = null;
        Result.a r13 = Result.Companion;
        r12.resumeWith(Result.m35constructorimpl(Unit.f21064a));
        goto L2
    }

    @Override // java.util.Iterator
    public Object next() {
        int r10 = this.f21227a;
        if (r10 == 0) goto L17;
        if (r10 == 1) goto L17;
        if (r10 != 2) goto L9;
        this.f21227a = 1;
        Iterator r11 = this.f21229c;
        q.d(r11);
        return r11.next();
    L9:
        if (r10 != 3) goto L13;
        this.f21227a = 0;
        Object r12 = this.f21228b;
        this.f21228b = null;
        return r12;
    L13:
        throw d();
    L17:
        return e();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
        kotlin.c.b(r10);
        this.f21227a = 4;
    }
}
