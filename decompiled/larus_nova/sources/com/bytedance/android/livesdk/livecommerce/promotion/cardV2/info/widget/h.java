package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.response.o0;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends FrameLayout implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o0 f150644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f150645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a f150646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LivePromotionCardArgsV2 f150647d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getCurrentContentDescription() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getType() {
        return "seckill_bar_widget";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public final void release() {
        this.f150647d.f150038b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.b(this.f150645b);
        this.f150644a = null;
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        release();
    }

    public h(Context r100, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r101, LivePromotionCardArgsV2 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "argument");
        super(r100, null, 0);
        this.f150646c = r101;
        this.f150647d = r102;
        ShoppingAsyncInflater.f45268e.getClass();
        addView(ShoppingAsyncInflater.a.a(r100).aU(R.layout.shopping_layout_promotion_card_seckill_bar_widget_v2, this, false));
        ((ECStockProgressLayout) findViewById(R.id.campaign_progress)).setPromotionCardArg(r102);
        this.f150645b = new i(this);
    }
}
