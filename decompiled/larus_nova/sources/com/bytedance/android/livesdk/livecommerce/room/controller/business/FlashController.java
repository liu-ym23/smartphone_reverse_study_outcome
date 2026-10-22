package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.network.response.ECFlashResponse;
import com.bytedance.android.livesdk.livecommerce.oldflash.LiveFlashNewFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.utils.f0;
import com.bytedance.android.livesdk.livecommerce.utils.g0;
import com.bytedance.android.livesdk.livecommerce.utils.k0;
import com.bytedance.android.livesdk.livecommerce.utils.l0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class FlashController extends c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f151527f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f151528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveFlashNewFragment f151529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f151530e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f151531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f151532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f151533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f151534d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f151535e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f151536f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map<String, ? extends List<String>> f151537g;

        public b() {
        }
    }

    static {
    }

    public FlashController(RealRoomController$roomResources$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "roomResources");
        super(r100);
    }

    public final void K(ECFlashResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "ecFlashResponse");
        this.f151528c = r100.isOpen();
        b r101 = new b();
        this.f151530e = r101;
        if (r100.getHasAuth() == 0) goto L5;
        boolean r102 = true;
    L6:
        r101.f151536f = r102;
        r101.f151533c = r100.getShopId();
        r101.f151537g = r100.getProperties_adapt_multi();
        r101.f151535e = r100.getIds();
        r101.f151534d = r100.getNames();
        r101.f151531a = r100.isNeedBarCode();
        r101.f151532b = r100.getLastBarCodeState();
        r101.f151537g = r100.getProperties_adapt_multi();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void H(Context r100, Function2<? super String, ? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "cb");
        int r102 = g0.f153082a;
        if (r100 != null) goto L5;
        r100 = m();
    L5:
        com.bytedance.android.livesdk.livecommerce.room.api.c r103 = q();
        Intrinsics.checkNotNullParameter(r101, "cb");
        if (r100 != null) goto L8;
        r101.invoke(null, "no context");
        return;
    L8:
        if (r103 == null) goto L10;
        r103.i(new f0(r100, r101));
        return;
    L10:
        r101.invoke(null, "no liveRoomProvider");
    }

    public final DialogFragment I(Context r110, Bundle r111, Long r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        b r100 = this.f151530e;
        if (r100 == null) goto L9;
        if ((r110 instanceof FragmentActivity) == false) goto L9;
        int r101 = com.bytedance.android.livesdk.livecommerce.oldflash.r.f149645a;
        LiveFlashNewFragment r113 = com.bytedance.android.livesdk.livecommerce.oldflash.r.a(r110, y(), z(), B(), new FlashController$showFlashPanel$1$localFlash$1(this), r100, this, r111, r112);
        this.f151529d = r113;
        return r113;
    L9:
        return new DialogFragment();
    }

    public final void J(final Context r100, final Bundle r101, final Long r110, final Function1<? super DialogFragment, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        si2.i r102 = com.bytedance.android.livesdk.livecommerce.oldflash.s.f149646s;
        ECLiveABUtils r103 = ECLiveABUtils.INSTANCE;
        if (r103.getEC_LIVE_USE_NEW_ANCHOR_FLASH_SALE().booleanValue() == false) goto L41;
        dm.a.a("FlashController").a("openNewFlashPanel");
        if (r100 != null) goto L8;
        return;
    L8:
        if (r101 == null) goto L11;
        String r104 = r101.getString("enter_from", "sg_nickname");
        if (r104 == null) goto L11;
    L12:
        boolean r112 = Intrinsics.areEqual(r104, "sg_nickname");
        String r105 = "";
        if (r101 == null) goto L16;
        String r106 = r101.getString("target_id", "");
        if (r106 == null) goto L16;
    L17:
        UrlBuilderV2 r107 = new UrlBuilderV2(r103.getEC_LIVE_ANCHOR_FLASH_PURCHASE_PUBLISH_URL());
        r107.addOrReplaceParam("enter_from", r104);
        r107.addOrReplaceParam("room_id", B());
        r107.addOrReplaceParam("room_unique_key", D());
        r107.addOrReplaceParam("anchor_id", y());
        b r113 = this.f151530e;
        if (r113 == null) goto L21;
        String r114 = r113.f151533c;
        if (r114 == null) goto L21;
    L22:
        r107.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r114);
        r107.addOrReplaceParam("target_uid", r106);
        ECAppInfoService r108 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L25;
        String r115 = "7386";
    L26:
        r107.addOrReplaceParam("ecom_appid", r115);
        String r109 = r108.e();
        if (r109 == null) goto L30;
        r105 = r109;
    L30:
        r107.addOrReplaceParam("host_app_id", r105);
        r107.addOrReplaceParam("ecom_sdk_version", String.valueOf(44700));
        com.bytedance.android.livesdk.livecommerce.utils.k.h(1);
        com.bytedance.android.livesdk.livecommerce.room.f.b(r100, r107.build());
        LiveRoomParams r116 = l();
        if (r116 == null) goto L43;
        sg2.v r117 = new sg2.v("livesdk_click_button", r116);
        if (r112 == false) goto L35;
        String r118 = "定向闪购";
    L36:
        r117.c("button_for", r118);
        if (r112 == false) goto L39;
        String r119 = "user_detail";
    L40:
        r117.c("page_name", r119);
        r117.c("entrance_name", "flash_buy");
        r117.i(null);
        return;
    L39:
        r119 = "live_stream";
        goto L40
    L35:
        r118 = "全量闪购";
        goto L36
    L43:
        return;
    L25:
        r115 = "";
    L21:
        r114 = "";
    L16:
        r106 = "";
    L11:
        r104 = "sg_nickname";
        goto L12
    L41:
        int r120 = l0.f153097a;
        Function0<Unit> r121 = new FlashController$tryShowLiveFlashFragment$1(this, r100, r101, r110, r111);
        Intrinsics.checkNotNullParameter(r121, "goShowFlashPanel");
        CoreRequests.d(new k0(r100, SystemClock.elapsedRealtime(), r121));
    }
}
