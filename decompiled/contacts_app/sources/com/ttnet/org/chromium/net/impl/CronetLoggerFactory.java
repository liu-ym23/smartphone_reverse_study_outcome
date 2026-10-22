package com.ttnet.org.chromium.net.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class CronetLoggerFactory {
    private static final String CRONET_LOGGER_IMPL_CLASS = "com.google.net.cronet.telemetry.CronetLoggerImpl";
    private static final int SAMPLE_RATE_PER_SECOND = 1;
    private static final CronetLogger sDefaultLogger = null;
    private static CronetLogger sTestingLogger;

    public static class SwapLoggerForTesting implements AutoCloseable {
        public SwapLoggerForTesting(CronetLogger r1) {
            CronetLoggerFactory.access$000(r1);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            CronetLoggerFactory.access$000(null);
        }
    }

    static /* synthetic */ void access$000(CronetLogger r0) {
        setLoggerForTesting(r0);
    }

    private CronetLoggerFactory() {
    }

    static {
        sDefaultLogger = new NoOpLogger();
    }

    public static CronetLogger createNoOpLogger() {
        return sDefaultLogger;
    }

    public static CronetLogger createLogger(Context r3, CronetLogger.CronetSource r4) {
        CronetLogger r0 = sTestingLogger;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (CronetManifest.isAppOptedInForTelemetry(r3, r4) == false) goto L17;
        Class<? extends CronetLogger> r5 = fetchLoggerImplClass();
        if (r5 != null) goto L18;
        return sDefaultLogger;
    L18:
        return r5.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{1});
    L15:
        return sDefaultLogger;
    L17:
        return sDefaultLogger;
    }

    private static void setLoggerForTesting(CronetLogger r0) {
        sTestingLogger = r0;
    }

    private static Class<? extends CronetLogger> fetchLoggerImplClass() {
        return CronetLoggerFactory.class.getClassLoader().loadClass(CRONET_LOGGER_IMPL_CLASS).asSubclass(CronetLogger.class);
    L5:
        return null;
    }
}
