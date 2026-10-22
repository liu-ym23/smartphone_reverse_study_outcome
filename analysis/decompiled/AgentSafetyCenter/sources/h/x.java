package h;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.lang.invoke.VarHandle;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class x {
    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Object obj, e0 e0Var) {
        Objects.requireNonNull(e0Var);
        androidx.activity.x xVar = new androidx.activity.x(1);
        xVar.f707b = e0Var;
        VarHandle.storeStoreFence();
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, xVar);
        return xVar;
    }

    public static void c(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
