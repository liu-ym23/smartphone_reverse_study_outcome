package io.ktor.client.plugins;

import Z8.C1172u;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.UnixSocketCapability;
import io.ktor.client.request.UnixSocketSettings;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u001d\b\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest;", "", "Lkotlin/Function1;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "LY8/t;", "block", "<init>", "(Lp9/l;)V", "Lp9/l;", "Plugin", "DefaultRequestBuilder", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultRequest {

    /* renamed from: Plugin, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final AttributeKey<DefaultRequest> key;
    private final InterfaceC5074l<DefaultRequestBuilder, Y8.t> block;

    @KtorDsl
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJS\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\u0010J\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\b\u0010\u0012J!\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0014\u0010\tJ-\u0010\u001a\u001a\u00020\u0006\"\b\b\u0000\u0010\u0016*\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u0012R\u001a\u0010\u001e\u001a\u00020\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R$\u0010\f\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0012R$\u0010\u000e\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "Lio/ktor/http/HttpMessageBuilder;", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/http/URLBuilder;", "LY8/t;", "block", "url", "(Lp9/l;)V", "", "scheme", "host", "", "port", "path", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/l;)V", "urlString", "(Ljava/lang/String;)V", "Lio/ktor/util/Attributes;", "setAttributes", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/engine/HttpClientEngineCapability;", "key", "capability", "setCapability", "(Lio/ktor/client/engine/HttpClientEngineCapability;Ljava/lang/Object;)V", "unixSocket", "Lio/ktor/http/HeadersBuilder;", "headers", "Lio/ktor/http/HeadersBuilder;", "getHeaders", "()Lio/ktor/http/HeadersBuilder;", "Lio/ktor/http/URLBuilder;", "getUrl", "()Lio/ktor/http/URLBuilder;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", UxipConstants.f30680s, "getHost", "()Ljava/lang/String;", "setHost", "getPort", "()I", "setPort", "(I)V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultRequestBuilder implements HttpMessageBuilder {
        private final HeadersBuilder headers = new HeadersBuilder(0, 1, null);
        private final URLBuilder url = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
        private final Attributes attributes = AttributesJvmKt.Attributes(true);

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map setCapability$lambda$1() {
            return new LinkedHashMap();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void url$default(DefaultRequestBuilder defaultRequestBuilder, String str, String str2, Integer num, String str3, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = null;
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            if ((i10 & 4) != 0) {
                num = null;
            }
            if ((i10 & 8) != 0) {
                str3 = null;
            }
            if ((i10 & 16) != 0) {
                interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.d
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj2) {
                        return DefaultRequest.DefaultRequestBuilder.url$lambda$0((URLBuilder) obj2);
                    }
                };
            }
            defaultRequestBuilder.url(str, str2, num, str3, interfaceC5074l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Y8.t url$lambda$0(URLBuilder uRLBuilder) {
            kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
            return Y8.t.f7040a;
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        @Override // io.ktor.http.HttpMessageBuilder
        public HeadersBuilder getHeaders() {
            return this.headers;
        }

        public final String getHost() {
            return this.url.getHost();
        }

        public final int getPort() {
            return this.url.getPort();
        }

        public final URLBuilder getUrl() {
            return this.url;
        }

        public final void setAttributes(InterfaceC5074l<? super Attributes, Y8.t> block) {
            kotlin.jvm.internal.p.i(block, "block");
            block.invoke(this.attributes);
        }

        public final <T> void setCapability(HttpClientEngineCapability<T> key, T capability) {
            kotlin.jvm.internal.p.i(key, "key");
            kotlin.jvm.internal.p.i(capability, "capability");
            ((Map) this.attributes.computeIfAbsent(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY(), new InterfaceC5063a() { // from class: io.ktor.client.plugins.c
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return DefaultRequest.DefaultRequestBuilder.setCapability$lambda$1();
                }
            })).put(key, capability);
        }

        public final void setHost(String value) {
            kotlin.jvm.internal.p.i(value, "value");
            this.url.setHost(value);
        }

        public final void setPort(int i10) {
            this.url.setPort(i10);
        }

        public final void unixSocket(String path) {
            kotlin.jvm.internal.p.i(path, "path");
            setCapability(UnixSocketCapability.INSTANCE, new UnixSocketSettings(path));
        }

        public final void url(InterfaceC5074l<? super URLBuilder, Y8.t> block) {
            kotlin.jvm.internal.p.i(block, "block");
            block.invoke(this.url);
        }

        public final void url(String scheme, String host, Integer port, String path, InterfaceC5074l<? super URLBuilder, Y8.t> block) {
            kotlin.jvm.internal.p.i(block, "block");
            URLBuilderKt.set(this.url, scheme, host, port, path, block);
        }

        public final void url(String urlString) {
            kotlin.jvm.internal.p.i(urlString, "urlString");
            URLParserKt.takeFrom(this.url, urlString);
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "Lio/ktor/client/plugins/DefaultRequest;", "<init>", "()V", "Lio/ktor/http/Url;", "baseUrl", "Lio/ktor/http/URLBuilder;", "requestUrl", "LY8/t;", "mergeUrls", "(Lio/ktor/http/Url;Lio/ktor/http/URLBuilder;)V", "", "", "parent", "child", "concatenatePath", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lkotlin/Function1;", "block", "prepare", "(Lp9/l;)Lio/ktor/client/plugins/DefaultRequest;", "plugin", "Lio/ktor/client/HttpClient;", "scope", W4.b.STEP_INSTALL, "(Lio/ktor/client/plugins/DefaultRequest;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.DefaultRequest$Plugin, reason: from kotlin metadata */
    public static final class Companion implements HttpClientPlugin<DefaultRequestBuilder, DefaultRequest> {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private final List<String> concatenatePath(List<String> parent, List<String> child) {
            if (child.isEmpty()) {
                return parent;
            }
            if (parent.isEmpty() || ((CharSequence) Z8.F.q0(child)).length() == 0) {
                return child;
            }
            List listD = C1172u.d((parent.size() + child.size()) - 1);
            int size = parent.size() - 1;
            for (int i10 = 0; i10 < size; i10++) {
                listD.add(parent.get(i10));
            }
            listD.addAll(child);
            return C1172u.a(listD);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void mergeUrls(Url baseUrl, URLBuilder requestUrl) {
            if (requestUrl.getProtocolOrNull() == null) {
                requestUrl.setProtocolOrNull(baseUrl.getProtocolOrNull());
            }
            if (requestUrl.getHost().length() > 0) {
                return;
            }
            URLBuilder URLBuilder = URLUtilsKt.URLBuilder(baseUrl);
            URLBuilder.setProtocolOrNull(requestUrl.getProtocolOrNull());
            if (requestUrl.getPort() != 0) {
                URLBuilder.setPort(requestUrl.getPort());
            }
            URLBuilder.setEncodedPathSegments(DefaultRequest.INSTANCE.concatenatePath(URLBuilder.getEncodedPathSegments(), requestUrl.getEncodedPathSegments()));
            if (requestUrl.getEncodedFragment().length() > 0) {
                URLBuilder.setEncodedFragment(requestUrl.getEncodedFragment());
            }
            ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
            StringValuesKt.appendAll(parametersBuilderParametersBuilder$default, URLBuilder.getEncodedParameters());
            URLBuilder.setEncodedParameters(requestUrl.getEncodedParameters());
            Iterator<T> it = parametersBuilderParametersBuilder$default.entries().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (!URLBuilder.getEncodedParameters().contains(str)) {
                    URLBuilder.getEncodedParameters().appendAll(str, list);
                }
            }
            URLUtilsKt.takeFrom(requestUrl, URLBuilder);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<DefaultRequest> getKey() {
            return DefaultRequest.key;
        }

        private Companion() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(DefaultRequest plugin, HttpClient scope) {
            kotlin.jvm.internal.p.i(plugin, "plugin");
            kotlin.jvm.internal.p.i(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getBefore(), new DefaultRequest$Plugin$install$1(plugin, null));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public DefaultRequest prepare(InterfaceC5074l<? super DefaultRequestBuilder, Y8.t> block) {
            kotlin.jvm.internal.p.i(block, "block");
            return new DefaultRequest(block, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        InterfaceC5755n interfaceC5755nM = null;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(DefaultRequest.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(DefaultRequest.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("DefaultRequest", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    public /* synthetic */ DefaultRequest(InterfaceC5074l interfaceC5074l, kotlin.jvm.internal.i iVar) {
        this(interfaceC5074l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DefaultRequest(InterfaceC5074l<? super DefaultRequestBuilder, Y8.t> interfaceC5074l) {
        this.block = interfaceC5074l;
    }
}
