package com.obric.autoaction.hostbridges;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.logging.IAutoActionLoggingApi;
import com.obric.autogui.common.api.logging.ILogger;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: OAutoAIAgentLogging.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OAutoAIAgentLogging implements IAutoActionLoggingApi {
    public static final a Companion = null;
    private static final String TAG = "AOLog";
    private final ILogger sLogger;

    /* JADX INFO: compiled from: OAutoAIAgentLogging.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OAutoAIAgentLogging.kt */
    public static final class b implements ILogger {
        /* JADX INFO: renamed from: lambda$2is71urZqYFOFpo-UiAxCYhmqkk, reason: not valid java name */
        public static /* synthetic */ x m579lambda$2is71urZqYFOFpoUiAxCYhmqkk(d.h.a.b r0, boolean r1, int r2, String r3) {
            return a(r0, r1, r2, r3);
        }

        b() {
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void dp(String r3, d.h.a.a<String> r4) {
            ILogger.DefaultImpls.dp(this, r3, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void dp(String r3, d.h.a.a<String> r4, d.h.a.a<String> r5) {
            ILogger.DefaultImpls.dp(this, r3, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void ep(String r3, d.h.a.a<String> r4, d.h.a.a<String> r5) {
            ILogger.DefaultImpls.ep(this, r3, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void ep(String r3, d.h.a.a<String> r4, d.h.a.a<String> r5, Throwable r6) {
            ILogger.DefaultImpls.ep(this, r3, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"), r6);
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void ip(String r3, d.h.a.a<String> r4, d.h.a.a<String> r5) {
            ILogger.DefaultImpls.ip(this, r3, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.autogui.common.api.logging.ILogger
        public void wp(String r3, d.h.a.a<String> r4, d.h.a.a<String> r5) {
            ILogger.DefaultImpls.wp(this, r3, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"));
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
        public void uploadAllLog(String r2, d.h.a.b<? super Boolean, x> r3) {
            final d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r2, DBHelper.BATTERY_COL_SCENE);
            ILogDepend.Companion.uploadAllLog(r2, new $$Lambda$OAutoAIAgentLogging$b$2is71urZqYFOFpoUiAxCYhmqkk(r1));
        }

        private static final x a(d.h.a.b r1, boolean r2, int r3, String r4) {
            d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r4, "<unused var>");
            if (r5 == null) goto L6;
            r5.invoke(Boolean.valueOf(r2));
        L6:
            return x.f38692a;
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // com.obric.autogui.common.api.logging.IAutoActionLoggingApi
    public void reEvaluateLogPrintingPolicy() {
    }

    @Override // com.obric.autogui.common.api.logging.IAutoActionLoggingApi
    public void triggerLogFlush() {
    }

    public OAutoAIAgentLogging() {
        this.sLogger = getAIAgentLoggingImpl();
    }

    private final ILogger getAIAgentLoggingImpl() {
        return (ILogger) ZeusTransformUtils.preCheckCast(new b(), ILogger.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.logging.IAutoActionLoggingApi
    public void initLoggingModule(Context r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        Loog.INSTANCE.setImpl(this.sLogger);
        com.obric.autogui.common.b.b.f29001a.b();
        Loog.INSTANCE.d(TAG, "Initialized Logs via AIAgent.");
    }

    @Override // com.obric.autogui.common.api.logging.IAutoActionLoggingApi
    public ILogger provideLogger() {
        return this.sLogger;
    }
}
