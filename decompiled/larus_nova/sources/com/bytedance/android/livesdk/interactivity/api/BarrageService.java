package com.bytedance.android.livesdk.interactivity.api;

import am2.x;
import android.content.Context;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.VSLiveLandscapeBarrageSettingDialog;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.barrage.widget.CarnivalDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.barrage.widget.CarnivalManagerServiceWidget;
import com.bytedance.android.livesdk.interactivity.barrage.widget.VSLandscapeCarnivalDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalRedPacketEggResultModel;
import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalTrayContentResultModel;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.SimpleZDanmakuSettingDialogFragment;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeZDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuWidget;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPreviewBarrageService;
import com.bytedance.android.livesdkapi.service.OpenParams;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0005H\u0016J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J>\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0014j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eH\u0016J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"H\u0016J\u0018\u0010(\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020)H\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/BarrageService;", "Lcom/bytedance/android/livesdk/interactivity/api/IBarrageService;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "providePortraitBarrageWidget", "provideLandscapeBarrageWidget", "Ljava/lang/Class;", "provideCarnivalManagerWidget", "provideChatCarnivalWidget", "provideLandscapeCarnivalWidget", "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget;", "providePortraitSimpleBarrageWidget", "providePortraitSimpleBarrageWidgetClass", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "requestPage", "", "showVSLandscapeBarrageSettingDialog", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraParams", "Ln22/c;", "showLandscapeBarrageSettingDialog", "Ln22/d;", "msg", "addBarrageToScreen", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/b;", "createBarrageContext", "Lq82/c;", "Lq82/f;", "Lcom/bytedance/android/livesdk/interactivity/jsb/ShowCarnivalTrayContentResultModel;", "createShowCarnivalTrayContentMethod", "Lq82/b;", "Lq82/e;", "Lcom/bytedance/android/livesdk/interactivity/jsb/ShowCarnivalRedPacketEggResultModel;", "createShowCarnivalRedPacketEggMethod", "Lcom/bytedance/android/livesdkapi/service/OpenParams;", "params", "openPortraitSimpleBarrageSettingDialog", "Lcom/bytedance/android/livesdkapi/service/IPreviewBarrageService;", "provideILivePreviewBarrageService", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BarrageService implements IBarrageService {
    public BarrageService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.b createBarrageContext() {
        return new BarrageWidgetContext();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public q82.b<q82.e, ShowCarnivalRedPacketEggResultModel> createShowCarnivalRedPacketEggMethod() {
        return new y52.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public q82.c<q82.f, ShowCarnivalTrayContentResultModel> createShowCarnivalTrayContentMethod() {
        return new y52.b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Widget provideChatCarnivalWidget() {
        return new CarnivalDanmakuWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Widget provideLandscapeBarrageWidget() {
        return new LandscapeZDanmakuWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Widget provideLandscapeCarnivalWidget() {
        return new VSLandscapeCarnivalDanmakuWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Widget providePortraitBarrageWidget() {
        return new PortraitZDanmakuWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public AbsMergeWidget providePortraitSimpleBarrageWidget() {
        return new PortraitSimpleZDanmakuWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Class<? extends Widget> provideCarnivalManagerWidget() {
        return CarnivalManagerServiceWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public IPreviewBarrageService provideILivePreviewBarrageService() {
        return com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager.a.f141799a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public Class<? extends AbsMergeWidget> providePortraitSimpleBarrageWidgetClass() {
        return PortraitSimpleZDanmakuWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public void addBarrageToScreen(n22.d r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        q22.d r101 = new q22.d(r100);
        xs2.b.a().post(r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public void openPortraitSimpleBarrageSettingDialog(Context r100, OpenParams r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = SimpleZDanmakuSettingDialogFragment.f141755i;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        FragmentActivity r103 = ContextUtil.contextToFragmentActivity(r100);
        if (r103 == null) goto L15;
        FragmentManager r104 = r103.getSupportFragmentManager();
        if (r104 == null) goto L16;
        SimpleZDanmakuSettingDialogFragment r105 = new SimpleZDanmakuSettingDialogFragment();
        r105.f141760h = r101;
        LandscapeRestrictionOperation r106 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r105, "SimpleZDanmakuSettingDialogFragment", r106);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r104, r105, r106) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r105.show(r104, "SimpleZDanmakuSettingDialogFragment");
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public n22.c showLandscapeBarrageSettingDialog(Context r100, DataCenter r101, HashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "extraParams");
        int r103 = z52.b.K;
        l42.a.f507317d.getValue().setNeedRollback(l42.a.f507320g.getValue().booleanValue());
        HashMap r104 = new HashMap();
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L5;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).appendCastSDKLogCommonParams(r104);
    L5:
        if (r102 == null) goto L7;
        r104.put("position", r102.get("position"));
        r104.put("live_type", r102.get("live_type"));
    L7:
        j0.l().sendLog("livesdk_landscape_barrage_settings_click", r104, new Object[]{new x(), IRoom.class});
        IRoomContextService r105 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r105 != null) goto L10;
    L12:
        z52.b r106 = new z52.b(r100);
        Window r107 = r106.getWindow();
        if (r107 == null) goto L16;
        r107.setDimAmount(0.0f);
    L16:
        if (r106.isShowing() == true) goto L23;
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(r106);
        goto L23
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L21:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
    L23:
        return r106;
    L10:
        if (r105.getRoomDataContext(r101, 0).isVSRoom() != Boolean.TRUE) goto L12;
        int r108 = VSLiveLandscapeBarrageSettingDialog.f133948m;
        VSLiveLandscapeBarrageSettingDialog.a.b(r100, r101, "");
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBarrageService
    public void showVSLandscapeBarrageSettingDialog(Context r100, DataCenter r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        int r103 = VSLiveLandscapeBarrageSettingDialog.f133948m;
        VSLiveLandscapeBarrageSettingDialog.a.b(r100, r101, r102);
    }
}
