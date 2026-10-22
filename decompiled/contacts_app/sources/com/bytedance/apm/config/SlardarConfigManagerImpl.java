package com.bytedance.apm.config;

import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm6.Apm6;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private SlardarConfigFetcher mSlardarConfigFetcher;

    public SlardarConfigManagerImpl() {
        this.mSlardarConfigFetcher = new SlardarConfigFetcher();
    }

    public void initParams(boolean r1, IQueryParams r2, List<String> r3) {
        this.mSlardarConfigFetcher.initParams(r1, r2, r3);
    }

    public void forceUpdateFromRemote(IQueryParams r1, List<String> r2) {
        this.mSlardarConfigFetcher.forceUpdateFromRemote(r1, r2);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void fetchConfig() {
        this.mSlardarConfigFetcher.initConfig();
    }

    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.getConfigData();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public String queryConfig() {
        return this.mSlardarConfigFetcher.queryFromLocal();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getLogTypeSwitch(String r1) {
        return this.mSlardarConfigFetcher.getLogTypeSwitch(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getServiceSwitch(String r1) {
        return this.mSlardarConfigFetcher.getServiceSwitch(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getMetricTypeSwitch(String r1) {
        return this.mSlardarConfigFetcher.getMetricTypeSwitch(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getSwitch(String r1) {
        return this.mSlardarConfigFetcher.getSwitch(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject getConfigJSON(String r1) {
        return this.mSlardarConfigFetcher.getJson(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public int getConfigInt(String r1, int r2) {
        return this.mSlardarConfigFetcher.getInt(r1, r2);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.isReady();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerConfigListener(IConfigListener r1) {
        this.mSlardarConfigFetcher.addConfigListener(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterConfigListener(IConfigListener r1) {
        this.mSlardarConfigFetcher.removeConfigListener(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerResponseConfigListener(IResponseConfigListener r1) {
        Apm6.registerResponseConfigListener(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterResponseConfigListener(IResponseConfigListener r1) {
        Apm6.unregisterResponseConfigListener(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean updateWithSpecificAidResult(JSONObject r1) {
        return this.mSlardarConfigFetcher.updateWithSpecificAidResult(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject retrieveSettingsParams() {
        return this.mSlardarConfigFetcher.retrieveSettingsParams();
    }
}
