package io.ktor.client.plugins.api;

import Y8.t;
import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.reflect.KVariance;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B7\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R&\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/client/plugins/api/ClientPluginImpl;", "", "PluginConfigT", "Lio/ktor/client/plugins/api/ClientPlugin;", "", "name", "Lkotlin/Function0;", "createConfiguration", "Lkotlin/Function1;", "Lio/ktor/client/plugins/api/ClientPluginBuilder;", "LY8/t;", "body", "<init>", "(Ljava/lang/String;Lp9/a;Lp9/l;)V", "block", "Lio/ktor/client/plugins/api/ClientPluginInstance;", "prepare", "(Lp9/l;)Lio/ktor/client/plugins/api/ClientPluginInstance;", "plugin", "Lio/ktor/client/HttpClient;", "scope", W4.b.STEP_INSTALL, "(Lio/ktor/client/plugins/api/ClientPluginInstance;Lio/ktor/client/HttpClient;)V", "Lp9/a;", "Lp9/l;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ClientPluginImpl<PluginConfigT> implements ClientPlugin<PluginConfigT> {
    private final InterfaceC5074l<ClientPluginBuilder<PluginConfigT>, t> body;
    private final InterfaceC5063a<PluginConfigT> createConfiguration;
    private final AttributeKey<ClientPluginInstance<PluginConfigT>> key;

    /* JADX WARN: Multi-variable type inference failed */
    public ClientPluginImpl(String name, InterfaceC5063a<? extends PluginConfigT> createConfiguration, InterfaceC5074l<? super ClientPluginBuilder<PluginConfigT>, t> body) {
        InterfaceC5755n interfaceC5755nN;
        p.i(name, "name");
        p.i(createConfiguration, "createConfiguration");
        p.i(body, "body");
        this.createConfiguration = createConfiguration;
        this.body = body;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(ClientPluginInstance.class);
        try {
            C5757p.Companion companion = C5757p.INSTANCE;
            InterfaceC5756o interfaceC5756oR = kotlin.jvm.internal.t.r(kotlin.jvm.internal.t.b(ClientPluginImpl.class), "PluginConfigT", KVariance.INVARIANT, false);
            kotlin.jvm.internal.t.l(interfaceC5756oR, kotlin.jvm.internal.t.m(Object.class));
            interfaceC5755nN = kotlin.jvm.internal.t.n(ClientPluginInstance.class, companion.d(kotlin.jvm.internal.t.q(interfaceC5756oR)));
        } catch (Throwable unused) {
            interfaceC5755nN = null;
        }
        this.key = new AttributeKey<>(name, new TypeInfo(interfaceC5745dB, interfaceC5755nN));
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public AttributeKey<ClientPluginInstance<PluginConfigT>> getKey() {
        return this.key;
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public void install(ClientPluginInstance<PluginConfigT> plugin, HttpClient scope) {
        p.i(plugin, "plugin");
        p.i(scope, "scope");
        plugin.install(scope);
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public ClientPluginInstance<PluginConfigT> prepare(InterfaceC5074l<? super PluginConfigT, t> block) {
        p.i(block, "block");
        PluginConfigT pluginconfigtInvoke = this.createConfiguration.invoke();
        block.invoke(pluginconfigtInvoke);
        return new ClientPluginInstance<>(getKey(), pluginconfigtInvoke, this.body);
    }
}
