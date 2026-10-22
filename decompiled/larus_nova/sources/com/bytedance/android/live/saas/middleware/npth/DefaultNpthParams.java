package com.bytedance.android.live.saas.middleware.npth;

import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.crash.ICommonParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/npth/DefaultNpthParams;", "Lcom/bytedance/crash/ICommonParams;", "()V", "getCommonParams", "", "", "", "getDeviceId", "middleware_release"}, k = 1, mv = {1, 4, 3})
public abstract class DefaultNpthParams implements ICommonParams {
    public DefaultNpthParams() {
    }

    @Override // com.bytedance.crash.ICommonParams
    public Map<String, Object> getCommonParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        IAppInfo r101 = BDLiveSdk.getAppInfo();
        if (r101 == null) goto L5;
        r100.put("aid", Integer.valueOf(r101.appId()));
        r100.put("update_version_code", Integer.valueOf(r101.versionCode()));
        r100.put("version_code", r101.versionName());
        r100.put("channel", r101.channel());
    L5:
        return r100;
    }

    @Override // com.bytedance.crash.ICommonParams
    public String getDeviceId() {
        if (BDLiveSdk.getAppInfo() == null) goto L5;
        IAppInfo r100 = BDLiveSdk.getAppInfo();
        Intrinsics.checkNotNull(r100);
        return r100.devicesId();
    L5:
        return "";
    }
}
