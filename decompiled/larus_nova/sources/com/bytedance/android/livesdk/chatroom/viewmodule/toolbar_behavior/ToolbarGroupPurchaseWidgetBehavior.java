package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.depend.livead.model.ILiveLocalLifeMessage;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.config.c01;
import com.bytedance.android.livesdk.config.d01;
import com.bytedance.android.livesdk.message.model.dm;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/ToolbarGroupPurchaseWidgetBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarGroupPurchaseWidgetBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, vlc.l, Observer<KVData> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f116985l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f116986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f116987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataCenter f116988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RoomContext f116989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vlc.d f116990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Room f116991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f116992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f116993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f116994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f116995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f116996k;

    public static final class a {
        public static boolean a(LiveMode r100) {
            if (r100 == LiveMode.VIDEO) goto L5;
        L9:
            return false;
        L5:
            if (tb1.c.f545235g == false) goto L9;
            if (Intrinsics.areEqual(com.bytedance.android.livesdk.config.t3.f121268a.getValue(), Boolean.TRUE) == false) goto L9;
            return true;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return Intrinsics.areEqual(com.bytedance.android.livesdk.sharedpref.b.f158161i3.getValue(), Boolean.TRUE);
    }

    public final void b() {
        Activity r100 = com.bytedance.android.live.core.utils.a.d();
        if ((r100 instanceof FragmentActivity) == false) goto L8;
        String r101 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.d.b();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        IHostLiveLocalLife r102 = (IHostLiveLocalLife) jc1.k.n(IHostLiveLocalLife.class);
        Intrinsics.checkNotNull(r101);
        r102.openUrlByBullet(r100, r101);
        return;
    L7:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_local_life_no_response", this.f116995j, new Object[0]);
        return;
    L8:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_local_life_no_response", this.f116995j, new Object[0]);
    }

    public ToolbarGroupPurchaseWidgetBehavior(boolean r100) {
        this.f116996k = r100;
        this.f116995j = new HashMap();
    }

    public final void a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r100) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L6;
        return;
    L6:
        if (r100.f116657f == true) goto L10;
        c(8);
        return;
    L10:
        if (this.f116996k == false) goto L24;
        if (tb1.c.f545235g == true) goto L14;
    L17:
        boolean r101 = false;
    L18:
        if (r101 == true) goto L20;
        c(8);
        return;
    L20:
        c(0);
        View r102 = this.f116986a;
        if (r102 == null) goto L31;
        r102.setAlpha(1.0f);
        return;
    L31:
        return;
    L14:
        if (r100.d() != 0) goto L17;
        r101 = true;
        goto L18
    L24:
        if (r100.d() == 1) goto L26;
        c(8);
        return;
    L26:
        c(0);
        View r103 = this.f116986a;
        if (r103 == null) goto L34;
        r103.setAlpha(1.0f);
        return;
    }

    public final void c(int r100) {
        if (r100 == 0) goto L16;
        if (r100 == 8) goto L7;
        return;
    L7:
        if (this.f116996k == false) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r101 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.f116988c);
    L11:
        if (this.f116996k == false) goto L13;
        ToolbarButton r102 = ToolbarButton.GROUP_PURCHASE_MORE;
    L14:
        r101.i(r102.extended());
        return;
    L13:
        r102 = ToolbarButton.GROUP_PURCHASE;
        goto L14
    L9:
        r101 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.f116988c);
        goto L11
    L16:
        if (this.f116996k == false) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r103 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.f116988c);
    L20:
        if (this.f116996k == false) goto L22;
        ToolbarButton r104 = ToolbarButton.GROUP_PURCHASE_MORE;
    L23:
        r103.c(r104.extended());
        return;
    L22:
        r104 = ToolbarButton.GROUP_PURCHASE;
        goto L23
    L18:
        r103 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.f116988c);
        goto L20
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        if ((r100 instanceof pp1.c) == true) goto L5;
        return;
    L5:
        if (this.f116993h == false) goto L7;
        return;
    L7:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_promotion_guide_bubble_show", this.f116995j, new Object[0]);
        RoomContext r101 = this.f116989d;
        Context r102 = null;
        if (r101 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0<pp1.c>> r103 = r101.getToolbarBubbleManager();
        if (r103 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0<pp1.c> r104 = r103.getValue();
    L13:
        View r105 = this.f116986a;
        if (r105 == null) goto L16;
        r102 = r105.getContext();
    L16:
        final View r106 = this.f116986a;
        if (r102 == null) goto L21;
        if (r104 == null) goto L21;
        if (r106 == null) goto L21;
        r104.addBubbleLocal(r100, ((pp1.c) r100).f530177k, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2(this.f116988c, r102, r106), new ToolbarGroupPurchaseWidgetBehavior$onCommand$$inlined$lets$lambda$1(r106, this, r100));
    L21:
        String r107 = SimpleDateFormat.getDateInstance().format(new Date(System.currentTimeMillis()));
        com.bytedance.android.livesdk.sharedpref.e<String> r108 = com.bytedance.android.livesdk.sharedpref.b.f158166j3;
        r108.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r108, r107);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r109 = com.bytedance.android.livesdk.sharedpref.b.f158171k3;
        com.bytedance.android.livesdk.sharedpref.f.d(r109, Integer.valueOf(r109.getValue().intValue() + 1));
        return;
    L12:
        r104 = null;
        goto L13
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getKey();
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.hashCode() == 919040494) goto L12;
        return;
    L12:
        if (r103.equals("data_live_mini_app_commerce_status") == false) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r104 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r101.getData();
        if (r104 != null) goto L16;
        return;
    L16:
        if (com.bytedance.android.live.core.utils.z.e(this.f116988c, false) == false) goto L18;
        r102 = r104;
    L18:
        if (r102 == null) goto L23;
        a(r102);
        return;
    L23:
        return;
    L21:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        if (this.f116996k == false) goto L50;
        RoomContext r100 = this.f116989d;
        if (r100 == null) goto L54;
        com.bytedance.live.datacontext.m<Room> r101 = r100.getRoom();
        if (r101 == null) goto L54;
        Room r102 = r101.getValue();
        if (r102 == null) goto L54;
        long r103 = r102.getRoomId();
        Context r111 = r110.getContext();
        if (r111 == null) goto L54;
        final ToolbarBroadcastFunction r104 = ToolbarBroadcastFunction.GROUP_PURCHASE;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L18;
        BottomToolbarViewModel.a r105 = BottomToolbarViewModel.Companion;
        DataCenter r106 = this.f116988c;
        r105.getClass();
        BottomToolbarViewModel r107 = BottomToolbarViewModel.a.a(r106);
        if (r107 == null) goto L54;
        r107.openChangeDialog(r111, r103, r104, new h3(this));
        goto L54
    L18:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r108 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.f116988c);
        if (r108.h() != 1) goto L22;
        ToolbarBroadcastFunction r109 = ToolbarBroadcastFunction.TRANSFORM_WIDGET;
    L42:
        ToolbarBroadcastFunction r112 = r109;
    L46:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.e(r111, r108, r103, r112, r104, new ToolbarGroupPurchaseWidgetBehavior$showReplaceDialog$2(this), new ToolbarGroupPurchaseWidgetBehavior$showReplaceDialog$3(this, r104));
        goto L54
    L22:
        if (r108.f() != 1) goto L25;
        r109 = ToolbarBroadcastFunction.MINI_APP;
        goto L42
    L25:
        if (r108.b() != 1) goto L28;
        r109 = ToolbarBroadcastFunction.COMMERCE;
        goto L42
    L28:
        if (r108.c() != 1) goto L31;
        r109 = ToolbarBroadcastFunction.GAME_PROMOTE;
        goto L42
    L31:
        if (r108.j() != 1) goto L34;
        r109 = ToolbarBroadcastFunction.WELFARE;
        goto L42
    L34:
        if (r108.d() != 1) goto L37;
    L45:
        r112 = r104;
        goto L46
    L37:
        if (r108.e() != 1) goto L40;
        r109 = ToolbarBroadcastFunction.MIX_MINI_APP;
        goto L42
    L40:
        if (r108.g() != 1) goto L43;
        r109 = ToolbarBroadcastFunction.MINI_GAME;
        goto L42
    L43:
        boolean r113 = tb1.c.f545229a;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L45;
        throw new IllegalStateException("cant has other button unfold");
    L54:
        if (this.f116996k == false) goto L56;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r114 = com.bytedance.android.livesdk.sharedpref.b.f158161i3;
        Boolean r115 = Boolean.FALSE;
        r114.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r114, r115);
        return;
    L56:
        View r116 = this.f116987b;
        if (r116 == null) goto L59;
        r116.setVisibility(8);
    L59:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r117 = com.bytedance.android.livesdk.sharedpref.b.f158176l3;
        Boolean r118 = Boolean.FALSE;
        r117.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r117, r118);
        return;
    L50:
        if (this.f116994i == true) goto L52;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_life_groupbuy_icon_click", this.f116995j, new Object[0]);
    L52:
        this.f116994i = false;
        b();
        goto L54
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L41:
        if (r100 != null) goto L43;
        return;
    L43:
        if (com.bytedance.android.live.core.utils.z.e(this.f116988c, false) == true) goto L45;
    L56:
        if (r101 == true) goto L59;
        r100 = null;
    L59:
        if (r100 == null) goto L65;
        ((ILiveLocalLifeMessage) r100).getUpdateType();
        return;
    L65:
        return;
    L45:
        if (3001 != r100.getIntType()) goto L56;
        if ((r100 instanceof ILiveLocalLifeMessage) == false) goto L56;
        Integer r102 = Integer.valueOf(r100.getClass().getField("type").getInt(r100));     // Catch: Throwable -> L50
    L51:
        if (r102 == null) goto L56;
        if (8 != r102.intValue()) goto L56;
        r101 = true;
    L50:
        r102 = null;
        goto L51
    L5:
        if (com.bytedance.android.live.core.utils.z.e(this.f116988c, false) == true) goto L7;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
        tlc.d r104 = r100;
    L15:
        if (r104 == null) goto L41;
        if ((r104 instanceof dm) == true) goto L19;
        r104 = null;
    L19:
        dm r105 = (dm) r104;
        if (r105 == null) goto L41;
        if (r105.getComponentType() != 7) goto L41;
        if (r105.getEventType() != 1) goto L31;
        if (r105.getOpType() != 0) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r106 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.f116988c);
        r106.f116657f = true;
        r106.f116666o = true;
        DataCenter r107 = this.f116988c;
        if (r107 == null) goto L41;
        r107.put("data_live_mini_app_commerce_status", r106);
    L31:
        if (r105.getEventType() != 1) goto L35;
        if (r105.getOpType() != 1) goto L35;
    L38:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r108 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.f116988c);
        r108.f116657f = true;
        r108.f116666o = false;
        DataCenter r109 = this.f116988c;
        if (r109 == null) goto L41;
        r109.put("data_live_mini_app_commerce_status", r108);
    L35:
        if (r105.getEventType() == 2) goto L38;
        if (r105.getEventType() != 1) goto L41;
    L14:
        r104 = null;
        goto L15
    L7:
        if (r100.getIntType() != MessageType.TOOLBAR_CONTROL_MESSAGE.getIntType()) goto L11;
        if ((r100 instanceof dm) == false) goto L11;
        r103 = true;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        vlc.d r102 = this.f116990e;
        if (r102 == null) goto L5;
        r102.removeMessageListener(this);
    L5:
        Disposable r103 = this.f116992g;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.isDisposed() == true) goto L14;
        Disposable r104 = this.f116992g;
        if (r104 == null) goto L15;
        r104.dispose();
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f116988c = r101;
        this.f116989d = RoomContext.a.c(RoomContext.Companion, r101, 0, 2);
        boolean r102 = true;
        r101.observe("data_live_mini_app_commerce_status", this, true);
        LifecycleOwner r103 = null;
        vlc.d r104 = (vlc.d) r101.get("data_message_manager", null);
        this.f116990e = r104;
        if (r104 == null) goto L5;
        r104.addMessageListener(MessageType.TOOLBAR_CONTROL_MESSAGE.getIntType(), this);
    L5:
        vlc.d r105 = this.f116990e;
        if (r105 == null) goto L8;
        r105.addMessageListener(3001, this);
    L8:
        Room r106 = com.bytedance.android.live.core.utils.z.o(r101);
        this.f116991f = r106;
        Map<String, String> r107 = this.f116995j;
        if (r106 == null) goto L11;
        Long r108 = Long.valueOf(r106.f162599id);
    L12:
        ((HashMap) r107).put("room_id", String.valueOf(r108));
        Map<String, String> r109 = this.f116995j;
        Room r110 = this.f116991f;
        if (r110 == null) goto L15;
        String r111 = r110.getOwnerUserIdString();
    L16:
        ((HashMap) r109).put("anchor_id", String.valueOf(r111));
        Observable<SubscriberJsEvent> r112 = ((IBrowserService) jc1.k.n(IBrowserService.class)).registerJsEventSubscriber("local_life.live.anchor.explanation_card").observeOn(AndroidSchedulers.mainThread());
        DataCenter r113 = this.f116988c;
        if (r113 == null) goto L19;
        r103 = r113.lifecycleOwner;
    L19:
        ((ObservableSubscribeProxy) r112.as(AutoDispose.bind(r103))).subscribe(new g3(this));
        this.f116986a = r100;
        if (this.f116996k == true) goto L28;
        View r114 = r100.findViewById(R.id.view_red_dot);
        this.f116987b = r114;
        if (r114 == null) goto L28;
        if (Intrinsics.areEqual(com.bytedance.android.livesdk.sharedpref.b.f158176l3.getValue(), Boolean.TRUE) == false) goto L26;
        int r115 = 0;
    L27:
        r114.setVisibility(r115);
        goto L28
    L26:
        r115 = 8;
    L28:
        a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.f116988c));
        Integer r116 = c01.f119912a.getValue();
        if (r116 != null) goto L32;
    L34:
        String r117 = SimpleDateFormat.getDateInstance().format(new Date(System.currentTimeMillis()));
        String r118 = com.bytedance.android.livesdk.sharedpref.b.f158166j3.getValue();
        Integer r119 = com.bytedance.android.livesdk.sharedpref.b.f158171k3.getValue();
        if ((!Intrinsics.areEqual(r117, r118)) == true) goto L37;
    L39:
        r102 = false;
    L40:
        if (r102 == false) goto L44;
        this.f116992g = Observable.timer(120, TimeUnit.SECONDS).subscribe(new f3(this), RxUtil.getNoOpThrowable());
    L44:
        if (this.f116996k == true) goto L47;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_life_groupbuy_icon_show", this.f116995j, new Object[0]);
        return;
    L47:
        return;
    L37:
        if (r119.intValue() >= d01.f119993a.getValue().intValue()) goto L39;
    L32:
        if (r116.intValue() != 0) goto L34;
    L15:
        r111 = null;
        goto L16
    L11:
        r108 = null;
        goto L12
    }
}
