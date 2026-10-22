package com.stepos.ailauncher.chat.sheet;

import Z8.C1173v;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\tB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/i0;", "Lcom/stepos/ailauncher/chat/sheet/f0;", "Landroid/content/Context;", "context", "", "launcherPackage", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", Const.INTENT_KEY_APIKEY, "()I", "Landroid/content/Context;", "Ljava/lang/String;", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class i0 implements f0 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "LauncherTaskIdProvider";
    private final Context context;
    private final String launcherPackage;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/i0$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/ComponentName;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroid/content/ComponentName;", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.sheet.i0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ComponentName a(Context context) {
            ActivityInfo activityInfo;
            kotlin.jvm.internal.p.i(context, "context");
            Intent intentAddCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
            kotlin.jvm.internal.p.h(intentAddCategory, "addCategory(...)");
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intentAddCategory, 65536);
            if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
                return null;
            }
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        }

        public final String b(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            ComponentName componentNameA = a(context);
            if (componentNameA != null) {
                return componentNameA.getPackageName();
            }
            return null;
        }

        public Companion() {
        }
    }

    public i0(Context context, String str) {
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        this.launcherPackage = str;
    }

    @Override // com.stepos.ailauncher.chat.sheet.f0
    public int a() {
        Object next;
        Object next2;
        Object obj;
        ComponentName componentNameA = INSTANCE.a(this.context);
        String packageName = this.launcherPackage;
        if (packageName == null) {
            packageName = componentNameA != null ? componentNameA.getPackageName() : null;
            if (packageName == null) {
                packageName = this.context.getPackageName();
            }
        }
        try {
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService(ActivityManager.class);
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
                if (componentNameA != null && (kotlin.jvm.internal.p.d(runningTaskInfo.baseActivity, componentNameA) || kotlin.jvm.internal.p.d(runningTaskInfo.topActivity, componentNameA))) {
                    break;
                }
            }
            ActivityManager.RunningTaskInfo runningTaskInfo2 = (ActivityManager.RunningTaskInfo) next;
            if (runningTaskInfo2 == null) {
                Iterator<T> it2 = runningTasks.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    ActivityManager.RunningTaskInfo runningTaskInfo3 = (ActivityManager.RunningTaskInfo) next2;
                    ComponentName componentName = runningTaskInfo3.baseActivity;
                    if (kotlin.jvm.internal.p.d(componentName != null ? componentName.getPackageName() : null, packageName)) {
                        if (componentNameA == null) {
                            break;
                        }
                        ComponentName componentName2 = runningTaskInfo3.baseActivity;
                        if (kotlin.jvm.internal.p.d(componentName2 != null ? componentName2.getClassName() : null, componentNameA.getClassName())) {
                            break;
                        }
                    }
                }
                runningTaskInfo2 = (ActivityManager.RunningTaskInfo) next2;
                if (runningTaskInfo2 == null) {
                    Iterator<T> it3 = runningTasks.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj = null;
                            break;
                        }
                        Object next3 = it3.next();
                        ComponentName componentName3 = ((ActivityManager.RunningTaskInfo) next3).baseActivity;
                        if (kotlin.jvm.internal.p.d(componentName3 != null ? componentName3.getPackageName() : null, packageName)) {
                            obj = next3;
                            break;
                        }
                    }
                    runningTaskInfo2 = (ActivityManager.RunningTaskInfo) obj;
                }
            }
            int i10 = runningTaskInfo2 != null ? runningTaskInfo2.id : -1;
            if (i10 <= 0) {
                C4148a.u(TAG, "no running task for pkg=" + packageName + " home=" + componentNameA, false, 4, null);
                return i10;
            }
            C4148a.d(TAG, "resolved launcherTaskId=" + i10 + " base=" + (runningTaskInfo2 != null ? runningTaskInfo2.baseActivity : null), false, 4, null);
            return i10;
        } catch (Throwable th) {
            C4148a.u(TAG, "getRunningTasks failed: " + th.getMessage(), false, 4, null);
            return -1;
        }
    }

    public /* synthetic */ i0(Context context, String str, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : str);
    }
}
