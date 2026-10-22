package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.model.CategoryInfo;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageCategoryData;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import si2.d0;
import si2.e0;
import si2.f0;
import si2.t;
import si2.z;

/* JADX INFO: loaded from: classes10.dex */
public final class LivePromotionListCacheCenter implements lj2.a, oj2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f151060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mj2.e f151061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f151062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f151063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f151064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b f151065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DisposableScope f151066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f151067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f151068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.utils.g f151069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Boolean> f151070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Boolean> f151071l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RoomContextController f151072m;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePromotionListCacheCenter f151073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f151074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f151075c;

        public a(LivePromotionListCacheCenter r100, int r101, long r102) {
            this.f151073a = r100;
            this.f151074b = r101;
            this.f151075c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            vj2.b r101 = (vj2.b) r100;
            if (this.f151074b != 11) goto L6;
            long r102 = SystemClock.elapsedRealtime() - this.f151075c;
            int r103 = com.bytedance.android.livesdk.livecommerce.opt.d.f149775a;
            com.bytedance.android.livesdk.livecommerce.opt.d.a("data_fetched", this.f151073a.f151060a.f151116h, Long.valueOf(r102), this.f151073a.f151072m.l());
        L6:
            if (r101.statusCode != 0) goto L8;
            int r104 = mj2.e.f514176y;
            mj2.e r105 = mj2.e.a.a(r101);
            LivePromotionListCacheCenter r106 = this.f151073a;
            c r107 = r106.f151060a;
            Handler r108 = k.f153092a;
            r106.i(r107, r105, SystemClock.elapsedRealtime());
        L8:
            int r109 = zg2.a.f572040a;
            c r110 = this.f151073a.f151060a;
            zg2.a.a(r110.f151116h, r110.f151118j, Action.SHOP_LIST_DATA_FROM, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data_from", String.valueOf(this.f151074b))}));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f151076a = null;

        static {
            f151076a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    @Override // lj2.a
    public final void H(z r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // lj2.a
    public final void a(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // lj2.a
    public final void d(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // lj2.a
    public final void h(z r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // lj2.a
    public final void z(boolean r100, List<ECPromotionInterationData> r101) {
    }

    public final void e() {
        this.f151064e = -1;
        this.f151061b = null;
        this.f151062c = false;
        this.f151066g.clearDisposable();
        this.f151069j.a();
        Disposable r100 = this.f151067h;
        if (r100 != null) goto L5;
    L10:
        Disposable r101 = this.f151068i;
        if (r101 != null) goto L13;
    L18:
        this.f151067h = null;
        this.f151068i = null;
        return;
    L13:
        if ((!r101.isDisposed()) == true) goto L16;
        r101 = null;
    L16:
        if (r101 == null) goto L18;
        r101.dispose();
        goto L18
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    public final boolean f() {
        long r100 = this.f151064e;
        if (r100 <= 0) goto L9;
        long r101 = r100 + ((long) this.f151063d);
        Handler r102 = k.f153092a;
        if (r101 <= SystemClock.elapsedRealtime()) goto L9;
        if (this.f151061b == null) goto L9;
        return true;
    L9:
        return false;
    }

    public static void b(LivePromotionListCacheCenter r100) {
        PromotionListController r101 = ControllerExtensionsKt.c(r100.f151072m, r100.f151060a.f151116h).A().f151427r;
        Context r102 = ControllerExtensionsKt.c(r100.f151072m, r100.f151060a.f151116h).getContext();
        if (r102 == null) goto L18;
        int r103 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.g.f150320a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater r104 = ShoppingAsyncInflater.a.a(r102);
        com.bytedance.android.ec.opt.asyncInflate.d r105 = r104.a();
        boolean r106 = true;
        boolean r107 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.g.a(r104, r105, R.layout.shopping_fragment_live_promotion_list, 1);
        if (com.bytedance.android.livesdk.livecommerce.promotion.card.utils.g.a(r104, r105, R.layout.shopping_layout_promotion_card_v2, 10) == true) goto L9;
        if (r107 == true) goto L9;
        boolean r108 = false;
    L11:
        if (com.bytedance.android.livesdk.livecommerce.promotion.card.utils.g.a(r104, r105, R.layout.shopping_layout_promotion_card_seckill_bar_widget_v2, 3) == true) goto L15;
        if (r108 == true) goto L15;
        r106 = false;
    L15:
        if (r106 == false) goto L19;
        r105.commit();
        return;
    L19:
        return;
    L9:
        r108 = true;
        goto L11
    }

    @Override // oj2.a
    public final void I(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        sj2.a.a("[cache] recv list refresh message");
        if (f() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.livecommerce.room.utils.g r101 = this.f151069j;
        Function0<Unit> r102 = new LivePromotionListCacheCenter$updateProductListFromListRefreshMessage$1(this);
        int r103 = com.bytedance.android.livesdk.livecommerce.room.utils.g.f151937c;
        r101.c("update_product_list", 0, true, r102);
    }

    public final boolean c(c r100) {
        PromotionCategory.a r101 = PromotionCategory.Companion;
        String r102 = r100.f151110b;
        r101.getClass();
        boolean r103 = PromotionCategory.a.b(r102);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SPLIT_PROMOTION_LIST_REQUEST().booleanValue() == false) goto L8;
        if (this.f151062c == r100.f151132x) goto L8;
        r103 = false;
    L8:
        if (Intrinsics.areEqual(r100.f151121m, "live_shopping_cart") == false) goto L20;
        String r104 = r100.f151124p;
        if (r104 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L21;
        if (r103 == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L12:
        if (r104.length() == 0) goto L15;
        r105 = false;
        goto L16
    L20:
        return false;
    }

    public final mj2.e j(c r100) {
        Intrinsics.checkNotNullParameter(r100, "reqParam");
        boolean r101 = c(r100);
        boolean r102 = f();
        if (r101 == false) goto L9;
        if (r102 == false) goto L10;
        mj2.e r103 = this.f151061b;
        if (r103 == null) goto L11;
        r103.f514197u = true;
        r103.f514191o = null;
        r103.f514188l = null;
        return r103;
    L11:
        return null;
    L10:
        return null;
    L9:
        return null;
    }

    @Override // lj2.a
    public final void m(t r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        PromotionListController r101 = ControllerExtensionsKt.c(this.f151072m, this.f151060a.f151116h).A().f151427r;
        if (r100.msgType != 1) goto L5;
        boolean r102 = true;
    L6:
        r101.I = Boolean.valueOf(r102);
        if (f() == true) goto L9;
        return;
    L9:
        e();
        this.f151069j.c("update_product_list", 0, true, new LivePromotionListCacheCenter$updateAuthorConnect$1(this));
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // oj2.a
    public final void w(si2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        sj2.a.a("[cache] recv category refresh message");
        if (f() == true) goto L5;
        return;
    L5:
        mj2.e r101 = this.f151061b;
        if (r101 == null) goto L19;
        LivePromotionPageCategoryData r102 = r101.f514192p;
        if (r102 == null) goto L20;
        List<CategoryInfo> r103 = r100.categoryInfo;
        if (r103 == null) goto L15;
        List<CategoryInfo> r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L13:
        if (r106.hasNext() == false) goto L16;
        CategoryInfo r107 = (CategoryInfo) r106.next();
        PromotionCategory.Companion.getClass();
        r105.add(PromotionCategory.a.a(r107));
    L16:
        r102.setCategories(r105);
        return;
    L15:
        r105 = null;
        goto L16
    L20:
        return;
    }

    public final void g(boolean r110, int r111) {
        if (r110 == false) goto L7;
        if (xh2.a.b() == true) goto L7;
        return;
    L7:
        if (r110 == false) goto L11;
        ControllerExtensionsKt.c(this.f151072m, this.f151060a.f151116h).A().f151427r.f151557l = true;
        ECLivePerformanceMonitor.b r112 = ECLivePerformanceMonitor.f149745x;
        c r113 = this.f151060a;
        ECLivePerformanceMonitor r114 = ECLivePerformanceMonitor.c.a(r113.f151116h, r113.f151118j);
        if (r114 == null) goto L11;
        r114.p(4, true);
    L11:
        c r115 = this.f151060a;
        r115.f151119k = this.f151070k.invoke().booleanValue();
        long r100 = SystemClock.elapsedRealtime();
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b r101 = this.f151065f;
        c r102 = this.f151060a;
        r102.f151128t = this.f151071l.invoke().booleanValue();
        Unit r116 = Unit.INSTANCE;
        Disposable r117 = r101.a(r102, 0, EComABUtils.liveListLoadPageSize(), r111, true, true).observeOn(Schedulers.io()).subscribe(new a(this, r111, r100), b.f151076a);
        if (EComABUtils.isLiveListMemoryLeakSwitchForDisposable() == false) goto L22;
        Disposable r118 = this.f151067h;
        if (r118 != null) goto L16;
    L21:
        this.f151067h = r117;
        return;
    L16:
        if ((true ^ r118.isDisposed()) == true) goto L19;
        r118 = null;
    L19:
        if (r118 == null) goto L21;
        r118.dispose();
        goto L21
    L22:
        com.bytedance.android.ec.core.async.a.a(r117, this.f151066g);
    }

    public final void i(c r100, mj2.e r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "reqParam");
        this.f151062c = r100.f151132x;
        if (c(r100) == false) goto L5;
        this.f151064e = r102;
        this.f151061b = r101;
        return;
    L5:
        this.f151064e = -1;
        this.f151061b = null;
        this.f151062c = false;
    }

    @Override // lj2.a
    public final void t(String r100, final String r101, final Map<String, String> r102) {
        if (f() == true) goto L6;
        return;
    L6:
        if (r100 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L17;
        mj2.e r104 = this.f151061b;
        if (r104 == null) goto L19;
        r104.f514179c = null;
        return;
    L19:
        return;
    L17:
        com.bytedance.android.livesdk.livecommerce.room.utils.g r105 = this.f151069j;
        Function0<Unit> r106 = new LivePromotionListCacheCenter$updateExplainPromotionFromMessage$1(this, r101, r102);
        int r107 = com.bytedance.android.livesdk.livecommerce.room.utils.g.f151937c;
        r105.c("update_explain_promotion", 0, true, r106);
        return;
    L8:
        if (r100.length() == 0) goto L11;
        r103 = false;
        goto L12
    }

    public LivePromotionListCacheCenter(String r210, String r211, String r212, Function0<Boolean> r213, Function0<Boolean> r310, RoomContextController r311) {
        Intrinsics.checkNotNullParameter(r210, "anchorId");
        Intrinsics.checkNotNullParameter(r211, "anchorSecId");
        Intrinsics.checkNotNullParameter(r212, "roomId");
        Intrinsics.checkNotNullParameter(r213, "isLinkmic");
        Intrinsics.checkNotNullParameter(r310, "recommendedProductDisplayed");
        Intrinsics.checkNotNullParameter(r311, "roomContextController");
        this.f151070k = r213;
        this.f151071l = r310;
        this.f151072m = r311;
        this.f151060a = new c(r210, r211, r212, r212, r311.D(), r213.invoke().booleanValue(), false, "live_shopping_cart", false, -1, null, null, false, null, r310.invoke().booleanValue(), null, false, null, null, 2064384);
        this.f151063d = EComABUtils.liveListCacheExpireTime();
        this.f151064e = -1;
        this.f151065f = new com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b();
        this.f151066g = new DisposableScope();
        this.f151069j = new com.bytedance.android.livesdk.livecommerce.room.utils.g();
    }
}
