package com.bytedance.android.shopping.anchorv3.activities.view;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.activities.quick.presenter.a;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/activities/view/ActivityBarGroupLayout;", "Lcom/bytedance/android/shopping/anchorv3/activities/view/AbsActivitiesBarView;", "", "getLayout", "Lcom/bytedance/android/shopping/anchorv3/activities/quick/presenter/a;", "presenter", "Lcom/bytedance/android/shopping/anchorv3/activities/quick/presenter/a;", "getPresenter$ec_shopping_impl_saasRelease", "()Lcom/bytedance/android/shopping/anchorv3/activities/quick/presenter/a;", "setPresenter$ec_shopping_impl_saasRelease", "(Lcom/bytedance/android/shopping/anchorv3/activities/quick/presenter/a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityBarGroupLayout extends AbsActivitiesBarView {
    public ActivityBarGroupLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ActivityBarGroupLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.anchorv3.activities.view.AbsActivitiesBarView
    public final void c(c2 r100) {
        Intrinsics.checkNotNullParameter(r100, "uiCountDown");
    }

    @Override // com.bytedance.android.shopping.anchorv3.activities.view.AbsActivitiesBarView
    public final void e(ActivityVO r100, Long r101, PromotionProductStruct r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "activityVO");
    }

    @Override // com.bytedance.android.shopping.anchorv3.activities.view.AbsActivitiesBarView
    public int getLayout() {
        return R.layout.ec_commerce_layout_anchor_v3_group_activity;
    }

    public final a getPresenter$ec_shopping_impl_saasRelease() {
        return null;
    }

    public final void setPresenter$ec_shopping_impl_saasRelease(a r100) {
    }

    public ActivityBarGroupLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ActivityBarGroupLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
