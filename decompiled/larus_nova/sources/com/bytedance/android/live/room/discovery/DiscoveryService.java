package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.text.Spannable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.api.IDiscoveryService;
import com.bytedance.android.live.room.discovery.drawer.NewLiveDrawerEntranceWidget;
import com.bytedance.android.live.room.discovery.drawer.template.LiveDrawerEntranceCommonWidget;
import com.bytedance.android.live.room.discovery.inspector.OfficialInspectorManager;
import com.bytedance.android.live.room.navi.userinfo_p.widget.ecom.ECLiveLynxRankEntrance;
import com.bytedance.android.live.room.navi.userinfo_p.widget.ecom.ECLiveUserInfoWidget;
import com.bytedance.android.livesdk.config.ua;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.message.model.rk;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000fH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000fH\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016JG\u0010#\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2)\u0010\"\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dH\u0016J\"\u0010(\u001a\u00020\u00172\u0006\u0010%\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010)\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u0005H\u0016R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/bytedance/android/live/room/discovery/DiscoveryService;", "Lcom/bytedance/android/live/room/api/IDiscoveryService;", "Lj70/j;", "Lh70/b;", "getDiscoveryDescriptor", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getECDiscoveryWidget", "getECAnchorAvatarWidget", "getDrawerEntranceWidget", "getDrawerEntranceCommonWidget", "getHotSpotWidget", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getNetStatusWidget", "getLiveSceneWidget", "Lj70/n;", "getDrawerEntranceDescriptor", "getLandscapeDrawerEntranceDescriptor", "getNetStatusDescriptor", "", "status", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "onNetworkStatus", "Lcom/bytedance/android/livesdk/message/model/rk;", "roomTopMessage", "Ld90/a;", "liveLayerContext", "Lkotlin/Function1;", "Lj70/h;", "Lkotlin/ParameterName;", "name", "descriptor", "loadElementBlock", "handleRoomTopMsg", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdk/message/model/kj;", "remindMessage", "handleOfficialInspectorRemindMsg", "getAnchorPerfWidgetClass", "Lcom/bytedance/android/live/room/discovery/p0;", "signalStatusEvent", "Lcom/bytedance/android/live/room/discovery/p0;", "getSignalStatusEvent", "()Lcom/bytedance/android/live/room/discovery/p0;", "Lcom/bytedance/android/live/room/discovery/inspector/OfficialInspectorManager;", "officialInspectorManager", "Lcom/bytedance/android/live/room/discovery/inspector/OfficialInspectorManager;", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DiscoveryService implements IDiscoveryService {
    private OfficialInspectorManager officialInspectorManager;
    private final p0 signalStatusEvent;

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public j70.j<? extends h70.b> getDiscoveryDescriptor() {
        return new o0();
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public j70.n<? extends h70.b> getDrawerEntranceDescriptor() {
        return new com.bytedance.android.live.room.discovery.drawer.a();
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public j70.n<? extends h70.b> getLandscapeDrawerEntranceDescriptor() {
        return new com.bytedance.android.live.room.discovery.drawer.i();
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public j70.n<? extends h70.b> getNetStatusDescriptor() {
        if (ua.f121355a.getValue().booleanValue() == false) goto L6;
        return new b();
    L6:
        return new l0();
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Widget getNetStatusWidget() {
        return new NetSpeedMonitorWidget();
    }

    public DiscoveryService() {
        this.signalStatusEvent = new p0();
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends Widget> getAnchorPerfWidgetClass() {
        return AnchorPerfMonitorWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getDrawerEntranceCommonWidget() {
        return LiveDrawerEntranceCommonWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getDrawerEntranceWidget() {
        return NewLiveDrawerEntranceWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getECAnchorAvatarWidget() {
        return ECLiveUserInfoWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getECDiscoveryWidget() {
        return ECLiveLynxRankEntrance.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getHotSpotWidget() {
        return LiveHotSpotWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public Class<? extends LiveRecyclableWidget> getLiveSceneWidget() {
        return LiveSceneWidget.class;
    }

    public final p0 getSignalStatusEvent() {
        return this.signalStatusEvent;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public void onNetworkStatus(int r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        LayerEventDispatcher r102 = o70.c.a(Integer.valueOf(r101.hashCode()));
        p0 r103 = this.signalStatusEvent;
        r103.f99577a = r100;
        if (r102 == null) goto L6;
        r102.b(r103);
        return;
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public void handleOfficialInspectorRemindMsg(Context r100, d90.a r101, kj r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "liveLayerContext");
        OfficialInspectorManager.f99528b.getClass();
        OfficialInspectorManager.Companion.a(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.room.api.IDiscoveryService
    public void handleRoomTopMsg(rk r110, d90.a r111, Function1<? super j70.h<d90.a>, Unit> r112) {
        com.bytedance.android.live.room.discovery.inspector.l r100 = null;
        if (this.officialInspectorManager != null) goto L46;
        OfficialInspectorManager.Companion r101 = OfficialInspectorManager.f99528b;
        if (r111 == null) goto L7;
        DataCenter r102 = r111.f467480h;
    L8:
        r101.getClass();
        if (r102 == null) goto L29;
        if (r111 == null) goto L29;
        if (r112 == null) goto L29;
        if (jr1.b.a(r111) == true) goto L16;
    L18:
        boolean r103 = false;
    L19:
        if (r103 == true) goto L26;
        StringBuilder r113 = new StringBuilder("get OfficialInspectorManager failed: isAnchor is ");
        r113.append(jr1.b.a(r111));
        r113.append(". LiveMode is ");
        LiveMode r114 = d90.c.o(r111);
        if (r114 == null) goto L23;
        String r115 = r114.toString();
    L24:
        r113.append(r115);
        ALogger.e("OfficialInspectorManager", r113.toString());
    L42:
        OfficialInspectorManager r116 = null;
    L43:
        this.officialInspectorManager = r116;
        if (r116 != null) goto L46;
        return;
    L23:
        r115 = null;
        goto L24
    L26:
        if (OfficialInspectorManager.Companion.b() == true) goto L28;
        ALogger.e("OfficialInspectorManager", "get OfficialInspectorManager failed: setting enable is " + OfficialInspectorManager.Companion.b());
        goto L42
    L28:
        r116 = new OfficialInspectorManager();
        r112.invoke(new com.bytedance.android.live.room.discovery.inspector.m());
        r116.f99529a = r102;
        goto L43
    L16:
        if (d90.c.o(r111) != LiveMode.VIDEO) goto L18;
        r103 = true;
    L29:
        StringBuilder r104 = new StringBuilder("dataCenter or liveLayerContext or portrait2ndDelegate or layerManager is null.dataCenter is ");
        if (r102 == null) goto L32;
        String r105 = r102.toString();
    L33:
        r104.append(r105);
        r104.append("liveLayerContext is ");
        if (r111 == null) goto L36;
        String r117 = r111.toString();
    L37:
        r104.append(r117);
        r104.append(".layerManager is ");
        if (r112 == null) goto L40;
        String r118 = r112.toString();
    L41:
        r104.append(r118);
        ALogger.e("OfficialInspectorManager", r104.toString());
        goto L42
    L40:
        r118 = null;
        goto L41
    L36:
        r117 = null;
        goto L37
    L32:
        r105 = null;
        goto L33
    L7:
        r102 = null;
    L46:
        OfficialInspectorManager r119 = this.officialInspectorManager;
        if (r119 == null) goto L70;
        OfficialInspectorManager.f99528b.getClass();
        if (OfficialInspectorManager.Companion.b() == true) goto L51;
        ALogger.e("OfficialInspectorManager", "setting enable is false when tryShowWithMessage");
        return;
    L51:
        if (r110 != null) goto L53;
        ALogger.e("OfficialInspectorManager", "try show with null message");
        return;
    L53:
        Spannable r120 = sb2.a.h(r110.G(), null, false);
        if (r120 == null) goto L64;
        boolean r106 = !Intrinsics.areEqual(r120, sb2.a.f541209a);
        Text r121 = r110.P();
        Text r107 = r110.P();
        if (r107 == null) goto L59;
        String r108 = r107.getDefaultPattern();
    L60:
        Spannable r122 = sb2.a.h(r121, r108, false);
        if (r122 == null) goto L64;
        r100 = new com.bytedance.android.live.room.discovery.inspector.l(r106, r110.E(), r110.H(), r110.getDisplayDuration(), r120, r122);
        goto L64
    L59:
        r108 = null;
    L64:
        if (r100 != null) goto L66;
        ALogger.e("OfficialInspectorManager", "config is null, because of TextPieceHelper's error");
        return;
    L66:
        DataCenter r123 = r119.f99529a;
        if (r123 == null) goto L74;
        r123.put("cmd_official_inspector", new com.bytedance.android.live.room.discovery.inspector.a(0, r100));
        return;
    L74:
        return;
    }
}
