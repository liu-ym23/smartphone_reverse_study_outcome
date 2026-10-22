package io.ktor.server.config;

import b8.InterfaceC1455a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lb8/a;", "", "path", "tryGetString", "(Lb8/a;Ljava/lang/String;)Ljava/lang/String;", "", "tryGetStringList", "(Lb8/a;Ljava/lang/String;)Ljava/util/List;", "configPath", "Lio/ktor/server/config/ApplicationConfig;", "ApplicationConfig", "(Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfig;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HoconApplicationConfigKt {
    public static final ApplicationConfig ApplicationConfig(String str) {
        return ConfigLoader.INSTANCE.load(str);
    }

    public static final String tryGetString(InterfaceC1455a interfaceC1455a, String path) {
        p.i(interfaceC1455a, "<this>");
        p.i(path, "path");
        if (interfaceC1455a.H(path)) {
            return interfaceC1455a.t(path);
        }
        return null;
    }

    public static final List<String> tryGetStringList(InterfaceC1455a interfaceC1455a, String path) {
        p.i(interfaceC1455a, "<this>");
        p.i(path, "path");
        if (interfaceC1455a.H(path)) {
            return interfaceC1455a.m(path);
        }
        return null;
    }
}
