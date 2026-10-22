package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/LivePromotionListFooterView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/recyclerview/widget/RecyclerView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListFooterView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f150884a;

    public final RecyclerView getRecyclerView() {
        return this.f150884a;
    }

    public LivePromotionListFooterView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final void setRecyclerView(RecyclerView r100) {
        this.f150884a = r100;
    }

    public LivePromotionListFooterView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        super.onMeasure(r100, r110);
        RecyclerView r111 = this.f150884a;
        if (r111 != null) goto L5;
        return;
    L5:
        RecyclerView.Adapter r101 = r111.getAdapter();
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = View.MeasureSpec.getSize(getMeasuredHeight());
        if (r111.getHeight() > 0) goto L11;
    L13:
        boolean r103 = false;
    L14:
        Integer r104 = null;
        if (r103 == false) goto L17;
        RecyclerView r105 = r111;
    L18:
        if (r105 == null) goto L53;
        RecyclerView.ViewHolder r106 = r105.findViewHolderForLayoutPosition(r101.getItemCount() - 2);
        if (r106 == null) goto L54;
        View r107 = r106.itemView;
        if (r107 == null) goto L56;
        int r108 = r111.getHeight() - Math.max(r107.getBottom(), getTop());
        if (r102 < r108) goto L27;
        return;
    L27:
        if ((r101 instanceof PagedListAdapter) == true) goto L29;
        RecyclerView.Adapter r109 = null;
    L30:
        PagedListAdapter r112 = (PagedListAdapter) r109;
        if (r112 == null) goto L33;
        PagedList r113 = r112.getCurrentList();
    L34:
        int r114 = r101.getItemCount() - 2;
        if (r113 == null) goto L37;
        Integer r115 = Integer.valueOf(r113.getPositionOffset());
    L38:
        if (r113 == null) goto L42;
        PagedList.Config r116 = r113.getConfig();
        if (r116 == null) goto L42;
        r104 = Integer.valueOf(r116.pageSize);
    L42:
        int r117 = View.MeasureSpec.getSize(r107.getMeasuredHeight());
        if (r113 == null) goto L51;
        if (r115 == null) goto L51;
        if (r104 == null) goto L51;
        if ((r114 + r115.intValue()) < r104.intValue()) goto L51;
        if ((r117 * r104.intValue()) < r111.getHeight()) goto L51;
        return;
    L51:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r108, 1073741824));
        return;
    L37:
        r115 = null;
        goto L38
    L33:
        r113 = null;
        goto L34
    L29:
        r109 = r101;
        goto L30
    L56:
        return;
    L54:
        return;
    L53:
        return;
    L17:
        r105 = null;
        goto L18
    L11:
        if (r101.getItemCount() < 2) goto L13;
        r103 = true;
        goto L14
    }

    public LivePromotionListFooterView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
