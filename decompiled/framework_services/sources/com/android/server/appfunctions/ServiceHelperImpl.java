package com.android.server.appfunctions;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes.dex */
class ServiceHelperImpl implements ServiceHelper {
    private final Context mContext;

    ServiceHelperImpl(Context context) {
        context.getClass();
        this.mContext = context;
    }

    @Override // com.android.server.appfunctions.ServiceHelper
    public Intent resolveAppFunctionService(String targetPackageName, UserHandle targetUser) {
        Intent serviceIntent = new Intent("android.app.appfunctions.AppFunctionService");
        serviceIntent.setPackage(targetPackageName);
        ResolveInfo resolveInfo = this.mContext.createContextAsUser(targetUser, 0).getPackageManager().resolveService(serviceIntent, 0);
        if (resolveInfo != null) goto L5;
    L12:
        return null;
    L5:
        if (resolveInfo.serviceInfo == null) goto L12;
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if ("android.permission.BIND_APP_FUNCTION_SERVICE".equals(serviceInfo.permission) == true) goto L10;
        return null;
    L10:
        serviceIntent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
        return serviceIntent;
    }
}
