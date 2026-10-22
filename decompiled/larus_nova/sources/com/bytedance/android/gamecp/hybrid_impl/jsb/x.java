package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.hybrid_impl.jsb.p3;
import com.bytedance.android.gamecp.hybrid_impl.jsb.q3;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes44.dex */
public abstract class x<P extends p3, R extends q3> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public x() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
