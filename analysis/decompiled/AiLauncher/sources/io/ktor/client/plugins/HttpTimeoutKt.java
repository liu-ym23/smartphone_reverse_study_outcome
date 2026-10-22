package io.ktor.client.plugins;

import Ua.C1060i;
import Ua.CoroutineName;
import Ua.M;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.network.sockets.TimeoutExceptionsKt;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.plugins.sse.SSEClientContent;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.http.URLProtocolKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.utils.io.InternalAPI;
import java.net.SocketTimeoutException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a%\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a%\u0010\u000b\u001a\u00020\u0005*\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0015\u001a%\u0010\u0018\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0002\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a'\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0081\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\"\u0018\u0010%\u001a\u00060#j\u0002`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&\"\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u001e\u00101\u001a\u00020,*\u00020\u00018BX\u0082\u0004¢\u0006\f\u0012\u0004\b/\u00100\u001a\u0004\b-\u0010.\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00062"}, d2 = {"LUa/M;", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "", "requestTimeout", "LY8/t;", "applyRequestTimeout", "(LUa/M;Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Long;)V", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "block", "timeout", "(Lio/ktor/client/request/HttpRequestBuilder;Lp9/l;)V", "Lio/ktor/client/request/HttpRequestData;", "", "cause", "Lio/ktor/client/network/sockets/ConnectTimeoutException;", "ConnectTimeoutException", "(Lio/ktor/client/request/HttpRequestData;Ljava/lang/Throwable;)Lio/ktor/client/network/sockets/ConnectTimeoutException;", "", "url", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Throwable;)Lio/ktor/client/network/sockets/ConnectTimeoutException;", "Ljava/net/SocketTimeoutException;", "Lio/ktor/client/network/sockets/SocketTimeoutException;", "SocketTimeoutException", "(Lio/ktor/client/request/HttpRequestData;Ljava/lang/Throwable;)Ljava/net/SocketTimeoutException;", "", "convertLongTimeoutToIntWithInfiniteAsZero", "(J)I", "convertLongTimeoutToLongWithInfiniteAsZero", "(J)J", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "unwrapRequestTimeoutException", "(Lp9/a;)Ljava/lang/Object;", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpTimeout", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpTimeout", "()Lio/ktor/client/plugins/api/ClientPlugin;", "", "getSupportsRequestTimeout", "(Lio/ktor/client/request/HttpRequestBuilder;)Z", "getSupportsRequestTimeout$annotations", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "supportsRequestTimeout", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpTimeoutKt {
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpTimeout");
    private static final ClientPlugin<HttpTimeoutConfig> HttpTimeout = CreatePluginUtilsKt.createClientPlugin("HttpTimeout", HttpTimeoutKt$HttpTimeout$2.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.client.plugins.C
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return HttpTimeoutKt.HttpTimeout$lambda$1((ClientPluginBuilder) obj);
        }
    });

    public static final ConnectTimeoutException ConnectTimeoutException(HttpRequestData request, Throwable th) {
        Object obj;
        kotlin.jvm.internal.p.i(request, "request");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connect timeout has expired [url=");
        sb2.append(request.getUrl());
        sb2.append(", connect_timeout=");
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) request.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
        if (httpTimeoutConfig == null || (obj = httpTimeoutConfig.get_connectTimeoutMillis()) == null) {
            obj = "unknown";
        }
        sb2.append(obj);
        sb2.append(" ms]");
        return new ConnectTimeoutException(sb2.toString(), th);
    }

    public static /* synthetic */ ConnectTimeoutException ConnectTimeoutException$default(HttpRequestData httpRequestData, Throwable th, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th = null;
        }
        return ConnectTimeoutException(httpRequestData, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t HttpTimeout$lambda$1(ClientPluginBuilder createClientPlugin) {
        kotlin.jvm.internal.p.i(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.on(Send.INSTANCE, new HttpTimeoutKt$HttpTimeout$3$1(((HttpTimeoutConfig) createClientPlugin.getPluginConfig()).get_requestTimeoutMillis(), ((HttpTimeoutConfig) createClientPlugin.getPluginConfig()).get_connectTimeoutMillis(), ((HttpTimeoutConfig) createClientPlugin.getPluginConfig()).get_socketTimeoutMillis(), null));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpTimeout$lambda$1$hasNotNullTimeouts(Long l10, Long l11, Long l12, boolean z10) {
        return ((!z10 || l10 == null) && l11 == null && l12 == null) ? false : true;
    }

    public static final SocketTimeoutException SocketTimeoutException(HttpRequestData request, Throwable th) {
        Object obj;
        kotlin.jvm.internal.p.i(request, "request");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Socket timeout has expired [url=");
        sb2.append(request.getUrl());
        sb2.append(", socket_timeout=");
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) request.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
        if (httpTimeoutConfig == null || (obj = httpTimeoutConfig.get_socketTimeoutMillis()) == null) {
            obj = "unknown";
        }
        sb2.append(obj);
        sb2.append("] ms");
        return TimeoutExceptionsKt.SocketTimeoutException(sb2.toString(), th);
    }

    public static /* synthetic */ SocketTimeoutException SocketTimeoutException$default(HttpRequestData httpRequestData, Throwable th, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th = null;
        }
        return SocketTimeoutException(httpRequestData, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyRequestTimeout(M m10, HttpRequestBuilder httpRequestBuilder, Long l10) {
        if (l10 == null || l10.longValue() == Long.MAX_VALUE) {
            return;
        }
        final kotlinx.coroutines.g gVarD = C1060i.d(m10, new CoroutineName("request-timeout"), null, new HttpTimeoutKt$applyRequestTimeout$killer$1(l10, httpRequestBuilder, httpRequestBuilder.getExecutionContext(), null), 2, null);
        httpRequestBuilder.getExecutionContext().J(new InterfaceC5074l() { // from class: io.ktor.client.plugins.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpTimeoutKt.applyRequestTimeout$lambda$2(gVarD, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applyRequestTimeout$lambda$2(kotlinx.coroutines.g gVar, Throwable th) {
        kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        return Y8.t.f7040a;
    }

    @InternalAPI
    public static final int convertLongTimeoutToIntWithInfiniteAsZero(long j10) {
        if (j10 == Long.MAX_VALUE) {
            return 0;
        }
        if (j10 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j10;
    }

    @InternalAPI
    public static final long convertLongTimeoutToLongWithInfiniteAsZero(long j10) {
        if (j10 == Long.MAX_VALUE) {
            return 0L;
        }
        return j10;
    }

    public static final ClientPlugin<HttpTimeoutConfig> getHttpTimeout() {
        return HttpTimeout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getSupportsRequestTimeout(HttpRequestBuilder httpRequestBuilder) {
        return (URLProtocolKt.isWebsocket(httpRequestBuilder.getUrl().getProtocol()) || (httpRequestBuilder.getBody() instanceof ClientUpgradeContent) || (httpRequestBuilder.getBody() instanceof SSEClientContent)) ? false : true;
    }

    private static /* synthetic */ void getSupportsRequestTimeout$annotations(HttpRequestBuilder httpRequestBuilder) {
    }

    public static final void timeout(HttpRequestBuilder httpRequestBuilder, InterfaceC5074l<? super HttpTimeoutConfig, Y8.t> block) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        HttpTimeoutCapability httpTimeoutCapability = HttpTimeoutCapability.INSTANCE;
        HttpTimeoutConfig httpTimeoutConfig = new HttpTimeoutConfig(null, null, null, 7, null);
        block.invoke(httpTimeoutConfig);
        httpRequestBuilder.setCapability(httpTimeoutCapability, httpTimeoutConfig);
    }

    public static final <T> T unwrapRequestTimeoutException(InterfaceC5063a<? extends T> block) throws Throwable {
        kotlin.jvm.internal.p.i(block, "block");
        try {
            return block.invoke();
        } catch (CancellationException e10) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e10);
        }
    }

    public static /* synthetic */ ConnectTimeoutException ConnectTimeoutException$default(String str, Long l10, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        return ConnectTimeoutException(str, l10, th);
    }

    public static final ConnectTimeoutException ConnectTimeoutException(String url, Long l10, Throwable th) {
        kotlin.jvm.internal.p.i(url, "url");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connect timeout has expired [url=");
        sb2.append(url);
        sb2.append(", connect_timeout=");
        Object obj = l10;
        if (l10 == null) {
            obj = "unknown";
        }
        sb2.append(obj);
        sb2.append(" ms]");
        return new ConnectTimeoutException(sb2.toString(), th);
    }
}
