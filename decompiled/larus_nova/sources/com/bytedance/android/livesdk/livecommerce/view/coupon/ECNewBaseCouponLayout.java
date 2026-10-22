package com.bytedance.android.livesdk.livecommerce.view.coupon;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.bytedance.android.livesdk.livecommerce.view.ECPriceView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import si2.p;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewBaseCouponLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECNewBaseCouponLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f153230a;

    public ECNewBaseCouponLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECNewBaseCouponLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public View a(int r100) {
        if (this.f153230a != null) goto L5;
        this.f153230a = new LinkedHashMap();
    L5:
        View r101 = this.f153230a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f153230a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public void b(p r110) {
        Intrinsics.checkNotNullParameter(r110, "ecuiCoupon");
        boolean r100 = true;
        ((TextView) a(R.id.ec_new_coupon_num)).setText(getContext().getResources().getString(R.string.ec_coupon_res, new Object[]{Integer.valueOf(r110.f542197i)}));
        ((TextView) a(R.id.ec_new_coupon_limit)).setText(r110.f542196h);
        TextView r101 = (TextView) a(R.id.ec_new_coupon_time);
        if (r110.f542194f != 1) goto L5;
        String r102 = r110.f542193e;
    L6:
        r101.setText(r102);
        float r103 = 30.0f;
        if (r110.f542189a != 1) goto L9;
        ((TextView) a(R.id.ec_new_coupon_l)).setVisibility(8);
        ((LinearLayout) a(R.id.ec_new_coupon_normal)).setVisibility(8);
        ((RelativeLayout) a(R.id.ec_new_coupon_discount_wrapper)).setVisibility(0);
        String r104 = k.g(MathKt.roundToLong(r110.f542190b * ((double) 100)));
        TextView r105 = (TextView) a(R.id.ec_new_coupon_discount);
        SpannableString r106 = new SpannableString(r104 + getContext().getString(R.string.ec_zhe_text));
        r106.setSpan(new AbsoluteSizeSpan(w0.a(30.0f)), 0, r104.length(), 17);
        r106.setSpan(new StyleSpan(1), 0, r104.length(), 17);
        r106.setSpan(new AbsoluteSizeSpan(w0.a(11.0f)), r104.length(), r104.length() + 1, 17);
        Unit r107 = Unit.INSTANCE;
        r105.setText(r106);
    L32:
        String r108 = r110.f542203o;
        if (r108 == null) goto L39;
        if (r108.length() == 0) goto L39;
        r100 = false;
    L39:
        if (r100 == false) goto L44;
        ViewGroup.LayoutParams r111 = ((ECNetImageView) a(R.id.ec_coupon_left_top_icon)).getLayoutParams();
        if (r111 == null) goto L43;
        r111.width = w0.a(26.0f);
        r111.height = w0.a(28.0f);
    L43:
        ((ECNetImageView) a(R.id.ec_coupon_left_top_icon)).setVisibility(0);
        ((ECNetImageView) a(R.id.ec_coupon_left_top_icon)).setImageResource(R.drawable.ec_new_coupon_douyin_icon);
        return;
    L44:
        ((ECNetImageView) a(R.id.ec_coupon_left_top_icon)).setVisibility(0);
        ViewGroup.LayoutParams r109 = ((ECNetImageView) a(R.id.ec_coupon_left_top_icon)).getLayoutParams();
        if (r109 == null) goto L47;
        r109.width = w0.a(r110.f542204p);
        r109.height = w0.a(r110.f542205q);
    L47:
        ECLiveImageUtils.i((SimpleDraweeView) a(R.id.ec_coupon_left_top_icon), r110.f542203o, 0, 0);
        return;
    L9:
        ((LinearLayout) a(R.id.ec_new_coupon_normal)).setVisibility(0);
        ((TextView) a(R.id.ec_new_coupon_l)).setVisibility(0);
        ((RelativeLayout) a(R.id.ec_new_coupon_discount_wrapper)).setVisibility(8);
        String r112 = String.valueOf(r110.f542191c);
        ECPriceView r113 = (ECPriceView) a(R.id.ec_new_coupon_price);
        int r114 = r112.length();
        float r115 = 18.0f;
        if (r114 == 1) goto L19;
        if (r114 == 2) goto L19;
        if (r114 == 3) goto L18;
        if (r114 == 4) goto L17;
        if (r114 == 5) goto L16;
        r103 = 11.0f;
        goto L19
    L16:
        r103 = 16.0f;
        goto L19
    L17:
        r103 = 18.0f;
        goto L19
    L18:
        r103 = 24.0f;
    L19:
        r113.setPriceTextSize(w0.a(r103));
        ECPriceView r116 = (ECPriceView) a(R.id.ec_new_coupon_price);
        int r117 = r112.length();
        if (r117 == 1) goto L28;
        if (r117 == 2) goto L28;
        if (r117 == 3) goto L27;
        if (r117 == 4) goto L26;
        if (r117 == 5) goto L26;
        r115 = 10.0f;
    L26:
        r115 = 12.0f;
        goto L28
    L27:
        r115 = 14.0f;
    L28:
        r116.setYangTextSize(w0.a(r115));
        ((ECPriceView) a(R.id.ec_new_coupon_price)).setPriceText(r112);
        if (r110.f542189a != 2) goto L31;
        ((TextView) a(R.id.ec_new_coupon_l)).setText(getContext().getResources().getString(R.string.ec_decrease_coupon_no_limit));
        goto L32
    L31:
        ((TextView) a(R.id.ec_new_coupon_l)).setText(getContext().getResources().getString(R.string.ec_decrease_coupon_limit, new Object[]{Integer.valueOf(r110.f542192d)}));
        goto L32
    L5:
        r102 = getContext().getResources().getString(R.string.ec_valid_period, new Object[]{Integer.valueOf(r110.f542195g)});
        goto L6
    }

    public ECNewBaseCouponLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f153230a = new LinkedHashMap();
        View.inflate(r100, R.layout.ec_new_coupon_layout, this);
        ((ImageView) a(R.id.ec_coupon_logo)).setVisibility(0);
        ViewGroup.LayoutParams r103 = ((RelativeLayout) a(R.id.tv_right_layout)).getLayoutParams();
        if (r103 == null) goto L11;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        r104.topMargin = w0.a(5.0f);
        ((RelativeLayout) a(R.id.tv_right_layout)).setLayoutParams(r104);
        ViewGroup.LayoutParams r105 = ((RelativeLayout) a(R.id.tv_left_wrapper)).getLayoutParams();
        if (r105 == null) goto L9;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        r106.topMargin = w0.a(5.0f);
        ((RelativeLayout) a(R.id.tv_left_wrapper)).setLayoutParams(r106);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public /* synthetic */ ECNewBaseCouponLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
