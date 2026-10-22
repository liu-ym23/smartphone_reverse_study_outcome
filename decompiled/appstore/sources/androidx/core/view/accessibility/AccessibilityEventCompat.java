package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class AccessibilityEventCompat {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ContentChangeType {
    }

    public static class a {
        @DoNotInline
        public static int a(AccessibilityEvent r10) {
            return r10.getContentChangeTypes();
        }

        @DoNotInline
        public static void b(AccessibilityEvent r10, int r11) {
            r10.setContentChangeTypes(r11);
        }
    }

    public static int a(AccessibilityEvent r10) {
        return a.a(r10);
    }

    public static void b(AccessibilityEvent r10, int r11) {
        a.b(r10, r11);
    }
}
