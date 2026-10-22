package com.bytedance.android.livesdk.gamecp.impl;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.x8;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.depend.model.live.IOptions;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.ILiveFloatViewService;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements ILiveFloatViewService {
    public k() {
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final String getCurResolution() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void markFullPanel(boolean r100) {
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void pullAudioStream(boolean r100) {
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void setResolution(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resolution");
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void stopLiveStream() {
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final boolean isFloatViewShowing() {
        return ((ILiveVideoFloatWindowService) jc1.k.n(ILiveVideoFloatWindowService.class)).isFloatWindowShowing();
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void stopFloatView() {
        ((ILiveVideoFloatWindowService) jc1.k.n(ILiveVideoFloatWindowService.class)).stopShowFloat();
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void pauseLiveStream() {
        xs2.b.a().post(new h1(32));
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void addFloatViewStatusObserver(IVideoFloatManager.VideoFloatManagerListener r100) {
        ((ILiveVideoFloatWindowService) jc1.k.n(ILiveVideoFloatWindowService.class)).addVideoFloatManagerListener(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void removeFloatViewStatusObserver(IVideoFloatManager.VideoFloatManagerListener r100) {
        ((ILiveVideoFloatWindowService) jc1.k.n(ILiveVideoFloatWindowService.class)).removeVideoFloatManagerListener(r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void toggleLiveAudio(boolean r100) {
        ILiveVideoFloatWindowService r101 = (ILiveVideoFloatWindowService) jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r101 == null) goto L6;
        r101.toggleLiveAudio(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void showFloatViewNow(Context r100, Long r101, boolean r102, boolean r103, HashMap<String, String> r104, HashMap<String, String> r105) {
        Activity r106 = x8.c(r100);
        if (r106 != null) goto L5;
        r106 = com.bytedance.android.live.core.utils.a.d();
    L5:
        if (r106 == null) goto L10;
        ILiveVideoFloatWindowService r107 = (ILiveVideoFloatWindowService) jc1.k.n(ILiveVideoFloatWindowService.class);
        InnerContextEntity.InnerFloatExtra r108 = new InnerContextEntity.InnerFloatExtra();
        r108.setRequestPage("gamecp_game_detail");
        r108.setMobParams(r104);
        r108.setMute(r103);
        r108.setFinishOnClick(r102);
        r108.setEnterRoomId(r101);
        r108.setBusinessLine(FloatWindowBusinessLine.Game);
        r108.setExtParams(r105);
        Unit r109 = Unit.INSTANCE;
        r107.startShowFloat(r106, r108);
        ILiveVideoFloatWindowService r110 = (ILiveVideoFloatWindowService) jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r110 == null) goto L11;
        r110.stopShowFloatInNextLifecycle();
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void showFloatViewNow(DialogFragment r100, FrameLayout r101, Long r102, boolean r103, boolean r104, HashMap<String, String> r105, HashMap<String, String> r110) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        ILiveVideoFloatWindowService r106 = (ILiveVideoFloatWindowService) jc1.k.n(ILiveVideoFloatWindowService.class);
        InnerContextEntity.InnerFloatExtra r107 = new InnerContextEntity.InnerFloatExtra();
        r107.setRequestPage("gamecp_game_detail");
        r107.setMobParams(r105);
        r107.setMute(r104);
        r107.setFinishOnClick(r103);
        r107.setEnterRoomId(r102);
        r107.setBusinessLine(FloatWindowBusinessLine.Game);
        r107.setExtParams(r110);
        Unit r108 = Unit.INSTANCE;
        r106.startShowFloat(r100, r101, r107);
        ILiveVideoFloatWindowService r109 = (ILiveVideoFloatWindowService) jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r109 == null) goto L6;
        r109.stopShowFloatInNextLifecycle();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveFloatViewService
    public final void showFloatView(Context r110, String r111, boolean r112, long r113, boolean r114, boolean r115, boolean r210, boolean r211, boolean r212, RelativeLayout.LayoutParams r213) {
        Intrinsics.checkNotNullParameter(r110, "ctx");
        Intrinsics.checkNotNullParameter(r111, "requestPage");
        ILiveVideoFloatWindowService r100 = (ILiveVideoFloatWindowService) jc1.k.n(ILiveVideoFloatWindowService.class);
        Activity r101 = (Activity) r110;
        InnerContextEntity.InnerFloatExtra r102 = new InnerContextEntity.InnerFloatExtra();
        r102.setRequestPage("live_cloud_game");
        r102.setFinishOnClick(false);
        r102.setEnterRoomId(Long.valueOf(r113));
        r102.setSkipCheckResumed(r212);
        if (r114 == false) goto L62;
        Object r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L54
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, null, r113, 1);     // Catch: Throwable -> L54
        if (r105 == null) goto L62;
        com.bytedance.live.datacontext.m<Room> r106 = r105.getRoom();     // Catch: Throwable -> L54
        if (r106 == null) goto L62;
        Room r107 = r106.getValue();     // Catch: Throwable -> L54
        if (r107 == null) goto L62;
        StreamUrl r108 = r107.getStreamUrl();     // Catch: Throwable -> L54
        if (r108 == null) goto L24;
        LiveCoreSDKData r109 = r108.getLiveCoreSDKData();     // Catch: Throwable -> L54
        if (r109 == null) goto L24;
        LiveCoreSDKData.PullData r116 = r109.pullData;     // Catch: Throwable -> L54
        if (r116 == null) goto L24;
        IOptions r117 = r116.getOptions();     // Catch: Throwable -> L54
        if (r117 == null) goto L24;
        if (r117.getVPassDefault() != true) goto L24;
        String r118 = ResolutionManager.getMultiStreamDefaultQualitySdkKey$default(ResolutionManager.INSTANCE, r107, false, false, 6, null);     // Catch: Throwable -> L54
    L52:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L54
    L57:
        if (Result.m9455isFailureimpl(r119) == true) goto L60;
        r103 = r119;
    L60:
        String r120 = (String) r103;
        if (r120 == null) goto L62;
    L63:
        r102.setResolution(r120);
        r102.setForceNotSharedLiveClient(true);
        r102.setInBackGroud(!LiveSettingKeys.LIVE_CLOUD_GAME_INDIVIDUAL_CONTROL_AUDIO.getValue().booleanValue());
        r102.setInBackGroud(true);
        r102.setMute(r211);
        r102.setParams(r213);
        r102.setEnableChangePosition(true);
        r102.setBusinessLine(FloatWindowBusinessLine.Game);
        Unit r121 = Unit.INSTANCE;
        r100.startShowFloat(r101, r102);
        return;
    L24:
        StreamUrl r122 = r107.getStreamUrl();     // Catch: Throwable -> L54
        if (r122 == null) goto L42;
        List<IQuality> r123 = r122.getQualityList();     // Catch: Throwable -> L54
        if (r123 == null) goto L42;
        ArrayList r124 = new ArrayList();     // Catch: Throwable -> L54
        Iterator<T> r125 = r123.iterator();     // Catch: Throwable -> L54
    L30:
        if (r125.hasNext() == false) goto L39;
        Object r126 = r125.next();     // Catch: Throwable -> L54
        IQuality r127 = (IQuality) r126;     // Catch: Throwable -> L54
        if (r127.isEnable() == true) goto L34;
    L36:
        boolean r128 = false;
    L37:
        if (r128 == false) goto L30;
        r124.add(r126);     // Catch: Throwable -> L54
        goto L30
    L34:
        if (r127.getDisable() > 0) goto L36;
        r128 = true;
        goto L37
    L39:
        List r129 = CollectionsKt.sortedWith(r124, new j());     // Catch: Throwable -> L54
        if (r129 == null) goto L42;
        IQuality r130 = (IQuality) CollectionsKt.getOrNull(r129, 0);     // Catch: Throwable -> L54
    L43:
        StringBuilder r131 = new StringBuilder();     // Catch: Throwable -> L54
        r131.append("floatView getFloatViewResolution ");     // Catch: Throwable -> L54
        if (r130 == null) goto L46;
        String r132 = r130.getName();     // Catch: Throwable -> L54
    L47:
        r131.append(r132);     // Catch: Throwable -> L54
        ALogger.i("CloudGame", r131.toString());     // Catch: Throwable -> L54
        if (r130 == null) goto L51;
        r118 = r130.getSdkKey();     // Catch: Throwable -> L54
        if (r118 != null) goto L52;
    L51:
        r118 = ResolutionManager.getMultiStreamDefaultQualitySdkKey$default(ResolutionManager.INSTANCE, r107, false, false, 6, null);     // Catch: Throwable -> L54
        goto L52
    L46:
        r132 = null;
    L42:
        r130 = null;
    L54:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L62:
        r120 = "";
        goto L63
    }
}
