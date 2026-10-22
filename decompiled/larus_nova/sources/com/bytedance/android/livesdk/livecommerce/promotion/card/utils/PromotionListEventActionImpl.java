package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionBottomBanner;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class PromotionListEventActionImpl implements com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.e f150205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final il.a f150206b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImpl f150207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f150209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f150210d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f150211e;

        public a(PromotionListEventActionImpl r100, com.bytedance.android.ec.common.api.jump.model.g r101, boolean r102, String r103, String r104) {
            this.f150207a = r100;
            this.f150208b = r101;
            this.f150209c = r102;
            this.f150210d = r103;
            this.f150211e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PromotionListEventActionImpl.g(this.f150207a, this.f150208b, this.f150209c, this.f150210d, this.f150211e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImpl f150212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150213b;

        public b(PromotionListEventActionImpl r100, com.bytedance.android.ec.common.api.jump.model.g r101) {
            this.f150212a = r100;
            this.f150213b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f150212a.l(this.f150213b, "add_to_cart");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImpl f150214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f150216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f150217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f150218e;

        public c(PromotionListEventActionImpl r100, com.bytedance.android.ec.common.api.jump.model.g r101, boolean r102, String r103, String r104) {
            this.f150214a = r100;
            this.f150215b = r101;
            this.f150216c = r102;
            this.f150217d = r103;
            this.f150218e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PromotionListEventActionImpl.g(this.f150214a, this.f150215b, this.f150216c, this.f150217d, this.f150218e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImpl f150219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotion f150220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150221c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f150222d;

        public d(PromotionListEventActionImpl r100, ECUIPromotion r101, com.bytedance.android.ec.common.api.jump.model.g r102, String r103) {
            this.f150219a = r100;
            this.f150220b = r101;
            this.f150221c = r102;
            this.f150222d = r103;
        }

        public final void a() {
            StringBuilder r100 = new StringBuilder("livesdk_");
            ECPromotionBottomBanner r101 = this.f150220b.bottomBanner;
            Map<String, String> r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.getTrackName();
        L6:
            if (r103 != null) goto L8;
            r103 = "";
        L8:
            r100.append(r103);
            r100.append("_click");
            sg2.v r104 = new sg2.v(r100.toString(), this.f150221c);
            r104.c("product_id", this.f150220b.getProductId());
            ECPromotionBottomBanner r105 = this.f150220b.bottomBanner;
            if (r105 == null) goto L11;
            r102 = r105.getTrackParam();
        L11:
            r104.d(r102);
            PromotionListEventActionImplKt.a(r104, this.f150219a.f150205a, this.f150222d);
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImpl f150224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotion f150225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f150227d;

        public e(PromotionListEventActionImpl r100, ECUIPromotion r101, com.bytedance.android.ec.common.api.jump.model.g r102, String r103) {
            this.f150224a = r100;
            this.f150225b = r101;
            this.f150226c = r102;
            this.f150227d = r103;
        }

        public final void a() {
            StringBuilder r100 = new StringBuilder("livesdk_");
            ECPromotionBottomBanner r101 = this.f150225b.bottomBanner;
            Map<String, String> r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.getTrackName();
        L6:
            if (r103 != null) goto L8;
            r103 = "";
        L8:
            r100.append(r103);
            r100.append("_show");
            sg2.v r104 = new sg2.v(r100.toString(), this.f150226c);
            r104.c("product_id", this.f150225b.getProductId());
            ECPromotionBottomBanner r105 = this.f150225b.bottomBanner;
            if (r105 == null) goto L11;
            r102 = r105.getTrackParam();
        L11:
            r104.d(r102);
            PromotionListEventActionImplKt.a(r104, this.f150224a.f150205a, this.f150227d);
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImpl f150228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f150230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f150231d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f150232e;

        public f(PromotionListEventActionImpl r100, com.bytedance.android.ec.common.api.jump.model.g r101, String r102, boolean r103, String r104) {
            this.f150228a = r100;
            this.f150229b = r101;
            this.f150230c = r102;
            this.f150231d = r103;
            this.f150232e = r104;
        }

        public final void a() {
            com.bytedance.android.ec.common.api.jump.model.g r100 = this.f150229b;
            ql.a r101 = r100.f42873a;
            sg2.v r102 = new sg2.v(this.f150230c, r100);
            sl.q r103 = r101.getClientData().f533696e;
            if (r103 == null) goto L5;
            Map<String, String> r104 = r103.b();
        L6:
            r102.d(r104);
            if (this.f150231d == false) goto L9;
            String r105 = "user";
        L10:
            r102.c("close_type", r105);
            PromotionListEventActionImplKt.a(r102, this.f150228a.f150205a, this.f150232e);
            return;
        L9:
            r105 = "auto";
            goto L10
        L5:
            r104 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImpl f150233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotion f150235c;

        public g(PromotionListEventActionImpl r100, com.bytedance.android.ec.common.api.jump.model.g r101, ECUIPromotion r102) {
            this.f150233a = r100;
            this.f150234b = r101;
            this.f150235c = r102;
        }

        public final void a() {
            sg2.v r100 = new sg2.v("livesdk_show_have_seen_label", this.f150234b);
            r100.c("product_id", this.f150235c.getProductId());
            ECPromotion.FlickerIcon r101 = this.f150235c.flickerIconV2;
            if (r101 == null) goto L5;
            String r102 = r101.eventTag;
        L6:
            r100.c("tag_name", r102);
            PromotionListEventActionImplKt.a(r100, this.f150233a.f150205a, null);
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotion f150236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f150237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImpl f150238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150239d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f150240e;

        public h(ECUIPromotion r100, Map r101, PromotionListEventActionImpl r102, com.bytedance.android.ec.common.api.jump.model.g r103, String r104) {
            this.f150236a = r100;
            this.f150237b = r101;
            this.f150238c = r102;
            this.f150239d = r103;
            this.f150240e = r104;
        }

        public final void a() {
            com.bytedance.android.ec.common.api.jump.model.a r100 = this.f150239d;
            if (r100 != null) goto L5;
            r100 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
        L5:
            sg2.v r101 = new sg2.v("livesdk_show_product_info", r100);
            ECUIPromotion r102 = this.f150236a;
            if (r102 == null) goto L8;
            String r103 = r102.getProductId();
        L9:
            r101.c("product_id", r103);
            ECUIPromotion r104 = this.f150236a;
            if (r104 == null) goto L22;
            r101.d(r104.getEventParams());
            r101.c("product_id", r104.getProductId());
            if (r104.isOnExplain() == false) goto L14;
            String r105 = "1";
        L15:
            r101.c("is_explaining", r105);
            int r106 = 1;
            r101.a(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, !r104.getSingleSku() ? 1 : 0);
            r101.a("local_num", r104.getLocalNum());
            ECUIAskExplainInfo r107 = r104.getAskExplainInfo();
            if (r107 != null) goto L18;
        L20:
            r106 = 0;
        L21:
            r101.a(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r106);
            goto L22
        L18:
            if (r107.isAsked() != true) goto L20;
        L14:
            r105 = "0";
        L22:
            r101.d(this.f150237b);
            PromotionListEventActionImplKt.a(r101, this.f150238c.f150205a, this.f150240e);
            return;
        L8:
            r103 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImpl f150241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveRoomParams f150243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f150244d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f150245e;

        public i(PromotionListEventActionImpl r100, com.bytedance.android.ec.common.api.jump.model.g r101, LiveRoomParams r102, Map r103, String r104) {
            this.f150241a = r100;
            this.f150242b = r101;
            this.f150243c = r102;
            this.f150244d = r103;
            this.f150245e = r104;
        }

        public final void a() {
            sg2.v r100 = new sg2.v("livesdk_show_store_info", this.f150242b);
            LiveRoomParams r101 = this.f150243c;
            String r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.getAuthorId();
        L6:
            r100.c("live_anchor_id", r103);
            r100.c(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "live_product_card");
            r100.c(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
            LiveRoomParams r104 = this.f150243c;
            if (r104 == null) goto L9;
            String r105 = r104.getEnterFromMerge();
        L10:
            r100.c(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r105);
            LiveRoomParams r106 = this.f150243c;
            if (r106 == null) goto L13;
            r102 = r106.getEnterMethod();
        L13:
            r100.c(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r102);
            r100.c(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, "live");
            r100.d(this.f150244d);
            PromotionListEventActionImplKt.a(r100, this.f150241a.f150205a, this.f150245e);
            return;
        L9:
            r105 = null;
            goto L10
        L5:
            r103 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void j(final com.bytedance.android.ec.common.api.jump.model.g r100) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        final ql.a r101 = r100.f42873a;
        this.f150206b.c("livesdk_show_invalid_product", r101.getPromotionId(), new PromotionListEventActionImpl$doShowFindSimilarEvent$1(this, r100, r101));
    }

    public final void k(com.bytedance.android.ec.common.api.jump.model.g r100) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        ql.a r101 = r100.f42873a;
        if (r101 == null) goto L7;
        oh.a.c("doShowHaveSeenLabelEvent", new g(this, r100, (ECUIPromotion) r101));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }

    public PromotionListEventActionImpl(com.bytedance.android.livesdk.livecommerce.promotion.card.e r100, il.a r101) {
        Intrinsics.checkNotNullParameter(r101, "eventMap");
        this.f150205a = r100;
        this.f150206b = r101;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void b(com.bytedance.android.ec.common.api.jump.model.g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        oh.a.c("ECExplainReplayEntranceEvent", new p(this, r100, "livesdk_explain_replay_entrance_show", r101));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void c(com.bytedance.android.ec.common.api.jump.model.g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        oh.a.c("ECExplainReplayEntranceEvent", new p(this, r100, "livesdk_explain_replay_entrance_click", r101));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void d(com.bytedance.android.ec.common.api.jump.model.g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        ql.a r102 = r100.f42873a;
        if (r102 == null) goto L7;
        oh.a.c("ExplainStatusClickEvent", new d(this, (ECUIPromotion) r102, r100, r101));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void e(com.bytedance.android.ec.common.api.jump.model.g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        ql.a r102 = r100.f42873a;
        if (r102 == null) goto L7;
        oh.a.c("ExplainStatusShowEvent", new e(this, (ECUIPromotion) r102, r100, r101));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }

    public final void l(com.bytedance.android.ec.common.api.jump.model.g r100, String r101) {
        LiveRoomParams r102 = (LiveRoomParams) r100.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        ql.a r103 = r100.f42873a;
        if (r103 == null) goto L59;
        ECUIPromotion r104 = (ECUIPromotion) r103;
        boolean r105 = EntryController.M1;
        String r106 = null;
        if (r102 == null) goto L7;
        String r107 = r102.getRoomId();
    L8:
        if (r102 == null) goto L10;
        String r108 = r102.getRoomUniqueKey();
    L11:
        ak2.m r109 = EntryController.a.b(r107, r108).F;
        if (r109 == null) goto L62;
        JSONObject r110 = new JSONObject();
        r110.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r104.getShopId());     // Catch: Exception -> L54
        r110.put("product_id", r104.getProductId());     // Catch: Exception -> L54
        r110.put("promotion_id", r104.getPromotionId());     // Catch: Exception -> L54
        if (r102 == null) goto L18;
        String r111 = r102.getAuthorId();     // Catch: Exception -> L54
    L19:
        String r112 = "";
        if (r111 != null) goto L22;
        r111 = "";
    L22:
        r110.put("anchor_id", r111);     // Catch: Exception -> L54
        if (hh2.f.e() == false) goto L32;
        if (r102 == null) goto L27;
        String r113 = r102.getAuthorId();     // Catch: Exception -> L54
    L28:
        if (r113 != null) goto L30;
        r113 = "";
    L30:
        r110.put("anchor_open_id", r113);     // Catch: Exception -> L54
        goto L32
    L27:
        r113 = null;
    L32:
        if (r102 == null) goto L34;
        String r114 = r102.getRoomId();     // Catch: Exception -> L54
    L35:
        if (r114 == null) goto L38;
        r112 = r114;
    L38:
        r110.put("room_id", r112);     // Catch: Exception -> L54
        r110.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r104.getPromotionId());     // Catch: Exception -> L54
        String r115 = r104.getEventItemType();     // Catch: Exception -> L54
        if (r115 != null) goto L41;
        r115 = "-1";
    L41:
        r110.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r115);     // Catch: Exception -> L54
        r110.put("commodity_price", (int) (CastFloatProtector.parseFloat(r104.price) * 100));     // Catch: Exception -> L54
        if (r102 == null) goto L44;
        String r116 = r102.getActionType();     // Catch: Exception -> L54
    L45:
        r110.put("action_type", r116);     // Catch: Exception -> L54
        if (r102 == null) goto L48;
        String r117 = r102.getEnterFromMerge();     // Catch: Exception -> L54
    L49:
        r110.put("enter_from_merge", r117);     // Catch: Exception -> L54
        if (r102 == null) goto L52;
        r106 = r102.getEnterMethod();     // Catch: Exception -> L54
    L52:
        r110.put("enter_method", r106);     // Catch: Exception -> L54
    L56:
        r109.onClickPromotion("live_ad", r101, "live", r110);
        return;
    L48:
        r117 = null;
        goto L49
    L44:
        r116 = null;
        goto L45
    L34:
        r114 = null;
        goto L35
    L18:
        r111 = null;
    L54:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L56
    L62:
        return;
    L10:
        r108 = null;
        goto L11
    L7:
        r107 = null;
        goto L8
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void a(Map<String, String> r100, com.bytedance.android.ec.common.api.jump.model.g r110, String r111) {
        if (r100 == null) goto L14;
        ql.a r101 = null;
        if ((!r100.isEmpty()) == false) goto L6;
        Map<String, String> r102 = r100;
    L7:
        if (r102 == null) goto L15;
        if (r110 == null) goto L10;
        r101 = r110.f42873a;
    L10:
        if (r101 == null) goto L13;
        oh.a.c("livesdk_show_product_info", new h((ECUIPromotion) r101, r102, this, r110, r111));
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    L15:
        return;
    L6:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void f(Map<String, String> r100, com.bytedance.android.ec.common.api.jump.model.g r101, String r110) {
        Intrinsics.checkNotNullParameter(r101, "promotionParams");
        oh.a.c("livesdk_show_store_entrance", new i(this, r101, (LiveRoomParams) r101.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class)), r100, r110));
    }

    public final void h(com.bytedance.android.ec.common.api.jump.model.g r100, boolean r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        if (r110 == false) goto L5;
        oh.a.c("ECAddShopCartEvent", new a(this, r100, r110, r111, r112));
        oh.a.c("doClickAddCartForDouPlus", new b(this, r100));
        return;
    L5:
        oh.a.c("ECAddShopCartEvent", new c(this, r100, r110, r111, r112));
    }

    public final void i(boolean r100, com.bytedance.android.ec.common.api.jump.model.g r101, boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "promotionParams");
        if (r100 == false) goto L5;
        String r102 = "livesdk_close_product_long_press_guide";
    L6:
        oh.a.c(r102, new f(this, r101, r102, r110, r111));
        return;
    L5:
        r102 = "livesdk_show_product_long_press_guide";
        goto L6
    }

    public static final void g(PromotionListEventActionImpl r100, com.bytedance.android.ec.common.api.jump.model.g r101, boolean r102, String r103, String r110) {
        r100.getClass();
        ql.a r104 = r101.f42873a;
        if (r104 == null) goto L51;
        ECUIPromotion r105 = (ECUIPromotion) r104;
        if (r105.canShowAddCart() == false) goto L55;
        int r106 = 0;
        int r107 = 1;
        if (r105.shouldShowStepper() == false) goto L15;
        com.bytedance.android.ec.model.response.v r108 = r105.stepperInfo;
        if (r108 != null) goto L12;
    L20:
        r107 = 0;
    L21:
        com.bytedance.android.ec.common.api.jump.model.f r109 = (com.bytedance.android.ec.common.api.jump.model.f) r101.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r102 == false) goto L24;
        String r111 = "livesdk_click_add_to_cart";
    L25:
        sg2.v r112 = new sg2.v(r111, r101);
        r112.c(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "live_list_card");
        if (r105.shouldShowStepper() == false) goto L28;
        String r113 = "edit";
    L29:
        r112.c("display_type", r113);
        com.bytedance.android.ec.model.response.v r114 = r105.stepperInfo;
        if (r114 == null) goto L32;
        r106 = r114.b();
    L32:
        r112.a("cart_num", r106);
        r112.a("add_display_status", r107);
        r112.c("cart_track", new JSONObject(r105.getTrackExtra()).optString("cart_track"));     // Catch: Exception -> L35
    L37:
        r112.c("ecom_pitaya_json_str", com.bytedance.android.livesdk.livecommerce.event.r.a(r105));
        r112.c("btm_id", r110);
        if (r109 == null) goto L48;
        String r115 = r109.f42860b;
        if (r115 == null) goto L48;
        Map<String, Object> r116 = EcomBcmTracker.f(PageFinder.via(r115), r112.g());
        if (r116 == null) goto L48;
        LinkedHashMap r117 = new LinkedHashMap(MapsKt.mapCapacity(r116.size()));
        Iterator<T> r118 = r116.entrySet().iterator();
    L45:
        if (r118.hasNext() == false) goto L47;
        Map.Entry r119 = (Map.Entry) r118.next();
        r117.put(r119.getKey(), String.valueOf(r119.getValue()));
        goto L45
    L47:
        r112.d(r117);
    L48:
        PromotionListEventActionImplKt.a(r112, r100.f150205a, r103);
        return;
    L35:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L37
    L28:
        r113 = "normal";
        goto L29
    L24:
        r111 = "livesdk_show_add_to_cart";
        goto L25
    L12:
        if (r108.c() != true) goto L20;
    L15:
        if (r105.getCanAddShopCart() == false) goto L21;
        if (r105.isOnSale() == false) goto L21;
        if (r105.isFlash() == true) goto L21;
    L55:
        return;
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }
}
