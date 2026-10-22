package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class LinearCard extends Card {
    private static final String KEY_DIVIDE_HEIGHT = "divideHeight";

    public LinearCard() {
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        if ((r10 instanceof LinearLayoutHelper) == false) goto L5;
        LinearLayoutHelper r11 = (LinearLayoutHelper) r10;
    L6:
        Style r12 = this.style;
        if (r12 == null) goto L16;
        r11.setBgColor(r12.bgColor);
        if (Float.isNaN(this.style.aspectRatio) == true) goto L11;
        r11.setAspectRatio(this.style.aspectRatio);
    L11:
        JSONObject r13 = this.style.extras;
        if (r13 == null) goto L16;
        if (r13.has(KEY_DIVIDE_HEIGHT) == false) goto L16;
        r11.setDividerHeight(Style.dp2px(this.style.extras.optInt(KEY_DIVIDE_HEIGHT, 0)));
    L16:
        r11.setItemCount(this.mCells.size());
        int[] r14 = this.style.margin;
        r11.setMargin(r14[3], r14[0], r14[1], r14[2]);
        int[] r15 = this.style.padding;
        r11.setPadding(r15[3], r15[0], r15[1], r15[2]);
        return r11;
    L5:
        r11 = new LinearLayoutHelper();
        goto L6
    }
}
