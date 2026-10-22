package androidx.core.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.ReplaceWith;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public final class ConnectivityManagerCompat {
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static int getRestrictBackgroundStatus(ConnectivityManager r100) {
            return r100.getRestrictBackgroundStatus();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RestrictBackgroundStatus {
    }

    private ConnectivityManagerCompat() {
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return 3;
    L5:
        return Api24Impl.getRestrictBackgroundStatus(r100);
    }

    @ReplaceWith(expression = "cm.isActiveNetworkMetered()")
    public static boolean isActiveNetworkMetered(ConnectivityManager r100) {
        return r100.isActiveNetworkMetered();
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager r100, Intent r101) {
        NetworkInfo r102 = (NetworkInfo) r101.getParcelableExtra("networkInfo");
        if (r102 != null) goto L5;
        return null;
    L5:
        return r100.getNetworkInfo(r102.getType());
    }
}
