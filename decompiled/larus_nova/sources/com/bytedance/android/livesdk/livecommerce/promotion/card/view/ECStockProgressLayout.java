package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/view/ECStockProgressLayout;", "Landroid/widget/FrameLayout;", "", "progressText", "", "setTxStockDes", "label", "setLabel", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStockProgressLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressBar f150388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f150389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f150390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f150391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECNewCountDownView f150392e;

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

    private final void setLabel(String r100) {
        TextView r101 = this.f150391d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L5:
        r101.setContentDescription(r100);
        if (TextUtils.isEmpty(r100) == false) goto L11;
        TextView r102 = this.f150391d;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L10:
        r102.setVisibility(4);
        return;
    L11:
        TextView r103 = this.f150391d;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L15:
        if (Intrinsics.areEqual(r103.getText(), r100) == false) goto L21;
        TextView r104 = this.f150391d;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L20:
        if (r104.getVisibility() != 0) goto L21;
        return;
    L21:
        TextView r105 = this.f150391d;
        if (r105 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L24:
        r105.setText(r100);
        TextView r106 = this.f150391d;
        if (r106 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L27:
        r106.setVisibility(4);
    }

    private final void setTxStockDes(String r100) {
        TextView r101 = this.f150390c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L5:
        r101.setContentDescription(r100);
        if (TextUtils.isEmpty(r100) == false) goto L11;
        TextView r102 = this.f150390c;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L10:
        r102.setVisibility(8);
        return;
    L11:
        TextView r103 = this.f150390c;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L14:
        r103.setVisibility(0);
        ECNewCountDownView r104 = this.f150392e;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("countDownView");
    L17:
        r104.setVisibility(8);
        TextView r105 = this.f150390c;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L20:
        r105.setText(r100);
    }

    public static final void a(ECStockProgressLayout r100, float r101) {
        ProgressBar r102 = r100.f150388a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
    L5:
        r102.setProgressDrawable(th.a.b(r100.getContext(), R.drawable.ec_stock_progress_layer_list_opt));
        ImageView r103 = r100.f150389b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L8:
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof FrameLayout.LayoutParams) == true) goto L11;
        r104 = null;
    L11:
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r104;
        if (r105 == null) goto L21;
        r105.width = (int) r101;
        ImageView r106 = r100.f150389b;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L16:
        r106.setLayoutParams(r105);
        ImageView r107 = r100.f150389b;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L19:
        r107.setVisibility(0);
        return;
    }

    public ECStockProgressLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = th.a.c(r100, R.layout.shopping_layout_promotion_card_seckill_stock_progress, this, true);
        this.f150388a = (ProgressBar) r103.findViewById(R.id.ec_progressbar_seckill_stock_progress);
        this.f150389b = (ImageView) r103.findViewById(R.id.ec_bg_seckill_stock_progress);
        this.f150390c = (TextView) r103.findViewById(R.id.ec_tv_seckill_progress_des);
        this.f150391d = (TextView) r103.findViewById(R.id.ec_ic_seckill_stock_label);
        this.f150392e = (ECNewCountDownView) r103.findViewById(R.id.new_countdown_view);
    }

    public /* synthetic */ ECStockProgressLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(String r100, long r101, long r110, String r111) {
        setLabel(r111);
        post(new d(this, r101, r110));
        setTxStockDes(r100);
    }
}
