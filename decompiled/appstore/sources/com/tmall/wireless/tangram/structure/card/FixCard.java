package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.util.Utils;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class FixCard extends OneItemCard {

    public static class FixStyle extends Style {
        public static final Map<String, Integer> ALIGN_MAP = null;
        public static final String KEY_ALIGN = "align";
        public static final String KEY_SHOW_TYPE = "showType";
        public static final String KEY_SKETCH_MEASURE = "sketchMeasure";
        public static final String KEY_X = "x";
        public static final String KEY_Y = "y";
        public static final Map<String, Integer> SHOW_TYPE_MAP = null;
        public int alignType;
        String mDefaultAlign;
        String mDefaultShowType;
        public int showType;
        public boolean sketchMeasure;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f18214x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f18215y;

        static {
            ALIGN_MAP = Collections.unmodifiableMap(Utils.newMap("top_left", 0, "top_right", 1, "bottom_left", 2, "bottom_right", 3));
            SHOW_TYPE_MAP = Collections.unmodifiableMap(Utils.newMap("showonenter", 1, "showonleave", 2, "always", 0));
        }

        public FixStyle() {
            this.mDefaultAlign = "top_left";
            this.mDefaultShowType = "always";
            this.alignType = 0;
            this.showType = 0;
            this.sketchMeasure = true;
            this.f18214x = 0;
            this.f18215y = 0;
        }

        @Override // com.tmall.wireless.tangram.dataparser.concrete.Style
        public void parseWith(JSONObject r10) {
            super.parseWith(r10);
            if (r10 == null) goto L12;
            String r11 = r10.optString(KEY_SHOW_TYPE, this.mDefaultShowType).toLowerCase();
            String r12 = r10.optString(KEY_ALIGN, this.mDefaultAlign).toLowerCase();
            this.sketchMeasure = r10.optBoolean(KEY_SKETCH_MEASURE, true);
            Map<String, Integer> r13 = SHOW_TYPE_MAP;
            if (r13.containsKey(r11) == false) goto L7;
            this.showType = r13.get(r11).intValue();
        L7:
            Map<String, Integer> r14 = ALIGN_MAP;
            if (r14.containsKey(r12) == false) goto L10;
            this.alignType = r14.get(r12).intValue();
        L10:
            this.f18214x = Style.dp2px(r10.optDouble(KEY_X, 0.0d));
            this.f18215y = Style.dp2px(r10.optDouble(KEY_Y, 0.0d));
            return;
        }
    }

    public FixCard() {
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        if ((r10 instanceof FixLayoutHelper) == false) goto L5;
        FixLayoutHelper r11 = (FixLayoutHelper) r10;
    L6:
        r11.setSketchMeasure(false);
        r11.setItemCount(this.mCells.size());
        Style r12 = this.style;
        if ((r12 instanceof FixStyle) == false) goto L9;
        FixStyle r13 = (FixStyle) r12;
        r11.setAlignType(r13.alignType);
        r11.setX(r13.f18214x);
        r11.setY(r13.f18215y);
    L10:
        Style r14 = this.style;
        if (r14 == null) goto L13;
        int[] r15 = r14.margin;
        r11.setMargin(r15[3], r15[0], r15[1], r15[2]);
        int[] r16 = this.style.padding;
        r11.setPadding(r16[3], r16[0], r16[1], r16[2]);
    L13:
        return r11;
    L9:
        r11.setAlignType(0);
        r11.setX(0);
        r11.setY(0);
        goto L10
    L5:
        r11 = new FixLayoutHelper(0, 0);
        goto L6
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(JSONObject r10) {
        FixStyle r11 = new FixStyle();
        this.style = r11;
        if (r10 == null) goto L6;
        r11.parseWith(r10);
        return;
    }
}
