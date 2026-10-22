package com.bytedance.android.livesdkapi.service;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.chatroom.multitask.b;
import com.bytedance.android.livesdk.chatroom.multitask.c;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.enterparam.ILiveCommonMonitorService;
import com.bytedance.android.livesdkapi.feed.IKtvComponentFeedViewManager;
import com.bytedance.android.livesdkapi.feed.ILivePreviewMultiLinkCommonWidget;
import com.bytedance.android.livesdkapi.feed.anchormode.ILivePreviewAnchorModeLinkCommonWidget;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerServiceV2;
import com.bytedance.android.livesdkapi.live.NotificationSettingCallBack;
import com.bytedance.android.livesdkapi.live.UGDialoOnClickCallBack;
import com.bytedance.android.livesdkapi.livetrace.ILiveCloudGameTraceMonitor;
import com.bytedance.android.livesdkapi.livetrace.ILiveGameTraceMonitor;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.preview.IPreviewSeiService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerService;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;

/* JADX INFO: loaded from: classes12.dex */
public interface IMiddlewareLiveService extends IService {
    void addRecordStatsChangeListener(ILiveRecordService.RecordStatusChangeListener r100, DataCenter r101);

    ICalendarManager getCalendarManager(Context r100);

    ILiveCloudGameTraceMonitor getCloudGameTraceMonitor();

    ILiveCommonMonitorService getCommonMonitorService();

    ICurrentInteractionUiAction getCurrentInteractionUiAction();

    IGameStickerServiceV2 getGameStickerServiceV2();

    ILiveGameTraceMonitor getGameTraceMonitor();

    IInteractPlayView getInteractPlayView(Context r100);

    IKtvComponentFeedViewManager getKtvComponentFeedViewManage();

    b getLiveInnerDependentTaskHelper();

    c getLiveInnerIndependentManage();

    ILiveOntologyInfoManager getLiveOntologyRecord();

    ILivePreviewAnchorModeLinkCommonWidget getLivePreviewAnchorModeDynamicWidget(Object r100);

    ILivePreviewMultiLinkCommonWidget getLivePreviewMultiLinkCommonWidget();

    <T> T getLiveSettingValue(String r100, T r101);

    IMultiLinkWRDSPreloadService getMultiLinkWRDSPreloadService();

    long getNotificationOppositeValue(long r100);

    IPreviewSeiService getPreviewSeiService();

    Pair<Integer, Integer> getSeiVersionAndUILayoutForMultiLink(int r100, int r101);

    boolean handleSchema(Context r100, Uri r101);

    boolean isMergeVSMediaRoom(IRoom r100);

    boolean isRecording(DataCenter r100);

    boolean isSupportedCommonInteractFeedView(int r100, int r101);

    ILivePlayerService livePlayerService();

    void notificationSettingModify(Context r100, String r101, long r102, String r103, NotificationSettingCallBack r104, boolean r105);

    ParseSeiData parseSeiDataBySei(String r100);

    void postDialogSuccess(boolean r100);

    void registerUgDialog(UGDialoOnClickCallBack r100);

    void removeRecordStatsChangeListener(ILiveRecordService.RecordStatusChangeListener r100, DataCenter r101);

    void setOnNeedMuteAudioFullPage(boolean r100);

    boolean shouldUseNewLivePlayerLayout();

    boolean shouldUsePkFeedViewFix();

    void showLivePrivilegeManagerDialog(Context r100);

    void showLiveProfileManagerDialog(Context r100);

    void unRegisterUgDialog(UGDialoOnClickCallBack r100);
}
