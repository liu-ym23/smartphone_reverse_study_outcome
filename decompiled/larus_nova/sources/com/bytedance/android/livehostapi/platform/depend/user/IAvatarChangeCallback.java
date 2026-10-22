package com.bytedance.android.livehostapi.platform.depend.user;

import com.bytedance.android.live.base.model.user.IUser;

/* JADX INFO: loaded from: classes7.dex */
public interface IAvatarChangeCallback {
    void onChangeSuccess(IUser r100);

    void onChangeUserFailed(Exception r100);

    void onUploadAvatarReject();

    void onUploadFailed(Exception r100);
}
