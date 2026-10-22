package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.LogoutResultModel;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;

/* JADX INFO: loaded from: classes43.dex */
public final class x0 implements IUserInfoService.ILogoutStatusCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y0 f38850a;

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService.ILogoutStatusCallback
    public final void onSuccess() {
        y0 r100 = this.f38850a;
        LogoutResultModel r101 = new LogoutResultModel();
        r101.a(LogoutResultModel.Code.Success);
        r101.b("loggedOut success");
        r100.finishWithResult(r101);
    }

    public x0(y0 r100) {
        this.f38850a = r100;
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService.ILogoutStatusCallback
    public final void onFail(String r100) {
        y0 r101 = this.f38850a;
        LogoutResultModel r102 = new LogoutResultModel();
        r102.a(LogoutResultModel.Code.Success);
        if (r100 != null) goto L5;
        r100 = "loggedOut Fail";
    L5:
        r102.b(r100);
        r101.finishWithResult(r102);
    }
}
