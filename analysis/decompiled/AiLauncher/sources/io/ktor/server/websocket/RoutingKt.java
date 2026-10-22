package io.ktor.server.websocket;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.routing.Route;
import io.ktor.server.routing.RoutingBuilderKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.WebSocketSession;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.g;
import p9.InterfaceC5074l;
import p9.p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aI\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0004\b\n\u0010\u000b\u001aS\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\r\u001a\u00020\f2\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0004\b\n\u0010\u000e\u001aA\u0010\n\u001a\u00020\u0007*\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0004\b\n\u0010\u000f\u001aK\u0010\n\u001a\u00020\u0007*\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\r\u001a\u00020\f2\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0004\b\n\u0010\u0010\u001aA\u0010\u0012\u001a\u00020\u0007*\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0004\b\u0012\u0010\u000f\u001aI\u0010\u0012\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0004\b\u0012\u0010\u000b\u001aN\u0010\u0015\u001a\u00020\u0007*\u00020\u00132\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\r\u001a\u00020\f2\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a1\u0010\u0019\u001a\u00020\u0007*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a8\u0010\u001b\u001a\u00020\u0007*\u00020\u00052\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004H\u0082@¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001e\u001a\u00020\u0007*\u00020\u001dH\u0082@¢\u0006\u0004\b\u001e\u0010\u001f\u001a@\u0010\"\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\u00132\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004H\u0082@¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lio/ktor/server/routing/Route;", "", "path", "protocol", "Lkotlin/Function2;", "Lio/ktor/server/websocket/WebSocketServerSession;", "Le9/c;", "LY8/t;", "", "handler", "webSocketRaw", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Ljava/lang/String;Lp9/p;)V", "", "negotiateExtensions", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Ljava/lang/String;ZLp9/p;)V", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lp9/p;)V", "(Lio/ktor/server/routing/Route;Ljava/lang/String;ZLp9/p;)V", "Lio/ktor/server/websocket/DefaultWebSocketServerSession;", "webSocket", "Lio/ktor/server/application/ApplicationCall;", "Lio/ktor/websocket/WebSocketSession;", "respondWebSocketRaw", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;ZLp9/p;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "block", "webSocketProtocol", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lp9/l;)V", "proceedWebSocket", "(Lio/ktor/server/websocket/WebSocketServerSession;Lp9/p;Le9/c;)Ljava/lang/Object;", "LUa/M;", "joinSession", "(LUa/M;Le9/c;)Ljava/lang/Object;", "Lio/ktor/websocket/DefaultWebSocketSession;", "call", "handleServerSession", "(Lio/ktor/websocket/DefaultWebSocketSession;Lio/ktor/server/application/ApplicationCall;Lp9/p;Le9/c;)Ljava/lang/Object;", "ktor-server-websockets"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingKt {

    @InterfaceC4112d(c = "io.ktor.server.websocket.RoutingKt", f = "Routing.kt", l = {219, 220}, m = "handleServerSession")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.websocket.RoutingKt$handleServerSession$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoutingKt.handleServerSession(null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.websocket.RoutingKt", f = "Routing.kt", l = {204, 205}, m = "proceedWebSocket")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.websocket.RoutingKt$proceedWebSocket$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44091(InterfaceC4014c<? super C44091> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoutingKt.proceedWebSocket(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/websocket/WebSocketServerSession;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/websocket/WebSocketServerSession;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.websocket.RoutingKt$webSocket$1", f = "Routing.kt", l = {144}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.websocket.RoutingKt$webSocket$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44101 extends SuspendLambda implements p<WebSocketServerSession, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ p<DefaultWebSocketServerSession, InterfaceC4014c<? super t>, Object> $handler;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C44101(p<? super DefaultWebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super C44101> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$handler = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C44101 c44101 = new C44101(this.$handler, interfaceC4014c);
            c44101.L$0 = obj;
            return c44101;
        }

        @Override // p9.p
        public final Object invoke(WebSocketServerSession webSocketServerSession, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C44101) create(webSocketServerSession, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                WebSocketServerSession webSocketServerSession = (WebSocketServerSession) this.L$0;
                p<DefaultWebSocketServerSession, InterfaceC4014c<? super t>, Object> pVar = this.$handler;
                this.label = 1;
                if (RoutingKt.proceedWebSocket(webSocketServerSession, pVar, this) == objG) {
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/websocket/WebSocketServerSession;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/websocket/WebSocketServerSession;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.websocket.RoutingKt$webSocket$2", f = "Routing.kt", l = {168}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.websocket.RoutingKt$webSocket$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<WebSocketServerSession, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ p<DefaultWebSocketServerSession, InterfaceC4014c<? super t>, Object> $handler;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(p<? super DefaultWebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$handler = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$handler, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(WebSocketServerSession webSocketServerSession, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(webSocketServerSession, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                WebSocketServerSession webSocketServerSession = (WebSocketServerSession) this.L$0;
                p<DefaultWebSocketServerSession, InterfaceC4014c<? super t>, Object> pVar = this.$handler;
                this.label = 1;
                if (RoutingKt.proceedWebSocket(webSocketServerSession, pVar, this) == objG) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0087, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r6, null, r0, 1, null) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object handleServerSession(io.ktor.websocket.DefaultWebSocketSession r6, io.ktor.server.application.ApplicationCall r7, p9.p<? super io.ktor.server.websocket.DefaultWebSocketServerSession, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.server.websocket.RoutingKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.server.websocket.RoutingKt$handleServerSession$1 r0 = (io.ktor.server.websocket.RoutingKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.websocket.RoutingKt$handleServerSession$1 r0 = new io.ktor.server.websocket.RoutingKt$handleServerSession$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$0
            r7 = r6
            io.ktor.server.application.ApplicationCall r7 = (io.ktor.server.application.ApplicationCall) r7
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            goto L8a
        L31:
            r6 = move-exception
            goto L8d
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            io.ktor.server.application.ApplicationCall r7 = (io.ktor.server.application.ApplicationCall) r7
            java.lang.Object r6 = r0.L$0
            io.ktor.websocket.DefaultWebSocketSession r6 = (io.ktor.websocket.DefaultWebSocketSession) r6
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            goto L7c
        L48:
            kotlin.C4849c.b(r9)
            vc.c r9 = io.ktor.server.websocket.WebSocketsKt.getLOGGER()     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            r2.<init>()     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            java.lang.String r5 = "Starting websocket session for "
            r2.append(r5)     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            io.ktor.server.request.ApplicationRequest r5 = r7.getRequest()     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            java.lang.String r5 = io.ktor.server.request.ApplicationRequestPropertiesKt.getUri(r5)     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            r2.append(r5)     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            r9.trace(r2)     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            io.ktor.server.websocket.DefaultWebSocketServerSession r9 = io.ktor.server.websocket.WebSocketServerSessionKt.toServerSession(r6, r7)     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            r0.label = r4     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            java.lang.Object r8 = r8.invoke(r9, r0)     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            if (r8 != r1) goto L7c
            goto L89
        L7c:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            r8 = 0
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            r0.label = r3     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            java.lang.Object r6 = io.ktor.websocket.WebSocketSessionKt.close$default(r6, r8, r0, r4, r8)     // Catch: java.lang.Throwable -> L31 io.ktor.util.cio.ChannelIOException -> L9b java.util.concurrent.CancellationException -> L9d
            if (r6 != r1) goto L8a
        L89:
            return r1
        L8a:
            Y8.t r6 = Y8.t.f7040a
            return r6
        L8d:
            io.ktor.server.application.Application r7 = r7.getApplication()
            vc.c r7 = io.ktor.server.application.ApplicationKt.getLog(r7)
            java.lang.String r8 = "Websocket handler failed"
            r7.error(r8, r6)
            throw r6
        L9b:
            r6 = move-exception
            throw r6
        L9d:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.websocket.RoutingKt.handleServerSession(io.ktor.websocket.DefaultWebSocketSession, io.ktor.server.application.ApplicationCall, p9.p, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object joinSession(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        d.b bVar = m10.getCoroutineContext().get(g.INSTANCE);
        kotlin.jvm.internal.p.f(bVar);
        Object objT0 = ((g) bVar).T0(interfaceC4014c);
        return objT0 == C4063a.g() ? objT0 : t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
    
        if (joinSession(r9, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object proceedWebSocket(io.ktor.server.websocket.WebSocketServerSession r9, p9.p<? super io.ktor.server.websocket.DefaultWebSocketServerSession, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r10, e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof io.ktor.server.websocket.RoutingKt.C44091
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.server.websocket.RoutingKt$proceedWebSocket$1 r0 = (io.ktor.server.websocket.RoutingKt.C44091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.websocket.RoutingKt$proceedWebSocket$1 r0 = new io.ktor.server.websocket.RoutingKt$proceedWebSocket$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r11)
            goto L88
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L34:
            java.lang.Object r9 = r0.L$0
            io.ktor.websocket.DefaultWebSocketSession r9 = (io.ktor.websocket.DefaultWebSocketSession) r9
            kotlin.C4849c.b(r11)
            goto L7c
        L3c:
            kotlin.C4849c.b(r11)
            io.ktor.server.application.Application r11 = io.ktor.server.websocket.WebSocketServerSessionKt.getApplication(r9)
            io.ktor.server.websocket.WebSockets$Plugin r2 = io.ktor.server.websocket.WebSockets.INSTANCE
            java.lang.Object r11 = io.ktor.server.application.ApplicationPluginKt.plugin(r11, r2)
            io.ktor.server.websocket.WebSockets r11 = (io.ktor.server.websocket.WebSockets) r11
            long r5 = r11.getPingIntervalMillis()
            long r7 = r11.getTimeoutMillis()
            io.ktor.websocket.DefaultWebSocketSession r11 = io.ktor.websocket.DefaultWebSocketSessionKt.DefaultWebSocketSession(r9, r5, r7)
            io.ktor.server.application.ApplicationCall r5 = r9.getCall()
            io.ktor.util.Attributes r5 = r5.getAttributes()
            io.ktor.util.AttributeKey r2 = r2.getEXTENSIONS_KEY()
            java.lang.Object r2 = r5.get(r2)
            java.util.List r2 = (java.util.List) r2
            r11.start(r2)
            io.ktor.server.application.ApplicationCall r9 = r9.getCall()
            r0.L$0 = r11
            r0.label = r4
            java.lang.Object r9 = handleServerSession(r11, r9, r10, r0)
            if (r9 != r1) goto L7b
            goto L87
        L7b:
            r9 = r11
        L7c:
            r10 = 0
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r9 = joinSession(r9, r0)
            if (r9 != r1) goto L88
        L87:
            return r1
        L88:
            Y8.t r9 = Y8.t.f7040a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.websocket.RoutingKt.proceedWebSocket(io.ktor.server.websocket.WebSocketServerSession, p9.p, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object respondWebSocketRaw(ApplicationCall applicationCall, String str, boolean z10, p<? super WebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM;
        WebSocketUpgrade webSocketUpgrade = new WebSocketUpgrade(applicationCall, str, z10, pVar);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(WebSocketUpgrade.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(WebSocketUpgrade.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        Object objRespond = applicationCall.respond(webSocketUpgrade, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static /* synthetic */ Object respondWebSocketRaw$default(ApplicationCall applicationCall, String str, boolean z10, p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return respondWebSocketRaw(applicationCall, str, z10, pVar, interfaceC4014c);
    }

    public static final void webSocket(Route route, String str, p<? super DefaultWebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(handler, "handler");
        webSocketRaw(route, str, true, (p<? super WebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object>) new C44101(handler, null));
    }

    public static /* synthetic */ void webSocket$default(Route route, String str, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        webSocket(route, str, pVar);
    }

    private static final void webSocketProtocol(Route route, String str, InterfaceC5074l<? super Route, t> interfaceC5074l) {
        if (str == null) {
            interfaceC5074l.invoke(route);
        } else {
            interfaceC5074l.invoke(route.createChild(new WebSocketProtocolsSelector(str)));
        }
    }

    public static final void webSocketRaw(Route route, String path, String str, p<? super WebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(handler, "handler");
        webSocketRaw(route, path, str, false, handler);
    }

    public static /* synthetic */ void webSocketRaw$default(Route route, String str, String str2, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        webSocketRaw(route, str, str2, (p<? super WebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object>) pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketRaw$lambda$0(String str, boolean z10, p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        webSocketRaw(route, str, z10, (p<? super WebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object>) pVar);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketRaw$lambda$3(final String str, final boolean z10, final p pVar, Route header) {
        kotlin.jvm.internal.p.i(header, "$this$header");
        RoutingBuilderKt.header(header, HttpHeaders.INSTANCE.getUpgrade(), "websocket", new InterfaceC5074l() { // from class: io.ktor.server.websocket.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingKt.webSocketRaw$lambda$3$lambda$2(str, z10, pVar, (Route) obj);
            }
        });
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketRaw$lambda$3$lambda$2(final String str, final boolean z10, final p pVar, Route header) {
        kotlin.jvm.internal.p.i(header, "$this$header");
        webSocketProtocol(header, str, new InterfaceC5074l() { // from class: io.ktor.server.websocket.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingKt.webSocketRaw$lambda$3$lambda$2$lambda$1(str, z10, pVar, (Route) obj);
            }
        });
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketRaw$lambda$3$lambda$2$lambda$1(String str, boolean z10, p pVar, Route webSocketProtocol) {
        kotlin.jvm.internal.p.i(webSocketProtocol, "$this$webSocketProtocol");
        webSocketProtocol.handle(new RoutingKt$webSocketRaw$2$1$1$1(str, z10, pVar, null));
        return t.f7040a;
    }

    public static final void webSocket(Route route, String path, String str, p<? super DefaultWebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(handler, "handler");
        webSocketRaw(route, path, str, true, new AnonymousClass2(handler, null));
    }

    public static /* synthetic */ void webSocket$default(Route route, String str, String str2, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        webSocket(route, str, str2, pVar);
    }

    public static final void webSocketRaw(Route route, String path, final String str, final boolean z10, final p<? super WebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(handler, "handler");
        route.plugin(WebSockets.INSTANCE);
        RoutingBuilderKt.route(route, path, HttpMethod.INSTANCE.getGet(), new InterfaceC5074l() { // from class: io.ktor.server.websocket.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingKt.webSocketRaw$lambda$0(str, z10, handler, (Route) obj);
            }
        });
    }

    public static /* synthetic */ void webSocketRaw$default(Route route, String str, String str2, boolean z10, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        webSocketRaw(route, str, str2, z10, pVar);
    }

    public static /* synthetic */ void webSocketRaw$default(Route route, String str, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        webSocketRaw(route, str, pVar);
    }

    public static final void webSocketRaw(Route route, String str, p<? super WebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(handler, "handler");
        webSocketRaw(route, str, false, handler);
    }

    public static /* synthetic */ void webSocketRaw$default(Route route, String str, boolean z10, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        webSocketRaw(route, str, z10, (p<? super WebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object>) pVar);
    }

    public static final void webSocketRaw(Route route, final String str, final boolean z10, final p<? super WebSocketServerSession, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(handler, "handler");
        route.plugin(WebSockets.INSTANCE);
        RoutingBuilderKt.header(route, HttpHeaders.INSTANCE.getConnection(), "Upgrade", new InterfaceC5074l() { // from class: io.ktor.server.websocket.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingKt.webSocketRaw$lambda$3(str, z10, handler, (Route) obj);
            }
        });
    }
}
