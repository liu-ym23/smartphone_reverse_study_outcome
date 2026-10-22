package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015JV\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/android/CanvasCompatM;", "", "<init>", "()V", "drawTextRun", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "index", "", "count", "contextIndex", "contextCount", "x", "", "y", "isRtl", "", "paint", "Landroid/graphics/Paint;", "", "start", "end", "contextStart", "contextEnd", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CanvasCompatM {
    public static final CanvasCompatM INSTANCE = null;

    static {
        INSTANCE = new CanvasCompatM();
    }

    private CanvasCompatM() {
    }

    public final void drawTextRun(Canvas r100, CharSequence r101, int r102, int r103, int r104, int r105, float r106, float r107, boolean r108, Paint r110) {
        r100.drawTextRun(r101, r102, r103, r104, r105, r106, r107, r108, r110);
    }

    public final void drawTextRun(Canvas r100, char[] r101, int r102, int r103, int r104, int r105, float r106, float r107, boolean r108, Paint r110) {
        r100.drawTextRun(r101, r102, r103, r104, r105, r106, r107, r108, r110);
    }
}
