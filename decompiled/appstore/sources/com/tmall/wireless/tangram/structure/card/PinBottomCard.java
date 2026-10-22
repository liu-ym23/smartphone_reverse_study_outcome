package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;

/* JADX INFO: loaded from: classes4.dex */
public class PinBottomCard extends FixCard {
    public PinBottomCard() {
    }

    @Override // com.tmall.wireless.tangram.structure.card.FixCard, com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        LayoutHelper r11 = super.convertLayoutHelper(r10);
        if ((r11 instanceof FixLayoutHelper) == false) goto L5;
        FixLayoutHelper r12 = (FixLayoutHelper) r11;
        r12.setAlignType(2);
        r12.setSketchMeasure(true);
    L5:
        return r11;
    }
}
