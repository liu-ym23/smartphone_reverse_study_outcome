package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroStockProgressLayout;", "Landroid/widget/FrameLayout;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
final class IntroStockProgressLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f148084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f148085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f148086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f148087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f148088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f148089f;

    public static final class a {
    }

    static {
    }

    public final void a(float r100) {
        View r101 = this.f148084a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r102 = null;
    L8:
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        if (r103 == null) goto L18;
        r103.width = (int) r100;
        View r104 = this.f148084a;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L13:
        r104.setLayoutParams(r103);
        View r105 = this.f148084a;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L16:
        r105.setVisibility(0);
        return;
    }

    public IntroStockProgressLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public IntroStockProgressLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = th.a.c(r100, R.layout.ec_intro_card_widget_seckill_bar_component, this, true);
        r103.setBackgroundResource(R.drawable.ec_bg_intro_card_stock_progress);
        this.f148084a = r103.findViewById(R.id.ec_bg_seckill_stock_progress);
        ECLottieAnimationView r104 = (ECLottieAnimationView) r103.findViewById(R.id.lottie_ec_bg_seckill_stock_progress_tail);
        this.f148085b = (TextView) r103.findViewById(R.id.ec_tv_seckill_progress_des);
        this.f148086c = (TextView) r103.findViewById(R.id.ec_ic_seckill_stock_label);
        this.f148087d = UtilityKotlinExtentionsKt.d(48);
        this.f148088e = 10.0f;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_INFO_PROGRESS_FIX() == true) goto L5;
        return;
    L5:
        Float r105 = this.f148089f;
        if (r105 == null) goto L11;
        float r106 = 10;
        if (r105.floatValue() > r106) goto L10;
        float r107 = this.f148087d;
        a(r107);
    L12:
        TextView r108 = this.f148086c;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L15:
        boolean r109 = false;
        if (r107 < r108.getLeft()) goto L21;
        TextView r110 = this.f148086c;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L20:
        r110.setVisibility(4);
    L25:
        TextView r111 = this.f148085b;
        if (r111 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L28:
        CharSequence r112 = r111.getText();
        if (r112 == null) goto L57;
        String r113 = r112.toString();
        if (r113 != null) goto L33;
        return;
    L33:
        if (r113.length() <= 3) goto L35;
        boolean r114 = true;
    L36:
        Integer r115 = null;
        if (r114 == true) goto L40;
        r113 = null;
    L40:
        if (r113 == null) goto L59;
        TextView r116 = this.f148085b;
        if (r116 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L45:
        if ((r116.getPaint().measureText(r113) + (UtilityKotlinExtentionsKt.d(6) * 2)) <= r107) goto L60;
        Integer r117 = Integer.valueOf((int) this.f148088e);
        if (r117.intValue() <= 1) goto L49;
        r109 = true;
    L49:
        if (r109 == false) goto L51;
        r115 = r117;
    L51:
        if (r115 == null) goto L61;
        int r118 = r115.intValue();
        int r119 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.f150307a;
        int r120 = ((int) r107) - (UtilityKotlinExtentionsKt.d(6) * 2);
        TextView r121 = this.f148085b;
        if (r121 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L55:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a(r118, r120, r113, r121);
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L35:
        r114 = false;
        goto L36
    L57:
        return;
    L21:
        TextView r122 = this.f148086c;
        if (r122 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L24:
        r122.setVisibility(0);
        goto L25
    L10:
        float r123 = this.f148087d;
        r107 = (((r105.floatValue() - r106) / 90) * (getWidth() - r123)) + r123;
        a(r107);
        goto L12
    L11:
        r107 = 0.0f;
        goto L12
    }
}
