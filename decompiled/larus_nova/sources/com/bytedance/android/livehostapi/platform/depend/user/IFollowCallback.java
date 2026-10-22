package com.bytedance.android.livehostapi.platform.depend.user;

/* JADX INFO: loaded from: classes7.dex */
public interface IFollowCallback {
    public static final int FOLLOWING = 1;
    public static final int NOT_FOLLOW = 0;

    void onCancel(Throwable r100);

    void onSuccess(int r100);
}
