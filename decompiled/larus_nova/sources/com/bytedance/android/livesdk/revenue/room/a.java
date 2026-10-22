package com.bytedance.android.livesdk.revenue.room;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import dq2.g;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import vlc.l;

/* JADX INFO: loaded from: classes11.dex */
public interface a {
    dq2.a getActivityRoomSkinInfo();

    Observable<dq2.e> getAudioTalkSwitchSceneEvent();

    m<Long> getCameraId();

    m<Integer> getCleanMode();

    boolean getCommonIsAnchor();

    boolean getCommonIsMediaRoom();

    com.bytedance.android.livesdk.revenue.pushstream.a getCommonLiveStream();

    Pair<DataContext, Disposable> getCommonProfitInteractionDataContext();

    IRoomBase getCommonRoom();

    IBaseUser getCommonUser();

    long getDesireId();

    long getEnterRoomTime();

    String getFeedRespFrom();

    long getForbiddenBeforeEnd();

    boolean getHasCommerceEntrance();

    n<IRoom> getInteractionDataPrepared();

    long getLiveDurationStartTime();

    ILiveMode getLiveMode();

    j<com.bytedance.android.livesdk.revenue.pushstream.a> getLiveStream();

    String getLogPb();

    Observable<RevPadOrientation> getPadOrientation();

    RevPadOrientation getPadOrientationData();

    String getPixEnterFrom();

    Pair<Integer, Integer> getPlayerSize();

    m<IRoom> getRoom();

    n<BackendGeneratedData> getRoomBackendData();

    dh1.c getRtcRoomInfo();

    Pair<Long, Long> getSeiTimePair();

    List<IToolbarComponentData> getToolbarDataList();

    m<IBaseUser> getUser();

    long getUserFrom();

    g getVideoTalkRoomSubScene();

    float getVsVerticalProgressBarHeight();

    i<Boolean> isAnchor();

    m<Boolean> isAnchorEffectInit();

    m<Boolean> isCasting();

    m<? extends Boolean> isCleanMode();

    boolean isGameCp();

    boolean isHasCommerceGoods();

    boolean isInVideoPlay();

    boolean isLiveTypeSandbox();

    boolean isMediaRoom();

    m<Boolean> isMultiPkState();

    m<? extends Boolean> isPortraitInteraction();

    boolean isVSFirstShow();

    boolean isVSLive();

    boolean isVSRoom();

    boolean isVSVerticalStream();

    Disposable registerRtcRoomMessageListener(String r100, l r101, Function0<Unit> r102);

    void resetVideoPlayState();

    void setCommonProfitInteractionDataContext(Pair<? extends DataContext, ? extends Disposable> r100);

    void setRevnueLinkHasLoad(boolean r100);
}
