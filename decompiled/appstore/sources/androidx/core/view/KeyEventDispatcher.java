package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyEventDispatcher {

    public interface Component {
        boolean superDispatchKeyEvent(@NonNull KeyEvent r10);
    }

    static {
    }

    public static boolean a(View r10, KeyEvent r11) {
        return ViewCompat.i(r10, r11);
    }

    public static boolean b(Component r10, View r11, Window.Callback r12, KeyEvent r13) {
        if (r10 != null) goto L6;
        return false;
    L6:
        return r10.superDispatchKeyEvent(r13);
    }
}
