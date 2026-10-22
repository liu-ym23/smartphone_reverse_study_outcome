package com.bytedance.android.livesdkapi.replay;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import cjc.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodePaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.replay.paid.PaidReplayScene;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.Resolution;
import java.util.Map;
import jm1.g;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nic.l;
import tic.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 :2\u00020\u0001:\u0002:;J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0017J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002H'Jp\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&Jp\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&J$\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0003\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH&J$\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00022\b\b\u0003\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH&J\b\u0010\"\u001a\u00020\u000bH&J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0015H&J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%H&J\u0018\u0010,\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*H&J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*H&J\u0018\u0010/\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020.H&J\u0018\u00100\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020.H&J\u0016\u00103\u001a\u00020\u000b2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b01H&R\u001c\u00107\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001048&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001c\u00109\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001048&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00106¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdkapi/replay/IReplayPlayerHelper;", "Ljm1/g;", "", "videoInfo", "", "progress", "episodeId", "Ltic/a;", "playEntity", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePaidInfo;", "episodePaidInfo", "", "playRecord", "episodePaidInfoJson", "scene", "roomId", "anchorId", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayPaidInfo;", "replayPaidInfo", "", "mobParams", "", "adaptLargeFont", "play", "replayPaidInfoJson", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "", "defaultCoverRes", "Landroid/widget/ImageView$ScaleType;", "scaleType", "bindCover", "coverUrl", "bindCoverUrl", "showCover", "withAnim", "hideCover", "Landroid/widget/FrameLayout;", KtvSubElement.CONTAINER, "updateVideoPlayerContainer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lnic/l;", "listener", "registerVideoPlayListener", "unregisterVideoPlayListener", "Lcom/bytedance/android/livesdkapi/replay/IReplayPlayerHelper$IReplayPlayerWrapperListener;", "setReplayPlayWrapperListener", "removeReplayPlayWrapperListener", "Lkotlin/Function0;", "action", "setOnBuyTicketAction", "Landroidx/lifecycle/MutableLiveData;", "getReplayPaidStatus", "()Landroidx/lifecycle/MutableLiveData;", "replayPaidStatus", "getReplayPaidCountDown", "replayPaidCountDown", "Companion", "IReplayPlayerWrapperListener", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IReplayPlayerHelper extends g {
    public static final Companion Companion = null;
    public static final int PAID_STATUS_PAID = 0;
    public static final int PAID_STATUS_TEMP_WATCH = 1;
    public static final int PAID_STATUS_TEMP_WATCH_END = 2;
    public static final int PAID_STATUS_UNDELIVERY = 3;
    public static final int PLAYBACK_STATE_ERROR = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_STOPPED = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/replay/IReplayPlayerHelper$Companion;", "", "()V", "PAID_STATUS_PAID", "", "PAID_STATUS_TEMP_WATCH", "PAID_STATUS_TEMP_WATCH_END", "PAID_STATUS_UNDELIVERY", "PLAYBACK_STATE_ERROR", "PLAYBACK_STATE_PAUSED", "PLAYBACK_STATE_PLAYING", "PLAYBACK_STATE_STOPPED", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int PAID_STATUS_PAID = 0;
        public static final int PAID_STATUS_TEMP_WATCH = 1;
        public static final int PAID_STATUS_TEMP_WATCH_END = 2;
        public static final int PAID_STATUS_UNDELIVERY = 3;
        public static final int PLAYBACK_STATE_ERROR = 3;
        public static final int PLAYBACK_STATE_PAUSED = 2;
        public static final int PLAYBACK_STATE_PLAYING = 1;
        public static final int PLAYBACK_STATE_STOPPED = 0;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        @Deprecated(message = "录播卡片下线后不再使用")
        public static void playRecord(IReplayPlayerHelper r100, String r101, long r102, long r103, a r104, EpisodePaidInfo r105) {
            Intrinsics.checkNotNullParameter(r101, "videoInfo");
        }

        public static /* synthetic */ void bindCover$default(IReplayPlayerHelper r100, Episode r101, int r102, ImageView.ScaleType r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = 0;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = ImageView.ScaleType.CENTER_CROP;
        L9:
            r100.bindCover(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindCover");
        }

        public static /* synthetic */ void bindCoverUrl$default(IReplayPlayerHelper r100, String r101, int r102, ImageView.ScaleType r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = 0;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = ImageView.ScaleType.CENTER_CROP;
        L9:
            r100.bindCoverUrl(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindCoverUrl");
        }

        public static /* synthetic */ void playRecord$default(IReplayPlayerHelper r110, String r111, long r112, long r113, a r114, EpisodePaidInfo r115, int r116, Object r117) {
            if (r117 != null) goto L14;
            if ((r116 & 8) == 0) goto L6;
            a r100 = null;
        L8:
            if ((r116 & 16) == 0) goto L10;
            EpisodePaidInfo r101 = null;
        L11:
            r110.playRecord(r111, r112, r113, r100, r101);
            return;
        L10:
            r101 = r115;
            goto L11
        L6:
            r100 = r114;
            goto L8
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playRecord");
        }

        public static /* synthetic */ void playRecord$default(IReplayPlayerHelper r110, String r111, long r112, long r113, a r114, String r115, int r116, Object r117) {
            if (r117 != null) goto L14;
            if ((r116 & 8) == 0) goto L6;
            a r100 = null;
        L8:
            if ((r116 & 16) == 0) goto L10;
            String r101 = null;
        L11:
            r110.playRecord(r111, r112, r113, r100, r101);
            return;
        L10:
            r101 = r115;
            goto L11
        L6:
            r100 = r114;
            goto L8
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playRecord");
        }

        public static /* synthetic */ void play$default(IReplayPlayerHelper r110, String r111, String r112, long r210, long r211, long r212, String r213, a r214, ReplayPaidInfo r215, Map r216, boolean r310, int r311, Object r312) {
            if (r312 != null) goto L19;
            if ((r311 & 64) == 0) goto L7;
            a r113 = null;
        L9:
            if ((r311 & 128) == 0) goto L11;
            ReplayPaidInfo r114 = null;
        L13:
            if ((r311 & 512) == 0) goto L15;
            boolean r115 = false;
        L16:
            r110.play(r111, r112, r210, r211, r212, r213, r113, r114, r216, r115);
            return;
        L15:
            r115 = r310;
            goto L16
        L11:
            r114 = r215;
            goto L13
        L7:
            r113 = r214;
            goto L9
        L19:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
        }

        public static /* synthetic */ void play$default(IReplayPlayerHelper r110, String r111, String r112, long r210, long r211, long r212, String r213, a r214, String r215, Map r216, boolean r310, int r311, Object r312) {
            if (r312 != null) goto L19;
            if ((r311 & 64) == 0) goto L7;
            a r113 = null;
        L9:
            if ((r311 & 128) == 0) goto L11;
            String r114 = null;
        L13:
            if ((r311 & 512) == 0) goto L15;
            boolean r115 = false;
        L16:
            r110.play(r111, r112, r210, r211, r212, r213, r113, r114, r216, r115);
            return;
        L15:
            r115 = r310;
            goto L16
        L11:
            r114 = r215;
            goto L13
        L7:
            r113 = r214;
            goto L9
        L19:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/replay/IReplayPlayerHelper$IReplayPlayerWrapperListener;", "", LynxVideoManagerLite.EVENT_ON_ERROR, "", "code", "", "msg", "", "onPlayStateChanged", "state", "onVideoPause", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IReplayPlayerWrapperListener {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static void onError(IReplayPlayerWrapperListener r100, int r101, String r102) {
                Intrinsics.checkNotNullParameter(r102, "msg");
            }

            public static void onPlayStateChanged(IReplayPlayerWrapperListener r100, int r101) {
            }

            public static void onVideoPause(IReplayPlayerWrapperListener r100) {
            }
        }

        void onError(int r100, String r101);

        void onPlayStateChanged(int r100);

        void onVideoPause();
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void bindCover(Episode r100, int r101, ImageView.ScaleType r102);

    void bindCoverUrl(String r100, int r101, ImageView.ScaleType r102);

    MutableLiveData<Long> getReplayPaidCountDown();

    MutableLiveData<Integer> getReplayPaidStatus();

    /* synthetic */ void getVideoFrame(d r100);

    /* synthetic */ qic.d getVideoSnapshotInfo();

    void hideCover(boolean r100);

    @Override // jm1.g
    /* synthetic */ boolean isPlaying();

    /* synthetic */ boolean isStartPlay();

    @Override // jm1.g
    /* synthetic */ void pause();

    @Override // jm1.g
    /* synthetic */ void play(String r100, FrameLayout r101, long r102, a r103);

    void play(@PaidReplayScene String r100, String r101, long r102, long r103, long r104, String r105, a r110, ReplayPaidInfo r111, Map<String, String> r112, boolean r113);

    void play(@PaidReplayScene String r100, String r101, long r102, long r103, long r104, String r105, a r110, String r111, Map<String, String> r112, boolean r113);

    @Deprecated(message = "录播卡片下线后不再使用")
    void playRecord(String r100, long r101, long r102, a r103, EpisodePaidInfo r104);

    @Deprecated(message = "录播卡片下线后不再使用")
    void playRecord(String r100, long r101, long r102, a r103, String r104);

    void registerVideoPlayListener(Context r100, l r101);

    @Override // jm1.g
    /* synthetic */ void release();

    void removeReplayPlayWrapperListener(Context r100, IReplayPlayerWrapperListener r101);

    /* synthetic */ void resolutionDegrade();

    @Override // jm1.g
    /* synthetic */ void resume();

    /* synthetic */ void seek(long r100);

    /* synthetic */ void setLoop(boolean r100);

    /* synthetic */ void setMute(boolean r100);

    void setOnBuyTicketAction(Function0<Unit> r100);

    /* synthetic */ void setPlayerConfiger(ReplayPlayerConfiger r100);

    /* synthetic */ void setReleaseEnable(boolean r100);

    void setReplayPlayWrapperListener(Context r100, IReplayPlayerWrapperListener r101);

    /* synthetic */ void setResolution(Resolution r100, boolean r101);

    /* synthetic */ void setTag(String r100, String r101);

    void showCover();

    void unregisterVideoPlayListener(Context r100, l r101);

    void updateVideoPlayerContainer(FrameLayout r100);
}
