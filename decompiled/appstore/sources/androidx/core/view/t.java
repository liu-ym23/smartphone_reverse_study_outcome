package androidx.core.view;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    public static class a {
        @DoNotInline
        public static void a(@NonNull Window r10, boolean r11) {
            r10.setDecorFitsSystemWindows(r11);
        }
    }

    public static WindowInsetsControllerCompat a(Window r10, View r11) {
        return new WindowInsetsControllerCompat(r10, r11);
    }

    public static void b(Window r10, boolean r11) {
        a.a(r10, r11);
    }
}
