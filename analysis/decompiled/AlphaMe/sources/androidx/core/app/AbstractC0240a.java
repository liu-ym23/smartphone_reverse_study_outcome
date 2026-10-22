package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0240a {
    @DoNotInline
    public static void a(Activity activity) {
        activity.finishAfterTransition();
    }

    @DoNotInline
    public static void b(Activity activity) {
        activity.postponeEnterTransition();
    }

    @DoNotInline
    public static void c(Activity activity, SharedElementCallback sharedElementCallback) {
        activity.setEnterSharedElementCallback(sharedElementCallback);
    }

    @DoNotInline
    public static void d(Activity activity, SharedElementCallback sharedElementCallback) {
        activity.setExitSharedElementCallback(sharedElementCallback);
    }

    @DoNotInline
    public static void e(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
