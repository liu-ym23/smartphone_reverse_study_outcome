package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.widget.ECBenefitLabelView;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SkuBenefitLabelGroupLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBenefitLabelGroupLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PromotionBenefitLabel> f43408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<PromotionBenefitLabel> f43409b;

    public SkuBenefitLabelGroupLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SkuBenefitLabelGroupLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        removeAllViews();
        Iterator r100 = ((ArrayList) this.f43409b).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L10;
        PromotionBenefitLabel r102 = (PromotionBenefitLabel) r100.next();
        ECBenefitLabelView r103 = new ECBenefitLabelView(getContext(), null, 6, 0);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, vf4.a.b(Float.valueOf(20.0f)));
        if (r101 != 0) goto L8;
        r104.setMargins(0, 0, 0, 0);
    L9:
        r103.setLayoutParams(r104);
        addView(r103);
        r103.a(r102, null);
        r101 = r101 + 1;
        goto L4
    L8:
        r104.setMargins(vf4.a.b(Float.valueOf(8.0f)), 0, 0, 0);
        goto L9
    }

    public SkuBenefitLabelGroupLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f43408a = new ArrayList();
        this.f43409b = new ArrayList();
    }

    public /* synthetic */ SkuBenefitLabelGroupLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (getChildCount() != ((ArrayList) this.f43409b).size()) goto L9;
        int r105 = getChildCount() - 1;
    L5:
        if (r105 < 0) goto L12;
        View r106 = getChildAt(r105);
        if ((r106.getLeft() + r106.getMeasuredWidth()) < getMeasuredWidth()) goto L13;
        removeViewInLayout(r106);
        r105 = r105 - 1;
        goto L5
    L13:
        return;
    L12:
        return;
    }
}
