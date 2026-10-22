package io.ktor.client.plugins.sse;

import La.H;
import Ua.C1056g;
import Ua.C1086v0;
import Ua.CoroutineName;
import Ua.M;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.sse.ServerSentEvent;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.JobKt__JobKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u0004H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u0004H\u0082@¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u001b\u001a\u00020\u000b*\u00060\u0017j\u0002`\u00182\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u0019*\u00020\u0004H\u0082@¢\u0006\u0004\b\u001d\u0010\u0015J\u0017\u0010\u001e\u001a\u00020\u0019*\u00060\u0017j\u0002`\u0018H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010!\u001a\u00020 *\u00020\u0013H\u0002¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020 *\u00020\u0013H\u0002¢\u0006\u0004\b#\u0010\"J\u0013\u0010$\u001a\u00020 *\u00020\u0013H\u0002¢\u0006\u0004\b$\u0010\"J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00102R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00102R\u0016\u0010&\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00109R\u0014\u0010:\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00130?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00130?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lio/ktor/client/plugins/sse/DefaultClientSSESession;", "Lio/ktor/client/plugins/sse/SSESession;", "Lio/ktor/client/plugins/sse/SSEClientContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lkotlin/coroutines/d;", "coroutineContext", "<init>", "(Lio/ktor/client/plugins/sse/SSEClientContent;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/d;)V", "(Lio/ktor/client/plugins/sse/SSEClientContent;Lio/ktor/utils/io/ByteReadChannel;)V", "LY8/t;", "doReconnection", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestBuilder;", "getRequestForReconnection", "()Lio/ktor/client/request/HttpRequestBuilder;", "close", "()V", "Lio/ktor/sse/ServerSentEvent;", "tryParseEvent", "(Lio/ktor/utils/io/ByteReadChannel;Le9/c;)Ljava/lang/Object;", "parseEvent", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "comment", "appendComment", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "readUTF8LineWithSave", "toText", "(Ljava/lang/StringBuilder;)Ljava/lang/String;", "", "isEmpty", "(Lio/ktor/sse/ServerSentEvent;)Z", "isCommentsEvent", "isRetryEvent", "", "bodyBuffer", "()[B", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "lastEventId", "Ljava/lang/String;", "", "reconnectionTimeMillis", "J", "showCommentEvents", "Z", "showRetryEvents", "", "maxReconnectionAttempts", "I", "needToReconnect", "Lio/ktor/client/plugins/sse/BodyBuffer;", "Lio/ktor/client/plugins/sse/BodyBuffer;", "initialRequest", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/HttpClient;", "clientForReconnection", "Lio/ktor/client/HttpClient;", "LXa/b;", "_incoming", "LXa/b;", "getIncoming", "()LXa/b;", "incoming", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultClientSSESession implements SSESession {
    private Xa.b<ServerSentEvent> _incoming;
    private BodyBuffer bodyBuffer;
    private final HttpClient clientForReconnection;
    private final kotlin.coroutines.d coroutineContext;
    private final HttpRequestBuilder initialRequest;
    private ByteReadChannel input;
    private String lastEventId;
    private final int maxReconnectionAttempts;
    private boolean needToReconnect;
    private long reconnectionTimeMillis;
    private final boolean showCommentEvents;
    private final boolean showRetryEvents;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$doReconnection$2", f = "DefaultClientSSESession.kt", l = {101, 108, 110}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$doReconnection$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return DefaultClientSSESession.this.new AnonymousClass2(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[Catch: all -> 0x0022, TRY_ENTER, TryCatch #0 {all -> 0x0022, blocks: (B:8:0x001d, B:39:0x010e, B:41:0x011e, B:42:0x0124, B:23:0x0058, B:26:0x0078, B:28:0x008a, B:29:0x00bf, B:32:0x00d2, B:34:0x00e2, B:35:0x00fa, B:15:0x0035, B:18:0x003f), top: B:56:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x008a A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:8:0x001d, B:39:0x010e, B:41:0x011e, B:42:0x0124, B:23:0x0058, B:26:0x0078, B:28:0x008a, B:29:0x00bf, B:32:0x00d2, B:34:0x00e2, B:35:0x00fa, B:15:0x0035, B:18:0x003f), top: B:56:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00d2 A[Catch: all -> 0x0022, PHI: r1 r5 r10
          0x00d2: PHI (r1v10 io.ktor.client.request.HttpRequestBuilder) = (r1v9 io.ktor.client.request.HttpRequestBuilder), (r1v18 io.ktor.client.request.HttpRequestBuilder) binds: [B:30:0x00cf, B:15:0x0035] A[DONT_GENERATE, DONT_INLINE]
          0x00d2: PHI (r5v3 kotlin.jvm.internal.Ref$IntRef) = (r5v2 kotlin.jvm.internal.Ref$IntRef), (r5v9 kotlin.jvm.internal.Ref$IntRef) binds: [B:30:0x00cf, B:15:0x0035] A[DONT_GENERATE, DONT_INLINE]
          0x00d2: PHI (r10v16 java.lang.Object) = (r10v15 java.lang.Object), (r10v0 java.lang.Object) binds: [B:30:0x00cf, B:15:0x0035] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0022, blocks: (B:8:0x001d, B:39:0x010e, B:41:0x011e, B:42:0x0124, B:23:0x0058, B:26:0x0078, B:28:0x008a, B:29:0x00bf, B:32:0x00d2, B:34:0x00e2, B:35:0x00fa, B:15:0x0035, B:18:0x003f), top: B:56:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00e2 A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:8:0x001d, B:39:0x010e, B:41:0x011e, B:42:0x0124, B:23:0x0058, B:26:0x0078, B:28:0x008a, B:29:0x00bf, B:32:0x00d2, B:34:0x00e2, B:35:0x00fa, B:15:0x0035, B:18:0x003f), top: B:56:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x011e A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:8:0x001d, B:39:0x010e, B:41:0x011e, B:42:0x0124, B:23:0x0058, B:26:0x0078, B:28:0x008a, B:29:0x00bf, B:32:0x00d2, B:34:0x00e2, B:35:0x00fa, B:15:0x0035, B:18:0x003f), top: B:56:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0191  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x010d -> B:39:0x010e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 404
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.sse.DefaultClientSSESession", f = "DefaultClientSSESession.kt", l = {DidiCardView.FINISHED_TITLE_TRAILING_WIDTH_DP, 174, 223}, m = "parseEvent")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$parseEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultClientSSESession.this.parseEvent(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.sse.DefaultClientSSESession", f = "DefaultClientSSESession.kt", l = {232}, m = "readUTF8LineWithSave")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$readUTF8LineWithSave$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42331 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C42331(InterfaceC4014c<? super C42331> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultClientSSESession.this.readUTF8LineWithSave(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.sse.DefaultClientSSESession", f = "DefaultClientSSESession.kt", l = {151}, m = "tryParseEvent")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$tryParseEvent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42341 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C42341(InterfaceC4014c<? super C42341> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultClientSSESession.this.tryParseEvent(null, this);
        }
    }

    public DefaultClientSSESession(SSEClientContent content, ByteReadChannel input, kotlin.coroutines.d coroutineContext) {
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        this.input = input;
        this.coroutineContext = coroutineContext;
        this.reconnectionTimeMillis = kotlin.time.a.s(content.getReconnectionTime());
        this.showCommentEvents = content.getShowCommentEvents();
        this.showRetryEvents = content.getShowRetryEvents();
        int maxReconnectionAttempts = content.getMaxReconnectionAttempts();
        this.maxReconnectionAttempts = maxReconnectionAttempts;
        this.needToReconnect = maxReconnectionAttempts > 0;
        this.bodyBuffer = SSEBufferPolicyKt.toBodyBuffer(content.getBufferPolicy());
        HttpRequestBuilder initialRequest = content.getInitialRequest();
        this.initialRequest = initialRequest;
        this.clientForReconnection = (HttpClient) initialRequest.getAttributes().get(SSEKt.getSSEClientForReconnectionAttr());
        this._incoming = Xa.d.J(Xa.d.g(Xa.d.B(new DefaultClientSSESession$_incoming$1(this, null)), new DefaultClientSSESession$_incoming$2(this, null)), new DefaultClientSSESession$_incoming$3(this, null));
        C1086v0.o(getCoroutineContext()).J(new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DefaultClientSSESession._init_$lambda$0(this.f33241a, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t _init_$lambda$0(DefaultClientSSESession defaultClientSSESession, Throwable th) {
        defaultClientSSESession.close();
        return Y8.t.f7040a;
    }

    private final void appendComment(StringBuilder sb2, String str) {
        sb2.append(H.R0(H.R0(str, ServerSentEventKt.COLON), " "));
        sb2.append(ServerSentEventKt.END_OF_LINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void close() {
        JobKt__JobKt.e(getCoroutineContext(), null, 1, null);
        ByteReadChannelKt.cancel(this.input);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doReconnection(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objJ = C1056g.j(getCoroutineContext(), new AnonymousClass2(null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpRequestBuilder getRequestForReconnection() {
        HttpRequestBuilder httpRequestBuilderTakeFrom = new HttpRequestBuilder().takeFrom(this.initialRequest);
        httpRequestBuilderTakeFrom.getAttributes().remove(BuildersKt.getSseRequestAttr());
        httpRequestBuilderTakeFrom.getAttributes().put(SSEKt.getSSEReconnectionRequestAttr(), Boolean.TRUE);
        String str = this.lastEventId;
        if (str != null) {
            httpRequestBuilderTakeFrom.getHeaders().append(HttpHeaders.INSTANCE.getLastEventID(), str);
        }
        return httpRequestBuilderTakeFrom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCommentsEvent(ServerSentEvent serverSentEvent) {
        return serverSentEvent.getData() == null && serverSentEvent.getEvent() == null && serverSentEvent.getId() == null && serverSentEvent.getRetry() == null && serverSentEvent.getComments() != null;
    }

    private final boolean isEmpty(ServerSentEvent serverSentEvent) {
        return serverSentEvent.getData() == null && serverSentEvent.getId() == null && serverSentEvent.getEvent() == null && serverSentEvent.getRetry() == null && serverSentEvent.getComments() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRetryEvent(ServerSentEvent serverSentEvent) {
        return serverSentEvent.getData() == null && serverSentEvent.getEvent() == null && serverSentEvent.getId() == null && serverSentEvent.getComments() == null && serverSentEvent.getRetry() != null;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00ff -> B:30:0x0103). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0237 -> B:91:0x023e). Please report as a decompilation issue!!! */
    public final java.lang.Object parseEvent(io.ktor.utils.io.ByteReadChannel r23, e9.InterfaceC4014c<? super io.ktor.sse.ServerSentEvent> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession.parseEvent(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readUTF8LineWithSave(io.ktor.utils.io.ByteReadChannel r6, e9.InterfaceC4014c<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.sse.DefaultClientSSESession.C42331
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.plugins.sse.DefaultClientSSESession$readUTF8LineWithSave$1 r0 = (io.ktor.client.plugins.sse.DefaultClientSSESession.C42331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.sse.DefaultClientSSESession$readUTF8LineWithSave$1 r0 = new io.ktor.client.plugins.sse.DefaultClientSSESession$readUTF8LineWithSave$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.C4849c.b(r7)
            goto L49
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.C4849c.b(r7)
            java.lang.Object r7 = g9.h.a(r6)
            r0.L$0 = r7
            r0.label = r4
            r7 = 0
            java.lang.Object r7 = io.ktor.utils.io.ByteReadChannelOperationsKt.readUTF8Line$default(r6, r7, r0, r4, r3)
            if (r7 != r1) goto L49
            return r1
        L49:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L4e
            return r3
        L4e:
            io.ktor.client.plugins.sse.BodyBuffer r5 = r5.bodyBuffer
            r5.appendLine(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession.readUTF8LineWithSave(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    private final String toText(StringBuilder sb2) {
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return H.T0(string, ServerSentEventKt.END_OF_LINE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object tryParseEvent(io.ktor.utils.io.ByteReadChannel r5, e9.InterfaceC4014c<? super io.ktor.sse.ServerSentEvent> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.sse.DefaultClientSSESession.C42341
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.sse.DefaultClientSSESession$tryParseEvent$1 r0 = (io.ktor.client.plugins.sse.DefaultClientSSESession.C42341) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.sse.DefaultClientSSESession$tryParseEvent$1 r0 = new io.ktor.client.plugins.sse.DefaultClientSSESession$tryParseEvent$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.C4849c.b(r6)     // Catch: io.ktor.utils.io.ClosedByteChannelException -> L4a
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            java.lang.Object r6 = g9.h.a(r5)     // Catch: io.ktor.utils.io.ClosedByteChannelException -> L4a
            r0.L$0 = r6     // Catch: io.ktor.utils.io.ClosedByteChannelException -> L4a
            r0.label = r3     // Catch: io.ktor.utils.io.ClosedByteChannelException -> L4a
            java.lang.Object r6 = r4.parseEvent(r5, r0)     // Catch: io.ktor.utils.io.ClosedByteChannelException -> L4a
            if (r6 != r1) goto L47
            return r1
        L47:
            io.ktor.sse.ServerSentEvent r6 = (io.ktor.sse.ServerSentEvent) r6     // Catch: io.ktor.utils.io.ClosedByteChannelException -> L4a
            return r6
        L4a:
            r4 = move-exception
            java.lang.Throwable r4 = io.ktor.util.ThrowableKt.getRootCause(r4)
            boolean r5 = r4 instanceof java.net.SocketTimeoutException
            if (r5 != 0) goto L55
            r4 = 0
            return r4
        L55:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession.tryParseEvent(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    @Override // io.ktor.client.plugins.sse.SSESession
    public byte[] bodyBuffer() {
        return this.bodyBuffer.toByteArray();
    }

    @Override // io.ktor.client.plugins.sse.SSESession, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.client.plugins.sse.SSESession
    public Xa.b<ServerSentEvent> getIncoming() {
        return this._incoming;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultClientSSESession(SSEClientContent content, ByteReadChannel input) {
        this(content, input, content.getCallContext().plus(JobKt__JobKt.b(null, 1, null)).plus(new CoroutineName("DefaultClientSSESession")));
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(input, "input");
    }
}
