package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;

/* JADX INFO: loaded from: classes6.dex */
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private static final ThreadLocal<StringBuilder> sStringBuilder = null;
    private final TextPaint mTextPaint;

    static {
        sStringBuilder = new ThreadLocal();
    }

    private static StringBuilder getStringBuilder() {
        ThreadLocal<StringBuilder> r100 = sStringBuilder;
        if (r100.get() != null) goto L6;
        r100.set(new StringBuilder());
    L6:
        return r100.get();
    }

    public DefaultGlyphChecker() {
        TextPaint r100 = new TextPaint();
        this.mTextPaint = r100;
        r100.setTextSize(10.0f);
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(CharSequence r100, int r101, int r102, int r103) {
        int r104 = Build.VERSION.SDK_INT;
        if (r104 >= 23) goto L6;
        if (r103 <= r104) goto L6;
        return false;
    L6:
        StringBuilder r105 = getStringBuilder();
        r105.setLength(0);
    L7:
        if (r101 >= r102) goto L10;
        r105.append(r100.charAt(r101));
        r101 = r101 + 1;
        goto L7
    L10:
        return PaintCompat.hasGlyph(this.mTextPaint, r105.toString());
    }
}
