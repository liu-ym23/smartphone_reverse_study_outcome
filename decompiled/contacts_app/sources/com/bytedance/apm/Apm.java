package com.bytedance.apm;

import android.content.Context;
import com.bytedance.apm.config.ApmInitConfig;
import com.bytedance.apm.config.ApmReportConfig;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.LogBypassStoreEventManager;
import com.bytedance.apm.trace.ITraceListener;
import com.bytedance.apm.trace.TraceConfig;

/* JADX INFO: loaded from: classes2.dex */
public class Apm {

    private static class Holder {
        private static final Apm sInstance = null;

        private Holder() {
        }

        static /* synthetic */ Apm access$000() {
            return sInstance;
        }

        static {
            sInstance = new Apm(null);
        }
    }

    /* synthetic */ Apm(AnonymousClass1 r1) {
        this();
    }

    public static Apm getInstance() {
        return Holder.access$000();
    }

    @Deprecated
    public Apm traceConfig(TraceConfig r2) {
        ApmDelegate.getInstance().setTraceConfig(r2);
        return this;
    }

    @Deprecated
    public Apm traceListener(ITraceListener r2) {
        ApmDelegate.getInstance().setTraceListener(r2);
        return this;
    }

    public void init(Context r2) {
        ApmDelegate.getInstance().init(r2);
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass1(this));
        return;
    }

    public void init(Context r2, ApmInitConfig r3) {
        ApmDelegate.getInstance().init(r2, r3);
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass2(this));
        return;
    }

    public void start(ApmStartConfig r2) {
        ApmDelegate.getInstance().start(r2);
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass3(this));
        return;
    }

    public void pause() {
        ApmDelegate.getInstance().pause();
    }

    public void resume() {
        ApmDelegate.getInstance().resume();
    }

    public void stop() {
        ApmDelegate.getInstance().stop();
    }

    public static void setReportMode(ApmReportConfig r1) {
        ApmDelegate.getInstance().setReportConfig(r1);
    }

    public ApmStartConfig.Builder newStartConfigBuilder() {
        return ApmDelegate.getInstance().newStartConfigBuilder();
    }

    public void restart(ApmStartConfig r1) {
        ApmDelegate.getInstance().restart(r1);
    }

    public void clearBufferLog() {
        ApmDelegate.getInstance().clearBufferLog();
    }

    public void clearAllLogSync() {
        ApmDelegate.getInstance().clearBufferLogSync();
        ApmDelegate.getInstance().clearLegacyLogSync(-1);
    }

    public void clearLegacyLog(long r1) {
        ApmDelegate.getInstance().clearLegacyLog(r1);
    }

    public void startAllPlugins() {
        ApmDelegate.getInstance().startAllPlugins();
    }

    public void stopAllPlugins() {
        ApmDelegate.getInstance().stopAllPlugins();
    }

    public void destroyAllPlugins() {
        ApmDelegate.getInstance().destroyAllPlugins();
    }

    private Apm() {
    }
}
