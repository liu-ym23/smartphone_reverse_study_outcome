package com.android.server.wm;

import android.annotation.SystemApi;
import android.os.Binder;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes3.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public class ActivityInterceptorCallbackRegistry {
    private static final ActivityInterceptorCallbackRegistry sInstance = null;

    static {
        sInstance = new ActivityInterceptorCallbackRegistry();
    }

    private ActivityInterceptorCallbackRegistry() {
    }

    public static ActivityInterceptorCallbackRegistry getInstance() {
        return sInstance;
    }

    public void registerActivityInterceptorCallback(int mainlineOrderId, ActivityInterceptorCallback callback) {
        if (getCallingUid() != 1000) goto L14;
        if (ActivityInterceptorCallback.isValidMainlineOrderId(mainlineOrderId) == false) goto L12;
        if (callback == null) goto L10;
        ActivityTaskManagerInternal activityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        activityTaskManagerInternal.registerActivityStartInterceptor(mainlineOrderId, callback);
        return;
    L10:
        throw new IllegalArgumentException("The passed ActivityInterceptorCallback can not be null");
    L12:
        throw new IllegalArgumentException("id is not in the mainline modules range, please useActivityTaskManagerInternal.registerActivityStartInterceptor(OrderedId, ActivityInterceptorCallback) instead.");
    L14:
        throw new SecurityException("Only system server can register ActivityInterceptorCallback");
    }

    public void unregisterActivityInterceptorCallback(int mainlineOrderId) {
        if (getCallingUid() != 1000) goto L11;
        if (ActivityInterceptorCallback.isValidMainlineOrderId(mainlineOrderId) == false) goto L9;
        ActivityTaskManagerInternal activityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        activityTaskManagerInternal.unregisterActivityStartInterceptor(mainlineOrderId);
        return;
    L9:
        throw new IllegalArgumentException("id is not in the mainline modules range, please useActivityTaskManagerInternal.unregisterActivityStartInterceptor(OrderedId) instead.");
    L11:
        throw new SecurityException("Only system server can register ActivityInterceptorCallback");
    }

    int getCallingUid() {
        return Binder.getCallingUid();
    }
}
