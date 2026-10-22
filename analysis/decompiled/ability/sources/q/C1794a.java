package q;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import e2.C1404a;
import java.util.HashMap;
import java.util.HashSet;
import v.j;

/* renamed from: q.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1794a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public static int f5571a;
    public static j b;
    public static String c;
    public static final HashSet d;

    static {
        new HashMap();
        d = new HashSet(8);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        d.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        d.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        j jVar = b;
        if (jVar != null) {
            c = jVar.n;
            long jCurrentTimeMillis = System.currentTimeMillis();
            j jVar2 = b;
            j jVar3 = (j) jVar2.clone();
            jVar3.c(jCurrentTimeMillis);
            long j5 = jCurrentTimeMillis - jVar2.b;
            if (j5 <= 0) {
                j5 = 1000;
            }
            jVar3.l = j5;
            C1404a.e(jVar3);
            b = null;
            if (activity != null) {
                activity.isChild();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Window window;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String name = activity.getClass().getName();
        String str = c;
        j jVar = new j();
        if (TextUtils.isEmpty("")) {
            jVar.n = name;
        } else {
            jVar.n = name.concat(":");
        }
        jVar.c(jCurrentTimeMillis);
        jVar.l = -1L;
        if (str == null) {
            str = "";
        }
        jVar.m = str;
        C1404a.e(jVar);
        b = jVar;
        jVar.o = !d.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild() || (window = activity.getWindow()) == null || window.getDecorView() == null) {
            return;
        }
        window.getDecorView().hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        f5571a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (c != null) {
            int i = f5571a - 1;
            f5571a = i;
            if (i <= 0) {
                c = null;
            }
        }
    }
}
