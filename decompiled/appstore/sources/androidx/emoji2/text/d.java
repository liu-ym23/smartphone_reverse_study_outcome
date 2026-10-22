package androidx.emoji2.text;

import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public class d implements EmojiCompat.GlyphChecker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f3057b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f3058a;

    static {
        f3057b = new ThreadLocal();
    }

    public d() {
        TextPaint r10 = new TextPaint();
        this.f3058a = r10;
        r10.setTextSize(10.0f);
    }

    public static StringBuilder a() {
        ThreadLocal r10 = f3057b;
        if (r10.get() != null) goto L6;
        r10.set(new StringBuilder());
    L6:
        return (StringBuilder) r10.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(CharSequence r10, int r11, int r12, int r13) {
        StringBuilder r14 = a();
        r14.setLength(0);
    L3:
        if (r11 >= r12) goto L6;
        r14.append(r10.charAt(r11));
        r11 = r11 + 1;
        goto L3
    L6:
        return androidx.core.graphics.f.a(this.f3058a, r14.toString());
    }
}
