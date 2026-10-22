package A7;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LA7/z;", "src", Const.INTENT_KEY_APIKEY, "(LA7/z;)LA7/z;", "Landroid/widget/TextView;", "tv", "Landroid/graphics/Path;", Const.INTENT_KEY_PKGNAME, "(Landroid/widget/TextView;)Landroid/graphics/Path;", "", "c", "(Landroid/widget/TextView;)F", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0756y {
    public static final C0757z a(C0757z src) {
        kotlin.jvm.internal.p.i(src, "src");
        C0757z c0757z = new C0757z();
        c0757z.d(src.getCrossWindow());
        c0757z.j(src.getSdfScale());
        c0757z.i(src.getErode());
        c0757z.h(src.getBlendOnly());
        return c0757z;
    }

    public static final Path b(TextView tv) {
        int i10;
        kotlin.jvm.internal.p.i(tv, "tv");
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
        float extendedPaddingTop = tv.getExtendedPaddingTop() + c(tv);
        float scrollX = tv.getScrollX();
        float scrollY = tv.getScrollY();
        Path path = new Path();
        int lineCount = layout.getLineCount();
        int i11 = 0;
        while (i11 < lineCount) {
            int lineStart = layout.getLineStart(i11);
            int lineVisibleEnd = layout.getLineVisibleEnd(i11);
            if (lineVisibleEnd > lineStart) {
                float lineLeft = layout.getParagraphDirection(i11) == -1 ? layout.getLineLeft(i11) : layout.getPrimaryHorizontal(lineStart);
                i10 = i11;
                Path path2 = new Path();
                paint.getTextPath(str, lineStart, lineVisibleEnd, (lineLeft + totalPaddingLeft) - scrollX, (layout.getLineBaseline(i11) + extendedPaddingTop) - scrollY, path2);
                path.addPath(path2);
            } else {
                i10 = i11;
            }
            i11 = i10 + 1;
        }
        path.setFillType(Path.FillType.WINDING);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        if (rectF.isEmpty() || tv.getWidth() <= 0 || tv.getHeight() <= 0 || rectF.intersects(0.0f, 0.0f, tv.getWidth(), tv.getHeight())) {
            return path;
        }
        Log.w("MotionKit.GlassText", "pathFromTextView: outline [" + rectF.left + Const.STR_MART_COMMA + rectF.top + " " + rectF.width() + "x" + rectF.height() + "] outside view " + tv.getWidth() + "x" + tv.getHeight() + " (scroll=" + scrollX + Const.STR_MART_COMMA + scrollY + " not published yet); retry on pre-draw");
        return new Path();
    }

    public static final float c(TextView textView) {
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
