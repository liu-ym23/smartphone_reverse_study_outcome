package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.LoginResultModel;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;

/* JADX INFO: loaded from: classes43.dex */
public final class v0 implements IUserInfoService.ILoginStatusCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IUserInfoService f38843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w0 f38844b;

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService.ILoginStatusCallback
    public final void onFail() {
        w0 r100 = this.f38844b;
        LoginResultModel r101 = new LoginResultModel();
        r101.b(LoginResultModel.Code.Success);
        r101.a(Boolean.FALSE);
        LoginResultModel.Status r102 = LoginResultModel.Status.Cancelled;
        r101.d(r102.toString());
        r101.c(r102.toString());
        r100.finishWithResult(r101);
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService.ILoginStatusCallback
    public final void onSuccess() {
        this.f38843a.hasLogin();
        w0 r100 = this.f38844b;
        LoginResultModel r101 = new LoginResultModel();
        r101.b(LoginResultModel.Code.Success);
        r101.a(Boolean.FALSE);
        LoginResultModel.Status r102 = LoginResultModel.Status.Cancelled;
        r101.d(r102.toString());
        r101.c(r102.toString());
        r100.finishWithResult(r101);
    }

    public v0(IUserInfoService r100, w0 r101) {
        this.f38843a = r100;
        this.f38844b = r101;
    }
}
