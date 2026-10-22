package com.tmall.wireless.tangram.dataparser.concrete;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tmall.wireless.tangram.util.TangramViewMetrics;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class Style {
    public static final String DEFAULT_BG_COLOR = "#00000000";
    private static final int[] DEFAULT_MARGIN = null;
    public static final String DISPLAY_BLOCK = "block";
    public static final String DISPLAY_INLINE = "inline-block";
    public static final int DISPLAY_INNER_BLOCK = 1;
    public static final int DISPLAY_INNER_INLINE = 0;
    public static final String KEY_ANIMATION_DURATION = "animationDuration";
    public static final String KEY_ASPECT_RATIO = "aspectRatio";
    public static final String KEY_BG_COLOR = "bgColor";
    public static final String KEY_BG_IMAGE = "bgImage";
    public static final String KEY_COLS = "cols";
    public static final String KEY_DISPLAY = "display";
    public static final String KEY_FOR_LABEL = "forLabel";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_MARGIN = "margin";
    public static final String KEY_PADDING = "padding";
    public static final String KEY_SLIDABLE = "slidable";
    public static final String KEY_STYLE_BG_IMAGE = "bgImgUrl";
    public static final String KEY_WIDTH = "width";
    public static final String KEY_ZINDEX = "zIndex";
    public static final int MARGIN_BOTTOM_INDEX = 2;
    public static final int MARGIN_LEFT_INDEX = 3;
    public static final int MARGIN_RIGHT_INDEX = 1;
    public static final int MARGIN_TOP_INDEX = 0;
    public float aspectRatio;
    public int bgColor;
    public String bgImage;
    public String bgImgUrl;

    @Nullable
    public JSONObject extras;
    public String forLabel;
    public int height;

    @NonNull
    public final int[] margin;

    @NonNull
    public final int[] padding;
    public boolean slidable;
    public int width;
    public int zIndex;

    static {
        DEFAULT_MARGIN = new int[]{0, 0, 0, 0};
    }

    public Style() {
        this(DEFAULT_MARGIN);
    }

    public static int dp2px(double r10) {
        float r11 = TangramViewMetrics.screenDensity();
        if (r11 >= 0.0f) goto L6;
        r11 = 1.0f;
    L6:
        if (r10 < 0.0d) goto L9;
        return (int) ((r10 * ((double) r11)) + 0.5d);
    L9:
        return -((int) (((-r10) * ((double) r11)) + 0.5d));
    }

    public static int parseColor(String r10) {
        return Color.parseColor(r10);
    L4:
        return -1;
    }

    public void parseWith(@Nullable JSONObject r10) {
        if (r10 == null) goto L42;
        this.extras = r10;
        this.forLabel = r10.optString(KEY_FOR_LABEL, "");
        setBgColor(r10.optString(KEY_BG_COLOR, DEFAULT_BG_COLOR));
        int r11 = r10.optInt(KEY_WIDTH, -1);
        this.width = r11;
        if (r11 < 0) goto L6;
        this.width = dp2px(r11);
    L6:
        int r12 = r10.optInt(KEY_HEIGHT, -2);
        this.height = r12;
        if (r12 < 0) goto L9;
        this.height = dp2px(r12);
    L9:
        this.bgImage = r10.optString(KEY_BG_IMAGE, "");
        this.bgImgUrl = r10.optString(KEY_STYLE_BG_IMAGE, "");
        this.aspectRatio = (float) r10.optDouble(KEY_ASPECT_RATIO);
        int r13 = 0;
        this.zIndex = r10.optInt(KEY_ZINDEX, 0);
        this.slidable = r10.optBoolean(KEY_SLIDABLE);
        JSONArray r14 = r10.optJSONArray(KEY_MARGIN);
        if (r14 == null) goto L17;
        int r15 = Math.min(this.margin.length, r14.length());
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L15;
        this.margin[r16] = dp2px(r14.optDouble(r16));     // Catch: Exception -> L33
    L14:
        r16 = r16 + 1;
        goto L12
    L15:
        if (r15 <= 0) goto L20;
        int[] r17 = this.margin;
        Arrays.fill(r17, r15, r17.length, r17[r15 - 1]);
    L20:
        JSONArray r18 = r10.optJSONArray(KEY_PADDING);
        if (r18 == null) goto L28;
        int r19 = Math.min(this.padding.length, r18.length());
    L23:
        if (r13 >= r19) goto L26;
        this.padding[r13] = dp2px(r18.optDouble(r13));     // Catch: Exception -> L32
    L25:
        r13 = r13 + 1;
        goto L23
    L26:
        if (r19 <= 0) goto L43;
        int[] r20 = this.padding;
        Arrays.fill(r20, r19, r20.length, r20[r19 - 1]);
        return;
    L43:
        return;
    L28:
        String r21 = r10.optString(KEY_PADDING);
        if (TextUtils.isEmpty(r21) == true) goto L45;
        setPadding(r21);
        return;
    L45:
        return;
    L17:
        String r22 = r10.optString(KEY_MARGIN);
        if (TextUtils.isEmpty(r22) == true) goto L20;
        setMargin(r22);
        goto L20
    }

    public void setBgColor(String r10) {
        this.bgColor = parseColor(r10);
    }

    public void setMargin(@Nullable String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L24;
        return;
    L24:
        String[] r11 = r10.trim().substring(1, r10.length() - 1).split(",");     // Catch: Exception -> L20
        int r12 = 4;
        if (r11.length > 4) goto L9;
        r12 = r11.length;     // Catch: Exception -> L20
    L9:
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L18;
        String r14 = r11[r13];     // Catch: Exception -> L20
    L16:
        this.margin[r13] = 0;     // Catch: Exception -> L20
    L17:
        r13 = r13 + 1;     // Catch: Exception -> L20
        goto L10
    L13:
        if (TextUtils.isEmpty(r14) == true) goto L17;
        this.margin[r13] = dp2px(Float.parseFloat(r14.trim().replace("\"", "")));     // Catch: NumberFormatException -> L16 Exception -> L20
    L18:
        int[] r15 = this.margin;     // Catch: Exception -> L20
        Arrays.fill(r15, r12, r15.length, r15[r12 - 1]);     // Catch: Exception -> L20
        return;
    L20:
        Arrays.fill(this.margin, 0);
    }

    public void setPadding(@Nullable String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L24;
        return;
    L24:
        String[] r11 = r10.trim().substring(1, r10.length() - 1).split(",");     // Catch: Exception -> L20
        int r12 = 4;
        if (r11.length > 4) goto L9;
        r12 = r11.length;     // Catch: Exception -> L20
    L9:
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L18;
        String r14 = r11[r13];     // Catch: Exception -> L20
    L16:
        this.padding[r13] = 0;     // Catch: Exception -> L20
    L17:
        r13 = r13 + 1;     // Catch: Exception -> L20
        goto L10
    L13:
        if (TextUtils.isEmpty(r14) == true) goto L17;
        this.padding[r13] = dp2px(Float.parseFloat(r14.trim().replace("\"", "")));     // Catch: NumberFormatException -> L16 Exception -> L20
    L18:
        int[] r15 = this.padding;     // Catch: Exception -> L20
        Arrays.fill(r15, r12, r15.length, r15[r12 - 1]);     // Catch: Exception -> L20
        return;
    L20:
        Arrays.fill(this.padding, 0);
    }

    public Style(float[] r10) {
        int r11 = 0;
        this.zIndex = 0;
        int[] r12 = {0, 0, 0, 0};
        this.margin = r12;
        this.padding = new int[]{0, 0, 0, 0};
        this.width = -1;
        this.height = -1;
        this.aspectRatio = Float.NaN;
        int r13 = Math.min(r10.length, r12.length);
    L3:
        if (r11 >= r13) goto L5;
        this.margin[r11] = dp2px(r10[r11]);
        r11 = r11 + 1;
        goto L3
    L5:
        int[] r14 = this.margin;
        Arrays.fill(r14, r13, r14.length, r14[r13 - 1]);
        this.bgColor = parseColor(DEFAULT_BG_COLOR);
    }

    public Style(int[] r10) {
        this.zIndex = 0;
        int[] r11 = {0, 0, 0, 0};
        this.margin = r11;
        this.padding = new int[]{0, 0, 0, 0};
        this.width = -1;
        this.height = -1;
        this.aspectRatio = Float.NaN;
        int r12 = Math.min(r10.length, r11.length);
        System.arraycopy(r10, 0, r11, 0, r12);
        if (r12 >= r11.length) goto L5;
        Arrays.fill(r11, r12, r11.length, r11[r12 - 1]);
    L5:
        this.bgColor = parseColor(DEFAULT_BG_COLOR);
    }
}
