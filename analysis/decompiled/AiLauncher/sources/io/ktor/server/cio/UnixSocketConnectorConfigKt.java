package io.ktor.server.cio;

import Y8.t;
import io.ktor.server.engine.ApplicationEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/server/engine/ApplicationEngine$Configuration;", "", "socketPath", "Lkotlin/Function1;", "Lio/ktor/server/cio/UnixSocketConnectorBuilder;", "LY8/t;", "builder", "unixConnector", "(Lio/ktor/server/engine/ApplicationEngine$Configuration;Ljava/lang/String;Lp9/l;)V", "ktor-server-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UnixSocketConnectorConfigKt {
    public static final void unixConnector(ApplicationEngine.Configuration configuration, String socketPath, InterfaceC5074l<? super UnixSocketConnectorBuilder, t> builder) {
        p.i(configuration, "<this>");
        p.i(socketPath, "socketPath");
        p.i(builder, "builder");
        UnixSocketConnectorBuilder unixSocketConnectorBuilder = new UnixSocketConnectorBuilder();
        unixSocketConnectorBuilder.setSocketPath(socketPath);
        builder.invoke(unixSocketConnectorBuilder);
        configuration.getConnectors().add(unixSocketConnectorBuilder);
    }

    public static /* synthetic */ void unixConnector$default(ApplicationEngine.Configuration configuration, String str, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.cio.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return UnixSocketConnectorConfigKt.unixConnector$lambda$0((UnixSocketConnectorBuilder) obj2);
                }
            };
        }
        unixConnector(configuration, str, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t unixConnector$lambda$0(UnixSocketConnectorBuilder unixSocketConnectorBuilder) {
        p.i(unixSocketConnectorBuilder, "<this>");
        return t.f7040a;
    }
}
