package com.bytedance.android.annie.service.userinfo;

import android.app.Activity;
import com.bytedance.android.annie.bridge.method.v0;
import com.bytedance.android.annie.bridge.method.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IUserInfoService {
    public a() {
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService
    public final void getUserId() {
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService
    public final void hasLogin() {
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService
    public final void z(Activity r100, x0 r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "logoutStatusCallback");
        r101.onFail("DefaultUserInfoService默认返回");
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService
    public final void z1(Activity r100, v0 r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "loginStatusCallback");
        r101.onFail();
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService
    public final void U(Activity r100, v0 r101, IUserInfoService.LoginParamsExt r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "loginStatusCallback");
        Intrinsics.checkNotNullParameter(r102, "params");
        r101.onFail();
    }
}
