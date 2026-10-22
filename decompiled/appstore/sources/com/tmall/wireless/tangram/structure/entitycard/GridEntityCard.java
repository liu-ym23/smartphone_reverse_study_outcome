package com.tmall.wireless.tangram.structure.entitycard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.util.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class GridEntityCard extends EntityCard {
    private static final String TAG = "GridEntityCard";
    private int mColumn;

    public static class GridEntityStyle extends Style {
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

        public GridEntityStyle() {
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

    public GridEntityCard(int r10) {
        super(r10);
        this.mColumn = 0;
    }

    private void ensureBlock(BaseCell r10) {
        if (r10 == null) goto L15;
        Style r11 = r10.style;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.extras != null) goto L13;
        r11.extras = new JSONObject();
    L13:
        r10.style.extras.put("display", "block");     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        i.l(TAG, i.d(e), e);
        return;
    }

    @Override // com.tmall.wireless.tangram.structure.entitycard.EntityCard
    public void parseFooterCell(@NonNull MVHelper r10, @Nullable JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        ensureBlock(createCell(r10, r11, true));
    }

    @Override // com.tmall.wireless.tangram.structure.entitycard.EntityCard
    public void parseHeaderCell(@NonNull MVHelper r10, @Nullable JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        ensureBlock(createCell(r10, r11, true));
    }

    @Override // com.tmall.wireless.tangram.structure.entitycard.EntityCard, com.tmall.wireless.tangram.structure.BaseCell
    public void parseStyle(@Nullable JSONObject r10) {
        GridEntityStyle r11 = new GridEntityStyle();
        this.style = r11;
        r11.parseWith(r10);
    }

    @Override // com.tmall.wireless.tangram.structure.entitycard.EntityCard, com.tmall.wireless.tangram.structure.BaseCell
    public void parseWith(@NonNull JSONObject r10, @NonNull MVHelper r11) {
        super.parseWith(r10, r11);
        this.mColumn = Utils.getCardColumnCount(this.cardType);
    }
}
