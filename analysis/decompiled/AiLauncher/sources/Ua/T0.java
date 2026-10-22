package Ua;

import kotlin.Metadata;
import kotlin.coroutines.d;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"LUa/T0;", "Lkotlin/coroutines/d$b;", "Lkotlin/coroutines/d$c;", "<init>", "()V", "getKey", "()Lkotlin/coroutines/d$c;", "key", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class T0 implements d.b, d.c<T0> {

    /* renamed from: a, reason: collision with root package name */
    public static final T0 f6349a = new T0();

    @Override // kotlin.coroutines.d
    public /* bridge */ <R> R fold(R r10, p9.p<? super R, ? super d.b, ? extends R> pVar) {
        return (R) d.b.a.a(this, r10, pVar);
    }

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    public /* bridge */ <E extends d.b> E get(d.c<E> cVar) {
        return (E) d.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.d.b
    public d.c<?> getKey() {
        return this;
    }

    @Override // kotlin.coroutines.d
    public /* bridge */ kotlin.coroutines.d minusKey(d.c<?> cVar) {
        return d.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.d
    public /* bridge */ kotlin.coroutines.d plus(kotlin.coroutines.d dVar) {
        return d.b.a.d(this, dVar);
    }
}
