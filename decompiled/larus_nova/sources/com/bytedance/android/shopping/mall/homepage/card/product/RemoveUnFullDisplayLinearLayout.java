package com.bytedance.android.shopping.mall.homepage.card.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/product/RemoveUnFullDisplayLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RemoveUnFullDisplayLinearLayout extends LinearLayout {
    public RemoveUnFullDisplayLinearLayout(Context r100) {
        super(r100);
    }

    public RemoveUnFullDisplayLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getChildCount() <= 1) goto L14;
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = b0.b(this).size();
        int r104 = 0;
        int r105 = 0;
        int r106 = -1;
    L5:
        if (r104 >= r103) goto L12;
        View r107 = getChildAt(r104);
        if (r107 == null) goto L11;
        measureChild(r107, r100, r101);
        r105 = r105 + r107.getMeasuredWidth();
        if (r105 <= r102) goto L11;
        r106 = r104;
    L11:
        r104 = r104 + 1;
        goto L5
    L12:
        if (r106 <= 0) goto L14;
        removeViews(r106, getChildCount() - r106);
    L14:
        super.onMeasure(r100, r101);
    }

    public RemoveUnFullDisplayLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
