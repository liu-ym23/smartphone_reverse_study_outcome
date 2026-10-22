package io.modelcontextprotocol.kotlin.sdk.client;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import com.fasterxml.jackson.core.JsonPointer;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.sse.ClientSSESession;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.UrlKt;
import io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000f\u001a\u00020\n*\u00020\u000eH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u0019\u0010\u0018J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u001e\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010!R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001b\u00105\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/client/SseClientTransport;", "Lio/modelcontextprotocol/kotlin/sdk/shared/AbstractTransport;", "Lio/ktor/client/HttpClient;", "client", "", "urlString", "Lkotlin/time/a;", "reconnectionTime", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "LY8/t;", "requestBuilder", "<init>", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/a;Lp9/l;Lkotlin/jvm/internal/i;)V", "LUa/M;", "collectMessages", "(LUa/M;Le9/c;)Ljava/lang/Object;", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30740g, "handleEndpoint", "(Ljava/lang/String;)V", "data", "handleMessage", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "closeResources", "(Le9/c;)Ljava/lang/Object;", "start", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "message", "send", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;Le9/c;)Ljava/lang/Object;", "close", "Lio/ktor/client/HttpClient;", "Ljava/lang/String;", "Lkotlin/time/a;", "Lp9/l;", "Lkotlin/concurrent/atomics/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "LUa/u;", "endpoint", "LUa/u;", "Lio/ktor/client/plugins/sse/ClientSSESession;", "session", "Lio/ktor/client/plugins/sse/ClientSSESession;", "scope", "LUa/M;", "Lkotlinx/coroutines/g;", "job", "Lkotlinx/coroutines/g;", "baseUrl$delegate", "LY8/h;", "getBaseUrl", "()Ljava/lang/String;", "baseUrl", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SseClientTransport extends AbstractTransport {

    /* renamed from: baseUrl$delegate, reason: from kotlin metadata */
    private final Y8.h baseUrl;
    private final HttpClient client;
    private final InterfaceC1083u<String> endpoint;
    private final AtomicBoolean initialized;
    private kotlinx.coroutines.g job;
    private final kotlin.time.a reconnectionTime;
    private final InterfaceC5074l<HttpRequestBuilder, Y8.t> requestBuilder;
    private Ua.M scope;
    private ClientSSESession session;
    private final String urlString;

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport", f = "SSEClientTransport.kt", l = {179}, m = "closeResources")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$closeResources$1, reason: invalid class name */
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
            return SseClientTransport.this.closeResources(this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport", f = "SSEClientTransport.kt", l = {127, 151, 151}, m = "collectMessages")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$collectMessages$1, reason: invalid class name and case insensitive filesystem */
    public static final class C45551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C45551(InterfaceC4014c<? super C45551> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SseClientTransport.this.collectMessages(null, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport", f = "SSEClientTransport.kt", l = {170}, m = "handleMessage")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$handleMessage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C45561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C45561(InterfaceC4014c<? super C45561> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SseClientTransport.this.handleMessage(null, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport", f = "SSEClientTransport.kt", l = {224, 111}, m = "send")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$send$1, reason: invalid class name and case insensitive filesystem */
    public static final class C45571 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        public C45571(InterfaceC4014c<? super C45571> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SseClientTransport.this.send(null, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport", f = "SSEClientTransport.kt", l = {74, 79, 89, 91}, m = "start")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C45581 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C45581(InterfaceC4014c<? super C45581> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SseClientTransport.this.start(this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$start$4", f = "SSEClientTransport.kt", l = {86}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$start$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass4(InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass4 anonymousClass4 = SseClientTransport.this.new AnonymousClass4(interfaceC4014c);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass4) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ua.M m10 = (Ua.M) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                SseClientTransport sseClientTransport = SseClientTransport.this;
                this.L$0 = g9.h.a(m10);
                this.label = 1;
                if (sseClientTransport.collectMessages(m10, this) == objG) {
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

    public /* synthetic */ SseClientTransport(HttpClient httpClient, String str, kotlin.time.a aVar, InterfaceC5074l interfaceC5074l, kotlin.jvm.internal.i iVar) {
        this(httpClient, str, aVar, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t _init_$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String baseUrl_delegate$lambda$2(SseClientTransport sseClientTransport) {
        ClientSSESession clientSSESession = sseClientTransport.session;
        if (clientSSESession == null) {
            kotlin.jvm.internal.p.A("session");
            clientSSESession = null;
        }
        Url url = clientSSESession.getCall().getRequest().getUrl();
        String encodedPath = url.getEncodedPath();
        if (encodedPath.length() == 0) {
            return UrlKt.getProtocolWithAuthority(url);
        }
        if (La.D.K(encodedPath, "/", false, 2, null)) {
            return UrlKt.getProtocolWithAuthority(url) + La.H.T0(encodedPath, "/");
        }
        return UrlKt.getProtocolWithAuthority(url) + La.K.R1(encodedPath, La.H.B0(encodedPath, "/", 0, false, 6, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object closeResources(e9.InterfaceC4014c<? super Y8.t> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$closeResources$1 r0 = (io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$closeResources$1 r0 = new io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$closeResources$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L4d
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
            if (r5 != 0) goto L40
            Y8.t r4 = Y8.t.f7040a
            return r4
        L40:
            kotlinx.coroutines.g r5 = r4.job
            if (r5 == 0) goto L4d
            r0.label = r3
            java.lang.Object r5 = Ua.C1086v0.g(r5, r0)
            if (r5 != r1) goto L4d
            return r1
        L4d:
            io.ktor.client.plugins.sse.ClientSSESession r5 = r4.session     // Catch: java.lang.Throwable -> L5b
            r0 = 0
            if (r5 == 0) goto L60
            if (r5 != 0) goto L5d
            java.lang.String r5 = "session"
            kotlin.jvm.internal.p.A(r5)     // Catch: java.lang.Throwable -> L5b
            r5 = r0
            goto L5d
        L5b:
            r5 = move-exception
            goto L75
        L5d:
            kotlinx.coroutines.d.e(r5, r0, r3, r0)     // Catch: java.lang.Throwable -> L5b
        L60:
            Ua.M r5 = r4.scope     // Catch: java.lang.Throwable -> L5b
            if (r5 == 0) goto L6f
            if (r5 != 0) goto L6c
            java.lang.String r5 = "scope"
            kotlin.jvm.internal.p.A(r5)     // Catch: java.lang.Throwable -> L5b
            r5 = r0
        L6c:
            kotlinx.coroutines.d.e(r5, r0, r3, r0)     // Catch: java.lang.Throwable -> L5b
        L6f:
            Ua.u<java.lang.String> r5 = r4.endpoint     // Catch: java.lang.Throwable -> L5b
            kotlinx.coroutines.g.a.a(r5, r0, r3, r0)     // Catch: java.lang.Throwable -> L5b
            goto L7c
        L75:
            p9.l r0 = r4.get_onError()
            r0.invoke(r5)
        L7c:
            p9.a r4 = r4.get_onClose()
            r4.invoke()
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.closeResources(e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
    
        if (closeResources(r0) == r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collectMessages(final Ua.M r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.C45551
            if (r0 == 0) goto L13
            r0 = r9
            io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$collectMessages$1 r0 = (io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.C45551) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$collectMessages$1 r0 = new io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$collectMessages$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L53
            if (r2 == r5) goto L47
            if (r2 == r4) goto L3f
            if (r2 == r3) goto L33
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            java.lang.Object r7 = r0.L$1
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r8 = r0.L$0
            Ua.M r8 = (Ua.M) r8
            kotlin.C4849c.b(r9)
            goto La7
        L3f:
            java.lang.Object r7 = r0.L$0
            Ua.M r7 = (Ua.M) r7
            kotlin.C4849c.b(r9)
            goto L87
        L47:
            java.lang.Object r8 = r0.L$0
            Ua.M r8 = (Ua.M) r8
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L51
            goto L78
        L4f:
            r9 = move-exception
            goto L8a
        L51:
            r9 = move-exception
            goto L94
        L53:
            kotlin.C4849c.b(r9)
            io.ktor.client.plugins.sse.ClientSSESession r9 = r7.session     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L51
            if (r9 != 0) goto L60
            java.lang.String r9 = "session"
            kotlin.jvm.internal.p.A(r9)     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L51
            r9 = 0
        L60:
            Xa.b r9 = r9.getIncoming()     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L51
            io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$collectMessages$2 r2 = new io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$collectMessages$2     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L51
            r2.<init>()     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L51
            java.lang.Object r6 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L51
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L51
            r0.label = r5     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L51
            java.lang.Object r9 = r9.collect(r2, r0)     // Catch: java.lang.Throwable -> L4f java.util.concurrent.CancellationException -> L51
            if (r9 != r1) goto L78
            goto La5
        L78:
            java.lang.Object r8 = g9.h.a(r8)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = r7.closeResources(r0)
            if (r7 != r1) goto L87
            goto La5
        L87:
            Y8.t r7 = Y8.t.f7040a
            return r7
        L8a:
            p9.l r2 = r7.get_onError()     // Catch: java.lang.Throwable -> L92
            r2.invoke(r9)     // Catch: java.lang.Throwable -> L92
            throw r9     // Catch: java.lang.Throwable -> L92
        L92:
            r9 = move-exception
            goto L95
        L94:
            throw r9     // Catch: java.lang.Throwable -> L92
        L95:
            java.lang.Object r8 = g9.h.a(r8)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r7 = r7.closeResources(r0)
            if (r7 != r1) goto La6
        La5:
            return r1
        La6:
            r7 = r9
        La7:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.collectMessages(Ua.M, e9.c):java.lang.Object");
    }

    private final String getBaseUrl() {
        return (String) this.baseUrl.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleEndpoint(String eventData) {
        try {
            if (La.D.X(eventData, "/", false, 2, null)) {
                eventData = eventData.substring(1);
                kotlin.jvm.internal.p.h(eventData, "substring(...)");
            }
            this.endpoint.complete(URLUtilsKt.Url(getBaseUrl() + JsonPointer.SEPARATOR + eventData).getUrlString());
        } catch (Throwable th) {
            get_onError().invoke(th);
            this.endpoint.e(th);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleMessage(java.lang.String r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.C45561
            if (r0 == 0) goto L13
            r0 = r6
            io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$handleMessage$1 r0 = (io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.C45561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$handleMessage$1 r0 = new io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport$handleMessage$1
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
            kotlin.C4849c.b(r6)     // Catch: kotlinx.serialization.SerializationException -> L31
            goto L73
        L31:
            r5 = move-exception
            goto L6c
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r6)
            qb.a r6 = io.modelcontextprotocol.kotlin.sdk.shared.ProtocolKt.getMcpJson()     // Catch: kotlinx.serialization.SerializationException -> L31
            r6.getSerializersModule()     // Catch: kotlinx.serialization.SerializationException -> L31
            io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage$Companion r2 = io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage.INSTANCE     // Catch: kotlinx.serialization.SerializationException -> L31
            kotlinx.serialization.KSerializer r2 = r2.serializer()     // Catch: kotlinx.serialization.SerializationException -> L31
            lb.a r2 = (lb.InterfaceC4883a) r2     // Catch: kotlinx.serialization.SerializationException -> L31
            java.lang.Object r6 = r6.c(r2, r5)     // Catch: kotlinx.serialization.SerializationException -> L31
            io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r6 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r6     // Catch: kotlinx.serialization.SerializationException -> L31
            p9.p r2 = r4.get_onMessage()     // Catch: kotlinx.serialization.SerializationException -> L31
            java.lang.Object r5 = g9.h.a(r5)     // Catch: kotlinx.serialization.SerializationException -> L31
            r0.L$0 = r5     // Catch: kotlinx.serialization.SerializationException -> L31
            java.lang.Object r5 = g9.h.a(r6)     // Catch: kotlinx.serialization.SerializationException -> L31
            r0.L$1 = r5     // Catch: kotlinx.serialization.SerializationException -> L31
            r0.label = r3     // Catch: kotlinx.serialization.SerializationException -> L31
            java.lang.Object r4 = r2.invoke(r6, r0)     // Catch: kotlinx.serialization.SerializationException -> L31
            if (r4 != r1) goto L73
            return r1
        L6c:
            p9.l r4 = r4.get_onError()
            r4.invoke(r5)
        L73:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.handleMessage(java.lang.String, e9.c):java.lang.Object");
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object close(InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        if (!this.initialized.get()) {
            throw new IllegalStateException("SseClientTransport is not initialized!");
        }
        Object objCloseResources = closeResources(interfaceC4014c);
        return objCloseResources == C4063a.g() ? objCloseResources : Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object send(io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r12, e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.send(io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d5, code lost:
    
        if (r3 != r2) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e2 A[Catch: Exception -> 0x00b5, TryCatch #3 {Exception -> 0x00b5, blocks: (B:66:0x013b, B:55:0x00d9, B:56:0x00dc, B:58:0x00e2, B:59:0x00e8, B:61:0x00fc, B:63:0x0104, B:41:0x00af, B:49:0x00bf, B:37:0x00a6), top: B:84:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fc A[Catch: Exception -> 0x00b5, TryCatch #3 {Exception -> 0x00b5, blocks: (B:66:0x013b, B:55:0x00d9, B:56:0x00dc, B:58:0x00e2, B:59:0x00e8, B:61:0x00fc, B:63:0x0104, B:41:0x00af, B:49:0x00bf, B:37:0x00a6), top: B:84:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r15v10, types: [e9.c, java.lang.Object, kotlinx.coroutines.g] */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(e9.InterfaceC4014c<? super Y8.t> r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.SseClientTransport.start(e9.c):java.lang.Object");
    }

    public /* synthetic */ SseClientTransport(HttpClient httpClient, String str, kotlin.time.a aVar, InterfaceC5074l interfaceC5074l, int i10, kotlin.jvm.internal.i iVar) {
        this(httpClient, str, (i10 & 4) != 0 ? null : aVar, (i10 & 8) != 0 ? new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.client.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SseClientTransport._init_$lambda$0((HttpRequestBuilder) obj);
            }
        } : interfaceC5074l, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SseClientTransport(HttpClient client, String str, kotlin.time.a aVar, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> requestBuilder) {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(requestBuilder, "requestBuilder");
        this.client = client;
        this.urlString = str;
        this.reconnectionTime = aVar;
        this.requestBuilder = requestBuilder;
        this.initialized = new AtomicBoolean(false);
        this.endpoint = C1087w.c(null, 1, null);
        this.baseUrl = C4848b.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SseClientTransport.baseUrl_delegate$lambda$2(this.f33765a);
            }
        });
    }
}
