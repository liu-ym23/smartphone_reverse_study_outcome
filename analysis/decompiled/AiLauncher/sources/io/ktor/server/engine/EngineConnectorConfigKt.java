package io.ktor.server.engine;

import io.ktor.server.engine.ApplicationEngine;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"Lio/ktor/server/engine/ApplicationEngine$Configuration;", "Lkotlin/Function1;", "Lio/ktor/server/engine/EngineConnectorBuilder;", "LY8/t;", "builder", "connector", "(Lio/ktor/server/engine/ApplicationEngine$Configuration;Lp9/l;)V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EngineConnectorConfigKt {
    public static final void connector(ApplicationEngine.Configuration configuration, InterfaceC5074l<? super EngineConnectorBuilder, Y8.t> builder) {
        kotlin.jvm.internal.p.i(configuration, "<this>");
        kotlin.jvm.internal.p.i(builder, "builder");
        List<EngineConnectorConfig> connectors = configuration.getConnectors();
        EngineConnectorBuilder engineConnectorBuilder = new EngineConnectorBuilder(null, 1, null);
        builder.invoke(engineConnectorBuilder);
        connectors.add(engineConnectorBuilder);
    }
}
