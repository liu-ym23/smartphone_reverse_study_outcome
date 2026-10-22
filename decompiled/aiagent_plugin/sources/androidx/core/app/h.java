package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: NavUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    private static final String TAG = "NavUtils";

    /* JADX INFO: compiled from: NavUtils.java */
    static class a {
        static boolean a(Activity r2, Intent r3) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).shouldUpRecreateTask(r3);
        }

        static boolean b(Activity r2, Intent r3) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).navigateUpTo(r3);
        }

        static Intent a(Activity r2) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).getParentActivityIntent();
        }
    }

    public static boolean a(Activity r2, Intent r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        String r5 = r4.getIntent().getAction();
        if (r5 != null) goto L9;
    L11:
        return false;
    L9:
        if (r5.equals("android.intent.action.MAIN") == true) goto L11;
        return true;
    L5:
        return a.a(r4, r3);
    }

    public static void b(Activity r3, Intent r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        a.b(r5, r4);
        return;
    L5:
        r4.addFlags(67108864);
        ZeusTransformUtils.startActivity(r5, r4, "com.obric.aiagent.plugin");
        r5.finish();
    }

    public static Intent a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Intent r0 = a.a(r4);
        if (r0 == null) goto L7;
        return r0;
    L7:
        String r1 = b(r4);
        if (r1 != null) goto L10;
        return null;
    L10:
        ComponentName r2 = new ComponentName(r4, r1);
    L16:
        a(TAG, "getParentActivityIntent: bad parentActivityName '" + r1 + "' in manifest");
        return null;
    L12:
        if (b(r4, r2) != null) goto L15;
        return Intent.makeMainActivity(r2);
    L15:
        return new Intent().setComponent(r2);
    }

    public static Intent a(Context r2, ComponentName r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        String r0 = b(r4, r3);
        if (r0 != null) goto L6;
        return null;
    L6:
        ComponentName r1 = new ComponentName(r3.getPackageName(), r0);
        if (b(r4, r1) != null) goto L10;
        return Intent.makeMainActivity(r1);
    L10:
        return new Intent().setComponent(r1);
    }

    public static String b(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        return b(r3, r3.getComponentName());
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String b(Context r5, ComponentName r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        PackageManager r0 = r7.getPackageManager();
        int r1 = Build.VERSION.SDK_INT;
        int r2 = 640;
        if (Build.VERSION.SDK_INT < 29) goto L6;
        r2 = 269222528;
    L8:
        ActivityInfo r8 = r0.getActivityInfo(r6, r2);
        if (Build.VERSION.SDK_INT < 16) goto L14;
        String r3 = r8.parentActivityName;
        if (r3 == null) goto L14;
        return r3;
    L14:
        if (r8.metaData != null) goto L16;
        return null;
    L16:
        String r9 = r8.metaData.getString("android.support.PARENT_ACTIVITY");
        if (r9 != null) goto L20;
        return null;
    L20:
        if (r9.charAt(0) == '.') goto L22;
        return r9;
    L22:
        return r7.getPackageName() + r9;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L8;
        r2 = 787072;
        goto L8
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
