package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    private NavUtils() {
    }

    public static Intent getParentActivityIntent(Activity r100) {
        Intent r101 = r100.getParentActivityIntent();
        if (r101 == null) goto L5;
        return r101;
    L5:
        String r102 = getParentActivityName(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        ComponentName r103 = new ComponentName(r100, r102);
        if (getParentActivityName(r100, r103) != null) goto L13;
        return Intent.makeMainActivity(r103);
    L13:
        return new Intent().setComponent(r103);
    L15:
        return null;
    }

    public static String getParentActivityName(Activity r100) {
        return getParentActivityName(r100, r100.getComponentName());
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static void navigateUpFromSameTask(Activity r100) {
        Intent r101 = getParentActivityIntent(r100);
        if (r101 == null) goto L7;
        navigateUpTo(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException("Activity " + r100.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static Intent getParentActivityIntent(Context r100, Class<?> r101) throws PackageManager.NameNotFoundException {
        String r102 = getParentActivityName(r100, new ComponentName(r100, r101));
        if (r102 != null) goto L6;
        return null;
    L6:
        ComponentName r103 = new ComponentName(r100, r102);
        if (getParentActivityName(r100, r103) != null) goto L10;
        return Intent.makeMainActivity(r103);
    L10:
        return new Intent().setComponent(r103);
    }

    public static String getParentActivityName(Context r100, ComponentName r101) throws PackageManager.NameNotFoundException {
        PackageManager r102 = r100.getPackageManager();
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 29) goto L6;
        int r104 = 269222528;
    L9:
        ActivityInfo r105 = r102.getActivityInfo(r101, r104);
        String r106 = r105.parentActivityName;
        if (r106 == null) goto L12;
        return r106;
    L12:
        Bundle r107 = r105.metaData;
        if (r107 != null) goto L15;
        return null;
    L15:
        String r108 = r107.getString(PARENT_ACTIVITY);
        if (r108 != null) goto L19;
        return null;
    L19:
        if (r108.charAt(0) == '.') goto L21;
        return r108;
    L21:
        return r100.getPackageName() + r108;
    L6:
        if (r103 < 24) goto L8;
        r104 = 787072;
        goto L9
    L8:
        r104 = 640;
        goto L9
    }

    @ReplaceWith(expression = "sourceActivity.navigateUpTo(upIntent)")
    public static void navigateUpTo(Activity r100, Intent r101) {
        r100.navigateUpTo(r101);
    }

    @ReplaceWith(expression = "sourceActivity.shouldUpRecreateTask(targetIntent)")
    public static boolean shouldUpRecreateTask(Activity r100, Intent r101) {
        return r100.shouldUpRecreateTask(r101);
    }

    public static Intent getParentActivityIntent(Context r100, ComponentName r101) throws PackageManager.NameNotFoundException {
        String r102 = getParentActivityName(r100, r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        ComponentName r103 = new ComponentName(r101.getPackageName(), r102);
        if (getParentActivityName(r100, r103) != null) goto L10;
        return Intent.makeMainActivity(r103);
    L10:
        return new Intent().setComponent(r103);
    }
}
