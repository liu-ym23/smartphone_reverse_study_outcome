package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.ef0;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/PaidLiveCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidLiveCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.d f113175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.vscore_api.paidlive.l f113176c;

    public final View c6() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r100 = this.f113175b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c6();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f113174a = ho1.a.d(getComponentContext());
        this.f113175b = ho1.a.i(getComponentContext());
        runWithRoomEntered(new AnonymousClass1(this));
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.observeForever("cmd_widget_loaded", this);
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r101 = this.f113174a;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.V9() == true) goto L10;
        return;
    L10:
        if (ef0.f120121a.getValue().booleanValue() == false) goto L24;
        com.bytedance.android.livesdk.vscore_api.paidlive.c r102 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter);
        PaidSceneContext r103 = r102.u1(PaidSceneEnum.PAID_ROOM);
        if (r103 == null) goto L16;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.vscore_api.paidlive.l> r104 = r103.getCurrentState();
        if (r104 == null) goto L16;
        wq(r104.getValue());
        ((ObservableSubscribeProxy) r104.a().observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new k0(this));
    L16:
        PaidSceneContext r105 = r102.u1(PaidSceneEnum.SUBSCRIBE_ROOM);
        if (r105 == null) goto L25;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.vscore_api.paidlive.l> r106 = r105.getCurrentState();
        if (r106 == null) goto L26;
        wq(r106.getValue());
        ((ObservableSubscribeProxy) r106.a().observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new l0(this));
        return;
    L26:
        return;
    L25:
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
        this.f113174a = null;
        this.f113175b = null;
    }

    public PaidLiveCompositeWidget() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r102 = this.f113174a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.hq() != true) goto L33;
        if (r101 == null) goto L9;
        String r103 = r101.getKey();
    L10:
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.hashCode() == (-1836833765)) goto L16;
        return;
    L16:
        if (r103.equals("cmd_widget_loaded") == true) goto L18;
        return;
    L18:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r101) == false) goto L30;
        int r104 = com.bytedance.android.livesdk.chatroom.paidlive.b.f107569b;
        DataCenter r105 = this.dataCenter;
        if (r105 == null) goto L36;
        com.bytedance.android.live.profit.lottery.i r106 = yt0.c.f();
        if (r106 == null) goto L31;
        com.bytedance.android.live.profit.lottery.o r107 = r106.getLotteryPluginStore();
        if (r107 == null) goto L32;
        r107.a(new com.bytedance.android.livesdk.chatroom.paidlive.b(r105));
        return;
    L32:
        return;
    L31:
        return;
    L36:
        return;
    L30:
        return;
    L9:
        r103 = null;
        goto L10
    }

    public final void wq(com.bytedance.android.livesdk.vscore_api.paidlive.l r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        View r101 = null;
        if ((r100 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.l.e) == false) goto L119;
        com.bytedance.android.livesdk.vscore_api.paidlive.l r102 = this.f113176c;
        if (r102 != null) goto L9;
    L69:
        DataCenter r103 = this.dataCenter;
        if (r103 == null) goto L72;
        Room r104 = com.bytedance.android.live.core.utils.z.o(r103);
    L74:
        if (r104 != null) goto L76;
    L100:
        View r105 = c6();
        if (r105 == null) goto L103;
        r105.setVisibility(8);
    L103:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r106 = this.f113175b;
        if (r106 == null) goto L106;
        View r107 = r106.b6();
    L107:
        if (r107 == null) goto L109;
        r107.setVisibility(8);
    L109:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r108 = this.f113175b;
        if (r108 == null) goto L112;
        r101 = r108.fp();
    L112:
        if (r101 == null) goto L114;
        r101.setVisibility(8);
    L114:
        DataCenter r109 = this.dataCenter;
        if (r109 == null) goto L117;
        r109.put("paid_live_hidden_link_multi_view", Boolean.TRUE);
    L117:
        this.f113176c = r100;
        return;
    L106:
        r107 = null;
        goto L107
    L76:
        if (r104.isLiveTypeAudio() != true) goto L100;
        View r110 = c6();
        if (r110 == null) goto L80;
        r110.setVisibility(8);
    L80:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r111 = this.f113175b;
        if (r111 == null) goto L83;
        View r112 = r111.Ia();
    L84:
        if (r112 == null) goto L86;
        r112.setVisibility(8);
    L86:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r113 = this.f113175b;
        if (r113 == null) goto L89;
        View r114 = r113.Dj();
    L90:
        if (r114 == null) goto L92;
        r114.setVisibility(8);
    L92:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r115 = this.f113175b;
        if (r115 == null) goto L95;
        r101 = r115.r7();
    L95:
        if (r101 == null) goto L97;
        r101.setVisibility(8);
    L97:
        DataCenter r116 = this.dataCenter;
        if (r116 == null) goto L117;
        r116.put("paid_live_hidden_link_multi_view", Boolean.TRUE);
        goto L117
    L89:
        r114 = null;
        goto L90
    L83:
        r112 = null;
        goto L84
    L72:
        r104 = null;
        goto L74
    L9:
        if ((!Intrinsics.areEqual(r102.f159461a, r100.f159461a)) == true) goto L69;
        DataCenter r117 = this.dataCenter;
        if (r117 == null) goto L13;
        Room r118 = com.bytedance.android.live.core.utils.z.o(r117);
    L14:
        if (r118 != null) goto L16;
    L46:
        View r119 = c6();
        if (r119 != null) goto L49;
    L51:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r120 = this.f113175b;
        if (r120 == null) goto L54;
        View r121 = r120.b6();
    L55:
        if (r121 != null) goto L57;
    L59:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r122 = this.f113175b;
        if (r122 == null) goto L62;
        View r123 = r122.fp();
    L63:
        if (r123 != null) goto L65;
    L67:
        boolean r124 = true;
    L68:
        if (r124 == true) goto L119;
    L65:
        if (r123.getVisibility() != 0) goto L67;
    L66:
        r124 = false;
        goto L68
    L62:
        r123 = null;
        goto L63
    L57:
        if (r121.getVisibility() != 0) goto L59;
    L54:
        r121 = null;
        goto L55
    L49:
        if (r119.getVisibility() != 0) goto L51;
    L16:
        if (r118.isLiveTypeAudio() != true) goto L46;
        View r125 = c6();
        if (r125 != null) goto L20;
    L22:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r126 = this.f113175b;
        if (r126 == null) goto L25;
        View r127 = r126.Ia();
    L26:
        if (r127 != null) goto L28;
    L30:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r128 = this.f113175b;
        if (r128 == null) goto L33;
        View r129 = r128.Dj();
    L34:
        if (r129 != null) goto L36;
    L38:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r130 = this.f113175b;
        if (r130 == null) goto L41;
        View r131 = r130.r7();
    L42:
        if (r131 == null) goto L67;
        if (r131.getVisibility() != 0) goto L67;
    L41:
        r131 = null;
        goto L42
    L36:
        if (r129.getVisibility() != 0) goto L38;
    L33:
        r129 = null;
        goto L34
    L28:
        if (r127.getVisibility() != 0) goto L30;
    L25:
        r127 = null;
        goto L26
    L20:
        if (r125.getVisibility() != 0) goto L22;
    L13:
        r118 = null;
    L119:
        if ((r100 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.l.a) == false) goto L170;
        DataCenter r132 = this.dataCenter;
        if (r132 == null) goto L123;
        Room r133 = com.bytedance.android.live.core.utils.z.o(r132);
    L124:
        if (r133 != null) goto L126;
    L150:
        View r134 = c6();
        if (r134 == null) goto L153;
        r134.setVisibility(0);
    L153:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r135 = this.f113175b;
        if (r135 == null) goto L156;
        View r136 = r135.b6();
    L157:
        if (r136 == null) goto L159;
        r136.setVisibility(0);
    L159:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r137 = this.f113175b;
        if (r137 == null) goto L162;
        r101 = r137.fp();
    L162:
        if (r101 == null) goto L164;
        r101.setVisibility(0);
    L164:
        DataCenter r138 = this.dataCenter;
        if (r138 == null) goto L167;
        r138.put("paid_live_hidden_link_multi_view", Boolean.FALSE);
    L167:
        this.f113176c = r100;
        return;
    L156:
        r136 = null;
        goto L157
    L126:
        if (r133.isLiveTypeAudio() != true) goto L150;
        View r139 = c6();
        if (r139 == null) goto L130;
        r139.setVisibility(0);
    L130:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r140 = this.f113175b;
        if (r140 == null) goto L133;
        View r141 = r140.Ia();
    L134:
        if (r141 == null) goto L136;
        r141.setVisibility(0);
    L136:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r142 = this.f113175b;
        if (r142 == null) goto L139;
        View r143 = r142.Dj();
    L140:
        if (r143 == null) goto L142;
        r143.setVisibility(0);
    L142:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r144 = this.f113175b;
        if (r144 == null) goto L145;
        r101 = r144.r7();
    L145:
        if (r101 == null) goto L147;
        r101.setVisibility(0);
    L147:
        DataCenter r145 = this.dataCenter;
        if (r145 == null) goto L167;
        r145.put("paid_live_hidden_link_multi_view", Boolean.FALSE);
        goto L167
    L139:
        r143 = null;
        goto L140
    L133:
        r141 = null;
        goto L134
    L123:
        r133 = null;
        goto L124
    }
}
