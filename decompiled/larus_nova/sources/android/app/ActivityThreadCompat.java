package android.app;

import android.content.pm.ProviderInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityThreadCompat {
    public ActivityThreadCompat() {
    }

    public static ActivityThread currentActivityThread() {
        return ActivityThread.currentActivityThread();
    }

    public static List<ProviderInfo> getProviders() {
        ActivityThread r100 = currentActivityThread();
        if (r100 == null) goto L8;
        ActivityThread.AppBindData r101 = r100.mBoundApplication;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.providers;
    L8:
        return null;
    }

    public static boolean installProviders(List<ProviderInfo> r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ActivityThread r101 = currentActivityThread();
        if (r101 != null) goto L8;
    L11:
        return false;
    L8:
        if (r100.size() <= 0) goto L11;
        r101.installSystemProviders(r101.mBoundApplication.providers);
        return true;
    }

    public static boolean setProviders(List<ProviderInfo> r100) {
        ActivityThread r101 = currentActivityThread();
        if (r101 == null) goto L8;
        ActivityThread.AppBindData r102 = r101.mBoundApplication;
        if (r102 == null) goto L10;
        r102.providers = r100;
        return true;
    L10:
        return false;
    L8:
        return false;
    }
}
