package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0004\u0010\u0003\"\u0018\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "LY8/t;", "BrowserUserAgent", "(Lio/ktor/client/HttpClientConfig;)V", "CurlUserAgent", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/UserAgentConfig;", "UserAgent", "Lio/ktor/client/plugins/api/ClientPlugin;", "getUserAgent", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserAgentKt {
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.UserAgent");
    private static final ClientPlugin<UserAgentConfig> UserAgent = CreatePluginUtilsKt.createClientPlugin("UserAgent", UserAgentKt$UserAgent$2.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.client.plugins.F
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return UserAgentKt.UserAgent$lambda$1((ClientPluginBuilder) obj);
        }
    });

    public static final void BrowserUserAgent(HttpClientConfig<?> httpClientConfig) {
        kotlin.jvm.internal.p.i(httpClientConfig, "<this>");
        httpClientConfig.install(UserAgent, new InterfaceC5074l() { // from class: io.ktor.client.plugins.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return UserAgentKt.BrowserUserAgent$lambda$2((UserAgentConfig) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t BrowserUserAgent$lambda$2(UserAgentConfig install) {
        kotlin.jvm.internal.p.i(install, "$this$install");
        install.setAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/70.0.3538.77 Chrome/70.0.3538.77 Safari/537.36");
        return Y8.t.f7040a;
    }

    public static final void CurlUserAgent(HttpClientConfig<?> httpClientConfig) {
        kotlin.jvm.internal.p.i(httpClientConfig, "<this>");
        httpClientConfig.install(UserAgent, new InterfaceC5074l() { // from class: io.ktor.client.plugins.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return UserAgentKt.CurlUserAgent$lambda$3((UserAgentConfig) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t CurlUserAgent$lambda$3(UserAgentConfig install) {
        kotlin.jvm.internal.p.i(install, "$this$install");
        install.setAgent("curl/7.61.0");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t UserAgent$lambda$1(ClientPluginBuilder createClientPlugin) {
        kotlin.jvm.internal.p.i(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.onRequest(new UserAgentKt$UserAgent$3$1(((UserAgentConfig) createClientPlugin.getPluginConfig()).getAgent(), null));
        return Y8.t.f7040a;
    }

    public static final ClientPlugin<UserAgentConfig> getUserAgent() {
        return UserAgent;
    }
}
