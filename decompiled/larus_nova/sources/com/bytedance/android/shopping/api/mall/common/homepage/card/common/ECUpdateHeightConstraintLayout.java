package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECUpdateHeightConstraintLayout;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECRoundedConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECUpdateHeightConstraintLayout extends ECRoundedConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f170302g;

    public ECUpdateHeightConstraintLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECUpdateHeightConstraintLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedConstraintLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f170302g > 0) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        if (r102 > 0) goto L10;
        super.onMeasure(r100, r101);
        return;
    L10:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r102 + this.f170302g, 1073741824));
    }

    public ECUpdateHeightConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ECUpdateHeightConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
