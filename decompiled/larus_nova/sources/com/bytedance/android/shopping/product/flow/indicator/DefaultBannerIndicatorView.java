package com.bytedance.android.shopping.product.flow.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.product.flow.banner.BannerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yg3.c;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/indicator/DefaultBannerIndicatorView;", "Landroid/widget/LinearLayout;", "Lyg3/c;", "", "count", "", "setUpViews", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultBannerIndicatorView extends LinearLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<ImageView> f182355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f182356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f182357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f182358d;

    public DefaultBannerIndicatorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DefaultBannerIndicatorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // yg3.c
    public final void b(BannerView r100) {
        Intrinsics.checkNotNullParameter(r100, "bannerView");
    }

    private final void setUpViews(int r100) {
        if (r100 > 1) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        Iterator<T> r101 = this.f182355a.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((ImageView) r101.next()).setVisibility(8);
        goto L8
    L10:
        int r102 = 0;
    L11:
        if (r102 >= r100) goto L19;
        ImageView r103 = (ImageView) CollectionsKt.getOrNull(this.f182355a, r102);
        if (r103 != null) goto L18;
        r103 = new ImageView(getContext());
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (r102 == 0) goto L17;
        r104.leftMargin = this.f182358d;
    L17:
        addView(r103, r104);
        this.f182355a.add(r103);
    L18:
        r103.setVisibility(0);
        r102 = r102 + 1;
        goto L11
    }

    @Override // yg3.c
    public final void a(int r100, int r101) {
        c(r100, r101);
    }

    public final void c(int r110, int r111) {
        setUpViews(r111);
        if (r111 > 1) goto L5;
        return;
    L5:
        int r100 = 0;
    L6:
        if (r100 >= r111) goto L31;
        if (r111 <= 5) goto L10;
        int r101 = r110 % r111;
        if (r101 != r100) goto L17;
        ((ImageView) ListProtector.get(this.f182355a, r100)).setBackgroundResource(this.f182356b);
    L30:
        r100 = r100 + 1;
        goto L6
    L17:
        if (r110 >= 4) goto L21;
        if (r101 == r100) goto L20;
        ((ImageView) ListProtector.get(this.f182355a, r100)).setBackgroundResource(this.f182357c);
    L20:
        ((ImageView) ListProtector.get(this.f182355a, r111 - 2)).setBackgroundResource(R.drawable.commerce_bg_right_second_fade_indicator_view);
        ((ImageView) ListProtector.get(this.f182355a, r111 - 1)).setBackgroundResource(R.drawable.commerce_bg_right_first_fade_indicator_view);
        goto L30
    L21:
        int r102 = r111 - 2;
        if (r110 >= r102) goto L27;
        if (r110 < 4) goto L27;
        if (r101 == r100) goto L26;
        ((ImageView) ListProtector.get(this.f182355a, r100)).setBackgroundResource(this.f182357c);
    L26:
        ((ImageView) ListProtector.get(this.f182355a, 0)).setBackgroundResource(R.drawable.commerce_bg_left_first_fade_indicator_view);
        ((ImageView) ListProtector.get(this.f182355a, 1)).setBackgroundResource(R.drawable.commerce_bg_left_second_fade_indicator_view);
        ((ImageView) ListProtector.get(this.f182355a, r102)).setBackgroundResource(R.drawable.commerce_bg_right_second_fade_indicator_view);
        ((ImageView) ListProtector.get(this.f182355a, r111 - 1)).setBackgroundResource(R.drawable.commerce_bg_right_first_fade_indicator_view);
    L27:
        if (r101 == r100) goto L29;
        ((ImageView) ListProtector.get(this.f182355a, r100)).setBackgroundResource(this.f182357c);
    L29:
        ((ImageView) ListProtector.get(this.f182355a, 0)).setBackgroundResource(R.drawable.commerce_bg_left_first_fade_indicator_view);
        ((ImageView) ListProtector.get(this.f182355a, 1)).setBackgroundResource(R.drawable.commerce_bg_left_second_fade_indicator_view);
        goto L30
    L10:
        if ((r110 % r111) != r100) goto L12;
        ((ImageView) ListProtector.get(this.f182355a, r100)).setBackgroundResource(this.f182356b);
        goto L30
    L12:
        ((ImageView) ListProtector.get(this.f182355a, r100)).setBackgroundResource(this.f182357c);
        goto L30
    }

    public DefaultBannerIndicatorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f182355a = new ArrayList();
        this.f182356b = R.drawable.commerce_bg_selected_indicator_dot;
        this.f182357c = R.drawable.commerce_bg_unselected_indicator_dot;
        Resources r103 = Resources.getSystem();
        this.f182358d = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        setGravity(17);
        setBackgroundResource(R.drawable.shopping_bg_product_feed_indicator);
        float r104 = 8;
        Resources r105 = Resources.getSystem();
        int r106 = MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
        float r107 = (float) 7.5d;
        Resources r108 = Resources.getSystem();
        int r109 = MathKt.roundToInt(TypedValue.applyDimension(1, r107, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics())));
        Resources r110 = Resources.getSystem();
        int r111 = MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics())));
        Resources r112 = Resources.getSystem();
        setPadding(r106, r109, r111, MathKt.roundToInt(TypedValue.applyDimension(1, r107, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()))));
    }

    public /* synthetic */ DefaultBannerIndicatorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
