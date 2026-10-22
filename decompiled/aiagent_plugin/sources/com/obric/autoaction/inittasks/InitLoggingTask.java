package com.obric.autoaction.inittasks;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.logging.ILogger;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: InitOLogTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitLoggingTask implements IInitTask {
    public static final Companion Companion = null;
    public static final String ID = "INIT_OLOG_TASK";

    /* JADX INFO: compiled from: InitOLogTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.inittasks.InitLoggingTask$getAIAgentLoggingImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: InitOLogTask.kt */
    public static final class AnonymousClass1 implements ILogger {
        public static /* synthetic */ x lambda$r50JBN_L5qjNFX8BCxi0JqzyMeI(b r0, boolean r1, int r2, String r3) {
            return uploadAllLog$lambda$0(r0, r1, r2, r3);
        }

        AnonymousClass1() {
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

        @Override // com.obric.autogui.common.api.logging.ILogger
        public boolean isDebug() {
            return ILogDepend.Companion.isDebug();
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void v(String r1, String r2) {
            o.e(r1, "tag");
            ILogDepend.Companion.v(r1, r2);
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void d(String r1, String r2) {
            o.e(r1, "tag");
            ILogDepend.Companion.d(r1, r2);
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void i(String r1, String r2) {
            o.e(r1, "tag");
            ILogDepend.Companion.i(r1, r2);
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void w(String r1, String r2) {
            o.e(r1, "tag");
            ILogDepend.Companion.w(r1, r2);
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void w(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            ILogDepend.Companion.w(r1, r2, r3);
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void w(String r1, Throwable r2) {
            o.e(r1, "tag");
            ILogDepend.Companion.w(r1, r2);
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void e(String r1, String r2) {
            o.e(r1, "tag");
            ILogDepend.Companion.e(r1, r2);
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void e(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            ILogDepend.Companion.e(r1, r2, r3);
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public String getDirPath() {
            return ILogDepend.Companion.getDirPath();
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void uploadAllLog(String r2, b<? super Boolean, x> r3) {
            final b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
            o.e(r2, DBHelper.BATTERY_COL_SCENE);
            ILogDepend.Companion.uploadAllLog(r2, new $$Lambda$InitLoggingTask$getAIAgentLoggingImpl$1$r50JBN_L5qjNFX8BCxi0JqzyMeI(r1));
        }

        private static final x uploadAllLog$lambda$0(b r1, boolean r2, int r3, String r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r1, b.class, "com.obric.aiagent.plugin");
            o.e(r4, "<unused var>");
            if (r5 == null) goto L6;
            r5.invoke(Boolean.valueOf(r2));
        L6:
            return x.f38692a;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public InitLoggingTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        Loog.INSTANCE.setImpl(getAIAgentLoggingImpl());
        Loog.INSTANCE.d(InitTasks.INIT_OLOG, "[THE-NEW-OLOG] initialized the-new-OLog.");
    }

    private final ILogger getAIAgentLoggingImpl() {
        return (ILogger) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), ILogger.class, "com.obric.aiagent.plugin");
    }
}
