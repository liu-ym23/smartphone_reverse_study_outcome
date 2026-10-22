package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.a1;
import com.bytedance.android.ec.model.response.g1;
import com.bytedance.android.ec.model.response.k1;
import com.bytedance.android.ec.model.response.m1;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.v0;
import com.bytedance.android.ec.model.response.y0;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.livesdk.livecommerce.event.d2;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class PromotionListEventActionImplV2 implements com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.e f150250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final il.a f150251b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImplV2 f150252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f150254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f150255d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f150256e;

        public a(PromotionListEventActionImplV2 r100, com.bytedance.android.ec.common.api.jump.model.g r101, boolean r102, String r103, String r104) {
            this.f150252a = r100;
            this.f150253b = r101;
            this.f150254c = r102;
            this.f150255d = r103;
            this.f150256e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PromotionListEventActionImplV2.g(this.f150252a, this.f150253b, this.f150254c, this.f150255d, this.f150256e);     // Catch: Throwable -> L4
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
        public final /* synthetic */ PromotionListEventActionImplV2 f150257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150258b;

        public b(PromotionListEventActionImplV2 r100, com.bytedance.android.ec.common.api.jump.model.g r101) {
            this.f150257a = r100;
            this.f150258b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f150257a.o(this.f150258b, "add_to_cart");     // Catch: Throwable -> L4
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
        public final /* synthetic */ PromotionListEventActionImplV2 f150259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f150261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f150262d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f150263e;

        public c(PromotionListEventActionImplV2 r100, com.bytedance.android.ec.common.api.jump.model.g r101, boolean r102, String r103, String r104) {
            this.f150259a = r100;
            this.f150260b = r101;
            this.f150261c = r102;
            this.f150262d = r103;
            this.f150263e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PromotionListEventActionImplV2.g(this.f150259a, this.f150260b, this.f150261c, this.f150262d, this.f150263e);     // Catch: Throwable -> L4
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
        public final /* synthetic */ PromotionListEventActionImplV2 f150264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f150265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotionV2 f150267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f150268e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f150269f;

        public d(PromotionListEventActionImplV2 r100, String r101, com.bytedance.android.ec.common.api.jump.model.g r102, ECUIPromotionV2 r103, Map r104, String r105) {
            this.f150264a = r100;
            this.f150265b = r101;
            this.f150266c = r102;
            this.f150267d = r103;
            this.f150268e = r104;
            this.f150269f = r105;
        }

        public final void a() {
            sg2.v r100 = new sg2.v("livesdk_" + this.f150265b + "_click", this.f150266c);
            r100.c("product_id", this.f150267d.getProductId());
            r100.d(this.f150268e);
            PromotionListEventActionImplKt.a(r100, this.f150264a.f150250a, this.f150269f);
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
        public final /* synthetic */ PromotionListEventActionImplV2 f150274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotionV2 f150275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150276c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f150277d;

        public e(PromotionListEventActionImplV2 r100, ECUIPromotionV2 r101, com.bytedance.android.ec.common.api.jump.model.g r102, String r103) {
            this.f150274a = r100;
            this.f150275b = r101;
            this.f150276c = r102;
            this.f150277d = r103;
        }

        public final void a() {
            z0 r100 = this.f150275b.getImage();
            Map<String, String> r101 = null;
            if (r100 == null) goto L9;
            a1 r102 = r100.c();
            if (r102 == null) goto L9;
            s1 r103 = r102.g();
            if (r103 == null) goto L9;
            String r104 = r103.c();
        L10:
            if (r104 != null) goto L12;
            r104 = "";
        L12:
            z0 r105 = this.f150275b.getImage();
            if (r105 == null) goto L19;
            a1 r106 = r105.c();
            if (r106 == null) goto L19;
            s1 r107 = r106.g();
            if (r107 == null) goto L19;
            r101 = r107.d();
        L19:
            sg2.v r108 = new sg2.v("livesdk_" + r104 + "_show", this.f150276c);
            r108.c("product_id", this.f150275b.getProductId());
            r108.d(r101);
            PromotionListEventActionImplKt.a(r108, this.f150274a.f150250a, this.f150277d);
            return;
        L9:
            r104 = null;
            goto L10
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
        public final /* synthetic */ PromotionListEventActionImplV2 f150278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f150280c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f150281d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f150282e;

        public f(PromotionListEventActionImplV2 r100, com.bytedance.android.ec.common.api.jump.model.g r101, String r102, boolean r103, String r104) {
            this.f150278a = r100;
            this.f150279b = r101;
            this.f150280c = r102;
            this.f150281d = r103;
            this.f150282e = r104;
        }

        public final void a() {
            com.bytedance.android.ec.common.api.jump.model.g r100 = this.f150279b;
            ql.a r101 = r100.f42873a;
            sg2.v r102 = new sg2.v(this.f150280c, r100);
            sl.q r103 = r101.getClientData().f533696e;
            if (r103 == null) goto L5;
            Map<String, String> r104 = r103.b();
        L6:
            r102.d(r104);
            if (this.f150281d == false) goto L9;
            String r105 = "user";
        L10:
            r102.c("close_type", r105);
            PromotionListEventActionImplKt.a(r102, this.f150278a.f150250a, this.f150282e);
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
        public final /* synthetic */ PromotionListEventActionImplV2 f150283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotionV2 f150285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f150286d;

        public g(PromotionListEventActionImplV2 r100, com.bytedance.android.ec.common.api.jump.model.g r101, ECUIPromotionV2 r102, Ref.ObjectRef r103) {
            this.f150283a = r100;
            this.f150284b = r101;
            this.f150285c = r102;
            this.f150286d = r103;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            sg2.v r100 = new sg2.v("livesdk_show_have_seen_label", this.f150284b);
            r100.c("product_id", this.f150285c.getProductId());
            r100.c("tag_name", (String) this.f150286d.element);
            PromotionListEventActionImplKt.a(r100, this.f150283a.f150250a, null);
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
        public final /* synthetic */ ql.a f150287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f150288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PromotionListEventActionImplV2 f150289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150290d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f150291e;

        public h(ql.a r100, Map r101, PromotionListEventActionImplV2 r102, com.bytedance.android.ec.common.api.jump.model.g r103, String r104) {
            this.f150287a = r100;
            this.f150288b = r101;
            this.f150289c = r102;
            this.f150290d = r103;
            this.f150291e = r104;
        }

        public final void a() {
            com.bytedance.android.ec.common.api.jump.model.a r100 = this.f150290d;
            if (r100 != null) goto L5;
            r100 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
        L5:
            sg2.v r101 = new sg2.v("livesdk_show_product_info", r100);
            ql.a r102 = this.f150287a;
            if (r102 == null) goto L8;
            String r103 = r102.getProductId();
        L9:
            r101.c("product_id", r103);
            ql.a r104 = this.f150287a;
            if (r104 == null) goto L22;
            r101.d(r104.getEventParams());
            r101.c("product_id", r104.getProductId());
            if (r104.isOnExplaining() == false) goto L14;
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
            r101.d(this.f150288b);
            PromotionListEventActionImplKt.a(r101, this.f150289c.f150250a, this.f150291e);
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
        public final /* synthetic */ PromotionListEventActionImplV2 f150292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveRoomParams f150294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f150295d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f150296e;

        public i(PromotionListEventActionImplV2 r100, com.bytedance.android.ec.common.api.jump.model.g r101, LiveRoomParams r102, Map r103, String r104) {
            this.f150292a = r100;
            this.f150293b = r101;
            this.f150294c = r102;
            this.f150295d = r103;
            this.f150296e = r104;
        }

        public final void a() {
            sg2.v r100 = new sg2.v("livesdk_show_store_info", this.f150293b);
            LiveRoomParams r101 = this.f150294c;
            String r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.getAuthorId();
        L6:
            r100.c("live_anchor_id", r103);
            r100.c(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "live_product_card");
            r100.c(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
            LiveRoomParams r104 = this.f150294c;
            if (r104 == null) goto L9;
            String r105 = r104.getEnterFromMerge();
        L10:
            r100.c(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r105);
            LiveRoomParams r106 = this.f150294c;
            if (r106 == null) goto L13;
            r102 = r106.getEnterMethod();
        L13:
            r100.c(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r102);
            r100.c(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, "live");
            r100.d(this.f150295d);
            PromotionListEventActionImplKt.a(r100, this.f150292a.f150250a, this.f150296e);
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

    public final void l(final com.bytedance.android.ec.common.api.jump.model.g r110) {
        Intrinsics.checkNotNullParameter(r110, "promotionParams");
        ql.a r100 = r110.f42873a;
        if (r100 == null) goto L19;
        final ECUIPromotionV2 r101 = (ECUIPromotionV2) r100;
        g1 r102 = r101.getPurchase();
        Map<String, String> r103 = null;
        if (r102 == null) goto L9;
        m1 r104 = r102.b();
        if (r104 == null) goto L9;
        s1 r105 = r104.e();
    L10:
        if (r105 == null) goto L12;
        r103 = r105.d();
    L12:
        final Map<String, String> r106 = r103;
        if (r105 == null) goto L20;
        final String r107 = r105.c();
        if (r107 == null) goto L21;
        this.f150251b.c(r107, r101.getPromotionId(), new PromotionListEventActionImplV2$doShowFindSimilarEvent$$inlined$also$lambda$1(r107, this, r101, r110, r106));
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r105 = null;
        goto L10
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.String] */
    public final void m(com.bytedance.android.ec.common.api.jump.model.g r100) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        ql.a r101 = r100.f42873a;
        if (r101 == null) goto L17;
        ECUIPromotionV2 r102 = (ECUIPromotionV2) r101;
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = null;
        z0 r104 = r102.getImage();
        if (r104 == null) goto L14;
        List<y0> r105 = r104.g();
        if (r105 == null) goto L14;
        Iterator<T> r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L14;
        ?? r107 = ((y0) r106.next()).d();
        if (r107 == 0) goto L10;
        r103.element = r107;
    L14:
        oh.a.c("doShowHaveSeenLabelEvent", new g(this, r100, r102, r103));
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    public final void n(final com.bytedance.android.ec.common.api.jump.model.g r100) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        ql.a r101 = r100.f42873a;
        String r102 = null;
        if ((r101 instanceof ECUIPromotionV2) == true) goto L5;
        r101 = null;
    L5:
        final ECUIPromotionV2 r103 = (ECUIPromotionV2) r101;
        if (r103 != null) goto L8;
        return;
    L8:
        v0 r104 = r103.getExtend();
        if (r104 != null) goto L11;
        return;
    L11:
        if (r104.c() == null) goto L37;
        v0 r105 = r103.getExtend();
        if (r105 == null) goto L18;
        s1 r106 = r105.j();
        if (r106 == null) goto L18;
        r102 = r106.c();
    L18:
        boolean r107 = true;
        if (r102 != null) goto L21;
    L24:
        boolean r108 = true;
    L25:
        if (r108 == true) goto L27;
        final String r109 = "livesdk_show_" + r102;
    L28:
        final String r110 = "livesdk_show_list_product_bottom";
        this.f150251b.c("livesdk_show_list_product_bottom", r103.getPromotionId(), new PromotionListEventActionImplV2$doShowListProductBottom$1(this, r110, r100, r103));
        if (r109.length() > 0) goto L32;
        r107 = false;
    L32:
        if (r107 == false) goto L36;
        this.f150251b.c(r109, r103.getPromotionId(), new PromotionListEventActionImplV2$doShowListProductBottom$2(this, r109, r100, r103));
        return;
    L36:
        return;
    L27:
        r109 = "";
        goto L28
    L21:
        if (r102.length() == 0) goto L24;
        r108 = false;
        goto L25
    }

    public PromotionListEventActionImplV2(com.bytedance.android.livesdk.livecommerce.promotion.card.e r100, il.a r101) {
        Intrinsics.checkNotNullParameter(r101, "eventMap");
        this.f150250a = r100;
        this.f150251b = r101;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void b(com.bytedance.android.ec.common.api.jump.model.g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        oh.a.c("ECExplainReplayEntranceEvent", new z(this, r100, "show", r101));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void c(com.bytedance.android.ec.common.api.jump.model.g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        oh.a.c("ECExplainReplayEntranceEvent", new z(this, r100, "click", r101));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void d(com.bytedance.android.ec.common.api.jump.model.g r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        ql.a r101 = r100.f42873a;
        if (r101 == null) goto L25;
        ECUIPromotionV2 r102 = (ECUIPromotionV2) r101;
        z0 r103 = r102.getImage();
        if (r103 == null) goto L11;
        a1 r104 = r103.c();
        if (r104 == null) goto L11;
        s1 r105 = r104.g();
        if (r105 == null) goto L11;
        String r106 = r105.c();
    L12:
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        String r107 = r106;
        z0 r108 = r102.getImage();
        if (r108 == null) goto L21;
        a1 r109 = r108.c();
        if (r109 == null) goto L21;
        s1 r111 = r109.g();
        if (r111 == null) goto L21;
        Map<String, String> r112 = r111.d();
    L22:
        oh.a.c("ExplainStatusClickEvent", new d(this, r107, r100, r102, r112, r110));
        return;
    L21:
        r112 = null;
    L11:
        r106 = null;
        goto L12
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void e(com.bytedance.android.ec.common.api.jump.model.g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        ql.a r102 = r100.f42873a;
        if (r102 == null) goto L7;
        oh.a.c("ExplainStatusShowEvent", new e(this, (ECUIPromotionV2) r102, r100, r101));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    public final Map i(com.bytedance.android.ec.common.api.jump.model.g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionParams");
        ql.a r102 = r100.f42873a;
        if (r102 == null) goto L41;
        ECUIPromotionV2 r103 = (ECUIPromotionV2) r102;
        LiveRoomParams r104 = (LiveRoomParams) r100.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r105 = (com.bytedance.android.ec.common.api.jump.model.f) r100.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        k1 r106 = r103.getTrack();
        String r107 = null;
        if (r106 == null) goto L9;
        s1 r108 = r106.c();
        if (r108 == null) goto L9;
        String r109 = r108.c();
    L10:
        if (r109 != null) goto L13;
        r109 = "";
    L13:
        if (Intrinsics.areEqual(r109, "livesdk_show_product") == false) goto L20;
        sg2.v r110 = new sg2.v(r109, r100);
        Pair r111 = d2.a(r103);
        List r112 = (List) r111.component1();
        List r113 = (List) r111.component2();
        if ((!r112.isEmpty()) == false) goto L18;
        r110.c("tag_code_list", r112.toString());
    L18:
        if ((!r113.isEmpty()) == false) goto L21;
        r110.c("live_tag_list", r113.toString());
    L21:
        r110.c("bst_tag", "bst_tag");
        int r114 = RoomContextController.f151593h;
        if (r104 == null) goto L24;
        String r115 = r104.getRoomId();
    L25:
        if (r104 == null) goto L27;
        r107 = r104.getRoomUniqueKey();
    L27:
        r110.c("duration", RoomContextController.a.b(r115, r107).I());
        r110.c(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, "live");
        r110.a("ecom_goods_status", r103.getStatus());
        if (r105 == null) goto L38;
        String r116 = r105.f42860b;
        if (r116 == null) goto L38;
        Map<String, Object> r117 = EcomBcmTracker.f(PageFinder.via(r116), r110.g());
        if (r117 == null) goto L38;
        LinkedHashMap r118 = new LinkedHashMap(MapsKt.mapCapacity(r117.size()));
        Iterator<T> r119 = r117.entrySet().iterator();
    L35:
        if (r119.hasNext() == false) goto L37;
        Map.Entry r120 = (Map.Entry) r119.next();
        r118.put(r120.getKey(), String.valueOf(r120.getValue()));
        goto L35
    L37:
        r110.d(r118);
    L38:
        LinkedHashMap r121 = new LinkedHashMap();
        r121.putAll(r110.g());
        return r121;
    L24:
        r115 = null;
        goto L25
    L20:
        r110 = new sg2.v(r109, r100);
    L9:
        r109 = null;
        goto L10
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    public final void o(com.bytedance.android.ec.common.api.jump.model.g r100, String r101) {
        LiveRoomParams r102 = (LiveRoomParams) r100.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        ql.a r103 = r100.f42873a;
        boolean r104 = EntryController.M1;
        String r105 = null;
        if (r102 == null) goto L5;
        String r106 = r102.getRoomId();
    L6:
        if (r102 == null) goto L8;
        String r107 = r102.getRoomUniqueKey();
    L9:
        ak2.m r108 = EntryController.a.b(r106, r107).F;
        if (r108 == null) goto L58;
        JSONObject r109 = new JSONObject();
        r109.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r103.getShopId());     // Catch: Exception -> L52
        r109.put("product_id", r103.getProductId());     // Catch: Exception -> L52
        r109.put("promotion_id", r103.getPromotionId());     // Catch: Exception -> L52
        if (r102 == null) goto L16;
        String r110 = r102.getAuthorId();     // Catch: Exception -> L52
    L17:
        String r111 = "";
        if (r110 != null) goto L20;
        r110 = "";
    L20:
        r109.put("anchor_id", r110);     // Catch: Exception -> L52
        if (hh2.f.e() == false) goto L30;
        if (r102 == null) goto L25;
        String r112 = r102.getAuthorId();     // Catch: Exception -> L52
    L26:
        if (r112 != null) goto L28;
        r112 = "";
    L28:
        r109.put("anchor_open_id", r112);     // Catch: Exception -> L52
        goto L30
    L25:
        r112 = null;
    L30:
        if (r102 == null) goto L32;
        String r113 = r102.getRoomId();     // Catch: Exception -> L52
    L33:
        if (r113 == null) goto L36;
        r111 = r113;
    L36:
        r109.put("room_id", r111);     // Catch: Exception -> L52
        r109.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r103.getPromotionId());     // Catch: Exception -> L52
        String r114 = r103.getEventItemType();     // Catch: Exception -> L52
        if (r114 != null) goto L39;
        r114 = "-1";
    L39:
        r109.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r114);     // Catch: Exception -> L52
        r109.put("commodity_price", (int) (CastFloatProtector.parseFloat(r103.mo8153getPrice()) * 100));     // Catch: Exception -> L52
        if (r102 == null) goto L42;
        String r115 = r102.getActionType();     // Catch: Exception -> L52
    L43:
        r109.put("action_type", r115);     // Catch: Exception -> L52
        if (r102 == null) goto L46;
        String r116 = r102.getEnterFromMerge();     // Catch: Exception -> L52
    L47:
        r109.put("enter_from_merge", r116);     // Catch: Exception -> L52
        if (r102 == null) goto L50;
        r105 = r102.getEnterMethod();     // Catch: Exception -> L52
    L50:
        r109.put("enter_method", r105);     // Catch: Exception -> L52
    L54:
        r108.onClickPromotion("live_ad", r101, "live", r109);
        return;
    L46:
        r116 = null;
        goto L47
    L42:
        r115 = null;
        goto L43
    L32:
        r113 = null;
        goto L33
    L16:
        r110 = null;
    L52:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L54
    L58:
        return;
    L8:
        r107 = null;
        goto L9
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void a(Map<String, String> r100, com.bytedance.android.ec.common.api.jump.model.g r110, String r111) {
        if (r100 == null) goto L12;
        ql.a r101 = null;
        if ((!r100.isEmpty()) == false) goto L6;
        Map<String, String> r102 = r100;
    L7:
        if (r102 == null) goto L13;
        if (r110 == null) goto L10;
        r101 = r110.f42873a;
    L10:
        oh.a.c("livesdk_show_product_info", new h(r101, r102, this, r110, r111));
        return;
    L13:
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

    public final void j(boolean r100, com.bytedance.android.ec.common.api.jump.model.g r101, boolean r110, String r111) {
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

    public final void k(final String r110, final Map<String, String> r111, final String r112, final com.bytedance.android.ec.common.api.jump.model.g r113) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        if (r113 == null) goto L9;
        ql.a r100 = r113.f42873a;
        if (r100 == null) goto L10;
        this.f150251b.c(r110, r100.getUniTag(), new PromotionListEventActionImplV2$doSalePointShowEvent$1(this, r110, r113, r111, r112));
        return;
    L10:
        return;
    }

    public static final void g(PromotionListEventActionImplV2 r100, com.bytedance.android.ec.common.api.jump.model.g r101, boolean r110, String r111, String r112) {
        r100.getClass();
        ql.a r102 = r101.f42873a;
        if (r102.canShowAddCart() == false) goto L60;
        int r103 = 0;
        int r104 = 1;
        if (r102.shouldShowStepper() == false) goto L13;
        com.bytedance.android.ec.model.response.v r105 = r102.getStepperInfo();
        if (r105 != null) goto L10;
    L18:
        r104 = 0;
    L19:
        com.bytedance.android.ec.common.api.jump.model.f r106 = (com.bytedance.android.ec.common.api.jump.model.f) r101.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r110 == false) goto L22;
        String r107 = "livesdk_click_add_to_cart";
    L23:
        sg2.v r108 = new sg2.v(r107, r101);
        r108.c(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "live_list_card");
        if (r102.shouldShowStepper() == false) goto L26;
        String r109 = "edit";
    L27:
        r108.c("display_type", r109);
        com.bytedance.android.ec.model.response.v r113 = r102.getStepperInfo();
        if (r113 == null) goto L30;
        r103 = r113.b();
    L30:
        r108.a("cart_num", r103);
        r108.a("add_display_status", r104);
        r108.c("cart_track", new JSONObject(r102.getTrackExtra()).optString("cart_track"));     // Catch: Exception -> L33
    L35:
        r108.c("ecom_pitaya_json_str", com.bytedance.android.livesdk.livecommerce.event.r.a(r102));
        r108.c("btm_id", r112);
        if (r106 == null) goto L46;
        String r114 = r106.f42860b;
        if (r114 == null) goto L46;
        Map<String, Object> r115 = EcomBcmTracker.f(PageFinder.via(r114), r108.g());
        if (r115 == null) goto L46;
        LinkedHashMap r116 = new LinkedHashMap(MapsKt.mapCapacity(r115.size()));
        Iterator<T> r117 = r115.entrySet().iterator();
    L43:
        if (r117.hasNext() == false) goto L45;
        Map.Entry r118 = (Map.Entry) r117.next();
        r116.put(r118.getKey(), String.valueOf(r118.getValue()));
        goto L43
    L45:
        r108.d(r116);
    L46:
        PromotionListEventActionImplKt.a(r108, r100.f150250a, r111);
        LiveRoomParams r119 = (LiveRoomParams) r101.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r110 == false) goto L59;
        Lazy r120 = LiveEventCenter.f147750b;
        com.bytedance.android.livesdk.livecommerce.eventcenter.d r121 = LiveEventCenter.a.a();
        String r122 = null;
        if (r119 == null) goto L51;
        String r123 = r119.getRoomId();
    L52:
        if (r119 == null) goto L54;
        r122 = r119.getRoomUniqueKey();
    L54:
        r121.sendEvent("product_add_cart", new lh2.a(r123, r122, r102));
        return;
    L51:
        r123 = null;
        goto L52
    L59:
        return;
    L33:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L35
    L26:
        r109 = "normal";
        goto L27
    L22:
        r107 = "livesdk_show_add_to_cart";
        goto L23
    L10:
        if (r105.c() != true) goto L18;
    L13:
        if (r102.getCanAddShopCart() == false) goto L19;
        if (r102.isOnSale() == false) goto L19;
        if (r102.isFlash() == true) goto L19;
    }
}
