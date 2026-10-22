package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/coroutines/a;", "Lkotlin/coroutines/d$b;", "Lkotlin/coroutines/d$c;", "key", "<init>", "(Lkotlin/coroutines/d$c;)V", "Lkotlin/coroutines/d$c;", "getKey", "()Lkotlin/coroutines/d$c;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class a implements d.b {
    private final d.c<?> key;

    public a(d.c<?> key) {
        p.i(key, "key");
        this.key = key;
    }

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
        return this.key;
    }

    @Override // kotlin.coroutines.d
    public /* bridge */ d minusKey(d.c<?> cVar) {
        return d.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.d
    public /* bridge */ d plus(d dVar) {
        return d.b.a.d(this, dVar);
    }
}
