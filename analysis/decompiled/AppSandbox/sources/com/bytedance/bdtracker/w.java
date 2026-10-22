package com.bytedance.bdtracker;

import android.app.Activity;
import android.app.Application;
import android.app.Presentation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import com.bytedance.applog.log.LoggerImpl;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class w implements Application.ActivityLifecycleCallbacks {
    public static o4 f;
    public static o4 g;
    public static long h;
    public static String i;
    public static Object j;
    public static o4 m;
    public static final k0 a = new k0(null, "@APPLOG_APP_USE");
    public static boolean b = false;
    public static final List<String> c = Arrays.asList("android.arch.lifecycle.ReportFragment", "androidx.lifecycle.ReportFragment");
    public static final List<String> d = Collections.singletonList("com.bumptech.glide.manager.SupportRequestManagerFragment");
    public static int e = 0;
    public static final Map<Integer, List<o4>> k = new HashMap();
    public static final Map<Integer, a> l = new ConcurrentHashMap();
    public static final HashSet<Integer> n = new HashSet<>(8);
    public static volatile w o = null;

    public static class a {
        public o4 a;
        public WeakReference<Object> b;

        public a(o4 o4Var, Object obj) {
            this.a = o4Var;
            this.b = new WeakReference<>(obj);
        }
    }

    public static int a(Presentation presentation) {
        Display display;
        if (presentation == null || (display = presentation.getDisplay()) == null) {
            return 0;
        }
        return display.getDisplayId();
    }

    public static o4 a() {
        o4 o4Var = f;
        o4 o4Var2 = g;
        if (o4Var2 != null) {
            return o4Var2;
        }
        if (o4Var != null) {
            return o4Var;
        }
        return null;
    }

    public static synchronized w a(Application application) {
        if (o == null) {
            o = new w();
            application.registerActivityLifecycleCallbacks(o);
        }
        return o;
    }

    public static void a(Object obj, boolean z) {
        String name;
        Class<?> cls;
        if (obj == null || !z) {
            return;
        }
        if (a(obj)) {
            LoggerImpl.global().debug("[Navigator] onFragResume return {} inFragmentCache", obj);
            return;
        }
        if (obj == null || !c.contains(obj.getClass().getName())) {
            if (obj != null && d.contains(obj.getClass().getName())) {
                LoggerImpl.global().debug("[Navigator] onFragResume return {} isBlackFragment", obj, true);
                return;
            }
            LoggerImpl.global().debug("[Navigator] onFragResume:frag：{} isVisible：{}", obj, true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String name2 = obj.getClass().getName();
            Class<?> cls2 = obj.getClass();
            Object obj2 = j;
            Object objInvoke = null;
            if (l5.f(obj)) {
                try {
                    Class[] clsArr = new Class[0];
                    objInvoke = obj.getClass().getMethod("getActivity", null).invoke(obj, null);
                } catch (Throwable unused) {
                }
            }
            if (objInvoke != null) {
                cls = objInvoke.getClass();
            } else {
                if (obj2 == null) {
                    name = "";
                    o4 o4VarA = a(cls2, true, name, name2, l5.d(obj), l5.c(obj), jCurrentTimeMillis, l5.e(obj));
                    g = o4VarA;
                    l.put(Integer.valueOf(obj.hashCode()), new a(o4VarA, obj));
                }
                cls = obj2.getClass();
            }
            name = cls.getName();
            o4 o4VarA2 = a(cls2, true, name, name2, l5.d(obj), l5.c(obj), jCurrentTimeMillis, l5.e(obj));
            g = o4VarA2;
            l.put(Integer.valueOf(obj.hashCode()), new a(o4VarA2, obj));
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        Map<Integer, a> map = l;
        if (map.isEmpty() || !map.containsKey(Integer.valueOf(obj.hashCode()))) {
            return false;
        }
        a aVar = map.get(Integer.valueOf(obj.hashCode()));
        if (aVar.b.get() == null) {
            map.remove(Integer.valueOf(obj.hashCode()));
            LoggerImpl.global().debug("[Navigator] inFragmentCache frag already recycle：{}", obj);
        }
        return aVar.b.get() == obj;
    }

    public static Activity b() {
        return (Activity) j;
    }

    public static boolean b(Object obj) {
        Object objB = l5.b(obj);
        if (objB != null && !b(objB)) {
            return false;
        }
        try {
            Class[] clsArr = new Class[0];
            Method method = obj.getClass().getMethod("isResumed", null);
            if (method == null || !Boolean.TRUE.equals(method.invoke(obj, null))) {
                return false;
            }
            try {
                Class[] clsArr2 = new Class[0];
                Method method2 = obj.getClass().getMethod("isHidden", null);
                if (method2 != null) {
                    if (Boolean.TRUE.equals(method2.invoke(obj, null))) {
                        return false;
                    }
                }
            } catch (Throwable unused) {
            }
            Class[] clsArr3 = new Class[0];
            Method method3 = obj.getClass().getMethod("getUserVisibleHint", null);
            if (method3 != null) {
                return Boolean.TRUE.equals(method3.invoke(obj, null));
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static void c(Object obj) {
        LoggerImpl.global().debug("[Navigator] onFragPause:frag：{}", obj);
        if (!a(obj)) {
            LoggerImpl.global().debug("[Navigator] onFragPause not in cache：{}", obj);
            return;
        }
        Map<Integer, a> map = l;
        o4 o4Var = map.get(Integer.valueOf(obj.hashCode())).a;
        map.remove(Integer.valueOf(obj.hashCode()));
        LoggerImpl.global().debug("[Navigator] onFragPause:page：{}", o4Var);
        if (o4Var != null) {
            a(true, o4Var, System.currentTimeMillis());
        }
        g = null;
    }

    public static void d(Object obj) {
        if (obj == null) {
            return;
        }
        a(obj, b(obj));
    }

    public void a(Activity activity, int i2) {
        o4 o4VarA = a(activity.getClass(), false, activity.getClass().getName(), "", l5.d(activity), l5.c(activity), System.currentTimeMillis(), l5.e(activity));
        f = o4VarA;
        o4VarA.A = !n.remove(Integer.valueOf(i2)) ? 1 : 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        n.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        n.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a.a(jCurrentTimeMillis);
        b = false;
        LoggerImpl.global().debug("[Navigator] onActivityPaused:{}", activity != null ? activity.getClass().getName() : "");
        for (a aVar : l.values()) {
            if (aVar != null) {
                c(aVar.b.get());
            }
        }
        l.clear();
        o4 o4Var = f;
        if (o4Var != null) {
            i = o4Var.u;
            h = jCurrentTimeMillis;
            a(false, o4Var, jCurrentTimeMillis);
            f = null;
            if (activity == null || activity.isChild()) {
                return;
            }
            j = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a.c(jCurrentTimeMillis);
        b = true;
        String strD = l5.d(activity);
        LoggerImpl.global().debug("[Navigator] onActivityResumed:{} {}", strD, activity.getClass().getName());
        o4 o4VarA = a(activity.getClass(), false, activity.getClass().getName(), "", strD, l5.c(activity), jCurrentTimeMillis, l5.e(activity));
        f = o4VarA;
        o4VarA.A = 1 ^ (n.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0);
        if (activity.isChild()) {
            return;
        }
        j = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        e++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (i != null) {
            int i2 = e - 1;
            e = i2;
            if (i2 <= 0) {
                i = null;
                h = 0L;
                b.a(new c());
            }
        }
    }

    public static o4 a(boolean z, o4 o4Var, long j2) {
        o4 o4Var2 = (o4) o4Var.m321clone();
        o4Var2.a(j2);
        long j3 = j2 - o4Var.c;
        if (j3 <= 0) {
            j3 = 1000;
        }
        o4Var2.s = j3;
        o4Var2.D = z;
        b.a(o4Var2, new v(o4Var2));
        LoggerImpl.global().debug("[Navigator] pausePage page.name：{}, duration：{}", o4Var2.u, Long.valueOf(o4Var2.s));
        b.a(new t(o4Var2), new u());
        return o4Var2;
    }

    public static o4 a(Class<?> cls, boolean z, String str, String str2, String str3, String str4, long j2, JSONObject jSONObject) {
        o4 o4Var = new o4();
        o4Var.E = cls;
        if (TextUtils.isEmpty(str2)) {
            o4Var.u = str;
        } else {
            o4Var.u = str + ":" + str2;
        }
        o4Var.a(j2);
        o4Var.z = j2;
        o4Var.s = -1L;
        o4 o4Var2 = m;
        o4Var.t = o4Var2 != null ? o4Var2.u : "";
        if (str3 == null) {
            str3 = "";
        }
        o4Var.v = str3;
        o4 o4Var3 = m;
        o4Var.w = o4Var3 != null ? o4Var3.v : "";
        if (str4 == null) {
            str4 = "";
        }
        o4Var.x = str4;
        o4 o4Var4 = m;
        o4Var.y = o4Var4 != null ? o4Var4.x : "";
        o4Var.o = jSONObject;
        o4Var.D = z;
        b.a(o4Var, new v(o4Var));
        m = o4Var;
        LoggerImpl.global().debug("[Navigator] resumePage page.name：{}", o4Var.u);
        return o4Var;
    }
}
