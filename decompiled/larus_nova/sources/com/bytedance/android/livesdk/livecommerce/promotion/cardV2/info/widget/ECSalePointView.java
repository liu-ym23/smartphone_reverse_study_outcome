package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.ECCarouselData;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated(message = "整体迁移 ECSalePointViewV2")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB%\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECSalePointView;", "Landroid/widget/LinearLayout;", "Landroid/view/View;", "getLine", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSalePointView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f150612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f150613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f150614c;

    private final View getLine() {
        View r100 = new View(getContext());
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d)), UtilityKotlinExtentionsKt.d(8));
        r101.leftMargin = UtilityKotlinExtentionsKt.d(3);
        r101.rightMargin = UtilityKotlinExtentionsKt.d(Double.valueOf(3.5d));
        r101.gravity = 16;
        r100.setLayoutParams(r101);
        r100.setBackgroundColor(th.a.a(getContext(), R.color.shopping_color_sale_point_line));
        r100.setVisibility(8);
        return r100;
    }

    public ECSalePointView(Context r100) {
        super(r100);
        setOrientation(0);
        TextView r101 = b(getContext());
        this.f150612a = r101;
        View r102 = getLine();
        this.f150613b = r102;
        TextView r103 = b(getContext());
        this.f150614c = r103;
        addView(r101);
        addView(r102);
        addView(r103);
    }

    public static TextView b(Context r100) {
        TextView r101 = new TextView(r100);
        r101.setTextSize(1, 12.0f);
        r101.setTextColor(th.a.a(r100, R.color.shopping_color_FFFF003C));
        r101.setEllipsize(TextUtils.TruncateAt.END);
        r101.setMaxLines(1);
        return r101;
    }

    public ECSalePointView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setOrientation(0);
        TextView r102 = b(getContext());
        this.f150612a = r102;
        View r103 = getLine();
        this.f150613b = r103;
        TextView r104 = b(getContext());
        this.f150614c = r104;
        addView(r102);
        addView(r103);
        addView(r104);
    }

    public final void a(ECCarouselData r100, com.bytedance.android.livesdk.livecommerce.promotion.card.k r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r102 = r100.getBefore();
        String r103 = null;
        if (cg4.a.a(r102) == true) goto L7;
        r102 = null;
    L7:
        if (r102 == null) goto L9;
        this.f150612a.setVisibility(0);
        this.f150612a.setText(r102);
    L11:
        if (cg4.a.a(r100.getBefore()) == true) goto L13;
    L15:
        this.f150613b.setVisibility(8);
    L16:
        String r104 = r100.getContent();
        if (cg4.a.a(r104) == false) goto L19;
        r103 = r104;
    L19:
        if (r103 == null) goto L21;
        this.f150614c.setVisibility(0);
        this.f150614c.setText(r103);
        int r105 = com.bytedance.android.ec.core.utils.s.f45717a;
        this.f150614c.setTextColor(com.bytedance.android.ec.core.utils.s.a(r100.getColor(), th.a.a(getContext(), R.color.shopping_color_FFFF003C)));
    L22:
        if (r101 == null) goto L29;
        IPromotionUIConfig.d r106 = r101.a(PromotionCardModuleName.InfoAreaSalePointModule);
        if (r106 == null) goto L30;
        IPromotionUIConfig.b r107 = r106.a();
        if (r107 == null) goto L31;
        int r108 = UIConfigHelper.f150297a;
        UIConfigHelper.c(this.f150612a, r107);
        UIConfigHelper.c(this.f150614c, r107);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L21:
        this.f150614c.setVisibility(8);
        Unit r109 = Unit.INSTANCE;
        goto L22
    L13:
        if (cg4.a.a(r100.getContent()) == false) goto L15;
        this.f150613b.setVisibility(0);
        goto L16
    L9:
        this.f150612a.setVisibility(8);
        Unit r110 = Unit.INSTANCE;
        goto L11
    }

    public ECSalePointView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setOrientation(0);
        TextView r103 = b(getContext());
        this.f150612a = r103;
        View r104 = getLine();
        this.f150613b = r104;
        TextView r105 = b(getContext());
        this.f150614c = r105;
        addView(r103);
        addView(r104);
        addView(r105);
    }
}
