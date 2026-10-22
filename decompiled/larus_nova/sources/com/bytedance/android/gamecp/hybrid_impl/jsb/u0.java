package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.hybrid_impl.jsb.PreloadHeliumGameResultModel;
import com.bytedance.android.gamecp.hybrid_impl.jsb.q5;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes44.dex */
public abstract class u0<P extends q5, R extends PreloadHeliumGameResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public u0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
