package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    static class Api16Impl {
        private Api16Impl() {
        }

        static boolean shouldUpRecreateTask(Activity r0, Intent r1) {
            return r0.shouldUpRecreateTask(r1);
        }

        static boolean navigateUpTo(Activity r0, Intent r1) {
            return r0.navigateUpTo(r1);
        }

        static Intent getParentActivityIntent(Activity r0) {
            return r0.getParentActivityIntent();
        }
    }

    public static boolean shouldUpRecreateTask(Activity r0, Intent r1) {
        return Api16Impl.shouldUpRecreateTask(r0, r1);
    }

    public static void navigateUpFromSameTask(Activity r3) {
        Intent r0 = getParentActivityIntent(r3);
        if (r0 == null) goto L7;
        navigateUpTo(r3, r0);
        return;
    L7:
        throw new IllegalArgumentException("Activity " + r3.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(Activity r0, Intent r1) {
        Api16Impl.navigateUpTo(r0, r1);
    }

    public static Intent getParentActivityIntent(Activity r3) {
        Intent r0 = Api16Impl.getParentActivityIntent(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = getParentActivityName(r3);
        if (r1 != null) goto L8;
        return null;
    L8:
        ComponentName r2 = new ComponentName(r3, r1);
    L14:
        Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + r1 + "' in manifest");
        return null;
    L10:
        if (getParentActivityName(r3, r2) != null) goto L13;
        return Intent.makeMainActivity(r2);
    L13:
        return new Intent().setComponent(r2);
    }

    public static Intent getParentActivityIntent(Context r1, Class<?> r2) throws PackageManager.NameNotFoundException {
        String r3 = getParentActivityName(r1, new ComponentName(r1, r2));
        if (r3 != null) goto L6;
        return null;
    L6:
        ComponentName r0 = new ComponentName(r1, r3);
        if (getParentActivityName(r1, r0) != null) goto L10;
        return Intent.makeMainActivity(r0);
    L10:
        return new Intent().setComponent(r0);
    }

    public static Intent getParentActivityIntent(Context r2, ComponentName r3) throws PackageManager.NameNotFoundException {
        String r0 = getParentActivityName(r2, r3);
        if (r0 != null) goto L6;
        return null;
    L6:
        ComponentName r1 = new ComponentName(r3.getPackageName(), r0);
        if (getParentActivityName(r2, r1) != null) goto L10;
        return Intent.makeMainActivity(r1);
    L10:
        return new Intent().setComponent(r1);
    }

    public static String getParentActivityName(Activity r1) {
        return getParentActivityName(r1, r1.getComponentName());
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String getParentActivityName(Context r2, ComponentName r3) throws PackageManager.NameNotFoundException {
        ActivityInfo r4 = r2.getPackageManager().getActivityInfo(r3, 269222528);
        String r0 = r4.parentActivityName;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r4.metaData != null) goto L8;
        return null;
    L8:
        String r5 = r4.metaData.getString(PARENT_ACTIVITY);
        if (r5 != null) goto L12;
        return null;
    L12:
        if (r5.charAt(0) == '.') goto L14;
        return r5;
    L14:
        return r2.getPackageName() + r5;
    }

    private NavUtils() {
    }
}
