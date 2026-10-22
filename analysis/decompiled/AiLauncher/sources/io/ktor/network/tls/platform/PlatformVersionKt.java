package io.ktor.network.tls.platform;

import Y8.h;
import io.ktor.network.tls.platform.PlatformVersion;
import io.ktor.network.tls.platform.PlatformVersionKt;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001b\u0010\u0005\u001a\u00020\u00008@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/ktor/network/tls/platform/PlatformVersion;", "platformVersion$delegate", "LY8/h;", "getPlatformVersion", "()Lio/ktor/network/tls/platform/PlatformVersion;", "platformVersion", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlatformVersionKt {
    private static final h platformVersion$delegate = C4848b.b(new InterfaceC5063a() { // from class: p8.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return PlatformVersionKt.platformVersion_delegate$lambda$0();
        }
    });

    public static final PlatformVersion getPlatformVersion() {
        return (PlatformVersion) platformVersion$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlatformVersion platformVersion_delegate$lambda$0() {
        PlatformVersion.Companion companion = PlatformVersion.INSTANCE;
        String property = System.getProperty("java.version");
        p.h(property, "getProperty(...)");
        return companion.invoke(property);
    }
}
