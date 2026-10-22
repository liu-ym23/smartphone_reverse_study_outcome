package e;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    @DoNotInline
    public static void a(@NonNull Resources r10, int r11, int r12, @NonNull TypedValue r13, boolean r14) {
        r10.getValueForDensity(r11, r12, r13, r14);
    }
}
