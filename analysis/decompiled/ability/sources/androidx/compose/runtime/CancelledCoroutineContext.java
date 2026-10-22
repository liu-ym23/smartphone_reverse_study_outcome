package androidx.compose.runtime;

import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/CancelledCoroutineContext;", "LH7/f;", AppAgent.CONSTRUCT, "()V", "LH7/g;", "getKey", "()LH7/g;", "key", "Key", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class CancelledCoroutineContext implements H7.f {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/CancelledCoroutineContext$Key;", "LH7/g;", "Landroidx/compose/runtime/CancelledCoroutineContext;", AppAgent.CONSTRUCT, "()V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.CancelledCoroutineContext$Key, reason: from kotlin metadata */
    public static final class Companion implements H7.g {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    @Override // H7.h
    public <R> R fold(R r5, n nVar) {
        return (R) z2.l.w(this, r5, nVar);
    }

    @Override // H7.h
    public <E extends H7.f> E get(H7.g gVar) {
        return (E) z2.l.x(this, gVar);
    }

    @Override // H7.f
    public H7.g getKey() {
        return INSTANCE;
    }

    @Override // H7.h
    public H7.h minusKey(H7.g gVar) {
        return z2.l.C(this, gVar);
    }

    @Override // H7.h
    public H7.h plus(H7.h hVar) {
        return z2.l.H(this, hVar);
    }
}
