package com.bytedance.android.livehostapi.platform.depend.user;

import com.bytedance.android.live.base.model.user.UploadResult;

/* JADX INFO: loaded from: classes7.dex */
public interface IUploadAvatarTaskCallback {
    void onCancel();

    void onUploadAvatarFail(Throwable r100);

    void onUploadAvatarSuccess(UploadResult r100);
}
