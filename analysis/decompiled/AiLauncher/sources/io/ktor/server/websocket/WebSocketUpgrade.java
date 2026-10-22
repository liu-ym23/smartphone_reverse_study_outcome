package io.ktor.server.websocket;

import Ua.C1060i;
import Ua.CoroutineName;
import Ua.M;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.websocket.UtilsKt;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.ApplicationPluginKt;
import io.ktor.server.request.ApplicationRequest;
import io.ktor.server.request.ApplicationRequestPropertiesKt;
import io.ktor.server.websocket.WebSockets;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.websocket.RawWebSocketJvmKt;
import io.ktor.websocket.WebSocketExtension;
import io.ktor.websocket.WebSocketExtensionHeader;
import io.ktor.websocket.WebSocketExtensionHeaderKt;
import io.ktor.websocket.WebSocketSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.g;
import p9.p;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u00013BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0004\b\u000e\u0010\u000fBA\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0004\b\u000e\u0010\u0010J\u001d\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012*\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J0\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010&R3\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010#R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010/\u001a\u00020.8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lio/ktor/server/websocket/WebSocketUpgrade;", "Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;", "Lio/ktor/server/application/ApplicationCall;", "call", "", "protocol", "", "installExtensions", "Lkotlin/Function2;", "Lio/ktor/websocket/WebSocketSession;", "Le9/c;", "LY8/t;", "", "handle", "<init>", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;ZLp9/p;)V", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;Lp9/p;)V", "Lio/ktor/http/HeadersBuilder;", "", "Lio/ktor/websocket/WebSocketExtension;", "writeExtensions", "(Lio/ktor/http/HeadersBuilder;)Ljava/util/List;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Lkotlin/coroutines/d;", "engineContext", "userContext", "Lkotlinx/coroutines/g;", "upgrade", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/d;Lkotlin/coroutines/d;Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/application/ApplicationCall;", "getCall", "()Lio/ktor/server/application/ApplicationCall;", "Ljava/lang/String;", "getProtocol", "()Ljava/lang/String;", "Z", "Lp9/p;", "getHandle", "()Lp9/p;", "key", "Lio/ktor/server/websocket/WebSockets;", "plugin", "Lio/ktor/server/websocket/WebSockets;", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "Companion", "ktor-server-websockets"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketUpgrade extends OutgoingContent.ProtocolUpgrade {
    private static final CoroutineName WebSocketHandlerCoroutineName = new CoroutineName("raw-ws-handler");
    private final ApplicationCall call;
    private final p<WebSocketSession, InterfaceC4014c<? super t>, Object> handle;
    private final Headers headers;
    private final boolean installExtensions;
    private final String key;
    private final WebSockets plugin;
    private final String protocol;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.websocket.WebSocketUpgrade$upgrade$2", f = "WebSocketUpgrade.kt", l = {103, 104}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.websocket.WebSocketUpgrade$upgrade$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ WebSocketSession $webSocket;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WebSocketSession webSocketSession, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$webSocket = webSocketSession;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return WebSocketUpgrade.this.new AnonymousClass2(this.$webSocket, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
        
            if (r6.flush(r5) == r0) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L13
                goto L40
            L13:
                r6 = move-exception
                goto L46
            L15:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1d:
                kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L13
                goto L35
            L21:
                kotlin.C4849c.b(r6)
                io.ktor.server.websocket.WebSocketUpgrade r6 = io.ktor.server.websocket.WebSocketUpgrade.this     // Catch: java.lang.Throwable -> L13
                p9.p r6 = r6.getHandle()     // Catch: java.lang.Throwable -> L13
                io.ktor.websocket.WebSocketSession r1 = r5.$webSocket     // Catch: java.lang.Throwable -> L13
                r5.label = r3     // Catch: java.lang.Throwable -> L13
                java.lang.Object r6 = r6.invoke(r1, r5)     // Catch: java.lang.Throwable -> L13
                if (r6 != r0) goto L35
                goto L3f
            L35:
                io.ktor.websocket.WebSocketSession r6 = r5.$webSocket     // Catch: java.lang.Throwable -> L13
                r5.label = r2     // Catch: java.lang.Throwable -> L13
                java.lang.Object r6 = r6.flush(r5)     // Catch: java.lang.Throwable -> L13
                if (r6 != r0) goto L40
            L3f:
                return r0
            L40:
                io.ktor.websocket.WebSocketSession r5 = r5.$webSocket
                kotlinx.coroutines.d.e(r5, r4, r3, r4)
                goto L4e
            L46:
                io.ktor.websocket.WebSocketSession r0 = r5.$webSocket     // Catch: java.lang.Throwable -> L51
                java.lang.String r1 = "WebSocket is cancelled"
                kotlinx.coroutines.d.c(r0, r1, r6)     // Catch: java.lang.Throwable -> L51
                goto L40
            L4e:
                Y8.t r5 = Y8.t.f7040a
                return r5
            L51:
                r6 = move-exception
                io.ktor.websocket.WebSocketSession r5 = r5.$webSocket
                kotlinx.coroutines.d.e(r5, r4, r3, r4)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.websocket.WebSocketUpgrade.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public /* synthetic */ WebSocketUpgrade(ApplicationCall applicationCall, String str, boolean z10, p pVar, int i10, i iVar) {
        this(applicationCall, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? false : z10, pVar);
    }

    private final List<WebSocketExtension<?>> writeExtensions(HeadersBuilder headersBuilder) {
        List<WebSocketExtensionHeader> listM;
        if (!this.installExtensions) {
            return C1173v.m();
        }
        String strHeader = ApplicationRequestPropertiesKt.header(this.call.getRequest(), HttpHeaders.INSTANCE.getSecWebSocketExtensions());
        if (strHeader == null || (listM = WebSocketExtensionHeaderKt.parseWebSocketExtensions(strHeader)) == null) {
            listM = C1173v.m();
        }
        List<WebSocketExtension<?>> listBuild = this.plugin.getExtensionsConfig().build();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = listBuild.iterator();
        while (it.hasNext()) {
            WebSocketExtension webSocketExtension = (WebSocketExtension) it.next();
            List<WebSocketExtensionHeader> listServerNegotiation = webSocketExtension.serverNegotiation(listM);
            if (!listServerNegotiation.isEmpty()) {
                arrayList2.add(webSocketExtension);
                arrayList.addAll(listServerNegotiation);
            }
        }
        if (!arrayList.isEmpty()) {
            headersBuilder.append(HttpHeaders.INSTANCE.getSecWebSocketExtensions(), F.A0(arrayList, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null));
        }
        return arrayList2;
    }

    public final ApplicationCall getCall() {
        return this.call;
    }

    public final p<WebSocketSession, InterfaceC4014c<? super t>, Object> getHandle() {
        return this.handle;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return this.headers;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    @Override // io.ktor.http.content.OutgoingContent.ProtocolUpgrade
    public Object upgrade(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, kotlin.coroutines.d dVar, kotlin.coroutines.d dVar2, InterfaceC4014c<? super g> interfaceC4014c) {
        long maxFrameSize = this.plugin.getMaxFrameSize();
        boolean masking = this.plugin.getMasking();
        kotlin.coroutines.d context = interfaceC4014c.getContext();
        g.Companion companion = g.INSTANCE;
        kotlin.coroutines.d dVar3 = (g) context.get(companion);
        if (dVar3 == null) {
            dVar3 = EmptyCoroutineContext.f34779a;
        }
        WebSocketSession webSocketSessionRawWebSocket = RawWebSocketJvmKt.RawWebSocket(byteReadChannel, byteWriteChannel, maxFrameSize, masking, dVar.plus(dVar3));
        C1060i.d(webSocketSessionRawWebSocket, WebSocketHandlerCoroutineName, null, new AnonymousClass2(webSocketSessionRawWebSocket, null), 2, null);
        d.b bVar = webSocketSessionRawWebSocket.getCoroutineContext().get(companion);
        kotlin.jvm.internal.p.f(bVar);
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebSocketUpgrade(ApplicationCall call, String str, boolean z10, p<? super WebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> handle) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(handle, "handle");
        this.call = call;
        this.protocol = str;
        this.installExtensions = z10;
        this.handle = handle;
        ApplicationRequest request = call.getRequest();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        String strHeader = ApplicationRequestPropertiesKt.header(request, httpHeaders.getSecWebSocketKey());
        this.key = strHeader;
        Application application = call.getApplication();
        WebSockets.Companion companion = WebSockets.INSTANCE;
        this.plugin = (WebSockets) ApplicationPluginKt.plugin(application, companion);
        Headers.Companion companion2 = Headers.INSTANCE;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.append(httpHeaders.getUpgrade(), "websocket");
        headersBuilder.append(httpHeaders.getConnection(), "Upgrade");
        if (strHeader != null) {
            headersBuilder.append(httpHeaders.getSecWebSocketAccept(), UtilsKt.websocketServerAccept(strHeader));
        }
        if (str != null) {
            headersBuilder.append(httpHeaders.getSecWebSocketProtocol(), str);
        }
        call.getAttributes().put(companion.getEXTENSIONS_KEY(), writeExtensions(headersBuilder));
        this.headers = headersBuilder.build();
    }

    public /* synthetic */ WebSocketUpgrade(ApplicationCall applicationCall, String str, p pVar, int i10, i iVar) {
        this(applicationCall, (i10 & 2) != 0 ? null : str, pVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebSocketUpgrade(ApplicationCall call, String str, p<? super WebSocketSession, ? super InterfaceC4014c<? super t>, ? extends Object> handle) {
        this(call, str, false, handle);
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(handle, "handle");
    }
}
