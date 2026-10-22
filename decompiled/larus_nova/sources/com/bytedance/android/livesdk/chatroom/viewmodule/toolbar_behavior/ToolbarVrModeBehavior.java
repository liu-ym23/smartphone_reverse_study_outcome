package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.config.su0;
import com.bytedance.android.livesdk.config.tu0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class ToolbarVrModeBehavior extends t5 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f117071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f117072k;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    public ToolbarVrModeBehavior(DataCenter r100) {
        super(r100);
        this.f117072k = 15000;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Context r101 = null;
        String r102 = null;
        r102 = null;
        if ((r100 instanceof pp1.m) == false) goto L34;
        if (((pp1.m) r100).f530192a != 0) goto L53;
        int r103 = VrUtils.l(this.f117385i);
        DataCenter r104 = this.f117385i;
        if (r104 == null) goto L9;
        Integer r105 = (Integer) r104.get("cmd_last_vr_toolbar_orientation", null);
    L10:
        if (r105 != null) goto L13;
    L14:
        DataCenter r106 = this.f117385i;
        if (r106 == null) goto L17;
        r106.put("cmd_last_vr_toolbar_orientation", Integer.valueOf(r103));
    L17:
        String r107 = String.valueOf(VrUtils.l(this.f117385i));
        com.bytedance.android.livesdk.log.g r108 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r109 = new Pair[6];
        DataCenter r110 = this.f117385i;
        if (r110 == null) goto L24;
        Room r111 = com.bytedance.android.live.core.utils.z.o(r110);
        if (r111 == null) goto L24;
        User r112 = r111.mo8271getOwner();
        if (r112 == null) goto L24;
        String r113 = r112.getIdString();
    L25:
        r109[0] = TuplesKt.to("anchor_id", r113);
        DataCenter r114 = this.f117385i;
        if (r114 == null) goto L30;
        Room r115 = com.bytedance.android.live.core.utils.z.o(r114);
        if (r115 == null) goto L30;
        r102 = r115.getIdStr();
    L30:
        r109[1] = TuplesKt.to("room_id", r102);
        r109[2] = TuplesKt.to(VrBgLogData.KEY_VR_TYPE, VrUtils.n());
        r109[3] = TuplesKt.to("is_vr_machine", "1");
        r109[4] = TuplesKt.to("is_original_vr", "1");
        r109[5] = TuplesKt.to("screen_direction", r107);
        r108.sendLog("livesdk_live_vr_label_show", MapsKt.mapOf(r109), new Object[]{am2.x.class});
        JSONObject r116 = new JSONObject();
        r116.put("vr_icon_show", true);     // Catch: JSONException -> L50
    L32:
        com.bytedance.android.livesdk.log.b0.o().k("LiveVRMonitor_live_play", r116);
        return;
    L24:
        r113 = null;
        goto L25
    L13:
        if (r103 != r105.intValue()) goto L14;
        return;
    L9:
        r105 = null;
        goto L10
    L53:
        return;
    L34:
        if ((r100 instanceof pp1.c) == false) goto L56;
        RoomContext r117 = this.f117377a;
        if (r117 == null) goto L40;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0<pp1.c>> r118 = r117.getToolbarBubbleManager();
        if (r118 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0<pp1.c> r119 = r118.getValue();
    L41:
        View r120 = this.f117378b;
        if (r120 == null) goto L44;
        r101 = r120.getContext();
    L44:
        if (r101 == null) goto L57;
        View r121 = this.f117378b;
        if (r119 == null) goto L58;
        if (r121 == null) goto L59;
        r119.addBubble(r100, ((pp1.c) r100).f530177k, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2(this.f117385i, r101, r121), new ToolbarVrModeBehavior$onCommand$$inlined$lets$lambda$1(this, r100));
        this.f117071j = System.currentTimeMillis();
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L40:
        r119 = null;
        goto L41
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        String r100 = null;
        if (r110 == null) goto L5;
        Context r111 = r110.getContext();
    L6:
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r101 = LiveVrContext.c.a();
        if (r101 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.getShouldShowBreathForReset();
        if (r102 == null) goto L15;
        if ((System.currentTimeMillis() - this.f117071j) > this.f117072k) goto L13;
        boolean r103 = true;
    L14:
        r102.setValue(Boolean.valueOf(r103));
        goto L15
    L13:
        r103 = false;
    L15:
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r104 = LiveVrContext.c.a();
        if (r104 == null) goto L18;
        r104.showVrControlDialog(r111);
    L18:
        long r105 = System.currentTimeMillis();
        String r112 = String.valueOf(VrUtils.l(this.f117385i));
        long r106 = com.bytedance.android.livesdk.chatroom.tetris.vr.r.f111944a;
        if (r105 > (r106 - ((long) 20000))) goto L21;
    L23:
        boolean r107 = false;
    L24:
        com.bytedance.android.livesdk.log.g r108 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r109 = new Pair[8];
        DataCenter r113 = this.f117385i;
        if (r113 == null) goto L31;
        Room r114 = com.bytedance.android.live.core.utils.z.o(r113);
        if (r114 == null) goto L31;
        User r115 = r114.mo8271getOwner();
        if (r115 == null) goto L31;
        String r116 = r115.getIdString();
    L32:
        r109[0] = TuplesKt.to("anchor_id", r116);
        DataCenter r117 = this.f117385i;
        if (r117 == null) goto L37;
        Room r118 = com.bytedance.android.live.core.utils.z.o(r117);
        if (r118 == null) goto L37;
        r100 = r118.getIdStr();
    L37:
        r109[1] = TuplesKt.to("room_id", r100);
        r109[2] = TuplesKt.to(VrBgLogData.KEY_VR_TYPE, VrUtils.n());
        String r119 = "1";
        r109[3] = TuplesKt.to("is_vr_machine", "1");
        r109[4] = TuplesKt.to("is_switch_model", "0");
        r109[5] = TuplesKt.to("is_original_vr", "1");
        if (r107 == true) goto L41;
        r119 = "0";
    L41:
        r109[6] = TuplesKt.to("bubble_show", r119);
        r109[7] = TuplesKt.to("screen_direction", r112);
        r108.sendLog("livesdk_live_vr_label_click", MapsKt.mapOf(r109), new Object[]{am2.x.class});
        return;
    L31:
        r116 = null;
        goto L32
    L21:
        if (r105 >= r106) goto L23;
        r107 = true;
        goto L24
    L5:
        r111 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == false) goto L10;
        IAnimationScheduler r102 = IAnimationScheduler.Companion.a(this.f117385i);
        if (r102 == null) goto L9;
        r102.unRegisterListener(this.f117384h);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f117377a = RoomContext.a.c(RoomContext.Companion, r101, 0, 2);
        this.f117378b = r100.findViewById(R.id.static_icon);
        int r102 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.f116309a;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.b(Boolean.valueOf(com.bytedance.android.live.core.utils.z.e(r101, false))) == false) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(this.f117378b);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(r100.findViewById(R.id.vr_static_icon_container));
        View r103 = this.f117378b;
        if (r103 == null) goto L8;
        r103.setBackgroundResource(R.drawable.ttlive_ic_vr_mode38);
    L8:
        if (ev1.q.f474230d.getValue().booleanValue() == false) goto L12;
        View r104 = this.f117378b;
        if (r104 == null) goto L12;
        r104.setBackgroundResource(R.drawable.live_toolbar_ic_v2_vr_static);
    L12:
        this.f117379c = (HSImageView) r100.findViewById(R.id.animated_icon);
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == true) goto L36;
    L27:
        HSImageView r105 = this.f117379c;
        if (r105 != null) goto L30;
        return;
    L30:
        Intrinsics.checkNotNull(r105);
        r105.post(new ToolbarVrModeBehavior$onLoad$1(this));
        com.bytedance.android.livesdk.log.filter.o r106 = com.bytedance.android.livesdk.log.j0.l().c(IRoom.class);
        if (r106 != null) goto L33;
        return;
    L33:
        if ((r106 instanceof com.bytedance.android.livesdk.log.filter.u) == false) goto L39;
        ((com.bytedance.android.livesdk.log.filter.u) r106).y(VrUtils.o(r101));
        return;
    L39:
        return;
    L36:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L25
        if (su0.f121254a.getValue().booleanValue() == false) goto L19;
        ALogger.i("ToolbarVrModeBehavior", "register group purchase by delay");     // Catch: Throwable -> L25
        Object r108 = Boolean.valueOf(com.bytedance.android.live.core.utils.i0.c().postDelayed(new u5(this), tu0.f121327a.getValue().longValue()));     // Catch: Throwable -> L25
    L23:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L25
        goto L27
    L19:
        ALogger.i("ToolbarVrModeBehavior", "register group purchase by no delay");     // Catch: Throwable -> L25
        IAnimationScheduler r109 = IAnimationScheduler.Companion.a(this.f117385i);     // Catch: Throwable -> L25
        if (r109 == null) goto L22;
        r109.registerListener(this.f117384h);     // Catch: Throwable -> L25
        r108 = Unit.INSTANCE;     // Catch: Throwable -> L25
        goto L23
    L22:
        r108 = null;
    L25:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }
}
