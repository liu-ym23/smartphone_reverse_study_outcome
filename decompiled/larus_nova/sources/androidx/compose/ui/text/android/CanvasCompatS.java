package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.fonts.Font;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\rJF\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/android/CanvasCompatS;", "", "<init>", "()V", "drawPatch", "", "canvas", "Landroid/graphics/Canvas;", "patch", "Landroid/graphics/NinePatch;", "dst", "Landroid/graphics/Rect;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/RectF;", "drawGlyphs", "glyphIds", "", "glyphIdOffset", "", "positions", "", "positionOffset", "glyphCount", LynxResourceModule.FONT_TYPE, "Landroid/graphics/fonts/Font;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CanvasCompatS {
    public static final CanvasCompatS INSTANCE = null;

    static {
        INSTANCE = new CanvasCompatS();
    }

    private CanvasCompatS() {
    }

    public final void drawPatch(Canvas r100, NinePatch r101, Rect r102, Paint r103) {
        r100.drawPatch(r101, r102, r103);
    }

    public final void drawPatch(Canvas r100, NinePatch r101, RectF r102, Paint r103) {
        r100.drawPatch(r101, r102, r103);
    }

    public final void drawGlyphs(Canvas r100, int[] r101, int r102, float[] r103, int r104, int r105, Font r106, Paint r107) {
        r100.drawGlyphs(r101, r102, r103, r104, r105, r106, r107);
    }
}
