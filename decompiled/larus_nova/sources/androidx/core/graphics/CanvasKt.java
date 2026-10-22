package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a0\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aD\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aN\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¨\u0006\u001e"}, d2 = {"withClip", "", "Landroid/graphics/Canvas;", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withRotation", "degrees", "pivotX", "pivotY", "withSave", "withScale", "x", "y", "withSkew", "withTranslation", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CanvasKt {
    public static final void withSave(Canvas r100, Function1<? super Canvas, Unit> r101) {
        int r102 = r100.save();
        r101.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r102);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r102);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r100, Path r101, Function1<? super Canvas, Unit> r102) {
        int r103 = r100.save();
        r100.clipPath(r101);
        r102.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r103);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r103);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withMatrix(Canvas r100, Matrix r101, Function1<? super Canvas, Unit> r102) {
        int r103 = r100.save();
        r100.concat(r101);
        r102.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r103);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r103);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r100, Rect r101, Function1<? super Canvas, Unit> r102) {
        int r103 = r100.save();
        r100.clipRect(r101);
        r102.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r103);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r103);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r100, RectF r101, Function1<? super Canvas, Unit> r102) {
        int r103 = r100.save();
        r100.clipRect(r101);
        r102.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r103);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r103);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withSkew(Canvas r100, float r101, float r102, Function1<? super Canvas, Unit> r103) {
        int r104 = r100.save();
        r100.skew(r101, r102);
        r103.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r104);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r104);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withTranslation(Canvas r100, float r101, float r102, Function1<? super Canvas, Unit> r103) {
        int r104 = r100.save();
        r100.translate(r101, r102);
        r103.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r104);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r104);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withMatrix$default(Canvas r100, Matrix r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = new Matrix();
    L5:
        int r105 = r100.save();
        r100.concat(r101);
        r102.invoke(r100);     // Catch: Throwable -> L9
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r105);
        InlineMarker.finallyEnd(1);
        return;
    L9:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r105);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withRotation(Canvas r100, float r101, float r102, float r103, Function1<? super Canvas, Unit> r104) {
        int r105 = r100.save();
        r100.rotate(r101, r102, r103);
        r104.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r105);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r105);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r100, float r101, float r102, float r103, float r104, Function1<? super Canvas, Unit> r105) {
        int r106 = r100.save();
        r100.clipRect(r101, r102, r103, r104);
        r105.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r106);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r106);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withScale(Canvas r100, float r101, float r102, float r103, float r104, Function1<? super Canvas, Unit> r105) {
        int r106 = r100.save();
        r100.scale(r101, r102, r103, r104);
        r105.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r106);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r106);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withSkew$default(Canvas r100, float r101, float r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0.0f;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = 0.0f;
    L8:
        int r106 = r100.save();
        r100.skew(r101, r102);
        r103.invoke(r100);     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r106);
        InlineMarker.finallyEnd(1);
        return;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r106);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withTranslation$default(Canvas r100, float r101, float r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0.0f;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = 0.0f;
    L8:
        int r106 = r100.save();
        r100.translate(r101, r102);
        r103.invoke(r100);     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r106);
        InlineMarker.finallyEnd(1);
        return;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r106);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r100, int r101, int r102, int r103, int r104, Function1<? super Canvas, Unit> r105) {
        int r106 = r100.save();
        r100.clipRect(r101, r102, r103, r104);
        r105.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r106);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r106);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withRotation$default(Canvas r100, float r101, float r102, float r103, Function1 r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = 0.0f;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = 0.0f;
    L9:
        if ((r105 & 4) == 0) goto L11;
        r103 = 0.0f;
    L11:
        int r107 = r100.save();
        r100.rotate(r101, r102, r103);
        r104.invoke(r100);     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r107);
        InlineMarker.finallyEnd(1);
        return;
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r107);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withScale$default(Canvas r100, float r101, float r102, float r103, float r104, Function1 r105, int r106, Object r107) {
        if ((r106 & 1) == 0) goto L6;
        r101 = 1.0f;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r102 = 1.0f;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r103 = 0.0f;
    L12:
        if ((r106 & 8) == 0) goto L14;
        r104 = 0.0f;
    L14:
        int r108 = r100.save();
        r100.scale(r101, r102, r103, r104);
        r105.invoke(r100);     // Catch: Throwable -> L18
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r108);
        InlineMarker.finallyEnd(1);
        return;
    L18:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.restoreToCount(r108);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
