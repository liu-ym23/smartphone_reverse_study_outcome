package com.android.server.appfunctions;

import android.app.appfunctions.AppFunctionManagerConfiguration;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import com.android.server.LocalServices;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes.dex */
public class AppFunctionManagerService extends SystemService {
    private final AppFunctionManagerServiceImpl mServiceImpl;

    public AppFunctionManagerService(Context context) {
        super(context);
        this.mServiceImpl = new AppFunctionManagerServiceImpl(context, (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class));
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        if (AppFunctionManagerConfiguration.isSupported(getContext()) == false) goto L6;
        publishBinderService("app_function", this.mServiceImpl);
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocked(SystemService.TargetUser user) {
        this.mServiceImpl.onUserUnlocked(user);
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(SystemService.TargetUser user) {
        this.mServiceImpl.onUserStopping(user);
    }
}
