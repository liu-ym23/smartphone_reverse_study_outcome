package o8;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.stepos.agentsafetycenter.MainActivity;
import com.stepos.agentsafetycenter.auth.LaunchAuthActivity;
import com.stepos.agentsafetycenter.auth.ResumeAuthActivity;
import java.util.Stack;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        activity.getClass();
        Stack stack = n.f9321a;
        n.f9321a.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        activity.getClass();
        Stack stack = n.f9321a;
        n.f9321a.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        activity.getClass();
        Stack stack = n.f9321a;
        n.f9328h = activity.getResources().getConfiguration().isNightModeActive();
        n.i = n.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        activity.getClass();
        if (!(activity instanceof LaunchAuthActivity) || (activity instanceof MainActivity)) {
            if (activity instanceof MainActivity) {
                Stack stack = n.f9321a;
                if (n.f9327g) {
                    n.f9327g = false;
                    Log.d("ScreenLockAuthManager", "account auth overlay finished");
                }
            }
            if (!p5.f.C(activity)) {
                Stack stack2 = n.f9321a;
                n.f9325e = false;
                n.c(true);
                n.f9326f = true;
                return;
            }
            if (n.f9328h != activity.getResources().getConfiguration().isNightModeActive()) {
                n.f9328h = !n.f9328h;
                n.c(n.i);
                return;
            }
            boolean zA = n.a();
            boolean zIsFinishing = activity.isFinishing();
            if (!zA && !zIsFinishing) {
                Log.d("ScreenLockAuthManager", "start ResumeAuthActivity from ".concat(activity.getClass().getSimpleName()));
                activity.startActivity(new Intent(activity, (Class<?>) ResumeAuthActivity.class));
                activity.overridePendingTransition(0, 0);
            }
            n.f9328h = activity.getResources().getConfiguration().isNightModeActive();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        activity.getClass();
        bundle.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        activity.getClass();
        e3.j jVar = n.f9330k;
        if (jVar != null) {
            n.f9329j.removeCallbacks(jVar);
        }
        n.f9330k = null;
        int i = n.f9324d + 1;
        n.f9324d = i;
        if (i != 1 || n.f9326f) {
            return;
        }
        n.c(!p5.f.C(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        activity.getClass();
        int i = n.f9324d - 1;
        n.f9324d = i;
        if (i == 0 && p5.f.C(activity)) {
            if (n.f9327g) {
                Log.d("ScreenLockAuthManager", "skip lock reset: account auth overlay pending");
                return;
            }
            n.f9325e = true;
            Log.d("ScreenLockAuthManager", "left foreground: require re-auth on next gate");
            e3.j jVar = n.f9330k;
            if (jVar != null) {
                n.f9329j.removeCallbacks(jVar);
            }
            n.f9330k = null;
            e3.j jVar2 = new e3.j(2);
            n.f9330k = jVar2;
            n.f9329j.postDelayed(jVar2, 300L);
        }
    }
}
