package io.modelcontextprotocol.kotlin.sdk.client;

import Ua.C1060i;
import Ua.CoroutineName;
import Ua.L0;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.C4078e;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import io.modelcontextprotocol.kotlin.sdk.internal.Utils_jvmKt;
import io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport;
import io.modelcontextprotocol.kotlin.sdk.shared.ReadBuffer;
import j8.C4785k;
import j8.InterfaceC4782h;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0082@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\nJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0010\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/client/StdioClientTransport;", "Lio/modelcontextprotocol/kotlin/sdk/shared/AbstractTransport;", "Lfb/v;", "input", "Lfb/s;", "output", "<init>", "(Lfb/v;Lfb/s;)V", "LY8/t;", "processReadBuffer", "(Le9/c;)Ljava/lang/Object;", "start", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "message", "send", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;Le9/c;)Ljava/lang/Object;", "close", "Lfb/v;", "Lfb/s;", "Lj8/h;", "logger", "Lj8/h;", "Lkotlin/coroutines/d;", "ioCoroutineContext", "Lkotlin/coroutines/d;", "LUa/M;", "scope$delegate", "LY8/h;", "getScope", "()LUa/M;", "scope", "Lkotlinx/coroutines/g;", "job", "Lkotlinx/coroutines/g;", "Lkotlin/concurrent/atomics/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "LWa/g;", "sendChannel", "LWa/g;", "Lio/modelcontextprotocol/kotlin/sdk/shared/ReadBuffer;", "readBuffer", "Lio/modelcontextprotocol/kotlin/sdk/shared/ReadBuffer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StdioClientTransport extends AbstractTransport {
    private final AtomicBoolean initialized;
    private final fb.v input;
    private final kotlin.coroutines.d ioCoroutineContext;
    private kotlinx.coroutines.g job;
    private final InterfaceC4782h logger;
    private final fb.s output;
    private final ReadBuffer readBuffer;

    /* renamed from: scope$delegate, reason: from kotlin metadata */
    private final Y8.h scope;
    private final Wa.g<JSONRPCMessage> sendChannel;

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport", f = "StdioClientTransport.kt", l = {118}, m = "close")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$close$1, reason: invalid class name */
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
            return StdioClientTransport.this.close(this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport", f = "StdioClientTransport.kt", l = {130}, m = "processReadBuffer")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$processReadBuffer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C45591 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C45591(InterfaceC4014c<? super C45591> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StdioClientTransport.this.processReadBuffer(this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$start$3", f = "StdioClientTransport.kt", l = {100, 101}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$start$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ fb.s $outputStream;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(fb.s sVar, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$outputStream = sVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass3 anonymousClass3 = StdioClientTransport.this.new AnonymousClass3(this.$outputStream, interfaceC4014c);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0085, code lost:
        
            if (Ua.C1086v0.g(r2, r10) == r0) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = r10.L$0
                r1 = r0
                Ua.M r1 = (Ua.M) r1
                java.lang.Object r0 = f9.C4063a.g()
                int r2 = r10.label
                r7 = 2
                r8 = 1
                if (r2 == 0) goto L33
                if (r2 == r8) goto L27
                if (r2 != r7) goto L1f
                java.lang.Object r0 = r10.L$2
                kotlinx.coroutines.g r0 = (kotlinx.coroutines.g) r0
                java.lang.Object r0 = r10.L$1
                kotlinx.coroutines.g r0 = (kotlinx.coroutines.g) r0
                kotlin.C4849c.b(r11)
                goto L88
            L1f:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L27:
                java.lang.Object r2 = r10.L$2
                kotlinx.coroutines.g r2 = (kotlinx.coroutines.g) r2
                java.lang.Object r3 = r10.L$1
                kotlinx.coroutines.g r3 = (kotlinx.coroutines.g) r3
                kotlin.C4849c.b(r11)
                goto L6d
            L33:
                kotlin.C4849c.b(r11)
                io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$start$3$readJob$1 r4 = new io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$start$3$readJob$1
                io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport r11 = io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.this
                r9 = 0
                r4.<init>(r11, r9)
                r5 = 3
                r6 = 0
                r2 = 0
                r3 = 0
                kotlinx.coroutines.g r11 = Ua.C1056g.d(r1, r2, r3, r4, r5, r6)
                io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$start$3$writeJob$1 r4 = new io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$start$3$writeJob$1
                io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport r2 = io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.this
                fb.s r3 = r10.$outputStream
                r4.<init>(r2, r3, r9)
                r2 = 0
                r3 = 0
                kotlinx.coroutines.g r2 = Ua.C1056g.d(r1, r2, r3, r4, r5, r6)
                java.lang.Object r3 = g9.h.a(r1)
                r10.L$0 = r3
                java.lang.Object r3 = g9.h.a(r11)
                r10.L$1 = r3
                r10.L$2 = r2
                r10.label = r8
                java.lang.Object r3 = r11.T0(r10)
                if (r3 != r0) goto L6c
                goto L87
            L6c:
                r3 = r11
            L6d:
                java.lang.Object r11 = g9.h.a(r1)
                r10.L$0 = r11
                java.lang.Object r11 = g9.h.a(r3)
                r10.L$1 = r11
                java.lang.Object r11 = g9.h.a(r2)
                r10.L$2 = r11
                r10.label = r7
                java.lang.Object r11 = Ua.C1086v0.g(r2, r10)
                if (r11 != r0) goto L88
            L87:
                return r0
            L88:
                io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport r10 = io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.this
                p9.a r10 = io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.access$get_onClose(r10)
                r10.invoke()
                Y8.t r10 = Y8.t.f7040a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public StdioClientTransport(fb.v input, fb.s output) {
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(output, "output");
        this.input = input;
        this.output = output;
        this.logger = C4785k.f34533a.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.t
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Y8.t.f7040a;
            }
        });
        this.ioCoroutineContext = Utils_jvmKt.getIODispatcher();
        this.scope = C4848b.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.u
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StdioClientTransport.scope_delegate$lambda$1(this.f33766a);
            }
        });
        this.initialized = new AtomicBoolean(false);
        this.sendChannel = Wa.j.b(Integer.MAX_VALUE, null, null, 6, null);
        this.readBuffer = new ReadBuffer();
    }

    private final Ua.M getScope() {
        return (Ua.M) this.scope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0058 -> B:19:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processReadBuffer(e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.C45591
            if (r0 == 0) goto L13
            r0 = r6
            io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$processReadBuffer$1 r0 = (io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.C45591) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$processReadBuffer$1 r0 = new io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$processReadBuffer$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r2 = r0.L$0
            io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r2 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r2
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L3a
        L2d:
            r6 = move-exception
            goto L58
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.C4849c.b(r6)
        L3a:
            io.modelcontextprotocol.kotlin.sdk.shared.ReadBuffer r6 = r5.readBuffer
            io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r6 = r6.readMessage()
            if (r6 != 0) goto L45
            Y8.t r5 = Y8.t.f7040a
            return r5
        L45:
            p9.p r2 = r5.get_onMessage()     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r4 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L2d
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2d
            r0.label = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r6 = r2.invoke(r6, r0)     // Catch: java.lang.Throwable -> L2d
            if (r6 != r1) goto L3a
            return r1
        L58:
            p9.l r2 = r5.get_onError()
            r2.invoke(r6)
            j8.h r2 = r5.logger
            io.modelcontextprotocol.kotlin.sdk.client.s r4 = new io.modelcontextprotocol.kotlin.sdk.client.s
            r4.<init>()
            r2.a(r6, r4)
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.processReadBuffer(e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object processReadBuffer$lambda$3() {
        return "Error processing message.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Ua.M scope_delegate$lambda$1(StdioClientTransport stdioClientTransport) {
        return kotlinx.coroutines.d.a(stdioClientTransport.ioCoroutineContext.plus(L0.b(null, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object start$lambda$2() {
        return "Starting StdioClientTransport...";
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
            boolean r0 = r5 instanceof io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$close$1 r0 = (io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$close$1 r0 = new io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$close$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L4a
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            java.util.concurrent.atomic.AtomicBoolean r5 = r4.initialized
            r2 = 0
            boolean r5 = r5.compareAndSet(r3, r2)
            if (r5 == 0) goto L69
            kotlinx.coroutines.g r5 = r4.job
            if (r5 == 0) goto L4a
            r0.label = r3
            java.lang.Object r5 = Ua.C1086v0.g(r5, r0)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            fb.v r5 = r4.input
            r5.close()
            fb.s r5 = r4.output
            r5.close()
            io.modelcontextprotocol.kotlin.sdk.shared.ReadBuffer r5 = r4.readBuffer
            r5.clear()
            Wa.g<io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage> r5 = r4.sendChannel
            r0 = 0
            Wa.s.a.a(r5, r0, r3, r0)
            p9.a r4 = r4.get_onClose()
            r4.invoke()
            Y8.t r4 = Y8.t.f7040a
            return r4
        L69:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Transport is already closed"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport.close(e9.c):java.lang.Object");
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object send(JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        if (!this.initialized.get()) {
            throw new IllegalStateException("Transport not started");
        }
        Object objSend = this.sendChannel.send(jSONRPCMessage, interfaceC4014c);
        return objSend == C4063a.g() ? objSend : Y8.t.f7040a;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object start(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        if (!this.initialized.compareAndSet(false, true)) {
            throw new IllegalStateException("StdioClientTransport already started!");
        }
        this.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StdioClientTransport.start$lambda$2();
            }
        });
        fb.s sVarA = C4078e.a(this.output);
        this.job = C1060i.d(getScope(), new CoroutineName("StdioClientTransport.IO#" + hashCode()), null, new AnonymousClass3(sVarA, null), 2, null);
        return Y8.t.f7040a;
    }
}
