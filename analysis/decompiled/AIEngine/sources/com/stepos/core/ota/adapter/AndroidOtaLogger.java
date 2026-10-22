package com.stepos.core.ota.adapter;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.domain.port.OtaLogger;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AndroidOtaLogger implements OtaLogger {
    @Override // com.stepos.core.ota.domain.port.OtaLogger
    public void d(String tag, String msg) {
        g.f(tag, "tag");
        g.f(msg, "msg");
        AIEngineLogger.d(LogModule.OTA, tag, msg);
    }

    @Override // com.stepos.core.ota.domain.port.OtaLogger
    public void e(String tag, String msg, Throwable th) {
        g.f(tag, "tag");
        g.f(msg, "msg");
        AIEngineLogger.e(LogModule.OTA, tag, msg, th);
    }

    @Override // com.stepos.core.ota.domain.port.OtaLogger
    public void i(String tag, String msg) {
        g.f(tag, "tag");
        g.f(msg, "msg");
        AIEngineLogger.i(LogModule.OTA, tag, msg);
    }

    @Override // com.stepos.core.ota.domain.port.OtaLogger
    public void w(String tag, String msg) {
        g.f(tag, "tag");
        g.f(msg, "msg");
        AIEngineLogger.w(LogModule.OTA, tag, msg);
    }
}
