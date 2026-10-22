package Na;

import H.h;
import N9.j;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import g1.AbstractC1451a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import kotlin.jvm.internal.k;
import y0.C2126b;
import z.AbstractC2152a;
import z0.C2153a;

/* loaded from: classes4.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1025a;

    public /* synthetic */ a(int i) {
        this.f1025a = i;
    }

    private final void a(Activity activity, Bundle bundle) {
    }

    private final void b(Activity activity) {
    }

    private final void c(Activity activity) {
    }

    private final void d(Activity activity, Bundle bundle) {
    }

    private final void e(Activity activity) {
    }

    private final void f(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        switch (this.f1025a) {
            case 0:
                k.f(activity, "activity");
                j.H("onActivityCreated: " + activity, "ActivityMonitor");
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        switch (this.f1025a) {
            case 0:
                k.f(activity, "activity");
                j.H("onActivityDestroyed: " + activity, "ActivityMonitor");
                break;
            default:
                boolean serviceSwitch = AbstractC1451a.f4474w.getServiceSwitch("apmplus_activity_leak_switch");
                if (h.b) {
                    Log.i("ApmInsight:ActivityLeakTask", U7.a.e(new String[]{"apmplus_activity_leak_switch : " + serviceSwitch}));
                }
                if (serviceSwitch) {
                    String string = UUID.randomUUID().toString();
                    C2126b c2126b = C2126b.g;
                    String localClassName = activity.getLocalClassName();
                    C2153a c2153a = new C2153a(activity, string, localClassName, c2126b.b);
                    c2126b.c.add(string);
                    C2126b.h.add(c2153a);
                    if (h.b) {
                        Log.i("ApmInsight:ActivityLeakTask", U7.a.e(new String[]{"Wait Check Leak:".concat(localClassName)}));
                    }
                    if (c2126b.f == null) {
                        c2126b.f = AbstractC2152a.f6923a;
                    }
                    u1.d dVar = c2126b.f;
                    z.b bVar = new z.b(new A1.a(23));
                    if (c2126b.e <= 0) {
                        c2126b.e = 60000L;
                    }
                    long j5 = c2126b.e;
                    dVar.getClass();
                    try {
                        dVar.h(bVar).c(bVar, j5);
                        break;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        switch (this.f1025a) {
            case 0:
                k.f(activity, "activity");
                j.H("onActivityPaused: " + activity, "ActivityMonitor");
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        switch (this.f1025a) {
            case 0:
                k.f(activity, "activity");
                j.H("onActivityResumed: " + activity, "ActivityMonitor");
                ArrayList arrayList = b.f1026a;
                new WeakReference(activity);
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        switch (this.f1025a) {
            case 0:
                k.f(activity, "activity");
                k.f(outState, "outState");
                j.H("onActivitySaveInstanceState: " + activity, "ActivityMonitor");
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        switch (this.f1025a) {
            case 0:
                k.f(activity, "activity");
                j.H("onActivityStarted: " + activity, "ActivityMonitor");
                int i = b.b + 1;
                b.b = i;
                if (i == 1) {
                    j.H("app enter foreground", "ActivityMonitor");
                    Iterator it = b.f1026a.iterator();
                    if (it.hasNext()) {
                        throw B7.a.f(it);
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        switch (this.f1025a) {
            case 0:
                k.f(activity, "activity");
                j.H("onActivityStopped: " + activity, "ActivityMonitor");
                int i = b.b + (-1);
                b.b = i;
                if (i == 0) {
                    j.H("app enter background", "ActivityMonitor");
                    Iterator it = b.f1026a.iterator();
                    if (it.hasNext()) {
                        throw B7.a.f(it);
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
