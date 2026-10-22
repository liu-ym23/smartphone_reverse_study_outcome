package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0241b {
    @DoNotInline
    public static void a(Object obj) {
        ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
    }

    @DoNotInline
    public static void b(Activity activity, String[] strArr, int i4) {
        activity.requestPermissions(strArr, i4);
    }

    @DoNotInline
    public static boolean c(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
