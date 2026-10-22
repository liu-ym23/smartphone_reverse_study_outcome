package reactor.util;

import io.micrometer.core.instrument.MeterRegistry;

@Deprecated
/* loaded from: classes5.dex */
public class Metrics {
    static final boolean isMicrometerAvailable;

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
