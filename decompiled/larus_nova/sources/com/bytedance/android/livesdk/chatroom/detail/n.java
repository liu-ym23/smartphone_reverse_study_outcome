package com.bytedance.android.livesdk.chatroom.detail;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements Consumer<Throwable> {
    public n() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        Throwable r101 = r100;
        if (("generateBackendWrapperData error: " + r101) == null) goto L5;
        String r102 = r101.getMessage();
    L6:
        ALogger.i("EnterRoomController", r102);
        return;
    L5:
        r102 = "null";
        goto L6
    }
}
