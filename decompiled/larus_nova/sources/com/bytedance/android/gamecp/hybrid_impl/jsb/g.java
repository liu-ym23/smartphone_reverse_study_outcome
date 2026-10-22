package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.hybrid_impl.jsb.GameCpAnchorPrivacyResultModel;
import com.bytedance.android.gamecp.hybrid_impl.jsb.x1;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes44.dex */
public abstract class g<P extends x1, R extends GameCpAnchorPrivacyResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public g() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
