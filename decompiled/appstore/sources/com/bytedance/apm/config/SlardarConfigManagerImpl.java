package com.bytedance.apm.config;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import h1.f;
import j2.a;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private f mSlardarConfigFetcher;

    public SlardarConfigManagerImpl() {
        this.mSlardarConfigFetcher = new f();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void fetchConfig() {
        this.mSlardarConfigFetcher.o();
    }

    @WorkerThread
    public void forceUpdateFromRemote(@Nullable IQueryParams r10, @Nullable List<String> r11) {
        this.mSlardarConfigFetcher.f(r10, r11);
    }

    @Nullable
    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.g();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public int getConfigInt(String r10, int r11) {
        return this.mSlardarConfigFetcher.h(r10, r11);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    @Nullable
    public JSONObject getConfigJSON(String r10) {
        return this.mSlardarConfigFetcher.i(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getLogTypeSwitch(String r10) {
        return this.mSlardarConfigFetcher.j(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getMetricTypeSwitch(String r10) {
        return this.mSlardarConfigFetcher.k(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getServiceSwitch(String r10) {
        return this.mSlardarConfigFetcher.l(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getSwitch(String r10) {
        return this.mSlardarConfigFetcher.m(r10);
    }

    public void initParams(boolean r10, IQueryParams r11, List<String> r12) {
        this.mSlardarConfigFetcher.p(r10, r11, r12);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.u();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public String queryConfig() {
        return this.mSlardarConfigFetcher.x();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerConfigListener(IConfigListener r10) {
        this.mSlardarConfigFetcher.c(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerResponseConfigListener(IResponseConfigListener r10) {
        a.c(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject retrieveSettingsParams() {
        return this.mSlardarConfigFetcher.C();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterConfigListener(IConfigListener r10) {
        this.mSlardarConfigFetcher.B(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterResponseConfigListener(IResponseConfigListener r10) {
        a.d(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean updateWithSpecificAidResult(JSONObject r10) {
        return this.mSlardarConfigFetcher.H(r10);
    }
}
