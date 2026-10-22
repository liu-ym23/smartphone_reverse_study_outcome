package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.newmethods.bd;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class x<P extends bd, R extends JSONObject> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public x() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
