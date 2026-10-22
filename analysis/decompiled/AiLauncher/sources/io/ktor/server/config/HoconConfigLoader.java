package io.ktor.server.config;

import La.D;
import b8.InterfaceC1455a;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/server/config/HoconConfigLoader;", "Lio/ktor/server/config/ConfigLoader;", "<init>", "()V", "", "path", "Lio/ktor/server/config/ApplicationConfig;", "load", "(Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfig;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HoconConfigLoader implements ConfigLoader {
    @Override // io.ktor.server.config.ConfigLoader
    public ApplicationConfig load(String path) {
        InterfaceC1455a interfaceC1455aI;
        InterfaceC1455a interfaceC1455aB;
        if (path == null) {
            path = "application.conf";
        } else if (!D.K(path, ".conf", false, 2, null) && !D.K(path, ".json", false, 2, null) && !D.K(path, ".properties", false, 2, null)) {
            return null;
        }
        if (Thread.currentThread().getContextClassLoader().getResource(path) != null) {
            interfaceC1455aI = com.typesafe.config.a.g(path);
        } else {
            File file = new File(path);
            interfaceC1455aI = file.exists() ? com.typesafe.config.a.i(file) : null;
        }
        if (interfaceC1455aI == null || (interfaceC1455aB = interfaceC1455aI.b()) == null) {
            return null;
        }
        return new HoconApplicationConfig(interfaceC1455aB);
    }
}
