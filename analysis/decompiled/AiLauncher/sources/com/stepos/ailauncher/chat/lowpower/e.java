package com.stepos.ailauncher.chat.lowpower;

import Y8.t;
import android.app.ActivityManager;
import android.os.Process;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.controller.C2536e;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.container.api.IOverlayPageHost;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/lowpower/e;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    public static final e INSTANCE = new e();
    private static final String TAG = "TempPowerLowExit";

    public final void a() {
        Object objB;
        IOverlayPageHost iOverlayPageHost = (IOverlayPageHost) D5.a.INSTANCE.a(IOverlayPageHost.class);
        if (iOverlayPageHost == null) {
            C4148a.u(TAG, "IOverlayPageHost not registered, cannot collapse overlay", false, 4, null);
            return;
        }
        C4148a.k(TAG, "collapse overlay: closeOverlay, keep process", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            iOverlayPageHost.closeOverlay(true);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "closeOverlay failed", thE, false, 8, null);
        }
        Result.a(objB);
    }

    public final void b() {
        Object objB;
        Object objB2;
        t tVar;
        List<ActivityManager.AppTask> appTasks;
        Object objB3;
        C4148a.k(TAG, "hard exit: remove recents tasks + clear activities + kill process", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = C3197a.INSTANCE.a().getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (activityManager == null || (appTasks = activityManager.getAppTasks()) == null) {
                tVar = null;
            } else {
                for (ActivityManager.AppTask appTask : appTasks) {
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        appTask.finishAndRemoveTask();
                        objB3 = Result.b(t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objB3 = Result.b(C4849c.a(th));
                    }
                    Throwable thE = Result.e(objB3);
                    if (thE != null) {
                        C4148a.t(TAG, "finishAndRemoveTask failed", thE, false, 8, null);
                    }
                }
                tVar = t.f7040a;
            }
            objB = Result.b(tVar);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB);
        if (thE2 != null) {
            C4148a.t(TAG, "remove recents tasks failed", thE2, false, 8, null);
        }
        try {
            C2536e.Companion.b(C2536e.INSTANCE, null, 1, null);
            objB2 = Result.b(t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion5 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th3));
        }
        Throwable thE3 = Result.e(objB2);
        if (thE3 != null) {
            C4148a.t(TAG, "clearUselessActivity failed", thE3, false, 8, null);
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
