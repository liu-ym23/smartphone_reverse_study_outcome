package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECStockProgressLayout;", "Landroid/widget/FrameLayout;", "", "progressText", "", "setTxStockDes", "label", "setLabel", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/LivePromotionCardArgsV2;", "arg", "setPromotionCardArg", "", ce.f26391f, "Lkotlin/Lazy;", "getBasicWidth", "()I", "basicWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStockProgressLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f150622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f150623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECLottieAnimationView f150624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f150625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LivePromotionCardArgsV2 f150626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f150627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f150628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f150629h;

    public static final class a {
    }

    static {
    }

    public ECStockProgressLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECStockProgressLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getBasicWidth() {
        return ((Number) this.f150628g.getValue()).intValue();
    }

    public static final /* synthetic */ int a(ECStockProgressLayout r100) {
        return r100.getBasicWidth();
    }

    private final void setLabel(String r100) {
        TextView r101 = this.f150625d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L5:
        r101.setContentDescription(r100);
        if (TextUtils.isEmpty(r100) == false) goto L11;
        TextView r102 = this.f150625d;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L10:
        r102.setVisibility(4);
        return;
    L11:
        TextView r103 = this.f150625d;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L15:
        if (Intrinsics.areEqual(r103.getText(), r100) == false) goto L21;
        TextView r104 = this.f150625d;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L20:
        if (r104.getVisibility() != 0) goto L21;
        return;
    L21:
        TextView r105 = this.f150625d;
        if (r105 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L24:
        r105.setText(r100);
        TextView r106 = this.f150625d;
        if (r106 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L27:
        r106.setVisibility(4);
    }

    private final void setTxStockDes(String r100) {
        TextView r101 = this.f150623b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L5:
        r101.setContentDescription(r100);
        if (TextUtils.isEmpty(r100) == false) goto L11;
        TextView r102 = this.f150623b;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L10:
        r102.setVisibility(8);
        return;
    L11:
        TextView r103 = this.f150623b;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L14:
        r103.setVisibility(0);
        TextView r104 = this.f150623b;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L17:
        r104.setText(r100);
    }

    public final void setPromotionCardArg(LivePromotionCardArgsV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "arg");
        this.f150626e = r100;
    }

    public static final void b(ECStockProgressLayout r100, float r101) {
        View r102 = r100.f150622a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L5:
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        ql.a r104 = null;
        if ((r103 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r103 = null;
    L8:
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r103;
        if (r105 == null) goto L17;
        r105.width = (int) r101;
        View r106 = r100.f150622a;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L13:
        r106.setLayoutParams(r105);
        View r107 = r100.f150622a;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L16:
        r107.setVisibility(0);
    L17:
        LivePromotionCardArgsV2 r108 = r100.f150626e;
        if (r108 == null) goto L54;
        ILivePromotionCardContainerHandler r109 = r108.f150038b;
        if (r109 == null) goto L55;
        Function0<com.bytedance.android.ec.common.api.jump.model.g> r110 = r108.f150475k;
        if (r110 == null) goto L27;
        com.bytedance.android.ec.common.api.jump.model.g r111 = r110.invoke();
        if (r111 == null) goto L27;
        r104 = r111.f42873a;
    L27:
        if (r109.i(r104, 2, false) == true) goto L29;
        return;
    L29:
        if (r101 <= r100.getBasicWidth()) goto L40;
        float r112 = (int) (r101 - r100.getBasicWidth());
        Resources r113 = Resources.getSystem();
        float r114 = 200 + (13 * (r112 / WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics()).density));
        float r115 = r100.getBasicWidth() / r101;
        View r116 = r100.f150622a;
        if (r116 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L33:
        r116.setPivotX(0.0f);
        View r117 = r100.f150622a;
        if (r117 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L36:
        r117.setScaleX(r115);
        View r118 = r100.f150622a;
        if (r118 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L39:
        r118.animate().scaleX(1.0f).setDuration((long) r114).setInterpolator(new PathInterpolator(0.0f, 0.46f, 0.25f, 1.0f)).withEndAction(new j(r100)).start();
    L40:
        ECLottieAnimationView r119 = r100.f150624c;
        if (r119 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L43:
        r119.setAnimation("ec_live_list_card_seckill_progress.json");
        ECLottieAnimationView r120 = r100.f150624c;
        if (r120 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L46:
        r120.setRepeatCount(0);
        ECLottieAnimationView r121 = r100.f150624c;
        if (r121 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L49:
        r121.playAnimation();
        ECLottieAnimationView r122 = r100.f150624c;
        if (r122 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L52:
        r122.addAnimatorListener(new k(r100));
        return;
    L55:
        return;
    }

    public ECStockProgressLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = th.a.c(r100, R.layout.shopping_layout_promotion_card_seckill_stock_progress_v2, this, true);
        r103.setBackgroundResource(R.drawable.ec_bg_stock_progress_background);
        this.f150622a = r103.findViewById(R.id.ec_bg_seckill_stock_progress);
        this.f150624c = (ECLottieAnimationView) r103.findViewById(R.id.lottie_ec_bg_seckill_stock_progress_tail);
        this.f150623b = (TextView) r103.findViewById(R.id.ec_tv_seckill_progress_des);
        this.f150625d = (TextView) r103.findViewById(R.id.ec_ic_seckill_stock_label);
        this.f150627f = LazyKt.lazy(ECStockProgressLayout$isLargeMode$2.INSTANCE);
        this.f150628g = LazyKt.lazy(new ECStockProgressLayout$basicWidth$2(this));
        this.f150629h = 10.0f;
    }

    public final void c(String r100, Float r101, String r102) {
        setLabel(r102);
        post(new l(this, r101, r100));
        setTxStockDes(r100);
    }

    public /* synthetic */ ECStockProgressLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
