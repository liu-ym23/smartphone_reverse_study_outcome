package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;

/* JADX INFO: loaded from: classes.dex */
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private static final ThreadLocal<StringBuilder> sStringBuilder = null;
    private final TextPaint mTextPaint;

    static {
        sStringBuilder = new ThreadLocal();
    }

    DefaultGlyphChecker() {
        TextPaint r0 = new TextPaint();
        this.mTextPaint = r0;
        r0.setTextSize(10.0f);
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(CharSequence r2, int r3, int r4, int r5) {
        StringBuilder r6 = getStringBuilder();
        r6.setLength(0);
    L3:
        if (r3 >= r4) goto L6;
        r6.append(r2.charAt(r3));
        r3 = r3 + 1;
        goto L3
    L6:
        return PaintCompat.hasGlyph(this.mTextPaint, r6.toString());
    }

    private static StringBuilder getStringBuilder() {
        ThreadLocal<StringBuilder> r0 = sStringBuilder;
        if (r0.get() != null) goto L6;
        r0.set(new StringBuilder());
    L6:
        return r0.get();
    }
}
