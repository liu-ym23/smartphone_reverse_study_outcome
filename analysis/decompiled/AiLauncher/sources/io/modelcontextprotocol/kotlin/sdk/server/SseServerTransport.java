package io.modelcontextprotocol.kotlin.sdk.server;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.sse.ServerSSESession;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport;
import io.modelcontextprotocol.kotlin.sdk.shared.ProtocolKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.uuid.Uuid;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0012\u0010\nJ\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u00020\u00028\u0006¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/SseServerTransport;", "Lio/modelcontextprotocol/kotlin/sdk/shared/AbstractTransport;", "", "endpoint", "Lio/ktor/server/sse/ServerSSESession;", "session", "<init>", "(Ljava/lang/String;Lio/ktor/server/sse/ServerSSESession;)V", "LY8/t;", "start", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/application/ApplicationCall;", "call", "handlePostMessage", "(Lio/ktor/server/application/ApplicationCall;Le9/c;)Ljava/lang/Object;", "message", "handleMessage", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "close", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "send", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;Le9/c;)Ljava/lang/Object;", "Ljava/lang/String;", "Lio/ktor/server/sse/ServerSSESession;", "Lkotlin/concurrent/atomics/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sessionId", "getSessionId", "()Ljava/lang/String;", "getSessionId$annotations", "()V", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SseServerTransport extends AbstractTransport {
    private final String endpoint;
    private final AtomicBoolean initialized;
    private final ServerSSESession session;
    private final String sessionId;

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport", f = "SSEServerTransport.kt", l = {114}, m = "close")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$close$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SseServerTransport.this.close(this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport", f = "SSEServerTransport.kt", l = {106}, m = "handleMessage")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$handleMessage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C46001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C46001(InterfaceC4014c<? super C46001> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SseServerTransport.this.handleMessage(null, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport", f = "SSEServerTransport.kt", l = {72, 137, 135, 84, 90, 92, 96}, m = "handlePostMessage")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$handlePostMessage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C46011 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C46011(InterfaceC4014c<? super C46011> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SseServerTransport.this.handlePostMessage(null, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport", f = "SSEServerTransport.kt", l = {52, 58}, m = "start")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C46021 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C46021(InterfaceC4014c<? super C46021> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SseServerTransport.this.start(this);
        }
    }

    public SseServerTransport(String endpoint, ServerSSESession session) {
        kotlin.jvm.internal.p.i(endpoint, "endpoint");
        kotlin.jvm.internal.p.i(session, "session");
        this.endpoint = endpoint;
        this.session = session;
        this.initialized = new AtomicBoolean(false);
        this.sessionId = Uuid.INSTANCE.e().toString();
    }

    public static /* synthetic */ void getSessionId$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object close(e9.InterfaceC4014c<? super Y8.t> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$close$1 r0 = (io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$close$1 r0 = new io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$close$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            io.ktor.server.sse.ServerSSESession r5 = r4.session
            r0.label = r3
            java.lang.Object r5 = r5.close(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            p9.a r4 = r4.get_onClose()
            r4.invoke()
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport.close(e9.c):java.lang.Object");
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport, io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport] */
    /* JADX WARN: Type inference failed for: r4v1, types: [io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport] */
    /* JADX WARN: Type inference failed for: r4v4, types: [Y8.t, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleMessage(java.lang.String r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport.C46001
            if (r0 == 0) goto L13
            r0 = r6
            io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$handleMessage$1 r0 = (io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport.C46001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$handleMessage$1 r0 = new io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$handleMessage$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$1
            io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r5 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r6)     // Catch: java.lang.Exception -> L31
            goto L6c
        L31:
            r5 = move-exception
            goto L6f
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r6)
            qb.a r6 = io.modelcontextprotocol.kotlin.sdk.shared.ProtocolKt.getMcpJson()     // Catch: java.lang.Exception -> L31
            r6.getSerializersModule()     // Catch: java.lang.Exception -> L31
            io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage$Companion r2 = io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage.INSTANCE     // Catch: java.lang.Exception -> L31
            kotlinx.serialization.KSerializer r2 = r2.serializer()     // Catch: java.lang.Exception -> L31
            lb.a r2 = (lb.InterfaceC4883a) r2     // Catch: java.lang.Exception -> L31
            java.lang.Object r6 = r6.c(r2, r5)     // Catch: java.lang.Exception -> L31
            io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r6 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r6     // Catch: java.lang.Exception -> L31
            p9.p r2 = r4.get_onMessage()     // Catch: java.lang.Exception -> L31
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Exception -> L31
            r0.L$0 = r5     // Catch: java.lang.Exception -> L31
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Exception -> L31
            r0.L$1 = r5     // Catch: java.lang.Exception -> L31
            r0.label = r3     // Catch: java.lang.Exception -> L31
            java.lang.Object r4 = r2.invoke(r6, r0)     // Catch: java.lang.Exception -> L31
            if (r4 != r1) goto L6c
            return r1
        L6c:
            Y8.t r4 = Y8.t.f7040a
            return r4
        L6f:
            p9.l r4 = r4.get_onError()
            r4.invoke(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport.handleMessage(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x01bd, code lost:
    
        if (io.ktor.server.response.ApplicationResponseFunctionsKt.respondText$default(r3, "Accepted", null, r6, null, r8, 10, null) != r2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x020a, code lost:
    
        if (io.ktor.server.response.ApplicationResponseFunctionsKt.respondText$default(r3, r4, null, r6, null, r8, 10, null) == r2) goto L90;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015e A[Catch: Exception -> 0x00ac, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ac, blocks: (B:27:0x00a4, B:57:0x015e, B:78:0x0211, B:82:0x021b, B:83:0x022c), top: B:96:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0211 A[Catch: Exception -> 0x00ac, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ac, blocks: (B:27:0x00a4, B:57:0x015e, B:78:0x0211, B:82:0x021b, B:83:0x022c), top: B:96:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0256 A[Catch: Exception -> 0x0086, TryCatch #4 {Exception -> 0x0086, blocks: (B:22:0x0081, B:61:0x0182, B:40:0x00f7, B:42:0x010b, B:44:0x0115, B:48:0x011b, B:52:0x0125, B:86:0x0256, B:87:0x0270, B:84:0x022d, B:85:0x0255), top: B:101:0x002b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r16v0, types: [io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport, io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8, types: [io.ktor.server.application.ApplicationCall, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handlePostMessage(io.ktor.server.application.ApplicationCall r17, e9.InterfaceC4014c<? super Y8.t> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 714
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport.handlePostMessage(io.ktor.server.application.ApplicationCall, e9.c):java.lang.Object");
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object send(JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        if (!this.initialized.get()) {
            throw new IllegalStateException("Not connected");
        }
        ServerSSESession serverSSESession = this.session;
        AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
        mcpJson.getSerializersModule();
        Object objSend$default = ServerSSESession.DefaultImpls.send$default(serverSSESession, mcpJson.a(JSONRPCMessage.INSTANCE.serializer(), jSONRPCMessage), "message", null, null, null, interfaceC4014c, 28, null);
        return objSend$default == C4063a.g() ? objSend$default : Y8.t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008b, code lost:
    
        if (r12.T0(r7) == r0) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Type inference failed for: r11v0, types: [io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport, io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport] */
    /* JADX WARN: Type inference failed for: r11v1, types: [io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport] */
    /* JADX WARN: Type inference failed for: r11v5, types: [Y8.t, java.lang.Object] */
    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r12 instanceof io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport.C46021
            if (r0 == 0) goto L14
            r0 = r12
            io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$start$1 r0 = (io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport.C46021) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$start$1 r0 = new io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport$start$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r7.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r10 = 2
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 == r2) goto L39
            if (r1 != r10) goto L31
            kotlin.C4849c.b(r12)     // Catch: java.lang.Throwable -> L2e
            goto L8e
        L2e:
            r0 = move-exception
            r12 = r0
            goto L98
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            kotlin.C4849c.b(r12)
            goto L7b
        L3d:
            kotlin.C4849c.b(r12)
            java.util.concurrent.atomic.AtomicBoolean r12 = r11.initialized
            r1 = 0
            boolean r12 = r12.compareAndSet(r1, r2)
            if (r12 == 0) goto La0
            r12 = r1
            io.ktor.server.sse.ServerSSESession r1 = r11.session
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r11.endpoint
            r5 = 3
            r6 = 0
            java.lang.String r12 = io.ktor.http.CodecsKt.encodeURLPath$default(r4, r12, r12, r5, r6)
            r3.append(r12)
            java.lang.String r12 = "?sessionId="
            r3.append(r12)
            java.lang.String r12 = r11.sessionId
            r3.append(r12)
            java.lang.String r12 = r3.toString()
            r7.label = r2
            java.lang.String r3 = "endpoint"
            r4 = 0
            r5 = 0
            r8 = 28
            r9 = 0
            r2 = r12
            java.lang.Object r12 = io.ktor.server.sse.ServerSSESession.DefaultImpls.send$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r12 != r0) goto L7b
            goto L8d
        L7b:
            io.ktor.server.sse.ServerSSESession r12 = r11.session     // Catch: java.lang.Throwable -> L2e
            kotlin.coroutines.d r12 = r12.getCoroutineContext()     // Catch: java.lang.Throwable -> L2e
            kotlinx.coroutines.g r12 = Ua.C1086v0.o(r12)     // Catch: java.lang.Throwable -> L2e
            r7.label = r10     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r12 = r12.T0(r7)     // Catch: java.lang.Throwable -> L2e
            if (r12 != r0) goto L8e
        L8d:
            return r0
        L8e:
            p9.a r11 = r11.get_onClose()
            r11.invoke()
            Y8.t r11 = Y8.t.f7040a
            return r11
        L98:
            p9.a r11 = r11.get_onClose()
            r11.invoke()
            throw r12
        La0:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "SSEServerTransport already started! If using Server class, note that connect() calls start() automatically."
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.SseServerTransport.start(e9.c):java.lang.Object");
    }
}
