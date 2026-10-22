package com.obric.matrix.sdk.network;

import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.util.Utils;
import org.chromium.CronetAppProviderManager;
import org.chromium.CronetDependManager;

/* JADX INFO: compiled from: TTNetCronetDependAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u001c\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/matrix/sdk/network/TTNetCronetDependAdapter;", "Lcom/bytedance/ttnet/cronet/AbsCronetDependAdapter;", "()V", "getAppId", "", "getAppName", "getCarrierRegion", "getChannel", Utils.METHOD_GET_DEVICE_ID, "getManifestVersionCode", "getOpaqueData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getRegion", "getStoreIdc", "getSysRegion", "getUpdateVersionCode", "getUserId", "getVersionCode", "getVersionName", "inJect", "", "loggerDebug", "", "sendAppMonitorEvent", "logContent", "logType", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TTNetCronetDependAdapter extends AbsCronetDependAdapter {
    public static final TTNetCronetDependAdapter INSTANCE = null;

    static {
        INSTANCE = new TTNetCronetDependAdapter();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCarrierRegion() {
        return null;
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
    public String getUserId() {
        return "null";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        return false;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void sendAppMonitorEvent(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "logContent");
        Intrinsics.checkNotNullParameter(r2, "logType");
    }

    private TTNetCronetDependAdapter() {
    }

    public final void inJect() {
        CronetDependManager.inst().setAdapter(this);     // Catch: Throwable -> L4
        CronetAppProviderManager.inst().setAdapter(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw th;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceId() {
        return NetworkSDKInit.INSTANCE.getConfig().getDid();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppId() {
        return String.valueOf(NetworkSDKInit.INSTANCE.getConfig().getAppId());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppName() {
        return NetworkSDKInit.INSTANCE.getConfig().getAppName();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getChannel() {
        return NetworkSDKInit.INSTANCE.getConfig().getChannel();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionCode() {
        return String.valueOf(NetworkSDKInit.INSTANCE.getConfig().getVersionCode());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionName() {
        return NetworkSDKInit.INSTANCE.getConfig().getVersionName();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUpdateVersionCode() {
        return String.valueOf(NetworkSDKInit.INSTANCE.getConfig().getVersionCode());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter, com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getManifestVersionCode() {
        return String.valueOf(NetworkSDKInit.INSTANCE.getConfig().getVersionCode());
    }
}
