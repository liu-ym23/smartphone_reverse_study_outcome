package com.bytedance.apm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements ff7.i, IConfigListener, ff7.c, bt3.b.e {
    private volatile JSONObject mAllowLogType;
    private volatile JSONObject mAllowService;
    private JSONObject mConfigData;
    private boolean mConfigReady;
    private boolean mIsFront;
    private volatile JSONObject mMetricType;

    public e() {
    }

    public String getTag() {
        return "base";
    }

    @Override // ff7.i
    public void init(Context r100) {
    }

    @Override // ff7.i
    public abstract boolean isOnlyMainProcess();

    @Override // ff7.c
    public void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // ff7.c
    public void onActivityPause(Activity r100) {
    }

    @Override // ff7.c
    public void onActivityResume(Activity r100) {
    }

    @Override // ff7.c
    public void onActivityStarted(Activity r100) {
    }

    @Override // ff7.c
    public void onChange(Activity r100, Fragment r101) {
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        this.mConfigReady = true;
    }

    @Override // bt3.b.e
    public void onTimeEvent(long r100) {
    }

    @Override // ff7.i
    public void start() {
    }

    public void stop() {
    }

    public final boolean registerAppLifeCycle() {
        IActivityLifeManager r100 = (IActivityLifeManager) ServiceManager.getService(IActivityLifeManager.class);
        if (r100 == null) goto L6;
        r100.register(this);
        return true;
    L6:
        return false;
    }

    public final boolean registerConfigService() {
        IConfigManager r100 = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        if (r100 == null) goto L6;
        r100.registerConfigListener(this);
        return true;
    L6:
        return false;
    }

    public final void registerTimerTask() {
        bt3.b.d.f20539a.a(this);
    }

    public final boolean unregisterAppLifeCycle() {
        IActivityLifeManager r100 = (IActivityLifeManager) ServiceManager.getService(IActivityLifeManager.class);
        if (r100 == null) goto L6;
        r100.unregister(this);
        return true;
    L6:
        return false;
    }

    public final boolean unregisterConfigService() {
        IConfigManager r100 = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        if (r100 == null) goto L6;
        r100.unregisterConfigListener(this);
        return true;
    L6:
        return false;
    }

    public final void unregisterTimerTask() {
        bt3.b.d.f20539a.i(this);
    }

    private void ensureUnregisterForSafety() {
        unregisterAppLifeCycle();
        unregisterConfigService();
        unregisterTimerTask();
    }

    public void destroy() {
        ensureUnregisterForSafety();
    }

    public boolean isConfigReady() {
        return this.mConfigReady;
    }

    public boolean isFront() {
        return this.mIsFront;
    }

    public boolean getConfigBool(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        JSONObject r101 = this.mConfigData;
        if (r101 != null) goto L8;
        return false;
    L8:
        return r101.optBoolean(r100);
    L9:
        return false;
    }

    public JSONObject getConfigJSON(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        JSONObject r101 = this.mConfigData;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.optJSONObject(r100);
    L9:
        return null;
    }

    public boolean getLogTypeSwitch(String r100) {
        if (this.mAllowLogType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return false;
    L8:
        if (this.mAllowLogType.optInt(r100) != 1) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean getMetricTypeSwitch(String r100) {
        if (this.mMetricType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return false;
    L8:
        if (this.mMetricType.optInt(r100) != 1) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean getServiceSwitch(String r100) {
        if (this.mAllowService != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return false;
    L8:
        if (this.mAllowService.optInt(r100) != 1) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // ff7.c
    public void onBackground(Activity r100) {
        this.mIsFront = false;
    }

    @Override // ff7.c
    public void onFront(Activity r100) {
        this.mIsFront = true;
    }

    public int getConfigInt(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        JSONObject r102 = this.mConfigData;
        if (r102 == null) goto L9;
        return r102.optInt(r100, r101);
    L9:
        return r101;
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r100, boolean r101) {
        this.mConfigData = r100;
        JSONObject r102 = r100.optJSONObject("custom_event_settings");
        if (r102 == null) goto L6;
        this.mAllowLogType = r102.optJSONObject("allow_log_type");
        this.mMetricType = r102.optJSONObject("allow_metric_type");
        this.mAllowService = r102.optJSONObject("allow_service_name");
        return;
    }
}
