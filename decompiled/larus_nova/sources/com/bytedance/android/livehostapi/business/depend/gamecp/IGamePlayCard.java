package com.bytedance.android.livehostapi.business.depend.gamecp;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePlayCard;", "", "bind", "", "params", "", "", "getPlayController", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePlayCard$IGamePlayController;", "getView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "IGamePlayController", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGamePlayCard {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H&¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePlayCard$IGamePlayController;", "", "feedVideoPlayIfNeeded", "", "pause", "play", "release", "seek", "progress", "", "setLoop", "loop", "", "setMute", ITTVideoEngineEventSource.KEY_MUTE, "setOnUIPlayListener", "listener", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePlayCard$IGamePlayController$IGameUIPlayListener;", "setScaleType", "type", "", "stop", "IGameUIPlayListener", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IGamePlayController {

        /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.gamecp.IGamePlayCard$IGamePlayController$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$setScaleType(IGamePlayController r100, String r101) {
                Intrinsics.checkNotNullParameter(r101, "type");
            }

            public static /* synthetic */ void access$setScaleType$jd(IGamePlayController r100, String r101) {
                $default$setScaleType(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static void setScaleType(IGamePlayController r100, String r101) {
                CC.access$setScaleType$jd(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J$\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePlayCard$IGamePlayController$IGameUIPlayListener;", "", LynxVideoManagerLite.EVENT_ON_BUFFER, "", "sourceId", "", "start", "", "onItemSelected", "position", "", "onPlayCompleted", "playCount", "onPlayFail", "errorCode", "errorMsg", "onPlayPause", "onPlayPrepare", "onPlayProgressChange", "", "duration", "onPlayStop", "onPlaying", "onSeekEnd", "success", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public interface IGameUIPlayListener {

            /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.gamecp.IGamePlayCard$IGamePlayController$IGameUIPlayListener$-CC, reason: invalid class name */
            public final /* synthetic */ class CC {
                public static void $default$onBuffering(IGameUIPlayListener r100, String r101, boolean r102) {
                }

                public static void $default$onItemSelected(IGameUIPlayListener r100, int r101) {
                }

                public static void $default$onPlayCompleted(IGameUIPlayListener r100, String r101, int r102) {
                }

                public static void $default$onPlayFail(IGameUIPlayListener r100, String r101, int r102, String r103) {
                }

                public static void $default$onPlayPause(IGameUIPlayListener r100, String r101) {
                }

                public static void $default$onPlayPrepare(IGameUIPlayListener r100, String r101) {
                }

                public static void $default$onPlayProgressChange(IGameUIPlayListener r100, String r101, long r102, long r103) {
                }

                public static void $default$onPlayStop(IGameUIPlayListener r100, String r101) {
                }

                public static void $default$onPlaying(IGameUIPlayListener r100, String r101) {
                }

                public static void $default$onSeekEnd(IGameUIPlayListener r100, String r101, boolean r102) {
                }

                public static /* synthetic */ void access$onItemSelected$jd(IGameUIPlayListener r100, int r101) {
                    $default$onItemSelected(r100, r101);
                }

                public static /* synthetic */ void access$onPlayPause$jd(IGameUIPlayListener r100, String r101) {
                    $default$onPlayPause(r100, r101);
                }

                public static /* synthetic */ void access$onPlayPrepare$jd(IGameUIPlayListener r100, String r101) {
                    $default$onPlayPrepare(r100, r101);
                }

                public static /* synthetic */ void access$onPlayStop$jd(IGameUIPlayListener r100, String r101) {
                    $default$onPlayStop(r100, r101);
                }

                public static /* synthetic */ void access$onPlaying$jd(IGameUIPlayListener r100, String r101) {
                    $default$onPlaying(r100, r101);
                }

                public static /* synthetic */ void access$onBuffering$jd(IGameUIPlayListener r100, String r101, boolean r102) {
                    $default$onBuffering(r100, r101, r102);
                }

                public static /* synthetic */ void access$onPlayCompleted$jd(IGameUIPlayListener r100, String r101, int r102) {
                    $default$onPlayCompleted(r100, r101, r102);
                }

                public static /* synthetic */ void access$onSeekEnd$jd(IGameUIPlayListener r100, String r101, boolean r102) {
                    $default$onSeekEnd(r100, r101, r102);
                }

                public static /* synthetic */ void access$onPlayFail$jd(IGameUIPlayListener r100, String r101, int r102, String r103) {
                    $default$onPlayFail(r100, r101, r102, r103);
                }

                public static /* synthetic */ void access$onPlayProgressChange$jd(IGameUIPlayListener r100, String r101, long r102, long r103) {
                    $default$onPlayProgressChange(r100, r101, r102, r103);
                }
            }

            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
            public static final class DefaultImpls {
                public static void onItemSelected(IGameUIPlayListener r100, int r101) {
                    CC.access$onItemSelected$jd(r100, r101);
                }

                public static void onPlayPause(IGameUIPlayListener r100, String r101) {
                    CC.access$onPlayPause$jd(r100, r101);
                }

                public static void onPlayPrepare(IGameUIPlayListener r100, String r101) {
                    CC.access$onPlayPrepare$jd(r100, r101);
                }

                public static void onPlayStop(IGameUIPlayListener r100, String r101) {
                    CC.access$onPlayStop$jd(r100, r101);
                }

                public static void onPlaying(IGameUIPlayListener r100, String r101) {
                    CC.access$onPlaying$jd(r100, r101);
                }

                public static void onBuffering(IGameUIPlayListener r100, String r101, boolean r102) {
                    CC.access$onBuffering$jd(r100, r101, r102);
                }

                public static void onPlayCompleted(IGameUIPlayListener r100, String r101, int r102) {
                    CC.access$onPlayCompleted$jd(r100, r101, r102);
                }

                public static void onSeekEnd(IGameUIPlayListener r100, String r101, boolean r102) {
                    CC.access$onSeekEnd$jd(r100, r101, r102);
                }

                public static void onPlayFail(IGameUIPlayListener r100, String r101, int r102, String r103) {
                    CC.access$onPlayFail$jd(r100, r101, r102, r103);
                }

                public static void onPlayProgressChange(IGameUIPlayListener r100, String r101, long r102, long r103) {
                    CC.access$onPlayProgressChange$jd(r100, r101, r102, r103);
                }
            }

            void onBuffering(String r100, boolean r101);

            void onItemSelected(int r100);

            void onPlayCompleted(String r100, int r101);

            void onPlayFail(String r100, int r101, String r102);

            void onPlayPause(String r100);

            void onPlayPrepare(String r100);

            void onPlayProgressChange(String r100, long r101, long r102);

            void onPlayStop(String r100);

            void onPlaying(String r100);

            void onSeekEnd(String r100, boolean r101);
        }

        void feedVideoPlayIfNeeded();

        void pause();

        void play();

        void release();

        void seek(float r100);

        void setLoop(boolean r100);

        void setMute(boolean r100);

        void setOnUIPlayListener(IGameUIPlayListener r100);

        void setScaleType(String r100);

        void stop();
    }

    boolean bind(Map<String, ? extends Object> r100);

    IGamePlayController getPlayController();

    View getView(Context r100);
}
