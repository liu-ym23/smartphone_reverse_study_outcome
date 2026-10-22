package io.modelcontextprotocol.kotlin.sdk.client;

import Ua.L0;
import Ua.Y;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.zyql.ai.selector.camera.CustomCameraView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.sse.ClientSSESession;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.sse.ServerSentEvent;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import io.modelcontextprotocol.kotlin.sdk.RequestId;
import io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport;
import io.modelcontextprotocol.kotlin.sdk.shared.ProtocolKt;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0012\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ8\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0082@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0096@¢\u0006\u0004\b#\u0010$J:\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0086@¢\u0006\u0004\b#\u0010%J\u0010\u0010&\u001a\u00020\nH\u0096@¢\u0006\u0004\b&\u0010 J\u0010\u0010'\u001a\u00020\nH\u0086@¢\u0006\u0004\b'\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010(R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010)R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010*R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010+R(\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010)\u001a\u0004\b1\u0010/\"\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010)¨\u0006C"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/client/StreamableHttpClientTransport;", "Lio/modelcontextprotocol/kotlin/sdk/shared/AbstractTransport;", "Lio/ktor/client/HttpClient;", "client", "", "url", "Lkotlin/time/a;", "reconnectionTime", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "LY8/t;", "requestBuilder", "<init>", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/a;Lp9/l;Lkotlin/jvm/internal/i;)V", "resumptionToken", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "replayMessageId", "onResumptionToken", "startSseSession", "(Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/RequestId;Lp9/l;Le9/c;)Ljava/lang/Object;", "builder", "applyCommonHeaders", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "Lio/ktor/client/plugins/sse/ClientSSESession;", "session", "collectSse", "(Lio/ktor/client/plugins/sse/ClientSSESession;Lio/modelcontextprotocol/kotlin/sdk/RequestId;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", UxipConstants.f30685x, "handleInlineSse", "(Lio/ktor/client/statement/HttpResponse;Lio/modelcontextprotocol/kotlin/sdk/RequestId;Lp9/l;Le9/c;)Ljava/lang/Object;", "start", "(Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "message", "send", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;Le9/c;)Ljava/lang/Object;", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "close", "terminateSession", "Lio/ktor/client/HttpClient;", "Ljava/lang/String;", "Lkotlin/time/a;", "Lp9/l;", UxipConstants.f30680s, "sessionId", "getSessionId", "()Ljava/lang/String;", Constants.PARAM_PROTOCOL_VERSION, "getProtocolVersion", "setProtocolVersion", "(Ljava/lang/String;)V", "Lkotlin/concurrent/atomics/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sseSession", "Lio/ktor/client/plugins/sse/ClientSSESession;", "Lkotlinx/coroutines/g;", "sseJob", "Lkotlinx/coroutines/g;", "LUa/M;", "scope$delegate", "LY8/h;", "getScope", "()LUa/M;", "scope", "lastEventId", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StreamableHttpClientTransport extends AbstractTransport {
    private final HttpClient client;
    private final AtomicBoolean initialized;
    private String lastEventId;
    private String protocolVersion;
    private final kotlin.time.a reconnectionTime;
    private final InterfaceC5074l<HttpRequestBuilder, Y8.t> requestBuilder;

    /* renamed from: scope$delegate, reason: from kotlin metadata */
    private final Y8.h scope;
    private String sessionId;
    private kotlinx.coroutines.g sseJob;
    private ClientSSESession sseSession;
    private final String url;

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport", f = "StreamableHttpClientTransport.kt", l = {171, 174}, m = "close")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$close$1, reason: invalid class name */
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
            return StreamableHttpClientTransport.this.close(this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport", f = "StreamableHttpClientTransport.kt", l = {CustomCameraView.BUTTON_STATE_BOTH}, m = "collectSse")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$collectSse$1, reason: invalid class name and case insensitive filesystem */
    public static final class C45601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C45601(InterfaceC4014c<? super C45601> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamableHttpClientTransport.this.collectSse(null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport", f = "StreamableHttpClientTransport.kt", l = {295, 324, 326}, m = "handleInlineSse")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$handleInlineSse$1, reason: invalid class name and case insensitive filesystem */
    public static final class C45611 extends ContinuationImpl {
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

        public C45611(InterfaceC4014c<? super C45611> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamableHttpClientTransport.this.handleInlineSse(null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport", f = "StreamableHttpClientTransport.kt", l = {111, 369, 131, 137, 143, 145, 149, 154}, m = "send")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$send$2, reason: invalid class name and case insensitive filesystem */
    public static final class C45622 extends ContinuationImpl {
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
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C45622(InterfaceC4014c<? super C45622> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamableHttpClientTransport.this.send(null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport", f = "StreamableHttpClientTransport.kt", l = {217, 221}, m = "startSseSession")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$startSseSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C45631 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C45631(InterfaceC4014c<? super C45631> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamableHttpClientTransport.this.startSseSession(null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$startSseSession$6", f = "StreamableHttpClientTransport.kt", l = {242}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$startSseSession$6, reason: invalid class name */
    public static final class AnonymousClass6 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<String, Y8.t> $onResumptionToken;
        final /* synthetic */ RequestId $replayMessageId;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass6(RequestId requestId, InterfaceC5074l<? super String, Y8.t> interfaceC5074l, InterfaceC4014c<? super AnonymousClass6> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$replayMessageId = requestId;
            this.$onResumptionToken = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return StreamableHttpClientTransport.this.new AnonymousClass6(this.$replayMessageId, this.$onResumptionToken, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass6) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ClientSSESession clientSSESession = StreamableHttpClientTransport.this.sseSession;
                if (clientSSESession != null) {
                    StreamableHttpClientTransport streamableHttpClientTransport = StreamableHttpClientTransport.this;
                    RequestId requestId = this.$replayMessageId;
                    InterfaceC5074l<String, Y8.t> interfaceC5074l = this.$onResumptionToken;
                    this.L$0 = g9.h.a(clientSSESession);
                    this.I$0 = 0;
                    this.label = 1;
                    if (streamableHttpClientTransport.collectSse(clientSSESession, requestId, interfaceC5074l, this) == objG) {
                        return objG;
                    }
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

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport", f = "StreamableHttpClientTransport.kt", l = {345}, m = "terminateSession")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$terminateSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C45641 extends ContinuationImpl {
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

        public C45641(InterfaceC4014c<? super C45641> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamableHttpClientTransport.this.terminateSession(this);
        }
    }

    public /* synthetic */ StreamableHttpClientTransport(HttpClient httpClient, String str, kotlin.time.a aVar, InterfaceC5074l interfaceC5074l, kotlin.jvm.internal.i iVar) {
        this(httpClient, str, aVar, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t _init_$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    private final void applyCommonHeaders(HttpRequestBuilder builder) {
        HttpRequestKt.headers(builder, new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.client.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StreamableHttpClientTransport.applyCommonHeaders$lambda$23(this.f33745a, (HeadersBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applyCommonHeaders$lambda$23(StreamableHttpClientTransport streamableHttpClientTransport, HeadersBuilder headers) {
        kotlin.jvm.internal.p.i(headers, "$this$headers");
        String str = streamableHttpClientTransport.sessionId;
        if (str != null) {
            headers.append("mcp-session-id", str);
        }
        String str2 = streamableHttpClientTransport.protocolVersion;
        if (str2 != null) {
            headers.append("mcp-protocol-version", str2);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object close$lambda$11() {
        return "Client transport closing.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collectSse(io.ktor.client.plugins.sse.ClientSSESession r5, io.modelcontextprotocol.kotlin.sdk.RequestId r6, p9.InterfaceC5074l<? super java.lang.String, Y8.t> r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.C45601
            if (r0 == 0) goto L13
            r0 = r8
            io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$collectSse$1 r0 = (io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.C45601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$collectSse$1 r0 = new io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$collectSse$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.L$2
            p9.l r5 = (p9.InterfaceC5074l) r5
            java.lang.Object r5 = r0.L$1
            io.modelcontextprotocol.kotlin.sdk.RequestId r5 = (io.modelcontextprotocol.kotlin.sdk.RequestId) r5
            java.lang.Object r5 = r0.L$0
            io.ktor.client.plugins.sse.ClientSSESession r5 = (io.ktor.client.plugins.sse.ClientSSESession) r5
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            goto L6d
        L35:
            r5 = move-exception
            goto L66
        L37:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3f:
            kotlin.C4849c.b(r8)
            Xa.b r8 = r5.getIncoming()     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$collectSse$2 r2 = new io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$collectSse$2     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            r2.<init>(r7, r6)     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            r0.label = r3     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            java.lang.Object r4 = r8.collect(r2, r0)     // Catch: java.lang.Throwable -> L35 java.util.concurrent.CancellationException -> L6d
            if (r4 != r1) goto L6d
            return r1
        L66:
            p9.l r4 = r4.get_onError()
            r4.invoke(r5)
        L6d:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.collectSse(io.ktor.client.plugins.sse.ClientSSESession, io.modelcontextprotocol.kotlin.sdk.RequestId, p9.l, e9.c):java.lang.Object");
    }

    private final Ua.M getScope() {
        return (Ua.M) this.scope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00cc, code lost:
    
        if (r5 == r10) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r0v15, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v19, types: [T, java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0155 -> B:37:0x015d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01ab -> B:22:0x00e7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleInlineSse(io.ktor.client.statement.HttpResponse r19, io.modelcontextprotocol.kotlin.sdk.RequestId r20, p9.InterfaceC5074l<? super java.lang.String, Y8.t> r21, e9.InterfaceC4014c<? super Y8.t> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.handleInlineSse(io.ktor.client.statement.HttpResponse, io.modelcontextprotocol.kotlin.sdk.RequestId, p9.l, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0102, code lost:
    
        if (r9.invoke(r13, r6) == r7) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0133, code lost:
    
        if (r10.invoke(r8, r6) == r7) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0135, code lost:
    
        return r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object handleInlineSse$dispatch(kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r20, kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r21, io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport r22, java.lang.StringBuilder r23, p9.InterfaceC5074l<? super java.lang.String, Y8.t> r24, io.modelcontextprotocol.kotlin.sdk.RequestId r25, java.lang.String r26, e9.InterfaceC4014c<? super Y8.t> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.handleInlineSse$dispatch(kotlin.jvm.internal.Ref$ObjectRef, kotlin.jvm.internal.Ref$ObjectRef, io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport, java.lang.StringBuilder, p9.l, io.modelcontextprotocol.kotlin.sdk.RequestId, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleInlineSse$lambda$24() {
        return "Handling inline SSE from POST response";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Ua.M scope_delegate$lambda$1() {
        return kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.a()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object send$default(StreamableHttpClientTransport streamableHttpClientTransport, JSONRPCMessage jSONRPCMessage, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = null;
        }
        return streamableHttpClientTransport.send(jSONRPCMessage, str, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object send$lambda$3(StreamableHttpClientTransport streamableHttpClientTransport, JSONRPCMessage jSONRPCMessage) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Client sending message via POST to ");
        sb2.append(streamableHttpClientTransport.url);
        sb2.append(": ");
        AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
        mcpJson.getSerializersModule();
        sb2.append(mcpJson.a(JSONRPCMessage.INSTANCE.serializer(), jSONRPCMessage));
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object start$lambda$2() {
        return "Client transport starting...";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object startSseSession(final java.lang.String r12, io.modelcontextprotocol.kotlin.sdk.RequestId r13, p9.InterfaceC5074l<? super java.lang.String, Y8.t> r14, e9.InterfaceC4014c<? super Y8.t> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.startSseSession(java.lang.String, io.modelcontextprotocol.kotlin.sdk.RequestId, p9.l, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object startSseSession$default(StreamableHttpClientTransport streamableHttpClientTransport, String str, RequestId requestId, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            requestId = null;
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = null;
        }
        return streamableHttpClientTransport.startSseSession(str, requestId, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object startSseSession$lambda$16(StreamableHttpClientTransport streamableHttpClientTransport) {
        return "Client attempting to start SSE session at url: " + streamableHttpClientTransport.url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t startSseSession$lambda$18(StreamableHttpClientTransport streamableHttpClientTransport, String str, HttpRequestBuilder sseSession) {
        kotlin.jvm.internal.p.i(sseSession, "$this$sseSession");
        sseSession.setMethod(HttpMethod.INSTANCE.getGet());
        streamableHttpClientTransport.applyCommonHeaders(sseSession);
        UtilsKt.accept(sseSession, ContentType.Text.INSTANCE.getEventStream());
        if (str == null) {
            str = streamableHttpClientTransport.lastEventId;
        }
        if (str != null) {
            sseSession.getHeaders().append(HttpHeaders.LAST_EVENT_ID, str);
        }
        streamableHttpClientTransport.requestBuilder.invoke(sseSession);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object startSseSession$lambda$19() {
        return "Client SSE session started successfully.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object startSseSession$lambda$20() {
        return "Server returned 405 for GET/SSE, stream disabled.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object terminateSession$lambda$12(StreamableHttpClientTransport streamableHttpClientTransport) {
        return "Terminating session: " + streamableHttpClientTransport.sessionId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object terminateSession$lambda$14() {
        return "Failed to terminate session";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object terminateSession$lambda$15() {
        return "Session terminated successfully";
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
    
        if (Ua.C1086v0.g(r8, r0) == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object close(e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$close$1 r0 = (io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$close$1 r0 = new io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$close$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L3c
            if (r2 == r6) goto L38
            if (r2 != r3) goto L30
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
            goto L73
        L2e:
            r8 = move-exception
            goto L87
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
            goto L5f
        L3c:
            kotlin.C4849c.b(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.initialized
            boolean r8 = r8.get()
            if (r8 != 0) goto L4a
            Y8.t r7 = Y8.t.f7040a
            return r7
        L4a:
            j8.h r8 = io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransportKt.access$getLogger$p()
            io.modelcontextprotocol.kotlin.sdk.client.N r2 = new io.modelcontextprotocol.kotlin.sdk.client.N
            r2.<init>()
            r8.g(r2)
            r0.label = r6     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
            java.lang.Object r8 = r7.terminateSession(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
            if (r8 != r1) goto L5f
            goto L72
        L5f:
            io.ktor.client.plugins.sse.ClientSSESession r8 = r7.sseSession     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
            if (r8 == 0) goto L66
            kotlinx.coroutines.d.e(r8, r5, r6, r5)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
        L66:
            kotlinx.coroutines.g r8 = r7.sseJob     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
            if (r8 == 0) goto L73
            r0.label = r3     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
            java.lang.Object r8 = Ua.C1086v0.g(r8, r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
            if (r8 != r1) goto L73
        L72:
            return r1
        L73:
            Ua.M r8 = r7.getScope()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
            kotlinx.coroutines.d.e(r8, r5, r6, r5)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L7a
        L7a:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.initialized
            r8.set(r4)
            p9.a r7 = r7.get_onClose()
            r7.invoke()
            goto L94
        L87:
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.initialized
            r0.set(r4)
            p9.a r7 = r7.get_onClose()
            r7.invoke()
            throw r8
        L94:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.close(e9.c):java.lang.Object");
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object send(JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objSend$default = send$default(this, jSONRPCMessage, null, null, interfaceC4014c, 4, null);
        return objSend$default == C4063a.g() ? objSend$default : Y8.t.f7040a;
    }

    public final void setProtocolVersion(String str) {
        this.protocolVersion = str;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object start(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        if (!this.initialized.compareAndSet(false, true)) {
            throw new IllegalStateException("StreamableHttpClientTransport already started!");
        }
        StreamableHttpClientTransportKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.H
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StreamableHttpClientTransport.start$lambda$2();
            }
        });
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object terminateSession(e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.terminateSession(e9.c):java.lang.Object");
    }

    public /* synthetic */ StreamableHttpClientTransport(HttpClient httpClient, String str, kotlin.time.a aVar, InterfaceC5074l interfaceC5074l, int i10, kotlin.jvm.internal.i iVar) {
        this(httpClient, str, (i10 & 4) != 0 ? null : aVar, (i10 & 8) != 0 ? new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.client.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StreamableHttpClientTransport._init_$lambda$0((HttpRequestBuilder) obj);
            }
        } : interfaceC5074l, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0442, code lost:
    
        if (handleInlineSse(r6, r7, r4, r5) == r8) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0164, code lost:
    
        if (startSseSession(r2, r10, r21, r5) == r8) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x02b7, code lost:
    
        if (startSseSession$default(r18, null, null, r4, r5, 3, null) == r8) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x03e3, code lost:
    
        if (r12.invoke(r4, r5) == r8) goto L111;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0378 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object send(io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r19, java.lang.String r20, p9.InterfaceC5074l<? super java.lang.String, Y8.t> r21, e9.InterfaceC4014c<? super Y8.t> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.send(io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage, java.lang.String, p9.l, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private StreamableHttpClientTransport(HttpClient client, String url, kotlin.time.a aVar, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> requestBuilder) {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(requestBuilder, "requestBuilder");
        this.client = client;
        this.url = url;
        this.reconnectionTime = aVar;
        this.requestBuilder = requestBuilder;
        this.initialized = new AtomicBoolean(false);
        this.scope = C4848b.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.B
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StreamableHttpClientTransport.scope_delegate$lambda$1();
            }
        });
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$collectSse$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Xa.c {
        final /* synthetic */ InterfaceC5074l<String, Y8.t> $onResumptionToken;
        final /* synthetic */ RequestId $replayMessageId;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(InterfaceC5074l<? super String, Y8.t> interfaceC5074l, RequestId requestId) {
            this.$onResumptionToken = interfaceC5074l;
            this.$replayMessageId = requestId;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object emit$lambda$1(ServerSentEvent serverSentEvent) {
            return "Client received SSE event: event=" + serverSentEvent.getEvent() + ", data=" + serverSentEvent.getData() + ", id=" + serverSentEvent.getId();
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x011e, code lost:
        
            if (r5.invoke(r8, r2) == r3) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0121, code lost:
        
            r3 = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0149, code lost:
        
            if (r8.invoke(r15, r2) == r3) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x014b, code lost:
        
            return r3;
         */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0156  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(final io.ktor.sse.ServerSentEvent r18, e9.InterfaceC4014c<? super Y8.t> r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 348
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport.AnonymousClass2.emit(io.ktor.sse.ServerSentEvent, e9.c):java.lang.Object");
        }

        @Override // Xa.c
        public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
            return emit((ServerSentEvent) obj, (InterfaceC4014c<? super Y8.t>) interfaceC4014c);
        }
    }
}
