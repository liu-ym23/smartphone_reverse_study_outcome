package io.modelcontextprotocol.kotlin.sdk.server;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.routing.Route;
import io.ktor.server.websocket.DefaultWebSocketServerSession;
import io.ktor.server.websocket.RoutingKt;
import io.ktor.server.websocket.WebSocketServerSession;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aC\u0010\t\u001a\u00020\u0006*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012$\b\u0002\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\t\u0010\n\u001aK\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012$\b\u0002\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\t\u0010\r\u001a7\u0010\u000f\u001a\u00020\u0006*\u00020\u00002$\b\u0002\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a?\u0010\u000f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2$\b\u0002\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\u000f\u0010\u0011\u001aJ\u0010\u0014\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/server/routing/Route;", "Lio/modelcontextprotocol/kotlin/sdk/server/ServerOptions;", "options", "Lkotlin/Function2;", "Lio/modelcontextprotocol/kotlin/sdk/server/Server;", "Le9/c;", "LY8/t;", "", "handler", "mcpWebSocket", "(Lio/ktor/server/routing/Route;Lio/modelcontextprotocol/kotlin/sdk/server/ServerOptions;Lp9/p;)V", "", "path", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/server/ServerOptions;Lp9/p;)V", "Lio/modelcontextprotocol/kotlin/sdk/server/WebSocketMcpServerTransport;", "mcpWebSocketTransport", "(Lio/ktor/server/routing/Route;Lp9/p;)V", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lp9/p;)V", "Lio/ktor/server/websocket/WebSocketServerSession;", "session", "createMcpServer", "(Lio/ktor/server/routing/Route;Lio/ktor/server/websocket/WebSocketServerSession;Lio/modelcontextprotocol/kotlin/sdk/server/ServerOptions;Lp9/p;Le9/c;)Ljava/lang/Object;", "createMcpTransport", "(Lio/ktor/server/websocket/WebSocketServerSession;)Lio/modelcontextprotocol/kotlin/sdk/server/WebSocketMcpServerTransport;", "kotlin-sdk"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketMcpKtorServerExtensionsKt {

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt", f = "WebSocketMcpKtorServerExtensions.kt", l = {99, 100, 101}, m = "createMcpServer")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$createMcpServer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketMcpKtorServerExtensionsKt.createMcpServer(null, null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/Server;", "LY8/t;", "<anonymous>", "(Lio/modelcontextprotocol/kotlin/sdk/server/Server;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocket$1", f = "WebSocketMcpKtorServerExtensions.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocket$1, reason: invalid class name and case insensitive filesystem */
    public static final class C46041 extends SuspendLambda implements p9.p<Server, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public C46041(InterfaceC4014c<? super C46041> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C46041(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Server server, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C46041) create(server, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/websocket/DefaultWebSocketServerSession;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/websocket/DefaultWebSocketServerSession;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocket$2", f = "WebSocketMcpKtorServerExtensions.kt", l = {22}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocket$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<DefaultWebSocketServerSession, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.p<Server, InterfaceC4014c<? super Y8.t>, Object> $handler;
        final /* synthetic */ ServerOptions $options;
        final /* synthetic */ Route $this_mcpWebSocket;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Route route, ServerOptions serverOptions, p9.p<? super Server, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_mcpWebSocket = route;
            this.$options = serverOptions;
            this.$handler = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_mcpWebSocket, this.$options, this.$handler, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(DefaultWebSocketServerSession defaultWebSocketServerSession, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(defaultWebSocketServerSession, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            DefaultWebSocketServerSession defaultWebSocketServerSession = (DefaultWebSocketServerSession) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Route route = this.$this_mcpWebSocket;
                ServerOptions serverOptions = this.$options;
                p9.p<Server, InterfaceC4014c<? super Y8.t>, Object> pVar = this.$handler;
                this.L$0 = g9.h.a(defaultWebSocketServerSession);
                this.label = 1;
                if (WebSocketMcpKtorServerExtensionsKt.createMcpServer(route, defaultWebSocketServerSession, serverOptions, pVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/Server;", "LY8/t;", "<anonymous>", "(Lio/modelcontextprotocol/kotlin/sdk/server/Server;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocket$3", f = "WebSocketMcpKtorServerExtensions.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocket$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<Server, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass3(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Server server, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(server, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/websocket/DefaultWebSocketServerSession;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/websocket/DefaultWebSocketServerSession;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocket$4", f = "WebSocketMcpKtorServerExtensions.kt", l = {39}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocket$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p9.p<DefaultWebSocketServerSession, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.p<Server, InterfaceC4014c<? super Y8.t>, Object> $handler;
        final /* synthetic */ ServerOptions $options;
        final /* synthetic */ Route $this_mcpWebSocket;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Route route, ServerOptions serverOptions, p9.p<? super Server, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_mcpWebSocket = route;
            this.$options = serverOptions;
            this.$handler = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$this_mcpWebSocket, this.$options, this.$handler, interfaceC4014c);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // p9.p
        public final Object invoke(DefaultWebSocketServerSession defaultWebSocketServerSession, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass4) create(defaultWebSocketServerSession, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            DefaultWebSocketServerSession defaultWebSocketServerSession = (DefaultWebSocketServerSession) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Route route = this.$this_mcpWebSocket;
                ServerOptions serverOptions = this.$options;
                p9.p<Server, InterfaceC4014c<? super Y8.t>, Object> pVar = this.$handler;
                this.L$0 = g9.h.a(defaultWebSocketServerSession);
                this.label = 1;
                if (WebSocketMcpKtorServerExtensionsKt.createMcpServer(route, defaultWebSocketServerSession, serverOptions, pVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/WebSocketMcpServerTransport;", "LY8/t;", "<anonymous>", "(Lio/modelcontextprotocol/kotlin/sdk/server/WebSocketMcpServerTransport;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocketTransport$1", f = "WebSocketMcpKtorServerExtensions.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocketTransport$1, reason: invalid class name and case insensitive filesystem */
    public static final class C46051 extends SuspendLambda implements p9.p<WebSocketMcpServerTransport, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public C46051(InterfaceC4014c<? super C46051> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C46051(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(WebSocketMcpServerTransport webSocketMcpServerTransport, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C46051) create(webSocketMcpServerTransport, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/websocket/DefaultWebSocketServerSession;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/websocket/DefaultWebSocketServerSession;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocketTransport$2", f = "WebSocketMcpKtorServerExtensions.kt", l = {53, 54, 55}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocketTransport$2, reason: invalid class name and case insensitive filesystem */
    public static final class C46062 extends SuspendLambda implements p9.p<DefaultWebSocketServerSession, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.p<WebSocketMcpServerTransport, InterfaceC4014c<? super Y8.t>, Object> $handler;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C46062(p9.p<? super WebSocketMcpServerTransport, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super C46062> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$handler = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C46062 c46062 = new C46062(this.$handler, interfaceC4014c);
            c46062.L$0 = obj;
            return c46062;
        }

        @Override // p9.p
        public final Object invoke(DefaultWebSocketServerSession defaultWebSocketServerSession, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C46062) create(defaultWebSocketServerSession, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
        
            if (r2.close(r6) != r1) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                io.ktor.server.websocket.DefaultWebSocketServerSession r0 = (io.ktor.server.websocket.DefaultWebSocketServerSession) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r6.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L35
                if (r2 == r5) goto L2d
                if (r2 == r4) goto L25
                if (r2 != r3) goto L1d
                java.lang.Object r6 = r6.L$1
                io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport r6 = (io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport) r6
                kotlin.C4849c.b(r7)
                goto L76
            L1d:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L25:
                java.lang.Object r2 = r6.L$1
                io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport r2 = (io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport) r2
                kotlin.C4849c.b(r7)
                goto L61
            L2d:
                java.lang.Object r2 = r6.L$1
                io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport r2 = (io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport) r2
                kotlin.C4849c.b(r7)
                goto L4e
            L35:
                kotlin.C4849c.b(r7)
                io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport r7 = io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt.access$createMcpTransport(r0)
                java.lang.Object r2 = g9.h.a(r0)
                r6.L$0 = r2
                r6.L$1 = r7
                r6.label = r5
                java.lang.Object r2 = r7.start(r6)
                if (r2 != r1) goto L4d
                goto L75
            L4d:
                r2 = r7
            L4e:
                p9.p<io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport, e9.c<? super Y8.t>, java.lang.Object> r7 = r6.$handler
                java.lang.Object r5 = g9.h.a(r0)
                r6.L$0 = r5
                r6.L$1 = r2
                r6.label = r4
                java.lang.Object r7 = r7.invoke(r2, r6)
                if (r7 != r1) goto L61
                goto L75
            L61:
                java.lang.Object r7 = g9.h.a(r0)
                r6.L$0 = r7
                java.lang.Object r7 = g9.h.a(r2)
                r6.L$1 = r7
                r6.label = r3
                java.lang.Object r6 = r2.close(r6)
                if (r6 != r1) goto L76
            L75:
                return r1
            L76:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt.C46062.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/WebSocketMcpServerTransport;", "LY8/t;", "<anonymous>", "(Lio/modelcontextprotocol/kotlin/sdk/server/WebSocketMcpServerTransport;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocketTransport$3", f = "WebSocketMcpKtorServerExtensions.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocketTransport$3, reason: invalid class name and case insensitive filesystem */
    public static final class C46073 extends SuspendLambda implements p9.p<WebSocketMcpServerTransport, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public C46073(InterfaceC4014c<? super C46073> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C46073(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(WebSocketMcpServerTransport webSocketMcpServerTransport, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C46073) create(webSocketMcpServerTransport, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/websocket/DefaultWebSocketServerSession;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/websocket/DefaultWebSocketServerSession;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocketTransport$4", f = "WebSocketMcpKtorServerExtensions.kt", l = {71, 72, 73}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt$mcpWebSocketTransport$4, reason: invalid class name and case insensitive filesystem */
    public static final class C46084 extends SuspendLambda implements p9.p<DefaultWebSocketServerSession, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.p<WebSocketMcpServerTransport, InterfaceC4014c<? super Y8.t>, Object> $handler;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C46084(p9.p<? super WebSocketMcpServerTransport, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super C46084> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$handler = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C46084 c46084 = new C46084(this.$handler, interfaceC4014c);
            c46084.L$0 = obj;
            return c46084;
        }

        @Override // p9.p
        public final Object invoke(DefaultWebSocketServerSession defaultWebSocketServerSession, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C46084) create(defaultWebSocketServerSession, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
        
            if (r2.close(r6) != r1) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                io.ktor.server.websocket.DefaultWebSocketServerSession r0 = (io.ktor.server.websocket.DefaultWebSocketServerSession) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r6.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L35
                if (r2 == r5) goto L2d
                if (r2 == r4) goto L25
                if (r2 != r3) goto L1d
                java.lang.Object r6 = r6.L$1
                io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport r6 = (io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport) r6
                kotlin.C4849c.b(r7)
                goto L76
            L1d:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L25:
                java.lang.Object r2 = r6.L$1
                io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport r2 = (io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport) r2
                kotlin.C4849c.b(r7)
                goto L61
            L2d:
                java.lang.Object r2 = r6.L$1
                io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport r2 = (io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport) r2
                kotlin.C4849c.b(r7)
                goto L4e
            L35:
                kotlin.C4849c.b(r7)
                io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport r7 = io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt.access$createMcpTransport(r0)
                java.lang.Object r2 = g9.h.a(r0)
                r6.L$0 = r2
                r6.L$1 = r7
                r6.label = r5
                java.lang.Object r2 = r7.start(r6)
                if (r2 != r1) goto L4d
                goto L75
            L4d:
                r2 = r7
            L4e:
                p9.p<io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpServerTransport, e9.c<? super Y8.t>, java.lang.Object> r7 = r6.$handler
                java.lang.Object r5 = g9.h.a(r0)
                r6.L$0 = r5
                r6.L$1 = r2
                r6.label = r4
                java.lang.Object r7 = r7.invoke(r2, r6)
                if (r7 != r1) goto L61
                goto L75
            L61:
                java.lang.Object r7 = g9.h.a(r0)
                r6.L$0 = r7
                java.lang.Object r7 = g9.h.a(r2)
                r6.L$1 = r7
                r6.label = r3
                java.lang.Object r6 = r2.close(r6)
                if (r6 != r1) goto L76
            L75:
                return r1
            L76:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt.C46084.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0154, code lost:
    
        if (r3.close(r1) != r2) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object createMcpServer(io.ktor.server.routing.Route r19, io.ktor.server.websocket.WebSocketServerSession r20, io.modelcontextprotocol.kotlin.sdk.server.ServerOptions r21, p9.p<? super io.modelcontextprotocol.kotlin.sdk.server.Server, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r22, e9.InterfaceC4014c<? super Y8.t> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.WebSocketMcpKtorServerExtensionsKt.createMcpServer(io.ktor.server.routing.Route, io.ktor.server.websocket.WebSocketServerSession, io.modelcontextprotocol.kotlin.sdk.server.ServerOptions, p9.p, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebSocketMcpServerTransport createMcpTransport(WebSocketServerSession webSocketServerSession) {
        return new WebSocketMcpServerTransport(webSocketServerSession);
    }

    public static final void mcpWebSocket(Route route, ServerOptions serverOptions, p9.p<? super Server, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(handler, "handler");
        RoutingKt.webSocket$default(route, null, new AnonymousClass2(route, serverOptions, handler, null), 1, null);
    }

    public static /* synthetic */ void mcpWebSocket$default(Route route, ServerOptions serverOptions, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            serverOptions = null;
        }
        if ((i10 & 2) != 0) {
            pVar = new C46041(null);
        }
        mcpWebSocket(route, serverOptions, pVar);
    }

    public static final void mcpWebSocketTransport(Route route, p9.p<? super WebSocketMcpServerTransport, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(handler, "handler");
        RoutingKt.webSocket$default(route, null, new C46062(handler, null), 1, null);
    }

    public static /* synthetic */ void mcpWebSocketTransport$default(Route route, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            pVar = new C46051(null);
        }
        mcpWebSocketTransport(route, pVar);
    }

    public static final void mcpWebSocket(Route route, String path, ServerOptions serverOptions, p9.p<? super Server, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(handler, "handler");
        RoutingKt.webSocket$default(route, path, null, new AnonymousClass4(route, serverOptions, handler, null), 2, null);
    }

    public static final void mcpWebSocketTransport(Route route, String path, p9.p<? super WebSocketMcpServerTransport, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(handler, "handler");
        RoutingKt.webSocket$default(route, path, null, new C46084(handler, null), 2, null);
    }

    public static /* synthetic */ void mcpWebSocket$default(Route route, String str, ServerOptions serverOptions, p9.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            serverOptions = null;
        }
        if ((i10 & 4) != 0) {
            pVar = new AnonymousClass3(null);
        }
        mcpWebSocket(route, str, serverOptions, pVar);
    }

    public static /* synthetic */ void mcpWebSocketTransport$default(Route route, String str, p9.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = new C46073(null);
        }
        mcpWebSocketTransport(route, str, pVar);
    }
}
