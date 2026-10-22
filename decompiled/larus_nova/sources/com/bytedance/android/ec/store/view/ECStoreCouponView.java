package com.bytedance.android.ec.store.view;

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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECStoreCouponView;", "Landroid/widget/LinearLayout;", "", "uiType", "", "setCouponUIStyle", "(Ljava/lang/Integer;)V", "color", "setTextColor", GXTemplateKey.FLEXBOX_PADDING, "setPaddingVertical", "setPrefixBackgroundColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreCouponView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f48831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f48832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f48833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f48834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f48835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f48836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f48837g;

    public ECStoreCouponView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECStoreCouponView(Context r100, AttributeSet r101) {
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
        TextView r101 = this.f48832b;
        if (r101 == null) goto L32;
        r101.setTextColor(getContext().getResources().getColor(R.color.ec_color_white));
    L32:
        TextView r102 = this.f48832b;
        if (r102 == null) goto L35;
        r102.setBackgroundResource(R.drawable.ec_common_coupon_strong_bg_header);
    L35:
        View r103 = this.f48834d;
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
        TextView r104 = this.f48832b;
        if (r104 == null) goto L14;
        r104.setTextColor(getContext().getResources().getColor(R.color.Primary));
    L14:
        TextView r105 = this.f48832b;
        if (r105 == null) goto L17;
        r105.setBackgroundResource(R.drawable.ecommerce_coupon_item_left);
    L17:
        View r106 = this.f48834d;
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
        TextView r101 = this.f48832b;
        if (r101 == null) goto L5;
        r101.setPadding(r101.getPaddingLeft(), r100, r101.getPaddingRight(), r100);
    L5:
        TextView r102 = this.f48831a;
        if (r102 == null) goto L9;
        r102.setPadding(r102.getPaddingLeft(), r100, r102.getPaddingRight(), r100);
        return;
    }

    public final void setPrefixBackgroundColor(int r100) {
        float r101 = UIUtils.dip2Px(getContext(), 2.0f);
        TextView r102 = this.f48832b;
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
        TextView r101 = this.f48832b;
        if (r101 == null) goto L5;
        r101.setTextColor(r100);
    L5:
        TextView r102 = this.f48831a;
        if (r102 == null) goto L9;
        r102.setTextColor(r100);
        return;
    }

    public ECStoreCouponView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        View r103 = ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_store_coupon_view_layout, this, true);
        this.f48836f = r103;
        this.f48831a = (TextView) r103.findViewById(R.id.coupon_tag);
        this.f48832b = (TextView) r103.findViewById(R.id.coupon_prefix);
        this.f48833c = (ImageView) r103.findViewById(R.id.coupon_divider);
        this.f48834d = r103.findViewById(R.id.coupon_stroke);
        this.f48837g = (ImageView) r103.findViewById(R.id.coupon_arrow);
        this.f48835e = r103.findViewById(R.id.coupon_divider_new);
    }

    public /* synthetic */ ECStoreCouponView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void a(ECStoreCouponView r100, String r101, String r102, boolean r103) {
        boolean r104 = false;
        View r105 = r100.f48835e;
        if (r105 == null) goto L5;
        r105.setVisibility(8);
    L5:
        TextView r106 = r100.f48832b;
        if (r106 == null) goto L8;
        r106.setVisibility(0);
    L8:
        ImageView r107 = r100.f48833c;
        if (r107 == null) goto L11;
        r107.setVisibility(0);
    L11:
        TextView r108 = r100.f48831a;
        if (r108 == null) goto L14;
        r108.setVisibility(0);
    L14:
        if (r103 == false) goto L18;
        ImageView r109 = r100.f48837g;
        if (r109 == null) goto L18;
        r109.setVisibility(0);
    L18:
        r100.getContext();
        TextView r110 = r100.f48831a;
        if (r110 == null) goto L21;
        r110.setText(r101);
    L21:
        if (r102 != null) goto L23;
    L24:
        r104 = true;
    L26:
        if (r104 == true) goto L33;
        TextView r111 = r100.f48832b;
        if (r111 == null) goto L30;
        r111.setText(r102);
    L30:
        View r112 = r100.f48834d;
        if (r112 == null) goto L42;
        r112.setBackgroundResource(R.drawable.ecommerce_coupon_item_border);
    L42:
        r100.setCouponUIStyle(0);
        r100.requestLayout();
        View r113 = r100.f48836f;
        if (r113 == null) goto L45;
        r113.requestLayout();
    L45:
        View r114 = r100.f48834d;
        if (r114 == null) goto L49;
        r114.requestLayout();
        return;
    L49:
        return;
    L33:
        TextView r115 = r100.f48832b;
        if (r115 == null) goto L36;
        r115.setVisibility(8);
    L36:
        ImageView r116 = r100.f48833c;
        if (r116 == null) goto L39;
        r116.setVisibility(8);
    L39:
        View r117 = r100.f48834d;
        if (r117 == null) goto L42;
        r117.setBackgroundResource(R.drawable.ecommerce_coupon_item_border);
        goto L42
    L23:
        if (r102.length() != 0) goto L26;
        goto L24
    }
}
