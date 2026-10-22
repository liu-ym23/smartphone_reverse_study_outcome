package androidx.core.widget;

import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class n {
    @DoNotInline
    public static void a(@NonNull TextView textView, int i4, @FloatRange(from = 0.0d) float f4) {
        textView.setLineHeight(i4, f4);
    }
}
