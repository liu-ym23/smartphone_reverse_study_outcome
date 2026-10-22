package com.bytedance.android.livesdk.gift.banner;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.android.livesdk.gift.platform.core.model.k;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import cy0.e;
import cy0.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import mz0.i;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f125850e;

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean o(AbsPanel<?> r100, int r101, int r102, IBaseUser r103, boolean r104, List<? extends IBaseUser> r105, n r106, k r107, k r108, l1 r110, com.bytedance.android.livesdk.gift.model.n r111, String r112, int r113, String r114, com.bytedance.android.livesdk.gift.platform.core.model.a r115) {
        Intrinsics.checkNotNullParameter(r103, "toUser");
        Intrinsics.checkNotNullParameter(r106, "showInfo");
        return false;
    }

    public d(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public static final void I(d r100, AbsPanel r101, l2 r110, String r111, boolean r112) {
        IRoom r102 = (IRoom) r100.f129749b.get("data_room", null);
        HashMap r103 = new HashMap();
        if (r110.getCount() > 0) goto L7;
        r103.put("has_popularity_card", Boolean.FALSE);
        b1 r104 = r110.getBanner();
        if (r104 == null) goto L13;
        r104.setHeight(306);
    L13:
        b1 r105 = r110.getBanner();
        if (r105 == null) goto L16;
        r105.setWidth(280);
    L16:
        b1 r106 = r110.getBanner();
        if (r106 == null) goto L19;
        r106.setActionType(2);
    L19:
        r103.put("count", 1);
        if (r102 == null) goto L22;
        long r107 = r102.getId();
    L23:
        r103.put("room_id", Long.valueOf(r107));
        r103.put("prop_def_id", Long.valueOf(r101.c()));
        if (r102 == null) goto L27;
        Comparable r108 = r102.getAnchorId();
        if (r108 == null) goto L27;
    L28:
        r103.put("to_uid", r108);
        r103.put("is_aweme_free_gift", 0);
        String r109 = r101.a();
        String r113 = "";
        if (r109 != null) goto L31;
        r109 = "";
    L31:
        r103.put("describe", r109);
        r103.put("next_expire", Long.valueOf(r110.getNextExpire()));
        if (r111 != null) goto L34;
        r111 = "";
    L34:
        r103.put("city_code", r111);
        r103.put("has_options", Boolean.valueOf(r112));
        if (r100.getContext() == null) goto L39;
        b1 r114 = r110.getBanner();
        if (r114 == null) goto L39;
        int r115 = BannerGiftHelperKt.f125841a;
        BannerGiftHelperKt.a(r100.getContext(), r114, r103);
    L39:
        int r116 = r110.getCount();
        String r117 = r110.getDescription();
        if (r102 == null) goto L42;
        long r118 = r102.getId();
    L43:
        HashMap r119 = new HashMap();
        r119.put("cards_left", String.valueOf(r116));
        if (r117 == null) goto L47;
        r113 = r117;
    L47:
        r119.put("cards_time", r113);
        r119.put("room_id", String.valueOf(r118));
        mz0.n r120 = new mz0.n();
        Map<String, String> r121 = r120.f516447a;
        Intrinsics.checkNotNullParameter(r121, "map");
        Intrinsics.checkNotNullParameter(r119, "map");
        r121.putAll(r119);
        e.f465759a.getClass();
        j r122 = e.a.f465760a;
        m.f163449e.getClass();
        Object r123 = m.b(r122).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r123);
        ((i) ((f80.a) r123)).w3("popular_card_click", r120.f516447a, r120.f516448b);
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        return;
    L42:
        r118 = 0;
    L27:
        r108 = 0;
        goto L28
    L22:
        r107 = 0;
        goto L23
    L7:
        r103.put("has_popularity_card", Boolean.TRUE);
        b1 r124 = r110.getBanner();
        if (r124 == null) goto L13;
        if (r112 == false) goto L11;
        int r125 = 444;
    L12:
        r124.setHeight(r125);
        goto L13
    L11:
        r125 = 373;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean A(AbsPanel<?> r100, int r101, int r102, IBaseUser r103, boolean r104, List<? extends IBaseUser> r105, boolean r106, n r107, k r108, k r110, l1 r111, com.bytedance.android.livesdk.gift.model.n r112, String r113, String r114, com.bytedance.android.livesdk.gift.platform.core.model.a r115) {
        Intrinsics.checkNotNullParameter(r103, "toUser");
        Intrinsics.checkNotNullParameter(r107, "showInfo");
        if ((r100 instanceof pz1.e) == false) goto L27;
        T r109 = ((pz1.e) r100).f126620h;
        if ((r109 instanceof l2) == false) goto L27;
        l2 r116 = (l2) r109;
        if (r116 == null) goto L30;
        if (r116.getPropType() != 4) goto L27;
        if (r116.getBanner() == null) goto L27;
        wh6.b r117 = ((wh6.a) vh6.c.b(wh6.a.class)).getCurrentLocation();
        if (r117 == null) goto L18;
        String r118 = r117.f559701a;
    L19:
        TextUtils.isEmpty(r118);
        if (this.f125850e == true) goto L32;
        this.f125850e = true;
        tz0.b r119 = tz0.b.f548039a;
        uz0.c r120 = new uz0.c();
        r119.getClass();
        Intrinsics.checkNotNullParameter(r120, "$this$beforeConfigureRequest");
        if (r118 != null) goto L25;
        String r121 = "";
    L26:
        r120.query("city_code", r121);
        r120.a(qx0.a.f535099a);
        Intrinsics.checkNotNullParameter(r120, "$this$afterConfigureRequest");
        ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/anchor/popular/status/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.rank.model.e.class)), Extra.class, r120.f552163d, r120.f552160a, r120.f552161b, r120.f552162c).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new b(this, r100, r116, r118), new c(this, r100, r116, r118));
        return true;
    L25:
        r121 = r118;
        goto L26
    L32:
        return true;
    L18:
        r118 = null;
        goto L19
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L27:
        return false;
    }
}
