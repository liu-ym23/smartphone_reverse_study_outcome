package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public final class l extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Paint f3108f;

    public l(EmojiMetadata r10) {
        super(r10);
    }

    public static Paint c() {
        if (f3108f != null) goto L6;
        TextPaint r10 = new TextPaint();
        f3108f = r10;
        r10.setColor(EmojiCompat.b().c());
        f3108f.setStyle(Paint.Style.FILL);
    L6:
        return f3108f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r10, CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, Paint r18) {
        if (EmojiCompat.b().i() == false) goto L5;
        r10.drawRect(r14, r15, r14 + b(), r17, c());
    L5:
        a().a(r10, r14, r16, r18);
    }
}
