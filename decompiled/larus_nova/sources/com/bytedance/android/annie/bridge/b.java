package com.bytedance.android.annie.bridge;

import com.bytedance.android.annie.bridge.ChooseMediaResultModel;
import com.bytedance.android.annie.bridge.i;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes43.dex */
public abstract class b<P extends i, R extends ChooseMediaResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
