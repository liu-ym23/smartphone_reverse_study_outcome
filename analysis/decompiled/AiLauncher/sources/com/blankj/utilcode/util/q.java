package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityThread;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.Lifecycle;
import android.view.Window;
import com.blankj.utilcode.util.p;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.o0;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class q implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g, reason: collision with root package name */
    public static final q f19239g = new q();

    /* renamed from: h, reason: collision with root package name */
    public static final Activity f19240h = new Activity();

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList<Activity> f19241a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    public final List<p.c> f19242b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final Map<Activity, List<p.a>> f19243c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public int f19244d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f19245e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19246f = false;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f19247a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p.a f19248b;

        public a(Activity activity, p.a aVar) {
            this.f19247a = activity;
            this.f19248b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.e(this.f19247a, this.f19248b);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f19250a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p.a f19251b;

        public b(Activity activity, p.a aVar) {
            this.f19250a = activity;
            this.f19251b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.t(this.f19250a, this.f19251b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f19253a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f19254b;

        public c(Activity activity, Object obj) {
            this.f19253a = activity;
            this.f19254b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Window window = this.f19253a.getWindow();
                if (window != null) {
                    window.setSoftInputMode(((Integer) this.f19254b).intValue());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void u() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (ValueAnimator.areAnimatorsEnabled()) {
            return;
        }
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                declaredField.set(null, Float.valueOf(1.0f));
                Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
            }
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
        }
    }

    public void c(Activity activity, p.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        r.x(new a(activity, aVar));
    }

    public void d(p.a aVar) {
        c(f19240h, aVar);
    }

    public final void e(Activity activity, p.a aVar) {
        List<p.a> copyOnWriteArrayList = this.f19243c.get(activity);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f19243c.put(activity, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        copyOnWriteArrayList.add(aVar);
    }

    public final void f(Activity activity, Lifecycle.Event event) {
        g(activity, event, this.f19243c.get(activity));
        g(activity, event, this.f19243c.get(f19240h));
    }

    public final void g(Activity activity, Lifecycle.Event event, List<p.a> list) {
        if (list == null) {
            return;
        }
        for (p.a aVar : list) {
            aVar.g(activity, event);
            if (event.equals(Lifecycle.Event.ON_CREATE)) {
                aVar.a(activity);
            } else if (event.equals(Lifecycle.Event.ON_START)) {
                aVar.e(activity);
            } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                aVar.d(activity);
            } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                aVar.c(activity);
            } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                aVar.f(activity);
            } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                aVar.b(activity);
            }
        }
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            this.f19243c.remove(activity);
        }
    }

    public final List<Activity> h() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object objJ;
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            objJ = j();
        } catch (Exception e10) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e10.getMessage());
        }
        if (objJ != null) {
            Field declaredField = objJ.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objJ);
            if (obj instanceof Map) {
                for (Object obj2 : ((Map) obj).values()) {
                    Class<?> cls = obj2.getClass();
                    Field declaredField2 = cls.getDeclaredField("activity");
                    declaredField2.setAccessible(true);
                    Activity activity2 = (Activity) declaredField2.get(obj2);
                    if (activity == null) {
                        Field declaredField3 = cls.getDeclaredField(o0.TRACK_STATUS_PAUSED);
                        declaredField3.setAccessible(true);
                        if (declaredField3.getBoolean(obj2)) {
                            linkedList.addFirst(activity2);
                        } else {
                            activity = activity2;
                        }
                    } else {
                        linkedList.addFirst(activity2);
                    }
                }
                if (activity != null) {
                    linkedList.addFirst(activity);
                }
            }
        }
        return linkedList;
    }

    public List<Activity> i() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!this.f19241a.isEmpty()) {
            return new LinkedList(this.f19241a);
        }
        this.f19241a.addAll(h());
        return new LinkedList(this.f19241a);
    }

    public final Object j() throws NoSuchFieldException, SecurityException {
        Object objK = k();
        return objK != null ? objK : l();
    }

    public final Object k() throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = ActivityThread.class.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e10) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e10.getMessage());
            return null;
        }
    }

    public final Object l() {
        try {
            return ActivityThread.class.getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Exception e10) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e10.getMessage());
            return null;
        }
    }

    public Application m() {
        Object objInvoke;
        try {
            Object objJ = j();
            if (objJ == null || (objInvoke = ActivityThread.class.getMethod("getApplication", null).invoke(objJ, null)) == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public void n(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public boolean o() {
        return !this.f19246f;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (this.f19241a.size() == 0) {
            p(activity, true);
        }
        h.a(activity);
        u();
        v(activity);
        f(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.f19241a.remove(activity);
        r.c(activity);
        f(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        f(activity, Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        v(activity);
        if (this.f19246f) {
            this.f19246f = false;
            p(activity, true);
        }
        q(activity, false);
        f(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (!this.f19246f) {
            v(activity);
        }
        int i10 = this.f19245e;
        if (i10 < 0) {
            this.f19245e = i10 + 1;
        } else {
            this.f19244d++;
        }
        f(activity, Lifecycle.Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.f19245e--;
        } else {
            int i10 = this.f19244d - 1;
            this.f19244d = i10;
            if (i10 <= 0) {
                this.f19246f = true;
                p(activity, false);
            }
        }
        q(activity, true);
        f(activity, Lifecycle.Event.ON_STOP);
    }

    public final void p(Activity activity, boolean z10) {
        if (this.f19242b.isEmpty()) {
            return;
        }
        for (p.c cVar : this.f19242b) {
            if (z10) {
                cVar.a(activity);
            } else {
                cVar.b(activity);
            }
        }
    }

    public final void q(Activity activity, boolean z10) {
        try {
            if (z10) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
                return;
            }
            Object tag = activity.getWindow().getDecorView().getTag(-123);
            if (tag instanceof Integer) {
                r.y(new c(activity, tag), 100L);
            }
        } catch (Exception unused) {
        }
    }

    public void r(Activity activity, p.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        r.x(new b(activity, aVar));
    }

    public void s(p.a aVar) {
        r(f19240h, aVar);
    }

    public final void t(Activity activity, p.a aVar) {
        List<p.a> list = this.f19243c.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(aVar);
    }

    public final void v(Activity activity) {
        if (!this.f19241a.contains(activity)) {
            this.f19241a.addFirst(activity);
        } else {
            if (this.f19241a.getFirst().equals(activity)) {
                return;
            }
            this.f19241a.remove(activity);
            this.f19241a.addFirst(activity);
        }
    }

    public void w(Application application) {
        this.f19241a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }
}
