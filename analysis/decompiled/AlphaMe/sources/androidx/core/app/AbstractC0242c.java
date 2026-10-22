package androidx.core.app;

import android.app.Activity;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0242c {
    @DoNotInline
    public static boolean a(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
