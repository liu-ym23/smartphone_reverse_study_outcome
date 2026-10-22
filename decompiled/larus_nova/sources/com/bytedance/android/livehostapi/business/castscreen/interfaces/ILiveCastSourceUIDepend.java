package com.bytedance.android.livehostapi.business.castscreen.interfaces;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.livehostapi.business.castscreen.bean.ILiveCastSourceUIDevice;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastDanmakuSetting;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastLiveScreenMode;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastOptionResolutionStrategyInfo;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastResolutionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 n2\u00020\u0001:\u0001nJ$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H&J\n\u0010'\u001a\u0004\u0018\u00010(H&J\b\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0017H&J\u0018\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010,H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\n\u00100\u001a\u0004\u0018\u000101H&J\b\u00102\u001a\u00020\u0017H&J\u000f\u00103\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u00104J\u000f\u00105\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0002\u0010\u0018J\n\u00106\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u00107\u001a\u0004\u0018\u00010\u0007H&J\b\u00108\u001a\u00020\u0007H&J\u0018\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0017H\u0016J\b\u0010<\u001a\u00020\tH&J\u000f\u0010=\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020\tH\u0016J\b\u0010@\u001a\u00020\tH\u0016J\b\u0010A\u001a\u00020\tH\u0016J\u000f\u0010B\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010>J\b\u0010C\u001a\u00020\tH\u0016J\u000f\u0010D\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010>J\b\u0010E\u001a\u00020\tH\u0016J\u0012\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010HH&J\"\u0010I\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0017H\u0016J\u0010\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\tH\u0016J\"\u0010N\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\t2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020PH&J\b\u0010R\u001a\u00020\u0003H&J\u0012\u0010S\u001a\u00020\t2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J \u0010V\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\t2\u0006\u0010X\u001a\u00020\u0017H&J\u0010\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u0017H\u0016J\u0018\u0010[\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010W\u001a\u00020\u0007H\u0016J\n\u0010\\\u001a\u0004\u0018\u00010\u0007H&J\b\u0010]\u001a\u00020\tH\u0016J\u0010\u0010^\u001a\u00020\u00032\u0006\u0010_\u001a\u00020\tH\u0016J\u001a\u0010`\u001a\u00020\u00032\u0006\u0010a\u001a\u00020\u00152\b\u0010b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010c\u001a\u00020\u0003H\u0016J\b\u0010d\u001a\u00020\tH\u0016J\b\u0010e\u001a\u00020\tH\u0016J\b\u0010f\u001a\u00020\tH\u0016J\b\u0010g\u001a\u00020\tH\u0016J\b\u0010h\u001a\u00020\tH\u0016J\b\u0010i\u001a\u00020\tH\u0016J\b\u0010j\u001a\u00020\tH\u0016J\u0018\u0010k\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010l\u001a\u00020mH\u0016¨\u0006oÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastSourceUIDepend;", "", "accessibilityAddContent", "", "view", "Landroid/view/View;", "description", "", "isButton", "", "appendLogExtra", "params", "Lorg/json/JSONObject;", "canLandscapeExpandControlView", "changeLiveFlow", "customChangeEpisode", "customChangeResolution", "enableHalfControlViewGesture", "enableLandscapeControlViewGesture", "getAlbumId", "getCameraId", "", "getControlViewParentHeight", "", "()Ljava/lang/Integer;", "getControlViewParentWidth", "getCurRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getDanmakuSetting", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastDanmakuSetting;", "getDisplay", "Landroid/view/Display;", "getHalfControlStyle", "getHostLoadingView", "Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastLoadingView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getLiveScreenMode", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveScreenMode;", "getMatchRoomLandScapeAnimCallback", "Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastMatchRoomLandScapeAnimCallback;", "getMaxRoomResolution", "getOnlySupportXsgConfig", "getOptions", "", "getPlayInfo", "callback", "Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastGetPlayInfoCallback;", "getResolutionStrategyInfo", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastOptionResolutionStrategyInfo;", "getSceneId", "getSearchTimeoutPeriodWifiXsg", "()Ljava/lang/Long;", "getSearchViewTargetHeight", "getTitle", "getUISettings", "getVideoId", "hostShowToast", "toast", "mode", "isMatchRoom", "isPad", "()Ljava/lang/Boolean;", "isPaidRoom", "isRealPlay", "isReplayRoom", "isSysExtendedCastMode", "isSysMiracast", "isXsgDeviceShowNotBDLink", "needControlClickEventPassThrough", "onChangeResolution", "resolution", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastResolutionInfo;", "onControlPageClose", "isLandscape", "action", "onDanmakuButtonClick", "enable", "onDeviceSelected", "oldDevice", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/ILiveCastSourceUIDevice;", "newDevice", "onExitCasting", "onKeyEvent", "event", "Landroid/view/KeyEvent;", "onOpenWebPageClick", "url", "castPage", "onPlayStatus", "playStatus", "openWebPage", "playerResolution", "searchNeedStartControl", "setIsFakePlay", "isFakePlay", "setReplayMediaInfo", "episodeId", "title", "showCastControlView", "showHalfControlBackIcon", "showHalfPlayController", "showLandscapePlayController", "showLandscapeSearchMaskBg", "supportChangeResolution", "supportEpisode", "supportFoldMode", "useRouteOutCertIdToIntent", "intent", "Landroid/content/Intent;", "Companion", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCastSourceUIDepend {
    public static final int CAST_PAGE_CONTROL = 2;
    public static final int CAST_PAGE_GUIDE = 3;
    public static final int CAST_PAGE_SEARCH = 1;
    public static final Companion Companion = null;
    public static final int HALF_CONTROL_STYLE_0 = 0;
    public static final int HALF_CONTROL_STYLE_1 = 1;

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIDepend$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$accessibilityAddContent(ILiveCastSourceUIDepend r100, View r101, String r102, boolean r103) {
        }

        public static boolean $default$canLandscapeExpandControlView(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static void $default$changeLiveFlow(ILiveCastSourceUIDepend r100) {
        }

        public static boolean $default$customChangeEpisode(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static boolean $default$customChangeResolution(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static boolean $default$enableHalfControlViewGesture(ILiveCastSourceUIDepend r100) {
            return true;
        }

        public static boolean $default$enableLandscapeControlViewGesture(ILiveCastSourceUIDepend r100) {
            return true;
        }

        public static long $default$getCameraId(ILiveCastSourceUIDepend r100) {
            return 0;
        }

        public static Integer $default$getControlViewParentHeight(ILiveCastSourceUIDepend r100) {
            return null;
        }

        public static Integer $default$getControlViewParentWidth(ILiveCastSourceUIDepend r100) {
            return null;
        }

        public static Room $default$getCurRoom(ILiveCastSourceUIDepend r100) {
            return null;
        }

        public static LiveCastDanmakuSetting $default$getDanmakuSetting(ILiveCastSourceUIDepend r100) {
            return null;
        }

        public static Display $default$getDisplay(ILiveCastSourceUIDepend r100) {
            return null;
        }

        public static int $default$getHalfControlStyle(ILiveCastSourceUIDepend r100) {
            return 0;
        }

        public static ILiveCastLoadingView $default$getHostLoadingView(ILiveCastSourceUIDepend r100, Context r101) {
            return null;
        }

        public static int $default$getMaxRoomResolution(ILiveCastSourceUIDepend r100) {
            return 0;
        }

        public static Long $default$getSearchTimeoutPeriodWifiXsg(ILiveCastSourceUIDepend r100) {
            return null;
        }

        public static String $default$getTitle(ILiveCastSourceUIDepend r100) {
            return "";
        }

        public static void $default$hostShowToast(ILiveCastSourceUIDepend r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "toast");
        }

        public static boolean $default$isPaidRoom(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static boolean $default$isRealPlay(ILiveCastSourceUIDepend r100) {
            return true;
        }

        public static boolean $default$isReplayRoom(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static boolean $default$isSysMiracast(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static Boolean $default$isXsgDeviceShowNotBDLink(ILiveCastSourceUIDepend r100) {
            return null;
        }

        public static boolean $default$needControlClickEventPassThrough(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static void $default$onControlPageClose(ILiveCastSourceUIDepend r100, Context r101, boolean r102, int r103) {
        }

        public static void $default$onDanmakuButtonClick(ILiveCastSourceUIDepend r100, boolean r101) {
        }

        public static boolean $default$onKeyEvent(ILiveCastSourceUIDepend r100, KeyEvent r101) {
            return false;
        }

        public static void $default$onPlayStatus(ILiveCastSourceUIDepend r100, int r101) {
        }

        public static boolean $default$openWebPage(ILiveCastSourceUIDepend r100, Context r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "url");
            return false;
        }

        public static boolean $default$searchNeedStartControl(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static void $default$setIsFakePlay(ILiveCastSourceUIDepend r100, boolean r101) {
        }

        public static void $default$setReplayMediaInfo(ILiveCastSourceUIDepend r100, long r101, String r102) {
        }

        public static void $default$showCastControlView(ILiveCastSourceUIDepend r100) {
        }

        public static boolean $default$showHalfControlBackIcon(ILiveCastSourceUIDepend r100) {
            return true;
        }

        public static boolean $default$showHalfPlayController(ILiveCastSourceUIDepend r100) {
            return true;
        }

        public static boolean $default$showLandscapePlayController(ILiveCastSourceUIDepend r100) {
            return true;
        }

        public static boolean $default$showLandscapeSearchMaskBg(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static boolean $default$supportChangeResolution(ILiveCastSourceUIDepend r100) {
            return true;
        }

        public static boolean $default$supportEpisode(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static boolean $default$supportFoldMode(ILiveCastSourceUIDepend r100) {
            return false;
        }

        public static boolean $default$useRouteOutCertIdToIntent(ILiveCastSourceUIDepend r100, Context r101, Intent r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "intent");
            return false;
        }

        static {
            Companion r100 = ILiveCastSourceUIDepend.Companion;
        }

        public static Boolean $default$isPad(ILiveCastSourceUIDepend r100) {
            return Boolean.FALSE;
        }

        public static Boolean $default$isSysExtendedCastMode(ILiveCastSourceUIDepend r100) {
            return Boolean.FALSE;
        }

        public static /* synthetic */ boolean access$canLandscapeExpandControlView$jd(ILiveCastSourceUIDepend r100) {
            return $default$canLandscapeExpandControlView(r100);
        }

        public static /* synthetic */ void access$changeLiveFlow$jd(ILiveCastSourceUIDepend r100) {
            $default$changeLiveFlow(r100);
        }

        public static /* synthetic */ boolean access$customChangeEpisode$jd(ILiveCastSourceUIDepend r100) {
            return $default$customChangeEpisode(r100);
        }

        public static /* synthetic */ boolean access$customChangeResolution$jd(ILiveCastSourceUIDepend r100) {
            return $default$customChangeResolution(r100);
        }

        public static /* synthetic */ boolean access$enableHalfControlViewGesture$jd(ILiveCastSourceUIDepend r100) {
            return $default$enableHalfControlViewGesture(r100);
        }

        public static /* synthetic */ boolean access$enableLandscapeControlViewGesture$jd(ILiveCastSourceUIDepend r100) {
            return $default$enableLandscapeControlViewGesture(r100);
        }

        public static /* synthetic */ long access$getCameraId$jd(ILiveCastSourceUIDepend r100) {
            return $default$getCameraId(r100);
        }

        public static /* synthetic */ Integer access$getControlViewParentHeight$jd(ILiveCastSourceUIDepend r100) {
            return $default$getControlViewParentHeight(r100);
        }

        public static /* synthetic */ Integer access$getControlViewParentWidth$jd(ILiveCastSourceUIDepend r100) {
            return $default$getControlViewParentWidth(r100);
        }

        public static /* synthetic */ Room access$getCurRoom$jd(ILiveCastSourceUIDepend r100) {
            return $default$getCurRoom(r100);
        }

        public static /* synthetic */ LiveCastDanmakuSetting access$getDanmakuSetting$jd(ILiveCastSourceUIDepend r100) {
            return $default$getDanmakuSetting(r100);
        }

        public static /* synthetic */ Display access$getDisplay$jd(ILiveCastSourceUIDepend r100) {
            return $default$getDisplay(r100);
        }

        public static /* synthetic */ int access$getHalfControlStyle$jd(ILiveCastSourceUIDepend r100) {
            return $default$getHalfControlStyle(r100);
        }

        public static /* synthetic */ int access$getMaxRoomResolution$jd(ILiveCastSourceUIDepend r100) {
            return $default$getMaxRoomResolution(r100);
        }

        public static /* synthetic */ Long access$getSearchTimeoutPeriodWifiXsg$jd(ILiveCastSourceUIDepend r100) {
            return $default$getSearchTimeoutPeriodWifiXsg(r100);
        }

        public static /* synthetic */ String access$getTitle$jd(ILiveCastSourceUIDepend r100) {
            return $default$getTitle(r100);
        }

        public static /* synthetic */ Boolean access$isPad$jd(ILiveCastSourceUIDepend r100) {
            return $default$isPad(r100);
        }

        public static /* synthetic */ boolean access$isPaidRoom$jd(ILiveCastSourceUIDepend r100) {
            return $default$isPaidRoom(r100);
        }

        public static /* synthetic */ boolean access$isRealPlay$jd(ILiveCastSourceUIDepend r100) {
            return $default$isRealPlay(r100);
        }

        public static /* synthetic */ boolean access$isReplayRoom$jd(ILiveCastSourceUIDepend r100) {
            return $default$isReplayRoom(r100);
        }

        public static /* synthetic */ Boolean access$isSysExtendedCastMode$jd(ILiveCastSourceUIDepend r100) {
            return $default$isSysExtendedCastMode(r100);
        }

        public static /* synthetic */ boolean access$isSysMiracast$jd(ILiveCastSourceUIDepend r100) {
            return $default$isSysMiracast(r100);
        }

        public static /* synthetic */ Boolean access$isXsgDeviceShowNotBDLink$jd(ILiveCastSourceUIDepend r100) {
            return $default$isXsgDeviceShowNotBDLink(r100);
        }

        public static /* synthetic */ boolean access$needControlClickEventPassThrough$jd(ILiveCastSourceUIDepend r100) {
            return $default$needControlClickEventPassThrough(r100);
        }

        public static /* synthetic */ boolean access$searchNeedStartControl$jd(ILiveCastSourceUIDepend r100) {
            return $default$searchNeedStartControl(r100);
        }

        public static /* synthetic */ void access$showCastControlView$jd(ILiveCastSourceUIDepend r100) {
            $default$showCastControlView(r100);
        }

        public static /* synthetic */ boolean access$showHalfControlBackIcon$jd(ILiveCastSourceUIDepend r100) {
            return $default$showHalfControlBackIcon(r100);
        }

        public static /* synthetic */ boolean access$showHalfPlayController$jd(ILiveCastSourceUIDepend r100) {
            return $default$showHalfPlayController(r100);
        }

        public static /* synthetic */ boolean access$showLandscapePlayController$jd(ILiveCastSourceUIDepend r100) {
            return $default$showLandscapePlayController(r100);
        }

        public static /* synthetic */ boolean access$showLandscapeSearchMaskBg$jd(ILiveCastSourceUIDepend r100) {
            return $default$showLandscapeSearchMaskBg(r100);
        }

        public static /* synthetic */ boolean access$supportChangeResolution$jd(ILiveCastSourceUIDepend r100) {
            return $default$supportChangeResolution(r100);
        }

        public static /* synthetic */ boolean access$supportEpisode$jd(ILiveCastSourceUIDepend r100) {
            return $default$supportEpisode(r100);
        }

        public static /* synthetic */ boolean access$supportFoldMode$jd(ILiveCastSourceUIDepend r100) {
            return $default$supportFoldMode(r100);
        }

        public static /* synthetic */ ILiveCastLoadingView access$getHostLoadingView$jd(ILiveCastSourceUIDepend r100, Context r101) {
            return $default$getHostLoadingView(r100, r101);
        }

        public static /* synthetic */ void access$onDanmakuButtonClick$jd(ILiveCastSourceUIDepend r100, boolean r101) {
            $default$onDanmakuButtonClick(r100, r101);
        }

        public static /* synthetic */ boolean access$onKeyEvent$jd(ILiveCastSourceUIDepend r100, KeyEvent r101) {
            return $default$onKeyEvent(r100, r101);
        }

        public static /* synthetic */ void access$onPlayStatus$jd(ILiveCastSourceUIDepend r100, int r101) {
            $default$onPlayStatus(r100, r101);
        }

        public static /* synthetic */ void access$setIsFakePlay$jd(ILiveCastSourceUIDepend r100, boolean r101) {
            $default$setIsFakePlay(r100, r101);
        }

        public static /* synthetic */ void access$hostShowToast$jd(ILiveCastSourceUIDepend r100, String r101, int r102) {
            $default$hostShowToast(r100, r101, r102);
        }

        public static /* synthetic */ boolean access$openWebPage$jd(ILiveCastSourceUIDepend r100, Context r101, String r102) {
            return $default$openWebPage(r100, r101, r102);
        }

        public static /* synthetic */ void access$setReplayMediaInfo$jd(ILiveCastSourceUIDepend r100, long r101, String r102) {
            $default$setReplayMediaInfo(r100, r101, r102);
        }

        public static /* synthetic */ boolean access$useRouteOutCertIdToIntent$jd(ILiveCastSourceUIDepend r100, Context r101, Intent r102) {
            return $default$useRouteOutCertIdToIntent(r100, r101, r102);
        }

        public static /* synthetic */ void access$accessibilityAddContent$jd(ILiveCastSourceUIDepend r100, View r101, String r102, boolean r103) {
            $default$accessibilityAddContent(r100, r101, r102, r103);
        }

        public static /* synthetic */ void access$onControlPageClose$jd(ILiveCastSourceUIDepend r100, Context r101, boolean r102, int r103) {
            $default$onControlPageClose(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastSourceUIDepend$Companion;", "", "()V", "CAST_PAGE_CONTROL", "", "CAST_PAGE_GUIDE", "CAST_PAGE_SEARCH", "HALF_CONTROL_STYLE_0", "HALF_CONTROL_STYLE_1", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int CAST_PAGE_CONTROL = 2;
        public static final int CAST_PAGE_GUIDE = 3;
        public static final int CAST_PAGE_SEARCH = 1;
        public static final int HALF_CONTROL_STYLE_0 = 0;
        public static final int HALF_CONTROL_STYLE_1 = 1;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static boolean canLandscapeExpandControlView(ILiveCastSourceUIDepend r100) {
            return CC.access$canLandscapeExpandControlView$jd(r100);
        }

        public static void changeLiveFlow(ILiveCastSourceUIDepend r100) {
            CC.access$changeLiveFlow$jd(r100);
        }

        public static boolean customChangeEpisode(ILiveCastSourceUIDepend r100) {
            return CC.access$customChangeEpisode$jd(r100);
        }

        public static boolean customChangeResolution(ILiveCastSourceUIDepend r100) {
            return CC.access$customChangeResolution$jd(r100);
        }

        public static boolean enableHalfControlViewGesture(ILiveCastSourceUIDepend r100) {
            return CC.access$enableHalfControlViewGesture$jd(r100);
        }

        public static boolean enableLandscapeControlViewGesture(ILiveCastSourceUIDepend r100) {
            return CC.access$enableLandscapeControlViewGesture$jd(r100);
        }

        public static long getCameraId(ILiveCastSourceUIDepend r100) {
            return CC.access$getCameraId$jd(r100);
        }

        public static Integer getControlViewParentHeight(ILiveCastSourceUIDepend r100) {
            return CC.access$getControlViewParentHeight$jd(r100);
        }

        public static Integer getControlViewParentWidth(ILiveCastSourceUIDepend r100) {
            return CC.access$getControlViewParentWidth$jd(r100);
        }

        public static Room getCurRoom(ILiveCastSourceUIDepend r100) {
            return CC.access$getCurRoom$jd(r100);
        }

        public static LiveCastDanmakuSetting getDanmakuSetting(ILiveCastSourceUIDepend r100) {
            return CC.access$getDanmakuSetting$jd(r100);
        }

        public static Display getDisplay(ILiveCastSourceUIDepend r100) {
            return CC.access$getDisplay$jd(r100);
        }

        public static int getHalfControlStyle(ILiveCastSourceUIDepend r100) {
            return CC.access$getHalfControlStyle$jd(r100);
        }

        public static int getMaxRoomResolution(ILiveCastSourceUIDepend r100) {
            return CC.access$getMaxRoomResolution$jd(r100);
        }

        public static Long getSearchTimeoutPeriodWifiXsg(ILiveCastSourceUIDepend r100) {
            return CC.access$getSearchTimeoutPeriodWifiXsg$jd(r100);
        }

        public static String getTitle(ILiveCastSourceUIDepend r100) {
            return CC.access$getTitle$jd(r100);
        }

        public static Boolean isPad(ILiveCastSourceUIDepend r100) {
            return CC.access$isPad$jd(r100);
        }

        public static boolean isPaidRoom(ILiveCastSourceUIDepend r100) {
            return CC.access$isPaidRoom$jd(r100);
        }

        public static boolean isRealPlay(ILiveCastSourceUIDepend r100) {
            return CC.access$isRealPlay$jd(r100);
        }

        public static boolean isReplayRoom(ILiveCastSourceUIDepend r100) {
            return CC.access$isReplayRoom$jd(r100);
        }

        public static Boolean isSysExtendedCastMode(ILiveCastSourceUIDepend r100) {
            return CC.access$isSysExtendedCastMode$jd(r100);
        }

        public static boolean isSysMiracast(ILiveCastSourceUIDepend r100) {
            return CC.access$isSysMiracast$jd(r100);
        }

        public static Boolean isXsgDeviceShowNotBDLink(ILiveCastSourceUIDepend r100) {
            return CC.access$isXsgDeviceShowNotBDLink$jd(r100);
        }

        public static boolean needControlClickEventPassThrough(ILiveCastSourceUIDepend r100) {
            return CC.access$needControlClickEventPassThrough$jd(r100);
        }

        public static boolean searchNeedStartControl(ILiveCastSourceUIDepend r100) {
            return CC.access$searchNeedStartControl$jd(r100);
        }

        public static void showCastControlView(ILiveCastSourceUIDepend r100) {
            CC.access$showCastControlView$jd(r100);
        }

        public static boolean showHalfControlBackIcon(ILiveCastSourceUIDepend r100) {
            return CC.access$showHalfControlBackIcon$jd(r100);
        }

        public static boolean showHalfPlayController(ILiveCastSourceUIDepend r100) {
            return CC.access$showHalfPlayController$jd(r100);
        }

        public static boolean showLandscapePlayController(ILiveCastSourceUIDepend r100) {
            return CC.access$showLandscapePlayController$jd(r100);
        }

        public static boolean showLandscapeSearchMaskBg(ILiveCastSourceUIDepend r100) {
            return CC.access$showLandscapeSearchMaskBg$jd(r100);
        }

        public static boolean supportChangeResolution(ILiveCastSourceUIDepend r100) {
            return CC.access$supportChangeResolution$jd(r100);
        }

        public static boolean supportEpisode(ILiveCastSourceUIDepend r100) {
            return CC.access$supportEpisode$jd(r100);
        }

        public static boolean supportFoldMode(ILiveCastSourceUIDepend r100) {
            return CC.access$supportFoldMode$jd(r100);
        }

        public static ILiveCastLoadingView getHostLoadingView(ILiveCastSourceUIDepend r100, Context r101) {
            return CC.access$getHostLoadingView$jd(r100, r101);
        }

        public static void onDanmakuButtonClick(ILiveCastSourceUIDepend r100, boolean r101) {
            CC.access$onDanmakuButtonClick$jd(r100, r101);
        }

        public static boolean onKeyEvent(ILiveCastSourceUIDepend r100, KeyEvent r101) {
            return CC.access$onKeyEvent$jd(r100, r101);
        }

        public static void onPlayStatus(ILiveCastSourceUIDepend r100, int r101) {
            CC.access$onPlayStatus$jd(r100, r101);
        }

        public static void setIsFakePlay(ILiveCastSourceUIDepend r100, boolean r101) {
            CC.access$setIsFakePlay$jd(r100, r101);
        }

        public static void hostShowToast(ILiveCastSourceUIDepend r100, String r101, int r102) {
            CC.access$hostShowToast$jd(r100, r101, r102);
        }

        public static boolean openWebPage(ILiveCastSourceUIDepend r100, Context r101, String r102) {
            return CC.access$openWebPage$jd(r100, r101, r102);
        }

        public static void setReplayMediaInfo(ILiveCastSourceUIDepend r100, long r101, String r102) {
            CC.access$setReplayMediaInfo$jd(r100, r101, r102);
        }

        public static boolean useRouteOutCertIdToIntent(ILiveCastSourceUIDepend r100, Context r101, Intent r102) {
            return CC.access$useRouteOutCertIdToIntent$jd(r100, r101, r102);
        }

        public static void accessibilityAddContent(ILiveCastSourceUIDepend r100, View r101, String r102, boolean r103) {
            CC.access$accessibilityAddContent$jd(r100, r101, r102, r103);
        }

        public static void onControlPageClose(ILiveCastSourceUIDepend r100, Context r101, boolean r102, int r103) {
            CC.access$onControlPageClose$jd(r100, r101, r102, r103);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void accessibilityAddContent(View r100, String r101, boolean r102);

    void appendLogExtra(JSONObject r100);

    boolean canLandscapeExpandControlView();

    void changeLiveFlow();

    boolean customChangeEpisode();

    boolean customChangeResolution();

    boolean enableHalfControlViewGesture();

    boolean enableLandscapeControlViewGesture();

    String getAlbumId();

    long getCameraId();

    Integer getControlViewParentHeight();

    Integer getControlViewParentWidth();

    Room getCurRoom();

    LiveCastDanmakuSetting getDanmakuSetting();

    Display getDisplay();

    int getHalfControlStyle();

    ILiveCastLoadingView getHostLoadingView(Context r100);

    LiveCastLiveScreenMode getLiveScreenMode();

    ILiveCastMatchRoomLandScapeAnimCallback getMatchRoomLandScapeAnimCallback();

    int getMaxRoomResolution();

    int getOnlySupportXsgConfig();

    Map<Integer, Object> getOptions();

    void getPlayInfo(ILiveCastGetPlayInfoCallback r100);

    LiveCastOptionResolutionStrategyInfo getResolutionStrategyInfo();

    int getSceneId();

    Long getSearchTimeoutPeriodWifiXsg();

    Integer getSearchViewTargetHeight();

    String getTitle();

    String getUISettings();

    String getVideoId();

    void hostShowToast(String r100, int r101);

    boolean isMatchRoom();

    Boolean isPad();

    boolean isPaidRoom();

    boolean isRealPlay();

    boolean isReplayRoom();

    Boolean isSysExtendedCastMode();

    boolean isSysMiracast();

    Boolean isXsgDeviceShowNotBDLink();

    boolean needControlClickEventPassThrough();

    void onChangeResolution(LiveCastResolutionInfo r100);

    void onControlPageClose(Context r100, boolean r101, int r102);

    void onDanmakuButtonClick(boolean r100);

    void onDeviceSelected(boolean r100, ILiveCastSourceUIDevice r101, ILiveCastSourceUIDevice r102);

    void onExitCasting();

    boolean onKeyEvent(KeyEvent r100);

    void onOpenWebPageClick(String r100, boolean r101, int r102);

    void onPlayStatus(int r100);

    boolean openWebPage(Context r100, String r101);

    String playerResolution();

    boolean searchNeedStartControl();

    void setIsFakePlay(boolean r100);

    void setReplayMediaInfo(long r100, String r101);

    void showCastControlView();

    boolean showHalfControlBackIcon();

    boolean showHalfPlayController();

    boolean showLandscapePlayController();

    boolean showLandscapeSearchMaskBg();

    boolean supportChangeResolution();

    boolean supportEpisode();

    boolean supportFoldMode();

    boolean useRouteOutCertIdToIntent(Context r100, Intent r101);
}
