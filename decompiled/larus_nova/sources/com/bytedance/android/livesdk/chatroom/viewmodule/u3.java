package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class u3<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u3 f117535a = null;

    static {
        f117535a = new u3();
    }

    public u3() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        TTLiveSDK.hostService().verify().dismissCaptcha();
        Logger.d("VerifyCodeWidget", "showCaptchaV2, dismissCaptcha");
    }
}
