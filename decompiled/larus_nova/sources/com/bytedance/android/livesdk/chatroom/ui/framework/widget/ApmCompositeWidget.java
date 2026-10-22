package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ApmCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ApmCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113056a;

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f113056a = ho1.a.d(getComponentContext());
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.observeForever("cmd_send_priority_widget_load_track", this);
    L5:
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L9;
        r101.observeForever("cmd_widget_loaded", this);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        this.f113056a = null;
    }

    public ApmCompositeWidget() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r102 = this.f113056a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.hq() != true) goto L56;
        Room r103 = null;
        if (r101 == null) goto L10;
        String r104 = r101.getKey();
    L11:
        if (r104 == null) goto L57;
        int r105 = r104.hashCode();
        if (r105 == (-1836833765)) goto L26;
        if (r105 == 2125823940) goto L19;
        return;
    L19:
        if (r104.equals("cmd_send_priority_widget_load_track") == false) goto L50;
        Integer r106 = (Integer) r101.getData(null);
        if (r106 == null) goto L51;
        int r107 = r106.intValue();
        if (com.bytedance.android.live.core.tetris.widgets.d.d() == false) goto L52;
        wq(r107, SystemClock.elapsedRealtime() - ((Number) this.dataCenter.get("widget_load_start_time", 0L)).longValue(), "livesdk_framework_loading_duration");
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L26:
        if (r104.equals("cmd_widget_loaded") == true) goto L28;
        return;
    L28:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r101) == false) goto L55;
        int r108 = k60.b.g();
        if (r108 != 1) goto L32;
    L37:
        k60.b.i();
    L38:
        IPerformanceManager r109 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r109 == null) goto L47;
        DataCenter r110 = this.dataCenter;
        if (r110 == null) goto L43;
        r103 = com.bytedance.android.live.core.utils.z.o(r110);
    L43:
        if (r103 == null) goto L45;
        long r111 = r103.f162599id;
    L46:
        r109.forceStopLoadStallMonitor(r111, false);
        r109.onModuleStop(IPerformanceManager.MODULE_ENTER_ROOM);
        goto L47
    L45:
        r111 = 0;
    L47:
        wq(-1, SystemClock.elapsedRealtime() - ((Number) this.dataCenter.get("widget_load_start_time", 0L)).longValue(), "livesdk_all_components_loading_duration");
        TimeCostUtil.Tag r112 = TimeCostUtil.Tag.ShowBInteractionFirstWidget;
        int r113 = TimeCostUtil.f65106a;
        com.bytedance.android.live.core.performance.a r114 = com.bytedance.android.live.core.performance.a.f65108a;
        r112.name();
        r114.getClass();
        TimeCostUtil.Tag.ShowCInteractionFirstWidget.name();
        return;
    L32:
        if (r108 == 3) goto L37;
        if (r108 != 2) goto L38;
        int r115 = cu2.a.f465419a;
        cu2.a.C5589a.b();
        goto L38
    L55:
        return;
    L57:
        return;
    L10:
        r104 = null;
        goto L11
    }

    public final void wq(int r100, long r101, String r110) {
        HashMap r102 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r103 != null) goto L5;
    L16:
        String r104 = "";
        String r105 = r104;
    L17:
        r102.put("enter_from_merge", r105);
        r102.put("enter_method", r104);
        DataCenter r106 = this.dataCenter;
        String r107 = null;
        if (r106 == null) goto L20;
        Room r108 = com.bytedance.android.live.core.utils.z.o(r106);
    L21:
        if (r108 != null) goto L23;
    L29:
        r102.put("duration", String.valueOf(r101));
        r102.put("action_type", (String) this.dataCenter.get("log_action_type", ""));
        if (r100 == (-1)) goto L32;
        r102.put("level", String.valueOf(r100));
    L32:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r109 = ho1.a.d(getComponentContext());
        if (r109 == null) goto L35;
        boolean r111 = r109.dg();
    L36:
        if (r111 == false) goto L38;
        String r112 = "1";
    L39:
        r102.put(IPerformanceManager.Params.is_anchor, r112);
        com.bytedance.android.livesdk.log.u.l().sendLog(r110, r102, new Object[0]);
        return;
    L38:
        r112 = "0";
        goto L39
    L35:
        r111 = false;
        goto L36
    L23:
        if (r108.mo8271getOwner() == null) goto L28;
        User r113 = r108.mo8271getOwner();
        if (r113 == null) goto L27;
        r107 = r113.getIdStr();
    L27:
        r102.put("anchor_id", r107);
    L28:
        String r114 = String.valueOf(r108.f162599id);
        LiveMode r115 = r108.getStreamType();
        int r116 = com.bytedance.android.live.core.utils.h1.f66189a;
        String r117 = com.bytedance.android.live.core.utils.i1.a(r115);
        r102.put("room_id", r114);
        r102.put("live_type", r117);
        goto L29
    L20:
        r108 = null;
        goto L21
    L5:
        if ((r103 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L16;
        com.bytedance.android.livesdk.log.filter.n0 r118 = (com.bytedance.android.livesdk.log.filter.n0) r103;
        if (r118.f153291b.containsKey("enter_from_merge") == false) goto L10;
        r105 = r118.f153291b.get("enter_from_merge");
        if (r105 == null) goto L10;
    L12:
        if (r118.f153291b.containsKey("enter_method") == false) goto L15;
        r104 = r118.f153291b.get("enter_method");
        if (r104 != null) goto L17;
    L15:
        r104 = "";
    L10:
        r105 = "";
        goto L12
    }
}
