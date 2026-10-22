package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.moreliveentrance.LiveTabForceRefreshStyle;
import com.bytedance.android.livehostapi.business.base.IBaseHostBusiness;
import com.bytedance.android.livehostapi.business.depend.DialogListener;
import com.bytedance.android.livehostapi.business.depend.IImageTemplateApplyCallback;
import com.bytedance.android.livehostapi.business.depend.IShowDialogParam;
import com.bytedance.android.livehostapi.business.depend.IShowPoiSearchCallback;
import com.bytedance.android.livehostapi.business.depend.IUserAgreePrivacyPolicyListener;
import com.bytedance.android.livehostapi.business.depend.elder.LiveElderModeConfig;
import com.bytedance.android.livehostapi.business.depend.highlight.PublishHighlightVideoData;
import com.bytedance.android.livehostapi.business.depend.largefont.IHostLargeFontService;
import com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdkapi.listener.ICallStatusListener;
import com.bytedance.android.livesdkapi.ms.ILiveMsManager;
import gz.a;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jz.b;
import jz.d;
import jz.f;
import jz.h;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IMiddlewareHostBusiness extends IService, IBaseHostBusiness {
    public static final int LIVE_VIDEO_PLAY_USER_TYPE_ANCHOR = 1;
    public static final int LIVE_VIDEO_PLAY_USER_TYPE_GUEST = 2;
    public static final int LIVE_VIDEO_PLAY_USER_TYPE_NORMAL = 3;

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getSourceBtmToken2Schema(IMiddlewareHostBusiness r100, View r101, JSONObject r102) {
            return null;
        }

        public static JSONObject $default$getTTWebViewPerfTiming(IMiddlewareHostBusiness r100, WebView r101) {
            return null;
        }

        public static boolean $default$isLivePushOpen(IMiddlewareHostBusiness r100) {
            return false;
        }

        public static boolean $default$isTTWebView(IMiddlewareHostBusiness r100) {
            return false;
        }

        public static void $default$openAlbum(IMiddlewareHostBusiness r100, Activity r101, ArrayList r102) {
        }

        public static ArrayList $default$parseIntent(IMiddlewareHostBusiness r100, Intent r101) {
            return null;
        }

        public static void $default$updateLivePushOpen(IMiddlewareHostBusiness r100, boolean r101) {
        }

        public static List $default$getHostRejectControllerBusinessTypes(IMiddlewareHostBusiness r100) {
            return Collections.emptyList();
        }
    }

    public interface AuthorizeCallback {
        void onAuthorized();

        void onDisauthorized();

        void onInterrupted();
    }

    public interface AwemeCustomPureVideoPlayerView {
        View asView();

        void pauseVideoPlayer();

        void releaseVideoPlayer();

        void resumeVideoPlayer();

        void setCallback(AwemeVideoPlayFragmentCallback r100);

        void startVideoPlayer(Object r100, int r101, int r102, long r103);

        void stopVideoPlayer();
    }

    public interface AwemeQueryCallBack {
        void onBatchSuccess(HashMap<Long, Object> r100);

        void onFailure(String r100, String r101, String r102);

        void onSuccess(Object r100, long r101);
    }

    public interface AwemeVideoPlayFragment {
        DialogFragment asDialogFragment();

        void setCallback(AwemeVideoPlayFragmentCallback r100);
    }

    public interface AwemeVideoPlayFragmentCallback {
        void onDismiss();

        void onPausePlay(String r100, long r101, String r102);

        void onPlayCompletedFirstTime(String r100);

        void onPlayFailed(String r100, String r101);

        void onPlaying(String r100);

        void onRenderFirstFrame(String r100);

        void onResumePlay(String r100, String r101);

        void onShow();
    }

    public interface AwemeVideoPlayFragmentV2 {
        Fragment asFragment();

        void setCallback(AwemeVideoPlayFragmentCallback r100);

        void setPlayOnResume(boolean r100);
    }

    public interface HashTagCallback {
        void onDismiss();

        void onJumpToOtherRoom(long r100, String r101, long r102);

        void onShow();

        void onVideoRecordOpened();
    }

    public interface HotSpotCallback {
        void onDismiss();

        void onJumpToHotSpotDetail();

        void onShow();
    }

    public interface OnActionCallback {
        void onActionError(String r100);
    }

    public interface OnLiveHighlightPublish {
        public static final int calcel = 2;
        public static final int fail = 1;
        public static final int publishing = 3;
        public static final int success = 0;

        void onPublish(int r100);
    }

    public interface TemplateCallback {
        void onFailed(String r100);

        void onSuccess(byte[] r100);
    }

    public interface onLightLivePublishCallback {
        void response(int r100, String r101, String r102);
    }

    public interface onLivePublishCallback {
        void onClose();

        void onPublish(JSONObject r100);
    }

    boolean addPrivacyAgreeListener(IUserAgreePrivacyPolicyListener r100);

    void appendBcmInfo(Map<String, Object> r100, String r101, Map<String, String> r102);

    void appendExtGlobalProps(Map<String, Object> r100, String r101);

    void applyImageTemplateToLocal(String r100, String r101, Map<String, String> r102, IImageTemplateApplyCallback r103);

    void callRemoveRoom(String r100);

    Boolean canShowPushPermissionGuide();

    void cancelVideoPublish(String r100);

    boolean checkLynxPlugin();

    int concatVideo(String[] r100, String r101);

    String createBtmId(String r100, Object r101);

    Map<String, Object> createReportParams(String r100, Object r101);

    LiveElderModeConfig elderModeConfig();

    void enterLiveChannel(Context r100, Map<String, String> r101, String r102, Bundle r103, boolean r104, boolean r105, LiveTabForceRefreshStyle r106);

    String getBtmIdByWidget(String r100);

    String getCurrentUserAddress(Object r100, String r101, int r102);

    Map<String, String> getEcomExtraLogParams(String r100, Map<String, String> r101, View r102);

    void getFollowStatusFromIMDB(String r100, String r101, String r102, Function1<Pair<Integer, Integer>, Void> r103);

    List<String> getHostRejectControllerBusinessTypes();

    Dialog getHotSpotDialog(Activity r100, boolean r101, String r102, String r103, HotSpotCallback r104);

    IHostLargeFontService getLiveLargeFontService();

    ILiveMultiTabDepend getLiveMultiTabDepend();

    String getLivePoiId();

    String getLivePoiName();

    AwemeVideoPlayFragment getLivePureVideoPlayFragment(Object r100, Context r101, long r102, int r103);

    AwemeVideoPlayFragmentV2 getLivePureVideoPlayFragmentV2(Object r100, int r101, Context r102, long r103);

    AwemeCustomPureVideoPlayerView getLivePureVideoPlayerView(Context r100, int r101, int r102, long r103);

    Pair<Integer, String> getLivePushOpenType();

    ILiveMsManager getMsManager();

    DialogFragment getPoiSearchModalDialog(Context r100, a r101, IShowPoiSearchCallback r102);

    boolean getPreviewAnswerClickEnable();

    List<BaseEmoji> getRecommendEmojiList();

    String getSourceBtmToken2Schema(View r100, JSONObject r101);

    JSONObject getTTWebViewPerfTiming(WebView r100);

    boolean hasCachedView(String r100, int r101);

    boolean hasCellularPermission();

    void hideStickerView();

    boolean isEnablePersonalRecommend();

    boolean isInAvCallFloatWindow();

    boolean isLivePushOpen();

    boolean isPadSplit();

    boolean isShowStickerView();

    boolean isTTWebView();

    boolean isUserAgreePrivacyPolicy();

    void loadLynxSoLib(View r100);

    void loadTemplate(String r100, TemplateCallback r101);

    Map<String, String> obtainEventParams(Map<String, String> r100, View r101);

    void onNetworkQualityChanged(int r100, String r101);

    void openAlbum(Activity r100, ArrayList<String> r101);

    void openEditAndPublishPage(PublishHighlightVideoData r100);

    void openLiveCommonVerifyActivity(Context r100, Intent r101);

    void openSoloKtvSharePanel(Activity r100, Bundle r101);

    void openTaobaoApp(Context r100, String r101, OnActionCallback r102);

    void openVideoDetailPage(String r100, String r101);

    ArrayList<JSONObject> parseIntent(Intent r100);

    void preloadTemplateResource(String r100);

    void publishVideo(Context r100, f r101, b r102);

    Disposable queryAweme(long r100, AwemeQueryCallBack r101);

    Disposable queryBatchAweme(List<Long> r100, AwemeQueryCallBack r101);

    void registerCallStatusListener(ICallStatusListener r100);

    void releaseStickerView();

    void requestForShoppingAccess(Context r100, String r101);

    void resetPoiMemoryPoiDetailData();

    void sendUrgeRequest(String r100, List<String> r101, String r102, Function1<String, Unit> r103);

    void setLinkMicFloatWindowState(boolean r100);

    Dialog showDialog(Context r100, CharSequence r101, CharSequence r102, CharSequence r103, DialogListener r104, CharSequence r105, DialogListener r106, IShowDialogParam r107);

    DialogFragment showHashTagDialog(Activity r100, String r101, HashTagCallback r102);

    void showManagePoiDialog(Context r100, boolean r101, long r102, DialogInterface.OnDismissListener r103);

    void showPoiInfoDialogForAudience(Context r100, String r101, String r102, String r103);

    void showVcdContentGrant(FragmentActivity r100, String r101, String r102, AuthorizeCallback r103);

    void showVcdRelationshipGrant(FragmentActivity r100, String r101, String r102, AuthorizeCallback r103);

    DialogFragment showVsTopicDialog(Activity r100, String r101, int r102, boolean r103, int r104, HashTagCallback r105);

    void soloKtvVideoSaveDraft(Context r100, h r101, b r102);

    void soloKtvVideoSilentPublish(Context r100, h r101, d r102);

    void startLightPublishActivity(Context r100, Intent r101, onLightLivePublishCallback r102);

    void startLivePublishActivity(Context r100, Intent r101, onLivePublishCallback r102);

    View tryGetPreLoadLiveLayouts(int r100, String r101, Activity r102, ViewGroup r103, Boolean r104, Boolean r105, LayoutInflater r106);

    boolean tryOpenAdByOpenUrl(Context r100, long r101, String r102, String r103);

    void unregisterCallStatusListener(ICallStatusListener r100);

    void updateLivePushOpen(boolean r100);

    boolean videoIsPublishable();
}
