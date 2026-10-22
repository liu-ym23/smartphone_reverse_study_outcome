package com.obric.eventkit.logger;

import b.a.a.b.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class Logger implements ILogger {
    public static final Logger INSTANCE = null;
    private static ILogger impl;

    static {
        INSTANCE = new Logger();
    }

    private Logger() {
    }

    private final ILogger getImpl() {
        ILogger r0 = impl;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return a.f3060a;
    }

    private final String normalizeTag(String r2) {
        return "ac_" + r2;
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void d(String r2, String r3) {
        o.e(r2, "tag");
        getImpl().d(normalizeTag(r2), r3);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void e(String r2, String r3) {
        o.e(r2, "tag");
        getImpl().e(normalizeTag(r2), r3);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void e(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        getImpl().e(normalizeTag(r2), r3, r4);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void i(String r2, String r3) {
        o.e(r2, "tag");
        getImpl().i(normalizeTag(r2), r3);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public boolean isDebug() {
        return getImpl().isDebug();
    }

    public final void setLogger(ILogger r2) {
        ILogger r1 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
        o.e(r1, "logger");
        impl = r1;
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void v(String r2, String r3) {
        o.e(r2, "tag");
        if (isDebug() == true) goto L5;
        return;
    L5:
        getImpl().v(normalizeTag(r2), r3);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void w(String r2, String r3) {
        o.e(r2, "tag");
        getImpl().w(normalizeTag(r2), r3);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void w(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        getImpl().w(normalizeTag(r2), r3, r4);
    }

    @Override // com.obric.eventkit.logger.ILogger
    public void w(String r2, Throwable r3) {
        o.e(r2, "tag");
        getImpl().w(normalizeTag(r2), r3);
    }
}
