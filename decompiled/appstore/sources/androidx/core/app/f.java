package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static class a {
        @DoNotInline
        public static Intent a(Activity r10) {
            return r10.getParentActivityIntent();
        }

        @DoNotInline
        public static boolean b(Activity r10, Intent r11) {
            return r10.navigateUpTo(r11);
        }

        @DoNotInline
        public static boolean c(Activity r10, Intent r11) {
            return r10.shouldUpRecreateTask(r11);
        }
    }

    public static Intent a(Activity r10) {
        Intent r11 = a.a(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        String r12 = c(r10);
        if (r12 != null) goto L8;
        return null;
    L8:
        ComponentName r13 = new ComponentName(r10, r12);
    L14:
        Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + r12 + "' in manifest");
        return null;
    L10:
        if (d(r10, r13) != null) goto L13;
        return Intent.makeMainActivity(r13);
    L13:
        return new Intent().setComponent(r13);
    }

    public static Intent b(Context r10, ComponentName r11) {
        String r12 = d(r10, r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        ComponentName r13 = new ComponentName(r11.getPackageName(), r12);
        if (d(r10, r13) != null) goto L10;
        return Intent.makeMainActivity(r13);
    L10:
        return new Intent().setComponent(r13);
    }

    public static String c(Activity r10) {
        return d(r10, r10.getComponentName());
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String d(Context r10, ComponentName r11) {
        ActivityInfo r12 = r10.getPackageManager().getActivityInfo(r11, 269222528);
        String r13 = r12.parentActivityName;
        if (r13 == null) goto L5;
        return r13;
    L5:
        Bundle r14 = r12.metaData;
        if (r14 != null) goto L8;
        return null;
    L8:
        String r15 = r14.getString("android.support.PARENT_ACTIVITY");
        if (r15 != null) goto L12;
        return null;
    L12:
        if (r15.charAt(0) == '.') goto L14;
        return r15;
    L14:
        return r10.getPackageName() + r15;
    }

    public static void e(Activity r10, Intent r11) {
        a.b(r10, r11);
    }

    public static boolean f(Activity r10, Intent r11) {
        return a.c(r10, r11);
    }
}
