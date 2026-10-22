package io.ktor.client;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.aiengine.api.IAlgorithmProperties;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.PlatformUtils;
import io.ktor.utils.io.KtorDsl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@KtorDsl
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJK\u0010\u0010\u001a\u00020\u0007\"\b\b\u0001\u0010\u000b*\u00020\u0003\"\b\b\u0002\u0010\f*\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0010\u0010\u0015J\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0010\u0010\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001b\u001a\u00020\u00072\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0086\u0002¢\u0006\u0004\b\u001b\u0010\u001cR0\u0010\u001f\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R0\u0010!\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R,\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 R.\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\nR\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00102\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R(\u00105\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b5\u0010*\u0012\u0004\b8\u0010\u0005\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.¨\u00069"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "Lkotlin/Function1;", "LY8/t;", "block", C3081a.KEY_ENGINE, "(Lp9/l;)V", "TBuilder", "TPlugin", "Lio/ktor/client/plugins/HttpClientPlugin;", "plugin", "configure", W4.b.STEP_INSTALL, "(Lio/ktor/client/plugins/HttpClientPlugin;Lp9/l;)V", "", "key", "Lio/ktor/client/HttpClient;", "(Ljava/lang/String;Lp9/l;)V", "client", "(Lio/ktor/client/HttpClient;)V", "clone", "()Lio/ktor/client/HttpClientConfig;", "other", "plusAssign", "(Lio/ktor/client/HttpClientConfig;)V", "", "Lio/ktor/util/AttributeKey;", IAlgorithmProperties.PLUGINS, "Ljava/util/Map;", "pluginConfigurations", "customInterceptors", "engineConfig", "Lp9/l;", "getEngineConfig$ktor_client_core", "()Lp9/l;", "setEngineConfig$ktor_client_core", "", "followRedirects", "Z", "getFollowRedirects", "()Z", "setFollowRedirects", "(Z)V", "useDefaultTransformers", "getUseDefaultTransformers", "setUseDefaultTransformers", "expectSuccess", "getExpectSuccess", "setExpectSuccess", "developmentMode", "getDevelopmentMode", "setDevelopmentMode", "getDevelopmentMode$annotations", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpClientConfig<T extends HttpClientEngineConfig> {
    private boolean expectSuccess;
    private final Map<AttributeKey<?>, InterfaceC5074l<HttpClient, t>> plugins = new LinkedHashMap();
    private final Map<AttributeKey<?>, InterfaceC5074l<Object, t>> pluginConfigurations = new LinkedHashMap();
    private final Map<String, InterfaceC5074l<HttpClient, t>> customInterceptors = new LinkedHashMap();
    private InterfaceC5074l<? super T, t> engineConfig = new InterfaceC5074l() { // from class: io.ktor.client.f
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return HttpClientConfig.engineConfig$lambda$0((HttpClientEngineConfig) obj);
        }
    };
    private boolean followRedirects = true;
    private boolean useDefaultTransformers = true;
    private boolean developmentMode = PlatformUtils.INSTANCE.getIS_DEVELOPMENT_MODE();

    /* JADX INFO: Access modifiers changed from: private */
    public static final t engine$lambda$1(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, HttpClientEngineConfig httpClientEngineConfig) {
        p.i(httpClientEngineConfig, "<this>");
        interfaceC5074l.invoke(httpClientEngineConfig);
        interfaceC5074l2.invoke(httpClientEngineConfig);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t engineConfig$lambda$0(HttpClientEngineConfig httpClientEngineConfig) {
        p.i(httpClientEngineConfig, "<this>");
        return t.f7040a;
    }

    public static /* synthetic */ void getDevelopmentMode$annotations() {
    }

    public static /* synthetic */ void install$default(HttpClientConfig httpClientConfig, HttpClientPlugin httpClientPlugin, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return HttpClientConfig.install$lambda$2(obj2);
                }
            };
        }
        httpClientConfig.install(httpClientPlugin, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t install$lambda$2(Object obj) {
        p.i(obj, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t install$lambda$3(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, Object obj) {
        p.i(obj, "<this>");
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(obj);
        }
        interfaceC5074l2.invoke(obj);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t install$lambda$5(HttpClientPlugin httpClientPlugin, HttpClient scope) {
        p.i(scope, "scope");
        Attributes attributes = (Attributes) scope.getAttributes().computeIfAbsent(HttpClientPluginKt.getPLUGIN_INSTALLED_LIST(), new InterfaceC5063a() { // from class: io.ktor.client.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HttpClientConfig.install$lambda$5$lambda$4();
            }
        });
        InterfaceC5074l<Object, t> interfaceC5074l = ((HttpClientConfig) scope.getConfig$ktor_client_core()).pluginConfigurations.get(httpClientPlugin.getKey());
        p.f(interfaceC5074l);
        Object objPrepare = httpClientPlugin.prepare(interfaceC5074l);
        httpClientPlugin.install(objPrepare, scope);
        attributes.put(httpClientPlugin.getKey(), objPrepare);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Attributes install$lambda$5$lambda$4() {
        return AttributesJvmKt.Attributes(true);
    }

    public final HttpClientConfig<T> clone() {
        HttpClientConfig<T> httpClientConfig = new HttpClientConfig<>();
        httpClientConfig.plusAssign(this);
        return httpClientConfig;
    }

    public final void engine(final InterfaceC5074l<? super T, t> block) {
        p.i(block, "block");
        final InterfaceC5074l<? super T, t> interfaceC5074l = this.engineConfig;
        this.engineConfig = new InterfaceC5074l() { // from class: io.ktor.client.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpClientConfig.engine$lambda$1(interfaceC5074l, block, (HttpClientEngineConfig) obj);
            }
        };
    }

    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final InterfaceC5074l<T, t> getEngineConfig$ktor_client_core() {
        return this.engineConfig;
    }

    public final boolean getExpectSuccess() {
        return this.expectSuccess;
    }

    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public final boolean getUseDefaultTransformers() {
        return this.useDefaultTransformers;
    }

    public final <TBuilder, TPlugin> void install(final HttpClientPlugin<? extends TBuilder, TPlugin> plugin, final InterfaceC5074l<? super TBuilder, t> configure) {
        p.i(plugin, "plugin");
        p.i(configure, "configure");
        final InterfaceC5074l<Object, t> interfaceC5074l = this.pluginConfigurations.get(plugin.getKey());
        this.pluginConfigurations.put(plugin.getKey(), new InterfaceC5074l() { // from class: io.ktor.client.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpClientConfig.install$lambda$3(interfaceC5074l, configure, obj);
            }
        });
        if (this.plugins.containsKey(plugin.getKey())) {
            return;
        }
        this.plugins.put(plugin.getKey(), new InterfaceC5074l() { // from class: io.ktor.client.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpClientConfig.install$lambda$5(plugin, (HttpClient) obj);
            }
        });
    }

    public final void plusAssign(HttpClientConfig<? extends T> other) {
        p.i(other, "other");
        this.followRedirects = other.followRedirects;
        this.useDefaultTransformers = other.useDefaultTransformers;
        this.expectSuccess = other.expectSuccess;
        this.plugins.putAll(other.plugins);
        this.pluginConfigurations.putAll(other.pluginConfigurations);
        this.customInterceptors.putAll(other.customInterceptors);
    }

    public final void setDevelopmentMode(boolean z10) {
        this.developmentMode = z10;
    }

    public final void setEngineConfig$ktor_client_core(InterfaceC5074l<? super T, t> interfaceC5074l) {
        p.i(interfaceC5074l, "<set-?>");
        this.engineConfig = interfaceC5074l;
    }

    public final void setExpectSuccess(boolean z10) {
        this.expectSuccess = z10;
    }

    public final void setFollowRedirects(boolean z10) {
        this.followRedirects = z10;
    }

    public final void setUseDefaultTransformers(boolean z10) {
        this.useDefaultTransformers = z10;
    }

    public final void install(String key, InterfaceC5074l<? super HttpClient, t> block) {
        p.i(key, "key");
        p.i(block, "block");
        this.customInterceptors.put(key, block);
    }

    public final void install(HttpClient client) {
        p.i(client, "client");
        Iterator<T> it = this.plugins.values().iterator();
        while (it.hasNext()) {
            ((InterfaceC5074l) it.next()).invoke(client);
        }
        Iterator<T> it2 = this.customInterceptors.values().iterator();
        while (it2.hasNext()) {
            ((InterfaceC5074l) it2.next()).invoke(client);
        }
    }
}
