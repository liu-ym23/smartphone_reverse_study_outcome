package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.hybrid_impl.jsb.GameGetDownloadListResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class j<P extends JsonObject, R extends GameGetDownloadListResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
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
