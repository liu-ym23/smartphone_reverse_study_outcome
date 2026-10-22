package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: classes11.dex */
public interface ac extends com.bytedance.android.live.base.model.message.t, com.bytedance.android.live.base.model.message.u3 {
    boolean M1();

    String getContent();

    long getCount();

    long getMaxCount();

    IBaseUser getUser();

    void u1();
}
