package com.tmall.wireless.tangram.structure.card;

import com.tmall.wireless.tangram.dataparser.concrete.Style;
import org.json.JSONObject;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public class FiveColumnCard extends ColumnCard {
    public FiveColumnCard() {
        super(5);
    }

    @Override // com.tmall.wireless.tangram.structure.card.GridCard, com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(JSONObject r10) {
        super.parseStyle(r10);
        Style r11 = this.style;
        if ((r11 instanceof GridCard.GridStyle) == false) goto L6;
        GridCard.GridStyle r12 = (GridCard.GridStyle) r11;
        r12.margin[0] = f.i(8);
        r12.margin[1] = f.i(20);
        r12.margin[2] = f.i(8);
        r12.margin[3] = f.i(20);
        r12.hGap = f.i(12);
        return;
    }
}
