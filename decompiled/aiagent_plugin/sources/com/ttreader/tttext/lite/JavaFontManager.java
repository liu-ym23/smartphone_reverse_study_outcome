package com.ttreader.tttext.lite;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class JavaFontManager {
    static boolean current_fake_bold_;
    static TTFont current_font_;
    static int current_font_id_;
    static float current_font_size_;
    static boolean current_skew_;
    private static final JavaFontManager font_manager_ = null;
    static final Paint.FontMetrics metrics = null;
    static final Paint paint = null;
    private final ValueCache<TTFont> font_cache_;

    /* JADX INFO: renamed from: com.ttreader.tttext.lite.JavaFontManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ValueCache<Value> {
        private int current_id_;
        private final Map<Value, Integer> id_map_;
        private final Map<Integer, Value> value_map_;

        private ValueCache() {
            this.value_map_ = new ConcurrentHashMap();
            this.id_map_ = new ConcurrentHashMap();
            this.current_id_ = 1;
        }

        /* synthetic */ ValueCache(AnonymousClass1 r1) {
            this();
        }

        public int Register(Value r4) {
            if (r4 != null) goto L5;
            return 0;
        L5:
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.id_map_.get(r4), Integer.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L8;
            monitor-enter(this);
            int r1 = this.current_id_;     // Catch: Throwable -> L14
            this.current_id_ = r1 + 1;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            this.value_map_.put(Integer.valueOf(r1), r4);
            this.id_map_.put(r4, Integer.valueOf(r1));
            return r1;
        L14:
            th = move-exception;
            throw th;
        L8:
            return r0.intValue();
        }

        public void Unregister(int r3) {
            if (r3 != 0) goto L4;
            return;
        L4:
            Value r0 = this.value_map_.get(Integer.valueOf(r3));
            if (r0 != null) goto L7;
            return;
        L7:
            this.id_map_.remove(r0);
            this.value_map_.remove(Integer.valueOf(r3));
        }

        public Value GetValue(int r1) {
            return this.value_map_.get(Integer.valueOf(r1));
        }
    }

    public JavaFontManager() {
        this.font_cache_ = new ValueCache(null);
    }

    static {
        font_manager_ = new JavaFontManager();
        paint = new Paint();
        current_font_id_ = 0;
        current_font_ = null;
        current_font_size_ = 0.0f;
        current_fake_bold_ = false;
        current_skew_ = false;
        metrics = new Paint.FontMetrics();
    }

    public static JavaFontManager GetInstance() {
        return font_manager_;
    }

    public int RegisterFont(TTFont r1) {
        return this.font_cache_.Register(r1);
    }

    public TTFont GetFont(int r2) {
        return (TTFont) ZeusTransformUtils.preCheckCast(this.font_cache_.GetValue(r2), TTFont.class, "com.obric.aiagent.plugin");
    }

    private static void ApplyFont(int r3, float r4, TTTextDefinition.FontWeight r5, TTTextDefinition.FontStyle r6) {
        TTFont r0 = current_font_;
        if (r3 == current_font_id_) goto L9;
        r0 = GetInstance().GetFont(r3);
        if (r0 == null) goto L7;
        paint.setTypeface(r0.face);
    L8:
        current_font_id_ = r3;
        current_font_ = r0;
        goto L9
    L7:
        paint.setTypeface(null);
    L9:
        boolean r7 = true;
        if (r0 == null) goto L25;
        if (r0.face == null) goto L25;
        if (r0.font_weight.ordinal() >= r5.ordinal()) goto L17;
        boolean r8 = true;
    L19:
        if (r6 == TTTextDefinition.FontStyle.kItalic) goto L21;
    L23:
        r7 = false;
    L31:
        if (r8 == current_fake_bold_) goto L34;
        paint.setFakeBoldText(r8);
        current_fake_bold_ = r8;
    L34:
        if (r7 == current_skew_) goto L40;
        if (r7 == false) goto L37;
        paint.setTextSkewX(-0.25f);
    L38:
        current_skew_ = r7;
        goto L40
    L37:
        paint.setTextSkewX(0.0f);
    L40:
        if (current_font_size_ == r4) goto L43;
        paint.setTextSize(r4);
        current_font_size_ = r4;
        return;
    L43:
        return;
    L21:
        if (r0.font_style == TTTextDefinition.FontStyle.kItalic) goto L23;
    L17:
        r8 = false;
    L25:
        if (TTTextDefinition.FontWeight.kNormal_400.ordinal() >= r5.ordinal()) goto L27;
        r8 = true;
    L29:
        if (r6 != TTTextDefinition.FontStyle.kItalic) goto L23;
    L27:
        r8 = false;
        goto L29
    }

    private static void ApplyFont(int r0, float r1, boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        TTTextDefinition.FontWeight r4 = TTTextDefinition.FontWeight.kBold_700;
    L5:
        if (r3 == false) goto L7;
        TTTextDefinition.FontStyle r5 = TTTextDefinition.FontStyle.kItalic;
    L8:
        ApplyFont(r0, r1, r4, r5);
        return;
    L7:
        r5 = TTTextDefinition.FontStyle.kNormal;
        goto L8
    L4:
        r4 = TTTextDefinition.FontWeight.kNormal_400;
        goto L5
    }

    public static void ApplyFont(Paint r5, int r6, TTTextDefinition.FontWeight r7, TTTextDefinition.FontStyle r8) {
        TTFont r9 = GetInstance().GetFont(r6);
        boolean r2 = true;
        if (r9 != null) goto L5;
    L18:
        r5.setTypeface(Typeface.DEFAULT);
        if (TTTextDefinition.FontWeight.kNormal_400.ordinal() < r7.ordinal()) goto L22;
        r2 = false;
    L22:
        r5.setFakeBoldText(r2);
        if (r8 != TTTextDefinition.FontStyle.kItalic) goto L25;
        r5.setTextSkewX(-0.25f);
        return;
    L25:
        r5.setTextSkewX(0.0f);
        return;
    L5:
        if (r9.face == null) goto L18;
        r5.setTypeface(r9.face);
        if (r9.font_weight.ordinal() < r7.ordinal()) goto L11;
        r2 = false;
    L11:
        r5.setFakeBoldText(r2);
        if (r8 == TTTextDefinition.FontStyle.kItalic) goto L14;
    L16:
        r5.setTextSkewX(0.0f);
        return;
    L14:
        if (r9.font_style == TTTextDefinition.FontStyle.kItalic) goto L16;
        r5.setTextSkewX(-0.25f);
    }

    public static float[] GetFontMetrics(int r2, float r3, boolean r4, boolean r5) {
        float[] r0 = new float[2];
        Paint r1 = paint;
        monitor-enter(r1);
        ApplyFont(r2, TTTextUtils.Dp2Px(r3), r4, r5);     // Catch: Throwable -> L7
        Paint.FontMetrics r6 = metrics;     // Catch: Throwable -> L7
        r1.getFontMetrics(r6);     // Catch: Throwable -> L7
        r0[0] = TTTextUtils.Px2Dp(r6.ascent);     // Catch: Throwable -> L7
        r0[1] = TTTextUtils.Px2Dp(r6.descent);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public static float[] GetTextAdvance(String r2, int r3, float r4, boolean r5, boolean r6) {
        float[] r0 = new float[r2.length()];
        Paint r1 = paint;
        monitor-enter(r1);
        ApplyFont(r3, TTTextUtils.Dp2Px(r4), r5, r6);     // Catch: Throwable -> L11
        r1.getTextWidths(r2, r0);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        int r7 = 0;
    L8:
        if (r7 >= r2.length()) goto L10;
        r0[r7] = TTTextUtils.Px2Dp(r0[r7]);
        r7 = r7 + 1;
        goto L8
    L10:
        return r0;
    L11:
        th = move-exception;
        throw th;
    }
}
