package com.byted.mgl.merge.service.api.liveplayer.listener;

import com.byted.mgl.merge.service.api.liveplayer.IGameTTLivePlayer;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH&¨\u0006\u001c"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/listener/IGameTTLivePlayerListener;", "", "onCompletion", "", LynxVideoManagerLite.EVENT_ON_ERROR, "error", "Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$LiveError;", LynxVideoManagerLite.EVENT_ON_FIRST_FRAME, "isFirstFrame", "", "onLivePlayerPrepared", "onMonitorLog", "data", "Lorg/json/JSONObject;", "onPlayStateChanged", "state", "Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$PlayerState;", "onResolutionDegrade", "resolution", "", "onSeiUpdate", "message", "onStallEnd", "onStallStart", "onVideoSizeChanged", "videoWidth", "", "videoHeight", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface IGameTTLivePlayerListener {
    void onCompletion();

    void onError(IGameTTLivePlayer.LiveError r100);

    void onFirstFrame(boolean r100);

    void onLivePlayerPrepared();

    void onMonitorLog(JSONObject r100);

    void onPlayStateChanged(IGameTTLivePlayer.PlayerState r100);

    void onResolutionDegrade(String r100);

    void onSeiUpdate(String r100);

    void onStallEnd();

    void onStallStart();

    void onVideoSizeChanged(int r100, int r101);
}
