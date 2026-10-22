package com.android.server.appbinding;

import android.content.Intent;
import android.content.pm.IPackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.RemoteException;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppBindingUtils {
    private static final String TAG = "AppBindingUtils";

    private AppBindingUtils() {
    }

    public static ServiceInfo findService(String packageName, int userId, String serviceAction, String servicePermission, Class<?> serviceClassForLogging, IPackageManager ipm, StringBuilder errorMessage) {
        String simpleClassName = serviceClassForLogging.getSimpleName();
        Intent intent = new Intent(serviceAction);
        intent.setPackage(packageName);
        errorMessage.setLength(0);
        ParceledListSlice<ResolveInfo> pls = ipm.queryIntentServices(intent, null, 0, userId);     // Catch: RemoteException -> L13
        if (pls == null) goto L20;
        if (pls.getList().size() == 0) goto L20;
        List<ResolveInfo> list = pls.getList();     // Catch: RemoteException -> L13
        if (list.size() <= 1) goto L15;
        errorMessage.append("More than one " + simpleClassName + "'s found in package " + packageName + ".  They'll all be ignored.");     // Catch: RemoteException -> L13
        Log.e(TAG, errorMessage.toString());     // Catch: RemoteException -> L13
        return null;
    L15:
        ServiceInfo si = list.get(0).serviceInfo;     // Catch: RemoteException -> L13
        if (servicePermission.equals(si.permission) == true) goto L19;
        errorMessage.append(simpleClassName + " " + si.getComponentName().flattenToShortString() + " must be protected with " + servicePermission + ".");     // Catch: RemoteException -> L13
        Log.e(TAG, errorMessage.toString());     // Catch: RemoteException -> L13
        return null;
    L19:
        return si;
    L20:
        errorMessage.append("Service with " + serviceAction + " not found.");     // Catch: RemoteException -> L13
        return null;
    L23:
        return null;
    }
}
