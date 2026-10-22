package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;

/* JADX INFO: loaded from: classes45.dex */
public interface u3 {
    IPublicAreaCommon getOrInitPublicAreaCommon();

    IBaseUser getUserInMessage();
}
