package com.bytedance.android.live.revlink.api;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import cy0.a;
import dy0.c;
import fr2.p;
import gt1.b;
import java.util.List;
import java.util.Map;
import kc0.d;
import kc0.g;
import kc0.h;
import kc0.j;
import kc0.k;
import kc0.m;
import kc0.o;
import kc0.q;
import kc0.r;
import kc0.s;
import kotlin.Metadata;
import ld.f;
import org.json.JSONObject;
import p11.i;
import pc0.e;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.live.revlink.impl.RevLinkService")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J \u0010\u000e\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH&J \u0010\u000f\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/api/ILinkService;", "", "Lkc0/j;", "Ldy0/c;", "Lorg/json/JSONObject;", "featureObj", "", "setFeatureParams", "Lgt1/b;", "getMultiAnchorStatus", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lgt1/d;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "observer", "registerPkStateChangeObserver", "unRegisterPkStateChangeObserver", "Lfr2/p;", "getLiveCore", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkService extends k, j, c {
    @Override // kc0.j
    /* synthetic */ r createRevMultiControlWidget(r.a r100, ViewGroup r101, Boolean r102, boolean r103);

    @Override // kc0.k
    /* synthetic */ e createRevRtcData();

    @Override // kc0.k
    /* synthetic */ a enterLivePlay(f r100);

    @Override // kc0.j
    /* synthetic */ Class<? extends Widget> getAnchorTicketWidgetClass();

    @Override // kc0.k
    /* synthetic */ com.bytedance.android.live.revenuelink.connect.f getConnectService();

    /* synthetic */ String getConnectionType();

    /* synthetic */ int getCurrentAudienceCount();

    @Override // kc0.k
    /* synthetic */ int getEnterRoomLinkmicScene();

    @Override // kc0.j
    /* synthetic */ qc0.f getInteractFeedView(Context r100, pc0.a r101, int r102, d r103);

    @Override // kc0.k
    /* synthetic */ List<RevImCacheUnit> getInteractFeedViewImCaches();

    /* synthetic */ String getInviteModeStatus();

    @Override // kc0.k
    /* synthetic */ String getLinkAnchorCount();

    /* synthetic */ i getLinkRegionService();

    @Override // kc0.k
    /* synthetic */ kc0.i getLinkRegionServiceExternal();

    p getLiveCore();

    @Override // kc0.k
    /* synthetic */ m getMultiAnchorService();

    @Override // kc0.k
    /* synthetic */ p11.e getMultiAnchorService();

    b getMultiAnchorStatus();

    @Override // kc0.k
    /* synthetic */ g getPanelServiceExternal();

    @Override // kc0.k
    /* synthetic */ h getPerfManager();

    @Override // kc0.k
    /* synthetic */ p11.d getPerfManager();

    @Override // kc0.k
    /* synthetic */ q getPkService();

    @Override // kc0.k
    /* synthetic */ p11.h getPkService();

    @Override // kc0.j
    /* synthetic */ Class<? extends Widget> getProfitInteractionWidgetClass();

    @Override // kc0.k
    /* synthetic */ s getRevLinkAudioDetectExternal();

    @Override // kc0.k
    /* synthetic */ long getRevLinkControlLoadTs();

    @Override // kc0.k
    /* synthetic */ kc0.e getRevLinkControlService();

    @Override // kc0.k
    /* synthetic */ o getRevenueLinkDataHolder();

    @Override // kc0.k
    /* synthetic */ p11.j getRevenueLinkDataHolder();

    @Override // kc0.k
    /* synthetic */ com.bytedance.android.live.revenuelink.rtc.f getRtcService();

    /* synthetic */ Map<String, String> getUidToStreamRegionKeyMap();

    @Override // kc0.k
    /* synthetic */ boolean isSpatialAudioEnable(int r100);

    @Override // kc0.k
    /* synthetic */ void leaveLivePlay(a r100);

    @Override // kc0.k
    /* synthetic */ void markAddPkBackground(a r100, boolean r101);

    @Override // kc0.j
    /* synthetic */ void notifyAudienceEngineEvent();

    @Override // kc0.k
    /* synthetic */ void notifyAudienceSelfJoin(boolean r100);

    @Override // kc0.k
    /* synthetic */ void notifyAudienceSelfLeave();

    @Override // kc0.k
    /* synthetic */ void notifyCleanModeChanged(int r100);

    @Override // kc0.k
    /* synthetic */ void notifyIsCleanModeChanged(boolean r100);

    @Override // kc0.k
    /* synthetic */ void notifyPauseStatus(int r100);

    @Override // kc0.k
    /* synthetic */ void notifyPkAnchorSilenceStatus(boolean r100);

    @Override // kc0.k
    /* synthetic */ void notifyPkAudienceUnload();

    @Override // kc0.k
    /* synthetic */ void notifyPkRenderWidth(int r100);

    @Override // kc0.k
    /* synthetic */ void notifyRenderSizeChanged(int r100, int r101);

    @Override // kc0.k
    /* synthetic */ void notifyRtcData(String r100);

    @Override // kc0.k
    /* synthetic */ void notifyStartAudioDiagnosis();

    @Override // kc0.k
    /* synthetic */ void notifyStopLive(int r100);

    @Override // kc0.k
    /* synthetic */ void notifyUserClose();

    @Override // kc0.k
    /* synthetic */ void onAudienceJoinGuestLink(boolean r100);

    @Override // kc0.k
    /* synthetic */ void onAudienceJoinSelfLink(boolean r100);

    @Override // kc0.k
    /* synthetic */ void onMultiAnchorStateChange(int r100);

    @Override // kc0.k
    /* synthetic */ void receiveChorusMessage(f0 r100);

    void registerPkStateChangeObserver(Observer<gt1.d> r100);

    @Override // kc0.k
    /* synthetic */ void setEnterRoomTime(long r100);

    void setFeatureParams(JSONObject r100);

    @Override // kc0.k
    /* synthetic */ void setSkipRoomStatsSync(boolean r100);

    void unRegisterPkStateChangeObserver(Observer<gt1.d> r100);

    @Override // kc0.k
    /* synthetic */ void updateAudienceMemberCount(long r100);

    @Override // kc0.k
    /* synthetic */ void updateEnterParams(a r100, long r101);

    @Override // kc0.k
    /* synthetic */ void updateEnterRoomViewMock(boolean r100);

    @Override // kc0.k
    /* synthetic */ void updateFeedParams(a r100, int r101, int r102, int r103, long r104);

    @Override // kc0.k
    /* synthetic */ void updateFirstFrameSei(String r100);

    @Override // kc0.k
    /* synthetic */ void updateInteractAnchorParam(String r100);

    @Override // kc0.k
    /* synthetic */ void updateInteractLayoutShow(boolean r100);

    @Override // kc0.k
    /* synthetic */ void updateInteractMarginTop(a r100, int r101);

    @Override // kc0.k
    /* synthetic */ void updateKeyboardStatus(boolean r100);

    @Override // kc0.k
    /* synthetic */ void updateLiveMode(LiveMode r100);

    @Override // kc0.k
    /* synthetic */ void updateLoad0Ts(long r100);

    @Override // kc0.k
    /* synthetic */ void updateLoad1Ts(long r100);

    @Override // kc0.k
    /* synthetic */ void updateMicRoomAnchorStatus(int r100);

    @Override // kc0.k
    /* synthetic */ void updatePkLeftMargin(a r100, int r101);

    @Override // kc0.k
    /* synthetic */ void updatePkMovedMarginTop(a r100, int r101);

    @Override // kc0.k
    /* synthetic */ void updatePortrait(boolean r100);

    @Override // kc0.k
    /* synthetic */ void updatePushStreamInfo(double r100, double r101, double r102);

    @Override // kc0.k
    /* synthetic */ void updateStableMode(boolean r100);

    @Override // kc0.k
    /* synthetic */ void updateVideoHeight(a r100, int r101, int r102);
}
