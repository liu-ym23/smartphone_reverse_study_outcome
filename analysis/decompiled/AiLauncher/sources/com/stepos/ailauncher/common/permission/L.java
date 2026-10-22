package com.stepos.ailauncher.common.permission;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/common/permission/L;", "", "<init>", "()V", "", "anchorTaskId", "Landroid/os/Bundle;", "c", "(I)Landroid/os/Bundle;", "Landroid/app/ActivityOptions;", "options", "taskId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/app/ActivityOptions;I)V", "", "taskOverlay", "canResume", Const.INTENT_KEY_PKGNAME, "(Landroid/app/ActivityOptions;ZZ)V", "", "TAG", "Ljava/lang/String;", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class L {
    public static final L INSTANCE = new L();
    private static final String TAG = "PermissionTaskOverlay";

    public final void a(ActivityOptions options, int taskId) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        Class cls = Integer.TYPE;
        try {
            method = ActivityOptions.class.getMethod("setLaunchTaskId", cls);
        } catch (NoSuchMethodException unused) {
            Log.w(TAG, "setLaunchTaskId missing, try OEM setTaskId");
            method = ActivityOptions.class.getMethod("setTaskId", cls);
        }
        method.invoke(options, Integer.valueOf(taskId));
    }

    public final void b(ActivityOptions options, boolean taskOverlay, boolean canResume) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = Boolean.TYPE;
        ActivityOptions.class.getMethod("setTaskOverlay", cls, cls).invoke(options, Boolean.valueOf(taskOverlay), Boolean.valueOf(canResume));
    }

    public final Bundle c(int anchorTaskId) {
        if (anchorTaskId <= 0) {
            Log.w(TAG, "invalid anchorTaskId=" + anchorTaskId);
            return null;
        }
        try {
            ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
            kotlin.jvm.internal.p.f(activityOptionsMakeBasic);
            a(activityOptionsMakeBasic, anchorTaskId);
            b(activityOptionsMakeBasic, true, true);
            return activityOptionsMakeBasic.toBundle();
        } catch (Throwable th) {
            Log.w(TAG, "make overlay options failed: " + th.getMessage());
            return null;
        }
    }
}
