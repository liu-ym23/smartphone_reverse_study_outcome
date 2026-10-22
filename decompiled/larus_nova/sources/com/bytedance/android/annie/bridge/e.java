package com.bytedance.android.annie.bridge;

import com.bytedance.android.annie.bridge.ShowModalResultModel;
import com.bytedance.android.annie.bridge.t;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes43.dex */
public abstract class e<P extends t, R extends ShowModalResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public e() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
