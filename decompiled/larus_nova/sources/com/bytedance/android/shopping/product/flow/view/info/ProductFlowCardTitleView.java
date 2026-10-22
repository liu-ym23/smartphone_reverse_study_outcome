package com.bytedance.android.shopping.product.flow.view.info;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.p1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardTitleView;", "Landroid/widget/FrameLayout;", "", "visible", "", "setArrowStyleVisible", "", "maxLine", "setMaxLine", GXTemplateKey.STYLE_FONT_LINES, "setLines", "isBold", "setTextStyle", "iconMarginRight", "setIconMarginRight", "", "textAndIconSizeDP", "setTextAndIconSizeDP", "extra", "setLineSpacingExtra", "Landroid/widget/TextView;", "getTextview", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFlowCardTitleView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f182396d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f182397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f182398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f182399c;

    public static final class a {
    }

    static {
    }

    public ProductFlowCardTitleView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductFlowCardTitleView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setIconMarginRight(int r100) {
    }

    public final TextView getTextview() {
        return this.f182397a;
    }

    public final void setArrowStyleVisible(boolean r100) {
        if (r100 == false) goto L4;
        this.f182398b.setVisibility(0);
        return;
    L4:
        this.f182398b.setVisibility(8);
    }

    public final void setLineSpacingExtra(float r100) {
        this.f182397a.setLineSpacing(r100, 1.0f);
    }

    public final void setLines(int r100) {
        this.f182397a.setLines(r100);
    }

    public final void setMaxLine(int r100) {
        this.f182397a.setMaxLines(r100);
    }

    public final void setTextAndIconSizeDP(float r100) {
        this.f182397a.setTextSize(1, r100);
    }

    public final void setTextStyle(boolean r100) {
        if (r100 == false) goto L4;
        this.f182397a.setTypeface(Typeface.defaultFromStyle(1));
        return;
    L4:
        this.f182397a.setTypeface(Typeface.defaultFromStyle(0));
    }

    public ProductFlowCardTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Resources r103 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 3, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r104 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_product_flow_card_title_view, this, true);
    L6:
        TextView r105 = (TextView) findViewById(R.id.product_flow_card_title);
        this.f182397a = r105;
        this.f182398b = findViewById(R.id.product_flow_card_title_arrow);
        int r106 = g1.f45599a;
        r105.setTextColor(g1.a.a(r100, R.color.TextReverse));
        return;
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_product_flow_card_title_view, this, true);
        goto L6
    }

    public final void a(String r100, ECUrlModel r101, ECUrlModel r102) {
        ArrayList r103 = new ArrayList();
        if (r102 == null) goto L5;
        r103.add(r102);
    L5:
        if (r101 == null) goto L7;
        r103.add(r101);
    L7:
        int r104 = 14;
        if (r101 == null) goto L10;
        int r105 = r101.getHeight();
    L11:
        if (r105 <= 0) goto L14;
        r104 = r105;
    L14:
        p1 r106 = p1.f45668d;
        TextView r107 = this.f182397a;
        Float r108 = Float.valueOf(4.0f);
        r106.getClass();
        Disposable r109 = p1.a(r103, r100, 4.0f, r104, r107, r108);
        if (r109 == null) goto L18;
        this.f182399c = r109;
        return;
    L18:
        return;
    L10:
        r105 = 14;
        goto L11
    }

    public /* synthetic */ ProductFlowCardTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
