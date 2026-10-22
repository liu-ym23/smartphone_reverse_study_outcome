package io.ktor.client.plugins.api;

import Y8.t;
import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.utils.io.InternalAPI;
import java.io.Closeable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00060\u0003j\u0002`\u0004B?\b\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0005\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0014\u0010\u0007\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R&\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/api/ClientPluginInstance;", "", "PluginConfig", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/util/AttributeKey;", "key", "config", "Lkotlin/Function1;", "Lio/ktor/client/plugins/api/ClientPluginBuilder;", "LY8/t;", "body", "<init>", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;Lp9/l;)V", "Lio/ktor/client/HttpClient;", "scope", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;)V", "close", "()V", "Lio/ktor/util/AttributeKey;", "Ljava/lang/Object;", "Lp9/l;", "Lkotlin/Function0;", "onClose", "Lp9/a;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClientPluginInstance<PluginConfig> implements Closeable {
    private final InterfaceC5074l<ClientPluginBuilder<PluginConfig>, t> body;
    private final PluginConfig config;
    private final AttributeKey<ClientPluginInstance<PluginConfig>> key;
    private InterfaceC5063a<t> onClose;

    /* JADX WARN: Multi-variable type inference failed */
    public ClientPluginInstance(AttributeKey<ClientPluginInstance<PluginConfig>> key, PluginConfig config, InterfaceC5074l<? super ClientPluginBuilder<PluginConfig>, t> body) {
        p.i(key, "key");
        p.i(config, "config");
        p.i(body, "body");
        this.key = key;
        this.config = config;
        this.body = body;
        this.onClose = new InterfaceC5063a() { // from class: io.ktor.client.plugins.api.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return t.f7040a;
            }
        };
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.onClose.invoke();
    }

    @InternalAPI
    public final void install(HttpClient scope) {
        p.i(scope, "scope");
        ClientPluginBuilder<PluginConfig> clientPluginBuilder = new ClientPluginBuilder<>(this.key, scope, this.config);
        this.body.invoke(clientPluginBuilder);
        this.onClose = clientPluginBuilder.getOnClose$ktor_client_core();
        Iterator<T> it = clientPluginBuilder.getHooks$ktor_client_core().iterator();
        while (it.hasNext()) {
            ((HookHandler) it.next()).install(scope);
        }
    }
}
