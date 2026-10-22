package av2;

import am2.a0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.l;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeBaseInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nm1.h;
import pm1.f;

/* JADX INFO: loaded from: classes11.dex */
public class c extends com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.log.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f16363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f16364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f16365d;

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.log.a, com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public final void Ck() {
        if (this.f16365d.i0() != PaidSceneEnum.PAID_REPLAY_CAMERA) goto L5;
    L6:
        h r100 = f.f();
        if (r100 == null) goto L11;
        DataCenter r101 = getDataCenter();
        Map<String, String> r102 = Ra();
        r102.put(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, "live_machine_go_buy_card");
        r102.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, "live_machine_go_buy_card");
        Unit r103 = Unit.INSTANCE;
        r100.g(r101, "livesdk_paid_machine_buyticket_module_close", r102, new Object[0]);
        return;
    L11:
        return;
    L5:
        if (this.f16365d.i0() == PaidSceneEnum.PAID_REPLAY_PRIVILEGE_CAMERA) goto L6;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void Jo() {
        String r100 = "livesdk_paidlive_buyticket_module_show";
        if (this.f16365d.w0().isPreview() == false) goto L8;
        Map<String, String> r101 = a(this.f16363b);
        h r102 = f.f();
        if (r102 == null) goto L31;
        r102.g(getDataCenter(), "livesdk_paidlive_buyticket_module_show", r101, new Object[0]);
        return;
    L31:
        return;
    L8:
        l r103 = this.f16365d.l().getSceneStateMachine().getValue().b();
        r103.getClass();
        if ((r103 instanceof l.e) == false) goto L25;
        IMainEpisode r104 = f();
        if (r104 != null) goto L13;
    L14:
        IMainEpisode r105 = f();
        if (r105 != null) goto L17;
    L19:
        boolean r106 = false;
    L20:
        if (r106 != true) goto L22;
        r100 = "livesdk_paid_machine_buyticket_module_show";
    L22:
        h r107 = f.f();
        if (r107 == null) goto L32;
        DataCenter r108 = getDataCenter();
        Map<String, String> r109 = Ra();
        r109.put(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, c());
        r109.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, c());
        Unit r110 = Unit.INSTANCE;
        r107.g(r108, r100, r109, new Object[0]);
        return;
    L32:
        return;
    L17:
        if (r105.isPrivilegeCameraReplay() != true) goto L19;
    L18:
        r106 = true;
        goto L20
    L13:
        if (r104.isPaidCameraReplay() == true) goto L18;
    L25:
        l r111 = this.f16365d.l().getSceneStateMachine().getValue().b();
        r111.getClass();
        if ((r111 instanceof l.g) == false) goto L34;
        h r112 = f.f();
        if (r112 == null) goto L35;
        DataCenter r113 = getDataCenter();
        Map<String, String> r114 = Ra();
        r114.put(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, c());
        r114.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, c());
        Unit r115 = Unit.INSTANCE;
        r112.f(r113, "delivery_view_show", r114, new Object[0]);
        return;
    L35:
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.log.a, com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public Map<String, String> Ra() {
        Pair[] r100 = new Pair[14];
        int r101 = 0;
        r100[0] = TuplesKt.to("is_paidlive", "1");
        Episode r102 = this.f16365d.D().getEpisode().invoke();
        String r103 = "";
        if (r102 == null) goto L6;
        String r104 = EpisodeExtKt.getOwnerIdString(r102);
        if (r104 == null) goto L6;
    L7:
        r100[1] = TuplesKt.to("anchor_id", r104);
        Episode r105 = this.f16365d.D().getEpisode().invoke();
        Long r106 = null;
        if (r105 == null) goto L10;
        Long r107 = Long.valueOf(r105.roomId);
    L11:
        r100[2] = TuplesKt.to("room_id", String.valueOf(r107));
        if (this.f16365d.w0().isPreview() == false) goto L14;
        String r108 = "paidlive_window_tryend_card";
    L15:
        r100[3] = TuplesKt.to(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, r108);
        r100[4] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, PaidReplayConstants.VALUE_FROM_CONTENT_TYPE);
        IMainEpisode r109 = f();
        if (r109 == null) goto L19;
        String r110 = String.valueOf(r109.getId());
        if (r110 == null) goto L19;
    L20:
        r100[5] = TuplesKt.to(PaidReplayConstants.KEY_FROM_CONTENT_ID, r110);
        Episode r111 = this.f16365d.D().getEpisode().invoke();
        if (r111 == null) goto L24;
        String r112 = EpisodeExtKt.getOwnerIdString(r111);
        if (r112 == null) goto L24;
    L25:
        r100[6] = TuplesKt.to("from_author_id", r112);
        ReplayPaidInfo r113 = g();
        if (r113 == null) goto L31;
        TicketData r114 = r113.getTicketData();
        if (r114 == null) goto L31;
        String r115 = String.valueOf(r114.getTicketId());
        if (r115 == null) goto L31;
    L32:
        r100[7] = TuplesKt.to("ticket_id", r115);
        ReplayPaidInfo r116 = g();
        if (r116 == null) goto L36;
        String r117 = String.valueOf(r116.getFreeDuration());
        if (r117 == null) goto L36;
    L37:
        r100[8] = TuplesKt.to("try_duration", r117);
        ReplayPaidInfo r118 = g();
        if (r118 == null) goto L43;
        TicketData r119 = r118.getTicketData();
        if (r119 == null) goto L43;
        String r120 = r119.getTicketCategoryLogStr();
        if (r120 == null) goto L43;
    L44:
        r100[9] = TuplesKt.to("ticket_type", r120);
        ReplayPaidInfo r121 = g();
        if (r121 == null) goto L50;
        TicketData r122 = r121.getTicketData();
        if (r122 == null) goto L50;
        String r123 = String.valueOf(r122.getTicketId());
        if (r123 == null) goto L50;
    L51:
        r100[10] = TuplesKt.to("select_ticket_id", r123);
        r100[11] = TuplesKt.to("ticket_ids", this.f16365d.l().getCacheTicketIds().getValue());
        ReplayPaidInfo r124 = g();
        if (r124 == null) goto L58;
        TicketData r125 = r124.getTicketData();
        if (r125 == null) goto L58;
        String r126 = r125.getPrice();
        if (r126 == null) goto L58;
        r106 = Long.valueOf((long) (CastFloatProtector.parseFloat(r126) * 100));
    L58:
        r100[12] = TuplesKt.to("pay_num", String.valueOf(r106));
        IMainEpisode r127 = f();
        if (r127 == null) goto L73;
        Map<Integer, PrivilegeInfo> r128 = r127.getPrivilegeInfo();
        if (r128 == null) goto L73;
        IMainEpisode r129 = f();
        if (r129 != null) goto L65;
    L67:
        PrivilegeInfo r130 = r128.get(Integer.valueOf(r101));
        if (r130 == null) goto L73;
        String r131 = r130.getItemIdsForTeaLog();
        if (r131 == null) goto L73;
        r103 = r131;
        goto L73
    L65:
        if (r129.isPrivilegeCameraReplay() != true) goto L67;
        r101 = 6;
    L73:
        r100[13] = TuplesKt.to("vs_privilege_id", r103);
        return MapsKt.mutableMapOf(r100);
    L50:
        r123 = "";
    L43:
        r120 = "";
    L36:
        r117 = "";
    L31:
        r115 = "";
    L24:
        r112 = "";
    L19:
        r110 = "";
        goto L20
    L14:
        r108 = "paidlive_live_tryend_card";
        goto L15
    L10:
        r107 = null;
    L6:
        r104 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.log.a, com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public final String ao() {
        l r100 = this.f16365d.l().getSceneStateMachine().getValue().b();
        ReplayPaidInfo r101 = g();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        ReplayPaidInfo r104 = g();
        if (r104 != null) goto L12;
    L14:
        if (r102 == false) goto L17;
        return "vmember";
    L17:
        if (r103 == true) goto L29;
        r100.getClass();
        if ((r100 instanceof l.f) == false) goto L23;
    L30:
        return "try";
    L23:
        if ((r100 instanceof l.e) == false) goto L26;
        return "try_end";
    L26:
        if (r100.a() == false) goto L30;
    L29:
        return "regular";
    L12:
        if (r104.getViewRight() != 9) goto L14;
        r102 = true;
        goto L14
    L5:
        if (r101.getViewRight() != 0) goto L8;
        r103 = false;
        goto L9
    }

    public final IMainEpisode f() {
        Episode r100 = this.f16365d.D().getEpisode().invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (IMainEpisode) r100.castToOrNull(IMainEpisode.class);
    }

    public final DataCenter getDataCenter() {
        return this.f16365d.D().getDataCenter();
    }

    public final String c() {
        IMainEpisode r100 = f();
        if (r100 != null) goto L5;
    L6:
        IMainEpisode r101 = f();
        if (r101 != null) goto L9;
    L11:
        return "paidlive_live_tryend_card";
    L9:
        if (r101.isPrivilegeCameraReplay() != true) goto L11;
    L10:
        return "live_machine_tryend_card";
    L5:
        if (r100.isPaidCameraReplay() == true) goto L10;
        goto L6
    }

    public final ReplayPaidInfo g() {
        IMainEpisode r100 = f();
        if (r100 == null) goto L7;
        ReplayPaidInfo r101 = r100.getReplayPaidInfo();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.f16365d.D().getReplayPaidInfo();
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.log.a, com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public final void oa() {
        String r100 = ao();
        IMainEpisode r101 = f();
        if (r101 == null) goto L15;
        Map<Integer, PrivilegeInfo> r102 = r101.getPrivilegeInfo();
        if (r102 == null) goto L15;
        Iterator<PrivilegeInfo> r103 = r102.values().iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        PrivilegeBaseInfo r104 = r103.next().paidLiveInfo;
        if (r104 == null) goto L8;
        if (r104.viewRight != 0) goto L8;
        String r105 = "not_paid";
    L16:
        h r106 = f.f();
        if (r106 == null) goto L22;
        DataCenter r107 = getDataCenter();
        Map r108 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_PAID_LIVE_STATUS, r100)});
        if (this.f16365d.w0().isPreview() == true) goto L21;
        r108.put("privilege_status", r105);
    L21:
        Unit r109 = Unit.INSTANCE;
        r106.a(r107, a0.class, MapsKt.toMap(r108));
    L22:
        String r110 = "updateDataToFilter to Filter: watch_status=" + r100 + ", privilege_status=" + r105;
        Intrinsics.checkNotNullParameter(r110, "msg");
        ALogger.i(d(), r110);
        return;
    L14:
        r105 = "paid";
    L15:
        r105 = "none";
        goto L16
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public final Map<String, String> O8() {
        return this.f16363b;
    }

    public String d() {
        return this.f16362a;
    }

    public c(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f16365d = r100;
        this.f16362a = "PaidReplayRoomTeaLogAbility[" + hashCode() + "][" + r100.i0() + "][" + r100.w0() + ']';
        this.f16363b = new HashMap();
    }

    public static Map a(Map r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L5;
        r101.putAll(r100);
    L5:
        r101.put(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, PaidReplayConstants.VALUE_FROM_CONTENT_TYPE);
        r101.put(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, "paidlive_window_tryend_card");
        r101.put("is_vs", "1");
        CharSequence r102 = (CharSequence) r101.get(PaidReplayConstants.KEY_VS_MACHINE_TYPE);
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        r101.put(PaidReplayConstants.KEY_VS_MACHINE_TYPE, "major");
    L14:
        return r101;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public final void kf(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "mob");
        this.f16363b.clear();
        this.f16363b.putAll(r100);
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.log.a, com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public final void setOnBuyTicketAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f16364c = r100;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public void Cm(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "ticketEntrance");
        Intrinsics.checkNotNullParameter(r101, "extraMap");
        String r102 = "livesdk_paidlive_buyticket_module_click";
        if (this.f16365d.w0().isPreview() == false) goto L11;
        Function0<Unit> r103 = this.f16364c;
        if (r103 == null) goto L7;
        Unit r104 = r103.invoke();
    L7:
        Map<String, String> r105 = a(this.f16363b);
        h r106 = f.f();
        if (r106 == null) goto L27;
        r106.g(getDataCenter(), "livesdk_paidlive_buyticket_module_click", r105, new Object[0]);
        return;
    L27:
        return;
    L11:
        IMainEpisode r107 = f();
        if (r107 != null) goto L14;
    L15:
        IMainEpisode r108 = f();
        if (r108 != null) goto L18;
    L20:
        boolean r109 = false;
    L21:
        if (r109 != true) goto L23;
        r102 = "livesdk_paid_machine_buyticket_module_click";
    L23:
        h r110 = f.f();
        if (r110 == null) goto L28;
        DataCenter r111 = getDataCenter();
        Map<String, String> r112 = Ra();
        r112.put(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, r100);
        r112.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, r100);
        Unit r113 = Unit.INSTANCE;
        r110.g(r111, r102, r112, new Object[0]);
        return;
    L28:
        return;
    L18:
        if (r108.isPrivilegeCameraReplay() != true) goto L20;
    L19:
        r109 = true;
        goto L21
    L14:
        if (r107.isPaidCameraReplay() == true) goto L19;
        goto L15
    }
}
