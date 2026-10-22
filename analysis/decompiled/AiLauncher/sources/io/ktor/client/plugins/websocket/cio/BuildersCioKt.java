package io.ktor.client.plugins.websocket.cio;

import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.websocket.ClientWebSocketSession;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLProtocol;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001aX\u0010\r\u001a\u00020\f*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a|\u0010\u0013\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a|\u0010\u0015\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0086@¢\u0006\u0004\b\u0015\u0010\u0014\u001a|\u0010\u0016\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0086@¢\u0006\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/http/HttpMethod;", "method", "", "host", "", "port", "path", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "LY8/t;", "block", "Lio/ktor/client/plugins/websocket/ClientWebSocketSession;", "webSocketRawSession", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "request", "Lkotlin/Function2;", "Le9/c;", "", "webSocketRaw", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/l;Lp9/p;Le9/c;)Ljava/lang/Object;", "wsRaw", "wssRaw", "ktor-client-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuildersCioKt {

    @InterfaceC4112d(c = "io.ktor.client.plugins.websocket.cio.BuildersCioKt", f = "buildersCio.kt", l = {69, 77, 81, 79, 81, 81}, m = "webSocketRaw")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.websocket.cio.BuildersCioKt$webSocketRaw$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BuildersCioKt.webSocketRaw(null, null, null, null, null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.websocket.cio.BuildersCioKt$webSocketRawSession$3", f = "buildersCio.kt", l = {132, 135, 46, 147, 147}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.websocket.cio.BuildersCioKt$webSocketRawSession$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ HttpStatement $request;
        final /* synthetic */ InterfaceC1083u<ClientWebSocketSession> $result;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(HttpStatement httpStatement, InterfaceC1083u<ClientWebSocketSession> interfaceC1083u, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$request = httpStatement;
            this.$result = interfaceC1083u;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass3(this.$request, this.$result, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:(1:78)|(1:(1:(1:(1:(1:(2:9|10)(3:11|12|68))(4:18|19|72|73))(5:21|76|22|54|55))(6:26|82|27|28|79|(3:50|(3:53|54|55)|67)(2:61|62)))(3:31|32|33))(4:34|35|36|(2:38|67)(1:39))|40|74|41|80|42|45|(3:48|79|(0)(0))|67) */
        /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|78|(1:(1:(1:(1:(1:(2:9|10)(3:11|12|68))(4:18|19|72|73))(5:21|76|22|54|55))(6:26|82|27|28|79|(3:50|(3:53|54|55)|67)(2:61|62)))(3:31|32|33))(4:34|35|36|(2:38|67)(1:39))|40|74|41|80|42|45|(3:48|79|(0)(0))|67|(2:(0)|(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00eb, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0185, code lost:
        
            if (r9.cleanup(r8, r16) != r2) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0194, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0195, code lost:
        
            r8 = r12;
            r6 = r13;
            r7 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x01ba, code lost:
        
            if (r9.cleanup(r8, r16) == r2) goto L67;
         */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0119 A[Catch: all -> 0x0188, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0188, blocks: (B:50:0x0119, B:61:0x018c, B:62:0x0193), top: B:79:0x0117 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x018c A[Catch: all -> 0x0188, TRY_ENTER, TryCatch #3 {all -> 0x0188, blocks: (B:50:0x0119, B:61:0x018c, B:62:0x0193), top: B:79:0x0117 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 459
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.cio.BuildersCioKt.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x01bf, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r14, null, r8, 1, null) != r1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0243, code lost:
    
        if (r14 != r1) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x020a A[PHI: r2 r3 r4 r5 r6 r7 r11 r14
      0x020a: PHI (r2v22 ??) = (r2v27 ??), (r2v28 ??) binds: [B:41:0x0206, B:15:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r3v15 ??) = (r3v19 ??), (r3v20 ??) binds: [B:41:0x0206, B:15:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r4v15 ??) = (r4v19 ??), (r4v20 ??) binds: [B:41:0x0206, B:15:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r5v13 java.lang.Integer) = (r5v9 java.lang.Integer), (r5v15 java.lang.Integer) binds: [B:41:0x0206, B:15:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r6v13 java.lang.String) = (r6v9 java.lang.String), (r6v15 java.lang.String) binds: [B:41:0x0206, B:15:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r7v14 io.ktor.http.HttpMethod) = (r7v10 io.ktor.http.HttpMethod), (r7v16 io.ktor.http.HttpMethod) binds: [B:41:0x0206, B:15:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r11v11 io.ktor.client.HttpClient) = (r11v7 io.ktor.client.HttpClient), (r11v13 io.ktor.client.HttpClient) binds: [B:41:0x0206, B:15:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r14v31 io.ktor.client.plugins.websocket.ClientWebSocketSession) = 
      (r14v9 io.ktor.client.plugins.websocket.ClientWebSocketSession)
      (r14v36 io.ktor.client.plugins.websocket.ClientWebSocketSession)
     binds: [B:41:0x0206, B:15:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Type inference failed for: r14v0, types: [io.ktor.client.HttpClient, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object webSocketRaw(io.ktor.client.HttpClient r14, io.ktor.http.HttpMethod r15, java.lang.String r16, final java.lang.Integer r17, java.lang.String r18, final p9.InterfaceC5074l<? super io.ktor.client.request.HttpRequestBuilder, Y8.t> r19, p9.p<? super io.ktor.client.plugins.websocket.ClientWebSocketSession, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r20, e9.InterfaceC4014c<? super Y8.t> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.cio.BuildersCioKt.webSocketRaw(io.ktor.client.HttpClient, io.ktor.http.HttpMethod, java.lang.String, java.lang.Integer, java.lang.String, p9.l, p9.p, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object webSocketRaw$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l interfaceC5074l, p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            httpMethod = HttpMethod.INSTANCE.getGet();
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.cio.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersCioKt.webSocketRaw$lambda$2((HttpRequestBuilder) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        return webSocketRaw(httpClient, httpMethod, str, num, str2, interfaceC5074l2, pVar, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketRaw$lambda$2(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketRaw$lambda$3(Integer num, InterfaceC5074l interfaceC5074l, HttpRequestBuilder webSocketRawSession) {
        kotlin.jvm.internal.p.i(webSocketRawSession, "$this$webSocketRawSession");
        webSocketRawSession.getUrl().setProtocol(URLProtocol.INSTANCE.getWS());
        if (num != null) {
            webSocketRawSession.getUrl().setPort(num.intValue());
        }
        interfaceC5074l.invoke(webSocketRawSession);
        return t.f7040a;
    }

    public static final Object webSocketRawSession(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super ClientWebSocketSession> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url$default(httpRequestBuilder, "ws", str, num, str2, null, 16, null);
        interfaceC5074l.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
        C1060i.d(httpClient, null, null, new AnonymousClass3(httpStatement, interfaceC1083uC, null), 3, null);
        return interfaceC1083uC.a1(interfaceC4014c);
    }

    public static /* synthetic */ Object webSocketRawSession$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            httpMethod = HttpMethod.INSTANCE.getGet();
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.cio.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersCioKt.webSocketRawSession$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return webSocketRawSession(httpClient, httpMethod, str, num, str2, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketRawSession$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    public static final Object wsRaw(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, p<? super ClientWebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWebSocketRaw = webSocketRaw(httpClient, httpMethod, str, num, str2, interfaceC5074l, pVar, interfaceC4014c);
        return objWebSocketRaw == C4063a.g() ? objWebSocketRaw : t.f7040a;
    }

    public static /* synthetic */ Object wsRaw$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l interfaceC5074l, p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            httpMethod = HttpMethod.INSTANCE.getGet();
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.cio.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersCioKt.wsRaw$lambda$4((HttpRequestBuilder) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        return wsRaw(httpClient, httpMethod, str, num, str2, interfaceC5074l2, pVar, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t wsRaw$lambda$4(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    public static final Object wssRaw(HttpClient httpClient, HttpMethod httpMethod, String str, final Integer num, String str2, final InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, p<? super ClientWebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWebSocketRaw = webSocketRaw(httpClient, httpMethod, str, num, str2, new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.cio.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersCioKt.wssRaw$lambda$6(num, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, pVar, interfaceC4014c);
        return objWebSocketRaw == C4063a.g() ? objWebSocketRaw : t.f7040a;
    }

    public static /* synthetic */ Object wssRaw$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l interfaceC5074l, p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            httpMethod = HttpMethod.INSTANCE.getGet();
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.cio.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersCioKt.wssRaw$lambda$5((HttpRequestBuilder) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        return wssRaw(httpClient, httpMethod, str, num, str2, interfaceC5074l2, pVar, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t wssRaw$lambda$5(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t wssRaw$lambda$6(Integer num, InterfaceC5074l interfaceC5074l, HttpRequestBuilder webSocketRaw) {
        kotlin.jvm.internal.p.i(webSocketRaw, "$this$webSocketRaw");
        webSocketRaw.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
        if (num != null) {
            webSocketRaw.getUrl().setPort(num.intValue());
        }
        interfaceC5074l.invoke(webSocketRaw);
        return t.f7040a;
    }
}
