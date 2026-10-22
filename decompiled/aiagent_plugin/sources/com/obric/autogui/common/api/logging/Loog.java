package com.obric.autogui.common.api.logging;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.a.b;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: Loog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Loog implements ILogger {
    public static final Loog INSTANCE = null;
    private static final String TAG_PREFIX = "ao_";
    private static volatile ILogger impl;

    static {
        INSTANCE = new Loog();
    }

    private Loog() {
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void dp(String r3, a<String> r4) {
        ILogger.DefaultImpls.dp(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void dp(String r3, a<String> r4, a<String> r5) {
        ILogger.DefaultImpls.dp(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void ep(String r3, a<String> r4, a<String> r5) {
        ILogger.DefaultImpls.ep(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void ep(String r3, a<String> r4, a<String> r5, Throwable r6) {
        ILogger.DefaultImpls.ep(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void ip(String r3, a<String> r4, a<String> r5) {
        ILogger.DefaultImpls.ip(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void wp(String r3, a<String> r4, a<String> r5) {
        ILogger.DefaultImpls.wp(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"));
    }

    private final ILogger getImpl() {
        ILogger r2 = impl;
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (ILogger) ZeusTransformUtils.preCheckCast(DefaultLogger.INSTANCE, ILogger.class, "com.obric.aiagent.plugin");
    }

    public final void setImpl(ILogger r2) {
        impl = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
    }

    private final String normTag(String r2) {
        return TAG_PREFIX + r2;
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public boolean isDebug() {
        return getImpl().isDebug();
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public String getDirPath() {
        String r0 = getImpl().getDirPath();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void v(String r3, String r4) {
        o.e(r3, "tag");
        getImpl().v(TAG_PREFIX + r3, r4);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void d(String r3, String r4) {
        o.e(r3, "tag");
        getImpl().d(TAG_PREFIX + r3, r4);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void i(String r3, String r4) {
        o.e(r3, "tag");
        getImpl().i(TAG_PREFIX + r3, r4);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void w(String r3, String r4) {
        o.e(r3, "tag");
        getImpl().w(TAG_PREFIX + r3, r4);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void w(String r3, String r4, Throwable r5) {
        o.e(r3, "tag");
        getImpl().w(TAG_PREFIX + r3, r4, r5);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void w(String r3, Throwable r4) {
        o.e(r3, "tag");
        getImpl().w(TAG_PREFIX + r3, r4);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void e(String r3, String r4) {
        o.e(r3, "tag");
        getImpl().e(TAG_PREFIX + r3, r4);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void e(String r3, String r4, Throwable r5) {
        o.e(r3, "tag");
        getImpl().e(TAG_PREFIX + r3, r4, r5);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void uploadAllLog(String r3, b<? super Boolean, x> r4) {
        b<? super Boolean, x> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        o.e(r3, DBHelper.BATTERY_COL_SCENE);
        getImpl().uploadAllLog(r3, r5);
    }
}
