package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket;

import am2.n;
import am2.x;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.q2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.config.gd1;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.g;
import com.bytedance.android.livesdk.vscore_impl.paidlive.f;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import ev1.q;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class ToolbarTicketSaleBehavior implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.vscore_api.paidlive.model.a f160477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomContext f160478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CompositeDisposable f160479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f160480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f160481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f160482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f160483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f160484h;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarTicketSaleBehavior f160485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f160486b;

        public a(ToolbarTicketSaleBehavior r100, View r101) {
            this.f160485a = r100;
            this.f160486b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            View r102 = this.f160485a.f160481e;
            if (r102 == null) goto L6;
            r102.setBackground(new BitmapDrawable(this.f160486b.getResources(), r101));
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Drawable f160487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ToolbarTicketSaleBehavior f160488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f160489c;

        public b(Drawable r100, ToolbarTicketSaleBehavior r101, View r102) {
            this.f160487a = r100;
            this.f160488b = r101;
            this.f160489c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            View r102 = this.f160488b.f160481e;
            if (r102 == null) goto L5;
            r102.setBackground(this.f160487a);
        L5:
            ALogger.e("ToolbarTicketSaleBehavior", "load remote img error");
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
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
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final String a() {
        boolean r100 = true;
        if (g.d(this.f160484h).isPaidLive() == false) goto L11;
        com.bytedance.android.livesdk.vscore_api.paidlive.model.a r101 = this.f160477a;
        if (r101 != null) goto L8;
    L10:
        r100 = false;
        goto L11
    L8:
        if (r101.f159476e != true) goto L10;
    L11:
        if (r100 == false) goto L13;
        return "1";
    L13:
        return "0";
    }

    public final String b() {
        Long r100 = null;
        if (g.d(this.f160484h).isPaidLive() == false) goto L9;
        TicketData r101 = z.o(this.f160484h).getTicketInfo();
        if (r101 == null) goto L8;
        r100 = Long.valueOf(r101.getTicketId());
    L8:
        return String.valueOf(r100);
    L9:
        com.bytedance.android.livesdk.vscore_api.paidlive.model.a r102 = this.f160477a;
        if (r102 == null) goto L13;
        r100 = Long.valueOf(r102.f159472a);
    L13:
        return String.valueOf(r100);
    }

    public final boolean c() {
        if (g.d(this.f160484h).isPaidLive() == true) goto L11;
        String r100 = z.o(this.f160484h).getOwnerUserIdString();
        com.bytedance.android.livesdk.vscore_api.paidlive.model.a r101 = this.f160477a;
        if (r101 == null) goto L7;
        String r102 = r101.f159473b;
    L9:
        return Intrinsics.areEqual(r100, r102);
    L7:
        r102 = null;
        goto L9
    L11:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.c(g.d(this.f160484h)) == false) goto L19;
        com.bytedance.android.livesdk.vscore_api.paidlive.model.a r103 = this.f160477a;
        if (r103 != null) goto L15;
        return true;
    L15:
        if (r103.f159476e != true) goto L21;
        return false;
    L21:
        return true;
    L19:
        return true;
    }

    public final void g() {
        com.bytedance.android.livesdk.vscore_api.paidlive.g r100 = com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e;
        LinkedHashMap r101 = new LinkedHashMap();
        TuplesKt.to("visible", "true");
        Unit r102 = Unit.INSTANCE;
        RoomContext r103 = this.f160478b;
        if (r103 == null) goto L9;
        m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L9;
        Room r105 = r104.getValue();
        if (r105 == null) goto L9;
        long r106 = r105.f162599id;
    L10:
        Map.Entry r107 = z0.a(g.a(r106, null).D2());
        if (r107 == null) goto L17;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r108 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r107.getValue();
        if (r108 == null) goto L17;
        PaidSceneViewEntry r109 = r108.k5();
        if (r109 == null) goto L17;
        String r110 = r109.name();
    L18:
        RoomContext r111 = this.f160478b;
        if (r111 == null) goto L25;
        m<Room> r112 = r111.getRoom();
        if (r112 == null) goto L25;
        Room r113 = r112.getValue();
        if (r113 == null) goto L25;
        long r114 = r113.f162599id;
    L26:
        Map.Entry r115 = z0.a(g.a(r114, null).D2());
        if (r115 == null) goto L33;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r116 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r115.getValue();
        if (r116 == null) goto L33;
        PaidSceneEnum r117 = r116.i0();
        if (r117 == null) goto L33;
        String r118 = r117.name();
    L34:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r100, "paidlive_ticket_toolbar_show_status", r101, null, r110, r118, 4, null);
        o r119 = u.l().c(Room.class);
        com.bytedance.android.livesdk.log.g r120 = u.l();
        Pair[] r121 = new Pair[14];
        r121[0] = TuplesKt.to("ticket_id", b());
        String r122 = "1";
        if (c() == false) goto L37;
        Object r123 = "1";
    L38:
        r121[1] = TuplesKt.to("is_creator_anchor", r123);
        RoomContext r124 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r124 == null) goto L45;
        m<Boolean> r125 = r124.isCleanMode();
        if (r125 == null) goto L45;
        if (r125.getValue().booleanValue() != true) goto L45;
    L46:
        r121[2] = TuplesKt.to("if_clear_mode", r122);
        r121[3] = TuplesKt.to(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, "paidlive_live_bottom_buyticket_icon");
        r121[4] = TuplesKt.to(PaidReplayConstants.KEY_TICKET_ENTRANCE, "paidlive_live_bottom_buyticket_icon");
        String r126 = "";
        if (r119 == null) goto L52;
        Map<String, String> r127 = r119.getMap();
        if (r127 == null) goto L52;
        String r128 = r127.get("room_id");
        if (r128 == null) goto L52;
    L53:
        r121[5] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_ID, r128);
        if (r119 == null) goto L59;
        Map<String, String> r129 = r119.getMap();
        if (r129 == null) goto L59;
        String r130 = r129.get("anchor_id");
        if (r130 == null) goto L59;
    L60:
        r121[6] = TuplesKt.to("from_author_id", r130);
        r121[7] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, "live");
        r121[8] = TuplesKt.to("is_carry_paidlive", a());
        r121[9] = TuplesKt.to("paidcontent_type", "content_list");
        r121[10] = TuplesKt.to("paidcontent_id", "content_list");
        r121[11] = TuplesKt.to("paidcontent_author_id", "content_list");
        r121[12] = TuplesKt.to("spu_id", "content_list");
        r121[13] = TuplesKt.to("spu_name", "content_list");
        Map<String, String> r131 = MapsKt.mutableMapOf(r121);
        if (g.d(this.f160484h).isPaidLive() == false) goto L69;
        TicketData r132 = z.o(this.f160484h).getTicketInfo();
        if (r132 == null) goto L68;
        String r133 = r132.getTicketCategoryLogStr();
        if (r133 == null) goto L68;
        r126 = r133;
    L68:
        r131.put("ticket_type", r126);
    L69:
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.g().x(this.f160484h, r131);
        PaidSceneContext r134 = g.d(this.f160484h).u1(PaidSceneEnum.PAID_ROOM);
        if (r134 == null) goto L74;
        Map<String, String> r135 = r134.getCommonExtraMap();
        if (r135 == null) goto L74;
        r131.putAll(r135);
    L74:
        r120.sendLog("livesdk_paidlive_buyticket_module_show", r131, new Object[]{Room.class, x.class, n.class});
        f("othershow", this.f160477a);
        return;
    L59:
        r130 = "";
    L52:
        r128 = "";
    L45:
        r122 = "0";
        goto L46
    L37:
        r123 = "0";
    L33:
        r118 = null;
    L25:
        r114 = 0;
    L17:
        r110 = null;
    L9:
        r106 = 0;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(s r100) {
        if (g.d(this.f160484h).isPaidLive() == true) goto L5;
        return;
    L5:
        g();
    }

    public final void d(Map<String, String> r210) {
        o r100 = u.l().c(Room.class);
        com.bytedance.android.livesdk.log.g r101 = u.l();
        Pair[] r102 = new Pair[14];
        r102[0] = TuplesKt.to("ticket_id", b());
        String r103 = "1";
        if (c() == false) goto L5;
        Object r104 = "1";
    L6:
        r102[1] = TuplesKt.to("is_creator_anchor", r104);
        RoomContext r105 = this.f160478b;
        if (r105 == null) goto L13;
        m<Integer> r106 = r105.getCleanMode();
        if (r106 == null) goto L13;
        if (r106.getValue().intValue() != 3) goto L13;
    L21:
        r102[2] = TuplesKt.to("if_clear_mode", r103);
        r102[3] = TuplesKt.to(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, "paidlive_live_bottom_buyticket_icon");
        r102[4] = TuplesKt.to(PaidReplayConstants.KEY_TICKET_ENTRANCE, "paidlive_live_bottom_buyticket_icon");
        String r107 = "";
        if (r100 == null) goto L27;
        Map<String, String> r108 = r100.getMap();
        if (r108 == null) goto L27;
        String r109 = r108.get("room_id");
        if (r109 == null) goto L27;
    L28:
        r102[5] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_ID, r109);
        if (r100 == null) goto L34;
        Map<String, String> r110 = r100.getMap();
        if (r110 == null) goto L34;
        String r111 = r110.get("anchor_id");
        if (r111 == null) goto L34;
    L35:
        r102[6] = TuplesKt.to("from_author_id", r111);
        r102[7] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, "live");
        r102[8] = TuplesKt.to("is_carry_paidlive", a());
        r102[9] = TuplesKt.to("paidcontent_type", "content_list");
        r102[10] = TuplesKt.to("paidcontent_id", "content_list");
        r102[11] = TuplesKt.to("paidcontent_author_id", "content_list");
        r102[12] = TuplesKt.to("spu_id", "content_list");
        r102[13] = TuplesKt.to("spu_name", "content_list");
        Map<String, String> r112 = MapsKt.mutableMapOf(r102);
        if (g.d(this.f160484h).isPaidLive() == false) goto L44;
        TicketData r113 = z.o(this.f160484h).getTicketInfo();
        if (r113 == null) goto L43;
        String r114 = r113.getTicketCategoryLogStr();
        if (r114 == null) goto L43;
        r107 = r114;
    L43:
        r112.put("ticket_type", r107);
    L44:
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.g().x(this.f160484h, r112);
        r112.putAll(r210);
        PaidSceneContext r115 = g.d(this.f160484h).u1(PaidSceneEnum.PAID_ROOM);
        if (r115 == null) goto L49;
        Map<String, String> r116 = r115.getCommonExtraMap();
        if (r116 == null) goto L49;
        r112.putAll(r116);
    L49:
        Unit r117 = Unit.INSTANCE;
        r101.sendLog("livesdk_paidlive_buyticket_module_click", r112, new Object[]{Room.class, x.class, n.class});
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e, "paidlive_ticket_toolbar_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ticket_id", b())}), r210, null, null, 24, null);
        return;
    L34:
        r111 = "";
    L27:
        r109 = "";
    L13:
        RoomContext r118 = this.f160478b;
        if (r118 == null) goto L20;
        m<Integer> r119 = r118.getCleanMode();
        if (r119 == null) goto L20;
        if (r119.getValue().intValue() == 13) goto L21;
    L20:
        r103 = "0";
        goto L21
    L5:
        r104 = "0";
        goto L6
    }

    public final void e(long r110) {
        com.bytedance.android.livesdk.vscore_api.paidlive.model.a r100 = this.f160477a;
        if (r100 == null) goto L85;
        o r101 = u.l().c(Room.class);
        Pair[] r102 = new Pair[14];
        r102[0] = TuplesKt.to("click_buyticket_time", String.valueOf(this.f160480d));
        o r103 = u.l().c(x.class);
        String r104 = n.f().c();
        if (r104 != null) goto L7;
    L10:
        boolean r105 = true;
    L11:
        String r106 = "";
        if (r105 == true) goto L22;
        Map<String, String> r107 = r103.getMap();
        if (r107.containsKey("enter_from_ad_type") == false) goto L22;
        if (TextUtils.isEmpty(r107.get("enter_from_ad_type")) == true) goto L22;
        String r108 = r107.get("enter_from_ad_type");
        if (r108 != null) goto L20;
        r108 = r107.get("enter_from_merge");
    L20:
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        r102[1] = TuplesKt.to("enter_from_merge", r108);
        r102[2] = TuplesKt.to("enter_method", l0.a("enter_method", u.l().c(x.class)));
        r102[3] = TuplesKt.to(PaidReplayConstants.KEY_TICKET_ENTRANCE, "paidlive_live_bottom_buyticket_icon");
        r102[4] = TuplesKt.to("entrance_form", "paidlive_live_bottom_buyticket_icon");
        String r109 = r101.getMap().get("room_id");
        if (r109 != null) goto L26;
        r109 = "";
    L26:
        r102[5] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_ID, r109);
        String r111 = r101.getMap().get("anchor_id");
        if (r111 == null) goto L30;
        r106 = r111;
    L30:
        r102[6] = TuplesKt.to("from_author_id", r106);
        r102[7] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, "live");
        String r112 = "0";
        if (g.d(this.f160484h).isPaidLive() == false) goto L33;
        Object r113 = "1";
    L34:
        r102[8] = TuplesKt.to("is_paidlive", r113);
        r102[9] = TuplesKt.to("is_carry_paidlive", "1");
        if (Intrinsics.areEqual(r100.f159473b, z.o(this.f160484h).getOwnerUserIdString()) == false) goto L37;
        r112 = "1";
    L37:
        r102[10] = TuplesKt.to("is_creator_anchor", r112);
        r102[11] = TuplesKt.to("action_type", l0.a("action_type", u.l().c(x.class)));
        r102[12] = TuplesKt.to("is_other_channel", g4.b());
        r102[13] = TuplesKt.to("live_reason", l0.a("live_reason", u.l().c(x.class)));
        Map<String, String> r114 = MapsKt.mutableMapOf(r102);
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.g().x(this.f160484h, r114);
        PaidSceneContext r115 = g.d(this.f160484h).u1(PaidSceneEnum.PAID_ROOM);
        if (r115 == null) goto L43;
        Map<String, String> r116 = r115.getCommonExtraMap();
        if (r116 == null) goto L43;
        r114.putAll(r116);
    L43:
        if (g.d(this.f160484h).isPaidLive() == false) goto L45;
        String r117 = r100.f159475d;
    L46:
        if (r117 != null) goto L48;
    L51:
        boolean r118 = true;
    L52:
        if (r118 == false) goto L55;
        ALogger.e(this.f160482f, "empty schema! isPaidRoom: " + g.d(this.f160484h).isPaidLive());
        return;
    L55:
        Uri r119 = UriProtector.parse(r117);
        String r120 = UriProtector.getQueryParameter(r119, "url");
        if (r120 != null) goto L58;
    L61:
        boolean r121 = true;
    L62:
        if (r121 == false) goto L66;
        String r122 = f.a(r117, r114);
        if (r122 == null) goto L75;
        r119 = UriProtector.parse(r122);
    L75:
        String r123 = r119.toString();
        ILiveActionHandler r124 = (ILiveActionHandler) k.f(ILiveActionHandler.class);
        if (r124 == null) goto L78;
        r124.handle(this.f160483g, r123);
    L78:
        ALogger.i(this.f160482f, "open schema: " + r123);
        d(MapsKt.mapOf(new Pair[]{TuplesKt.to("click_interval", String.valueOf(r110)), TuplesKt.to(URLDispatch.KEY_FINAL_URL, r123)}));
        f("ticket_icon_click", r100);
        return;
    L66:
        String r125 = f.a(UriProtector.getQueryParameter(r119, "url"), r114);
        if (r125 == null) goto L75;
        Uri.Builder r126 = r119.buildUpon().clearQuery();
        Iterator<T> r127 = UriProtector.getQueryParameterNames(r119).iterator();
    L70:
        if (r127.hasNext() == false) goto L74;
        String r128 = (String) r127.next();
        if ((!Intrinsics.areEqual(r128, "url")) == false) goto L70;
        r126.appendQueryParameter(r128, UriProtector.getQueryParameter(r119, r128));
        goto L70
    L74:
        r126.appendQueryParameter("url", r125);
        r119 = r126.build();
        goto L75
    L58:
        if (r120.length() == 0) goto L61;
        r121 = false;
        goto L62
    L48:
        if (r117.length() == 0) goto L51;
        r118 = false;
        goto L52
    L45:
        r117 = r100.f159474c;
        goto L46
    L33:
        r113 = "0";
    L22:
        r108 = l0.a("enter_from_merge", r103);
        goto L23
    L7:
        if (r104.length() == 0) goto L10;
        r105 = false;
        goto L11
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = System.currentTimeMillis();
        long r102 = r101 - this.f160480d;
        if (r102 >= gd1.f120272a.getValue().longValue()) goto L5;
        return;
    L5:
        this.f160480d = r101;
        if (g.d(this.f160484h).isPaidLive() == false) goto L8;
    L11:
        ALogger.i(this.f160482f, "openPanelForPaidRoom");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, "paidlive_live_bottom_buyticket_icon");
        r103.put("is_carry_paidlive", a());
        com.bytedance.android.livesdk.vscore_api.paidlive.c r104 = g.d(this.f160484h);
        PaidSceneEnum r105 = PaidSceneEnum.PAID_ROOM;
        if (r104.e1(r105) == true) goto L28;
        nm1.m r106 = pm1.f.l();
        if (r106 != null) goto L16;
    L17:
        nm1.m r107 = pm1.f.l();
        if (r107 != null) goto L20;
    L24:
        boolean r108 = false;
    L25:
        if (r108 == false) goto L28;
        com.bytedance.android.livesdk.vscore_api.paidlive.c.a.a(g.d(this.f160484h), r105, r103, 8);
    L42:
        d(MapsKt.emptyMap());
        return;
    L20:
        if (r107.a(this.f160484h) != true) goto L24;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.g().i(this.f160484h) == true) goto L24;
    L23:
        r108 = true;
        goto L25
    L16:
        if (r106.a(this.f160484h) == false) goto L23;
    L28:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.g().i(this.f160484h) == false) goto L30;
        com.bytedance.android.livesdk.vscore_api.paidlive.c.a.a(g.d(this.f160484h), PaidSceneEnum.PAID_CAMERA, r103, 8);
        goto L42
    L30:
        com.bytedance.android.livesdk.vscore_api.paidlive.c r109 = g.d(this.f160484h);
        PaidSceneEnum r110 = PaidSceneEnum.PAID_PRIVILEGE_CAMERA;
        if (r109.e1(r110) == true) goto L36;
        com.bytedance.android.livesdk.vscore_api.paidlive.c r111 = g.d(this.f160484h);
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.g().a(this.f160484h) == true) goto L35;
        r103.put(PaidReplayConstants.KEY_PRIVILEGE_TYPE, "0");
    L35:
        Unit r112 = Unit.INSTANCE;
        com.bytedance.android.livesdk.vscore_api.paidlive.c.a.a(r111, r110, r103, 8);
        goto L42
    L36:
        com.bytedance.android.livesdk.vscore_api.paidlive.model.a r113 = this.f160477a;
        if (r113 != null) goto L39;
    L41:
        com.bytedance.android.livesdk.vscore_api.paidlive.c.a.a(g.d(this.f160484h), r105, r103, 8);
        goto L42
    L39:
        if (r113.f159476e != true) goto L41;
        e(r102);
        return;
    L8:
        if (q2.c(z.o(this.f160484h)) == true) goto L11;
        e(r102);
    }

    public ToolbarTicketSaleBehavior(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f160483g = r100;
        this.f160484h = r101;
        this.f160478b = RoomContext.a.c(RoomContext.Companion, r101, 0, 2);
        this.f160482f = "ToolbarTicketSaleBehavior[" + hashCode() + ']';
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        CompositeDisposable r102 = this.f160479c;
        if (r102 == null) goto L6;
        r102.dispose();
        return;
    }

    public final void f(String r100, com.bytedance.android.livesdk.vscore_api.paidlive.model.a r101) {
        String r102 = n.f().c();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        HashMap r104 = new HashMap();
        r104.put("value", n.f().c());
        r104.put("log_extra", n.f().d());
        JSONObject r105 = new JSONObject();
        RoomContext r106 = this.f160478b;
        String r107 = null;
        if (r106 == null) goto L18;
        m<Room> r108 = r106.getRoom();
        if (r108 == null) goto L18;
        Room r109 = r108.getValue();
        if (r109 == null) goto L18;
        String r110 = r109.getIdStr();
    L19:
        r105.put("room_id", r110);
        RoomContext r111 = this.f160478b;
        if (r111 == null) goto L28;
        m<Room> r112 = r111.getRoom();
        if (r112 == null) goto L28;
        Room r113 = r112.getValue();
        if (r113 == null) goto L28;
        IUser r114 = r113.author();
        if (r114 == null) goto L28;
        r107 = r114.getIdString();
    L28:
        r105.put("anchor_id", r107);
        if (r101 == null) goto L31;
        r105.put("ticket_session_id", r101.f159472a);
    L31:
        ILiveDouPlusService r115 = (ILiveDouPlusService) k.n(ILiveDouPlusService.class);
        HashMap r116 = new HashMap();
        r116.put("refer", "ticket_icon");
        r116.put("ad_extra_data", r105.toString());
        if (r104.isEmpty() == true) goto L35;
        r116.putAll(r104);
    L35:
        r115.logEvent(true, "live_ad", r100, r116);
        return;
    L18:
        r110 = null;
        goto L19
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f160479c = new CompositeDisposable();
        RoomContext r102 = this.f160478b;
        if (r102 == null) goto L7;
        j<ViewModel> r103 = r102.getPaidLiveTicketSaleManager();
        if (r103 == null) goto L7;
        r103.c(new ToolbarTicketSaleBehavior$onLoad$1(this));
    L7:
        this.f160481e = r100.findViewById(R.id.icon);
        RoomContext r104 = this.f160478b;
        if (r104 == null) goto L48;
        m<Room> r105 = r104.getRoom();
        if (r105 == null) goto L49;
        Room r106 = r105.getValue();
        if (r106 == null) goto L50;
        LiveToolbarData r107 = r106.getToolbarData();
        if (r107 == null) goto L51;
        List<IToolbarComponentData> r108 = r107.getToolbarDataList();
        if (r108 == null) goto L52;
        Iterator<T> r109 = r108.iterator();
    L19:
        if (r109.hasNext() == false) goto L26;
        Object r110 = r109.next();
        if (((IToolbarComponentData) r110).getId() != 8) goto L23;
        boolean r111 = true;
    L24:
        if (r111 == false) goto L19;
    L27:
        IToolbarComponentData r112 = (IToolbarComponentData) r110;
        if (r112 == null) goto L53;
        py.k r113 = r112.getIcon();
        if (r113 == null) goto L54;
        View r114 = this.f160481e;
        if (r114 == null) goto L34;
        Drawable r115 = r114.getBackground();
    L35:
        View r116 = this.f160481e;
        if (r116 == null) goto L39;
        r116.setBackground(null);
    L39:
        if (q.f474230d.getValue().booleanValue() == false) goto L41;
        int r117 = qy.a.f535172a;
        r113 = qy.a.b("", CollectionsKt.listOf(new String[]{q.f474227a + "live_toolbar_ic_v2_ticketsale_static.png", q.f474228b + "live_toolbar_ic_v2_ticketsale_static.png", q.f474229c + "live_toolbar_ic_v2_ticketsale_static.png"}));
    L41:
        a1.k(r113).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r100), new b(r115, this, r100));
        return;
    L34:
        r115 = null;
        goto L35
    L54:
        return;
    L53:
        return;
    L23:
        r111 = false;
        goto L24
    L26:
        r110 = null;
        goto L27
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    }
}
