package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdk.jsbridge.methods.OpenLiveLifeGrouponPageResultModel;
import com.bytedance.android.livesdk.jsbridge.methods.s2;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes9.dex */
public abstract class n<P extends s2, R extends OpenLiveLifeGrouponPageResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public n() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
