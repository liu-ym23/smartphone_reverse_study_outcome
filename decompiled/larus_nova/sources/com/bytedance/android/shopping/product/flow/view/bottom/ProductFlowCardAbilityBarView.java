package com.bytedance.android.shopping.product.flow.view.bottom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.extensions.f;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardAbilityBarView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductFlowCardAbilityBarView extends LinearLayout {
    public ProductFlowCardAbilityBarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductFlowCardAbilityBarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static void a(ProductFlowCardAbilityBarView r100, ProductFlowCardSimpleAbilityView r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "abilityView");
        f.c(r100, r101, null);
    }

    public ProductFlowCardAbilityBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        ShapeDrawable r103 = new ShapeDrawable();
        Resources r104 = Resources.getSystem();
        r103.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()))));
        r103.getPaint().setColor(0);
        Unit r105 = Unit.INSTANCE;
        setDividerDrawable(r103);
        setShowDividers(2);
    }

    public /* synthetic */ ProductFlowCardAbilityBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
