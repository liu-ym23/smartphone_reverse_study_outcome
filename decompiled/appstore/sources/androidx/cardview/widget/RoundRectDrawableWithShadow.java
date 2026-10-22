package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoundRectDrawableWithShadow extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f1167a = 0.0d;

    public interface RoundRectHelper {
        void drawRoundRect(Canvas r10, RectF r11, float r12, Paint r13);
    }

    static {
        f1167a = Math.cos(Math.toRadians(45.0d));
    }

    public static float a(float r10, float r11, boolean r12) {
        if (r12 == true) goto L4;
        return r10;
    L4:
        return (float) (((double) r10) + ((1.0d - f1167a) * ((double) r11)));
    }

    public static float b(float r10, float r11, boolean r12) {
        if (r12 == false) goto L7;
        return (float) (((double) (r10 * 1.5f)) + ((1.0d - f1167a) * ((double) r11)));
    L7:
        return r10 * 1.5f;
    }
}
