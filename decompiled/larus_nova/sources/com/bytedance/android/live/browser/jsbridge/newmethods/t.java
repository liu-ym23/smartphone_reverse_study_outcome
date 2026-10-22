package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.newmethods.SendPublicScreenTextMessageResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.wb;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes45.dex */
public abstract class t<P extends wb, R extends SendPublicScreenTextMessageResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public t() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
