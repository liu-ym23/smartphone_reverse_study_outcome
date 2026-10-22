package stepos.view.effects;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewRootImpl;
import com.android.internal.graphics.drawable.BackgroundBlurDrawable;

/* loaded from: classes.dex */
public final class StepOSBackgroundBlur {
    private static final String TAG = "StepOSBackgroundBlur";

    private StepOSBackgroundBlur() {
    }

    public static Drawable createBackgroundBlurDrawable(View view) {
        try {
            ViewRootImpl viewRoot = view.getViewRootImpl();
            if (viewRoot == null) {
                Log.w(TAG, "ViewRootImpl is null (view not attached); skipping");
                return null;
            }
            return viewRoot.createBackgroundBlurDrawable();
        } catch (LinkageError e) {
            Log.w(TAG, "createBackgroundBlurDrawable unavailable on this build; skipping", e);
            return null;
        }
    }

    public static void setBlurRadius(Drawable drawable, int radius) {
        ((BackgroundBlurDrawable) drawable).setBlurRadius(radius);
    }

    public static void setCornerRadius(Drawable drawable, float radius) {
        ((BackgroundBlurDrawable) drawable).setCornerRadius(radius);
    }

    public static void setColor(Drawable drawable, int color) {
        ((BackgroundBlurDrawable) drawable).setColor(color);
    }
}
