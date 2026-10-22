package com.bytedance.android.ec.window.base.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/window/base/view/ECWindowCouponView;", "Landroid/widget/LinearLayout;", "", "uiType", "", "setCouponUIStyle", "(Ljava/lang/Integer;)V", "color", "setTextColor", GXTemplateKey.FLEXBOX_PADDING, "setPaddingVertical", "setPrefixBackgroundColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowCouponView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f49795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f49796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f49797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f49798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f49799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f49800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f49801g;

    public ECWindowCouponView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECWindowCouponView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final void setCouponUIStyle(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L20:
        if (r100 != null) goto L23;
    L25:
        if (r100 != null) goto L28;
        return;
    L28:
        if (r100.intValue() != 3) goto L41;
    L29:
        TextView r101 = this.f49796b;
        if (r101 == null) goto L32;
        r101.setTextColor(getContext().getResources().getColor(R.color.ec_color_white));
    L32:
        TextView r102 = this.f49796b;
        if (r102 == null) goto L35;
        r102.setBackgroundResource(R.drawable.ec_common_coupon_strong_bg_header);
    L35:
        View r103 = this.f49798d;
        if (r103 == null) goto L42;
        r103.setBackgroundResource(R.drawable.ec_common_coupon_strong_border);
        return;
    L42:
        return;
    L41:
        return;
    L23:
        if (r100.intValue() != 2) goto L25;
    L10:
        if (r100.intValue() != 1) goto L20;
    L11:
        TextView r104 = this.f49796b;
        if (r104 == null) goto L14;
        r104.setTextColor(getContext().getResources().getColor(R.color.Primary));
    L14:
        TextView r105 = this.f49796b;
        if (r105 == null) goto L17;
        r105.setBackgroundResource(R.drawable.ecommerce_coupon_item_left);
    L17:
        View r106 = this.f49798d;
        if (r106 == null) goto L39;
        r106.setBackgroundResource(R.drawable.ecommerce_coupon_item_border);
        return;
    L39:
        return;
    L5:
        if (r100.intValue() != 0) goto L7;
        goto L7
    }

    public final void setPaddingVertical(int r100) {
        TextView r101 = this.f49796b;
        if (r101 == null) goto L5;
        r101.setPadding(r101.getPaddingLeft(), r100, r101.getPaddingRight(), r100);
    L5:
        TextView r102 = this.f49795a;
        if (r102 == null) goto L9;
        r102.setPadding(r102.getPaddingLeft(), r100, r102.getPaddingRight(), r100);
        return;
    }

    public final void setPrefixBackgroundColor(int r100) {
        float r101 = UIUtils.dip2Px(getContext(), 2.0f);
        TextView r102 = this.f49796b;
        if (r102 == null) goto L6;
        GradientDrawable r103 = new GradientDrawable();
        r103.setColor(r100);
        r103.setCornerRadii(new float[]{r101, r101, 0.0f, 0.0f, 0.0f, 0.0f, r101, r101});
        Unit r104 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "$this$setBackgroundCompat");
        r102.setBackground(r103);
        return;
    }

    public final void setTextColor(int r100) {
        TextView r101 = this.f49796b;
        if (r101 == null) goto L5;
        r101.setTextColor(r100);
    L5:
        TextView r102 = this.f49795a;
        if (r102 == null) goto L9;
        r102.setTextColor(r100);
        return;
    }

    public ECWindowCouponView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        View r103 = ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_window_coupon_view_layout, this, true);
        this.f49800f = r103;
        this.f49795a = (TextView) r103.findViewById(R.id.coupon_tag);
        this.f49796b = (TextView) r103.findViewById(R.id.coupon_prefix);
        this.f49797c = (ImageView) r103.findViewById(R.id.coupon_divider);
        this.f49798d = r103.findViewById(R.id.coupon_stroke);
        this.f49801g = (ImageView) r103.findViewById(R.id.coupon_arrow);
        this.f49799e = r103.findViewById(R.id.coupon_divider_new);
    }

    public /* synthetic */ ECWindowCouponView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void a(ECWindowCouponView r100, String r101, String r102, boolean r103, boolean r104, int r105) {
        if ((r105 & 8) == 0) goto L6;
        r103 = false;
    L6:
        if ((r105 & 16) == 0) goto L9;
        r104 = false;
    L9:
        if ((r105 & 32) == 0) goto L11;
        Integer r106 = 0;
    L12:
        View r107 = r100.f49799e;
        if (r107 == null) goto L15;
        r107.setVisibility(8);
    L15:
        TextView r108 = r100.f49796b;
        if (r108 == null) goto L18;
        r108.setVisibility(0);
    L18:
        ImageView r109 = r100.f49797c;
        if (r109 == null) goto L21;
        r109.setVisibility(0);
    L21:
        TextView r110 = r100.f49795a;
        if (r110 == null) goto L24;
        r110.setVisibility(0);
    L24:
        if (r103 == false) goto L28;
        ImageView r111 = r100.f49801g;
        if (r111 == null) goto L28;
        r111.setVisibility(0);
    L28:
        r100.getContext();
        TextView r112 = r100.f49795a;
        if (r112 == null) goto L32;
        r112.setText(r101);
    L32:
        if (r102 != null) goto L34;
    L37:
        boolean r113 = true;
    L39:
        if (r113 == true) goto L46;
        TextView r114 = r100.f49796b;
        if (r114 == null) goto L43;
        r114.setText(r102);
    L43:
        View r115 = r100.f49798d;
        if (r115 == null) goto L55;
        r115.setBackgroundResource(R.drawable.ecommerce_coupon_item_border);
    L55:
        r100.setCouponUIStyle(r106);
        if (r104 == false) goto L79;
        View r116 = r100.f49798d;
        if (r116 == null) goto L60;
        r116.setBackgroundResource(R.drawable.ecommerce_coupon_item_border_new);
    L60:
        ImageView r117 = r100.f49797c;
        if (r117 != null) goto L63;
    L73:
        TextView r118 = r100.f49796b;
        if (r118 == null) goto L76;
        r118.setTextColor(th.a.f(r100.getContext()).getColor(R.color.ec_shopping_FFFF3B52));
    L76:
        TextView r119 = r100.f49795a;
        if (r119 == null) goto L79;
        r119.setTextColor(th.a.f(r100.getContext()).getColor(R.color.ec_shopping_FFFF3B52));
        goto L79
    L63:
        if (r117.getVisibility() != 0) goto L65;
        boolean r120 = true;
    L66:
        if (r120 != true) goto L73;
        ImageView r121 = r100.f49797c;
        if (r121 == null) goto L70;
        r121.setVisibility(8);
    L70:
        View r122 = r100.f49799e;
        if (r122 == null) goto L73;
        r122.setVisibility(0);
        goto L73
    L65:
        r120 = false;
    L79:
        r100.requestLayout();
        View r123 = r100.f49800f;
        if (r123 == null) goto L82;
        r123.requestLayout();
    L82:
        View r124 = r100.f49798d;
        if (r124 == null) goto L86;
        r124.requestLayout();
        return;
    L86:
        return;
    L46:
        TextView r125 = r100.f49796b;
        if (r125 == null) goto L49;
        r125.setVisibility(8);
    L49:
        ImageView r126 = r100.f49797c;
        if (r126 == null) goto L52;
        r126.setVisibility(8);
    L52:
        View r127 = r100.f49798d;
        if (r127 == null) goto L55;
        r127.setBackgroundResource(R.drawable.ecommerce_coupon_item_border);
        goto L55
    L34:
        if (r102.length() == 0) goto L37;
        r113 = false;
        goto L39
    L11:
        r106 = null;
        goto L12
    }
}
