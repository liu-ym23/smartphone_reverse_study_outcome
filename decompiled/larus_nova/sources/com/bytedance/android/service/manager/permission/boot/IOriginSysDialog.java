package com.bytedance.android.service.manager.permission.boot;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.common.push.interfaze.RequestResultCallback;

/* JADX INFO: loaded from: classes12.dex */
public interface IOriginSysDialog extends RequestResultCallback {
    int getPushType();

    void onActivityResult(int r100, int r101, Intent r102);

    @Override // com.bytedance.common.push.interfaze.RequestResultCallback
    /* synthetic */ void onRequestResult(boolean r100, String r101);

    @Override // com.bytedance.common.push.interfaze.RequestResultCallback
    /* synthetic */ void onUserAgree(boolean r100);

    @Override // com.bytedance.common.push.interfaze.RequestResultCallback
    /* synthetic */ void onUserReject();

    void showOriginSysDialog(Activity r100, RequestResultCallback r101);
}
