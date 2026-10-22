package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.hybrid_impl.jsb.GameCloseGameDetailResultModel;
import com.bytedance.android.gamecp.hybrid_impl.jsb.u1;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes44.dex */
public abstract class f<P extends u1, R extends GameCloseGameDetailResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
