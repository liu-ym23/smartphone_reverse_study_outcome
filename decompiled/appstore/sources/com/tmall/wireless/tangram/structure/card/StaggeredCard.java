package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class StaggeredCard extends Card {

    public static class StaggeredStyle extends Style {
        public static final String KEY_COLUMN = "column";
        public static final String KEY_GAP = "gap";
        public static final String KEY_H_GAP = "hGap";
        public static final String KEY_V_GAP = "vGap";
        public int column;
        public int hGap;
        public int vGap;

        public StaggeredStyle() {
            this.vGap = 0;
            this.hGap = 0;
            this.column = 2;
        }

        @Override // com.tmall.wireless.tangram.dataparser.concrete.Style
        public void parseWith(JSONObject r10) {
            super.parseWith(r10);
            if (r10 == null) goto L6;
            this.column = r10.optInt("column", 2);
            int r11 = Style.dp2px(r10.optDouble(KEY_GAP, 0.0d));
            this.hGap = r11;
            this.vGap = r11;
            this.hGap = Style.dp2px(r10.optDouble("hGap", r11));
            this.vGap = Style.dp2px(r10.optDouble("vGap", this.vGap));
            return;
        }
    }

    public StaggeredCard() {
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        if ((r10 instanceof StaggeredGridLayoutHelper) == false) goto L5;
        StaggeredGridLayoutHelper r11 = (StaggeredGridLayoutHelper) r10;
    L6:
        Style r12 = this.style;
        if ((r12 instanceof StaggeredStyle) == false) goto L9;
        StaggeredStyle r13 = (StaggeredStyle) r12;
        r11.setLane(r13.column);
        r11.setItemCount(this.mCells.size());
        r11.setVGap(r13.vGap);
        r11.setHGap(r13.hGap);
    L9:
        Style r14 = this.style;
        if (r14 == null) goto L12;
        int[] r15 = r14.margin;
        r11.setMargin(r15[3], r15[0], r15[1], r15[2]);
        int[] r16 = this.style.padding;
        r11.setPadding(r16[3], r16[0], r16[1], r16[2]);
    L12:
        return r11;
    L5:
        r11 = new StaggeredGridLayoutHelper();
        goto L6
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public boolean isValid() {
        if (super.isValid() == false) goto L9;
        Style r10 = this.style;
        if ((r10 instanceof StaggeredStyle) == false) goto L9;
        if (((StaggeredStyle) r10).column <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(@Nullable JSONObject r10) {
        StaggeredStyle r11 = new StaggeredStyle();
        this.style = r11;
        r11.parseWith(r10);
    }
}
