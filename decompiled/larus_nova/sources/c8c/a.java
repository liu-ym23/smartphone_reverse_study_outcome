package c8c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ImageSpan {
    public a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super(r100);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Paint.FontMetricsInt r109 = r108.getFontMetricsInt();
        float r110 = r106;
        float r111 = ((r109.descent + r110) + r110) + r109.ascent;
        float r112 = 2;
        float r113 = (r111 / r112) - (getDrawable().getBounds().bottom / r112);
        r100.save();
        r100.translate(r104, r113);
        getDrawable().draw(r100);
        r100.restore();
    }
}
