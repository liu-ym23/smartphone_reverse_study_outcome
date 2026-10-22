package reactor.util;

import io.micrometer.core.instrument.MeterRegistry;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes2.dex */
public class Metrics {
    static final boolean isMicrometerAvailable;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Deprecated
    public static class MicrometerConfiguration {
        private static MeterRegistry registry = io.micrometer.core.instrument.Metrics.globalRegistry;

        @Deprecated
        public static MeterRegistry getRegistry() {
            return registry;
        }

        @Deprecated
        public static MeterRegistry useRegistry(MeterRegistry meterRegistry) {
            MeterRegistry meterRegistry2 = registry;
            registry = meterRegistry;
            return meterRegistry2;
        }
    }

    static {
        boolean z10;
        try {
            io.micrometer.core.instrument.Metrics.globalRegistry.getRegistries();
            z10 = true;
        } catch (Throwable unused) {
            z10 = false;
        }
        isMicrometerAvailable = z10;
    }

    @Deprecated
    public static final boolean isInstrumentationAvailable() {
        return isMicrometerAvailable;
    }
}
