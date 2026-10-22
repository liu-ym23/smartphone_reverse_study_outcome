package K;

import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class U {
    @DoNotInline
    public static int a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    @DoNotInline
    public static boolean b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
