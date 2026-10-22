package j;

import android.view.Window;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class p {
    @DoNotInline
    public static void a(Window.Callback callback, boolean z4) {
        callback.onPointerCaptureChanged(z4);
    }
}
