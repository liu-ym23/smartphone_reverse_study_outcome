package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.CampaignProgress;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.card.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECUIPromotion f150398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECNetImageView f150399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f150400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECNewCountDownView f150401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public StringBuilder f150402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f150403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f150404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f150405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f150406i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotion.card.view.a$a, reason: collision with other inner class name */
    public static final class C2319a {
    }

    static {
    }

    public final void c() {
        this.f150398a = null;
        this.f150406i.f150038b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r100 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a;
        r100.b(this.f150404g);
        this.f150406i.f150038b.a();
        r100.b(this.f150405h);
    }

    public final Drawable a() {
        GradientDrawable r100 = new GradientDrawable();
        r100.setCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(2.0f)));
        r100.setStroke(2, th.a.a(getContext(), R.color.shopping_color_33FF3344));
        r100.setColor(th.a.a(getContext(), R.color.shopping_color_0DFF3344));
        return r100;
    }

    public final void b() {
        setVisibility(8);
        this.f150400c.setVisibility(8);
        this.f150401d.setVisibility(8);
    }

    public a(Context r100, LivePromotionCardArgs r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "argument");
        super(r100, null, 0);
        this.f150406i = r101;
        this.f150404g = new b(this);
        this.f150405h = new c(this);
        th.a.c(r100, R.layout.shopping_layout_promotion_card_activity_label_view, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-2, UtilityKotlinExtentionsKt.d(16)));
        this.f150399b = (ECNetImageView) findViewById(R.id.niv_icon);
        this.f150400c = (TextView) findViewById(R.id.activity_des);
        this.f150401d = (ECNewCountDownView) findViewById(R.id.tv_count_down);
    }

    public final void d(ECUICampaign r110, long r111, StringBuilder r112) {
        if (r110 == null) goto L34;
        ECLiveABUtils r100 = ECLiveABUtils.INSTANCE;
        if (r100.getECOM_LIVE_ACTIVITY_LABEL_STOCK() == true) goto L8;
        if (r110.stock > 0) goto L8;
        return;
    L8:
        if (r100.getECOM_LIVE_ACTIVITY_LABEL_STOCK() == true) goto L10;
    L12:
        float r101 = ((r110.leftStock * 1.0f) / r110.stock) * 100;
    L13:
        long r102 = r110.endTime - r111;
        boolean r103 = true;
        if (r110.startTime >= r111) goto L16;
        boolean r104 = true;
    L18:
        if (r102 >= 86400000) goto L21;
        r103 = false;
    L21:
        if (r103 == false) goto L23;
    L30:
        this.f150401d.setText(r110.progressText);
        if (r112 == null) goto L38;
        r112.append(r110.progressText);
        return;
    L38:
        return;
    L23:
        if (r100.getECOM_LIVE_ACTIVITY_LABEL_STOCK() == false) goto L25;
    L27:
        if (r104 == true) goto L29;
        ECNewCountDownView.x(this.f150401d, r110.startTime - r111, r110.progressText, 10);
        return;
    L29:
        ECNewCountDownView.x(this.f150401d, r110.endTime - r111, null, 14);
        return;
    L25:
        if (r101 > 10) goto L27;
    L16:
        r104 = false;
        goto L18
    L10:
        if (r110.stock > 0) goto L12;
        r101 = 0.0f;
        goto L13
    }

    public final void e(ECUICampaign r100, long r101, StringBuilder r110) {
        if (r100 == null) goto L5;
        CampaignProgress r102 = r100.progress;
    L6:
        if (r102 != null) goto L8;
    L30:
        b();
        return;
    L8:
        if (r100.stock <= 0) goto L30;
        CampaignProgress r103 = r100.progress;
        if (r103.getCountDown() != null) goto L23;
        if (TextUtils.isEmpty(r103.getRightText()) == true) goto L21;
        this.f150401d.setText(r103.getRightText());
        if (r110 != null) goto L17;
    L18:
        if (r110 == null) goto L20;
        r110.append(r103.getRightText());
    L20:
        setVisibility(0);
        this.f150400c.setVisibility(0);
        this.f150401d.setVisibility(0);
        return;
    L17:
        if (StringsKt.contains$default(r110, String.valueOf(r103.getRightText()), false, 2, null) == true) goto L20;
    L21:
        b();
        return;
    L23:
        if (r101 <= 0) goto L28;
        ECNewCountDownView r111 = this.f150401d;
        String r104 = r103.getRightText();
        if (r104 != null) goto L27;
        r104 = "";
    L27:
        ECNewCountDownView.x(r111, r101, r104, 10);
        setVisibility(0);
        this.f150400c.setVisibility(0);
        this.f150401d.setVisibility(0);
        return;
    L28:
        b();
        return;
    L5:
        r102 = null;
        goto L6
    }
}
