package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.hybrid_impl.jsb.PreloadInteractGameResultModel;
import com.bytedance.android.gamecp.hybrid_impl.jsb.r5;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes44.dex */
public abstract class v0<P extends r5, R extends PreloadInteractGameResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public v0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
