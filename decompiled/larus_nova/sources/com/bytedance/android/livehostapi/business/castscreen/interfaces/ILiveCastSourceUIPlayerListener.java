package com.bytedance.android.livehostapi.business.castscreen.interfaces;

import com.bytedance.android.livehostapi.business.castscreen.bean.ILiveCastSourceUIDevice;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastPlayInfo;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastResolutionInfo;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\fH\u0016J(\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\fH\u0016¨\u0006#À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastSourceUIPlayerListener;", "", "onComplete", "", "onLoading", "onPaused", LynxVideoManagerLite.EVENT_ON_PLAY, "onPlayCommandSuccess", "playInfo", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastPlayInfo;", "onPlayError", "action", "", "errorCode", "errorMsg", "", "onPlayerDeviceChanged", "changedDevice", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/ILiveCastSourceUIDevice;", "onPositionUpdate", "duration", "", "position", "onResolutionChanged", "resolutionInfo", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastResolutionInfo;", "onStopPlay", "onSwitchDecodeTypeResult", "userConfirm", "onVideoSwitched", "videoId", "resolution", "isAuto", "", "noActCnt", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCastSourceUIPlayerListener {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onComplete(ILiveCastSourceUIPlayerListener r100) {
        }

        public static void $default$onLoading(ILiveCastSourceUIPlayerListener r100) {
        }

        public static void $default$onPaused(ILiveCastSourceUIPlayerListener r100) {
        }

        public static void $default$onPlay(ILiveCastSourceUIPlayerListener r100) {
        }

        public static void $default$onPlayCommandSuccess(ILiveCastSourceUIPlayerListener r100, LiveCastPlayInfo r101) {
            Intrinsics.checkNotNullParameter(r101, "playInfo");
        }

        public static void $default$onPlayError(ILiveCastSourceUIPlayerListener r100, int r101, int r102, String r103) {
            Intrinsics.checkNotNullParameter(r103, "errorMsg");
        }

        public static void $default$onPlayerDeviceChanged(ILiveCastSourceUIPlayerListener r100, ILiveCastSourceUIDevice r101) {
            Intrinsics.checkNotNullParameter(r101, "changedDevice");
        }

        public static void $default$onPositionUpdate(ILiveCastSourceUIPlayerListener r100, long r101, long r102) {
        }

        public static void $default$onResolutionChanged(ILiveCastSourceUIPlayerListener r100, LiveCastResolutionInfo r101) {
        }

        public static void $default$onStopPlay(ILiveCastSourceUIPlayerListener r100) {
        }

        public static void $default$onSwitchDecodeTypeResult(ILiveCastSourceUIPlayerListener r100, int r101) {
        }

        public static void $default$onVideoSwitched(ILiveCastSourceUIPlayerListener r100, String r101, String r102, boolean r103, int r104) {
            Intrinsics.checkNotNullParameter(r101, "videoId");
            Intrinsics.checkNotNullParameter(r102, "resolution");
        }

        public static /* synthetic */ void access$onComplete$jd(ILiveCastSourceUIPlayerListener r100) {
            $default$onComplete(r100);
        }

        public static /* synthetic */ void access$onLoading$jd(ILiveCastSourceUIPlayerListener r100) {
            $default$onLoading(r100);
        }

        public static /* synthetic */ void access$onPaused$jd(ILiveCastSourceUIPlayerListener r100) {
            $default$onPaused(r100);
        }

        public static /* synthetic */ void access$onPlay$jd(ILiveCastSourceUIPlayerListener r100) {
            $default$onPlay(r100);
        }

        public static /* synthetic */ void access$onStopPlay$jd(ILiveCastSourceUIPlayerListener r100) {
            $default$onStopPlay(r100);
        }

        public static /* synthetic */ void access$onPlayCommandSuccess$jd(ILiveCastSourceUIPlayerListener r100, LiveCastPlayInfo r101) {
            $default$onPlayCommandSuccess(r100, r101);
        }

        public static /* synthetic */ void access$onPlayerDeviceChanged$jd(ILiveCastSourceUIPlayerListener r100, ILiveCastSourceUIDevice r101) {
            $default$onPlayerDeviceChanged(r100, r101);
        }

        public static /* synthetic */ void access$onResolutionChanged$jd(ILiveCastSourceUIPlayerListener r100, LiveCastResolutionInfo r101) {
            $default$onResolutionChanged(r100, r101);
        }

        public static /* synthetic */ void access$onSwitchDecodeTypeResult$jd(ILiveCastSourceUIPlayerListener r100, int r101) {
            $default$onSwitchDecodeTypeResult(r100, r101);
        }

        public static /* synthetic */ void access$onPositionUpdate$jd(ILiveCastSourceUIPlayerListener r100, long r101, long r102) {
            $default$onPositionUpdate(r100, r101, r102);
        }

        public static /* synthetic */ void access$onPlayError$jd(ILiveCastSourceUIPlayerListener r100, int r101, int r102, String r103) {
            $default$onPlayError(r100, r101, r102, r103);
        }

        public static /* synthetic */ void access$onVideoSwitched$jd(ILiveCastSourceUIPlayerListener r100, String r101, String r102, boolean r103, int r104) {
            $default$onVideoSwitched(r100, r101, r102, r103, r104);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onComplete(ILiveCastSourceUIPlayerListener r100) {
            CC.access$onComplete$jd(r100);
        }

        public static void onLoading(ILiveCastSourceUIPlayerListener r100) {
            CC.access$onLoading$jd(r100);
        }

        public static void onPaused(ILiveCastSourceUIPlayerListener r100) {
            CC.access$onPaused$jd(r100);
        }

        public static void onPlay(ILiveCastSourceUIPlayerListener r100) {
            CC.access$onPlay$jd(r100);
        }

        public static void onStopPlay(ILiveCastSourceUIPlayerListener r100) {
            CC.access$onStopPlay$jd(r100);
        }

        public static void onPlayCommandSuccess(ILiveCastSourceUIPlayerListener r100, LiveCastPlayInfo r101) {
            CC.access$onPlayCommandSuccess$jd(r100, r101);
        }

        public static void onPlayerDeviceChanged(ILiveCastSourceUIPlayerListener r100, ILiveCastSourceUIDevice r101) {
            CC.access$onPlayerDeviceChanged$jd(r100, r101);
        }

        public static void onResolutionChanged(ILiveCastSourceUIPlayerListener r100, LiveCastResolutionInfo r101) {
            CC.access$onResolutionChanged$jd(r100, r101);
        }

        public static void onSwitchDecodeTypeResult(ILiveCastSourceUIPlayerListener r100, int r101) {
            CC.access$onSwitchDecodeTypeResult$jd(r100, r101);
        }

        public static void onPositionUpdate(ILiveCastSourceUIPlayerListener r100, long r101, long r102) {
            CC.access$onPositionUpdate$jd(r100, r101, r102);
        }

        public static void onPlayError(ILiveCastSourceUIPlayerListener r100, int r101, int r102, String r103) {
            CC.access$onPlayError$jd(r100, r101, r102, r103);
        }

        public static void onVideoSwitched(ILiveCastSourceUIPlayerListener r100, String r101, String r102, boolean r103, int r104) {
            CC.access$onVideoSwitched$jd(r100, r101, r102, r103, r104);
        }
    }

    void onComplete();

    void onLoading();

    void onPaused();

    void onPlay();

    void onPlayCommandSuccess(LiveCastPlayInfo r100);

    void onPlayError(int r100, int r101, String r102);

    void onPlayerDeviceChanged(ILiveCastSourceUIDevice r100);

    void onPositionUpdate(long r100, long r101);

    void onResolutionChanged(LiveCastResolutionInfo r100);

    void onStopPlay();

    void onSwitchDecodeTypeResult(int r100);

    void onVideoSwitched(String r100, String r101, boolean r102, int r103);
}
