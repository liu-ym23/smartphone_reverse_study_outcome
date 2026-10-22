package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import com.bytedance.android.livesdk.jsbridge.methods.subscribe.VipRecordResultModel;
import com.bytedance.android.livesdk.jsbridge.methods.subscribe.k;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a<P extends k, R extends VipRecordResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
