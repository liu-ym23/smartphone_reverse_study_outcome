package io.ktor.server.sse;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/sse/ServerSSESession;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/sse/ServerSSESession;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.sse.RoutingKt$processSSEWithSerialization$sessionHandler$1", f = "Routing.kt", l = {167}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class RoutingKt$processSSEWithSerialization$sessionHandler$1 extends SuspendLambda implements p<ServerSSESession, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ p<ServerSSESessionWithSerialization, InterfaceC4014c<? super t>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoutingKt$processSSEWithSerialization$sessionHandler$1(p<? super ServerSSESessionWithSerialization, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super RoutingKt$processSSEWithSerialization$sessionHandler$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$handler = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        RoutingKt$processSSEWithSerialization$sessionHandler$1 routingKt$processSSEWithSerialization$sessionHandler$1 = new RoutingKt$processSSEWithSerialization$sessionHandler$1(this.$handler, interfaceC4014c);
        routingKt$processSSEWithSerialization$sessionHandler$1.L$0 = obj;
        return routingKt$processSSEWithSerialization$sessionHandler$1;
    }

    @Override // p9.p
    public final Object invoke(ServerSSESession serverSSESession, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((RoutingKt$processSSEWithSerialization$sessionHandler$1) create(serverSSESession, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            ServerSSESession serverSSESession = (ServerSSESession) this.L$0;
            if (!(serverSSESession instanceof ServerSSESessionWithSerialization)) {
                throw new IllegalStateException("Impossible state. Please report this bug: https://youtrack.jetbrains.com/newIssue?project=KTOR");
            }
            p<ServerSSESessionWithSerialization, InterfaceC4014c<? super t>, Object> pVar = this.$handler;
            this.label = 1;
            if (pVar.invoke(serverSSESession, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
