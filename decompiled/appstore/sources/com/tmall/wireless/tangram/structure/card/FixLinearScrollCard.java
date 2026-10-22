package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class FixLinearScrollCard extends LinearScrollCard {
    private FixCard.FixStyle mFixStyle;

    public FixLinearScrollCard() {
    }

    @Override // com.tmall.wireless.tangram.structure.card.LinearScrollCard, com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(LayoutHelper r10) {
        if ((r10 instanceof ScrollFixLayoutHelper) == false) goto L5;
        ScrollFixLayoutHelper r11 = (ScrollFixLayoutHelper) r10;
    L6:
        FixCard.FixStyle r12 = this.mFixStyle;
        if (r12 == null) goto L9;
        r11.setAspectRatio(r12.aspectRatio);
    L9:
        FixCard.FixStyle r13 = this.mFixStyle;
        r11.setAlignType(r13.alignType);
        r11.setShowType(r13.showType);
        r11.setSketchMeasure(r13.sketchMeasure);
        r11.setX(r13.f18214x);
        r11.setY(r13.f18215y);
        return r11;
    L5:
        r11 = new ScrollFixLayoutHelper(0, 0);
        goto L6
    }

    @Override // com.tmall.wireless.tangram.structure.card.LinearScrollCard, com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(@Nullable JSONObject r10) {
        super.parseStyle(r10);
        FixCard.FixStyle r11 = new FixCard.FixStyle();
        this.mFixStyle = r11;
        if (r10 == null) goto L6;
        r11.parseWith(r10);
        return;
    }
}
