package com.bytedance.android.live.room.api.messagewindow.service;

import android.content.Context;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.api.messagewindow.manager.IFloatingBannerManager;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.process.MsgWindowAdjustSource;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import d71.c;
import j70.h;
import k71.a;
import kotlin.Metadata;
import u61.b;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.live.messagewindow.MsgWindowService")
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H&J\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H&J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H&J\u0010\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H&J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H&J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH&J\u0010\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH&J\u0010\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0012H&J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\u0016H&J\b\u0010\u001a\u001a\u00020\u0019H&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\b\u0010\u001e\u001a\u00020\u001dH&J\u0012\u0010 \u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\"\u001a\u00020!H&J\n\u0010$\u001a\u0004\u0018\u00010#H&J\b\u0010&\u001a\u00020%H&J\u001c\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J$\u0010+\u001a\u00020*2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010'H&J\u0018\u00100\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H&J\u0010\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H&J\"\u00105\u001a\u0004\u0018\u0001042\u0006\u00103\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u00106\u001a\u0004\u0018\u0001042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¨\u00067"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/service/IMsgWindowService;", "Lcom/bytedance/android/live/room/api/messagewindow/service/IMiddlewareMsgWindowService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/live/datacontext/DataContext;", "roomContext", "initCardContext", "Lj70/h;", "Lh70/b;", "getMsgWindowCardTetrisDesc", "getTopLeftMsgWindowCardTetrisDesc", "getTopRightMsgWindowCardTetrisDesc", "getVideoOrLinkShellCardTetrisDesc", "getCommonCardServiceTetrisDesc", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getPreviewMsgWinBottomRightWidget", "getPreviewMsgWinTopLeftWidget", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "getCommonCardServiceWidget", "", "cardType", "", "getSingleCommonCardSettingConfig", "getCardContainerOptConfig", "Le71/a;", "msgWindowManager", "Lu61/a;", "cardBuilder", "Ld71/c;", "cardRecorder", "Lq71/a;", "cardStateDispatcher", "Lk71/a;", "businessCards", "Lcom/bytedance/android/live/room/api/messagewindow/monitor/i;", "cardMonitor", "Lu61/b;", "commonCardBuilder", "Lcom/bytedance/android/live/room/api/messagewindow/builder/card/c;", "getCommonCardWrapper", "commonCardWrapper", "", "storeCommonCardWrapper", "Lcom/bytedance/android/live/room/api/messagewindow/process/MsgWindowAdjustSource;", "source", "Lh71/a;", "adjustConfig", "msgWindowPositionAdjust", "getTempDraggableComponentTetrisDesc", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/live/room/api/messagewindow/manager/IFloatingBannerManager;", "initFloatingBannerManager", "getFloatingBannerManager", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMsgWindowService extends IMiddlewareMsgWindowService {
    a businessCards();

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    u61.a cardBuilder();

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    i cardMonitor();

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    c cardRecorder();

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    q71.a cardStateDispatcher(DataCenter r100);

    b commonCardBuilder();

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    boolean getCardContainerOptConfig();

    h<? extends h70.b> getCommonCardServiceTetrisDesc();

    Tetris<? extends h70.b> getCommonCardServiceWidget();

    com.bytedance.android.live.room.api.messagewindow.builder.card.c getCommonCardWrapper(DataCenter r100, int r101);

    IFloatingBannerManager getFloatingBannerManager(DataCenter r100);

    h<? extends h70.b> getMsgWindowCardTetrisDesc();

    Class<? extends LiveRecyclableWidget> getPreviewMsgWinBottomRightWidget();

    Class<? extends LiveRecyclableWidget> getPreviewMsgWinTopLeftWidget();

    boolean getSingleCommonCardSettingConfig(int r100);

    h<? extends h70.b> getTempDraggableComponentTetrisDesc();

    h<? extends h70.b> getTopLeftMsgWindowCardTetrisDesc();

    h<? extends h70.b> getTopRightMsgWindowCardTetrisDesc();

    h<? extends h70.b> getVideoOrLinkShellCardTetrisDesc();

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    DataContext initCardContext(DataCenter r100, DataContext r101);

    IFloatingBannerManager initFloatingBannerManager(Context r100, DataContext r101, DataCenter r102);

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    e71.a msgWindowManager();

    void msgWindowPositionAdjust(MsgWindowAdjustSource r100, h71.a r101);

    void storeCommonCardWrapper(DataCenter r100, int r101, com.bytedance.android.live.room.api.messagewindow.builder.card.c r102);
}
