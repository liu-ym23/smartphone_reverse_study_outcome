package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0086\b\u001a+\u0010\b\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0086\b\u001a\"\u0010\r\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f\u001a&\u0010\u0012\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u001a,\u0010\u0014\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¨\u0006\u0017"}, d2 = {"Canvas", "Landroidx/compose/ui/graphics/Canvas;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "withSave", "", "block", "Lkotlin/Function0;", "withSaveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "rotate", "degrees", "", "pivotX", "pivotY", "rotateRad", "radians", "scale", "sx", "sy", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CanvasKt {
    public static final Canvas Canvas(ImageBitmap r100) {
        return AndroidCanvas_androidKt.ActualCanvas(r100);
    }

    public static final void withSave(Canvas r100, Function0<Unit> r101) {
        r100.save();     // Catch: Throwable -> L6
        r101.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restore();
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restore();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void rotate(Canvas r100, float r101, float r102, float r103) {
        if (r101 != 0.0f) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return;
    L8:
        r100.translate(r102, r103);
        r100.rotate(r101);
        r100.translate(-r102, -r103);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static final void rotateRad(Canvas r100, float r101, float r102, float r103) {
        rotate(r100, DegreesKt.degrees(r101), r102, r103);
    }

    public static final void withSaveLayer(Canvas r100, Rect r101, Paint r102, Function0<Unit> r103) {
        r100.saveLayer(r101, r102);     // Catch: Throwable -> L6
        r103.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restore();
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restore();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void scale(Canvas r100, float r101, float r102, float r103, float r104) {
        boolean r105 = true;
        if (r101 != 1.0f) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L8;
    L13:
        r100.translate(r103, r104);
        r100.scale(r101, r102);
        r100.translate(-r103, -r104);
        return;
    L8:
        if (r102 == 1.0f) goto L11;
        r105 = false;
    L11:
        if (r105 == false) goto L13;
        return;
    L5:
        r106 = false;
        goto L6
    }

    public static /* synthetic */ void rotateRad$default(Canvas r100, float r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0.0f;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = 0.0f;
    L8:
        rotateRad(r100, r101, r102, r103);
    }

    public static /* synthetic */ void scale$default(Canvas r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L5;
        r102 = r101;
    L5:
        scale(r100, r101, r102, r103, r104);
    }
}
