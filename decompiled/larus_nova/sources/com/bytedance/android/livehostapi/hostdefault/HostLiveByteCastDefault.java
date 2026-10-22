package com.bytedance.android.livehostapi.hostdefault;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import com.bytedance.android.livehostapi.business.IHostLiveByteCast;
import com.bytedance.android.livehostapi.business.IHostLiveByteCastForSaas;
import com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast;
import com.bytedance.android.livehostapi.business.castscreen.bean.ILiveCastSourceUIDevice;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastPlayInfo;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastPlayState;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ICastResultListener;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceImpl;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIDepend;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIPlayerListener;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.IMiracastStateListener;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class HostLiveByteCastDefault implements IHostLiveByteCast {
    public HostLiveByteCastDefault() {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void addGlobalPlayListener(ILiveCastSourceUIPlayerListener r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void appendCastSDKLogCommonParams(String r100, JSONObject r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public boolean beforeReconnectPlay(ILiveCastSourceUIDepend r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public boolean canShowBtn() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast
    public final /* synthetic */ boolean castEnabled() {
        return IMiddlewareHostLiveByteCast.CC.$default$castEnabled(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public void clearCompatibleResolution() {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void closeAllCastActivity() {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void closeSearchActivity() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCastForSaas
    public final /* synthetic */ boolean enable() {
        return IHostLiveByteCastForSaas.CC.$default$enable(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast
    public boolean enableCastFlowAllScene() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public boolean enableCastPreSearch() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public boolean enableCompatible() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast
    public boolean enableLiveCastFlow() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast
    public boolean enablePlayStatusAllOpt() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void exitCasting() {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void forceReplay(ILiveCastSourceUIDepend r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast
    public String getCastFlowFrom() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public View getCastHalfControlView(Context r100, ILiveCastSourceUIDepend r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public View getCastLandscapeControlView(Context r100, ILiveCastSourceUIDepend r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public ILiveCastSourceImpl getCastSourceImpl() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public JSONObject getCastUISettings() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public ILiveCastSourceUIDevice getCastingDevice() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public LiveCastPlayInfo getCastingPlayInfo() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public int getCurrentCastingSceneId() {
        return 0;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public long getCurrentPlayPosition() {
        return 0;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ Display getDisplay() {
        return IHostLiveByteCast.CC.$default$getDisplay(this);
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public String getFeedBackSchema(ILiveCastSourceUIDepend r100) {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCastForSaas
    public final /* synthetic */ View getLoadingAnimationView() {
        return IHostLiveByteCastForSaas.CC.$default$getLoadingAnimationView(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ boolean getMiracastExperimentValue(ILiveCastSourceUIDepend r100) {
        return IHostLiveByteCast.CC.$default$getMiracastExperimentValue(this, r100);
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public Object getOptions(int r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ List getOrderedLiveStreamList(Room r100) {
        return IHostLiveByteCast.CC.$default$getOrderedLiveStreamList(this, r100);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public Display getRemoteDisplay() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public String getScreencastSessionId() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public String getScreencastType() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ Long getSearchTimeoutPeriodWifiXsg() {
        return IHostLiveByteCast.CC.$default$getSearchTimeoutPeriodWifiXsg(this);
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public boolean getShowControlFeedback(ILiveCastSourceUIDepend r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast
    public final /* synthetic */ boolean hostEntryEnable() {
        return IMiddlewareHostLiveByteCast.CC.$default$hostEntryEnable(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCastForSaas
    public final /* synthetic */ void initCastSDK() {
        IHostLiveByteCastForSaas.CC.$default$initCastSDK(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast
    public void initCastUI() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCastForSaas
    public final /* synthetic */ boolean isCastSDKInit() {
        return IHostLiveByteCastForSaas.CC.$default$isCastSDKInit(this);
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public boolean isCasting() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public boolean isOfficalDevice(ILiveCastSourceUIDevice r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public boolean isSearchDialogShowing() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ boolean isSysMiracast() {
        return IHostLiveByteCast.CC.$default$isSysMiracast(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public boolean isValid() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ Boolean isXsgDeviceShowNotBDLink() {
        return IHostLiveByteCast.CC.$default$isXsgDeviceShowNotBDLink(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ boolean liveCastH265Disable() {
        return IHostLiveByteCast.CC.$default$liveCastH265Disable(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ boolean liveCastUseStreamData() {
        return IHostLiveByteCast.CC.$default$liveCastUseStreamData(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public String liveClarityStrategy() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void liveGoRealTime() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ boolean liveOnlySupportXsg() {
        return IHostLiveByteCast.CC.$default$liveOnlySupportXsg(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ int liveOnlySupportXsgForMatchRoom() {
        return IHostLiveByteCast.CC.$default$liveOnlySupportXsgForMatchRoom(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ void loadPlugin() {
        IHostLiveByteCast.CC.$default$loadPlugin(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ void logCastClose(ILiveCastSourceUIDepend r100, JSONObject r101) {
        IHostLiveByteCast.CC.$default$logCastClose(this, r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ void logCastStart(ILiveCastSourceUIDepend r100, JSONObject r101) {
        IHostLiveByteCast.CC.$default$logCastStart(this, r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ void logMiraFetchMedia(ILiveCastSourceUIDepend r100, JSONObject r101) {
        IHostLiveByteCast.CC.$default$logMiraFetchMedia(this, r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void logScreenCastEnter(Function1<? super JSONObject, Unit> r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ void notifyExtendedCastMode(boolean r100) {
        IHostLiveByteCast.CC.$default$notifyExtendedCastMode(this, r100);
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public boolean performChangeLiveFlow() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public boolean performOpenFeedBack() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void preSearchDevice() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ void registerMiracastStateListener(IMiracastStateListener r100) {
        IHostLiveByteCast.CC.$default$registerMiracastStateListener(this, r100);
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void removeGlobalPlayListener(ILiveCastSourceUIPlayerListener r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void savePlayInfo(boolean r100, Room r101, Long r102, String r103, LiveCastPlayInfo r104) {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void sendBusinessEvent(int r100, JSONObject r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void sendCastSDKLog(String r100, JSONObject r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void sendToast(ILiveCastSourceUIDevice r100, String r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast
    public void showOrHideCastFlow(boolean r100, String r101, Room r102, long r103, long r104, String r105) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public int startCast(Context r100, ILiveCastSourceUIDepend r101, boolean r102) {
        return 0;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public boolean startCastControlActivity(Context r100, ILiveCastSourceUIDepend r101) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void startCastGuideDialog(Context r100, ILiveCastSourceUIDepend r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public boolean startCastLandscapeSearchActivity(Context r100, ILiveCastSourceUIDepend r101) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public boolean startCastSearchActivity(Context r100, ILiveCastSourceUIDepend r101) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void startCastSendPlay(View r100, ILiveCastSourceUIDepend r101, ICastResultListener r102, boolean r103) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCastForSaas
    public final /* synthetic */ void startLoadingAnimation() {
        IHostLiveByteCastForSaas.CC.$default$startLoadingAnimation(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCastForSaas
    public final /* synthetic */ void stopLoadingAnimation() {
        IHostLiveByteCastForSaas.CC.$default$stopLoadingAnimation(this);
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public void stopSearchDevice() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ void unregisterMiracastStateListener(IMiracastStateListener r100) {
        IHostLiveByteCast.CC.$default$unregisterMiracastStateListener(this, r100);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public final /* synthetic */ boolean useNewPortraitUi() {
        return IHostLiveByteCast.CC.$default$useNewPortraitUi(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveByteCast
    public boolean useRouteOutCertIdToIntent(String r100, Context r101, Intent r102) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast
    public final /* synthetic */ boolean useRouteOutCertIdToIntentReplay(String r100, Context r101, Intent r102) {
        return IMiddlewareHostLiveByteCast.CC.$default$useRouteOutCertIdToIntentReplay(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.ILiveCastSourceUIManager
    public LiveCastPlayState getPlayState() {
        return LiveCastPlayState.UNKNOWN;
    }
}
