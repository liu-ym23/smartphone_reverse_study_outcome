package androidx.core.net;

import android.net.ConnectivityManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConnectivityManagerCompat {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface RestrictBackgroundStatus {
    }

    public static class a {
        @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
        @DoNotInline
        public static boolean a(ConnectivityManager r10) {
            return r10.isActiveNetworkMetered();
        }
    }

    public static boolean a(ConnectivityManager r10) {
        return a.a(r10);
    }
}
