package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Style;

/* JADX INFO: loaded from: classes4.dex */
public class ScrollFixCard extends FixCard {
    public ScrollFixCard() {
    }

    @Override // com.tmall.wireless.tangram.structure.card.FixCard, com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        if ((r10 instanceof ScrollFixLayoutHelper) == false) goto L5;
        ScrollFixLayoutHelper r11 = (ScrollFixLayoutHelper) r10;
    L6:
        Style r12 = this.style;
        if (r12 == null) goto L9;
        r11.setAspectRatio(r12.aspectRatio);
    L9:
        Style r13 = this.style;
        if ((r13 instanceof FixCard.FixStyle) == false) goto L12;
        FixCard.FixStyle r14 = (FixCard.FixStyle) r13;
        r11.setAlignType(r14.alignType);
        r11.setShowType(r14.showType);
        r11.setSketchMeasure(r14.sketchMeasure);
        r11.setX(r14.f18214x);
        r11.setY(r14.f18215y);
    L13:
        return r11;
    L12:
        r11.setAlignType(0);
        r11.setShowType(0);
        r11.setSketchMeasure(true);
        r11.setX(0);
        r11.setY(0);
        goto L13
    L5:
        r11 = new ScrollFixLayoutHelper(0, 0);
        goto L6
    }
}
