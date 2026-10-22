package io.ktor.server.engine.internal;

import La.H;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", UxipConstants.f30680s, "escapeHostname", "(Ljava/lang/String;)Ljava/lang/String;", "OS_NAME", "Ljava/lang/String;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EngineUtilsJvmKt {
    private static final String OS_NAME;

    static {
        String property = System.getProperty("os.name", "");
        p.h(property, "getProperty(...)");
        String lowerCase = property.toLowerCase(Locale.ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        OS_NAME = lowerCase;
    }

    public static final String escapeHostname(String value) {
        p.i(value, "value");
        return (H.g0(OS_NAME, "windows", false, 2, null) && p.d(value, "0.0.0.0")) ? "127.0.0.1" : value;
    }
}
