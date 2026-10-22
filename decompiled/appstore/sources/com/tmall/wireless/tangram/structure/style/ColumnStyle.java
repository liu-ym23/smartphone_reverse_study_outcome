package com.tmall.wireless.tangram.structure.style;

import androidx.annotation.Nullable;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ColumnStyle extends Style {
    public static final String KEY_ROWS = "rows";

    @Nullable
    public float[] cols;

    @Nullable
    public float[] rows;

    public ColumnStyle() {
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Style
    public void parseWith(JSONObject r10) {
        super.parseWith(r10);
        if (r10 == null) goto L21;
        JSONArray r11 = r10.optJSONArray(Style.KEY_COLS);
        int r12 = 0;
        if (r11 == null) goto L10;
        this.cols = new float[r11.length()];
        int r13 = 0;
    L7:
        float[] r14 = this.cols;
        if (r13 >= r14.length) goto L11;
        r14[r13] = (float) r11.optDouble(r13, 0.0d);
        r13 = r13 + 1;
    L11:
        JSONArray r15 = r10.optJSONArray("rows");
        if (r15 == null) goto L17;
        this.rows = new float[r15.length()];
    L14:
        float[] r16 = this.rows;
        if (r12 >= r16.length) goto L22;
        r16[r12] = (float) r15.optDouble(r12, 0.0d);
        r12 = r12 + 1;
        goto L14
    L22:
        return;
    L17:
        this.rows = new float[0];
        return;
    L10:
        this.cols = new float[0];
        goto L11
    }
}
