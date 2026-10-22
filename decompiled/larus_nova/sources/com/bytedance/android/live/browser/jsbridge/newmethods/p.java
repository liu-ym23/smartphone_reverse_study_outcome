package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.newmethods.PreDownloadGameResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.w9;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes45.dex */
public abstract class p<P extends w9, R extends PreDownloadGameResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public p() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
