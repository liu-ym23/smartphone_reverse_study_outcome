package com.bytedance.android.livesdkapi.vsplayer;

import android.widget.FrameLayout;
import cjc.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import tic.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0014\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000fH&J\b\u0010\u0014\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\nH&J\b\u0010\u0017\u001a\u00020\u000fH&J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0006H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000fH&J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H&J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H&¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/IVSVideoPlayer;", "", "", "videoInfo", "Landroid/widget/FrameLayout;", KtvSubElement.CONTAINER, "", "progress", "Ltic/a;", "playEntity", "", "play", "Lcom/bytedance/android/livesdkapi/vsplayer/VSVideoPlayerConfiger;", "playerConfiger", "setPlayerConfiger", "", ITTVideoEngineEventSource.KEY_MUTE, "setMute", "loop", "setLoop", "pause", "resume", "release", "isPlaying", "position", "seek", "Lqic/d;", "getVideoSnapshotInfo", "releaseEnable", "setReleaseEnable", "tag", "subTag", "setTag", "Lcjc/d;", "callback", "getVideoFrame", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSVideoPlayer {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void setPlayerConfiger$default(IVSVideoPlayer r100, VSVideoPlayerConfiger r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.setPlayerConfiger(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPlayerConfiger");
        }

        public static /* synthetic */ void play$default(IVSVideoPlayer r100, String r101, FrameLayout r102, long r103, a r110, int r111, Object r112) {
            if (r112 != null) goto L9;
            if ((r111 & 8) == 0) goto L6;
            r110 = null;
        L6:
            r100.play(r101, r102, r103, r110);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
        }
    }

    void getVideoFrame(d r100);

    qic.d getVideoSnapshotInfo();

    boolean isPlaying();

    void pause();

    void play(String r100, FrameLayout r101, long r102, a r103);

    void release();

    void resume();

    void seek(long r100);

    void setLoop(boolean r100);

    void setMute(boolean r100);

    void setPlayerConfiger(VSVideoPlayerConfiger r100);

    void setReleaseEnable(boolean r100);

    void setTag(String r100, String r101);
}
