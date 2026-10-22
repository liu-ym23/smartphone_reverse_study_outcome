package androidx.room;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class w0 implements CoroutineContext.Element {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f4708c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContinuationInterceptor f4709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f4710b;

    public static final class a implements CoroutineContext.Key {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f4708c = new a(null);
    }

    public w0(ContinuationInterceptor r10) {
        this.f4709a = r10;
        this.f4710b = new AtomicInteger(0);
    }

    public final void a() {
        this.f4710b.incrementAndGet();
    }

    public final ContinuationInterceptor b() {
        return this.f4709a;
    }

    public final void c() {
        if (this.f4710b.decrementAndGet() < 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Transaction was never started or was already released.");
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object r10, Function2 r11) {
        return CoroutineContext.Element.a.a(this, r10, r11);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key r10) {
        return CoroutineContext.Element.a.b(this, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key getKey() {
        return f4708c;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key r10) {
        return CoroutineContext.Element.a.c(this, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r10) {
        return CoroutineContext.Element.a.d(this, r10);
    }
}
