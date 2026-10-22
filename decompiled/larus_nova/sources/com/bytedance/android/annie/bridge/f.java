package com.bytedance.android.annie.bridge;

import com.bytedance.android.annie.bridge.UploadFileResultModel;
import com.bytedance.android.annie.bridge.u;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes43.dex */
public abstract class f<P extends u, R extends UploadFileResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
