package K;

import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class T {
    @DoNotInline
    public static float a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    @DoNotInline
    public static float b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }
}
