package androidx.compose.ui.text.android;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.text.MeasuredText;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJF\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J6\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019JV\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*¨\u0006+"}, d2 = {"Landroidx/compose/ui/text/android/CanvasCompatQ;", "", "<init>", "()V", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "disableZ", "drawColor", "color", "", "", "mode", "Landroid/graphics/BlendMode;", "drawDoubleRoundRect", RNParamRegisterEventHandler.SRC_OUTER, "Landroid/graphics/RectF;", "outerRx", "", "outerRy", RNParamRegisterEventHandler.SRC_INNER, "innerRx", "innerRy", "paint", "Landroid/graphics/Paint;", "outerRadii", "", "innerRadii", "drawTextRun", "text", "Landroid/graphics/text/MeasuredText;", "start", "end", "contextStart", "contextEnd", "x", "y", "isRtl", "", "drawRenderNode", "renderNode", "Landroid/graphics/RenderNode;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CanvasCompatQ {
    public static final CanvasCompatQ INSTANCE = null;

    static {
        INSTANCE = new CanvasCompatQ();
    }

    private CanvasCompatQ() {
    }

    public final void disableZ(Canvas r100) {
        r100.disableZ();
    }

    public final void enableZ(Canvas r100) {
        r100.enableZ();
    }

    public final void drawColor(Canvas r100, long r101) {
        r100.drawColor(r101);
    }

    public final void drawRenderNode(Canvas r100, RenderNode r101) {
        r100.drawRenderNode(r101);
    }

    public final void drawColor(Canvas r100, int r101, BlendMode r102) {
        r100.drawColor(r101, r102);
    }

    public final void drawColor(Canvas r100, long r101, BlendMode r102) {
        r100.drawColor(r101, r102);
    }

    public final void drawDoubleRoundRect(Canvas r100, RectF r101, float[] r102, RectF r103, float[] r104, Paint r105) {
        r100.drawDoubleRoundRect(r101, r102, r103, r104, r105);
    }

    public final void drawDoubleRoundRect(Canvas r100, RectF r101, float r102, float r103, RectF r104, float r105, float r106, Paint r107) {
        r100.drawDoubleRoundRect(r101, r102, r103, r104, r105, r106, r107);
    }

    public final void drawTextRun(Canvas r100, MeasuredText r101, int r102, int r103, int r104, int r105, float r106, float r107, boolean r108, Paint r110) {
        r100.drawTextRun(r101, r102, r103, r104, r105, r106, r107, r108, r110);
    }
}
