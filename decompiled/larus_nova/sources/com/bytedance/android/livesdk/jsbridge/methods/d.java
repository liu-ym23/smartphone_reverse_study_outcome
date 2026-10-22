package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdk.jsbridge.methods.GetLiveLifeCouponInfoResultModel;
import com.bytedance.android.livesdk.jsbridge.methods.y0;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes9.dex */
public abstract class d<P extends y0, R extends GetLiveLifeCouponInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public d() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
