package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.utils.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductIntroductionListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductIntroductionListAdapter$CommonProductIntroductionViewHolder;", "CommonProductIntroductionViewHolder", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonProductIntroductionListAdapter extends RecyclerView.Adapter<CommonProductIntroductionViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ProductIntroductionInfo> f85052a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductIntroductionListAdapter$CommonProductIntroductionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class CommonProductIntroductionViewHolder extends RecyclerView.ViewHolder {
        public CommonProductIntroductionViewHolder(TextView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f85052a.size();
    }

    public CommonProductIntroductionListAdapter(List<ProductIntroductionInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "itemList");
        this.f85052a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        CommonProductIntroductionViewHolder r102 = (CommonProductIntroductionViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        ProductIntroductionInfo r103 = (ProductIntroductionInfo) ListProtector.get(this.f85052a, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "productIntroductionInfo");
        View r104 = r102.itemView;
        if (r104 == null) goto L11;
        TextView r105 = (TextView) r104;
        r105.setText(r103.content);
        int r106 = c.f84004a;
        r105.setTextColor(c.a(r103.fontColor));
        r105.setTextSize(r103.fontSize);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        if (r101 == 0) goto L7;
        r107.setMargins(UtilityKotlinExtentionsKt.i(6), 0, UtilityKotlinExtentionsKt.i(6), 0);
    L8:
        Unit r108 = Unit.INSTANCE;
        r105.setLayoutParams(r107);
        r105.setEllipsize(TextUtils.TruncateAt.END);
        r105.setMaxLines(1);
        return;
    L7:
        r107.setMargins(0, 0, UtilityKotlinExtentionsKt.i(6), 0);
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new CommonProductIntroductionViewHolder(new TextView(r100.getContext()));
    }
}
