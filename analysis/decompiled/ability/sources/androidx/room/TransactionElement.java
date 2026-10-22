package androidx.room;

import H7.e;
import H7.f;
import H7.g;
import H7.h;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import z2.l;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/room/TransactionElement;", "LH7/f;", "LH7/e;", "transactionDispatcher", AppAgent.CONSTRUCT, "(LH7/e;)V", "LH7/e;", "getTransactionDispatcher$room_runtime", "()LH7/e;", "LH7/g;", "getKey", "()LH7/g;", "key", "Key", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransactionElement implements f {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final e transactionDispatcher;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/room/TransactionElement$Key;", "LH7/g;", "Landroidx/room/TransactionElement;", AppAgent.CONSTRUCT, "()V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.TransactionElement$Key, reason: from kotlin metadata */
    public static final class Companion implements g {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public TransactionElement(e transactionDispatcher) {
        k.f(transactionDispatcher, "transactionDispatcher");
        this.transactionDispatcher = transactionDispatcher;
    }

    @Override // H7.h
    public <R> R fold(R r5, n nVar) {
        return (R) l.w(this, r5, nVar);
    }

    @Override // H7.h
    public <E extends f> E get(g gVar) {
        return (E) l.x(this, gVar);
    }

    @Override // H7.f
    public g getKey() {
        return INSTANCE;
    }

    /* renamed from: getTransactionDispatcher$room_runtime, reason: from getter */
    public final e getTransactionDispatcher() {
        return this.transactionDispatcher;
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
