package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.NonNull;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OneItemCard extends Card {
    public OneItemCard() {
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseWith(@NonNull JSONObject r10, @NonNull MVHelper r11) {
        this.maxChildren = 1;
        super.parseWith(r10, r11);
    }
}
