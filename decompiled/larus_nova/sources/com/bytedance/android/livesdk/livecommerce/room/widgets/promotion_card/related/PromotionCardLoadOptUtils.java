package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import android.content.Context;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUISmallPopCard;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y;
import com.facebook.imagepipeline.common.Priority;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class PromotionCardLoadOptUtils {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap<String, PromotionCardLoadOptUtils> f152540n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f152541o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f152542p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f152543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Long f152544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Long f152545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile ECUIPromotion f152546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f152547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Disposable f152548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Function1<? super ECUIPromotion, Unit> f152549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ECContext f152550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f152551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference<Context> f152552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function3<com.bytedance.android.livesdk.livecommerce.room.model.e, String, Boolean, Observable<ECCurrentPromotion>> f152553k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f152554l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f152555m;

    public static final class Companion {
        public Companion() {
        }

        public static PromotionCardLoadOptUtils c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            HashMap<String, PromotionCardLoadOptUtils> r101 = PromotionCardLoadOptUtils.f152540n;
            PromotionCardLoadOptUtils r102 = r101.get(r100);
            if (r102 != null) goto L6;
            PromotionCardLoadOptUtils r103 = new PromotionCardLoadOptUtils(PromotionCardLoadOptUtils$Companion$getRelatedOpt$1.INSTANCE, (PromotionCardLoadOptUtils$Companion$RELATED_MONITOR$2.a) PromotionCardLoadOptUtils.f152541o.getValue());
            PromotionCardLoadOptUtils.f152542p.getClass();
            r101.put(r100, r103);
            return r103;
        L6:
            return r102;
        }

        public static final void b(Companion r110, ECUIPromotion r111) {
            r110.getClass();
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L19
            String r100 = r111.imageUrl;     // Catch: Throwable -> L19
            int r113 = com.bytedance.android.ec.core.imagex.r.f44937h;     // Catch: Throwable -> L19
            com.bytedance.android.ec.core.imagex.r r101 = com.bytedance.android.ec.core.imagex.r.a.b("goods_card_view");     // Catch: Throwable -> L19
            Priority r114 = Priority.IMMEDIATE;     // Catch: Throwable -> L19
            ImageExtensionsKt.B(r100, r101, null, null, r114, new d(), null, false, 192);     // Catch: Throwable -> L19
            ECUrlModel r102 = r111.topIcon;     // Catch: Throwable -> L19
            if (r102 == null) goto L8;
            String r103 = r102.getFirstUrl();     // Catch: Throwable -> L19
            if (r103 == null) goto L8;
            ImageExtensionsKt.B(r103, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_top_up_view"), null, null, r114, new e(), null, false, 192);     // Catch: Throwable -> L19
        L8:
            y.f152727o.getClass();     // Catch: Throwable -> L19
            if (y.f152725m == false) goto L24;
            ImageExtensionsKt.B(r111.normalBottonIcon, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_botton_normal_view"), null, null, r114, new f(), null, false, 192);     // Catch: Throwable -> L19
            ImageExtensionsKt.B(r111.qIvIcon, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_up_view"), null, null, r114, new g(), null, false, 192);     // Catch: Throwable -> L19
            ECUISmallPopCard r115 = r111.smallPopCard;     // Catch: Throwable -> L19
            if (r115 == null) goto L16;
            String r104 = r115.backgroundImgNew;     // Catch: Throwable -> L19
            if (r104 == null) goto L16;
            ImageExtensionsKt.B(r104, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_activity_view"), null, null, r114, new h(), null, false, 192);     // Catch: Throwable -> L19
            Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L19
        L17:
            Result.m9449constructorimpl(r116);     // Catch: Throwable -> L19
            return;
        L16:
            r116 = null;
            goto L17
        L24:
            return;
        L19:
            th = move-exception;
            Result.Companion r117 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        public static final void a(Companion r100, Context r101, int r102) {
            r100.getClass();
            ShoppingAsyncInflater.a r103 = ShoppingAsyncInflater.f45268e;
            Context r104 = th.a.e(r101, true);
            r103.getClass();
            com.bytedance.android.ec.opt.asyncInflate.d r105 = ShoppingAsyncInflater.a.a(r104).a();
            r105.c(R.layout.ec_explain_card_uimodule_above, r102, "ec_explain_card_uimodule_above");
            r105.c(R.layout.ec_explain_card_bottom_layout, r102, "ec_explain_card_bottom_layout");
            r105.commit();
        }
    }

    static {
        f152542p = new Companion();
        f152540n = new HashMap();
        f152541o = LazyKt.lazy(PromotionCardLoadOptUtils$Companion$RELATED_MONITOR$2.INSTANCE);
    }

    public final WeakReference<Context> getContext() {
        return this.f152552j;
    }

    public PromotionCardLoadOptUtils(Function3 r100, PromotionCardLoadOptUtils$Companion$RELATED_MONITOR$2.a r101) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        Intrinsics.checkNotNullParameter(r101, "monitor");
        this.f152553k = r100;
        this.f152554l = 1;
        this.f152555m = r101;
    }

    public final void a(ECContext r100, com.bytedance.android.livesdk.livecommerce.room.model.g r101, String r102, Context r103, com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p r104) {
        Intrinsics.checkNotNullParameter(r100, "ecContext");
        Intrinsics.checkNotNullParameter(r101, "liveRoomInfo");
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L5;
        return;
    L5:
        dm.a.b r105 = dm.a.a("LiveCardLoad");
        StringBuilder r106 = new StringBuilder("preload related card, is instant = ");
        if (r104 == null) goto L8;
        boolean r107 = true;
    L9:
        r106.append(r107);
        r105.i(r106.toString());
        if (r104 == null) goto L13;
        r104.c(r100, r101, r102);
        return;
    L13:
        if (r102 != null) goto L16;
        return;
    L16:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f152699f == true) goto L19;
        return;
    L19:
        if (this.f152543a != true) goto L21;
    L23:
        this.f152550h = r100;
        if (r103 == null) goto L38;
        y.f152727o.getClass();
        if (y.f152723k == false) goto L36;
        WeakReference<Context> r108 = this.f152552j;
        if (r108 == null) goto L30;
        Context r109 = r108.get();
    L31:
        boolean r110 = Intrinsics.areEqual(r109, r103);
        this.f152555m.c(r100.getEcLivePerformanceMonitor().getValue(), r110);
        OptCardUtil.b(null, "async layout same: " + r110);
        if (this.f152551i == false) goto L35;
        if (r110 == false) goto L35;
        return;
    L35:
        Companion.a(f152542p, r103, this.f152554l);
        return;
    L30:
        r109 = null;
        goto L31
    L36:
        Companion.a(f152542p, r103, this.f152554l);
        return;
    L38:
        return;
    L21:
        if (this.f152547e == true) goto L23;
        OptCardUtil.b(null, "request=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f152701h + " bind=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f152702i + " show=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f152703j + " CardDoFrame=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f152704k + " PicPreload=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f152705l + " PicDoFrame=" + com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f152706m);
        this.f152543a = true;
        this.f152555m.e(r100.getEcLivePerformanceMonitor().getValue());
        bk2.c.a(this.f152553k.invoke(r101, r102, Boolean.TRUE).subscribe(new k(this, r100), new l(this, r100)), r100.getDisposableContext().getValue());
        goto L23
    L8:
        r107 = false;
        goto L9
    }
}
