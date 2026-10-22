package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.commerce.ECLiteEntranceApi;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.constant.SchemaConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.shopping.LiveShoppingMessageHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.common.applog.AppLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/ToolbarLiteCommerceBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ToolbarLiteCommerceBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, vlc.l, Observer<KVData> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f116997g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f116998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Room f116999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vlc.d f117000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DataCenter f117001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f117002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f117003f;

    public static final class a {
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

    public ToolbarLiteCommerceBehavior() {
        this.f117003f = LazyKt.lazy(new ToolbarLiteCommerceBehavior$logParams$2(this));
    }

    public final void a(Context r100) {
        HashMap r101 = new HashMap();
        r101.put("user_id", ((com.bytedance.android.livesdk.user.f0) ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h()).n());
        r101.put("device_id", AppLog.v());
        Room r102 = this.f116999b;
        String r103 = null;
        if (r102 == null) goto L5;
        Long r104 = Long.valueOf(r102.f162599id);
    L6:
        r101.put("room_id", String.valueOf(r104));
        Room r105 = this.f116999b;
        if (r105 == null) goto L9;
        r103 = r105.getOwnerUserIdString();
    L9:
        r101.put("author_id", String.valueOf(r103));
        r101.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).f().logV3("ecom_lite_transfer", r101);
        Room r106 = this.f116999b;
        if (r106 == null) goto L12;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_product_entrance_click", (Map) this.f117003f.getValue(), new Object[0]);
        IHostAction r107 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).a();
        Bundle r108 = new Bundle();
        r108.putLong("com.ss.android.ugc.live.intent.extra.ROOM_ID", r106.f162599id);
        com.bytedance.android.live.base.model.user.o0.a r109 = com.bytedance.android.live.base.model.user.o0.f58946a;
        r106.getOwnerUserIdString();
        r109.getClass();
        r108.putLong("com.ss.android.ugc.live.intent.extra.USER_ID", 0);
        r108.putBoolean("com.ss.android.ugc.live.intent.extra.OPEN_DOUYIN", true);
        r108.putString("live.intent.extra.ENTER_FROM_MERGE", "dy_lite_app");
        r108.putString("live.intent.extra.ENTER_ENTER_METHOD", "live_tag_cart");
        Unit r110 = Unit.INSTANCE;
        r107.handleSchema(r100, SchemaConstants.SCHEMA_LIVE_DETAIL, r108);
    L12:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r111 = com.bytedance.android.livesdk.sharedpref.b.L1;
        Boolean r112 = Boolean.TRUE;
        r111.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r111, r112);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void b(boolean r100) {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r101 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.f117001d);
        ExtendedToolbarButton r102 = ToolbarButton.COMMERCE.extended();
        if (r100 == false) goto L5;
        r101.c(r102);
        return;
    L5:
        r101.i(r102);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101.getKey(), "CMD_DOUYIN_LITE_COMMERCE_READY") == true) goto L7;
    L13:
        boolean r102 = false;
    L14:
        View r103 = null;
        r103 = null;
        if (r102 == true) goto L18;
        r101 = null;
    L18:
        if (r101 == null) goto L112;
        kg1.a r104 = (kg1.a) r101.getData();
        if (r104 != null) goto L22;
    L30:
        if (r104 != null) goto L32;
    L109:
        b(false);
        return;
    L32:
        if (r104.f503346b != true) goto L109;
        View r105 = this.f116998a;
        if ((r105 instanceof ViewGroup) == true) goto L36;
        r105 = null;
    L36:
        ViewGroup r106 = (ViewGroup) r105;
        if (r106 == null) goto L71;
        DataCenter r107 = this.f117001d;
        if (r107 == null) goto L45;
        Boolean r108 = (Boolean) r107.get("data_is_anchor", Boolean.FALSE);
        LiveMode r109 = LiveMode.VIDEO;
        LiveMode r110 = (LiveMode) r107.get("data_live_mode", r109);
        if (r108.booleanValue() == false) goto L45;
        if (r110 != r109) goto L45;
        boolean r111 = true;
    L46:
        if (r111 == true) goto L68;
        DataCenter r112 = this.f117001d;
        if (r112 == null) goto L55;
        Boolean r113 = (Boolean) r112.get("data_is_anchor", Boolean.FALSE);
        LiveMode r114 = (LiveMode) r112.get("data_live_mode", LiveMode.VIDEO);
        if (r113.booleanValue() == false) goto L55;
        if (r114 != LiveMode.AUDIO) goto L55;
        boolean r115 = true;
    L56:
        if (r115 == true) goto L68;
        DataCenter r116 = this.f117001d;
        if (r116 == null) goto L65;
        Boolean r117 = (Boolean) r116.get("data_is_anchor", Boolean.FALSE);
        LiveMode r118 = (LiveMode) r116.get("data_live_mode", LiveMode.VIDEO);
        if (r117.booleanValue() == false) goto L65;
        if (r118 != LiveMode.SCREEN_RECORD) goto L65;
        boolean r119 = true;
    L66:
        if (r119 == true) goto L68;
        boolean r120 = true;
    L69:
        if (r120 == false) goto L71;
    L72:
        if (r106 == null) goto L100;
        Context r121 = r106.getContext();
        if (r121 == null) goto L100;
        Resources r122 = r121.getResources();
        if (r122 == null) goto L100;
        Configuration r123 = r122.getConfiguration();
        if (r123 == null) goto L100;
        if (r123.orientation != 2) goto L100;
        View r124 = this.f116998a;
        if ((r124 instanceof ViewGroup) == true) goto L84;
        r124 = null;
    L84:
        ViewGroup r125 = (ViewGroup) r124;
        if (r125 == null) goto L87;
        int r126 = r125.getChildCount();
    L88:
        if (r126 < 1) goto L100;
        View r127 = this.f116998a;
        if ((r127 instanceof ViewGroup) == true) goto L92;
        r127 = null;
    L92:
        ViewGroup r128 = (ViewGroup) r127;
        if (r128 == null) goto L95;
        View r129 = r128.getChildAt(0);
    L97:
        if ((r129 instanceof ViewGroup) == true) goto L99;
        r129 = null;
    L99:
        r106 = (ViewGroup) r129;
        goto L100
    L95:
        r129 = null;
        goto L97
    L87:
        r126 = 0;
    L100:
        if (r106 == null) goto L108;
        View r130 = this.f116998a;
        if (r130 == null) goto L106;
        Context r131 = r130.getContext();
        if (r131 == null) goto L106;
        RelativeLayout r132 = new RelativeLayout(r131);
        ViewGroup.LayoutParams r133 = new ViewGroup.LayoutParams(-1, -1);
        Unit r134 = Unit.INSTANCE;
        r132.setLayoutParams(r133);
        ImageView r135 = new ImageView(r131);
        RelativeLayout.LayoutParams r136 = new RelativeLayout.LayoutParams((int) t6.a(r131, 36.0f), (int) t6.a(r131, 36.0f));
        r136.addRule(13);
        r135.setLayoutParams(r136);
        Intrinsics.checkNotNullParameter(r131, PerfLog.PARAM_KEY_CONTEXT_ID);
        r135.setBackgroundResource(R.drawable.ttlive_selector_commerce_btn);
        r132.addView(r135);
        r132.setOnClickListener(this);
        r103 = r132;
    L106:
        if (r103 == null) goto L108;
        this.f117002e = r103;
        r106.addView(r103);
    L108:
        b(true);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_product_entrance_show", (Map) this.f117003f.getValue(), new Object[0]);
        return;
    L65:
        r119 = false;
    L55:
        r115 = false;
    L68:
        r120 = false;
    L45:
        r111 = false;
    L71:
        r106 = null;
        goto L72
    L22:
        if (r104.f503345a != true) goto L30;
        DataCenter r137 = this.f117001d;
        if (r137 == null) goto L26;
        vlc.d r138 = (vlc.d) r137.get("data_message_manager");
    L27:
        this.f117000c = r138;
        if (r138 == null) goto L30;
        r138.addMessageListener(1002, this);
        goto L30
    L26:
        r138 = null;
        goto L27
    L112:
        return;
    L7:
        if (this.f116999b == null) goto L13;
        if ((this.f116998a instanceof ViewGroup) == false) goto L13;
        if ((r101.getData() instanceof kg1.a) == false) goto L13;
        r102 = true;
        goto L14
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 == null) goto L18;
        Integer r101 = Integer.valueOf(r100.getId());
        r101.intValue();
        if (Intrinsics.areEqual(this.f117002e, r100) == true) goto L7;
        r101 = null;
    L7:
        if (r101 != null) goto L9;
        return;
    L9:
        if (com.bytedance.android.livesdk.utils.f1.a(r101.intValue()) == true) goto L20;
        Context r102 = r100.getContext();
        if (puc.a.isInstalledApp(r102, "com.ss.android.ugc.aweme") == true) goto L13;
        com.bytedance.android.livesdk.widget.x0.b r103 = new com.bytedance.android.livesdk.widget.x0.b(r102, 4);
        r103.l(R.string.ttlive_commerce_lite_download_guide);
        r103.i(0, R.string.ttlive_record_save_local, new q3(r102));
        r103.i(1, R.string.ttlive_cancel, r3.f117357a);
        r103.n();
        return;
    L13:
        if (com.bytedance.android.livesdk.sharedpref.b.L1.getValue().booleanValue() == false) goto L15;
        a(r102);
        return;
    L15:
        com.bytedance.android.livesdk.widget.x0.b r104 = new com.bytedance.android.livesdk.widget.x0.b(r102, 4);
        r104.l(R.string.ttlive_commerce_lite_jump_guide);
        r104.i(0, R.string.ttlive_confirm_and_never_alert, new o3(this, r102));
        r104.i(1, R.string.ttlive_cancel, p3.f117332a);
        r104.n();
        return;
    L20:
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        String r101 = kg1.d.f503349a;
        if (r100 == null) goto L59;
        boolean r102 = false;
        boolean r103 = true;
        if (r100.getIntType() != 1002) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        tlc.d r105 = r100;
    L11:
        if (r105 == null) goto L60;
        Integer r106 = LiveShoppingMessageHelper.INSTANCE.getMessageType(r100);
        if (r106 != null) goto L16;
    L18:
        if (r106 == null) goto L24;
        if (r106.intValue() != 14) goto L24;
        kg1.d.f503358j = false;
        return;
    L24:
        if (r106 != null) goto L27;
    L29:
        if (r106 == null) goto L42;
        if (r106.intValue() != 10) goto L42;
    L33:
        if (r106 != null) goto L36;
    L37:
        r102 = true;
    L39:
        if (kg1.d.f503358j == false) goto L63;
        kg1.d.a(true, r102);
        return;
    L63:
        return;
    L36:
        if (r106.intValue() == 10) goto L39;
    L42:
        if (r106 != null) goto L45;
    L47:
        if (r106 != null) goto L50;
        return;
    L50:
        if (r106.intValue() != 11) goto L65;
    L51:
        if (r106 != null) goto L54;
    L57:
        kg1.d.a(false, r103);
        return;
    L54:
        if (r106.intValue() != 11) goto L57;
        r103 = false;
        goto L57
    L65:
        return;
    L45:
        if (r106.intValue() != 1) goto L47;
    L27:
        if (r106.intValue() != 0) goto L29;
    L16:
        if (r106.intValue() != 13) goto L18;
        kg1.d.f503358j = true;
        return;
    L60:
        return;
    L10:
        r105 = null;
        goto L11
    L7:
        r104 = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        vlc.d r102 = this.f117000c;
        if (r102 == null) goto L5;
        r102.removeMessageListener(this);
    L5:
        r101.removeObserver(this);
        Disposable r103 = kg1.d.f503357i;
        if (r103 == null) goto L8;
        r103.dispose();
    L8:
        kg1.d.f503357i = null;
        this.f116999b = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f116998a = r100;
        boolean r102 = false;
        b(false);
        this.f116999b = (Room) r101.get("data_room", null);
        this.f117001d = r101;
        r101.observeForever("CMD_DOUYIN_LITE_COMMERCE_READY", this);
        String r103 = kg1.d.f503349a;
        kg1.d.f503356h = new WeakReference(this.f117001d);
        if (kg1.d.f503355g == false) goto L5;
        return;
    L5:
        if (kg1.d.f503354f == true) goto L7;
        return;
    L7:
        if (kg1.d.f503353e == false) goto L27;
        HashMap<String, String> r104 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("first_enter", "true"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, "live_list_card")});
        String r105 = kg1.d.f503349a;
        if (r105 == null) goto L11;
        r104.put("author_id", r105);
    L11:
        String r106 = kg1.d.f503350b;
        if (r106 == null) goto L14;
        r104.put("sec_author_id", r106);
    L14:
        String r107 = kg1.d.f503351c;
        if (r107 == null) goto L17;
        r104.put("room_id", r107);
    L17:
        IRoomCart r108 = kg1.d.f503352d;
        if (r108 != null) goto L20;
        kg1.d.f503357i = ((ECLiteEntranceApi) com.bytedance.android.live.network.c.b().e(ECLiteEntranceApi.class)).fetchPromotions(r104).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(kg1.b.f503347a, kg1.c.f503348a);
        return;
    L20:
        if (r108.getShowCartExt() != 1) goto L22;
        r102 = true;
    L22:
        kg1.d.a(r102, true);
        return;
    }
}
