package com.obric.network.ttnet;

import com.bytedance.apm.ApmAgent;
import com.bytedance.ies.common.cpp_shared.BuildConfig;
import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import obric.util.Utils;
import org.chromium.CronetAppProviderManager;
import org.chromium.CronetDependManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTNetCronetDependAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/network/ttnet/TTNetCronetDependAdapter;", "Lcom/bytedance/ttnet/cronet/AbsCronetDependAdapter;", "()V", "getAppId", "", "getAppName", "getCarrierRegion", "getChannel", Utils.METHOD_GET_DEVICE_ID, "getManifestVersionCode", "getOpaqueData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getRegion", "getStoreIdc", "getSysRegion", "getUpdateVersionCode", "getUserId", "getVersionCode", "getVersionName", "inJect", "", "loggerDebug", "", "sendAppMonitorEvent", "logContent", "logType", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TTNetCronetDependAdapter extends AbsCronetDependAdapter {
    public static final TTNetCronetDependAdapter INSTANCE = null;

    static {
        INSTANCE = new TTNetCronetDependAdapter();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppId() {
        return "";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppName() {
        return "incallui";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCarrierRegion() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getChannel() {
        return "local_test";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceId() {
        return "";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getManifestVersionCode() {
        return "";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public ArrayList<byte[]> getOpaqueData() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRegion() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdc() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSysRegion() {
        return null;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUpdateVersionCode() {
        return "incallui";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUserId() {
        return "";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionCode() {
        return "";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        return true;
    }

    private TTNetCronetDependAdapter() {
    }

    public final void inJect() {
        CronetDependManager.inst().setAdapter(this);
        CronetAppProviderManager.inst().setAdapter(this);
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void sendAppMonitorEvent(String r1, String r2) {
        ApmAgent.monitorCommonLog(r2, new JSONObject(r1));     // Catch: JSONException -> L4
        return;
    }
}
