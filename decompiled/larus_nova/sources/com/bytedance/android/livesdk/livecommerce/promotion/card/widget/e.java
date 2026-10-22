package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.CountDownView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.ECStockProgressLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends FrameLayout implements ij2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECUIPromotion f150459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f150460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LivePromotionCardArgs f150461c;

    public static final class a {
    }

    static {
    }

    @Override // ij2.a
    public String getCurrentContentDescription() {
        return "";
    }

    @Override // ij2.a
    public String getType() {
        return "seckill_bar_widget";
    }

    @Override // ij2.a
    public final void release() {
        this.f150461c.f150038b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.b(this.f150460b);
    }

    @Override // ij2.a
    public final boolean a() {
        return ij2.a.C6273a.b(this);
    }

    @Override // ij2.a
    public ij2.b getParentContainer() {
        return ij2.a.C6273a.a(this);
    }

    @Override // ij2.a
    public final void b(com.bytedance.android.ec.common.api.jump.model.e r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ECUIPromotion r101 = r100.f42855a;
        this.f150459a = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        ECUICampaign r102 = r101.getCampaign();
        if (r102 == null) goto L8;
        ((ECStockProgressLayout) findViewById(R.id.campaign_progress)).b(r102.progressText, r102.stock, r102.leftStock, r102.label);
        c(SystemClock.elapsedRealtime(), r102.endTime);
    L8:
        this.f150461c.f150038b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.a(this.f150460b);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        release();
    }

    public e(Context r100, LivePromotionCardArgs r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "argument");
        super(r100, null, 0);
        this.f150461c = r101;
        ShoppingAsyncInflater.f45268e.getClass();
        addView(ShoppingAsyncInflater.a.a(r100).aU(R.layout.shopping_layout_promotion_card_seckill_bar_widget, this, false));
        this.f150460b = new f(this);
    }

    public final void c(long r100, long r101) {
        long r102 = r101 - r100;
        CountDownView r103 = (CountDownView) findViewById(R.id.countdown_view);
        ECUIPromotion r104 = this.f150459a;
        if (r104 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L6:
        if (r104.isOnSale() == true) goto L8;
    L13:
        r103.setVisibility(4);
        return;
    L8:
        if (r102 < 86400000) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L13;
        r103.setVisibility(0);
        r103.a(r102);
        return;
    L10:
        r105 = false;
        goto L11
    }
}
