package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ColorPattern;
import com.bytedance.android.ec.model.DivLinePattern;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.TextPattern;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECBenefitLabelView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "label", "", "setTextStyle", "setColorStyle", "setDivLineStyle", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBenefitLabelView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f45899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f45900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f45901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECNetImageView f45902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VerticalDashLineView f45903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f45904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f45905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f45906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f45907i;

    public static final class a {
    }

    static {
    }

    public ECBenefitLabelView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECBenefitLabelView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setColorStyle(PromotionBenefitLabel r110) {
        Intrinsics.checkNotNullParameter(r110, "label");
        if (r110.getColorStyle() != this.f45906h) goto L5;
        return;
    L5:
        ColorPattern r100 = r110.getColorPattern();
        if (r100 != null) goto L8;
        return;
    L8:
        int r101 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r102 = com.bytedance.android.ec.core.utils.s.b(r100.getLeftTextColor());
        if (r102 == null) goto L11;
        this.f45899a.setTextColor(r102.intValue());
    L11:
        Integer r103 = com.bytedance.android.ec.core.utils.s.b(r100.getLeftBgColor());
        if (r103 == null) goto L14;
        int r104 = r103.intValue();
        TextView r111 = this.f45899a;
        float r112 = vf4.a.b(2);
        GradientDrawable r105 = new GradientDrawable();
        r105.setColor(r104);
        r105.setCornerRadii(new float[]{r112, r112, 0.0f, 0.0f, 0.0f, 0.0f, r112, r112});
        r111.setBackgroundDrawable(r105);
    L15:
        Integer r106 = com.bytedance.android.ec.core.utils.s.b(r100.getRightTextColor());
        if (r106 == null) goto L18;
        this.f45900b.setTextColor(r106.intValue());
    L18:
        Integer r107 = com.bytedance.android.ec.core.utils.s.b(r100.getRightBgColor());
        if (r107 == null) goto L21;
        int r108 = r107.intValue();
        LinearLayout r109 = this.f45901c;
        float r113 = vf4.a.b(2);
        GradientDrawable r114 = new GradientDrawable();
        r114.setColor(r108);
        r114.setCornerRadii(new float[]{0.0f, 0.0f, r113, r113, r113, r113, 0.0f, 0.0f});
        r109.setBackgroundDrawable(r114);
    L22:
        Integer r115 = com.bytedance.android.ec.core.utils.s.b(r100.getBorderColor());
        if (r115 == null) goto L25;
        int r116 = r115.intValue();
        View r117 = this.f45904f;
        float r118 = vf4.a.b(2);
        GradientDrawable r119 = new GradientDrawable();
        r119.setStroke(2, r116);
        r119.setCornerRadius(r118);
        r117.setBackgroundDrawable(r119);
        return;
    L25:
        this.f45904f.setBackgroundDrawable(null);
        return;
    L21:
        this.f45901c.setBackgroundDrawable(null);
        goto L22
    L14:
        this.f45899a.setBackgroundDrawable(null);
        goto L15
    }

    public final void setDivLineStyle(PromotionBenefitLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "label");
        if (r100.getDivLineStyle() != this.f45907i) goto L5;
        return;
    L5:
        DivLinePattern r101 = r100.getDivLinePattern();
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = 0;
        boolean r103 = true;
        if (r101.getStyle() == 1) goto L12;
        r103 = false;
    L12:
        VerticalDashLineView r104 = this.f45903e;
        float r105 = 0.0f;
        if (r103 == false) goto L15;
        float r106 = vf4.a.b(2);
    L16:
        if (r103 == false) goto L18;
        r105 = vf4.a.b(2);
    L18:
        r104.a(2.0f, r106, r105, (vf4.a.b(2) / 2) + 2);
        int r107 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r108 = com.bytedance.android.ec.core.utils.s.b(r101.getDivLineColor());
        if (r108 == null) goto L21;
        this.f45903e.setDashLineColor(r108.intValue());
    L21:
        int r109 = r101.getDivLineHeight();
        TextPattern r110 = r100.getTextPattern();
        if (r110 != null) goto L24;
    L26:
        this.f45903e.getLayoutParams().height = vf4.a.b(Integer.valueOf(r101.getDivLineHeight())) - r102;
        return;
    L24:
        if (r109 != r110.getHeight()) goto L26;
        r102 = 4;
        goto L26
    L15:
        r106 = 0.0f;
        goto L16
    }

    public final void setTextStyle(PromotionBenefitLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "label");
        if (r100.getTextStyle() != this.f45905g) goto L5;
        return;
    L5:
        TextPattern r101 = r100.getTextPattern();
        if (r101 != null) goto L8;
        return;
    L8:
        this.f45905g = r100.getTextStyle();
        getLayoutParams().height = vf4.a.b(Integer.valueOf(r101.getHeight()));
        this.f45899a.setTextSize(0, vf4.a.b(Integer.valueOf(r101.getTextSize())));
        this.f45900b.setTextSize(0, vf4.a.b(Integer.valueOf(r101.getTextSize())));
        int r102 = vf4.a.b(Integer.valueOf(r101.getInnerPadding()));
        this.f45899a.setPadding(r102, 0, r102, 0);
        this.f45901c.setPadding(r102, 0, r102, 0);
    }

    public final void a(PromotionBenefitLabel r100, StringBuilder r101) {
        Intrinsics.checkNotNullParameter(r100, "label");
        com.bytedance.android.ec.core.utils.r.a(r100);
        if (r100.getTextPattern() != null) goto L5;
    L33:
        setVisibility(8);
        return;
    L5:
        if (r100.getColorPattern() == null) goto L33;
        if (r100.getDivLinePattern() == null) goto L33;
        String r102 = r100.getLeftText();
        if (r102 != null) goto L12;
    L23:
        this.f45899a.setVisibility(8);
        this.f45903e.setVisibility(8);
    L24:
        this.f45900b.setText(r100.getRightText());
        if (r101 == null) goto L27;
        r101.append(r100.getRightText());
    L27:
        ECUrlModel r103 = r100.getRightIcon();
        if (r103 == null) goto L30;
        com.bytedance.android.ec.core.utils.y.a(this.f45902d, r103);
        ViewGroup.LayoutParams r104 = this.f45902d.getLayoutParams();
        r104.width = vf4.a.b(Integer.valueOf(r103.getWidth()));
        ViewGroup.LayoutParams r105 = this.f45902d.getLayoutParams();
        r105.height = vf4.a.b(Integer.valueOf(r103.getHeight()));
        this.f45902d.setVisibility(0);
    L31:
        setTextStyle(r100);
        setColorStyle(r100);
        setDivLineStyle(r100);
        return;
    L30:
        this.f45902d.setVisibility(8);
        goto L31
    L12:
        if (r102.length() <= 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L18;
        r102 = null;
    L18:
        if (r102 == null) goto L23;
        this.f45899a.setText(r102);
        if (r101 == null) goto L22;
        r101.append(r102);
    L22:
        this.f45899a.setVisibility(0);
        this.f45903e.setVisibility(0);
        goto L24
    L14:
        r106 = false;
        goto L15
    }

    public ECBenefitLabelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f45905g = -1;
        this.f45906h = -1;
        this.f45907i = -1;
        ShoppingAsyncInflater.f45268e.getClass();
        View r103 = ShoppingAsyncInflater.a.a(r100).aU(R.layout.shopping_layout_benefit_label_item, this, false);
        addView(r103);
        this.f45899a = (TextView) r103.findViewById(R.id.label_left_text);
        this.f45900b = (TextView) r103.findViewById(R.id.label_right_text);
        this.f45901c = (LinearLayout) r103.findViewById(R.id.coupon_right);
        this.f45902d = (ECNetImageView) r103.findViewById(R.id.label_icon);
        this.f45903e = (VerticalDashLineView) r103.findViewById(R.id.label_divider);
        this.f45904f = r103.findViewById(R.id.label_stroke);
        com.bytedance.android.ec.core.utils.a.f(this);
    }

    public /* synthetic */ ECBenefitLabelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
