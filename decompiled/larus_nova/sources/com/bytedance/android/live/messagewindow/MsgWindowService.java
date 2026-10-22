package com.bytedance.android.live.messagewindow;

import android.content.Context;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.messagewindow.business.tetris.MsgWindowCardTetris;
import com.bytedance.android.live.messagewindow.business.tetris.desc.c;
import com.bytedance.android.live.messagewindow.business.tetris.desc.d;
import com.bytedance.android.live.messagewindow.framework.ability.CardAbilityImpl;
import com.bytedance.android.live.messagewindow.framework.context.CardContext;
import com.bytedance.android.live.messagewindow.framework.context.CommonCardContext;
import com.bytedance.android.live.messagewindow.framework.manager.f;
import com.bytedance.android.live.messagewindow.preview.widget.PreviewMsgWinBottomRightWidget;
import com.bytedance.android.live.messagewindow.preview.widget.PreviewMsgWinTopLeftWidget;
import com.bytedance.android.live.room.api.messagewindow.builder.card.CommonCardBuilder;
import com.bytedance.android.live.room.api.messagewindow.manager.IFloatingBannerManager;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.process.MsgWindowAdjustSource;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import j70.h;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m71.e;
import u61.a;
import u61.b;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bF\u0010GJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u000fH\u0016J\u0010\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u000fH\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0012\u0010)\u001a\u00020(2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010+\u001a\u00020*H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\b\u0010/\u001a\u00020.H\u0016J\u001c\u00101\u001a\u0004\u0018\u0001002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J$\u00104\u001a\u0002032\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u000100H\u0016J\u0018\u00109\u001a\u0002032\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u000207H\u0016J\u0010\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\"\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010?\u001a\u0004\u0018\u00010=2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016R&\u0010E\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010@*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\bC\u0010D\u001a\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/bytedance/android/live/messagewindow/MsgWindowService;", "Lcom/bytedance/android/live/room/api/messagewindow/service/IMsgWindowService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/live/messagewindow/framework/context/c;", "cardContext", "Lcom/bytedance/live/datacontext/DataContext;", "roomContext", "initCardContext", "Lv61/a;", "cardWindow", "Lr61/a;", "cardAbilityImpl", "Ly61/b;", "middlewareCardCtx", "Ljava/lang/Class;", "getBackendModelClass", "Lj70/h;", "Lh70/b;", "getMsgWindowCardTetrisDesc", "getTopLeftMsgWindowCardTetrisDesc", "getTopRightMsgWindowCardTetrisDesc", "getVideoOrLinkShellCardTetrisDesc", "getCommonCardServiceTetrisDesc", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getPreviewMsgWinBottomRightWidget", "getPreviewMsgWinTopLeftWidget", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "getCommonCardServiceWidget", "", "cardType", "", "getSingleCommonCardSettingConfig", "getCardContainerOptConfig", "Le71/a;", "msgWindowManager", "Lu61/a;", "cardBuilder", "Ld71/c;", "cardRecorder", "Lq71/a;", "cardStateDispatcher", "Lk71/a;", "businessCards", "Lcom/bytedance/android/live/room/api/messagewindow/monitor/i;", "cardMonitor", "Lu61/b;", "commonCardBuilder", "Lcom/bytedance/android/live/room/api/messagewindow/builder/card/c;", "getCommonCardWrapper", "commonCardWrapper", "", "storeCommonCardWrapper", "Lcom/bytedance/android/live/room/api/messagewindow/process/MsgWindowAdjustSource;", "source", "Lh71/a;", "adjustConfig", "msgWindowPositionAdjust", "getTempDraggableComponentTetrisDesc", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/live/room/api/messagewindow/manager/IFloatingBannerManager;", "initFloatingBannerManager", "getFloatingBannerManager", "Lcom/bytedance/live/datacontext/j;", "getFloatingBannerManagerMember", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)Lcom/bytedance/live/datacontext/j;", "getFloatingBannerManagerMember$annotations", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "floatingBannerManagerMember", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MsgWindowService implements IMsgWindowService {
    private static /* synthetic */ void getFloatingBannerManagerMember$annotations(DataCenter r100) {
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService, com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public a cardBuilder() {
        IPlatformCardService.Companion.getClass();
        IPlatformCardService r100 = IPlatformCardService.a.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.newCardBuilder();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService, com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public i cardMonitor() {
        IPlatformCardService.Companion.getClass();
        IPlatformCardService r100 = IPlatformCardService.a.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.cardMonitor();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public b commonCardBuilder() {
        return new CommonCardBuilder();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public h<? extends h70.b> getCommonCardServiceTetrisDesc() {
        return new bm0.a();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public Tetris<? extends h70.b> getCommonCardServiceWidget() {
        return new MsgWindowCardTetris();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public h<? extends h70.b> getMsgWindowCardTetrisDesc() {
        return new com.bytedance.android.live.messagewindow.business.tetris.desc.a();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public h<? extends h70.b> getTempDraggableComponentTetrisDesc() {
        return new nm0.a();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public h<? extends h70.b> getTopLeftMsgWindowCardTetrisDesc() {
        return new com.bytedance.android.live.messagewindow.business.tetris.desc.b();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public h<? extends h70.b> getTopRightMsgWindowCardTetrisDesc() {
        return new c();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public h<? extends h70.b> getVideoOrLinkShellCardTetrisDesc() {
        return new d();
    }

    public MsgWindowService() {
        k.l(IMsgWindowService.class, this);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService, com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public boolean getCardContainerOptConfig() {
        return e.a();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public k71.a businessCards() {
        return xl0.a.f564432a;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService, com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public d71.c cardRecorder() {
        return em0.b.f473054a;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public Class<?> getBackendModelClass() {
        return f71.c.a.class;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public Class<? extends LiveRecyclableWidget> getPreviewMsgWinBottomRightWidget() {
        return PreviewMsgWinBottomRightWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public Class<? extends LiveRecyclableWidget> getPreviewMsgWinTopLeftWidget() {
        return PreviewMsgWinTopLeftWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService, com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public e71.a msgWindowManager() {
        return f.f83127a;
    }

    private final com.bytedance.android.live.messagewindow.framework.context.c cardContext(DataCenter r100) {
        CardContext.Companion.getClass();
        return CardContext.a.a(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final j<IFloatingBannerManager> getFloatingBannerManagerMember(DataCenter r100) {
        r r101 = z51.a.e(r100);
        if (r101 == null) goto L5;
        j r102 = r101.C();
    L7:
        if ((r102 instanceof j) == true) goto L10;
        return null;
    L10:
        return r102;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public r61.a cardAbilityImpl(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cardWindow");
        return new CardAbilityImpl(r100);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService, com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public q71.a cardStateDispatcher(DataCenter r100) {
        com.bytedance.android.live.messagewindow.framework.context.c r101 = cardContext(r100);
        if (r101 == null) goto L7;
        q71.a r102 = r101.stateDispatcher();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return jm0.b.f499632f;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public IFloatingBannerManager getFloatingBannerManager(DataCenter r100) {
        if (r100 == null) goto L6;
        j<IFloatingBannerManager> r101 = getFloatingBannerManagerMember(r100);
        if (r101 == null) goto L6;
        return r101.getValue();
    L6:
        return null;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public boolean getSingleCommonCardSettingConfig(int r100) {
        return e.c(r100);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public y61.b middlewareCardCtx(DataCenter r100) {
        CardContext.Companion.getClass();
        return CardContext.a.a(r100);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public /* bridge */ /* synthetic */ q71.b cardStateDispatcher(DataCenter r100) {
        return cardStateDispatcher(r100);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public com.bytedance.android.live.room.api.messagewindow.builder.card.c getCommonCardWrapper(DataCenter r100, int r101) {
        CommonCardContext.Companion.getClass();
        y61.a r102 = CommonCardContext.b.b(r100);
        if (r102 == null) goto L7;
        Map<Integer, com.bytedance.android.live.room.api.messagewindow.builder.card.c> r103 = r102.getCommonCardWrapperMap();
        if (r103 == null) goto L7;
        return r103.get(Integer.valueOf(r101));
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService, com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService
    public DataContext initCardContext(DataCenter r100, DataContext r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        CardContext r102 = new CardContext(r101, r100);
        r102.initialize();
        return r102;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public void msgWindowPositionAdjust(MsgWindowAdjustSource r110, h71.a r111) {
        Intrinsics.checkNotNullParameter(r110, "source");
        Intrinsics.checkNotNullParameter(r111, "adjustConfig");
        xs2.b r100 = xs2.b.a();
        MsgWindowAdjustSource r101 = null;
        if ((63 & 16) == 0) goto L5;
        h71.a r102 = new h71.a();
    L7:
        if ((63 & 32) == 0) goto L9;
        r101 = MsgWindowAdjustSource.UNKNOWN;
    L9:
        Intrinsics.checkNotNullParameter(r102, "adjustConfig");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r110, "source");
        Intrinsics.checkNotNullParameter(r111, "adjustConfig");
        Float r103 = r111.f483971d;
        if (r103 == null) goto L12;
        r103.floatValue();
        boolean r104 = true;
    L13:
        Float r105 = r111.f483969b;
        if (r105 == null) goto L16;
        r105.floatValue();
        boolean r106 = true;
    L17:
        Float r107 = r111.f483970c;
        if (r107 == null) goto L20;
        r107.floatValue();
        boolean r108 = true;
    L21:
        Float r109 = r111.f483972e;
        if (r109 == null) goto L24;
        r109.floatValue();
        boolean r112 = true;
    L25:
        Unit r113 = Unit.INSTANCE;
        r100.post(new z61.b(r106, r104, r108, r112, r111, r110));
        return;
    L24:
        r112 = false;
        goto L25
    L20:
        r108 = false;
        goto L21
    L16:
        r106 = false;
        goto L17
    L12:
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public IFloatingBannerManager initFloatingBannerManager(final Context r100, DataContext r101, final DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        j<IFloatingBannerManager> r103 = getFloatingBannerManagerMember(r102);
        if (r103 == null) goto L5;
        r103.e(new AnonymousClass1(r100, r102));
    L5:
        if (r103 != null) goto L9;
        return null;
    L9:
        return r103.getValue();
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService
    public void storeCommonCardWrapper(DataCenter r100, int r101, com.bytedance.android.live.room.api.messagewindow.builder.card.c r102) {
        CommonCardContext.Companion.getClass();
        y61.a r103 = CommonCardContext.b.b(r100);
        if (r103 == null) goto L8;
        Map<Integer, com.bytedance.android.live.room.api.messagewindow.builder.card.c> r104 = r103.getCommonCardWrapperMap();
        if (r104 == null) goto L9;
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r105 = r104.put(Integer.valueOf(r101), r102);
        return;
    L9:
        return;
    }
}
