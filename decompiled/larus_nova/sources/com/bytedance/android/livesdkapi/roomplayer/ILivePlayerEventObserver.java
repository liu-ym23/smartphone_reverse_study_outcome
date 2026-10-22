package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.android.livesdk.player.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerEventObserver;", "", "onBackground", "", "curState", "Lcom/bytedance/android/livesdk/player/State;", "currentResolution", "", "scene", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "onForeground", "onMonitorLog", "player", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "message", "Lorg/json/JSONObject;", "onPlayerCreate", "onPlaying", "onRelease", "onStallEnd", "onStallStart", "onStreamPreparePlay", "request", "Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;", "onStreamTrafficOverUsed", "onVideoRenderStall", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerEventObserver {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onBackground(ILivePlayerEventObserver r100, State r101, String r102, ILivePlayerScene r103) {
            Intrinsics.checkNotNullParameter(r101, "curState");
            Intrinsics.checkNotNullParameter(r102, "currentResolution");
            Intrinsics.checkNotNullParameter(r103, "scene");
        }

        public static void onForeground(ILivePlayerEventObserver r100, State r101) {
            Intrinsics.checkNotNullParameter(r101, "curState");
        }

        public static void onMonitorLog(ILivePlayerEventObserver r100, ILivePlayerClient r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r101, "player");
            Intrinsics.checkNotNullParameter(r102, "message");
        }

        public static void onPlaying(ILivePlayerEventObserver r100, ILivePlayerClient r101) {
            Intrinsics.checkNotNullParameter(r101, "player");
        }

        public static void onRelease(ILivePlayerEventObserver r100) {
        }

        public static void onStallEnd(ILivePlayerEventObserver r100) {
        }

        public static void onStallStart(ILivePlayerEventObserver r100) {
        }

        public static void onStreamPreparePlay(ILivePlayerEventObserver r100, ILivePlayerClient r101, LiveRequest r102) {
            Intrinsics.checkNotNullParameter(r101, "player");
            Intrinsics.checkNotNullParameter(r102, "request");
        }

        public static void onStreamTrafficOverUsed(ILivePlayerEventObserver r100, ILivePlayerClient r101) {
        }

        public static void onVideoRenderStall(ILivePlayerEventObserver r100) {
        }
    }

    void onBackground(State r100, String r101, ILivePlayerScene r102);

    void onForeground(State r100);

    void onMonitorLog(ILivePlayerClient r100, JSONObject r101);

    void onPlayerCreate(ILivePlayerClient r100);

    void onPlaying(ILivePlayerClient r100);

    void onRelease();

    void onStallEnd();

    void onStallStart();

    void onStreamPreparePlay(ILivePlayerClient r100, LiveRequest r101);

    void onStreamTrafficOverUsed(ILivePlayerClient r100);

    void onVideoRenderStall();
}
