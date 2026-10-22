package com.bytedance.apm.perf;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractPerfCollector implements IActivityLifeObserver, IConfigListener, AsyncEventManager.IMonitorTimeTask {
    private static final String TAG = "AbstractPerfCollector";
    private boolean mBackground;
    protected String mCollectorSettingKey;
    private boolean mInited;
    private boolean mReady;
    private boolean mStarted;
    private long workLastTimeStamp;

    protected void doConfig(JSONObject r1) {
    }

    protected abstract boolean isTimerMonitor();

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityPause(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityStarted(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r1, Fragment r2) {
    }

    protected void onDestroy() {
    }

    protected void onInit() {
    }

    protected void onStart() {
    }

    protected void onStop() {
    }

    protected abstract long workInternalMs();

    public AbstractPerfCollector() {
    }

    public final void init() {
        if (this.mInited == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.mCollectorSettingKey) == true) goto L12;
        this.mInited = true;
        ActivityLifeObserver.getInstance().register(this);
        this.mBackground = !ActivityLifeObserver.getInstance().isForeground();
        onInit();
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(this);
        if (ApmContext.isDebugMode() == false) goto L13;
        Logger.d(TAG, new String[]{"perf init: " + this.mCollectorSettingKey});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("Must set collector Setting key, before init");
    }

    private final void start() {
        if (this.mStarted == true) goto L7;
        this.mStarted = true;
        if (isTimerMonitor() == false) goto L7;
        AsyncEventManager.getInstance().addTimeTask(this);
    L7:
        onStart();
        this.workLastTimeStamp = System.currentTimeMillis();
    }

    public final void stop() {
        if (this.mStarted == false) goto L7;
        this.mStarted = false;
        if (isTimerMonitor() == false) goto L7;
        AsyncEventManager.getInstance().removeTimeTask(this);
    L7:
        onStop();
    }

    public final void destroy() {
        ActivityLifeObserver.getInstance().unregister(this);
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).unregisterConfigListener(this);
        onDestroy();
    }

    protected boolean isConfigReady() {
        return this.mReady;
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public final void onTimeEvent(long r5) {
        long r0 = workInternalMs();
        if (r0 > 0) goto L5;
        return;
    L5:
        if ((r5 - this.workLastTimeStamp) > r0) goto L7;
        return;
    L7:
        if (this.mReady == false) goto L12;
        onStart();
        this.workLastTimeStamp = System.currentTimeMillis();
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r1, boolean r2) {
        JSONObject r3 = r1.optJSONObject("performance_modules");
        if (r3 != null) goto L5;
        return;
    L5:
        JSONObject r4 = r3.optJSONObject(this.mCollectorSettingKey);
        if (r4 != null) goto L8;
        return;
    L8:
        doConfig(r4);
    }

    public void onReady() {
        this.mReady = true;
        start();
    }

    protected boolean isBackground() {
        return this.mBackground;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        this.mBackground = false;
        if (ApmContext.isStopWhenBackground() == true) goto L5;
        return;
    L5:
        if (this.mReady == false) goto L9;
        start();
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        this.mBackground = true;
        if (ApmContext.isStopWhenBackground() == false) goto L6;
        stop();
        return;
    }

    protected void sendPerfLog(PerfData r1) {
        CommonDataAssembly.wrapPerfStatus(r1);
        CommonDataAssembly.wrapFilters(r1, r1.isAddDeviceInfo());
        CommonDataPipeline.getInstance().handle(r1);
    }
}
