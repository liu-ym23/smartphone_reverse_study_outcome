package K;

import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class P {
    @DoNotInline
    public static int a(View view) {
        return view.getImportantForContentCapture();
    }

    @DoNotInline
    public static CharSequence b(View view) {
        return view.getStateDescription();
    }

    @Nullable
    public static B0 c(@NonNull View view) {
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            return new B0(windowInsetsController);
        }
        return null;
    }

    @DoNotInline
    public static boolean d(View view) {
        return view.isImportantForContentCapture();
    }

    @DoNotInline
    public static void e(View view, int i4) {
        view.setImportantForContentCapture(i4);
    }

    @DoNotInline
    public static void f(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }
}
