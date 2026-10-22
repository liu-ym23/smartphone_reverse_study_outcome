package com.tmall.wireless.tangram.structure.card;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class StickyEndCard extends StickyCard {
    public StickyEndCard() {
    }

    @Override // com.tmall.wireless.tangram.structure.card.StickyCard, com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(JSONObject r10) {
        StickyCard.StickyStyle r11 = new StickyCard.StickyStyle(false);
        this.style = r11;
        if (r10 == null) goto L6;
        r11.parseWith(r10);
        return;
    }
}
