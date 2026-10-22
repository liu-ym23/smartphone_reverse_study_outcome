package com.bytedance.android.livesdkapi.vsplayer;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodePaidInfo;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nic.l;
import tic.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 )2\u00020\u0001:\u0002)*J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002H&J$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0003\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H&J$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0003\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0017\u001a\u00020\u000bH&J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H&J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H&J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020$H&J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020$H&J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0018H&¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/IVSVideoPlayerHelper;", "Lcom/bytedance/android/livesdkapi/vsplayer/IVSVideoPlayer;", "", "videoInfo", "", "progress", "episodeId", "Ltic/a;", "playEntity", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePaidInfo;", "episodePaidInfo", "", "play", "episodePaidInfoJson", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "", "defaultCoverRes", "Landroid/widget/ImageView$ScaleType;", "scaleType", "bindCover", "coverUrl", "bindCoverUrl", "showCover", "", "withAnim", "hideCover", "Landroid/widget/FrameLayout;", KtvSubElement.CONTAINER, "updateVideoPlayerContainer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lnic/l;", "listener", "registerVideoPlayListener", "unregisterVideoPlayListener", "Lcom/bytedance/android/livesdkapi/vsplayer/IVSVideoPlayerHelper$IVSVideoPlayerWrapperListener;", "setVSVideoPlayWrapperListener", "removeVSVideoPlayWrapperListener", "hasRight", "setHasRight", "Companion", "IVSVideoPlayerWrapperListener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSVideoPlayerHelper extends IVSVideoPlayer {
    public static final Companion Companion = null;
    public static final int PLAYBACK_STATE_ERROR = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_STOPPED = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/IVSVideoPlayerHelper$Companion;", "", "()V", "PLAYBACK_STATE_ERROR", "", "PLAYBACK_STATE_PAUSED", "PLAYBACK_STATE_PLAYING", "PLAYBACK_STATE_STOPPED", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
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
        public static void play(IVSVideoPlayerHelper r100, String r101, long r102, long r103, a r104, EpisodePaidInfo r105) {
            Intrinsics.checkNotNullParameter(r101, "videoInfo");
        }

        public static /* synthetic */ void bindCover$default(IVSVideoPlayerHelper r100, Episode r101, int r102, ImageView.ScaleType r103, int r104, Object r105) {
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

        public static /* synthetic */ void bindCoverUrl$default(IVSVideoPlayerHelper r100, String r101, int r102, ImageView.ScaleType r103, int r104, Object r105) {
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

        public static /* synthetic */ void play$default(IVSVideoPlayerHelper r110, String r111, long r112, long r113, a r114, EpisodePaidInfo r115, int r116, Object r117) {
            if (r117 != null) goto L14;
            if ((r116 & 8) == 0) goto L6;
            a r100 = null;
        L8:
            if ((r116 & 16) == 0) goto L10;
            EpisodePaidInfo r101 = null;
        L11:
            r110.play(r111, r112, r113, r100, r101);
            return;
        L10:
            r101 = r115;
            goto L11
        L6:
            r100 = r114;
            goto L8
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
        }

        public static /* synthetic */ void play$default(IVSVideoPlayerHelper r110, String r111, long r112, long r113, a r114, String r115, int r116, Object r117) {
            if (r117 != null) goto L14;
            if ((r116 & 8) == 0) goto L6;
            a r100 = null;
        L8:
            if ((r116 & 16) == 0) goto L10;
            String r101 = null;
        L11:
            r110.play(r111, r112, r113, r100, r101);
            return;
        L10:
            r101 = r115;
            goto L11
        L6:
            r100 = r114;
            goto L8
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/IVSVideoPlayerHelper$IVSVideoPlayerWrapperListener;", "", LynxVideoManagerLite.EVENT_ON_ERROR, "", "code", "", "msg", "", "onFreePlayEnd", "onFreePlayStart", "onFreePlaying", "countDown", "", "onHasRight", "onPlayStateChanged", "state", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IVSVideoPlayerWrapperListener {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static void onError(IVSVideoPlayerWrapperListener r100, int r101, String r102) {
                Intrinsics.checkNotNullParameter(r102, "msg");
            }

            public static void onFreePlayEnd(IVSVideoPlayerWrapperListener r100) {
            }

            public static void onFreePlayStart(IVSVideoPlayerWrapperListener r100) {
            }

            public static void onFreePlaying(IVSVideoPlayerWrapperListener r100, long r101) {
            }

            public static void onHasRight(IVSVideoPlayerWrapperListener r100) {
            }

            public static void onPlayStateChanged(IVSVideoPlayerWrapperListener r100, int r101) {
            }
        }

        void onError(int r100, String r101);

        void onFreePlayEnd();

        void onFreePlayStart();

        void onFreePlaying(long r100);

        void onHasRight();

        void onPlayStateChanged(int r100);
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void bindCover(Episode r100, int r101, ImageView.ScaleType r102);

    void bindCoverUrl(String r100, int r101, ImageView.ScaleType r102);

    void hideCover(boolean r100);

    void play(String r100, long r101, long r102, a r103, EpisodePaidInfo r104);

    void play(String r100, long r101, long r102, a r103, String r104);

    void registerVideoPlayListener(Context r100, l r101);

    void removeVSVideoPlayWrapperListener(Context r100, IVSVideoPlayerWrapperListener r101);

    void setHasRight(boolean r100);

    void setVSVideoPlayWrapperListener(Context r100, IVSVideoPlayerWrapperListener r101);

    void showCover();

    void unregisterVideoPlayListener(Context r100, l r101);

    void updateVideoPlayerContainer(FrameLayout r100);
}
