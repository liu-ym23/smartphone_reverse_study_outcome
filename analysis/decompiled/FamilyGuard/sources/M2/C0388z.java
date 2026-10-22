package M2;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.widget.TextView;
import org.libpag.BuildConfig;

/* renamed from: M2.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0388z {
    public static final A a(A a6) {
        j4.k.g(a6, "src");
        A a7 = new A();
        a7.d(a6.b());
        a7.j(a6.g());
        a7.i(a6.f());
        a7.h(a6.e());
        return a7;
    }

    public static final Path b(TextView textView) {
        int i5;
        j4.k.g(textView, "tv");
        CharSequence text = textView.getText();
        if (text == null || text.length() == 0) {
            Log.w("MotionKit.GlassText", "pathFromTextView: empty text");
            return new Path();
        }
        Layout layout = textView.getLayout();
        if (layout == null) {
            Log.w("MotionKit.GlassText", "pathFromTextView: layout == null; will retry on pre-draw");
            return new Path();
        }
        CharSequence text2 = layout.getText();
        String string = text2 != null ? text2.toString() : null;
        if (string == null) {
            string = BuildConfig.FLAVOR;
        }
        String str = string;
        if (str.length() == 0) {
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            Log.w("MotionKit.GlassText", "pathFromTextView: layout text empty after transformation (tm=" + (transformationMethod != null ? transformationMethod.getClass().getSimpleName() : null) + ")");
            return new Path();
        }
        Paint paint = new Paint(layout.getPaint());
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.LEFT);
        if (Build.VERSION.SDK_INT >= 35) {
            paint.setFlags(paint.getFlags() | 24576);
        }
        float totalPaddingLeft = textView.getTotalPaddingLeft();
        float extendedPaddingTop = textView.getExtendedPaddingTop() + c(textView);
        float scrollX = textView.getScrollX();
        float scrollY = textView.getScrollY();
        Path path = new Path();
        int lineCount = layout.getLineCount();
        int i6 = 0;
        while (i6 < lineCount) {
            int lineStart = layout.getLineStart(i6);
            int lineVisibleEnd = layout.getLineVisibleEnd(i6);
            if (lineVisibleEnd > lineStart) {
                float lineLeft = layout.getParagraphDirection(i6) == -1 ? layout.getLineLeft(i6) : layout.getPrimaryHorizontal(lineStart);
                i5 = i6;
                Path path2 = new Path();
                paint.getTextPath(str, lineStart, lineVisibleEnd, (lineLeft + totalPaddingLeft) - scrollX, (layout.getLineBaseline(i6) + extendedPaddingTop) - scrollY, path2);
                path.addPath(path2);
            } else {
                i5 = i6;
            }
            i6 = i5 + 1;
        }
        path.setFillType(Path.FillType.WINDING);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        if (rectF.isEmpty() || textView.getWidth() <= 0 || textView.getHeight() <= 0 || rectF.intersects(0.0f, 0.0f, textView.getWidth(), textView.getHeight())) {
            return path;
        }
        Log.w("MotionKit.GlassText", "pathFromTextView: outline [" + rectF.left + "," + rectF.top + " " + rectF.width() + "x" + rectF.height() + "] outside view " + textView.getWidth() + "x" + textView.getHeight() + " (scroll=" + scrollX + "," + scrollY + " not published yet); retry on pre-draw");
        return new Path();
    }

    private static final float c(TextView textView) {
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
