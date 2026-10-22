package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.hybrid_impl.jsb.GetGameCPCurrentExplainPropInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a0<P extends JsonObject, R extends GetGameCPCurrentExplainPropInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
