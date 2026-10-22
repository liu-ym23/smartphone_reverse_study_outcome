package com.stepos.ailauncher.common.permission;

import Z8.C1173v;
import Z8.Y;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/common/permission/K;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)I", Const.INTENT_KEY_APIKEY, "c", "", "pkg", "", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Ljava/lang/String;)Z", "Landroid/content/ComponentName;", "e", "(Landroid/content/Context;)Landroid/content/ComponentName;", "TAG", "Ljava/lang/String;", "PKG_SYSTEM_UI", "PKG_PERMISSION_CONTROLLER", "PKG_MEDIA_CAMERA", "PKG_MEDIA_GALLERY", "PKG_DOCUMENTS_UI", "", "SKIP_FOREIGN_PACKAGES", "Ljava/util/Set;", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class K {
    private static final String PKG_DOCUMENTS_UI = "com.android.documentsui";
    private static final String PKG_MEDIA_CAMERA = "com.stepos.media.camera";
    private static final String PKG_MEDIA_GALLERY = "com.stepos.media.gallery";
    private static final String PKG_PERMISSION_CONTROLLER = "com.android.permissioncontroller";
    private static final String PKG_SYSTEM_UI = "com.android.systemui";
    private static final String TAG = "PermissionTaskLookup";
    public static final K INSTANCE = new K();
    private static final Set<String> SKIP_FOREIGN_PACKAGES = Y.j("com.android.systemui", "com.android.permissioncontroller", "com.stepos.media.camera", "com.stepos.media.gallery", "com.android.documentsui");

    public final int a(Context context) {
        String packageName;
        kotlin.jvm.internal.p.i(context, "context");
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return -1;
        }
        try {
            String packageName2 = context.getPackageName();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager != null ? activityManager.getRunningTasks(8) : null;
            if (runningTasks == null) {
                runningTasks = C1173v.m();
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                ComponentName componentName = runningTaskInfo.topActivity;
                if (componentName == null || (packageName = componentName.getPackageName()) == null) {
                    ComponentName componentName2 = runningTaskInfo.baseActivity;
                    packageName = componentName2 != null ? componentName2.getPackageName() : null;
                    if (packageName == null) {
                    }
                }
                if (!kotlin.jvm.internal.p.d(packageName, packageName2) && !d(context, packageName) && !SKIP_FOREIGN_PACKAGES.contains(packageName) && !La.D.X(packageName, "com.android.systemui.", false, 2, null)) {
                    Log.d(TAG, "foreignTaskId=" + runningTaskInfo.id + " pkg=" + packageName);
                    return runningTaskInfo.id;
                }
            }
        } catch (Throwable th) {
            Log.w(TAG, "findForeignTaskId failed: " + th.getMessage());
        }
        return -1;
    }

    public final int b(Context context) {
        String packageName;
        Object next;
        Object obj;
        kotlin.jvm.internal.p.i(context, "context");
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return -1;
        }
        ComponentName componentNameE = e(context);
        if (componentNameE == null || (packageName = componentNameE.getPackageName()) == null) {
            packageName = context.getPackageName();
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager != null ? activityManager.getRunningTasks(32) : null;
            if (runningTasks == null) {
                runningTasks = C1173v.m();
            }
            Iterator<T> it = runningTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) next;
                if (componentNameE != null && (kotlin.jvm.internal.p.d(runningTaskInfo.baseActivity, componentNameE) || kotlin.jvm.internal.p.d(runningTaskInfo.topActivity, componentNameE))) {
                    break;
                }
            }
            ActivityManager.RunningTaskInfo runningTaskInfo2 = (ActivityManager.RunningTaskInfo) next;
            if (runningTaskInfo2 == null) {
                Iterator<T> it2 = runningTasks.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next2 = it2.next();
                    ComponentName componentName = ((ActivityManager.RunningTaskInfo) next2).baseActivity;
                    if (kotlin.jvm.internal.p.d(componentName != null ? componentName.getPackageName() : null, packageName)) {
                        obj = next2;
                        break;
                    }
                }
                runningTaskInfo2 = (ActivityManager.RunningTaskInfo) obj;
            }
            int i10 = runningTaskInfo2 != null ? runningTaskInfo2.id : -1;
            if (i10 <= 0) {
                Log.w(TAG, "no launcher task pkg=" + packageName + " home=" + componentNameE);
                return i10;
            }
            Log.d(TAG, "launcherTaskId=" + i10 + " base=" + (runningTaskInfo2 != null ? runningTaskInfo2.baseActivity : null));
            return i10;
        } catch (Throwable th) {
            Log.w(TAG, "findLauncherTaskId failed: " + th.getMessage());
            return -1;
        }
    }

    public final int c(Context context) {
        String packageName;
        int i10;
        kotlin.jvm.internal.p.i(context, "context");
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return -1;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager != null ? activityManager.getRunningTasks(8) : null;
            if (runningTasks == null) {
                runningTasks = C1173v.m();
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                ComponentName componentName = runningTaskInfo.topActivity;
                if (componentName == null || (packageName = componentName.getPackageName()) == null) {
                    ComponentName componentName2 = runningTaskInfo.baseActivity;
                    packageName = componentName2 != null ? componentName2.getPackageName() : null;
                    if (packageName == null) {
                    }
                }
                if (!SKIP_FOREIGN_PACKAGES.contains(packageName) && !La.D.X(packageName, "com.android.systemui.", false, 2, null) && (i10 = runningTaskInfo.id) > 0) {
                    Log.d(TAG, "topVisibleTaskId=" + i10 + " pkg=" + packageName);
                    return i10;
                }
            }
        } catch (Throwable th) {
            Log.w(TAG, "findTopVisibleTaskId failed: " + th.getMessage());
        }
        return -1;
    }

    public final boolean d(Context context, String pkg) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(pkg, "pkg");
        if (La.H.e0(pkg, "launcher", true)) {
            return true;
        }
        try {
            ComponentName componentNameE = e(context);
            return kotlin.jvm.internal.p.d(componentNameE != null ? componentNameE.getPackageName() : null, pkg);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final ComponentName e(Context context) {
        ActivityInfo activityInfo;
        try {
            Intent intentAddCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
            kotlin.jvm.internal.p.h(intentAddCategory, "addCategory(...)");
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intentAddCategory, 65536);
            if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
                return null;
            }
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        } catch (Throwable unused) {
            return null;
        }
    }
}
