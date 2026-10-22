package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.hybrid_impl.jsb.GameGetExplainCardEnterRoomDataResultModel;
import com.bytedance.android.gamecp.hybrid_impl.jsb.t2;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes44.dex */
public abstract class k<P extends t2, R extends GameGetExplainCardEnterRoomDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public k() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
