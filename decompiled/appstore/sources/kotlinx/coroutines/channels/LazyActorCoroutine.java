package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes4.dex */
public final class LazyActorCoroutine extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Continuation f21357e;

    public LazyActorCoroutine(CoroutineContext r10, Channel r11, Function2 r12) {
        super(r10, r11, false);
        this.f21357e = IntrinsicsKt__IntrinsicsJvmKt.b(r12, this, this);
    }

    public static final /* synthetic */ void s0(LazyActorCoroutine r10, SelectInstance r11, Object r12) {
        r10.t0(r11, r12);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void X() {
        cg.a.b(this.f21357e, this);
    }

    @Override // kotlinx.coroutines.channels.d, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable r10) {
        boolean r11 = super.close(r10);
        start();
        return r11;
    }

    @Override // kotlinx.coroutines.channels.d, kotlinx.coroutines.channels.SendChannel
    public SelectClause2 getOnSend() {
        LazyActorCoroutine$onSend$1 r10 = LazyActorCoroutine$onSend$1.INSTANCE;
        q.e(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.e(this, (Function3) y.e(r10, 3), super.getOnSend().getProcessResFunc(), null, 8, null);
    }

    @Override // kotlinx.coroutines.channels.d, kotlinx.coroutines.channels.SendChannel
    public boolean offer(Object r10) {
        start();
        return super.offer(r10);
    }

    @Override // kotlinx.coroutines.channels.d, kotlinx.coroutines.channels.SendChannel
    public Object send(Object r10, Continuation r11) {
        start();
        Object r12 = super.send(r10, r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }

    public final void t0(SelectInstance r10, Object r11) {
        X();
        super.getOnSend().getRegFunc().invoke(this, r10, r11);
    }

    @Override // kotlinx.coroutines.channels.d, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo53trySendJP2dKIU(Object r10) {
        start();
        return super.mo53trySendJP2dKIU(r10);
    }
}
