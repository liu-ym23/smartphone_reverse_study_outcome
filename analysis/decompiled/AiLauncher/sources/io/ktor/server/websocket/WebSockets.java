package io.ktor.server.websocket;

import Ua.InterfaceC1089x;
import Ua.M;
import Y8.t;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.application.BaseApplicationPlugin;
import io.ktor.server.application.DefaultApplicationEventsKt;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.server.websocket.WebSockets;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import io.ktor.websocket.WebSocketExtension;
import io.ktor.websocket.WebSocketExtensionsConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.JobKt__JobKt;
import p9.InterfaceC5074l;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0002('B;\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lio/ktor/server/websocket/WebSockets;", "LUa/M;", "", "pingIntervalMillis", "timeoutMillis", "maxFrameSize", "", "masking", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "extensionsConfig", "Lio/ktor/serialization/WebsocketContentConverter;", "contentConverter", "<init>", "(JJJZLio/ktor/websocket/WebSocketExtensionsConfig;Lio/ktor/serialization/WebsocketContentConverter;)V", "(JJJZ)V", "LY8/t;", "shutdown", "()V", "J", "getPingIntervalMillis", "()J", "getTimeoutMillis", "getMaxFrameSize", "Z", "getMasking", "()Z", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "getExtensionsConfig", "()Lio/ktor/websocket/WebSocketExtensionsConfig;", "Lio/ktor/serialization/WebsocketContentConverter;", "getContentConverter", "()Lio/ktor/serialization/WebsocketContentConverter;", "LUa/x;", "parent", "LUa/x;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "coroutineContext", "Plugin", "WebSocketOptions", "ktor-server-websockets"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSockets implements M {
    private static final AttributeKey<List<WebSocketExtension<?>>> EXTENSIONS_KEY;

    /* renamed from: Plugin, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final AttributeKey<WebSockets> key;
    private final WebsocketContentConverter contentConverter;
    private final WebSocketExtensionsConfig extensionsConfig;
    private final boolean masking;
    private final long maxFrameSize;
    private final InterfaceC1089x parent;
    private final long pingIntervalMillis;
    private final long timeoutMillis;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0014\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00120\r8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lio/ktor/server/websocket/WebSockets$Plugin;", "Lio/ktor/server/application/BaseApplicationPlugin;", "Lio/ktor/server/application/Application;", "Lio/ktor/server/websocket/WebSockets$WebSocketOptions;", "Lio/ktor/server/websocket/WebSockets;", "<init>", "()V", "pipeline", "Lkotlin/Function1;", "LY8/t;", "configure", W4.b.STEP_INSTALL, "(Lio/ktor/server/application/Application;Lp9/l;)Lio/ktor/server/websocket/WebSockets;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "", "Lio/ktor/websocket/WebSocketExtension;", "EXTENSIONS_KEY", "getEXTENSIONS_KEY", "ktor-server-websockets"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.websocket.WebSockets$Plugin, reason: from kotlin metadata */
    public static final class Companion implements BaseApplicationPlugin<Application, WebSocketOptions, WebSockets> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final t install$lambda$1$lambda$0(WebSockets webSockets, ApplicationEnvironment it) {
            p.i(it, "it");
            WebSocketsKt.getLOGGER().trace("Shutdown WebSockets due to application stop");
            webSockets.shutdown();
            return t.f7040a;
        }

        public final AttributeKey<List<WebSocketExtension<?>>> getEXTENSIONS_KEY() {
            return WebSockets.EXTENSIONS_KEY;
        }

        @Override // io.ktor.server.application.Plugin
        public AttributeKey<WebSockets> getKey() {
            return WebSockets.key;
        }

        @Override // io.ktor.server.application.Plugin
        public /* bridge */ /* synthetic */ Object install(Pipeline pipeline, InterfaceC5074l interfaceC5074l) {
            return install((Application) pipeline, (InterfaceC5074l<? super WebSocketOptions, t>) interfaceC5074l);
        }

        private Companion() {
        }

        public WebSockets install(Application pipeline, InterfaceC5074l<? super WebSocketOptions, t> configure) {
            p.i(pipeline, "pipeline");
            p.i(configure, "configure");
            WebSocketOptions webSocketOptions = new WebSocketOptions();
            configure.invoke(webSocketOptions);
            final WebSockets webSockets = new WebSockets(webSocketOptions.getPingPeriodMillis(), webSocketOptions.getTimeoutMillis(), webSocketOptions.getMaxFrameSize(), webSocketOptions.getMasking(), webSocketOptions.getExtensionsConfig(), webSocketOptions.getContentConverter(), null);
            pipeline.getMonitor().subscribe(DefaultApplicationEventsKt.getApplicationStopPreparing(), new InterfaceC5074l() { // from class: io.ktor.server.websocket.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return WebSockets.Companion.install$lambda$1$lambda$0(webSockets, (ApplicationEnvironment) obj);
                }
            });
            pipeline.getSendPipeline().intercept(ApplicationSendPipeline.INSTANCE.getTransform(), new WebSockets$Plugin$install$1$2(null));
            return webSockets;
        }
    }

    @KtorDsl
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lio/ktor/server/websocket/WebSockets$WebSocketOptions;", "", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "LY8/t;", "block", "extensions", "(Lp9/l;)V", "extensionsConfig", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "getExtensionsConfig$ktor_server_websockets", "()Lio/ktor/websocket/WebSocketExtensionsConfig;", "", "pingPeriodMillis", "J", "getPingPeriodMillis", "()J", "setPingPeriodMillis", "(J)V", "timeoutMillis", "getTimeoutMillis", "setTimeoutMillis", "maxFrameSize", "getMaxFrameSize", "setMaxFrameSize", "", "masking", "Z", "getMasking", "()Z", "setMasking", "(Z)V", "Lio/ktor/serialization/WebsocketContentConverter;", "contentConverter", "Lio/ktor/serialization/WebsocketContentConverter;", "getContentConverter", "()Lio/ktor/serialization/WebsocketContentConverter;", "setContentConverter", "(Lio/ktor/serialization/WebsocketContentConverter;)V", "ktor-server-websockets"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WebSocketOptions {
        private WebsocketContentConverter contentConverter;
        private boolean masking;
        private long pingPeriodMillis;
        private final WebSocketExtensionsConfig extensionsConfig = new WebSocketExtensionsConfig();
        private long timeoutMillis = 15000;
        private long maxFrameSize = Long.MAX_VALUE;

        public final void extensions(InterfaceC5074l<? super WebSocketExtensionsConfig, t> block) {
            p.i(block, "block");
            block.invoke(this.extensionsConfig);
        }

        public final WebsocketContentConverter getContentConverter() {
            return this.contentConverter;
        }

        /* renamed from: getExtensionsConfig$ktor_server_websockets, reason: from getter */
        public final WebSocketExtensionsConfig getExtensionsConfig() {
            return this.extensionsConfig;
        }

        public final boolean getMasking() {
            return this.masking;
        }

        public final long getMaxFrameSize() {
            return this.maxFrameSize;
        }

        public final long getPingPeriodMillis() {
            return this.pingPeriodMillis;
        }

        public final long getTimeoutMillis() {
            return this.timeoutMillis;
        }

        public final void setContentConverter(WebsocketContentConverter websocketContentConverter) {
            this.contentConverter = websocketContentConverter;
        }

        public final void setMasking(boolean z10) {
            this.masking = z10;
        }

        public final void setMaxFrameSize(long j10) {
            this.maxFrameSize = j10;
        }

        public final void setPingPeriodMillis(long j10) {
            this.pingPeriodMillis = j10;
        }

        public final void setTimeoutMillis(long j10) {
            this.timeoutMillis = j10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5755n interfaceC5755nN = null;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(WebSockets.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(WebSockets.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        key = new AttributeKey<>("WebSockets", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(List.class);
        try {
            C5757p.Companion companion = C5757p.INSTANCE;
            interfaceC5755nN = kotlin.jvm.internal.t.n(List.class, companion.d(kotlin.jvm.internal.t.n(WebSocketExtension.class, companion.c())));
        } catch (Throwable unused2) {
        }
        EXTENSIONS_KEY = new AttributeKey<>("WebSocket extensions", new TypeInfo(interfaceC5745dB2, interfaceC5755nN));
    }

    public /* synthetic */ WebSockets(long j10, long j11, long j12, boolean z10, WebSocketExtensionsConfig webSocketExtensionsConfig, WebsocketContentConverter websocketContentConverter, i iVar) {
        this(j10, j11, j12, z10, webSocketExtensionsConfig, websocketContentConverter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shutdown() {
        this.parent.complete();
    }

    public final WebsocketContentConverter getContentConverter() {
        return this.contentConverter;
    }

    @Override // Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.parent;
    }

    public final WebSocketExtensionsConfig getExtensionsConfig() {
        return this.extensionsConfig;
    }

    public final boolean getMasking() {
        return this.masking;
    }

    public final long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public final long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    private WebSockets(long j10, long j11, long j12, boolean z10, WebSocketExtensionsConfig webSocketExtensionsConfig, WebsocketContentConverter websocketContentConverter) {
        this.pingIntervalMillis = j10;
        this.timeoutMillis = j11;
        this.maxFrameSize = j12;
        this.masking = z10;
        this.extensionsConfig = webSocketExtensionsConfig;
        this.contentConverter = websocketContentConverter;
        this.parent = JobKt__JobKt.b(null, 1, null);
        if (j10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (j11 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (j12 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public WebSockets(long j10, long j11, long j12, boolean z10) {
        this(j10, j11, j12, z10, new WebSocketExtensionsConfig(), null);
    }
}
