package com.bytedanceos.common.ui.recycler.provider;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.ui.recycler.adapter.BaseMultiItemAdapter;
import com.bytedanceos.common.ui.recycler.adapter.SubGiftListAdapter;
import com.bytedanceos.common.ui.recycler.entity.SubGiftListItem;
import com.bytedanceos.common.ui.widget.TryCatchLinearLayoutManager;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public class SubGiftListProvider<T> extends BaseItemProvider<SubGiftListItem> {
    private BaseMultiItemAdapter mAdapter;
    private ArrayList<MultiItemEntity> mDataList;
    private RecyclerView mRecycler;
    private SubGiftListAdapter mSubGiftListAdapter;

    public SubGiftListProvider(BaseMultiItemAdapter r10) {
        this.mAdapter = r10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(@NotNull BaseViewHolder r10, SubGiftListItem r11) {
        convert2(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 7;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R$layout.item_sub_gift_list;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public void convert2(@NotNull BaseViewHolder r10, SubGiftListItem r11) {
        if (r11.isAvailable() == true) goto L6;
        r10.itemView.setVisibility(8);
        return;
    L6:
        BaseMultiItemAdapter r12 = this.mAdapter;
        r12.setPage(r12.getPage());
        RecyclerView r13 = (RecyclerView) r10.getView(R$id.recycler);
        this.mRecycler = r13;
        if (r13.getLayoutManager() != null) goto L9;
        TryCatchLinearLayoutManager r14 = new TryCatchLinearLayoutManager(this.context);
        r14.setOrientation(0);
        this.mRecycler.setLayoutManager(r14);
    L9:
        ArrayList<MultiItemEntity> r15 = this.mDataList;
        if (r15 != null) goto L12;
        this.mDataList = new ArrayList();
    L13:
        this.mDataList.addAll(r11.getGifts());
        SubGiftListAdapter r16 = this.mSubGiftListAdapter;
        if (r16 != null) goto L16;
        SubGiftListAdapter r17 = new SubGiftListAdapter(this.context, this.mDataList);
        this.mSubGiftListAdapter = r17;
        this.mRecycler.setAdapter(r17);
        return;
    L16:
        r16.setNewData(this.mDataList);
        return;
    L12:
        r15.clear();
        goto L13
    }
}
