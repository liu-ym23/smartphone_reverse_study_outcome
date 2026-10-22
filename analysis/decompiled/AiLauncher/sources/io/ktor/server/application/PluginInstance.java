package io.ktor.server.application;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/server/application/PluginInstance;", "", "Lio/ktor/server/application/PluginBuilder;", "builder", "<init>", "(Lio/ktor/server/application/PluginBuilder;)V", "Lio/ktor/server/application/PluginBuilder;", "getBuilder$ktor_server_core", "()Lio/ktor/server/application/PluginBuilder;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PluginInstance {
    private final PluginBuilder<?> builder;

    public PluginInstance(PluginBuilder<?> builder) {
        p.i(builder, "builder");
        this.builder = builder;
    }

    public final PluginBuilder<?> getBuilder$ktor_server_core() {
        return this.builder;
    }
}
