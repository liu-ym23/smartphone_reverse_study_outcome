package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class StickyCard extends OneItemCard {

    public static class StickyStyle extends Style {
        public static final String KEY_STICKY = "sticky";
        public static final String STICKY_END = "end";
        public static final String STICKY_START = "start";
        public boolean stickyStart;

        public StickyStyle(boolean r10) {
            this.stickyStart = r10;
        }

        @Override // com.tmall.wireless.tangram.dataparser.concrete.Style
        public void parseWith(JSONObject r10) {
            super.parseWith(r10);
            if (r10 != null) goto L5;
            return;
        L5:
            if (this.stickyStart == false) goto L7;
            String r11 = "start";
        L8:
            this.stickyStart = "start".equalsIgnoreCase(r10.optString(KEY_STICKY, r11));
            return;
        L7:
            r11 = "end";
            goto L8
        }
    }

    public StickyCard() {
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        if ((r10 instanceof StickyLayoutHelper) == false) goto L5;
        StickyLayoutHelper r11 = (StickyLayoutHelper) r10;
    L6:
        Style r12 = this.style;
        if (r12 != null) goto L9;
    L11:
        Style r13 = this.style;
        if ((r13 instanceof StickyStyle) == false) goto L14;
        r11.setStickyStart(((StickyStyle) r13).stickyStart);
        int[] r14 = this.style.margin;
        r11.setMargin(r14[3], r14[0], r14[1], r14[2]);
        int[] r15 = this.style.padding;
        r11.setPadding(r15[3], r15[0], r15[1], r15[2]);
    L15:
        return r11;
    L14:
        r11.setStickyStart(true);
        goto L15
    L9:
        if (Float.isNaN(r12.aspectRatio) == true) goto L11;
        r11.setAspectRatio(this.style.aspectRatio);
        goto L11
    L5:
        r11 = new StickyLayoutHelper(true);
        goto L6
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(JSONObject r10) {
        StickyStyle r11 = new StickyStyle(true);
        this.style = r11;
        if (r10 == null) goto L6;
        r11.parseWith(r10);
        return;
    }
}
