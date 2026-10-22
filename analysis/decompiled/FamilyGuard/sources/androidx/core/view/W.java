package androidx.core.view;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class W {

    static class a {
        static void a(Window window, boolean z5) {
            window.setDecorFitsSystemWindows(z5);
        }
    }

    public static Z a(Window window, View view) {
        return new Z(window, view);
    }

    public static void b(Window window, boolean z5) {
        a.a(window, z5);
    }
}
