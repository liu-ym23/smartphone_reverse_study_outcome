package com.tmall.wireless.tangram.dataparser.concrete;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.tmall.wireless.tangram.structure.card.GridCard;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class WrapperCard extends Card {

    @NonNull
    private Card mCard;

    public WrapperCard(@NonNull Card r10) {
        this.mCard = r10;
        ArrayList r11 = new ArrayList(this.mCard.getCells());
        this.mCard.setCells(null);
        Card r12 = this.mCard;
        this.type = r12.type;
        this.f18212id = r12.f18212id;
        this.loaded = r12.loaded;
        this.load = r12.load;
        this.loading = r12.loading;
        this.loadMore = r12.loadMore;
        this.hasMore = r12.hasMore;
        this.page = r12.page;
        this.style = r12.style;
        this.maxChildren = r12.maxChildren;
        this.rowId = r12.rowId;
        this.serviceManager = r12.serviceManager;
        setParams(r12.getParams());
        setCells(r11);
        addCells(this.mCard.mPendingCells);
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        LayoutHelper r11 = this.mCard.convertLayoutHelper(r10);
        if (r11 == null) goto L7;
        r11.setItemCount(this.mCells.size());
        if ((r11 instanceof GridLayoutHelper) == false) goto L7;
        GridLayoutHelper r12 = (GridLayoutHelper) r11;
        r12.setSpanSizeLookup(new GridCard.CellSpanSizeLookup(this.mCells, r12.getSpanCount()));
    L7:
        return r11;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public boolean isValid() {
        return this.mCard.isValid();
    }
}
