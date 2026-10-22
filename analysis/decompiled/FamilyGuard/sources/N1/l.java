package N1;

import android.text.Layout;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final b f4223a = new a();

    class a implements b {
        a() {
        }

        @Override // N1.l.b
        public void a(TextView textView, int i5, int i6) {
            textView.measure(i5, i6);
        }

        @Override // N1.l.b
        public void b(TextView textView, int i5, float f5) {
            textView.setTextSize(i5, f5);
        }
    }

    public interface b {
        void a(TextView textView, int i5, int i6);

        void b(TextView textView, int i5, float f5);
    }

    public static void a(TextView textView, int i5) {
        b(textView, i5, f4223a);
    }

    public static void b(TextView textView, int i5, b bVar) {
        float textSize = textView.getTextSize();
        int maxLines = textView.getMaxLines();
        if (maxLines <= 0) {
            return;
        }
        textView.setMaxLines(Integer.MAX_VALUE);
        for (float f5 = textSize; f5 > 1.0f; f5 -= 1.0f) {
            try {
                bVar.b(textView, 0, f5);
                if (c(textView, i5, bVar) <= maxLines) {
                    textView.setMaxLines(maxLines);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        bVar.b(textView, 0, textSize);
        textView.setMaxLines(maxLines);
    }

    private static int c(TextView textView, int i5, b bVar) {
        int lineCount;
        bVar.a(textView, View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        Layout layout = textView.getLayout();
        if (layout == null || (lineCount = layout.getLineCount()) <= 0) {
            throw new IllegalStateException();
        }
        return lineCount;
    }
}
