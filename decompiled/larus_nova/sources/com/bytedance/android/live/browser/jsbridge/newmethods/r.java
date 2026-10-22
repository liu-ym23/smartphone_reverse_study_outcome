package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.newmethods.RequestOrientationPermissionResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.cb;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes45.dex */
public abstract class r<P extends cb, R extends RequestOrientationPermissionResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public r() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
