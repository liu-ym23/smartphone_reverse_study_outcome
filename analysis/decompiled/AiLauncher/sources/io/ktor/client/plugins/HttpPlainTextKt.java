package io.ktor.client.plugins;

import La.C0953c;
import Z8.T;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;
import r9.C5227b;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpPlainTextConfig;", "LY8/t;", "block", "Charsets", "(Lio/ktor/client/HttpClientConfig;Lp9/l;)V", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpPlainText", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpPlainText", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpPlainTextKt {
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpPlainText");
    private static final ClientPlugin<HttpPlainTextConfig> HttpPlainText = CreatePluginUtilsKt.createClientPlugin("HttpPlainText", HttpPlainTextKt$HttpPlainText$1.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.client.plugins.n
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return HttpPlainTextKt.HttpPlainText$lambda$6((ClientPluginBuilder) obj);
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Charsets(HttpClientConfig<?> httpClientConfig, InterfaceC5074l<? super HttpPlainTextConfig, Y8.t> block) {
        kotlin.jvm.internal.p.i(httpClientConfig, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        httpClientConfig.install(HttpPlainText, block);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t HttpPlainText$lambda$6(ClientPluginBuilder createClientPlugin) {
        kotlin.jvm.internal.p.i(createClientPlugin, "$this$createClientPlugin");
        List<Pair> listC1 = Z8.F.c1(T.E(((HttpPlainTextConfig) createClientPlugin.getPluginConfig()).getCharsetQuality$ktor_client_core()), new Comparator() { // from class: io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$lambda$6$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b9.b.d((Float) ((Pair) t11).f(), (Float) ((Pair) t10).f());
            }
        });
        Charset responseCharsetFallback = ((HttpPlainTextConfig) createClientPlugin.getPluginConfig()).getResponseCharsetFallback();
        Set<Charset> charsets$ktor_client_core = ((HttpPlainTextConfig) createClientPlugin.getPluginConfig()).getCharsets$ktor_client_core();
        ArrayList arrayList = new ArrayList();
        for (Object obj : charsets$ktor_client_core) {
            if (!((HttpPlainTextConfig) createClientPlugin.getPluginConfig()).getCharsetQuality$ktor_client_core().containsKey((Charset) obj)) {
                arrayList.add(obj);
            }
        }
        List<Charset> listC12 = Z8.F.c1(arrayList, new Comparator() { // from class: io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$lambda$6$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b9.b.d(CharsetJVMKt.getName((Charset) t10), CharsetJVMKt.getName((Charset) t11));
            }
        });
        StringBuilder sb2 = new StringBuilder();
        for (Charset charset : listC12) {
            if (sb2.length() > 0) {
                sb2.append(Const.STR_MART_COMMA);
            }
            sb2.append(CharsetJVMKt.getName(charset));
        }
        for (Pair pair : listC1) {
            Charset charset2 = (Charset) pair.a();
            float fFloatValue = ((Number) pair.b()).floatValue();
            if (sb2.length() > 0) {
                sb2.append(Const.STR_MART_COMMA);
            }
            double d10 = fFloatValue;
            if (0.0d > d10 || d10 > 1.0d) {
                throw new IllegalStateException("Check failed.");
            }
            sb2.append(CharsetJVMKt.getName(charset2) + ";q=" + (C5227b.b(100 * fFloatValue) / 100.0d));
        }
        if (sb2.length() == 0) {
            sb2.append(CharsetJVMKt.getName(responseCharsetFallback));
        }
        String string = sb2.toString();
        Charset sendCharset = ((HttpPlainTextConfig) createClientPlugin.getPluginConfig()).getSendCharset();
        if (sendCharset == null && (sendCharset = (Charset) Z8.F.s0(listC12)) == null) {
            Pair pair2 = (Pair) Z8.F.s0(listC1);
            sendCharset = pair2 != null ? (Charset) pair2.e() : null;
            if (sendCharset == null) {
                sendCharset = C0953c.UTF_8;
            }
        }
        createClientPlugin.on(RenderRequestHook.INSTANCE, new HttpPlainTextKt$HttpPlainText$2$1(string, sendCharset, null));
        createClientPlugin.transformResponseBody(new HttpPlainTextKt$HttpPlainText$2$2(responseCharsetFallback, null));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HttpPlainText$lambda$6$addCharsetHeaders(String str, HttpRequestBuilder httpRequestBuilder) {
        HeadersBuilder headers = httpRequestBuilder.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (headers.get(httpHeaders.getAcceptCharset()) != null) {
            return;
        }
        LOGGER.trace("Adding Accept-Charset=" + str + " to " + httpRequestBuilder.getUrl());
        httpRequestBuilder.getHeaders().set(httpHeaders.getAcceptCharset(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String HttpPlainText$lambda$6$read(Charset charset, HttpClientCall httpClientCall, fb.v vVar) {
        Charset charset2 = HttpMessagePropertiesKt.charset(httpClientCall.getResponse());
        if (charset2 != null) {
            charset = charset2;
        }
        LOGGER.trace("Reading response body for " + httpClientCall.getRequest().getUrl() + " as String with charset " + charset);
        return StringsKt.readText$default(vVar, charset, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OutgoingContent HttpPlainText$lambda$6$wrapContent(Charset charset, HttpRequestBuilder httpRequestBuilder, String str, ContentType contentType) {
        Charset charset2;
        ContentType plain = contentType == null ? ContentType.Text.INSTANCE.getPlain() : contentType;
        if (contentType != null && (charset2 = ContentTypesKt.charset(contentType)) != null) {
            charset = charset2;
        }
        LOGGER.trace("Sending request body to " + httpRequestBuilder.getUrl() + " as text/plain with charset " + charset);
        return new TextContent(str, ContentTypesKt.withCharset(plain, charset), null, 4, null);
    }

    public static final ClientPlugin<HttpPlainTextConfig> getHttpPlainText() {
        return HttpPlainText;
    }
}
