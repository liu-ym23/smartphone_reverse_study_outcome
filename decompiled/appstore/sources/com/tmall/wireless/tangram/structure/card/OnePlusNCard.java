package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.style.ColumnStyle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class OnePlusNCard extends Card {
    private static final float[] EMPTY_WEIGHTS = null;

    static {
        EMPTY_WEIGHTS = new float[0];
    }

    public OnePlusNCard() {
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        if ((r10 instanceof OnePlusNLayoutHelper) == false) goto L5;
        OnePlusNLayoutHelper r11 = (OnePlusNLayoutHelper) r10;
    L6:
        r11.setItemCount(this.mCells.size());
        Style r12 = this.style;
        if ((r12 instanceof ColumnStyle) == false) goto L23;
        ColumnStyle r13 = (ColumnStyle) r12;
        float[] r14 = r13.cols;
        if (r14 != null) goto L11;
    L13:
        r11.setColWeights(EMPTY_WEIGHTS);
    L15:
        if (Float.isNaN(this.style.aspectRatio) == true) goto L17;
        r11.setAspectRatio(this.style.aspectRatio);
    L17:
        float[] r15 = r13.rows;
        if (r15 != null) goto L20;
    L22:
        r11.setBgColor(r13.bgColor);
        int[] r16 = this.style.margin;
        r11.setMargin(r16[3], r16[0], r16[1], r16[2]);
        int[] r17 = this.style.padding;
        r11.setPadding(r17[3], r17[0], r17[1], r17[2]);
        goto L23
    L20:
        if (r15.length <= 0) goto L22;
        r11.setRowWeight(r15[0]);
        goto L22
    L11:
        if (r14.length <= 0) goto L13;
        r11.setColWeights(r14);
    L23:
        return r11;
    L5:
        r11 = new OnePlusNLayoutHelper();
        goto L6
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(JSONObject r10) {
        ColumnStyle r11 = new ColumnStyle();
        this.style = r11;
        if (r10 == null) goto L6;
        r11.parseWith(r10);
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseWith(@NonNull JSONObject r10, @NonNull MVHelper r11) {
        super.parseWith(r10, r11);
    }
}
