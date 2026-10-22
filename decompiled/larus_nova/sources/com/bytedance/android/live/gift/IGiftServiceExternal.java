package com.bytedance.android.live.gift;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import ca0.b;
import ca0.c;
import ca0.g;
import ca0.o;
import ca0.r;
import ca0.w;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.resources.AssetsModel;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.Gift;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.m1;
import com.bytedance.android.livesdk.gift.model.m2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.f;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayControllerManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import ga0.a;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.live.revenue.service.gift.GiftServiceWrapper")
public interface IGiftServiceExternal extends IService {
    void autoPlayMP4(String r100, Long r101, String r102);

    void cleanGiftDishCache();

    Long clearAppAssetDir(Boolean r100);

    void clearAssets(String r100);

    void clearGiftExposureCache();

    void clearGiftMemoryCache();

    void clearMarkResource();

    Bundle clearOverdueResource();

    void clearSensitiveLRUAsset();

    void downloadAssets(String r100, long r101, f r102, int r103);

    Gift findGiftById(long r100);

    m1 findGiftExtraInfo(long r100);

    h2 findLiteGiftById(long r100);

    AssetsModel getAssets(String r100, long r101);

    IAssetsManager getAssetsManager();

    String getAssetsPath(String r100, long r101);

    BaseCommentGiftGuideView getCommentGiftGuideView(Context r100);

    c getCommonPlayerControllerManager();

    c0.b getEffectGameToolbarBehavior(Context r100, String r101);

    Gift getFastGift();

    LiveRecyclableWidget getGestureGiftGuideWidget();

    b getGiftAnimationEngine(GiftType r100);

    LiveRecyclableWidget getGiftEffectInfoLynxWidget();

    LiveRecyclableWidget getGiftFourthLineWidget();

    LiveRecyclableWidget getGiftFrontSeatLayerEffectWidget();

    Dialog getGiftGuideDialog(Context r100, Room r101, IUser r102, ga0.b r103, long r104, String r105, long r106, String r110, DataCenter r111);

    a getGiftGuidePresenter(DataCenter r100);

    List<zo2.a> getGiftNitaViewList();

    List<zo2.a> getGiftPanelNitaViewList();

    Class<? extends LiveRecyclableWidget> getGiftPreviewDebugWidget();

    LiveRecyclableWidget getGiftTouchReceiveWidget();

    ca0.a getGiftTrayHeightInfo();

    uu0.a getGiftTrayPreviewView(Context r100, uu0.b r101);

    r getGiftUIStrategy();

    int getGiftUseDiskCacheSize();

    f6.c getGiftWidget(Context r100, LifecycleOwner r101, DataCenter r102, int r103);

    Class<? extends Widget> getGiftWidgetClass();

    long getLastEnterRoomTime();

    Widget getMatchRoomGiftTrayWidget();

    Class<? extends Widget> getMultiPlayerClass();

    LiveRecyclableWidget getPKBattlePropEffectWidget();

    LiveRecyclableWidget getPKTrayWidget();

    o getRevenueEventCenter();

    IRevenueFeedGameEffectServiceContainer getRevenueFeedGameEffectServiceContainer(ViewGroup r100);

    long getSendGiftMoney();

    long getSendGiftTime();

    long getSensitiveClearAssetSize();

    List<Gift> getStickerGifts();

    LiveRecyclableWidget getTopAtmosphereEffectWidget();

    int getUserConsumeLevel();

    ILiveGiftPlayControllerManager giftPlayControllerManager();

    void initGiftModule(Context r100, LifecycleOwner r101, DataCenter r102);

    void initGiftResourceCache();

    void initGiftResourceManager(Context r100);

    boolean isAssetsDownloaded(String r100, long r101);

    boolean isGiftListLoaded();

    void monitorEffectPlayEvent(EffectMessage r100, String r101, int r102, String r103, JSONObject r104);

    void monitorEffectPlayEvent(o7 r100, String r101, int r102, String r103, JSONObject r104);

    Observable<JSONObject> observeGiftMsgContent();

    void openGiftEffectConfigurationDialog(Context r100, Boolean r101, Boolean r102);

    void openGroupLiveDialog(String r100);

    void receiveStickGiftMSgEvent(o7 r100);

    void registerInRoomService(g r100);

    void registerMonkeyGameEngine(ea0.a r100);

    void removeAnimationEngine(GiftType r100);

    void removeFastGiftFromMap(long r100);

    void removeMonkeyGameEngine();

    void removeTemporaryFastGift(long r100);

    void reportStickEffectRenderResult(HashMap<String, String> r100);

    void reportStickResourceLoadResult(HashMap<String, String> r100);

    Observable<ExtraResponse<p2, ? extends Extra>> sendGift(b0 r100, int r101);

    void sendPlayAlphaVideoEvent(zg1.h2 r100);

    Observable<ExtraResponse<m2, Extra>> sendProp(b0 r100, int r101);

    void setAllowSendToGuest(boolean r100);

    void setGiftAnimationEngine(GiftType r100, b r101) throws Exception;

    void setTemporaryFastGift(long r100);

    void stickFirstFrameEvent(String r100, String r101, JSONObject r102, HashMap<String, String> r103);

    void syncAssetsList(String r100, int r101);

    void syncGiftList();

    void syncGiftList(int r100);

    void syncGiftList(w r100, long r101, int r102, boolean r103, String r104);

    void syncGiftPanel();

    void syncMultiAnchorList();

    void toggleVideoGiftView(boolean r100);

    void triggerGiftAsyncSort(JSONObject r100);

    void unRegisterInRoomService();

    void updateHotRoomInfo(float r100, double r101, double r102);
}
