package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.core.graphics.a$a, reason: collision with other inner class name */
    public static class C0016a {
        @DoNotInline
        public static ColorFilter a(int r10, Object r11) {
            return new BlendModeColorFilter(r10, (BlendMode) r11);
        }
    }

    public static ColorFilter a(int r10, BlendModeCompat r11) {
        Object r12 = c.a(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return C0016a.a(r10, r12);
    }
}
