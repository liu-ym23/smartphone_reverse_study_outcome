package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/android/CanvasCompatR;", "", "<init>", "()V", "quickReject", "", "canvas", "Landroid/graphics/Canvas;", SVGRenderEngine.RECT, "Landroid/graphics/RectF;", "path", "Landroid/graphics/Path;", "left", "", "top", "right", "bottom", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CanvasCompatR {
    public static final CanvasCompatR INSTANCE = null;

    static {
        INSTANCE = new CanvasCompatR();
    }

    private CanvasCompatR() {
    }

    public final boolean quickReject(Canvas r100, Path r101) {
        return r100.quickReject(r101);
    }

    public final boolean quickReject(Canvas r100, RectF r101) {
        return r100.quickReject(r101);
    }

    public final boolean quickReject(Canvas r100, float r101, float r102, float r103, float r104) {
        return r100.quickReject(r101, r102, r103, r104);
    }
}
