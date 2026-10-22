package l8;

import android.text.Layout;
import android.view.View;
import android.widget.TextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10369a = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements b {
        @Override // l8.i.b
        public final void a(TextView textView, int i10, int i11) {
            textView.measure(i10, i11);
        }

        @Override // l8.i.b
        public final void b(TextView textView, float f8) {
            textView.setTextSize(0, f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        void a(TextView textView, int i10, int i11);

        void b(TextView textView, float f8);
    }

    public static void a(TextView textView, int i10, b bVar) {
        int lineCount;
        float textSize = textView.getTextSize();
        int maxLines = textView.getMaxLines();
        if (maxLines <= 0) {
            return;
        }
        textView.setMaxLines(Integer.MAX_VALUE);
        for (float f8 = textSize; f8 > 1.0f; f8 -= 1.0f) {
            try {
                bVar.b(textView, f8);
                bVar.a(textView, View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                Layout layout = textView.getLayout();
                if (layout == null || (lineCount = layout.getLineCount()) <= 0) {
                    throw new IllegalStateException();
                }
                if (lineCount <= maxLines) {
                    textView.setMaxLines(maxLines);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        bVar.b(textView, textSize);
        textView.setMaxLines(maxLines);
    }
}
