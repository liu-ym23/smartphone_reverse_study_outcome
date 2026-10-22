package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdk.jsbridge.methods.LocalLifeGetBcmChainResultModel;
import com.bytedance.android.livesdk.jsbridge.methods.u1;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes9.dex */
public abstract class j<P extends u1, R extends LocalLifeGetBcmChainResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public j() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
