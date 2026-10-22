package io.ktor.server.websocket;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.routing.RoutingCall;
import io.ktor.server.routing.RoutingContext;
import io.ktor.websocket.WebSocketSession;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.websocket.RoutingKt$webSocketRaw$2$1$1$1", f = "Routing.kt", l = {116}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class RoutingKt$webSocketRaw$2$1$1$1 extends SuspendLambda implements p<RoutingContext, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ p<WebSocketServerSession, InterfaceC4014c<? super t>, Object> $handler;
    final /* synthetic */ boolean $negotiateExtensions;
    final /* synthetic */ String $protocol;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/websocket/WebSocketSession;", "LY8/t;", "<anonymous>", "(Lio/ktor/websocket/WebSocketSession;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.websocket.RoutingKt$webSocketRaw$2$1$1$1$1", f = "Routing.kt", l = {117}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.websocket.RoutingKt$webSocketRaw$2$1$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<WebSocketSession, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ RoutingContext $$this$handle;
        final /* synthetic */ p<WebSocketServerSession, InterfaceC4014c<? super t>, Object> $handler;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p<? super WebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, RoutingContext routingContext, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$handler = pVar;
            this.$$this$handle = routingContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, this.$$this$handle, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(WebSocketSession webSocketSession, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(webSocketSession, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                WebSocketSession webSocketSession = (WebSocketSession) this.L$0;
                p<WebSocketServerSession, InterfaceC4014c<? super t>, Object> pVar = this.$handler;
                WebSocketServerSession serverSession = WebSocketServerSessionKt.toServerSession(webSocketSession, this.$$this$handle.getCall());
                this.label = 1;
                if (pVar.invoke(serverSession, this) == objG) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoutingKt$webSocketRaw$2$1$1$1(String str, boolean z10, p<? super WebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super RoutingKt$webSocketRaw$2$1$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$protocol = str;
        this.$negotiateExtensions = z10;
        this.$handler = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        RoutingKt$webSocketRaw$2$1$1$1 routingKt$webSocketRaw$2$1$1$1 = new RoutingKt$webSocketRaw$2$1$1$1(this.$protocol, this.$negotiateExtensions, this.$handler, interfaceC4014c);
        routingKt$webSocketRaw$2$1$1$1.L$0 = obj;
        return routingKt$webSocketRaw$2$1$1$1;
    }

    @Override // p9.p
    public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((RoutingKt$webSocketRaw$2$1$1$1) create(routingContext, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            RoutingContext routingContext = (RoutingContext) this.L$0;
            RoutingCall call = routingContext.getCall();
            String str = this.$protocol;
            boolean z10 = this.$negotiateExtensions;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, routingContext, null);
            this.label = 1;
            if (RoutingKt.respondWebSocketRaw(call, str, z10, anonymousClass1, this) == objG) {
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
