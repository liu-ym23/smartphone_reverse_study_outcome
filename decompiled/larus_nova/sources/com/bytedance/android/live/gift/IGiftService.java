package com.bytedance.android.live.gift;

import am2.f0;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import ca0.b;
import ca0.g;
import ca0.i;
import ca0.j;
import ca0.l;
import ca0.o;
import ca0.q;
import ca0.r;
import ca0.s;
import ca0.w;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.m1;
import com.bytedance.android.livesdk.gift.model.m2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.f;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.livesdk.log.model.WishComboDataLog;
import com.bytedance.android.livesdk.message.model.n6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayControllerManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.lynx.tasm.LynxView;
import dy0.c;
import ga0.a;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.livesdk.gift.platform.core.GiftServiceKt")
public interface IGiftService extends j, IService, c {
    @Override // ca0.j
    /* synthetic */ void addGiftSendResultListener(s r100);

    /* synthetic */ boolean allowSendToGuest();

    /* synthetic */ void autoPlayMP4(String r100, Long r101, String r102);

    /* synthetic */ boolean checkGroupContainerType(int r100);

    /* synthetic */ void cleanGiftDishCache();

    /* synthetic */ Long clearAppAssetDir(Boolean r100);

    /* synthetic */ void clearAssets(String r100);

    @Override // ca0.j
    /* synthetic */ void clearBattlePropCardMessageQueue();

    /* synthetic */ void clearGiftExposureCache();

    /* synthetic */ void clearGiftMemoryCache();

    /* synthetic */ void clearMarkResource();

    /* synthetic */ Bundle clearOverdueResource();

    /* synthetic */ void clearSensitiveLRUAsset();

    /* synthetic */ void closeGiftDialog();

    @Override // ca0.j
    /* synthetic */ void convertHonorImageModel(k r100);

    @Override // ca0.j
    /* synthetic */ List<String> convertRichContentImageUrls(List<String> r100);

    View createView(String r100, Context r101, AttributeSet r102);

    @Override // ca0.j
    /* synthetic */ void downloadAssets(String r100, long r101, f r102, int r103);

    @Override // ca0.j
    /* synthetic */ void downloadAssets(String r100, long r101, f r102, int r103, AssetDownloadPriority r104);

    @Override // ca0.j
    /* synthetic */ h1 findGiftById(long r100);

    /* synthetic */ m1 findGiftExtraInfo(long r100);

    @Override // ca0.j
    /* synthetic */ h2 findLiteGiftById(long r100);

    /* synthetic */ e getAssets(String r100, long r101);

    @Override // ca0.j
    /* JADX INFO: renamed from: getAssetsManager */
    /* synthetic */ IAssetsManager mo8235getAssetsManager();

    @Override // ca0.j
    /* synthetic */ String getAssetsPath(String r100, long r101);

    @Override // ca0.j
    /* synthetic */ BaseCommentGiftGuideView getCommentGiftGuideView(Context r100);

    /* synthetic */ ca0.c getCommonPlayerControllerManager();

    /* synthetic */ IBaseUser getDefaultUserToSendGift();

    /* synthetic */ View.OnClickListener getEffectGameToolbarBehavior(Context r100, String r101);

    /* synthetic */ Map<String, String> getEventCenterCommonParams();

    @Override // ca0.j
    /* synthetic */ h1 getFastGift();

    /* synthetic */ LiveRecyclableWidget getGestureGiftGuideWidget();

    /* synthetic */ b getGiftAnimationEngine(GiftType r100);

    /* synthetic */ LiveRecyclableWidget getGiftEffectInfoLynxWidget();

    /* synthetic */ LiveRecyclableWidget getGiftFourthLineWidget();

    /* synthetic */ LiveRecyclableWidget getGiftFrontSeatLayerEffectWidget();

    /* synthetic */ Dialog getGiftGuideDialog(Context r100, IRoom r101, IBaseUser r102, ga0.b r103, long r104, String r105, long r106, String r110, DataCenter r111);

    /* synthetic */ a getGiftGuidePresenter(DataCenter r100);

    o7 getGiftMessage(long r100, p2 r101, IBaseUser r102);

    /* synthetic */ List<zo2.a> getGiftNitaViewList();

    /* synthetic */ List<zo2.a> getGiftPanelNitaViewList();

    /* synthetic */ Class<? extends LiveRecyclableWidget> getGiftPreviewDebugWidget();

    @Override // ca0.j
    /* synthetic */ i getGiftRenderFilterWrapper();

