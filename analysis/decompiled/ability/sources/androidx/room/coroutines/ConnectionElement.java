package androidx.room.coroutines;

import H7.f;
import H7.g;
import H7.h;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import z2.l;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/room/coroutines/ConnectionElement;", "LH7/f;", "LH7/g;", "key", "Landroidx/room/coroutines/PooledConnectionImpl;", "connectionWrapper", AppAgent.CONSTRUCT, "(LH7/g;Landroidx/room/coroutines/PooledConnectionImpl;)V", "LH7/g;", "getKey", "()LH7/g;", "Landroidx/room/coroutines/PooledConnectionImpl;", "getConnectionWrapper", "()Landroidx/room/coroutines/PooledConnectionImpl;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class ConnectionElement implements f {
    private final PooledConnectionImpl connectionWrapper;
    private final g key;

    public ConnectionElement(g key, PooledConnectionImpl connectionWrapper) {
        k.f(key, "key");
        k.f(connectionWrapper, "connectionWrapper");
        this.key = key;
        this.connectionWrapper = connectionWrapper;
    }

    @Override // H7.h
    public <R> R fold(R r5, n nVar) {
        return (R) l.w(this, r5, nVar);
    }

    @Override // H7.h
    public <E extends f> E get(g gVar) {
        return (E) l.x(this, gVar);
    }

    public final PooledConnectionImpl getConnectionWrapper() {
        return this.connectionWrapper;
    }

    @Override // H7.f
    public g getKey() {
        return this.key;
    }

    @Override // H7.h
    public h minusKey(g gVar) {
        return l.C(this, gVar);
    }

    @Override // H7.h
    public h plus(h hVar) {
        return l.H(this, hVar);
    }
}
