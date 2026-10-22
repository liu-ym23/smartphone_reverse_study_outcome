package io.ktor.server.config;

import Ka.t;
import Z8.C1173v;
import io.ktor.server.engine.EnvironmentUtilsJvmKt;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00008\u0006¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\t\u0010\n\u001a\u0004\b\b\u0010\u0003¨\u0006\u000b"}, d2 = {"", "", "getCONFIG_PATH", "()Ljava/util/List;", "CONFIG_PATH", "Lio/ktor/server/config/ConfigLoader;", "configLoaders", "Ljava/util/List;", "getConfigLoaders", "getConfigLoaders$annotations", "()V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConfigLoadersJvmKt {
    private static final List<ConfigLoader> configLoaders;

    static {
        Iterator it = ServiceLoader.load(ConfigLoader.class, ConfigLoader.class.getClassLoader()).iterator();
        p.h(it, "iterator(...)");
        configLoaders = SequencesKt___SequencesKt.d0(t.h(it));
    }

    public static final List<String> getCONFIG_PATH() {
        return C1173v.r(EnvironmentUtilsJvmKt.getEnvironmentProperty("config.file"), EnvironmentUtilsJvmKt.getEnvironmentProperty("config.resource"), EnvironmentUtilsJvmKt.getEnvironmentProperty("config.url"));
    }

    public static final List<ConfigLoader> getConfigLoaders() {
        return configLoaders;
    }

    public static /* synthetic */ void getConfigLoaders$annotations() {
    }
}
