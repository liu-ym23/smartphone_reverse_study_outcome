package com.bytedanceos.common.ui.recycler.provider;

import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.ui.recycler.adapter.BaseMultiItemAdapter;
import com.bytedanceos.common.ui.recycler.entity.SubGiftItem;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tmall.wireless.tangram.structure.card.FixCard;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public class SubGiftProvider<T> extends BaseItemProvider<SubGiftItem> {
    private BaseMultiItemAdapter mAdapter;

    public SubGiftProvider(BaseMultiItemAdapter r10) {
        this.mAdapter = r10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(@NotNull BaseViewHolder r10, SubGiftItem r11) {
        convert2(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R$layout.item_sub_gift;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public void convert2(@NotNull BaseViewHolder r10, SubGiftItem r11) {
        if (r11.isAvailable() == true) goto L6;
        r10.itemView.setVisibility(8);
        return;
    L6:
        BaseMultiItemAdapter r12 = this.mAdapter;
        r12.setPage(r12.getPage());
        ((NetworkImageView) r10.getView(R$id.iv_icon)).f(r11.getGift().getPic(), 0.0f, true);
        r10.setText(R$id.tv_name, r11.getGift().getName());
        r10.setText(R$id.tv_num, FixCard.FixStyle.KEY_X + r11.getGift().getNum());
    }
}
