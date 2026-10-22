package com.bytedance.android.shopping.mall.homepage.card.product;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ProductStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.Shape;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.TextBaseUIParams;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p93.b;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/product/ProductTextView;", "Lcom/bytedance/android/shopping/mall/homepage/card/product/BreakLineFeedText;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductTextView extends BreakLineFeedText {
    public ProductTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final void x(ProductStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "uiParams");
        b.f528293d.getClass();
        Intrinsics.checkNotNullParameter(this, "$this$updatePadding");
        Float r101 = r100.getPaddingLeft();
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = b.f(r101, getContext());
    L6:
        Float r104 = r100.getPaddingTop();
        if (r104 == null) goto L9;
        int r105 = b.f(r104, getContext());
    L10:
        Float r106 = r100.getPaddingRight();
        if (r106 == null) goto L13;
        int r107 = b.f(r106, getContext());
    L14:
        Float r108 = r100.getPaddingBottom();
        if (r108 == null) goto L17;
        int r109 = b.f(r108, getContext());
    L18:
        setPadding(r103, r105, r107, r109);
        ViewGroup.LayoutParams r110 = getLayoutParams();
        Context r111 = getContext();
        Intrinsics.checkNotNullParameter(r110, "$this$updateMargin");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == true) goto L21;
        ViewGroup.LayoutParams r112 = null;
    L22:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        if (r113 == null) goto L40;
        Float r114 = r100.getMarginLeft();
        if (r114 == null) goto L27;
        int r115 = b.f(r114, r111);
    L28:
        Float r116 = r100.getMarginTop();
        if (r116 == null) goto L31;
        int r117 = b.f(r116, r111);
    L32:
        Float r118 = r100.getMarginRight();
        if (r118 == null) goto L35;
        int r119 = b.f(r118, r111);
    L36:
        Float r120 = r100.getMarginBottom();
        if (r120 == null) goto L39;
        r102 = b.f(r120, r111);
    L39:
        r113.setMargins(r115, r117, r119, r102);
        goto L40
    L35:
        r119 = 0;
        goto L36
    L31:
        r117 = 0;
        goto L32
    L27:
        r115 = 0;
    L40:
        setLayoutParams(r110);
        return;
    L21:
        r112 = r110;
        goto L22
    L17:
        r109 = 0;
        goto L18
    L13:
        r107 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final void y(TextBaseUIParams r100) {
        if (r100 == null) goto L16;
        String r101 = r100.getContent();
        if (r101 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L16;
        setVisibility(0);
        setText(r100.getContent());
        ProductStyle r103 = r100.getStyle();
        if (r103 == null) goto L18;
        z(r103);
        x(r103);
        return;
    L18:
        return;
    L6:
        if (r101.length() == 0) goto L9;
        r102 = false;
    L16:
        setVisibility(8);
    }

    public final void z(ProductStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "uiParams");
        Float r101 = r100.getFontSize();
        if (r101 == null) goto L5;
        float r102 = r101.floatValue();
        int r103 = c.f47296a;
        setTextSize(1, c.b(Float.valueOf(r102), getContext()));
    L5:
        String r104 = r100.getEllipsize();
        if (r104 == null) goto L25;
        b.f528293d.getClass();
        Intrinsics.checkNotNullParameter(r104, "$this$toEllipsize");
        switch(r104.hashCode()) {
            case -1074341483: goto L20;
            case 100571: goto L17;
            case 109757538: goto L14;
            case 839444514: goto L11;
            default: goto L22;
        };
    L22:
        TextUtils.TruncateAt r105 = null;
    L23:
        if (r105 == null) goto L25;
        setEllipsize(r105);
        goto L25
    L11:
        if (r104.equals("marquee") == false) goto L22;
        r105 = TextUtils.TruncateAt.MARQUEE;
        goto L23
    L14:
        if (r104.equals("start") == false) goto L22;
        r105 = TextUtils.TruncateAt.START;
        goto L23
    L17:
        if (r104.equals("end") == false) goto L22;
        r105 = TextUtils.TruncateAt.END;
        goto L23
    L20:
        if (r104.equals("middle") == false) goto L22;
        r105 = TextUtils.TruncateAt.MIDDLE;
    L25:
        String r106 = r100.getFontFamily();
        Integer r107 = r100.getFontWeight();
        if (r106 != null) goto L29;
        if (r107 != null) goto L29;
    L37:
        String r108 = r100.getColor();
        if (r108 == null) goto L43;
        b.f528293d.getClass();
        Integer r109 = b.e(r108);
        if (r109 == null) goto L43;
        setTextColor(r109.intValue());
    L43:
        if (r100.getShape() == null) goto L63;
        Shape r110 = r100.getShape();
        if (r110 == null) goto L68;
        b r111 = b.f528293d;
        String r112 = r110.getShapeColor();
        r111.getClass();
        Integer r113 = b.e(r112);
        Integer r114 = b.e(r110.getStrokeColor());
        float[] r115 = new float[4];
        List<Float> r116 = r110.getShapeRadius();
        if (r116 == null) goto L50;
        r115[0] = b0.c(Float.valueOf(b.c(r116, 0)));
        r115[1] = b0.c(Float.valueOf(b.c(r116, 1)));
        r115[2] = b0.c(Float.valueOf(b.c(r116, 2)));
        r115[3] = b0.c(Float.valueOf(b.c(r116, 3)));
    L50:
        Float r117 = r110.getStrokeWidth();
        if (r117 == null) goto L53;
        float r118 = r117.floatValue();
    L54:
        int r119 = -1;
        if (r113 == null) goto L57;
        int r120 = r113.intValue();
    L58:
        if (r114 == null) goto L60;
        r119 = r114.intValue();
    L60:
        GradientDrawable r121 = b.a(r120, r119, (int) r118, r115);
        if (r121 == null) goto L68;
        setBackground(r121);
        goto L68
    L57:
        r120 = -1;
        goto L58
    L53:
        r118 = 0.0f;
    L68:
        Integer r122 = r100.getMaxLine();
        if (r122 == null) goto L72;
        setMaxLines(r122.intValue());
        return;
    L72:
        return;
    L63:
        String r123 = r100.getBackGround();
        if (r123 == null) goto L68;
        b.f528293d.getClass();
        Integer r124 = b.e(r123);
        if (r124 == null) goto L68;
        setBackgroundColor(r124.intValue());
    L29:
        if (r106 == null) goto L33;
        b r125 = b.f528293d;
        Context r126 = getContext();
        r125.getClass();
        Typeface r127 = b.d(r106, r126, r107);
        if (r127 == null) goto L37;
        setTypeface(r127);
        goto L37
    L33:
        if (r107 == null) goto L37;
        int r128 = r107.intValue();
        if (Build.VERSION.SDK_INT < 28) goto L37;
        setTypeface(Typeface.create(getTypeface(), r128, getTypeface().isItalic()));
        goto L37
    }

    public ProductTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public ProductTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
