package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udfffd";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = null;

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean hasGlyph(Paint r0, String r1) {
            return r0.hasGlyph(r1);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setBlendMode(Paint r0, Object r1) {
            r0.setBlendMode((BlendMode) r1);
        }
    }

    static {
        sRectThreadLocal = new ThreadLocal();
    }

    public static boolean hasGlyph(Paint r0, String r1) {
        return Api23Impl.hasGlyph(r0, r1);
    }

    public static boolean setBlendMode(Paint r0, BlendModeCompat r1) {
        if (r1 == null) goto L4;
        Object r2 = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(r1);
    L5:
        Api29Impl.setBlendMode(r0, r2);
        return true;
    L4:
        r2 = null;
        goto L5
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        ThreadLocal<Pair<Rect, Rect>> r0 = sRectThreadLocal;
        Pair<Rect, Rect> r1 = r0.get();
        if (r1 != null) goto L5;
        Pair<Rect, Rect> r2 = new Pair(new Rect(), new Rect());
        r0.set(r2);
        return r2;
    L5:
        r1.first.setEmpty();
        r1.second.setEmpty();
        return r1;
    }

    private PaintCompat() {
    }
}
