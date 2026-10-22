package com.stepos.ailauncher.chat.sheet;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u000eJ\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/e0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "taskId", "", "includeHome", "softOnly", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;IZZ)Z", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;I)Z", "Landroid/os/Bundle;", "c", "(Landroid/content/Context;)Landroid/os/Bundle;", "f", "(I)Z", Const.INTENT_KEY_UMID, "resetTask", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;Z)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)Z", "options", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ILandroid/os/Bundle;)Z", "Landroid/content/ComponentName;", "e", "(Landroid/content/Context;)Landroid/content/ComponentName;", "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e0 {
    public static final e0 INSTANCE = new e0();
    private static final String TAG = "LauncherTaskFront";

    public final boolean a(Context context, int taskId) {
        kotlin.jvm.internal.p.i(context, "context");
        if (taskId <= 0) {
            return false;
        }
        Bundle bundleC = c(context);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            if (activityManager != null) {
                activityManager.moveTaskToFront(taskId, 0, bundleC);
                C4148a.k(TAG, "board front requested taskId=" + taskId + " via=moveTaskToFront overrideTask=true enterRes=0 exitRes=0 disableStartingWindow=true", false, 4, null);
                return true;
            }
        } catch (Throwable th) {
            C4148a.u(TAG, "board moveTaskToFront failed taskId=" + taskId + ": " + th.getMessage(), false, 4, null);
        }
        boolean zG = g(taskId, bundleC);
        C4148a.k(TAG, "board front requested=" + zG + " taskId=" + taskId + " via=FromRecents overrideTask=true enterRes=0 exitRes=0 disableStartingWindow=true", false, 4, null);
        return zG;
    }

    public final boolean b(Context context, int taskId, boolean includeHome, boolean softOnly) {
        kotlin.jvm.internal.p.i(context, "context");
        if (taskId <= 0) {
            return false;
        }
        boolean zF = f(taskId);
        boolean zD = d(context, taskId);
        boolean z10 = true;
        if (softOnly) {
            if (!zF && !zD) {
                z10 = false;
            }
            C4148a.k(TAG, "bringTaskToFront SOFT taskId=" + taskId + " fromRecents=" + zF + " moved=" + zD, false, 4, null);
            return z10;
        }
        boolean zI = i(context, false);
        boolean zH = includeHome ? h(context) : false;
        if (!zF && !zD && !zI && !zH) {
            z10 = false;
        }
        C4148a.k(TAG, "bringTaskToFront taskId=" + taskId + " fromRecents=" + zF + " moved=" + zD + " launcher=" + zI + " home=" + zH + " includeHome=" + includeHome, false, 4, null);
        return z10;
    }

    public final Bundle c(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Bundle bundle = ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle();
        bundle.putBoolean("android:activity.overrideTaskTransition", true);
        bundle.putBoolean("android.activity.disableStarting", true);
        kotlin.jvm.internal.p.h(bundle, "apply(...)");
        return bundle;
    }

    public final boolean d(Context context, int taskId) {
        kotlin.jvm.internal.p.i(context, "context");
        if (taskId <= 0) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            if (activityManager != null) {
                activityManager.moveTaskToFront(taskId, 0);
            }
            C4148a.k(TAG, "moveTaskToFront ok taskId=" + taskId + " flags=0", false, 4, null);
            return true;
        } catch (Throwable th) {
            C4148a.u(TAG, "moveTaskToFront failed: " + th.getMessage(), false, 4, null);
            return false;
        }
    }

    public final ComponentName e(Context context) {
        ActivityInfo activityInfo;
        Intent intentAddCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
        kotlin.jvm.internal.p.h(intentAddCategory, "addCategory(...)");
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intentAddCategory, 65536);
        if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
            return null;
        }
        return new ComponentName(activityInfo.packageName, activityInfo.name);
    }

    public final boolean f(int taskId) {
        return g(taskId, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[LOOP:1: B:18:0x004e->B:56:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(int r12, android.os.Bundle r13) {
        /*
            r11 = this;
            java.lang.String r11 = "LauncherTaskFront"
            r0 = 0
            if (r12 > 0) goto L6
            return r0
        L6:
            r1 = 4
            r2 = 0
            java.lang.String r3 = "android.app.ActivityTaskManager"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L44
            java.lang.String r4 = "getService"
            java.lang.reflect.Method r3 = r3.getMethod(r4, r2)     // Catch: java.lang.Throwable -> L44
            java.lang.Object r3 = r3.invoke(r2, r2)     // Catch: java.lang.Throwable -> L44
            if (r3 != 0) goto L1b
            return r0
        L1b:
            java.lang.Class r4 = r3.getClass()     // Catch: java.lang.Throwable -> L44
            java.lang.reflect.Method[] r4 = r4.getMethods()     // Catch: java.lang.Throwable -> L44
            java.lang.String r5 = "getMethods(...)"
            kotlin.jvm.internal.p.h(r4, r5)     // Catch: java.lang.Throwable -> L44
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L44
            r5.<init>()     // Catch: java.lang.Throwable -> L44
            int r6 = r4.length     // Catch: java.lang.Throwable -> L44
            r7 = r0
        L2f:
            if (r7 >= r6) goto L4a
            r8 = r4[r7]     // Catch: java.lang.Throwable -> L44
            java.lang.String r9 = r8.getName()     // Catch: java.lang.Throwable -> L44
            java.lang.String r10 = "startActivityFromRecents"
            boolean r9 = kotlin.jvm.internal.p.d(r9, r10)     // Catch: java.lang.Throwable -> L44
            if (r9 == 0) goto L47
            r5.add(r8)     // Catch: java.lang.Throwable -> L44
            goto L47
        L44:
            r12 = move-exception
            goto Ld4
        L47:
            int r7 = r7 + 1
            goto L2f
        L4a:
            java.util.Iterator r4 = r5.iterator()     // Catch: java.lang.Throwable -> L44
        L4e:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L44
            if (r5 == 0) goto Lcd
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L44
            java.lang.reflect.Method r5 = (java.lang.reflect.Method) r5     // Catch: java.lang.Throwable -> L44
            r6 = 1
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L85
            java.lang.Class[] r7 = r5.getParameterTypes()     // Catch: java.lang.Throwable -> L85
            int r7 = r7.length     // Catch: java.lang.Throwable -> L85
            r8 = 2
            if (r7 == r8) goto L87
            r8 = 3
            if (r7 == r8) goto L6a
        L68:
            r5 = r0
            goto L93
        L6a:
            java.lang.Class[] r7 = r5.getParameterTypes()     // Catch: java.lang.Throwable -> L85
            r7 = r7[r0]     // Catch: java.lang.Throwable -> L85
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L85
            boolean r7 = kotlin.jvm.internal.p.d(r7, r8)     // Catch: java.lang.Throwable -> L85
            if (r7 == 0) goto L68
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L85
            java.lang.Object[] r7 = new java.lang.Object[]{r7, r13, r2}     // Catch: java.lang.Throwable -> L85
            r5.invoke(r3, r7)     // Catch: java.lang.Throwable -> L85
        L83:
            r5 = r6
            goto L93
        L85:
            r5 = move-exception
            goto L9c
        L87:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L85
            java.lang.Object[] r7 = new java.lang.Object[]{r7, r13}     // Catch: java.lang.Throwable -> L85
            r5.invoke(r3, r7)     // Catch: java.lang.Throwable -> L85
            goto L83
        L93:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L85
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L85
            goto La6
        L9c:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L44
            java.lang.Object r5 = kotlin.C4849c.a(r5)     // Catch: java.lang.Throwable -> L44
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L44
        La6:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L44
            boolean r8 = kotlin.Result.g(r5)     // Catch: java.lang.Throwable -> L44
            if (r8 == 0) goto Laf
            r5 = r7
        Laf:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L44
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L44
            if (r5 == 0) goto L4e
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            r13.<init>()     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = "startActivityFromRecents ok taskId="
            r13.append(r3)     // Catch: java.lang.Throwable -> L44
            r13.append(r12)     // Catch: java.lang.Throwable -> L44
            java.lang.String r12 = r13.toString()     // Catch: java.lang.Throwable -> L44
            h8.C4148a.k(r11, r12, r0, r1, r2)     // Catch: java.lang.Throwable -> L44
            return r6
        Lcd:
            java.lang.String r12 = "startActivityFromRecents: no matching method"
            h8.C4148a.u(r11, r12, r0, r1, r2)     // Catch: java.lang.Throwable -> L44
            goto Led
        Ld4:
            java.lang.String r12 = r12.getMessage()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r3 = "startActivityFromRecents failed: "
            r13.append(r3)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            h8.C4148a.u(r11, r12, r0, r1, r2)
        Led:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.sheet.e0.g(int, android.os.Bundle):boolean");
    }

    public final boolean h(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.getApplicationContext().startActivity(intent);
            C4148a.k(TAG, "HOME intent ok", false, 4, null);
            return true;
        } catch (Throwable th) {
            C4148a.u(TAG, "HOME intent failed: " + th.getMessage(), false, 4, null);
            return false;
        }
    }

    public final boolean i(Context context, boolean resetTask) {
        kotlin.jvm.internal.p.i(context, "context");
        try {
            ComponentName componentNameE = e(context);
            if (componentNameE == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setComponent(componentNameE);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(io.requery.android.database.sqlite.SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.addFlags(65536);
            if (resetTask) {
                intent.addFlags(2097152);
            }
            context.getApplicationContext().startActivity(intent);
            C4148a.k(TAG, "startLauncherComponent ok " + componentNameE + " resetTask=" + resetTask, false, 4, null);
            return true;
        } catch (Throwable th) {
            C4148a.u(TAG, "startLauncherComponent failed: " + th.getMessage(), false, 4, null);
            return false;
        }
    }
}
