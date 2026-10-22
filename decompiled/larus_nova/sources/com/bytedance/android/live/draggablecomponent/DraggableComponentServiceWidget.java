package com.bytedance.android.live.draggablecomponent;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.message.model.InfoBoxMessage;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/draggablecomponent/DraggableComponentServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/live/draggablecomponent/DraggableComponentPresenter$b;", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DraggableComponentServiceWidget extends RoomRecyclableWidget implements DraggableComponentPresenter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DraggableComponentPresenter f66612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<c61.c, c61.f> f66613b;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        DraggableComponentPresenter r100 = this.f66612a;
        if (r100 == null) goto L5;
        r100.detachView();
    L5:
        ((LinkedHashMap) this.f66613b).clear();
    }

    public DraggableComponentServiceWidget() {
        this.f66613b = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.draggablecomponent.DraggableComponentPresenter.b
    public final void Qk(f r110) {
        Intrinsics.checkNotNullParameter(r110, "draggableDataChangeParams");
        InfoBoxMessage r100 = r110.f66663b;
        final c61.c r101 = new c61.c(r100.scene, r100.subScene);
        long r102 = r110.f66662a;
        if (r102 != 0) goto L54;
        DraggableWindowContext.b r103 = DraggableWindowContext.Companion;
        r103.getClass();
        c61.g r104 = DraggableWindowContext.b.a();
        if (r104 == null) goto L20;
        c61.e r105 = r104.monitor();
        if (r105 == null) goto L20;
        c61.b r106 = new c61.b("livesdk_draggable_component_show");
        r106.b("type", String.valueOf(r110.f66663b.scene));
        r106.b("scene", String.valueOf(r110.f66663b.subScene));
        r106.b("drag_type", String.valueOf(r110.f66663b.dragType));
        if (this.f66613b.containsKey(r101) == false) goto L17;
        r103.getClass();
        c61.g r107 = DraggableWindowContext.b.a();
        if (r107 == null) goto L17;
        c61.d<c61.f> r108 = r107.windowContainer();
        if (r108 == null) goto L17;
        if (r108.v(r101) != true) goto L17;
        String r109 = "1";
    L18:
        r106.b("is_content_update", r109);
        Unit r111 = Unit.INSTANCE;
        r105.a(r106.a());
    L17:
        r109 = "0";
    L20:
        if (this.f66613b.containsKey(r101) == false) goto L32;
        r103.getClass();
        c61.g r112 = DraggableWindowContext.b.a();
        if (r112 == null) goto L32;
        c61.d<c61.f> r113 = r112.windowContainer();
        if (r113 == null) goto L32;
        if (r113.v(r101) != true) goto L32;
        if (this.f66612a == null) goto L64;
        DraggableComponentPresenter.c0(r110.f66663b);
        return;
    L64:
        return;
    L32:
        if (this.f66612a == null) goto L47;
        InfoBoxMessage r114 = r110.f66663b;
        Context r115 = this.context;
        Intrinsics.checkNotNullParameter(r114, "infoBoxSyncData");
        Intrinsics.checkNotNullParameter(r115, PerfLog.PARAM_KEY_CONTEXT_ID);
        Long r116 = r114.scene;
        if (r116 == null) goto L47;
        if (r116.longValue() != 0) goto L47;
        ALogger.i("DraggableComponentPresenter", "初始化LiveAnchorTeleprompterView");
        LiveAnchorTeleprompterVm.Companion.getClass();
        if (LiveAnchorTeleprompterVm.a.a() != null) goto L41;
        new LiveAnchorTeleprompterVm().initialize();
    L41:
        DraggableComponentPresenter.c0(r114);
        final LiveAnchorTeleprompterView r117 = new LiveAnchorTeleprompterView(r115);
        Long r118 = r114.dragType;
        if (r118 != null) goto L45;
    L48:
        this.f66613b.put(r101, r117);
        r103.getClass();
        c61.g r119 = DraggableWindowContext.b.a();
        if (r119 == null) goto L65;
        c61.d<c61.f> r120 = r119.windowContainer();
        if (r120 == null) goto L66;
        r120.u(r117, new DraggableComponentServiceWidget$notifyCardDataChange$2(this, r117, r101));
        return;
    L66:
        return;
    L65:
        return;
    L45:
        if (r118.longValue() != 0) goto L48;
        r117.setDraggableConfig(new c61.h(5, 0, 126));
    L47:
        r117 = null;
        goto L48
    L54:
        if (r102 != 1) goto L68;
        DraggableWindowContext.Companion.getClass();
        c61.g r121 = DraggableWindowContext.b.a();
        if (r121 == null) goto L60;
        c61.d<c61.f> r122 = r121.windowContainer();
        if (r122 == null) goto L60;
        r122.g(r101, 1, DraggableComponentServiceWidget$notifyCardDataChange$3.INSTANCE);
    L60:
        Map<c61.c, c61.f> r123 = this.f66613b;
        if (r123 == null) goto L69;
        c61.f r124 = r123.remove(r101);
        return;
    L69:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        DraggableComponentPresenter r101 = new DraggableComponentPresenter(this.dataCenter);
        r101.f531633a = this;
        DataCenter r102 = r101.f66609f;
        vlc.d r103 = null;
        if (r102 == null) goto L5;
        r103 = (vlc.d) r102.get("data_message_manager", null);
    L5:
        r101.f66607d = r103;
        if (r103 == null) goto L13;
        Iterator<T> r104 = r101.f66608e.iterator();
    L9:
        if (r104.hasNext() == false) goto L16;
        int r105 = ((Number) r104.next()).intValue();
        vlc.d r106 = r101.f66607d;
        if (r106 == null) goto L9;
        r106.addMessageListener(r105, r101);
    L16:
        Unit r107 = Unit.INSTANCE;
        this.f66612a = r101;
        return;
    L13:
        DataCenter r108 = r101.f66609f;
        if (r108 == null) goto L16;
        r108.observe("data_message_manager", r101);
        goto L16
    }
}
