package com.stepos.core.ota.domain.port;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface OtaLogger {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static /* synthetic */ void e$default(OtaLogger otaLogger, String str, String str2, Throwable th, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
            }
            if ((i10 & 4) != 0) {
                th = null;
            }
            otaLogger.e(str, str2, th);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Noop implements OtaLogger {
        public static final Noop INSTANCE = new Noop();

        private Noop() {
        }

        @Override // com.stepos.core.ota.domain.port.OtaLogger
        public void d(String tag, String msg) {
            g.f(tag, "tag");
            g.f(msg, "msg");
        }

        @Override // com.stepos.core.ota.domain.port.OtaLogger
        public void e(String tag, String msg, Throwable th) {
            g.f(tag, "tag");
            g.f(msg, "msg");
        }

        @Override // com.stepos.core.ota.domain.port.OtaLogger
        public void i(String tag, String msg) {
            g.f(tag, "tag");
            g.f(msg, "msg");
        }

        @Override // com.stepos.core.ota.domain.port.OtaLogger
        public void w(String tag, String msg) {
            g.f(tag, "tag");
            g.f(msg, "msg");
        }
    }

    void d(String str, String str2);

    void e(String str, String str2, Throwable th);

    void i(String str, String str2);

    void w(String str, String str2);
}
