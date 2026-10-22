package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.view.SkuContentsLayout;
import com.bytedance.android.ec.model.sku.ContentInfo;
import com.bytedance.android.ec.model.sku.SafeguardComponent;
import com.bytedance.android.ec.model.sku.TextObject;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes43.dex */
public final class t1 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f43294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SkuContentsLayout f43295h;

    public t1(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f43293f = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f43294g = (TextView) Z().b(R.id.tv_sku_header).f();
        this.f43295h = (SkuContentsLayout) Z().b(R.id.ll_sku_contents).f();
        SkuViewModel r101 = this.f43293f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r102 = r101.getSkuInfo().a();
        if (r102 == null) goto L8;
        SafeguardComponent r103 = r102.getSafeguardComponent();
    L10:
        if (r103 == null) goto L50;
        List<ContentInfo> r104 = r103.getHeaders();
        if (r104 == null) goto L50;
        ContentInfo r105 = (ContentInfo) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L50;
        TextObject r106 = r105.getTextObject();
        if (r106 == null) goto L50;
        String r107 = r106.getText();
        if (r107 == null) goto L50;
        TextView r108 = this.f43294g;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L22:
        r108.setText(r107);
        String r109 = r106.getFontColor();
        if (r109 != null) goto L68;
    L30:
        Integer r110 = r106.getFontSize();
        if (r110 == null) goto L36;
        int r111 = r110.intValue();
        TextView r112 = this.f43294g;
        if (r112 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L35:
        r112.setTextSize(r111);
    L36:
        Boolean r113 = r106.getBold();
        if (r113 == null) goto L45;
        boolean r114 = r113.booleanValue();
        TextView r115 = this.f43294g;
        if (r115 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L41:
        if (r114 == false) goto L43;
        Typeface r116 = Typeface.DEFAULT_BOLD;
    L44:
        r115.setTypeface(r116);
        goto L45
    L43:
        r116 = Typeface.DEFAULT;
    L45:
        TextView r117 = this.f43294g;
        if (r117 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L48:
        r117.setGravity(16);
        goto L50
    L68:
        TextView r118 = this.f43294g;     // Catch: Exception -> L29
        if (r118 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("header");     // Catch: Exception -> L29
    L27:
        r118.setTextColor(Color.parseColor(r109));     // Catch: Exception -> L29
    L50:
        if (r103 == null) goto L66;
        List<ContentInfo> r119 = r103.getContents();
        if (r119 == null) goto L66;
        TextView r120 = this.f43294g;
        if (r120 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L56:
        r120.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        TextView r121 = this.f43294g;
        if (r121 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("header");
    L59:
        int r122 = com.bytedance.android.ec.core.utils.k1.m(Y().c()) - r121.getMeasuredWidth();
        Resources r123 = Resources.getSystem();
        int r124 = r122 - MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r123, r123.getDisplayMetrics())));
        Resources r125 = Resources.getSystem();
        int r126 = r124 - MathKt.roundToInt(TypedValue.applyDimension(1, 24, WindowDisplayMetricsOverride.apply(r125, r125.getDisplayMetrics())));
        Resources r127 = Resources.getSystem();
        int r128 = r126 - MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r127, r127.getDisplayMetrics())));
        SkuContentsLayout r129 = this.f43295h;
        if (r129 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("contents");
    L62:
        SkuViewModel r130 = this.f43293f;
        if (r130 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L65:
        r129.a(r119, r128, r130);
        return;
    L66:
        Y().d().q(dg.m.class, 8);
        return;
    L8:
        r103 = null;
        goto L10
    }
}
