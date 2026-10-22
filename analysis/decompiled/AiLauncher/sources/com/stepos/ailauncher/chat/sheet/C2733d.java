package com.stepos.ailauncher.chat.sheet;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/d;", "", "<init>", "()V", "", "launcherTaskId", "", "canResume", "taskAlwaysOnTop", "Landroid/os/Bundle;", Const.INTENT_KEY_UMID, "(IZZ)Landroid/os/Bundle;", "Landroid/app/ActivityOptions;", "options", "taskId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/app/ActivityOptions;I)V", "taskOverlay", "c", "(Landroid/app/ActivityOptions;ZZ)V", "alwaysOnTop", Const.INTENT_KEY_PKGNAME, "(Landroid/app/ActivityOptions;Z)V", "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.sheet.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2733d {
    public static final C2733d INSTANCE = new C2733d();
    private static final String TAG = "ChatActivityOptions";

    public static /* synthetic */ Bundle e(C2733d c2733d, int i10, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return c2733d.d(i10, z10, z11);
    }

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

    public final void b(ActivityOptions options, boolean alwaysOnTop) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ActivityOptions.class.getMethod("setTaskAlwaysOnTop", Boolean.TYPE).invoke(options, Boolean.valueOf(alwaysOnTop));
    }

    public final void c(ActivityOptions options, boolean taskOverlay, boolean canResume) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = Boolean.TYPE;
        ActivityOptions.class.getMethod("setTaskOverlay", cls, cls).invoke(options, Boolean.valueOf(taskOverlay), Boolean.valueOf(canResume));
    }

    public final Bundle d(int launcherTaskId, boolean canResume, boolean taskAlwaysOnTop) {
        if (launcherTaskId <= 0) {
            Log.w(TAG, "invalid launcherTaskId=" + launcherTaskId);
            return null;
        }
        try {
            ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
            kotlin.jvm.internal.p.f(activityOptionsMakeBasic);
            a(activityOptionsMakeBasic, launcherTaskId);
            c(activityOptionsMakeBasic, true, canResume);
            if (taskAlwaysOnTop) {
                b(activityOptionsMakeBasic, true);
            }
            return activityOptionsMakeBasic.toBundle();
        } catch (Throwable th) {
            Log.w(TAG, "makeDesktopOverlayOptions failed: " + th.getMessage(), th);
            return null;
        }
    }
}
