package t0;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.graphics.BlendModeCompat;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<B0.d<Rect, Rect>> f41981a = new ThreadLocal<>();

    public static class a {
        public static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static class b {
        public static void a(Paint paint, Object obj) {
            paint.setBlendMode((BlendMode) obj);
        }
    }

    public static boolean a(Paint paint, String str) {
        return a.a(paint, str);
    }

    public static boolean b(Paint paint, BlendModeCompat blendModeCompat) {
        b.a(paint, blendModeCompat != null ? C5501c.a(blendModeCompat) : null);
        return true;
    }
}
