package com.bytedance.android.livehostapi.hostdefault;

import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livehostapi.utils.ContinuationHelperKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultPermissionRequestListener implements IMiddlewareHostAction.PermissionRequestListener {
    public DefaultPermissionRequestListener() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public void beforeRequest() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public void noNeedToRequest() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public void onPermissionDenied(String[] r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public void onPermissionGrant(String[] r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public boolean retry(String[] r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public void goToAppSetting(Continuation<Boolean> r100, String[] r101) {
        ContinuationHelperKt.resumeInJava(r100, Boolean.FALSE);
    }
}
