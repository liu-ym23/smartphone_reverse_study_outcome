package K;

import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class V {
    @DoNotInline
    public static int a(@NonNull ViewConfiguration viewConfiguration, int i4, int i5, int i6) {
        return viewConfiguration.getScaledMaximumFlingVelocity(i4, i5, i6);
    }

    @DoNotInline
    public static int b(@NonNull ViewConfiguration viewConfiguration, int i4, int i5, int i6) {
        return viewConfiguration.getScaledMinimumFlingVelocity(i4, i5, i6);
    }
}
