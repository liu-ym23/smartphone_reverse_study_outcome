package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.newmethods.LiveStartDiscoveryServiceResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.d7;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes45.dex */
public abstract class l<P extends d7, R extends LiveStartDiscoveryServiceResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
