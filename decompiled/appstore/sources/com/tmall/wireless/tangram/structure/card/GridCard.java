package com.tmall.wireless.tangram.structure.card;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class GridCard extends Card {
    private static final String TAG = "GridCard";
    private int mColumn;

    public static class CellSpanSizeLookup extends GridLayoutHelper.SpanSizeLookup {
        public static final String DISPLAY_BLOCK = "block";
        public static final String DISPLAY_INLINE = "inline";
        public static final String KEY_COLSPAN = "colspan";
        public static final String KEY_DISPLAY = "display";
        protected final List<BaseCell> mCells;
        private final int mTotalColumn;

        public CellSpanSizeLookup(List<BaseCell> r10, int r11) {
            this.mCells = r10;
            this.mTotalColumn = r11;
        }

        @Override // com.alibaba.android.vlayout.layout.GridLayoutHelper.SpanSizeLookup
        public int getSpanSize(int r10) {
            int r11 = r10 - getStartPosition();
            if (r11 >= 0) goto L5;
            return 0;
        L5:
            if (r11 >= this.mCells.size()) goto L22;
            BaseCell r12 = this.mCells.get(r11);
            if (r12 == null) goto L19;
            Style r13 = r12.style;
            if (r13 == null) goto L19;
            JSONObject r14 = r13.extras;
            if (r14 == null) goto L19;
            r14.optInt(KEY_COLSPAN, 1);
            if (TextUtils.equals("block", r12.style.extras.optString("display", DISPLAY_INLINE)) == false) goto L18;
            return this.mTotalColumn;
        L18:
            return r12.style.extras.optInt(KEY_COLSPAN, 1);
        L19:
            return 1;
        L22:
            return 0;
        }
    }

    public static class GridStyle extends Style {
        public static final String KEY_AUTO_EXPAND = "autoExpand";
        public static final String KEY_COLUMN = "column";
        public static final String KEY_H_GAP = "hGap";
        public static final String KEY_IGNORE_EXTRA = "ignoreExtra";
        public static final String KEY_V_GAP = "vGap";
        public boolean autoExpand;
        public float[] cols;
        public int column;
        public int hGap;
        public int vGap;

        public GridStyle() {
            this.vGap = 0;
            this.hGap = 0;
            this.autoExpand = false;
            this.column = 0;
        }

        @Override // com.tmall.wireless.tangram.dataparser.concrete.Style
        public void parseWith(JSONObject r10) {
            super.parseWith(r10);
            if (r10 == null) goto L14;
            int r11 = 0;
            this.column = r10.optInt("column", 0);
            this.autoExpand = r10.optBoolean("autoExpand", false);
            JSONArray r12 = r10.optJSONArray(Style.KEY_COLS);
            if (r12 == null) goto L10;
            this.cols = new float[r12.length()];
        L7:
            float[] r13 = this.cols;
            if (r11 >= r13.length) goto L11;
            r13[r11] = (float) r12.optDouble(r11, 0.0d);
            r11 = r11 + 1;
        L11:
            this.hGap = Style.dp2px(r10.optDouble("hGap", 0.0d));
            this.vGap = Style.dp2px(r10.optDouble("vGap", 0.0d));
            return;
        L10:
            this.cols = new float[0];
            goto L11
        }
    }

    public GridCard() {
        this.mColumn = 0;
    }

    private void ensureBlock(BaseCell r10) {
        if (r10 == null) goto L13;
        Style r11 = r10.style;
        if (r11.extras != null) goto L11;
        r11.extras = new JSONObject();
    L11:
        r10.style.extras.put("display", "block");     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        i.l(TAG, i.d(e), e);
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        if ((r10 instanceof GridLayoutHelper) == false) goto L5;
        GridLayoutHelper r11 = (GridLayoutHelper) r10;
    L6:
        r11.setItemCount(this.mCells.size());
        r11.setSpanCount(this.mColumn);
        Style r12 = this.style;
        if ((r12 instanceof GridStyle) == false) goto L19;
        GridStyle r13 = (GridStyle) r12;
        int r14 = this.mColumn;
        int r15 = r13.column;
        if (r15 <= 0) goto L11;
        r11.setSpanCount(r15);
        r14 = r15;
    L11:
        r11.setSpanSizeLookup(new CellSpanSizeLookup(this.mCells, r14));
        r11.setVGap(r13.vGap);
        r11.setHGap(r13.hGap);
        r11.setAutoExpand(r13.autoExpand);
        float[] r16 = r13.cols;
        if (r16 == null) goto L17;
        if (r16.length <= 0) goto L17;
        r11.setWeights(r16);
    L17:
        if (Float.isNaN(r13.aspectRatio) == true) goto L19;
        r11.setAspectRatio(r13.aspectRatio);
    L19:
        return r11;
    L5:
        r11 = new GridLayoutHelper(1, this.mCells.size());
        goto L6
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public boolean isValid() {
        if (super.isValid() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mColumn > 0) goto L10;
        Style r10 = this.style;
        if ((r10 instanceof GridStyle) == false) goto L11;
        if (((GridStyle) r10).column <= 0) goto L11;
    L10:
        return true;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseFooterCell(@NonNull MVHelper r10, @Nullable JSONObject r11) {
        ensureBlock(createCell(r10, r11, true));
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseHeaderCell(@NonNull MVHelper r10, @Nullable JSONObject r11) {
        ensureBlock(createCell(r10, r11, true));
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(JSONObject r10) {
        GridStyle r11 = new GridStyle();
        this.style = r11;
        if (r10 == null) goto L5;
        r11.parseWith(r10);
    L5:
        Style r12 = this.style;
        if (((GridStyle) r12).column <= 0) goto L9;
        this.mColumn = ((GridStyle) r12).column;
        return;
    }

    public GridCard(int r10) {
        this.mColumn = r10;
    }
}
