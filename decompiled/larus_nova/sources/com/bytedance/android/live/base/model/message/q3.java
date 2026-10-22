package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface q3 {
    boolean canPin();

    Map<String, String> getBuriedPoint();

    String getMessageMethod();

    long getPinBaseMessageId();

    long getPinCommenterId();

    long getPinMessageShowArea();

    IBaseUser getPinUser();
}
