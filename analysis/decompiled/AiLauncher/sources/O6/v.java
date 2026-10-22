package O6;

import android.text.Layout;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class v {
    private static final b DEFAULT_CALLBACK = new a();

    public class a implements b {
        @Override // O6.v.b
        public void a(TextView textView, int i10, int i11) {
            textView.measure(i10, i11);
        }

        @Override // O6.v.b
        public void b(TextView textView, int i10, float f10) {
            textView.setTextSize(i10, f10);
        }
    }

    public interface b {
        void a(TextView textView, int i10, int i11);

        void b(TextView textView, int i10, float f10);
    }

    public static void a(TextView textView, int i10) {
        b(textView, i10, DEFAULT_CALLBACK);
    }

    public static void b(TextView textView, int i10, b bVar) {
        float textSize = textView.getTextSize();
        int maxLines = textView.getMaxLines();
        if (maxLines <= 0) {
            return;
        }
        textView.setMaxLines(Integer.MAX_VALUE);
        for (float f10 = textSize; f10 > 1.0f; f10 -= 1.0f) {
            try {
                bVar.b(textView, 0, f10);
                if (c(textView, i10, bVar) <= maxLines) {
                    textView.setMaxLines(maxLines);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        bVar.b(textView, 0, textSize);
        textView.setMaxLines(maxLines);
    }

    public static int c(TextView textView, int i10, b bVar) {
        int lineCount;
        bVar.a(textView, View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        Layout layout = textView.getLayout();
        if (layout == null || (lineCount = layout.getLineCount()) <= 0) {
            throw new IllegalStateException();
        }
        return lineCount;
    }
}
