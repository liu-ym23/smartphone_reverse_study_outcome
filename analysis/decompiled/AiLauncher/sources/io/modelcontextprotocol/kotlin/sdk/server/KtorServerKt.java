package io.modelcontextprotocol.kotlin.sdk.server;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationPluginKt;
import io.ktor.server.routing.Route;
import io.ktor.server.routing.Routing;
import io.ktor.server.routing.RoutingBuilderKt;
import io.ktor.server.routing.RoutingContext;
import io.ktor.server.routing.RoutingRootKt;
import io.ktor.server.sse.RoutingKt;
import io.ktor.server.sse.SSEKt;
import io.ktor.server.sse.ServerSSESession;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.utils.io.KtorDsl;
import io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransportKt;
import io.modelcontextprotocol.server.transport.HttpServletSseServerTransportProvider;
import j8.C4785k;
import j8.InterfaceC4782h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\t\u001a!\u0010\u000b\u001a\u00020\u0006*\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u0007\u001a\u00020\u0006*\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\f\u001a>\u0010\u0012\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u0014\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000fH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0017\u001a\u00020\u0006*\u00020\u00162\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000fH\u0080@¢\u0006\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/server/routing/Routing;", "", "path", "Lkotlin/Function0;", "Lio/modelcontextprotocol/kotlin/sdk/server/Server;", "block", "LY8/t;", WebSocketMcpTransportKt.MCP_SUBPROTOCOL, "(Lio/ktor/server/routing/Routing;Ljava/lang/String;Lp9/a;)V", "(Lio/ktor/server/routing/Routing;Lp9/a;)V", "Lio/ktor/server/application/Application;", "MCP", "(Lio/ktor/server/application/Application;Lp9/a;)V", "Lio/ktor/server/sse/ServerSSESession;", "postEndpoint", "Lio/ktor/util/collections/ConcurrentMap;", "Lio/modelcontextprotocol/kotlin/sdk/server/SseServerTransport;", "transports", "mcpSseEndpoint", "(Lio/ktor/server/sse/ServerSSESession;Ljava/lang/String;Lio/ktor/util/collections/ConcurrentMap;Lp9/a;Le9/c;)Ljava/lang/Object;", "mcpSseTransport", "(Lio/ktor/server/sse/ServerSSESession;Ljava/lang/String;Lio/ktor/util/collections/ConcurrentMap;)Lio/modelcontextprotocol/kotlin/sdk/server/SseServerTransport;", "Lio/ktor/server/routing/RoutingContext;", "mcpPostEndpoint", "(Lio/ktor/server/routing/RoutingContext;Lio/ktor/util/collections/ConcurrentMap;Le9/c;)Ljava/lang/Object;", "Lj8/h;", "logger", "Lj8/h;", "kotlin-sdk"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KtorServerKt {
    private static final InterfaceC4782h logger = C4785k.f34533a.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.j
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Y8.t.f7040a;
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/sse/ServerSSESession;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/sse/ServerSSESession;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt$mcp$2", f = "KtorServer.kt", l = {36}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt$mcp$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<ServerSSESession, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5063a<Server> $block;
        final /* synthetic */ ConcurrentMap<String, SseServerTransport> $transports;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(ConcurrentMap<String, SseServerTransport> concurrentMap, InterfaceC5063a<? extends Server> interfaceC5063a, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$transports = concurrentMap;
            this.$block = interfaceC5063a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transports, this.$block, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(ServerSSESession serverSSESession, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(serverSSESession, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ServerSSESession serverSSESession = (ServerSSESession) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ConcurrentMap<String, SseServerTransport> concurrentMap = this.$transports;
                InterfaceC5063a<Server> interfaceC5063a = this.$block;
                this.L$0 = g9.h.a(serverSSESession);
                this.label = 1;
                if (KtorServerKt.mcpSseEndpoint(serverSSESession, "", concurrentMap, interfaceC5063a, this) == objG) {
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt$mcp$3", f = "KtorServer.kt", l = {40}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt$mcp$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ ConcurrentMap<String, SseServerTransport> $transports;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ConcurrentMap<String, SseServerTransport> concurrentMap, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$transports = concurrentMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$transports, interfaceC4014c);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            RoutingContext routingContext = (RoutingContext) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ConcurrentMap<String, SseServerTransport> concurrentMap = this.$transports;
                this.L$0 = g9.h.a(routingContext);
                this.label = 1;
                if (KtorServerKt.mcpPostEndpoint(routingContext, concurrentMap, this) == objG) {
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

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt", f = "KtorServer.kt", l = {121, 135, 115}, m = "mcpPostEndpoint")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt$mcpPostEndpoint$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KtorServerKt.mcpPostEndpoint(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt", f = "KtorServer.kt", l = {81}, m = "mcpSseEndpoint")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt$mcpSseEndpoint$1, reason: invalid class name and case insensitive filesystem */
    public static final class C45991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C45991(InterfaceC4014c<? super C45991> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KtorServerKt.mcpSseEndpoint(null, null, null, null, this);
        }
    }

    public static final void MCP(Application application, InterfaceC5063a<? extends Server> block) {
        kotlin.jvm.internal.p.i(application, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        mcp(application, block);
    }

    @KtorDsl
    public static final void mcp(final Routing routing, String path, final InterfaceC5063a<? extends Server> block) {
        kotlin.jvm.internal.p.i(routing, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(block, "block");
        RoutingBuilderKt.route(routing, path, new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.server.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return KtorServerKt.mcp$lambda$1(routing, block, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t mcp$lambda$1(Routing routing, InterfaceC5063a interfaceC5063a, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        mcp(routing, (InterfaceC5063a<? extends Server>) interfaceC5063a);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t mcp$lambda$2(ConcurrentMap concurrentMap, InterfaceC5063a interfaceC5063a, Routing routing) {
        kotlin.jvm.internal.p.i(routing, "$this$routing");
        RoutingKt.sse(routing, HttpServletSseServerTransportProvider.DEFAULT_SSE_ENDPOINT, new KtorServerKt$mcp$4$1(concurrentMap, interfaceC5063a, null));
        RoutingBuilderKt.post(routing, "/message", new KtorServerKt$mcp$4$2(concurrentMap, null));
        return Y8.t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0109, code lost:
    
        if (r12.respond("sessionId query parameter is not provided", r6, r0) == r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0184, code lost:
    
        if (r3.respond("Session not found", r6, r0) == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object mcpPostEndpoint(io.ktor.server.routing.RoutingContext r10, io.ktor.util.collections.ConcurrentMap<java.lang.String, io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport> r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt.mcpPostEndpoint(io.ktor.server.routing.RoutingContext, io.ktor.util.collections.ConcurrentMap, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object mcpPostEndpoint$lambda$10(String str) {
        return "Message handled for sessionId: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object mcpPostEndpoint$lambda$8(String str) {
        return "Received message for sessionId: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object mcpPostEndpoint$lambda$9(String str) {
        return "Session not found for sessionId: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object mcpSseEndpoint(io.ktor.server.sse.ServerSSESession r5, java.lang.String r6, final io.ktor.util.collections.ConcurrentMap<java.lang.String, io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport> r7, p9.InterfaceC5063a<? extends io.modelcontextprotocol.kotlin.sdk.server.Server> r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt.C45991
            if (r0 == 0) goto L13
            r0 = r9
            io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt$mcpSseEndpoint$1 r0 = (io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt.C45991) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt$mcpSseEndpoint$1 r0 = new io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt$mcpSseEndpoint$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r5 = r0.L$5
            io.modelcontextprotocol.kotlin.sdk.server.Server r5 = (io.modelcontextprotocol.kotlin.sdk.server.Server) r5
            java.lang.Object r5 = r0.L$4
            io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport r5 = (io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport) r5
            java.lang.Object r6 = r0.L$3
            p9.a r6 = (p9.InterfaceC5063a) r6
            java.lang.Object r6 = r0.L$2
            io.ktor.util.collections.ConcurrentMap r6 = (io.ktor.util.collections.ConcurrentMap) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            io.ktor.server.sse.ServerSSESession r6 = (io.ktor.server.sse.ServerSSESession) r6
            kotlin.C4849c.b(r9)
            goto L88
        L41:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L49:
            kotlin.C4849c.b(r9)
            io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport r9 = mcpSseTransport(r5, r6, r7)
            java.lang.Object r2 = r8.invoke()
            io.modelcontextprotocol.kotlin.sdk.server.Server r2 = (io.modelcontextprotocol.kotlin.sdk.server.Server) r2
            io.modelcontextprotocol.kotlin.sdk.server.d r4 = new io.modelcontextprotocol.kotlin.sdk.server.d
            r4.<init>()
            r2.onClose(r4)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            java.lang.Object r5 = g9.h.a(r6)
            r0.L$1 = r5
            java.lang.Object r5 = g9.h.a(r7)
            r0.L$2 = r5
            java.lang.Object r5 = g9.h.a(r8)
            r0.L$3 = r5
            r0.L$4 = r9
            java.lang.Object r5 = g9.h.a(r2)
            r0.L$5 = r5
            r0.label = r3
            java.lang.Object r5 = r2.connect(r9, r0)
            if (r5 != r1) goto L87
            return r1
        L87:
            r5 = r9
        L88:
            j8.h r6 = io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt.logger
            io.modelcontextprotocol.kotlin.sdk.server.e r7 = new io.modelcontextprotocol.kotlin.sdk.server.e
            r7.<init>()
            r6.g(r7)
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt.mcpSseEndpoint(io.ktor.server.sse.ServerSSESession, java.lang.String, io.ktor.util.collections.ConcurrentMap, p9.a, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t mcpSseEndpoint$lambda$4(ConcurrentMap concurrentMap, final SseServerTransport sseServerTransport) {
        logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return KtorServerKt.mcpSseEndpoint$lambda$4$lambda$3(sseServerTransport);
            }
        });
        concurrentMap.remove(sseServerTransport.getSessionId());
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object mcpSseEndpoint$lambda$4$lambda$3(SseServerTransport sseServerTransport) {
        return "Server connection closed for sessionId: " + sseServerTransport.getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object mcpSseEndpoint$lambda$5(SseServerTransport sseServerTransport) {
        return "Server connected to transport for sessionId: " + sseServerTransport.getSessionId();
    }

    public static final SseServerTransport mcpSseTransport(ServerSSESession serverSSESession, String postEndpoint, ConcurrentMap<String, SseServerTransport> transports) {
        kotlin.jvm.internal.p.i(serverSSESession, "<this>");
        kotlin.jvm.internal.p.i(postEndpoint, "postEndpoint");
        kotlin.jvm.internal.p.i(transports, "transports");
        final SseServerTransport sseServerTransport = new SseServerTransport(postEndpoint, serverSSESession);
        transports.put(sseServerTransport.getSessionId(), sseServerTransport);
        logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return KtorServerKt.mcpSseTransport$lambda$6(sseServerTransport);
            }
        });
        return sseServerTransport;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object mcpSseTransport$lambda$6(SseServerTransport sseServerTransport) {
        return "New SSE connection established and stored with sessionId: " + sseServerTransport.getSessionId();
    }

    @KtorDsl
    public static final void mcp(Routing routing, InterfaceC5063a<? extends Server> block) {
        kotlin.jvm.internal.p.i(routing, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        ConcurrentMap concurrentMap = new ConcurrentMap(0, 1, null);
        RoutingKt.sse(routing, new AnonymousClass2(concurrentMap, block, null));
        RoutingBuilderKt.post(routing, new AnonymousClass3(concurrentMap, null));
    }

    @KtorDsl
    public static final void mcp(Application application, final InterfaceC5063a<? extends Server> block) {
        kotlin.jvm.internal.p.i(application, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        final ConcurrentMap concurrentMap = new ConcurrentMap(0, 1, null);
        ApplicationPluginKt.install$default(application, SSEKt.getSSE(), (InterfaceC5074l) null, 2, (Object) null);
        RoutingRootKt.routing(application, new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.server.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return KtorServerKt.mcp$lambda$2(concurrentMap, block, (Routing) obj);
            }
        });
    }
}
