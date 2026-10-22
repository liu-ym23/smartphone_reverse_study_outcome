package io.modelcontextprotocol.kotlin.sdk.shared;

import Ua.L0;
import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H¤@¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0007\u0010\u0006J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\f\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/shared/WebSocketMcpTransport;", "Lio/modelcontextprotocol/kotlin/sdk/shared/AbstractTransport;", "<init>", "()V", "LY8/t;", "initializeSession", "(Le9/c;)Ljava/lang/Object;", "start", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "message", "send", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;Le9/c;)Ljava/lang/Object;", "close", "LUa/M;", "scope$delegate", "LY8/h;", "getScope", "()LUa/M;", "scope", "Lkotlin/concurrent/atomics/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lio/ktor/websocket/WebSocketSession;", "getSession", "()Lio/ktor/websocket/WebSocketSession;", "session", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class WebSocketMcpTransport extends AbstractTransport {

    /* renamed from: scope$delegate, reason: from kotlin metadata */
    private final Y8.h scope = C4848b.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.C
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return WebSocketMcpTransport.scope_delegate$lambda$0(this.f33831a);
        }
    });
    private final AtomicBoolean initialized = new AtomicBoolean(false);

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport", f = "WebSocketMcpTransport.kt", l = {100, 101}, m = "close$suspendImpl")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$close$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketMcpTransport.close$suspendImpl(WebSocketMcpTransport.this, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport", f = "WebSocketMcpTransport.kt", l = {51}, m = "start$suspendImpl")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C46371 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C46371(InterfaceC4014c<? super C46371> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketMcpTransport.start$suspendImpl(WebSocketMcpTransport.this, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$start$2", f = "WebSocketMcpTransport.kt", l = {56, 69}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$start$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return WebSocketMcpTransport.this.new AnonymousClass2(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0049 A[Catch: Exception -> 0x001a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x001a, blocks: (B:7:0x0016, B:22:0x0049), top: B:31:0x0016 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007d -> B:16:0x002b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Exception {
            /*
                r6 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 == r3) goto L24
                if (r1 != r2) goto L1c
                java.lang.Object r1 = r6.L$1
                io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r1 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r1
                java.lang.Object r1 = r6.L$0
                io.ktor.websocket.Frame r1 = (io.ktor.websocket.Frame) r1
                kotlin.C4849c.b(r7)     // Catch: java.lang.Exception -> L1a
                goto L2b
            L1a:
                r7 = move-exception
                goto L80
            L1c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L24:
                kotlin.C4849c.b(r7)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> Lbe
                goto L43
            L28:
                kotlin.C4849c.b(r7)
            L2b:
                io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport r7 = io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.this     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> Lbe
                io.ktor.websocket.WebSocketSession r7 = r7.getSession()     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> Lbe
                Wa.r r7 = r7.getIncoming()     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> Lbe
                r1 = 0
                r6.L$0 = r1     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> Lbe
                r6.L$1 = r1     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> Lbe
                r6.label = r3     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> Lbe
                java.lang.Object r7 = r7.receive(r6)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> Lbe
                if (r7 != r0) goto L43
                goto L7f
            L43:
                io.ktor.websocket.Frame r7 = (io.ktor.websocket.Frame) r7     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> Lbe
                boolean r1 = r7 instanceof io.ktor.websocket.Frame.Text
                if (r1 == 0) goto L8a
                qb.a r1 = io.modelcontextprotocol.kotlin.sdk.shared.ProtocolKt.getMcpJson()     // Catch: java.lang.Exception -> L1a
                r4 = r7
                io.ktor.websocket.Frame$Text r4 = (io.ktor.websocket.Frame.Text) r4     // Catch: java.lang.Exception -> L1a
                java.lang.String r4 = io.ktor.websocket.FrameCommonKt.readText(r4)     // Catch: java.lang.Exception -> L1a
                r1.getSerializersModule()     // Catch: java.lang.Exception -> L1a
                io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage$Companion r5 = io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage.INSTANCE     // Catch: java.lang.Exception -> L1a
                kotlinx.serialization.KSerializer r5 = r5.serializer()     // Catch: java.lang.Exception -> L1a
                lb.a r5 = (lb.InterfaceC4883a) r5     // Catch: java.lang.Exception -> L1a
                java.lang.Object r1 = r1.c(r5, r4)     // Catch: java.lang.Exception -> L1a
                io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r1 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r1     // Catch: java.lang.Exception -> L1a
                io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport r4 = io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.this     // Catch: java.lang.Exception -> L1a
                p9.p r4 = r4.get_onMessage()     // Catch: java.lang.Exception -> L1a
                java.lang.Object r7 = g9.h.a(r7)     // Catch: java.lang.Exception -> L1a
                r6.L$0 = r7     // Catch: java.lang.Exception -> L1a
                java.lang.Object r7 = g9.h.a(r1)     // Catch: java.lang.Exception -> L1a
                r6.L$1 = r7     // Catch: java.lang.Exception -> L1a
                r6.label = r2     // Catch: java.lang.Exception -> L1a
                java.lang.Object r7 = r4.invoke(r1, r6)     // Catch: java.lang.Exception -> L1a
                if (r7 != r0) goto L2b
            L7f:
                return r0
            L80:
                io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport r6 = io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.this
                p9.l r6 = r6.get_onError()
                r6.invoke(r7)
                throw r7
            L8a:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Expected text frame, got "
                r1.append(r2)
                java.lang.Class r2 = r7.getClass()
                w9.d r2 = kotlin.jvm.internal.t.b(r2)
                java.lang.String r2 = r2.t()
                r1.append(r2)
                java.lang.String r2 = ": "
                r1.append(r2)
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                r0.<init>(r7)
                io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport r6 = io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.this
                p9.l r6 = r6.get_onError()
                r6.invoke(r0)
                throw r0
            Lbe:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
    
        if (r6.T0(r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object close$suspendImpl(io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$close$1 r0 = (io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$close$1 r0 = new io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$close$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport r5 = (io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport) r5
            kotlin.C4849c.b(r6)
            goto L76
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.L$0
            io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport r5 = (io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport) r5
            kotlin.C4849c.b(r6)
            goto L5b
        L40:
            kotlin.C4849c.b(r6)
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.initialized
            boolean r6 = r6.get()
            if (r6 == 0) goto L79
            io.ktor.websocket.WebSocketSession r6 = r5.getSession()
            r0.L$0 = r5
            r0.label = r4
            r2 = 0
            java.lang.Object r6 = io.ktor.websocket.WebSocketSessionKt.close$default(r6, r2, r0, r4, r2)
            if (r6 != r1) goto L5b
            goto L75
        L5b:
            io.ktor.websocket.WebSocketSession r6 = r5.getSession()
            kotlin.coroutines.d r6 = r6.getCoroutineContext()
            kotlinx.coroutines.g r6 = Ua.C1086v0.o(r6)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r5 = r6.T0(r0)
            if (r5 != r1) goto L76
        L75:
            return r1
        L76:
            Y8.t r5 = Y8.t.f7040a
            return r5
        L79:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Not connected"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.close$suspendImpl(io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport, e9.c):java.lang.Object");
    }

    private final M getScope() {
        return (M) this.scope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M scope_delegate$lambda$0(WebSocketMcpTransport webSocketMcpTransport) {
        return kotlinx.coroutines.d.a(webSocketMcpTransport.getSession().getCoroutineContext().plus(L0.b(null, 1, null)));
    }

    public static /* synthetic */ Object send$suspendImpl(WebSocketMcpTransport webSocketMcpTransport, JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        if (!webSocketMcpTransport.initialized.get()) {
            throw new IllegalStateException("Not connected");
        }
        Wa.s<Frame> outgoing = webSocketMcpTransport.getSession().getOutgoing();
        AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
        mcpJson.getSerializersModule();
        Object objSend = outgoing.send(new Frame.Text(mcpJson.a(JSONRPCMessage.INSTANCE.serializer(), jSONRPCMessage)), interfaceC4014c);
        return objSend == C4063a.g() ? objSend : Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t start$lambda$1(WebSocketMcpTransport webSocketMcpTransport, Throwable th) {
        if (th != null) {
            webSocketMcpTransport.get_onError().invoke(th);
        } else {
            webSocketMcpTransport.get_onClose().invoke();
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object start$suspendImpl(final io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.C46371
            if (r0 == 0) goto L13
            r0 = r7
            io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$start$1 r0 = (io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.C46371) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$start$1 r0 = new io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$start$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.L$0
            io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport r6 = (io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport) r6
            kotlin.C4849c.b(r7)
            goto L4c
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.C4849c.b(r7)
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.initialized
            r2 = 0
            boolean r7 = r7.compareAndSet(r2, r3)
            if (r7 == 0) goto L8d
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r6.initializeSession(r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            Ua.M r0 = r6.getScope()
            Ua.L r1 = new Ua.L
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "WebSocketMcpTransport.collect#"
            r7.append(r2)
            int r2 = r6.hashCode()
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            r1.<init>(r7)
            io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$start$2 r3 = new io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport$start$2
            r7 = 0
            r3.<init>(r7)
            r4 = 2
            r5 = 0
            r2 = 0
            Ua.C1056g.d(r0, r1, r2, r3, r4, r5)
            io.ktor.websocket.WebSocketSession r7 = r6.getSession()
            kotlin.coroutines.d r7 = r7.getCoroutineContext()
            kotlinx.coroutines.g r7 = Ua.C1086v0.o(r7)
            io.modelcontextprotocol.kotlin.sdk.shared.B r0 = new io.modelcontextprotocol.kotlin.sdk.shared.B
            r0.<init>()
            r7.J(r0)
            Y8.t r6 = Y8.t.f7040a
            return r6
        L8d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "WebSocketClientTransport already started! If using Client class, note that connect() calls start() automatically."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport.start$suspendImpl(io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport, e9.c):java.lang.Object");
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object close(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return close$suspendImpl(this, interfaceC4014c);
    }

    public abstract WebSocketSession getSession();

    public abstract Object initializeSession(InterfaceC4014c<? super Y8.t> interfaceC4014c);

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object send(JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return send$suspendImpl(this, jSONRPCMessage, interfaceC4014c);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object start(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return start$suspendImpl(this, interfaceC4014c);
    }
}
