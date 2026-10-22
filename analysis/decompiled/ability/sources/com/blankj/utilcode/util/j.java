package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Lifecycle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class j implements Application.ActivityLifecycleCallbacks {
    public static final j g = new j();
    public static final Activity h = new Activity();

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f2208a = new LinkedList();
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public int d = 0;
    public int e = 0;
    public boolean f = false;

    public static Object c() {
        Object obj;
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Exception e) {
            androidx.constraintlayout.core.dsl.a.t(e, new StringBuilder("getActivityThreadInActivityThreadStaticField: "), "UtilsActivityLifecycle");
            obj = null;
        }
        if (obj != null) {
            return obj;
        }
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Exception e6) {
            androidx.constraintlayout.core.dsl.a.t(e6, new StringBuilder("getActivityThreadInActivityThreadStaticMethod: "), "UtilsActivityLifecycle");
            return null;
        }
    }

    public static void e(Activity activity, boolean z10) {
        try {
            if (z10) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
                return;
            }
            Object tag = activity.getWindow().getDecorView().getTag(-123);
            if (tag instanceof Integer) {
                i.f2207a.postDelayed(new A.a(10, activity, false, (Integer) tag), 100L);
            }
        } catch (Exception unused) {
        }
    }

    public final void a(Activity activity, Lifecycle.Event event) {
        ConcurrentHashMap concurrentHashMap = this.c;
        b(activity, event, (List) concurrentHashMap.get(activity));
        b(activity, event, (List) concurrentHashMap.get(h));
    }

    public final void b(Activity activity, Lifecycle.Event event, List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            this.c.remove(activity);
        }
    }

    public final void d(boolean z10) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.b;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public final void f(Activity activity) {
        LinkedList linkedList = this.f2208a;
        if (!linkedList.contains(activity)) {
            linkedList.addFirst(activity);
        } else {
            if (((Activity) linkedList.getFirst()).equals(activity)) {
                return;
            }
            linkedList.remove(activity);
            linkedList.addFirst(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Locale locale;
        Locale locale2;
        if (this.f2208a.size() == 0) {
            d(true);
        }
        String string = k.a().f2205a.getString("KEY_LOCALE", "");
        if (!TextUtils.isEmpty(string)) {
            if ("VALUE_FOLLOW_SYSTEM".equals(string)) {
                locale2 = Resources.getSystem().getConfiguration().getLocales().get(0);
            } else {
                char[] charArray = string.toCharArray();
                int length = charArray.length;
                int i = 0;
                int i6 = 0;
                while (true) {
                    if (i < length) {
                        if (charArray[i] == '$') {
                            if (i6 >= 1) {
                                break;
                            } else {
                                i6++;
                            }
                        }
                        i++;
                    } else if (i6 == 1) {
                        try {
                            int iIndexOf = string.indexOf("$");
                            locale = new Locale(string.substring(0, iIndexOf), string.substring(iIndexOf + 1));
                        } catch (Exception unused) {
                        }
                    }
                }
                locale = null;
                if (locale == null) {
                    Log.e("LanguageUtils", "The string of " + string + " is not in the correct format.");
                    k.a().f2205a.edit().remove("KEY_LOCALE").apply();
                }
                locale2 = locale;
            }
            if (locale2 != null) {
                Resources resources = activity.getResources();
                Configuration configuration = resources.getConfiguration();
                configuration.setLocale(locale2);
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
                Resources resources2 = S0.b.X0().getResources();
                Configuration configuration2 = resources2.getConfiguration();
                configuration2.setLocale(locale2);
                resources2.updateConfiguration(configuration2, resources2.getDisplayMetrics());
            }
        }
        if (!ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                    declaredField.set(null, Float.valueOf(1.0f));
                    Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e6) {
                e6.printStackTrace();
            }
        }
        f(activity);
        a(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f2208a.remove(activity);
        Window window = activity.getWindow();
        InputMethodManager inputMethodManager = (InputMethodManager) S0.b.X0().getSystemService("input_method");
        if (inputMethodManager != null) {
            String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
            for (int i = 0; i < 4; i++) {
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if ((obj instanceof View) && ((View) obj).getRootView() == window.getDecorView().getRootView()) {
                        declaredField.set(inputMethodManager, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        a(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPrePaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        f(activity);
        if (this.f) {
            this.f = false;
            d(true);
        }
        e(activity, false);
        a(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (!this.f) {
            f(activity);
        }
        int i = this.e;
        if (i < 0) {
            this.e = i + 1;
        } else {
            this.d++;
        }
        a(activity, Lifecycle.Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.e--;
        } else {
            int i = this.d - 1;
            this.d = i;
            if (i <= 0) {
                this.f = true;
                d(false);
            }
        }
        e(activity, true);
        a(activity, Lifecycle.Event.ON_STOP);
    }
}
