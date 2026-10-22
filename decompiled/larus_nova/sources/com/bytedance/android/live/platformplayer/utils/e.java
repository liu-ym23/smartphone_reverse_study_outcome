package com.bytedance.android.live.platformplayer.utils;

import android.os.CountDownTimer;
import androidx.camera.core.RetryPolicy;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class e extends CountDownTimer {
    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
    }

    public e() {
        super(RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        if (com.bytedance.android.live.core.setting.b.f65214a.getValue().booleanValue() == false) goto L6;
        f2.b(R.string.ttlive_toast_network_exception_and_retry_later, 0);
        com.bytedance.android.livesdk.chatroom.helper.h.a(3);
        return;
    }
}
