package io.ktor.client.plugins;

import Z8.Y;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0018\u0010\n\u001a\u00060\bj\u0002`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/ktor/http/HttpStatusCode;", "", "isRedirect", "(Lio/ktor/http/HttpStatusCode;)Z", "", "Lio/ktor/http/HttpMethod;", "ALLOWED_FOR_REDIRECT", "Ljava/util/Set;", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "HttpResponseRedirectEvent", "Lio/ktor/events/EventDefinition;", "getHttpResponseRedirectEvent", "()Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/HttpRedirectConfig;", "HttpRedirect", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRedirect", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRedirect$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpRedirectKt {
    private static final Set<HttpMethod> ALLOWED_FOR_REDIRECT;
    private static final ClientPlugin<HttpRedirectConfig> HttpRedirect;
    private static final EventDefinition<HttpResponse> HttpResponseRedirectEvent;
    private static final vc.c LOGGER;

    static {
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        ALLOWED_FOR_REDIRECT = Y.j(companion.getGet(), companion.getHead());
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRedirect");
        HttpResponseRedirectEvent = new EventDefinition<>();
        HttpRedirect = CreatePluginUtilsKt.createClientPlugin("HttpRedirect", HttpRedirectKt$HttpRedirect$1.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.client.plugins.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpRedirectKt.HttpRedirect$lambda$1((ClientPluginBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t HttpRedirect$lambda$1(ClientPluginBuilder createClientPlugin) {
        kotlin.jvm.internal.p.i(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.on(Send.INSTANCE, new HttpRedirectKt$HttpRedirect$2$1(((HttpRedirectConfig) createClientPlugin.getPluginConfig()).getCheckHttpMethod(), ((HttpRedirectConfig) createClientPlugin.getPluginConfig()).getAllowHttpsDowngrade(), createClientPlugin, null));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r14v4, types: [T, io.ktor.client.request.HttpRequestBuilder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0211 -> B:38:0x0217). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object HttpRedirect$lambda$1$handleCall(io.ktor.client.plugins.api.Send.Sender r17, io.ktor.client.request.HttpRequestBuilder r18, io.ktor.client.call.HttpClientCall r19, boolean r20, io.ktor.client.HttpClient r21, e9.InterfaceC4014c<? super io.ktor.client.call.HttpClientCall> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRedirectKt.HttpRedirect$lambda$1$handleCall(io.ktor.client.plugins.api.Send$Sender, io.ktor.client.request.HttpRequestBuilder, io.ktor.client.call.HttpClientCall, boolean, io.ktor.client.HttpClient, e9.c):java.lang.Object");
    }

    public static final ClientPlugin<HttpRedirectConfig> getHttpRedirect() {
        return HttpRedirect;
    }

    public static /* synthetic */ void getHttpRedirect$annotations() {
    }

    public static final EventDefinition<HttpResponse> getHttpResponseRedirectEvent() {
        return HttpResponseRedirectEvent;
    }

    private static final boolean isRedirect(HttpStatusCode httpStatusCode) {
        int value = httpStatusCode.getValue();
        HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
        return value == companion.getMovedPermanently().getValue() || value == companion.getFound().getValue() || value == companion.getTemporaryRedirect().getValue() || value == companion.getPermanentRedirect().getValue() || value == companion.getSeeOther().getValue();
    }
}
