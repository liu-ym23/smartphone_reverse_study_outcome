package e2;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RenderNode;
import android.graphics.fonts.Font;
import android.graphics.text.MeasuredText;
import com.google.crypto.tink.shaded.protobuf.Reader;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends Canvas {

    /* renamed from: a, reason: collision with root package name */
    public Canvas f3433a;

    @Override // android.graphics.Canvas
    public final boolean clipOutPath(Path path) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipOutPath(path);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipOutRect(RectF rectF) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipOutRect(rectF);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipPath(Path path, Region.Op op) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipPath(path, op);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(RectF rectF, Region.Op op) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipRect(rectF, op);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void concat(Matrix matrix) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.concat(matrix);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void disableZ() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.disableZ();
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawARGB(int i, int i3, int i10, int i11) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawARGB(i, i3, i10, i11);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawArc(RectF rectF, float f5, float f10, boolean z10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawArc(rectF, f5, f10, z10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, float f5, float f10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawBitmap(bitmap, f5, f10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmapMesh(Bitmap bitmap, int i, int i3, float[] fArr, int i10, int[] iArr, int i11, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawBitmapMesh(bitmap, i, i3, fArr, i10, iArr, i11, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawCircle(float f5, float f10, float f11, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawCircle(f5, f10, f11, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int i) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawColor(i);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawDoubleRoundRect(RectF rectF, float f5, float f10, RectF rectF2, float f11, float f12, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawDoubleRoundRect(rectF, f5, f10, rectF2, f11, f12, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawGlyphs(int[] iArr, int i, float[] fArr, int i3, int i10, Font font, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawGlyphs(iArr, i, fArr, i3, i10, font, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawLine(float f5, float f10, float f11, float f12, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawLine(f5, f10, f11, f12, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawLines(float[] fArr, int i, int i3, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawLines(fArr, i, i3, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawOval(RectF rectF, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawOval(rectF, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPaint(Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPaint(paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPatch(NinePatch ninePatch, Rect rect, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPatch(ninePatch, rect, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPath(Path path, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPath(path, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture picture) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPicture(picture);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPoint(float f5, float f10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPoint(f5, f10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPoints(float[] fArr, int i, int i3, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPoints(fArr, i, i3, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPosText(char[] cArr, int i, int i3, float[] fArr, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPosText(cArr, i, i3, fArr, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRGB(int i, int i3, int i10) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawRGB(i, i3, i10);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRect(RectF rectF, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawRect(rectF, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRenderNode(RenderNode renderNode) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawRenderNode(renderNode);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRoundRect(RectF rectF, float f5, float f10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawRoundRect(rectF, f5, f10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawText(char[] cArr, int i, int i3, float f5, float f10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawText(cArr, i, i3, f5, f10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawTextOnPath(char[] cArr, int i, int i3, Path path, float f5, float f10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawTextOnPath(cArr, i, i3, path, f5, f10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(char[] cArr, int i, int i3, int i10, int i11, float f5, float f10, boolean z10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawTextRun(cArr, i, i3, i10, i11, f5, f10, z10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawVertices(Canvas.VertexMode vertexMode, int i, float[] fArr, int i3, float[] fArr2, int i10, int[] iArr, int i11, short[] sArr, int i12, int i13, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawVertices(vertexMode, i, fArr, i3, fArr2, i10, iArr, i11, sArr, i12, i13, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void enableZ() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.enableZ();
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean getClipBounds(Rect rect) {
        Canvas canvas = this.f3433a;
        if (canvas == null) {
            k.f("nativeCanvas");
            throw null;
        }
        boolean clipBounds = canvas.getClipBounds(rect);
        if (clipBounds) {
            rect.set(0, 0, rect.width(), Reader.READ_DONE);
        }
        return clipBounds;
    }

    @Override // android.graphics.Canvas
    public final int getDensity() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.getDensity();
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final DrawFilter getDrawFilter() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.getDrawFilter();
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int getHeight() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.getHeight();
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void getMatrix(Matrix matrix) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.getMatrix(matrix);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final int getMaximumBitmapHeight() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.getMaximumBitmapHeight();
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int getMaximumBitmapWidth() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.getMaximumBitmapWidth();
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int getSaveCount() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.getSaveCount();
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int getWidth() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.getWidth();
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean isOpaque() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.isOpaque();
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(RectF rectF, Canvas.EdgeType edgeType) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.quickReject(rectF, edgeType);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void restore() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.restore();
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void restoreToCount(int i) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.restoreToCount(i);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void rotate(float f5) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.rotate(f5);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final int save() {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.save();
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(RectF rectF, Paint paint, int i) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.saveLayer(rectF, paint, i);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(RectF rectF, int i, int i3) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.saveLayerAlpha(rectF, i, i3);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void scale(float f5, float f10) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.scale(f5, f10);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void setBitmap(Bitmap bitmap) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.setBitmap(bitmap);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void setDensity(int i) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.setDensity(i);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void setDrawFilter(DrawFilter drawFilter) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.setDrawFilter(drawFilter);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void setMatrix(Matrix matrix) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.setMatrix(matrix);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void skew(float f5, float f10) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.skew(f5, f10);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void translate(float f5, float f10) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.translate(f5, f10);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawArc(float f5, float f10, float f11, float f12, float f13, float f14, boolean z10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawArc(f5, f10, f11, f12, f13, f14, z10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, Rect rect, RectF rectF, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawBitmap(bitmap, rect, rectF, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(long j10) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawColor(j10);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawDoubleRoundRect(RectF rectF, float[] fArr, RectF rectF2, float[] fArr2, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawDoubleRoundRect(rectF, fArr, rectF2, fArr2, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawLines(float[] fArr, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawLines(fArr, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawOval(float f5, float f10, float f11, float f12, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawOval(f5, f10, f11, f12, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPatch(NinePatch ninePatch, RectF rectF, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPatch(ninePatch, rectF, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture picture, RectF rectF) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPicture(picture, rectF);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPoints(float[] fArr, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPoints(fArr, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPosText(String str, float[] fArr, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPosText(str, fArr, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRect(Rect rect, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawRect(rect, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRoundRect(float f5, float f10, float f11, float f12, float f13, float f14, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawRoundRect(f5, f10, f11, f12, f13, f14, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawText(String str, float f5, float f10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawText(str, f5, f10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawTextOnPath(String str, Path path, float f5, float f10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawTextOnPath(str, path, f5, f10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(CharSequence charSequence, int i, int i3, int i10, int i11, float f5, float f10, boolean z10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawTextRun(charSequence, i, i3, i10, i11, f5, f10, z10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean clipOutRect(Rect rect) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipOutRect(rect);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipPath(Path path) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipPath(path);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(Rect rect, Region.Op op) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipRect(rect, op);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawBitmap(bitmap, rect, rect2, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture picture, Rect rect) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawPicture(picture, rect);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRect(float f5, float f10, float f11, float f12, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawRect(f5, f10, f11, f12, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawText(String str, int i, int i3, float f5, float f10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawText(str, i, i3, f5, f10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(RectF rectF) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.quickReject(rectF);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(RectF rectF, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.saveLayer(rectF, paint);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(RectF rectF, int i) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.saveLayerAlpha(rectF, i);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(RectF rectF) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipRect(rectF);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(int[] iArr, int i, int i3, float f5, float f10, int i10, int i11, boolean z10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawBitmap(iArr, i, i3, f5, f10, i10, i11, z10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawText(CharSequence charSequence, int i, int i3, float f5, float f10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawText(charSequence, i, i3, f5, f10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(float f5, float f10, float f11, float f12, Paint paint, int i) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.saveLayer(f5, f10, f11, f12, paint, i);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(float f5, float f10, float f11, float f12, int i, int i3) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.saveLayerAlpha(f5, f10, f11, f12, i, i3);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(Rect rect) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipRect(rect);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(int[] iArr, int i, int i3, int i10, int i11, int i12, int i13, boolean z10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawBitmap(iArr, i, i3, i10, i11, i12, i13, z10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int i, PorterDuff.Mode mode) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawColor(i, mode);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(MeasuredText measuredText, int i, int i3, int i10, int i11, float f5, float f10, boolean z10, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawTextRun(measuredText, i, i3, i10, i11, f5, f10, z10, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(float f5, float f10, float f11, float f12, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.saveLayer(f5, f10, f11, f12, paint);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(float f5, float f10, float f11, float f12, int i) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.saveLayerAlpha(f5, f10, f11, f12, i);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipOutRect(float f5, float f10, float f11, float f12) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipOutRect(f5, f10, f11, f12);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(float f5, float f10, float f11, float f12, Region.Op op) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipRect(f5, f10, f11, f12, op);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawBitmap(bitmap, matrix, paint);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int i, BlendMode blendMode) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawColor(i, blendMode);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(Path path, Canvas.EdgeType edgeType) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.quickReject(path, edgeType);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(float f5, float f10, float f11, float f12) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipRect(f5, f10, f11, f12);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(Path path) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.quickReject(path);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(int i, int i3, int i10, int i11) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipRect(i, i3, i10, i11);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipOutRect(int i, int i3, int i10, int i11) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.clipOutRect(i, i3, i10, i11);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void drawColor(long j10, BlendMode blendMode) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            canvas.drawColor(j10, blendMode);
        } else {
            k.f("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(float f5, float f10, float f11, float f12, Canvas.EdgeType edgeType) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.quickReject(f5, f10, f11, f12, edgeType);
        }
        k.f("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(float f5, float f10, float f11, float f12) {
        Canvas canvas = this.f3433a;
        if (canvas != null) {
            return canvas.quickReject(f5, f10, f11, f12);
        }
        k.f("nativeCanvas");
        throw null;
    }
}
