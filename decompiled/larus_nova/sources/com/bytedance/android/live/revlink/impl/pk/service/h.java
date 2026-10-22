package com.bytedance.android.live.revlink.impl.pk.service;

import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdk.link.model.bridge.f0;

/* JADX INFO: loaded from: classes47.dex */
public interface h {

    public static final class a {
        public static /* synthetic */ void a(h r100, Integer r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            r100.finishInteract(null, r101);
        }
    }

    void finish(String r100);

    void finishInteract(String r100, Integer r101);

    LiveData<Boolean> getGuestMuteState();

    oq2.d getPkLayoutData(boolean r100);

    void handlePkRoomClose(boolean r100);

    void onLynxMicInteractionEvent(int r100);

    void receiveChorusMessage(f0 r100);

    void sendGuestKickOut(String r100, String r101);
}
