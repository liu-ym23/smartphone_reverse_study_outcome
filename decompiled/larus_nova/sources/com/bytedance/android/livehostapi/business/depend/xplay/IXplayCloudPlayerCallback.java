package com.bytedance.android.livehostapi.business.depend.xplay;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH&J\"\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayCloudPlayerCallback;", "Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayInstanceCallback;", LynxVideoManagerLite.EVENT_ON_ERROR, "", "playerName", "", "error", "message", "onPlayEvent", "event", "Lcom/bytedance/android/livehostapi/business/depend/xplay/PlayerEvent;", "onPlayFail", "code", "", "err", "onPlaySuccess", "onVideoFrame", "videoFrame", "Lcom/bytedance/android/livehostapi/business/depend/xplay/IByteRtcVideoFrame;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IXplayCloudPlayerCallback extends IXplayInstanceCallback {
    void onError(String r100, String r101, String r102);

    void onPlayEvent(String r100, PlayerEvent r101);

    void onPlayFail(String r100, int r101, String r102);

    void onPlaySuccess(String r100);

    void onVideoFrame(String r100, IByteRtcVideoFrame r101);
}
