package com.bytedance.android.livehostapi.business.depend.xplay;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayPlayerCallback;", "Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayInstanceCallback;", "onCloudPlayerList", "", "players", "", "", LynxVideoManagerLite.EVENT_ON_ERROR, "error", "message", "onInitFail", "code", "", "onInitReqSuccess", "onInitSuccess", "onPlayEvent", "event", "Lcom/bytedance/android/livehostapi/business/depend/xplay/PlayerEvent;", "onPlayFail", "err", "onPlaySuccess", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IXplayPlayerCallback extends IXplayInstanceCallback {
    void onCloudPlayerList(List<String> r100);

    void onError(String r100, String r101);

    void onInitFail(int r100, String r101);

    void onInitReqSuccess();

    void onInitSuccess();

    void onPlayEvent(PlayerEvent r100);

    void onPlayFail(int r100, String r101);

    void onPlaySuccess();
}
