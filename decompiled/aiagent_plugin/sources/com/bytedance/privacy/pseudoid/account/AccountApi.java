package com.bytedance.privacy.pseudoid.account;

import com.bytedance.privacy.bridge.IAccountBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: AccountApi.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AccountApi {
    public static final AccountApi INSTANCE = null;
    private static final String TAG = "AccountApi";
    private static IAccountBridge mAccountBridge;

    static {
        INSTANCE = new AccountApi();
    }

    private AccountApi() {
    }

    public static final void init(IAccountBridge r2) {
        IAccountBridge r3 = (IAccountBridge) ZeusTransformUtils.wrapperContextForParams(r2, IAccountBridge.class, "com.obric.aiagent.plugin");
        o.e(r3, "callback");
        mAccountBridge = r3;
    }

    public final String getUserId() {
        IAccountBridge r0 = mAccountBridge;
        if (r0 == null) goto L5;
        String r1 = r0.onGetUserId();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean isLogin() {
        IAccountBridge r0 = mAccountBridge;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onIsAccountLogin();
    }

    public final Map<String, String> getXttTokenMap() {
        Map<String, String> r1 = ao.b();
        IAccountBridge r0 = mAccountBridge;
        if (r0 == null) goto L5;
        Map<String, String> r2 = r0.onGetXttTokenMap();
    L6:
        if (r2 != null) goto L9;
        return r1;
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public final String getDeviceId() {
        IAccountBridge r0 = mAccountBridge;
        if (r0 == null) goto L5;
        String r1 = r0.onGetDeviceId();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getUDID() {
        IAccountBridge r0 = mAccountBridge;
        if (r0 == null) goto L5;
        String r1 = r0.onGetUDID();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
