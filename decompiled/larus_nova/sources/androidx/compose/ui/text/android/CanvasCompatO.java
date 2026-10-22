package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\nJ.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/android/CanvasCompatO;", "", "<init>", "()V", "clipOutRect", "", "canvas", "Landroid/graphics/Canvas;", SVGRenderEngine.RECT, "Landroid/graphics/RectF;", "Landroid/graphics/Rect;", "left", "", "top", "right", "bottom", "", "clipOutPath", "path", "Landroid/graphics/Path;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CanvasCompatO {
    public static final CanvasCompatO INSTANCE = null;

    static {
        INSTANCE = new CanvasCompatO();
    }

    private CanvasCompatO() {
    }

    public final boolean clipOutPath(Canvas r100, Path r101) {
        return r100.clipOutPath(r101);
    }

    public final boolean clipOutRect(Canvas r100, Rect r101) {
        return r100.clipOutRect(r101);
    }

    public final boolean clipOutRect(Canvas r100, RectF r101) {
        return r100.clipOutRect(r101);
    }

    public final boolean clipOutRect(Canvas r100, float r101, float r102, float r103, float r104) {
        return r100.clipOutRect(r101, r102, r103, r104);
    }

    public final boolean clipOutRect(Canvas r100, int r101, int r102, int r103, int r104) {
        return r100.clipOutRect(r101, r102, r103, r104);
    }
}
