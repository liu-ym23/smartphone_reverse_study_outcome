package com.bytedance.android.service.manager.permission.boot;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import org.json.JSONObject;
import v77.a;

/* JADX INFO: loaded from: classes3.dex */
public class IPermissionBootExternalServiceImplOfMock implements IPermissionBootExternalService {
    public IPermissionBootExternalServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public BusinessCustomSysAlertDialogStatus allowBusinessCustomSysAlertDialog(Context r100) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public GoogleCustomSysAlertDialogStatus allowGoogleCustomSysAlertDialog(Context r100) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public a getCustomSysDialogConfig(Context r100) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public void initOnApplication() {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public void onNotificationPermissionDialogClickResult(String r100, String r101, int r102, int r103, boolean r104, String r105, int r106, JSONObject r107) {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public void onNotificationPermissionDialogRequestResultEvent(String r100, String r101, int r102, int r103, boolean r104, String r105) {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public boolean openSysPushSettingsPage(String r100, Activity r101, ISysPermissionPageCallback r102) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public boolean openSysPushSettingsPage(String r100, Activity r101, LottieAnimatorModel r102, ISysPermissionPageCallback r103) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public void reportDefaultNotificationStatus() {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public boolean requestNotificationPermissionByBusinessAlert(String r100, View r101, boolean r102, IOriginSysDialog r103) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public void requestNotificationPermissionByGoogleAlert(String r100, View r101, boolean r102, boolean r103, boolean r104, RequestResultCallback r105) {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public boolean sdkNeedRequestSettings() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public boolean shouldOpenSysPushSettingsByPushSdk(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public PushPermissionBootShowResult tryShowPushPermissionBoot(PermissionBootRequestParam r100) {
        return null;
    }
}
