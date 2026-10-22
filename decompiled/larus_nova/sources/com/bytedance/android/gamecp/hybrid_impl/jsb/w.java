package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.hybrid_impl.jsb.GamecpLoadingDialogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class w<P extends JsonObject, R extends GamecpLoadingDialogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public w() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
