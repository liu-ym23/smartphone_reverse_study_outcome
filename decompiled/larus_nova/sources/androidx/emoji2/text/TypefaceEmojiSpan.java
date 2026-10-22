package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes17.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {
    private static Paint sDebugPaint;
    private TextPaint mWorkingPaint;

    private static Paint getDebugPaint() {
        if (sDebugPaint != null) goto L6;
        TextPaint r100 = new TextPaint();
        sDebugPaint = r100;
        r100.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
        sDebugPaint.setStyle(Paint.Style.FILL);
    L6:
        return sDebugPaint;
    }

    public TypefaceEmojiSpan(TypefaceEmojiRasterizer r100) {
        super(r100);
    }

    private TextPaint applyCharacterSpanStyles(CharSequence r100, int r101, int r102, Paint r103) {
        if ((r100 instanceof Spanned) == false) goto L28;
        CharacterStyle[] r104 = (CharacterStyle[]) ((Spanned) r100).getSpans(r101, r102, CharacterStyle.class);
        if (r104.length == 0) goto L23;
        int r105 = 0;
        if (r104.length == 1) goto L9;
    L11:
        TextPaint r106 = this.mWorkingPaint;
        if (r106 != null) goto L14;
        r106 = new TextPaint();
        this.mWorkingPaint = r106;
    L14:
        r106.set(r103);
    L16:
        if (r105 >= r104.length) goto L21;
        CharacterStyle r107 = r104[r105];
        if ((r107 instanceof MetricAffectingSpan) == true) goto L20;
        r107.updateDrawState(r106);
    L20:
        r105 = r105 + 1;
        goto L16
    L21:
        return r106;
    L9:
        if (r104[0] != this) goto L11;
    L23:
        if ((r103 instanceof TextPaint) == true) goto L25;
        return null;
    L25:
        return (TextPaint) r103;
    L28:
        if ((r103 instanceof TextPaint) == true) goto L30;
        return null;
    L30:
        return (TextPaint) r103;
    }

    public void drawBackground(Canvas r100, TextPaint r110, float r111, float r112, float r113, float r114) {
        int r101 = r110.getColor();
        Paint.Style r102 = r110.getStyle();
        r110.setColor(r110.bgColor);
        r110.setStyle(Paint.Style.FILL);
        r100.drawRect(r111, r113, r112, r114, r110);
        r110.setStyle(r102);
        r110.setColor(r101);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r210, int r211, Paint r212) {
        Paint r116 = r212;
        TextPaint r117 = applyCharacterSpanStyles(r111, r112, r113, r116);
        if (r117 == null) goto L8;
        if (r117.bgColor == 0) goto L8;
        drawBackground(r110, r117, r114, r114 + getWidth(), r115, r211);
    L8:
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled() == false) goto L10;
        r110.drawRect(r114, r115, r114 + getWidth(), r211, getDebugPaint());
    L10:
        TypefaceEmojiRasterizer r100 = getTypefaceRasterizer();
        float r101 = r210;
        if (r117 == null) goto L13;
        r116 = r117;
    L13:
        r100.draw(r110, r114, r101, r116);
    }
}
