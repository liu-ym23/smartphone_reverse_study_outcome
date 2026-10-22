package com.stepos.ailauncher.express.scene;

import La.D;
import La.H;
import Z8.F;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010\u001e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/express/scene/d;", "", "<init>", "()V", "", "isPauseOrLost", "authWindowActive", "expanded", "sceneOnTop", "isStop", "e", "(ZZZZZ)Z", "Landroid/content/Context;", "context", "Landroid/content/ComponentName;", "f", "(Landroid/content/Context;)Landroid/content/ComponentName;", "", "scenePkg", "sceneActivity", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "topPkg", "topActivity", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "topClassName", "c", "(Ljava/lang/String;Ljava/lang/String;)Z", "selfPkg", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Z", "TAG", "Ljava/lang/String;", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    public static final d INSTANCE = new d();
    private static final String TAG = "ExpressScenePresence";

    public final boolean a(Context context, String scenePkg, String selfPkg, boolean authWindowActive, String sceneActivity) {
        p.i(context, "context");
        p.i(scenePkg, "scenePkg");
        p.i(selfPkg, "selfPkg");
        ComponentName componentNameF = f(context);
        String packageName = componentNameF != null ? componentNameF.getPackageName() : null;
        String className = componentNameF != null ? componentNameF.getClassName() : null;
        boolean zC = true;
        if (packageName != null && packageName.length() != 0) {
            if (p.d(packageName, scenePkg)) {
                zC = c(sceneActivity, className);
            } else if (!authWindowActive || !p.d(packageName, selfPkg)) {
                zC = false;
            }
        }
        Log.d(TAG, "isSceneOnTop: scenePkg=" + scenePkg + " sceneActivity=" + sceneActivity + " selfPkg=" + selfPkg + " top=" + packageName + "/" + className + " authWindowActive=" + authWindowActive + " result=" + zC);
        return zC;
    }

    public final boolean b(Context context, String scenePkg, String sceneActivity) {
        p.i(context, "context");
        p.i(scenePkg, "scenePkg");
        p.i(sceneActivity, "sceneActivity");
        ComponentName componentNameF = f(context);
        boolean zD = d(scenePkg, sceneActivity, componentNameF != null ? componentNameF.getPackageName() : null, componentNameF != null ? componentNameF.getClassName() : null);
        Log.d(TAG, "isStoredSceneOnTop: scenePkg=" + scenePkg + " sceneActivity=" + sceneActivity + " top=" + (componentNameF != null ? componentNameF.getPackageName() : null) + "/" + (componentNameF != null ? componentNameF.getClassName() : null) + " result=" + zD);
        return zD;
    }

    public final boolean c(String sceneActivity, String topClassName) {
        if (sceneActivity != null && !H.x0(sceneActivity) && topClassName != null && !H.x0(topClassName)) {
            String string = H.D1(sceneActivity).toString();
            String string2 = H.D1(topClassName).toString();
            if (p.d(string, string2)) {
                return true;
            }
            if (!D.K(string2, "." + string, false, 2, null)) {
                if (!D.K(string, "." + string2, false, 2, null)) {
                    String strS1 = H.s1(string, '.', null, 2, null);
                    return strS1.length() > 0 && p.d(strS1, H.s1(string2, '.', null, 2, null));
                }
            }
        }
        return true;
    }

    public final boolean d(String scenePkg, String sceneActivity, String topPkg, String topActivity) {
        p.i(scenePkg, "scenePkg");
        p.i(sceneActivity, "sceneActivity");
        return p.d(topPkg, scenePkg) && topActivity != null && !H.x0(topActivity) && c(sceneActivity, topActivity);
    }

    public final boolean e(boolean isPauseOrLost, boolean authWindowActive, boolean expanded, boolean sceneOnTop, boolean isStop) {
        if (isStop) {
            return authWindowActive;
        }
        if (!isPauseOrLost) {
            return false;
        }
        if (authWindowActive) {
            return true;
        }
        return expanded && sceneOnTop;
    }

    public final ComponentName f(Context context) {
        Object objB;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            objB = Result.b((activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || (runningTaskInfo = (ActivityManager.RunningTaskInfo) F.s0(runningTasks)) == null) ? null : runningTaskInfo.topActivity);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "topPackage: getRunningTasks failed", thE);
        }
        return (ComponentName) (Result.g(objB) ? null : objB);
    }
}
