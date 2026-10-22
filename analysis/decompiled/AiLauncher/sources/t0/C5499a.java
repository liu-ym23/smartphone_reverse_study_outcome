package t0;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import androidx.core.graphics.BlendModeCompat;

/* renamed from: t0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5499a {

    /* renamed from: t0.a$a, reason: collision with other inner class name */
    public static class C0528a {
        public static ColorFilter a(int i10, Object obj) {
            return new BlendModeColorFilter(i10, (BlendMode) obj);
        }
    }

    public static ColorFilter a(int i10, BlendModeCompat blendModeCompat) {
        Object objA = C5501c.a(blendModeCompat);
        if (objA != null) {
            return C0528a.a(i10, objA);
        }
        return null;
    }
}
