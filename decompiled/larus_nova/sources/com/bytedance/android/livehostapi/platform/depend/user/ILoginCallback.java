package com.bytedance.android.livehostapi.platform.depend.user;

import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: classes7.dex */
public interface ILoginCallback {
    void onCancel(Throwable r100);

    void onSuccess(IBaseUser r100);
}
