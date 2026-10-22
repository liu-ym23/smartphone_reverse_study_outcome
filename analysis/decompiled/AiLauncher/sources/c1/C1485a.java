package c1;

import androidx.room.coroutines.PooledConnectionImpl;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000e¨\u0006\u000f"}, d2 = {"Lc1/a;", "Lkotlin/coroutines/d$b;", "Lkotlin/coroutines/d$c;", "key", "Landroidx/room/coroutines/PooledConnectionImpl;", "connectionWrapper", "<init>", "(Lkotlin/coroutines/d$c;Landroidx/room/coroutines/PooledConnectionImpl;)V", Const.INTENT_KEY_APIKEY, "Lkotlin/coroutines/d$c;", "getKey", "()Lkotlin/coroutines/d$c;", Const.INTENT_KEY_PKGNAME, "Landroidx/room/coroutines/PooledConnectionImpl;", "()Landroidx/room/coroutines/PooledConnectionImpl;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: c1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1485a implements d.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final d.c<C1485a> key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final PooledConnectionImpl connectionWrapper;

    public C1485a(d.c<C1485a> key, PooledConnectionImpl connectionWrapper) {
        p.i(key, "key");
        p.i(connectionWrapper, "connectionWrapper");
        this.key = key;
        this.connectionWrapper = connectionWrapper;
    }

    /* renamed from: a, reason: from getter */
    public final PooledConnectionImpl getConnectionWrapper() {
        return this.connectionWrapper;
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r10, p9.p<? super R, ? super d.b, ? extends R> pVar) {
        return (R) d.b.a.a(this, r10, pVar);
    }

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    public <E extends d.b> E get(d.c<E> cVar) {
        return (E) d.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.d.b
    public d.c<C1485a> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.d
    public kotlin.coroutines.d minusKey(d.c<?> cVar) {
        return d.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.d
    public kotlin.coroutines.d plus(kotlin.coroutines.d dVar) {
        return d.b.a.d(this, dVar);
    }
}
