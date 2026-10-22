package com.bytedance.android.live.platformplayer.utils;

import android.os.CountDownTimer;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends CountDownTimer {
    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
    }

    public f() {
        super(3000, 3000);
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        if (com.bytedance.android.live.core.setting.b.f65214a.getValue().booleanValue() == false) goto L6;
        f2.b(R.string.ttlive_toast_network_exception_when_watching, 0);
        com.bytedance.android.livesdk.chatroom.helper.h.a(4);
        return;
    }
}
