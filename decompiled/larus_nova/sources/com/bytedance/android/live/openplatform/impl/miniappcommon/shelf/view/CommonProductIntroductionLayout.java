package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductIntroductionLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonProductIntroductionLayout extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommonProductIntroductionListAdapter f85051a;

    public final void r(List<ProductIntroductionInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "introductionList");
        List<ProductIntroductionInfo> r101 = this.f85051a.f85052a;
        r101.clear();
        r101.addAll(r100);
        this.f85051a.notifyDataSetChanged();
    }

    public CommonProductIntroductionLayout(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        CommonProductIntroductionListAdapter r102 = new CommonProductIntroductionListAdapter(new ArrayList());
        this.f85051a = r102;
        setLayoutManager(new AnonymousClass1(r100));
        DividerItemDecoration r103 = new DividerItemDecoration(r100);
        Drawable r104 = getResources().getDrawable(R.drawable.ttlive_product_introduction_divider_line);
        Intrinsics.checkNotNullParameter(r104, "drawable");
        r103.f85080b = r104;
        Unit r105 = Unit.INSTANCE;
        addItemDecoration(r103);
        setAdapter(r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = getChildCount() - 1;
    L3:
        if (r105 < 0) goto L7;
        View r106 = getChildAt(r105);
        if ((r106.getLeft() + r106.getMeasuredWidth()) < getMeasuredWidth()) goto L10;
        removeViewInLayout(r106);
        r105 = r105 - 1;
        goto L3
    L10:
        return;
    }
}
