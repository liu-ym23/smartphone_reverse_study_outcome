package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public class DialogCompat {

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static <T> T requireViewById(Dialog r100, int r101) {
            return (T) r100.requireViewById(r101);
        }
    }

    private DialogCompat() {
    }

    public static View requireViewById(Dialog r100, int r101) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        View r102 = r100.findViewById(r101);
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    L5:
        return (View) Api28Impl.requireViewById(r100, r101);
    }
}
