package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: classes.dex */
public final class p extends i {

    /* renamed from: g, reason: collision with root package name */
    private static Paint f10381g;

    /* renamed from: f, reason: collision with root package name */
    private TextPaint f10382f;

    public p(o oVar) {
        super(oVar);
    }

    private TextPaint c(CharSequence charSequence, int i5, int i6, Paint paint) {
        if (!(charSequence instanceof Spanned)) {
            if (paint instanceof TextPaint) {
                return (TextPaint) paint;
            }
            return null;
        }
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i5, i6, CharacterStyle.class);
        if (characterStyleArr.length != 0) {
            if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                TextPaint textPaint = this.f10382f;
                if (textPaint == null) {
                    textPaint = new TextPaint();
                    this.f10382f = textPaint;
                }
                textPaint.set(paint);
                for (CharacterStyle characterStyle : characterStyleArr) {
                    characterStyle.updateDrawState(textPaint);
                }
                return textPaint;
            }
        }
        if (paint instanceof TextPaint) {
            return (TextPaint) paint;
        }
        return null;
    }

    private static Paint e() {
        if (f10381g == null) {
            TextPaint textPaint = new TextPaint();
            f10381g = textPaint;
            textPaint.setColor(e.c().d());
            f10381g.setStyle(Paint.Style.FILL);
        }
        return f10381g;
    }

    void d(Canvas canvas, TextPaint textPaint, float f5, float f6, float f7, float f8) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f5, f7, f6, f8, textPaint);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i5, int i6, float f5, int i7, int i8, int i9, Paint paint) {
        TextPaint textPaintC = c(charSequence, i5, i6, paint);
        if (textPaintC != null && textPaintC.bgColor != 0) {
            d(canvas, textPaintC, f5, f5 + b(), i7, i9);
        }
        Paint paint2 = textPaintC;
        if (e.c().j()) {
            canvas.drawRect(f5, i7, f5 + b(), i9, e());
        }
        o oVarA = a();
        float f6 = i8;
        if (paint2 == null) {
            paint2 = paint;
        }
        oVarA.a(canvas, f5, f6, paint2);
    }
}
