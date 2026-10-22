package io.ktor.server.engine.internal;

import Ua.I;
import Ua.Y;
import Y8.t;
import io.ktor.server.application.ApplicationPluginKt;
import io.ktor.server.config.ApplicationConfig;
import io.ktor.server.config.ApplicationConfigValue;
import io.ktor.server.engine.EnginePipeline;
import io.ktor.server.engine.ShutDownUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\r\"\u0018\u0010\u0012\u001a\u00020\u000f*\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"", "availableProcessorsBridge", "()I", "", "message", "LY8/t;", "printError", "(Ljava/lang/Object;)V", "Lio/ktor/server/config/ApplicationConfig;", "config", "Lio/ktor/server/engine/EnginePipeline;", "pipeline", "configureShutdownUrl", "(Lio/ktor/server/config/ApplicationConfig;Lio/ktor/server/engine/EnginePipeline;)V", "LUa/Y;", "LUa/I;", "getIOBridge", "(LUa/Y;)LUa/I;", "IOBridge", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationUtilsJvmKt {
    public static final int availableProcessorsBridge() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static final void configureShutdownUrl(ApplicationConfig config, EnginePipeline pipeline) {
        final String string;
        p.i(config, "config");
        p.i(pipeline, "pipeline");
        ApplicationConfigValue applicationConfigValuePropertyOrNull = config.propertyOrNull("ktor.deployment.shutdown.url");
        if (applicationConfigValuePropertyOrNull == null || (string = applicationConfigValuePropertyOrNull.getString()) == null) {
            return;
        }
        ApplicationPluginKt.install(pipeline, ShutDownUrl.EnginePlugin.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.server.engine.internal.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ApplicationUtilsJvmKt.configureShutdownUrl$lambda$0(string, (ShutDownUrl.Config) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t configureShutdownUrl$lambda$0(String str, ShutDownUrl.Config install) {
        p.i(install, "$this$install");
        install.setShutDownUrl(str);
        return t.f7040a;
    }

    public static final I getIOBridge(Y y10) {
        p.i(y10, "<this>");
        return Y.b();
    }

    public static final void printError(Object obj) {
        System.err.print(obj);
    }
}
