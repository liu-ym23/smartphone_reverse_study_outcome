package com.bytedanceos.common.ui.recycler.provider;

import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.toolbox.glide.b;
import com.bytedanceos.common.ui.recycler.adapter.BaseMultiItemAdapter;
import com.bytedanceos.common.ui.recycler.entity.SubScreenItem;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public class SubScreenProvider<T> extends BaseItemProvider<SubScreenItem> {
    private int DP_10;
    private int DP_12;
    private BaseMultiItemAdapter mAdapter;
    private int mMarginLeft;
    private int mMarginRight;

    public SubScreenProvider(BaseMultiItemAdapter r10) {
        this.mMarginLeft = 0;
        this.mMarginRight = 0;
        this.mAdapter = r10;
        this.DP_10 = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.sub_screen_corner_radius);
        this.DP_12 = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.item_padding_hor);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(@NotNull BaseViewHolder r10, SubScreenItem r11) {
        convert2(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 12;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R$layout.item_sub_screen;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public void convert2(@NotNull BaseViewHolder r10, SubScreenItem r11) {
        if (r11.isAvailable() == true) goto L6;
        r10.itemView.setVisibility(8);
        return;
    L6:
        BaseMultiItemAdapter r12 = this.mAdapter;
        r12.setPage(r12.getPage());
        RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r10.itemView.getLayoutParams();
        int r14 = this.DP_10;
        this.mMarginLeft = r14;
        this.mMarginRight = r14;
        if (r10.getAdapterPosition() != 0) goto L10;
        this.mMarginLeft = this.DP_12;
    L10:
        if (r10.getAdapterPosition() != (this.mAdapter.getItemCount() - 1)) goto L12;
        this.mMarginRight = this.DP_12;
    L12:
        r13.setMargins(this.mMarginLeft, 0, this.mMarginRight, 0);
        b.k(BaseApplication.c(), R$drawable.default_app_icon_banner, r11.getScreen(), (ImageView) r10.getView(R$id.iv_screen), this.context.getResources().getDimensionPixelOffset(R$dimen.sub_screen_corner_radius));
    }
}
