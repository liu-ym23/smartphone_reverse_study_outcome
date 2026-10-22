package com.bytedance.apm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseApmWidget.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements com.bytedance.apm.thread.b.InterfaceC0118b, com.bytedance.services.apm.api.d, com.bytedance.services.apm.api.j, com.bytedance.services.slardar.config.a {
    private volatile JSONObject mAllowLogType;
    private volatile JSONObject mAllowService;
    private JSONObject mConfigData;
    private boolean mConfigReady;
    private boolean mIsFront;
    private volatile JSONObject mMetricType;

    public String getTag() {
        return "base";
    }

    @Override // com.bytedance.services.apm.api.j
    public void init(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.j
    public abstract boolean isOnlyMainProcess();

    @Override // com.bytedance.services.apm.api.d
    public void onActivityCreated(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityPause(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityResume(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityStarted(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onChange(Activity r1, Fragment r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.apm.thread.b.InterfaceC0118b
    public void onTimeEvent(long r1) {
    }

    @Override // com.bytedance.services.apm.api.j
    public void start() {
    }

    public void stop() {
    }

    public e() {
    }

    public void destroy() {
        ensureUnregisterForSafety();
    }

    private void ensureUnregisterForSafety() {
        unregisterAppLifeCycle();
        unregisterConfigService();
        unregisterTimerTask();
    }

    public final boolean registerConfigService() {
        IConfigManager r0 = (IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.registerConfigListener(this);
        return true;
    L6:
        return false;
    }

    public final boolean registerAppLifeCycle() {
        IActivityLifeManager r0 = (IActivityLifeManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IActivityLifeManager.class), IActivityLifeManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.register(this);
        return true;
    L6:
        return false;
    }

    public final void registerTimerTask() {
        com.bytedance.apm.thread.b.a().a(this);
    }

    public final boolean unregisterConfigService() {
        IConfigManager r0 = (IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.unregisterConfigListener(this);
        return true;
    L6:
        return false;
    }

    public final boolean unregisterAppLifeCycle() {
        IActivityLifeManager r0 = (IActivityLifeManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IActivityLifeManager.class), IActivityLifeManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.unregister(this);
        return true;
    L6:
        return false;
    }

    public final void unregisterTimerTask() {
        com.bytedance.apm.thread.b.a().b(this);
    }

    public boolean isFront() {
        return this.mIsFront;
    }

    @Override // com.bytedance.services.apm.api.d
    public void onFront(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.mIsFront = true;
    }

    @Override // com.bytedance.services.apm.api.d
    public void onBackground(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.mIsFront = false;
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r1, boolean r2) {
        this.mConfigData = r1;
        JSONObject r3 = r1.optJSONObject("custom_event_settings");
        if (r3 == null) goto L6;
        this.mAllowLogType = r3.optJSONObject("allow_log_type");
        this.mMetricType = r3.optJSONObject("allow_metric_type");
        this.mAllowService = r3.optJSONObject("allow_service_name");
        return;
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
        this.mConfigReady = true;
    }

    public boolean isConfigReady() {
        return this.mConfigReady;
    }

    public boolean getLogTypeSwitch(String r3) {
        if (this.mAllowLogType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mAllowLogType.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean getMetricTypeSwitch(String r3) {
        if (this.mMetricType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mMetricType.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean getServiceSwitch(String r3) {
        if (this.mAllowService != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mAllowService.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean getConfigBool(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.optBoolean(r2);
    L9:
        return false;
    }

    public JSONObject getConfigJSON(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.optJSONObject(r2);
    L9:
        return null;
    }

    public int getConfigInt(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 == null) goto L9;
        return r1.optInt(r2, r3);
    L9:
        return r3;
    }
}
