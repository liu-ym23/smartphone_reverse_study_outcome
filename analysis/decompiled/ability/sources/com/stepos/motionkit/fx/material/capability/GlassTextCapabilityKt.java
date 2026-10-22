package com.stepos.motionkit.fx.material.capability;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"cloneGlassTextParams", "Lcom/stepos/motionkit/fx/material/capability/GlassTextParams;", "src", "pathFromTextView", "Landroid/graphics/Path;", "tv", "Landroid/widget/TextView;", "verticalOffsetFromGravity", "", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GlassTextCapabilityKt {
    public static final GlassTextParams cloneGlassTextParams(GlassTextParams src) {
        k.f(src, "src");
        GlassTextParams glassTextParams = new GlassTextParams();
        glassTextParams.setCrossWindow$motionkit_fx_release(src.getCrossWindow());
        glassTextParams.setSdfScale(src.getSdfScale());
        glassTextParams.setErode(src.getErode());
        glassTextParams.setUseTextMask$motionkit_fx_release(src.getUseTextMask());
        glassTextParams.setHasBackdropBlur$motionkit_fx_release(src.getHasBackdropBlur());
        return glassTextParams;
    }

    public static final Path pathFromTextView(TextView tv) {
        int i;
        k.f(tv, "tv");
        CharSequence text = tv.getText();
        if (text == null || text.length() == 0) {
            Log.w("MotionKit.GlassText", "pathFromTextView: empty text");
            return new Path();
        }
        Layout layout = tv.getLayout();
        if (layout == null) {
            Log.w("MotionKit.GlassText", "pathFromTextView: layout == null; will retry on pre-draw");
            return new Path();
        }
        CharSequence text2 = layout.getText();
        String string = text2 != null ? text2.toString() : null;
        if (string == null) {
            string = "";
        }
        String str = string;
        if (str.length() == 0) {
            TransformationMethod transformationMethod = tv.getTransformationMethod();
            Log.w("MotionKit.GlassText", "pathFromTextView: layout text empty after transformation (tm=" + (transformationMethod != null ? transformationMethod.getClass().getSimpleName() : null) + ")");
            return new Path();
        }
        Paint paint = new Paint(layout.getPaint());
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.LEFT);
        if (Build.VERSION.SDK_INT >= 35) {
            paint.setFlags(paint.getFlags() | 24576);
        }
        float totalPaddingLeft = tv.getTotalPaddingLeft();
        float extendedPaddingTop = tv.getExtendedPaddingTop() + verticalOffsetFromGravity(tv);
        float scrollX = tv.getScrollX();
        float scrollY = tv.getScrollY();
        Path path = new Path();
        int lineCount = layout.getLineCount();
        int i6 = 0;
        while (i6 < lineCount) {
            int lineStart = layout.getLineStart(i6);
            int lineVisibleEnd = layout.getLineVisibleEnd(i6);
            if (lineVisibleEnd > lineStart) {
                float lineLeft = layout.getParagraphDirection(i6) == -1 ? layout.getLineLeft(i6) : layout.getPrimaryHorizontal(lineStart);
                i = i6;
                Path path2 = new Path();
                paint.getTextPath(str, lineStart, lineVisibleEnd, (lineLeft + totalPaddingLeft) - scrollX, (layout.getLineBaseline(i6) + extendedPaddingTop) - scrollY, path2);
                path.addPath(path2);
            } else {
                i = i6;
            }
            i6 = i + 1;
        }
        path.setFillType(Path.FillType.WINDING);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        if (rectF.isEmpty() || tv.getWidth() <= 0 || tv.getHeight() <= 0 || rectF.intersects(0.0f, 0.0f, tv.getWidth(), tv.getHeight())) {
            return path;
        }
        float f = rectF.left;
        float f7 = rectF.top;
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        int width = tv.getWidth();
        int height = tv.getHeight();
        StringBuilder sb = new StringBuilder("pathFromTextView: outline [");
        sb.append(f);
        sb.append(",");
        sb.append(f7);
        sb.append(" ");
        sb.append(fWidth);
        sb.append("x");
        sb.append(fHeight);
        sb.append("] outside view ");
        androidx.constraintlayout.core.dsl.a.y(sb, width, "x", height, " (scroll=");
        sb.append(scrollX);
        sb.append(",");
        sb.append(scrollY);
        sb.append(" not published yet); retry on pre-draw");
        Log.w("MotionKit.GlassText", sb.toString());
        return new Path();
    }

    private static final float verticalOffsetFromGravity(TextView textView) {
        int gravity;
        int measuredHeight;
        int height;
        Layout layout = textView.getLayout();
        if (layout == null || (gravity = textView.getGravity() & 112) == 48 || (height = layout.getHeight()) >= (measuredHeight = (textView.getMeasuredHeight() - textView.getExtendedPaddingTop()) - textView.getExtendedPaddingBottom())) {
            return 0.0f;
        }
        return gravity == 80 ? measuredHeight - height : r3 >> 1;
    }
}
