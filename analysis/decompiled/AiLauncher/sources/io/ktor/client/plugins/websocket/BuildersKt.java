package io.ktor.client.plugins.websocket;

import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a)\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a(\u0010\u000b\u001a\u00020\n*\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001aX\u0010\u000b\u001a\u00020\n*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u000b\u0010\u0014\u001a2\u0010\u000b\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u000b\u0010\u0016\u001aL\u0010\u001b\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001b\u0010\u001c\u001a|\u0010\u001b\u001a\u00020\u0003*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001b\u0010\u001d\u001aV\u0010\u001b\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001b\u0010\u001e\u001a|\u0010\u001f\u001a\u00020\u0003*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001f\u0010\u001d\u001aL\u0010\u001f\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001f\u0010\u001c\u001aV\u0010\u001f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b\u001f\u0010\u001e\u001aL\u0010 \u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b \u0010\u001c\u001aV\u0010 \u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b \u0010\u001e\u001a|\u0010 \u001a\u00020\u0003*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0086@¢\u0006\u0004\b \u0010\u001d¨\u0006!"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "LY8/t;", "config", "WebSockets", "(Lio/ktor/client/HttpClientConfig;Lp9/l;)V", "Lio/ktor/client/HttpClient;", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "webSocketSession", "(Lio/ktor/client/HttpClient;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/HttpMethod;", "method", "", "host", "", "port", "path", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "request", "Lkotlin/Function2;", "Le9/c;", "", "webSocket", "(Lio/ktor/client/HttpClient;Lp9/l;Lp9/p;Le9/c;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/l;Lp9/p;Le9/c;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lp9/l;Lp9/p;Le9/c;)Ljava/lang/Object;", "ws", "wss", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuildersKt {

    @InterfaceC4112d(c = "io.ktor.client.plugins.websocket.BuildersKt", f = "builders.kt", l = {271, 274, 114, 116, 116, 286, 286}, m = "webSocket")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.websocket.BuildersKt$webSocket$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BuildersKt.webSocket(null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2", f = "builders.kt", l = {269, 272, 56, 284, 284}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC1083u<DefaultClientWebSocketSession> $sessionDeferred;
        final /* synthetic */ HttpStatement $statement;
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
        public AnonymousClass2(HttpStatement httpStatement, InterfaceC1083u<DefaultClientWebSocketSession> interfaceC1083u, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$statement = httpStatement;
            this.$sessionDeferred = interfaceC1083u;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$statement, this.$sessionDeferred, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
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
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.BuildersKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void WebSockets(HttpClientConfig<?> httpClientConfig, final InterfaceC5074l<? super WebSockets.Config, t> config) {
        kotlin.jvm.internal.p.i(httpClientConfig, "<this>");
        kotlin.jvm.internal.p.i(config, "config");
        httpClientConfig.install(WebSockets.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.WebSockets$lambda$0(config, (WebSockets.Config) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t WebSockets$lambda$0(InterfaceC5074l interfaceC5074l, WebSockets.Config install) {
        kotlin.jvm.internal.p.i(install, "$this$install");
        interfaceC5074l.invoke(install);
        return t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0307, code lost:
    
        if (r11.cleanup(r10, r3) != r4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x03a9, code lost:
    
        if (r11.cleanup(r10, r3) == r4) goto L81;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x023f A[Catch: all -> 0x0170, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0170, blocks: (B:32:0x016b, B:54:0x023f, B:75:0x035d, B:76:0x0364), top: B:86:0x016b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02c2 A[Catch: all -> 0x00ae, PHI: r0 r1 r2 r5 r6 r7 r9 r10 r11 r12 r13 r14 r15
      0x02c2: PHI (r0v45 io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) = 
      (r0v33 io.ktor.client.plugins.websocket.DefaultClientWebSocketSession)
      (r0v52 io.ktor.client.plugins.websocket.DefaultClientWebSocketSession)
     binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r1v32 int) = (r1v29 int), (r1v39 int) binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r2v20 int) = (r2v35 int), (r2v36 int) binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r5v15 int) = (r5v13 int), (r5v16 int) binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r6v15 java.util.concurrent.CancellationException) = (r6v13 java.util.concurrent.CancellationException), (r6v17 java.util.concurrent.CancellationException) binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r7v11 int) = (r7v7 int), (r7v12 int) binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r9v15 io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) = 
      (r9v11 io.ktor.client.plugins.websocket.DefaultClientWebSocketSession)
      (r9v19 io.ktor.client.plugins.websocket.DefaultClientWebSocketSession)
     binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r10v19 io.ktor.client.statement.HttpResponse) = (r10v14 io.ktor.client.statement.HttpResponse), (r10v21 io.ktor.client.statement.HttpResponse) binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r11v15 io.ktor.client.statement.HttpStatement) = (r11v10 io.ktor.client.statement.HttpStatement), (r11v17 io.ktor.client.statement.HttpStatement) binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r12v16 io.ktor.client.statement.HttpStatement) = (r12v11 io.ktor.client.statement.HttpStatement), (r12v18 io.ktor.client.statement.HttpStatement) binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r13v16 p9.p<? super io.ktor.client.plugins.websocket.DefaultClientWebSocketSession, ? super e9.c<? super Y8.t>, ? extends java.lang.Object>) = 
      (r13v11 p9.p<? super io.ktor.client.plugins.websocket.DefaultClientWebSocketSession, ? super e9.c<? super Y8.t>, ? extends java.lang.Object>)
      (r13v18 p9.p<? super io.ktor.client.plugins.websocket.DefaultClientWebSocketSession, ? super e9.c<? super Y8.t>, ? extends java.lang.Object>)
     binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r14v16 p9.l<? super io.ktor.client.request.HttpRequestBuilder, Y8.t>) = 
      (r14v11 p9.l<? super io.ktor.client.request.HttpRequestBuilder, Y8.t>)
      (r14v18 p9.l<? super io.ktor.client.request.HttpRequestBuilder, Y8.t>)
     binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE]
      0x02c2: PHI (r15v15 io.ktor.client.HttpClient) = (r15v10 io.ktor.client.HttpClient), (r15v17 io.ktor.client.HttpClient) binds: [B:60:0x02be, B:25:0x00de] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #6 {all -> 0x00ae, blocks: (B:19:0x00a7, B:73:0x0355, B:74:0x035c, B:24:0x00db, B:62:0x02c2, B:59:0x0283, B:70:0x0315), top: B:91:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x035d A[Catch: all -> 0x0170, TRY_ENTER, TryCatch #0 {all -> 0x0170, blocks: (B:32:0x016b, B:54:0x023f, B:75:0x035d, B:76:0x0364), top: B:86:0x016b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Class, java.lang.Class<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession>] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object webSocket(io.ktor.client.HttpClient r19, p9.InterfaceC5074l<? super io.ktor.client.request.HttpRequestBuilder, Y8.t> r20, p9.p<? super io.ktor.client.plugins.websocket.DefaultClientWebSocketSession, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r21, e9.InterfaceC4014c<? super Y8.t> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.BuildersKt.webSocket(io.ktor.client.HttpClient, p9.l, p9.p, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l interfaceC5074l, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
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
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.webSocket$lambda$10((HttpRequestBuilder) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        return webSocket(httpClient, httpMethod, str, num, str2, interfaceC5074l2, pVar, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocket$lambda$10(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocket$lambda$11(HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l interfaceC5074l, HttpRequestBuilder webSocket) {
        kotlin.jvm.internal.p.i(webSocket, "$this$webSocket");
        webSocket.setMethod(httpMethod);
        HttpRequestKt.url$default(webSocket, "ws", str, num, str2, null, 16, null);
        interfaceC5074l.invoke(webSocket);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocket$lambda$12(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocket$lambda$13(String str, InterfaceC5074l interfaceC5074l, HttpRequestBuilder webSocket) {
        kotlin.jvm.internal.p.i(webSocket, "$this$webSocket");
        webSocket.getUrl().setProtocol(URLProtocol.INSTANCE.getWS());
        webSocket.getUrl().setPort(UtilsKt.getPort(webSocket));
        URLParserKt.takeFrom(webSocket.getUrl(), str);
        interfaceC5074l.invoke(webSocket);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocket$lambda$8$lambda$7(URLBuilder url, URLBuilder it) {
        kotlin.jvm.internal.p.i(url, "$this$url");
        kotlin.jvm.internal.p.i(it, "it");
        url.setProtocol(URLProtocol.INSTANCE.getWS());
        return t.f7040a;
    }

    public static final Object webSocketSession(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super DefaultClientWebSocketSession> interfaceC4014c) {
        HttpClientPluginKt.plugin(httpClient, WebSockets.INSTANCE);
        InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.url(new p9.p() { // from class: io.ktor.client.plugins.websocket.i
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return BuildersKt.webSocketSession$lambda$2$lambda$1((URLBuilder) obj, (URLBuilder) obj2);
            }
        });
        interfaceC5074l.invoke(httpRequestBuilder);
        C1060i.d(httpClient, null, null, new AnonymousClass2(new HttpStatement(httpRequestBuilder, httpClient), interfaceC1083uC, null), 3, null);
        return interfaceC1083uC.a1(interfaceC4014c);
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
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
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.webSocketSession$lambda$3((HttpRequestBuilder) obj2);
                }
            };
        }
        return webSocketSession(httpClient, httpMethod, str, num, str2, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketSession$lambda$2$lambda$1(URLBuilder url, URLBuilder it) {
        kotlin.jvm.internal.p.i(url, "$this$url");
        kotlin.jvm.internal.p.i(it, "it");
        url.setProtocol(URLProtocol.INSTANCE.getWS());
        url.setPort(url.getProtocol().getDefaultPort());
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketSession$lambda$3(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketSession$lambda$4(HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l interfaceC5074l, HttpRequestBuilder webSocketSession) {
        kotlin.jvm.internal.p.i(webSocketSession, "$this$webSocketSession");
        webSocketSession.setMethod(httpMethod);
        HttpRequestKt.url$default(webSocketSession, "ws", str, num, str2, null, 16, null);
        interfaceC5074l.invoke(webSocketSession);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketSession$lambda$5(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t webSocketSession$lambda$6(String str, InterfaceC5074l interfaceC5074l, HttpRequestBuilder webSocketSession) {
        kotlin.jvm.internal.p.i(webSocketSession, "$this$webSocketSession");
        URLParserKt.takeFrom(webSocketSession.getUrl(), str);
        interfaceC5074l.invoke(webSocketSession);
        return t.f7040a;
    }

    public static final Object ws(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, p9.p<? super DefaultClientWebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWebSocket = webSocket(httpClient, httpMethod, str, num, str2, interfaceC5074l, pVar, interfaceC4014c);
        return objWebSocket == C4063a.g() ? objWebSocket : t.f7040a;
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l interfaceC5074l, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
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
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.ws$lambda$14((HttpRequestBuilder) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        return ws(httpClient, httpMethod, str, num, str2, interfaceC5074l2, pVar, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t ws$lambda$14(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t ws$lambda$15(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    public static final Object wss(HttpClient httpClient, final InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, p9.p<? super DefaultClientWebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWebSocket = webSocket(httpClient, new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.wss$lambda$16(interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, pVar, interfaceC4014c);
        return objWebSocket == C4063a.g() ? objWebSocket : t.f7040a;
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.wss$lambda$17((HttpRequestBuilder) obj2);
                }
            };
        }
        return wss(httpClient, str, interfaceC5074l, pVar, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t wss$lambda$16(InterfaceC5074l interfaceC5074l, HttpRequestBuilder webSocket) {
        kotlin.jvm.internal.p.i(webSocket, "$this$webSocket");
        webSocket.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
        webSocket.getUrl().setPort(webSocket.getUrl().getProtocol().getDefaultPort());
        interfaceC5074l.invoke(webSocket);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t wss$lambda$17(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t wss$lambda$18(String str, InterfaceC5074l interfaceC5074l, HttpRequestBuilder wss) {
        kotlin.jvm.internal.p.i(wss, "$this$wss");
        URLParserKt.takeFrom(wss.getUrl(), str);
        interfaceC5074l.invoke(wss);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t wss$lambda$19(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t wss$lambda$20(Integer num, InterfaceC5074l interfaceC5074l, HttpRequestBuilder webSocket) {
        kotlin.jvm.internal.p.i(webSocket, "$this$webSocket");
        webSocket.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
        if (num != null) {
            webSocket.getUrl().setPort(num.intValue());
        }
        interfaceC5074l.invoke(webSocket);
        return t.f7040a;
    }

    public static final Object ws(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, p9.p<? super DefaultClientWebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWebSocket = webSocket(httpClient, interfaceC5074l, pVar, interfaceC4014c);
        return objWebSocket == C4063a.g() ? objWebSocket : t.f7040a;
    }

    public static final Object wss(HttpClient httpClient, final String str, final InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, p9.p<? super DefaultClientWebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWss = wss(httpClient, new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.wss$lambda$18(str, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, pVar, interfaceC4014c);
        return objWss == C4063a.g() ? objWss : t.f7040a;
    }

    public static final Object ws(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, p9.p<? super DefaultClientWebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWebSocket = webSocket(httpClient, str, interfaceC5074l, pVar, interfaceC4014c);
        return objWebSocket == C4063a.g() ? objWebSocket : t.f7040a;
    }

    public static final Object wss(HttpClient httpClient, HttpMethod httpMethod, String str, final Integer num, String str2, final InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, p9.p<? super DefaultClientWebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWebSocket = webSocket(httpClient, httpMethod, str, num, str2, new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.wss$lambda$20(num, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, pVar, interfaceC4014c);
        return objWebSocket == C4063a.g() ? objWebSocket : t.f7040a;
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, InterfaceC5074l interfaceC5074l, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
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
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.wss$lambda$19((HttpRequestBuilder) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        return wss(httpClient, httpMethod, str, num, str2, interfaceC5074l2, pVar, interfaceC4014c);
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.n
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.webSocket$lambda$12((HttpRequestBuilder) obj2);
                }
            };
        }
        return webSocket(httpClient, str, interfaceC5074l, pVar, interfaceC4014c);
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.webSocketSession$lambda$5((HttpRequestBuilder) obj2);
                }
            };
        }
        return webSocketSession(httpClient, str, interfaceC5074l, interfaceC4014c);
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.o
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.ws$lambda$15((HttpRequestBuilder) obj2);
                }
            };
        }
        return ws(httpClient, str, interfaceC5074l, pVar, interfaceC4014c);
    }

    public static final Object webSocketSession(HttpClient httpClient, final HttpMethod httpMethod, final String str, final Integer num, final String str2, final InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super DefaultClientWebSocketSession> interfaceC4014c) {
        return webSocketSession(httpClient, new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.webSocketSession$lambda$4(httpMethod, str, num, str2, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, interfaceC4014c);
    }

    public static final Object webSocketSession(HttpClient httpClient, final String str, final InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super DefaultClientWebSocketSession> interfaceC4014c) {
        return webSocketSession(httpClient, new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.webSocketSession$lambda$6(str, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, interfaceC4014c);
    }

    public static final Object webSocket(HttpClient httpClient, final HttpMethod httpMethod, final String str, final Integer num, final String str2, final InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, p9.p<? super DefaultClientWebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWebSocket = webSocket(httpClient, new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.webSocket$lambda$11(httpMethod, str, num, str2, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, pVar, interfaceC4014c);
        return objWebSocket == C4063a.g() ? objWebSocket : t.f7040a;
    }

    public static final Object webSocket(HttpClient httpClient, final String str, final InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, p9.p<? super DefaultClientWebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWebSocket = webSocket(httpClient, HttpMethod.INSTANCE.getGet(), null, null, null, new InterfaceC5074l() { // from class: io.ktor.client.plugins.websocket.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.webSocket$lambda$13(str, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, pVar, interfaceC4014c);
        return objWebSocket == C4063a.g() ? objWebSocket : t.f7040a;
    }
}
