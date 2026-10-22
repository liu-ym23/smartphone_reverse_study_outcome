package com.obric.autogui.common.api.logging;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.a.a;
import d.h.b.o;
import d.n.m;

/* JADX INFO: compiled from: OmniDataFeedbackLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniDataFeedbackLog {
    public static final OmniDataFeedbackLog INSTANCE = null;
    private static final String KEY_LOG_ENABLE = "omni.data_feedback.log.enable";
    private static final int PRIVACY_SAFE_CAUSE_DEPTH = 4;

    static {
        INSTANCE = new OmniDataFeedbackLog();
    }

    /* JADX INFO: renamed from: lambda$8pA5dH08CvM90Y1N9CLthdPds-c, reason: not valid java name */
    public static /* synthetic */ Throwable m805lambda$8pA5dH08CvM90Y1N9CLthdPdsc(Throwable r0) {
        return toPrivacySafeLogSummary$lambda$0(r0);
    }

    public static /* synthetic */ CharSequence lambda$cGMaApaWmZTMWMrhDs0HagCuwok(Throwable r0) {
        return toPrivacySafeLogSummary$lambda$2(r0);
    }

    private OmniDataFeedbackLog() {
    }

    public final void d(String r3, a<String> r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r5, "msg");
        if (isVerboseLogEnabled() == false) goto L6;
        Loog.INSTANCE.d(r3, (String) ZeusTransformUtils.preCheckCast(r5.invoke(), String.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void i(String r3, a<String> r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r5, "msg");
        if (isVerboseLogEnabled() == false) goto L6;
        Loog.INSTANCE.i(r3, (String) ZeusTransformUtils.preCheckCast(r5.invoke(), String.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void w(String r3, a<String> r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r5, "msg");
        if (isVerboseLogEnabled() == false) goto L6;
        Loog.INSTANCE.w(r3, (String) ZeusTransformUtils.preCheckCast(r5.invoke(), String.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void w(String r3, Throwable r4, a<String> r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r4, "tr");
        o.e(r6, "msg");
        if (isVerboseLogEnabled() == false) goto L6;
        Loog.INSTANCE.w(r3, (String) ZeusTransformUtils.preCheckCast(r6.invoke(), String.class, "com.obric.aiagent.plugin"), r4);
        return;
    }

    public final void e(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        Loog.INSTANCE.e(r1, r2);
    }

    public final void e(String r3, String r4, Throwable r5) {
        o.e(r3, "tag");
        o.e(r4, "msg");
        o.e(r5, "tr");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Loog.INSTANCE.e(r3, r4, r5);
        return;
    L5:
        Loog.INSTANCE.e(r3, r4 + ", exception=" + toPrivacySafeLogSummary(r5));
    }

    public final boolean isVerboseLogEnabled() {
        if (AOSystemTools.INSTANCE.isDebugVersion() == true) goto L5;
        return false;
    L5:
        if (AutoActionConfigs.INSTANCE.getBooleanCfg(KEY_LOG_ENABLE, false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private final String toPrivacySafeLogSummary(Throwable r10) {
        return m.a(m.c(m.a(r10, $$Lambda$OmniDataFeedbackLog$8pA5dH08CvM90Y1N9CLthdPdsc.INSTANCE), 4), (CharSequence) ZeusTransformUtils.preCheckCast(" <- ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$OmniDataFeedbackLog$cGMaApaWmZTMWMrhDs0HagCuwok.INSTANCE, 30, null);
    }

    private static final Throwable toPrivacySafeLogSummary$lambda$0(Throwable r1) {
        o.e(r1, "it");
        return r1.getCause();
    }

    private static final CharSequence toPrivacySafeLogSummary$lambda$2(Throwable r4) {
        o.e(r4, "current");
        String r0 = r4.getClass().getName();
        StackTraceElement[] r5 = r4.getStackTrace();
        o.c(r5, "getStackTrace(...)");
        StackTraceElement r6 = (StackTraceElement) ZeusTransformUtils.preCheckCast(i.c((Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.aiagent.plugin")), StackTraceElement.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L7;
        String r7 = r0 + '@' + r6.getClassName() + '.' + r6.getMethodName() + ':' + r6.getLineNumber();
        if (r7 == null) goto L7;
        return (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
    L7:
        o.a(r0);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
    }
}
