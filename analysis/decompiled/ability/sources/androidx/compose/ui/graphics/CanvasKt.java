package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\"\u0010\b\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001a2\u0010\u000e\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a)\u0010\u0014\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015\u001a-\u0010\u0017\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0015\u001a3\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmap;", "image", "Landroidx/compose/ui/graphics/Canvas;", "Canvas", "(Landroidx/compose/ui/graphics/ImageBitmap;)Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/Function0;", "LC7/r;", "block", "withSave", "(Landroidx/compose/ui/graphics/Canvas;LS7/a;)V", "Landroidx/compose/ui/geometry/Rect;", "bounds", "Landroidx/compose/ui/graphics/Paint;", "paint", "withSaveLayer", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/graphics/Paint;LS7/a;)V", "", "degrees", "pivotX", "pivotY", "rotate", "(Landroidx/compose/ui/graphics/Canvas;FFF)V", "radians", "rotateRad", "sx", "sy", "scale", "(Landroidx/compose/ui/graphics/Canvas;FFFF)V", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final Canvas Canvas(ImageBitmap imageBitmap) {
        return AndroidCanvas_androidKt.ActualCanvas(imageBitmap);
    }

    public static final void rotate(Canvas canvas, float f, float f7, float f9) {
        if (f == 0.0f) {
            return;
        }
        canvas.translate(f7, f9);
        canvas.rotate(f);
        canvas.translate(-f7, -f9);
    }

    public static final void rotateRad(Canvas canvas, float f, float f7, float f9) {
        rotate(canvas, DegreesKt.degrees(f), f7, f9);
    }

    public static /* synthetic */ void rotateRad$default(Canvas canvas, float f, float f7, float f9, int i, Object obj) {
        if ((i & 2) != 0) {
            f7 = 0.0f;
        }
        if ((i & 4) != 0) {
            f9 = 0.0f;
        }
        rotateRad(canvas, f, f7, f9);
    }

    public static final void scale(Canvas canvas, float f, float f7, float f9, float f10) {
        if (f == 1.0f && f7 == 1.0f) {
            return;
        }
        canvas.translate(f9, f10);
        canvas.scale(f, f7);
        canvas.translate(-f9, -f10);
    }

    public static /* synthetic */ void scale$default(Canvas canvas, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 2) != 0) {
            f7 = f;
        }
        scale(canvas, f, f7, f9, f10);
    }

    public static final void withSave(Canvas canvas, S7.a aVar) {
        try {
            canvas.save();
            aVar.invoke();
        } finally {
            canvas.restore();
        }
    }

    public static final void withSaveLayer(Canvas canvas, Rect rect, Paint paint, S7.a aVar) {
        try {
            canvas.saveLayer(rect, paint);
            aVar.invoke();
        } finally {
            canvas.restore();
        }
    }
}
