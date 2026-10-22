package io.ktor.client.engine;

import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lio/ktor/client/engine/KtorCallContextElement;", "Lkotlin/coroutines/d$b;", "Lkotlin/coroutines/d;", "callContext", "<init>", "(Lkotlin/coroutines/d;)V", "Lkotlin/coroutines/d;", "getCallContext", "()Lkotlin/coroutines/d;", "Lkotlin/coroutines/d$c;", "getKey", "()Lkotlin/coroutines/d$c;", "key", "Companion", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KtorCallContextElement implements d.b {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final kotlin.coroutines.d callContext;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/client/engine/KtorCallContextElement$Companion;", "Lkotlin/coroutines/d$c;", "Lio/ktor/client/engine/KtorCallContextElement;", "<init>", "()V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion implements d.c<KtorCallContextElement> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private Companion() {
        }
    }

    public KtorCallContextElement(kotlin.coroutines.d callContext) {
        p.i(callContext, "callContext");
        this.callContext = callContext;
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r10, p9.p<? super R, ? super d.b, ? extends R> pVar) {
        return (R) d.b.a.a(this, r10, pVar);
    }

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    public <E extends d.b> E get(d.c<E> cVar) {
        return (E) d.b.a.b(this, cVar);
    }

    public final kotlin.coroutines.d getCallContext() {
        return this.callContext;
    }

    @Override // kotlin.coroutines.d.b
    public d.c<?> getKey() {
        return INSTANCE;
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