    @Override // ca0.j
    /* synthetic */ BehaviorSubject<Long> getGiftSelectObservable();

    /* synthetic */ LiveRecyclableWidget getGiftTouchReceiveWidget();

    /* synthetic */ uu0.a getGiftTrayPreviewView(Context r100, uu0.b r101);

    @Override // ca0.j
    /* synthetic */ boolean getGiftTraySwitch();

    /* synthetic */ r getGiftUIStrategy();

    /* synthetic */ int getGiftUseDiskCacheSize();

    @Override // ca0.j
    /* synthetic */ l getGiftWallPreRequestManager();

    /* synthetic */ f6.c getGiftWidget(Context r100, LifecycleOwner r101, DataCenter r102, int r103);

    /* synthetic */ Class<? extends Widget> getGiftWidgetClass();

    @Override // ca0.j
    /* synthetic */ List<IBaseUser> getGroupMemberList();

    @Override // ca0.j
    /* synthetic */ int getGroupMemberNum();

    /* synthetic */ boolean getIsNewGiftPanel();

    /* synthetic */ long getLastEnterRoomTime();

    /* synthetic */ o getLiveRevenueEventCenter();

    @Override // ca0.j
    /* synthetic */ Widget getMatchRoomGiftTrayWidget();

    /* synthetic */ Class<? extends Widget> getMultiPlayerClass();

    @Override // ca0.j
    /* synthetic */ boolean getNeedShowGiftEffectSwitch();

    /* synthetic */ LiveRecyclableWidget getPKBattlePropEffectWidget();

    /* synthetic */ LiveRecyclableWidget getPKTrayWidget();

    /* synthetic */ IRevenueFeedGameEffectServiceContainer getRevenueFeedGameEffectServiceContainer(ViewGroup r100);

    /* synthetic */ long getSendGiftMoney();

    f0 getSendGiftResultLog(p2 r100);

    /* synthetic */ long getSendGiftTime();

    /* synthetic */ long getSensitiveClearAssetSize();

    /* synthetic */ List<h1> getStickerGifts();

    /* synthetic */ LiveRecyclableWidget getTopAtmosphereEffectWidget();

    @Override // ca0.j
    /* synthetic */ q getUICanvasMonitor();

    /* synthetic */ int getUserConsumeLevel();

    WishComboDataLog getWishComboDataMap();

    /* synthetic */ ILiveGiftPlayControllerManager giftPlayControllerManager();

    /* synthetic */ boolean hasExpiredPKPropCard();

    @Override // ca0.j
    /* synthetic */ boolean hasPKPropCard();

    /* synthetic */ void initGiftEffectDialog();

    /* synthetic */ void initGiftModule(Context r100, LifecycleOwner r101, DataCenter r102);

    /* synthetic */ void initGiftResourceCache();

    /* synthetic */ void initGiftResourceManager(Context r100);

    void injectLiveLynxCanvasTTPlayer(LynxView r100, Context r101, String r102);

    @Override // ca0.j
    /* synthetic */ boolean isAssetsDownloaded(String r100, long r101);

    /* synthetic */ boolean isGiftListLoaded();

    /* synthetic */ boolean isVSGiftIconShow(DataCenter r100);

    void monitorEffectPlayEvent(EffectMessage r100, String r101, int r102, String r103, JSONObject r104);

    void monitorEffectPlayEvent(o7 r100, String r101, int r102, String r103, JSONObject r104);

    /* synthetic */ boolean needFrequencyRoomNotifyMessage();

    @Override // ca0.j
    /* synthetic */ void notifyLowPriorityDownloadTask(Boolean r100);

    /* synthetic */ Observable<JSONObject> observeGiftMsgContent();

    Observable onDialogHide();

    void openGiftDialog(int r100);

    /* synthetic */ void openGiftDialog(int r100, long r101, Bundle r102, String r103, long r104);

    /* synthetic */ void openGiftDialog(int r100, long r101, Bundle r102, List<String> r103, boolean r104, String r105);

    /* synthetic */ void openGiftDialog(int r100, long r101, String r102, Bundle r103, int r104, JSONObject r105);

    /* synthetic */ void openGiftDialog(int r100, long r101, String r102, Bundle r103, int r104, JSONObject r105, String r106);

    /* synthetic */ void openGiftDialog(int r100, long r101, String r102, Bundle r103, JSONObject r104);

    /* synthetic */ void openGiftDialog(int r100, IBaseUser r101);

