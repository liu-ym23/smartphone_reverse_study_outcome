package io.ktor.client.plugins.api;

import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"", "PluginConfigT", "", "name", "Lkotlin/Function0;", "createConfiguration", "Lkotlin/Function1;", "Lio/ktor/client/plugins/api/ClientPluginBuilder;", "LY8/t;", "body", "Lio/ktor/client/plugins/api/ClientPlugin;", "createClientPlugin", "(Ljava/lang/String;Lp9/a;Lp9/l;)Lio/ktor/client/plugins/api/ClientPlugin;", "(Ljava/lang/String;Lp9/l;)Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CreatePluginUtilsKt {
    public static final <PluginConfigT> ClientPlugin<PluginConfigT> createClientPlugin(String name, InterfaceC5063a<? extends PluginConfigT> createConfiguration, InterfaceC5074l<? super ClientPluginBuilder<PluginConfigT>, t> body) {
        p.i(name, "name");
        p.i(createConfiguration, "createConfiguration");
        p.i(body, "body");
        return new ClientPluginImpl(name, createConfiguration, body);
    }

    public static final ClientPlugin<t> createClientPlugin(String name, InterfaceC5074l<? super ClientPluginBuilder<t>, t> body) {
        p.i(name, "name");
        p.i(body, "body");
        return createClientPlugin(name, new InterfaceC5063a() { // from class: io.ktor.client.plugins.api.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return t.f7040a;
            }
        }, body);
    }
}
