package com.bytedance.android.livesdk.vscore_api.paidlive;

import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;

/* JADX INFO: loaded from: classes11.dex */
public interface d {
    com.bytedance.live.datacontext.m<Long> getCameraId();

    com.bytedance.live.datacontext.m<Integer> getCleanMode();

    ILiveMode getLiveMode();

    com.bytedance.live.datacontext.j<vlc.d> getMessageManager();

    com.bytedance.live.datacontext.m<Boolean> getPaymentPanelShowing();

    com.bytedance.live.datacontext.m<Boolean> getTicketConversionCardNeedAutoOpen();

    com.bytedance.live.datacontext.m<? extends Boolean> isCleanMode();

    com.bytedance.live.datacontext.m<? extends Boolean> isPortraitInteraction();

    boolean isVSFirstShow();

    void stop();
}
