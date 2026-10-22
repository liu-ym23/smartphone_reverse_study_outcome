package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECHeaderSlideIndicator;", "Landroid/widget/LinearLayout;", "", "textStringId", "", "setText", "Lcom/bytedance/android/ec/core/widget/ECLottieAnimationView;", "b", "Lcom/bytedance/android/ec/core/widget/ECLottieAnimationView;", "getArrow", "()Lcom/bytedance/android/ec/core/widget/ECLottieAnimationView;", "arrow", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHeaderSlideIndicator extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f48708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECLottieAnimationView f48709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f48710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f48711d;

    public ECHeaderSlideIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECHeaderSlideIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ECLottieAnimationView getArrow() {
        return this.f48709b;
    }

    public final TextView getTextView() {
        return this.f48710c;
    }

    public final void setText(int r100) {
        this.f48710c.setText(th.a.e(getContext(), true).getString(r100));
    }

    public ECHeaderSlideIndicator(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        setOrientation(0);
        setGravity(17);
        View r101 = new View(r100);
        int r102 = (int) 2164260863L;
        r101.setBackgroundColor(r102);
        Float r103 = Float.valueOf(0.5f);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(0, com.bytedance.android.shopping.extensions.b.b(r103));
        r104.weight = 1.0f;
        r104.rightMargin = com.bytedance.android.shopping.extensions.b.b(8);
        Unit r105 = Unit.INSTANCE;
        addView(r101, r104);
        this.f48708a = r101;
        LinearLayout r106 = new LinearLayout(r100);
        ViewGroup.LayoutParams r107 = new LinearLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(24));
        r106.setGravity(17);
        addView(r106, r107);
        TextView r112 = new TextView(r100);
        r112.setIncludeFontPadding(false);
        r112.setTextSize(2, 12.0f);
        r112.setTextColor((int) 3221225471L);
        r112.setText(th.a.e(r100, true).getString(R.string.ec_store_header_live_expand_tips_brand_new));
        r106.addView(r112);
        this.f48710c = r112;
        ECLottieAnimationView r113 = new ECLottieAnimationView(r100);
        r113.setAnimation("ec_store_lottie_slide_down_arrow_light.json");
        r113.setRepeatCount(-1);
        r113.playAnimation();
        r106.addView(r113, new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(18), com.bytedance.android.shopping.extensions.b.b(18)));
        this.f48709b = r113;
        View r114 = new View(r100);
        r114.setBackgroundColor(r102);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(0, com.bytedance.android.shopping.extensions.b.b(r103));
        r108.weight = 1.0f;
        r108.leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
        addView(r114, r108);
        this.f48711d = r114;
    }

    public /* synthetic */ ECHeaderSlideIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
