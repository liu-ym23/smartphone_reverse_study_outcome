package com.bytedance.android.service.manager.permission.boot;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import org.json.JSONObject;
import v77.a;

/* JADX INFO: loaded from: classes3.dex */
@ExternalService
public interface IPermissionBootExternalService {
    BusinessCustomSysAlertDialogStatus allowBusinessCustomSysAlertDialog(Context r100);

    GoogleCustomSysAlertDialogStatus allowGoogleCustomSysAlertDialog(Context r100);

    a getCustomSysDialogConfig(Context r100);

    void initOnApplication();

    void onNotificationPermissionDialogClickResult(String r100, String r101, int r102, int r103, boolean r104, String r105, int r106, JSONObject r107);

    void onNotificationPermissionDialogRequestResultEvent(String r100, String r101, int r102, int r103, boolean r104, String r105);

    boolean openSysPushSettingsPage(String r100, Activity r101, ISysPermissionPageCallback r102);

    boolean openSysPushSettingsPage(String r100, Activity r101, LottieAnimatorModel r102, ISysPermissionPageCallback r103);

    void reportDefaultNotificationStatus();

    boolean requestNotificationPermissionByBusinessAlert(String r100, View r101, boolean r102, IOriginSysDialog r103);

    void requestNotificationPermissionByGoogleAlert(String r100, View r101, boolean r102, boolean r103, boolean r104, RequestResultCallback r105);

    boolean sdkNeedRequestSettings();

    boolean shouldOpenSysPushSettingsByPushSdk(Context r100);

    PushPermissionBootShowResult tryShowPushPermissionBoot(PermissionBootRequestParam r100);
}
