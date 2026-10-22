package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a$\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0001\u001a,\u0010\u000f\u001a\u00020\t*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0002¨\u0006\u0010"}, d2 = {"getCharSequenceBounds", "Landroid/graphics/Rect;", "Landroid/text/TextPaint;", "text", "", "startInclusive", "", "endExclusive", "extendWith", "", SVGRenderEngine.RECT, "getStringBounds", "Landroid/graphics/Paint;", "start", "end", "fillStringBounds", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PaintExtensions_androidKt {
    private static final void extendWith(Rect r100, Rect r101) {
        r100.right += r101.width();
        r100.top = Math.min(r100.top, r101.top);
        r100.bottom = Math.max(r100.bottom, r101.bottom);
    }

    public static final Rect getCharSequenceBounds(TextPaint r110, CharSequence r111, int r112, int r113) {
        if ((r111 instanceof Spanned) == false) goto L18;
        Spanned r100 = (Spanned) r111;
        if (SpannedExtensions_androidKt.hasSpan(r100, MetricAffectingSpan.class, r112, r113) == false) goto L18;
        Rect r101 = new Rect();
        Rect r102 = new Rect();
        TextPaint r103 = new TextPaint();
    L8:
        if (r112 >= r113) goto L16;
        int r104 = r100.nextSpanTransition(r112, r113, MetricAffectingSpan.class);
        MetricAffectingSpan[] r105 = (MetricAffectingSpan[]) r100.getSpans(r112, r104, MetricAffectingSpan.class);
        r103.set(r110);
        Iterator r106 = ArrayIteratorKt.iterator(r105);
    L11:
        if (r106.hasNext() == false) goto L15;
        MetricAffectingSpan r107 = (MetricAffectingSpan) r106.next();
        if (r100.getSpanStart(r107) == r100.getSpanEnd(r107)) goto L11;
        r107.updateMeasureState(r103);
        goto L11
    L15:
        fillStringBounds(r103, r111, r112, r104, r102);
        extendWith(r101, r102);
        r112 = r104;
        goto L8
    L16:
        return r101;
    L18:
        return getStringBounds(r110, r111, r112, r113);
    }

    public static final Rect getStringBounds(Paint r100, CharSequence r101, int r102, int r103) {
        Rect r104 = new Rect();
        fillStringBounds(r100, r101, r102, r103, r104);
        return r104;
    }

    private static final void fillStringBounds(Paint r100, CharSequence r101, int r102, int r103, Rect r104) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        Paint29.getTextBounds(r100, r101, r102, r103, r104);
        return;
    L5:
        r100.getTextBounds(r101.toString(), r102, r103, r104);
    }
}
