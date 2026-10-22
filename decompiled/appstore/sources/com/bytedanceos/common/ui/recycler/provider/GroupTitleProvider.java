package com.bytedanceos.common.ui.recycler.provider;

import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.ui.recycler.adapter.BaseMultiItemAdapter;
import com.bytedanceos.common.ui.recycler.entity.GroupTitleItem;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public class GroupTitleProvider<T> extends BaseItemProvider<GroupTitleItem> {
    private BaseMultiItemAdapter mAdapter;

    public GroupTitleProvider(BaseMultiItemAdapter r10) {
        this.mAdapter = r10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(@NotNull BaseViewHolder r10, GroupTitleItem r11) {
        convert2(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 4;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R$layout.item_group_title;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public void convert2(@NotNull BaseViewHolder r10, GroupTitleItem r11) {
        if (r11.isAvailable() == true) goto L6;
        r10.itemView.setVisibility(8);
        return;
    L6:
        BaseMultiItemAdapter r12 = this.mAdapter;
        r12.setPage(r12.getPage());
        r10.setText(R$id.tv_title, r11.getName());
        r10.setGone(R$id.tv_all, true);
        r10.setGone(R$id.iv_arrow, true);
    }
}