    /* synthetic */ void openGiftDialog(IBaseUser r100);

    @Override // ca0.j
    /* synthetic */ void openGiftDialog(IBaseUser r100, Bundle r101);

    /* synthetic */ void openGiftDialog(String r100);

    /* synthetic */ void openGiftDialog(String r100, IBaseUser r101);

    /* synthetic */ void openGiftDialog(String r100, IBaseUser r101, Bundle r102);

    /* synthetic */ void openGiftEffectConfigurationDialog(Context r100, Boolean r101, Boolean r102);

    /* synthetic */ void openGroupLiveDialog(String r100);

    /* synthetic */ void openInteractGiftDialog(Context r100, int r101, Long r102, String r103, Function0<Unit> r104, DialogInterface.OnDismissListener r105);

    /* synthetic */ void playUsePropCardAnimation(k r100, Pair<Integer, Integer> r101);

    /* synthetic */ void playUsePropCardAnimationOnLeftCount(k r100, View r101);

    @Override // ca0.j
    /* synthetic */ void processRevenueApiResponse(String r100, JSONObject r101);

    /* synthetic */ void receiveBattleDrawPropCardMessage(n6 r100);

    void receiveStickGiftMSgEvent(o7 r100);

    @Override // ca0.j
    /* synthetic */ void registerGiftPreviewDebugWidgetInstance(LiveRecyclableWidget r100);

    /* synthetic */ void registerInRoomService(g r100);

    /* synthetic */ void registerMonkeyGameEngine(ea0.a r100);

    /* synthetic */ void registerRecommendReceiver(long r100, String r101, Map<String, String> r102, Map<String, String> r103);

    /* synthetic */ void registerRecommendReceiver(String r100, String r101, Map<String, String> r102, Map<String, String> r103);

    /* synthetic */ void removeAnimationEngine(GiftType r100);

    /* synthetic */ void removeFastGiftFromMap(long r100);

    @Override // ca0.j
    /* synthetic */ void removeGiftSendResultListener(s r100);

    /* synthetic */ void removeMonkeyGameEngine();

    /* synthetic */ void removeTemporaryFastGift(long r100);

    void reportStickEffectRenderResult(HashMap<String, String> r100);

    void reportStickResourceLoadResult(HashMap<String, String> r100);

    @Override // ca0.j
    /* synthetic */ Observable<ExtraResponse<p2, ? extends Extra>> sendGift(b0 r100, int r101);

    /* synthetic */ void sendPlayAlphaVideoEvent(zg1.h2 r100);

    /* synthetic */ Observable<ExtraResponse<m2, Extra>> sendProp(b0 r100, int r101);

    @Override // ca0.j
    /* synthetic */ void setAllowSendToGuest(boolean r100);

    /* synthetic */ void setDefaultUserToSendGift(IBaseUser r100);

    /* synthetic */ void setGiftAnimationEngine(GiftType r100, b r101) throws Exception;

    /* synthetic */ void setGiftTraySwitch(boolean r100);

    @Override // ca0.j
    /* synthetic */ void setNeedShowGiftEffectSwitch(boolean r100);

    /* synthetic */ void setTemporaryFastGift(long r100);

    t startSendMultiGift(b0 r100);

    void stickFirstFrameEvent(String r100, String r101, JSONObject r102, HashMap<String, String> r103);

    Observable<Boolean> subscribeOnBanner();

    @Override // ca0.j
    void syncAssetsList(String r100, int r101);

    /* synthetic */ void syncGiftList();

    @Override // ca0.j
    void syncGiftList(int r100);

    /* synthetic */ void syncGiftList(w r100, long r101, int r102, boolean r103, String r104);

    /* synthetic */ void syncGiftListById(w r100, long r101, int r102, boolean r103, String r104, Long r105, boolean r106);

    @Override // ca0.j
    /* synthetic */ void syncGiftPanel();

    @Override // ca0.j
    /* synthetic */ void syncMultiAnchorList();

    /* synthetic */ void toggleVideoGiftView(boolean r100);

    @Override // ca0.j
    /* synthetic */ void triggerGiftAsyncSort(JSONObject r100);

    /* synthetic */ void unRegisterInRoomService();

    /* synthetic */ void unRegisterRecommendReceiver(String r100, Map<String, String> r101);

    @Override // ca0.j
    void updateGiftTrayPosition(zg1.f0 r100);

    /* synthetic */ void updateHotRoomInfo(float r100, double r101, double r102);
}
