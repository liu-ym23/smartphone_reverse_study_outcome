package cn.jzvd;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.ContextThemeWrapper;
import android.view.Window;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.i;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class JZUtils {
    public static final String SP_JZVD_PROGRESS = "JZVD_PROGRESS";
    public static final String TAG = "JZVD";

    public JZUtils() {
    }

    public static void clearSavedProgress(Context r10, Object r11) {
        if (r11 != null) goto L4;
        b0.n().j(SP_JZVD_PROGRESS, r10);
        return;
    L4:
        b0.n().F("newVersion:" + r11.toString(), 0, SP_JZVD_PROGRESS, r10);
    }

    public static int dip2px(Context r10, float r11) {
        return (int) ((r11 * r10.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Activity getActivity(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Activity) == false) goto L10;
        return (Activity) r10;
    L10:
        if ((r10 instanceof ContextThemeWrapper) == true) goto L12;
        return null;
    L12:
        return getActivity(((ContextThemeWrapper) r10).getBaseContext());
    }

    public static long getSavedProgress(Context r10, Object r11) {
        return r10.getSharedPreferences(SP_JZVD_PROGRESS, 0).getLong("newVersion:" + r11.toString(), 0);
    }

    public static Window getWindow(Context r10) {
        if (getActivity(r10) == null) goto L7;
        return getActivity(r10).getWindow();
    L7:
        return scanForActivity(r10).getWindow();
    }

    public static boolean isWifiConnected(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.getType() != 1) goto L7;
        return true;
    }

    public static void saveProgress(Context r10, Object r11, long r12) {
        i.e("JZVD", "saveProgress: " + r12);
        b0.n().F("newVersion:" + r11.toString(), r12, SP_JZVD_PROGRESS, r10);
    }

    public static Activity scanForActivity(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Activity) == false) goto L10;
        return (Activity) r10;
    L10:
        if ((r10 instanceof ContextWrapper) == true) goto L12;
        return null;
    L12:
        return scanForActivity(((ContextWrapper) r10).getBaseContext());
    }

    public static void setRequestedOrientation(Context r10, int r11) {
        if (getActivity(r10) == null) goto L5;
        getActivity(r10).setRequestedOrientation(r11);
        return;
    L5:
        scanForActivity(r10).setRequestedOrientation(r11);
    }

    public static String stringForTime(long r10) {
        if (r10 > 0) goto L5;
        return "00:00";
    L5:
        if (r10 >= 86400000) goto L15;
        long r11 = r10 / 1000;
        int r12 = (int) (r11 % 60);
        int r13 = (int) ((r11 / 60) % 60);
        int r14 = (int) (r11 / 3600);
        Formatter r15 = new Formatter(new StringBuilder(), Locale.getDefault());
        if (r14 <= 0) goto L12;
        return r15.format("%d:%02d:%02d", new Object[]{Integer.valueOf(r14), Integer.valueOf(r13), Integer.valueOf(r12)}).toString();
    L12:
        return r15.format("%02d:%02d", new Object[]{Integer.valueOf(r13), Integer.valueOf(r12)}).toString();
    L15:
        return "00:00";
    }
}
