package com.bytedance.android.ec.core.widget;

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

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECCouponView;", "Landroid/widget/LinearLayout;", "", GXTemplateKey.FLEXBOX_PADDING, "", "setPaddingVertical", "setPaddingHorizontal", "uiType", "setCouponUIStyle", "(Ljava/lang/Integer;)V", "color", "setPrefixBackgroundColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCouponView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f45911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f45912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f45913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f45914d;

    public ECCouponView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECCouponView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setCouponUIStyle(Integer r100) {
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
        TextView r101 = this.f45912b;
        if (r101 == null) goto L32;
        r101.setTextColor(getContext().getResources().getColor(R.color.ec_color_white));
    L32:
        TextView r102 = this.f45912b;
        if (r102 == null) goto L35;
        r102.setBackgroundResource(R.drawable.ec_common_coupon_strong_bg_header);
    L35:
        View r103 = this.f45914d;
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
        TextView r104 = this.f45912b;
        if (r104 == null) goto L14;
        r104.setTextColor(getContext().getResources().getColor(R.color.ec_color_black));
    L14:
        TextView r105 = this.f45912b;
        if (r105 == null) goto L17;
        r105.setBackgroundResource(R.drawable.ecommerce_coupon_item_left);
    L17:
        View r106 = this.f45914d;
        if (r106 == null) goto L39;
        r106.setBackgroundResource(R.drawable.ecommerce_coupon_item_border);
        return;
    L39:
        return;
    L5:
        if (r100.intValue() != 0) goto L7;
        goto L7
    }

    public final void setPaddingHorizontal(int r100) {
        TextView r101 = this.f45912b;
        if (r101 == null) goto L5;
        r101.setPadding(r100, r101.getPaddingTop(), r100, r101.getPaddingBottom());
    L5:
        TextView r102 = this.f45911a;
        if (r102 == null) goto L9;
        r102.setPadding(r100, r102.getPaddingTop(), r100, r102.getPaddingBottom());
        return;
    }

    public final void setPaddingVertical(int r100) {
        TextView r101 = this.f45912b;
        if (r101 == null) goto L5;
        r101.setPadding(r101.getPaddingLeft(), r100, r101.getPaddingRight(), r100);
    L5:
        TextView r102 = this.f45911a;
        if (r102 == null) goto L9;
        r102.setPadding(r102.getPaddingLeft(), r100, r102.getPaddingRight(), r100);
        return;
    }

    public final void setPrefixBackgroundColor(int r100) {
        float r101 = UIUtils.dip2Px(getContext(), 2.0f);
        TextView r102 = this.f45912b;
        if (r102 == null) goto L6;
        GradientDrawable r103 = new GradientDrawable();
        r103.setColor(r100);
        r103.setCornerRadii(new float[]{r101, r101, 0.0f, 0.0f, 0.0f, 0.0f, r101, r101});
        Unit r104 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "$this$setBackgroundCompat");
        r102.setBackground(r103);
        return;
    }

    public ECCouponView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        View r103 = ShoppingAsyncInflater.a.a(r100).aU(R.layout.ecommerce_coupon_item_layout, this, true);
        this.f45911a = (TextView) r103.findViewById(R.id.coupon_tag);
        this.f45912b = (TextView) r103.findViewById(R.id.coupon_prefix);
        this.f45913c = (ImageView) r103.findViewById(R.id.coupon_divider);
        this.f45914d = r103.findViewById(R.id.coupon_stroke);
        ImageView r104 = (ImageView) r103.findViewById(R.id.coupon_arrow);
    }

    public /* synthetic */ ECCouponView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void a(ECCouponView r100, String r101, String r102, boolean r103, Integer r104, int r105) {
        boolean r106 = false;
        if ((r105 & 4) == 0) goto L6;
        r103 = false;
    L6:
        if ((r105 & 16) == 0) goto L8;
        r104 = 0;
    L8:
        TextView r107 = r100.f45912b;
        if (r107 == null) goto L11;
        r107.setVisibility(0);
    L11:
        ImageView r108 = r100.f45913c;
        if (r108 == null) goto L14;
        r108.setVisibility(0);
    L14:
        TextView r109 = r100.f45911a;
        if (r109 == null) goto L17;
        r109.setVisibility(0);
    L17:
        Context r110 = r100.getContext();
        if (r110 == null) goto L26;
        if (r103 == false) goto L26;
        TextView r111 = r100.f45911a;
        if (r111 == null) goto L23;
        r111.setBackgroundResource(R.drawable.ecommerce_coupon_item_right_fill_color);
    L23:
        TextView r112 = r100.f45911a;
        if (r112 == null) goto L26;
        r112.setPadding((int) UIUtils.dip2Px(r110, 8.0f), 0, (int) UIUtils.dip2Px(r110, 8.0f), 0);
    L26:
        TextView r113 = r100.f45911a;
        if (r113 == null) goto L29;
        r113.setText(r101);
    L29:
        if (r102 != null) goto L31;
    L32:
        r106 = true;
    L34:
        if (r106 == true) goto L41;
        TextView r114 = r100.f45912b;
        if (r114 == null) goto L38;
        r114.setText(r102);
    L38:
        View r115 = r100.f45914d;
        if (r115 == null) goto L54;
        r115.setBackgroundResource(R.drawable.ecommerce_coupon_item_border);
    L54:
        r100.setCouponUIStyle(r104);
        r100.requestLayout();
        return;
    L41:
        TextView r116 = r100.f45912b;
        if (r116 == null) goto L44;
        r116.setVisibility(8);
    L44:
        ImageView r117 = r100.f45913c;
        if (r117 == null) goto L47;
        r117.setVisibility(8);
    L47:
        if (r103 == false) goto L51;
        View r118 = r100.f45914d;
        if (r118 == null) goto L54;
        r118.setBackgroundResource(R.drawable.ecommerce_coupon_item_fill_color);
        goto L54
    L51:
        View r119 = r100.f45914d;
        if (r119 == null) goto L54;
        r119.setBackgroundResource(R.drawable.ecommerce_coupon_item_border);
        goto L54
    L31:
        if (r102.length() != 0) goto L34;
        goto L32
    }
}
