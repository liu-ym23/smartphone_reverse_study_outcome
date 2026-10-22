package io.ktor.client.engine;

import Z8.X;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\"0\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"!\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/util/AttributeKey;", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "", "ENGINE_CAPABILITIES_KEY", "Lio/ktor/util/AttributeKey;", "getENGINE_CAPABILITIES_KEY", "()Lio/ktor/util/AttributeKey;", "", "DEFAULT_CAPABILITIES", "Ljava/util/Set;", "getDEFAULT_CAPABILITIES", "()Ljava/util/Set;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpClientEngineCapabilityKt {
    private static final Set<HttpClientEngineCapability<?>> DEFAULT_CAPABILITIES;
    private static final AttributeKey<Map<HttpClientEngineCapability<?>, Object>> ENGINE_CAPABILITIES_KEY;

    static {
        InterfaceC5755n interfaceC5755nD;
        InterfaceC5745d interfaceC5745dB = t.b(Map.class);
        try {
            C5757p.Companion companion = C5757p.INSTANCE;
            interfaceC5755nD = t.d(t.o(Map.class, companion.d(t.n(HttpClientEngineCapability.class, companion.c())), companion.d(t.m(Object.class))));
        } catch (Throwable unused) {
            interfaceC5755nD = null;
        }
        ENGINE_CAPABILITIES_KEY = new AttributeKey<>("EngineCapabilities", new TypeInfo(interfaceC5745dB, interfaceC5755nD));
        DEFAULT_CAPABILITIES = X.d(HttpTimeoutCapability.INSTANCE);
    }

    public static final Set<HttpClientEngineCapability<?>> getDEFAULT_CAPABILITIES() {
        return DEFAULT_CAPABILITIES;
    }

    public static final AttributeKey<Map<HttpClientEngineCapability<?>, Object>> getENGINE_CAPABILITIES_KEY() {
        return ENGINE_CAPABILITIES_KEY;
    }
}
