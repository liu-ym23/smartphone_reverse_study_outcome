package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class BundleCompat {
    private BundleCompat() {
    }

    @ReplaceWith(expression = "bundle.getBinder(key)")
    public static IBinder getBinder(Bundle r100, String r101) {
        return r100.getBinder(r101);
    }

    @ReplaceWith(expression = "bundle.putBinder(key, binder)")
    public static void putBinder(Bundle r100, String r101, IBinder r102) {
        r100.putBinder(r101, r102);
    }
}
