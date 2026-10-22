package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Style;

/* JADX INFO: loaded from: classes4.dex */
public class FloatCard extends FixCard {
    public FloatCard() {
    }

    @Override // com.tmall.wireless.tangram.structure.card.FixCard, com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        if ((r10 instanceof FloatLayoutHelper) == false) goto L5;
        FloatLayoutHelper r11 = (FloatLayoutHelper) r10;
    L6:
        r11.setItemCount(this.mCells.size());
        Style r12 = this.style;
        if ((r12 instanceof FixCard.FixStyle) == false) goto L9;
        FixCard.FixStyle r13 = (FixCard.FixStyle) r12;
        r11.setAlignType(r13.alignType);
        r11.setDefaultLocation(r13.f18214x, r13.f18215y);
    L9:
        return r11;
    L5:
        r11 = new FloatLayoutHelper();
        goto L6
    }
}
