package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdk.jsbridge.methods.UpdateCacheDataResultModel;
import com.bytedance.android.livesdk.jsbridge.methods.t4;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes9.dex */
public abstract class u<P extends t4, R extends UpdateCacheDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public u() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
