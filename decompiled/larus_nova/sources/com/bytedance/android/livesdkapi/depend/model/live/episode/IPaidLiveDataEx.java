package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.livesdkapi.depend.model.live.pay.ITicketData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\nH&J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPaidLiveDataEx;", "", "getAsyncAuthAB", "", "()Ljava/lang/Long;", "getAsyncAuthData", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IAsyncAuthData;", "getDataId", "", "getDataType", "", "getDelivery", "()Ljava/lang/Integer;", "getDuration", "getKeepAliveTime", "getMaxViewDuration", "getShowDeliveryTip", "", "()Ljava/lang/Boolean;", "getSubscribeRoomViewRight", "getSubscribeRoomWatchStatus", "getTicketSession", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ITicketData;", "needRefreshStream", "setKeepAliveTime", "", "keepAliveTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPaidLiveDataEx {
    Long getAsyncAuthAB();

    IAsyncAuthData getAsyncAuthData();

    String getDataId();

    int getDataType();

    /* JADX INFO: renamed from: getDelivery */
    Integer mo8272getDelivery();

    /* JADX INFO: renamed from: getDuration */
    Long mo8273getDuration();

    Long getKeepAliveTime();

    /* JADX INFO: renamed from: getMaxViewDuration */
    Long mo8274getMaxViewDuration();

    Boolean getShowDeliveryTip();

    int getSubscribeRoomViewRight();

    String getSubscribeRoomWatchStatus();

    ITicketData getTicketSession();

    Long needRefreshStream();

    void setKeepAliveTime(long r100);
}
