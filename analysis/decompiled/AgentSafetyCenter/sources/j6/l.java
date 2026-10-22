package j6;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.o;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g, reason: collision with root package name */
    public static final l f6613g;

    /* renamed from: h, reason: collision with root package name */
    public static final Activity f6614h;

    /* renamed from: a, reason: collision with root package name */
    public LinkedList f6615a;

    /* renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList f6616b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap f6617c;

    /* renamed from: d, reason: collision with root package name */
    public int f6618d;

    /* renamed from: e, reason: collision with root package name */
    public int f6619e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6620f;

    static {
        l lVar = new l();
        lVar.f6615a = new LinkedList();
        lVar.f6616b = new CopyOnWriteArrayList();
        lVar.f6617c = new ConcurrentHashMap();
        lVar.f6618d = 0;
        lVar.f6619e = 0;
        lVar.f6620f = false;
        VarHandle.storeStoreFence();
        f6613g = lVar;
        f6614h = new Activity();
    }

    public static Object c() {
        Object obj;
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Exception e10) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e10.getMessage());
            obj = null;
        }
        if (obj != null) {
            return obj;
        }
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e11.getMessage());
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
                com.stepos.statsrpk.service.d dVar = new com.stepos.statsrpk.service.d(4);
                dVar.f2885f = activity;
                dVar.f2886g = (Integer) tag;
                VarHandle.storeStoreFence();
                k.f6611a.postDelayed(dVar, 100L);
            }
        } catch (Exception unused) {
        }
    }

    public final void a(Activity activity, o oVar) {
        ConcurrentHashMap concurrentHashMap = this.f6617c;
        b(activity, oVar, (List) concurrentHashMap.get(activity));
        b(activity, oVar, (List) concurrentHashMap.get(f6614h));
    }

    public final void b(Activity activity, o oVar, List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
        if (oVar.equals(o.ON_DESTROY)) {
            this.f6617c.remove(activity);
        }
    }

    public final void d(boolean z10) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f6616b;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                od.f.j();
            } else {
                if (!z10) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public final void f(Activity activity) {
        LinkedList linkedList = this.f6615a;
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
        if (this.f6615a.size() == 0) {
            d(true);
        }
        String string = td.h.w().f6602a.getString("KEY_LOCALE", "");
        if (!TextUtils.isEmpty(string)) {
            if ("VALUE_FOLLOW_SYSTEM".equals(string)) {
                locale2 = Resources.getSystem().getConfiguration().getLocales().get(0);
            } else {
                char[] charArray = string.toCharArray();
                int length = charArray.length;
                int i = 0;
                int i3 = 0;
                while (true) {
                    if (i < length) {
                        if (charArray[i] == '$') {
                            if (i3 >= 1) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        i++;
                    } else if (i3 == 1) {
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
                    td.h.w().f6602a.edit().remove("KEY_LOCALE").apply();
                }
                locale2 = locale;
            }
            if (locale2 != null) {
                Resources resources = activity.getResources();
                Configuration configuration = resources.getConfiguration();
                configuration.setLocale(locale2);
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
                Resources resources2 = p5.f.x().getResources();
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
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (NoSuchFieldException e11) {
                e11.printStackTrace();
            }
        }
        f(activity);
        a(activity, o.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f6615a.remove(activity);
        Window window = activity.getWindow();
        InputMethodManager inputMethodManager = (InputMethodManager) p5.f.x().getSystemService("input_method");
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
        a(activity, o.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, o.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        f(activity);
        if (this.f6620f) {
            this.f6620f = false;
            d(true);
        }
        e(activity, false);
        a(activity, o.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (!this.f6620f) {
            f(activity);
        }
        int i = this.f6619e;
        if (i < 0) {
            this.f6619e = i + 1;
        } else {
            this.f6618d++;
        }
        a(activity, o.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.f6619e--;
        } else {
            int i = this.f6618d - 1;
            this.f6618d = i;
            if (i <= 0) {
                this.f6620f = true;
                d(false);
            }
        }
        e(activity, true);
        a(activity, o.ON_STOP);
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
    public final void onActivityPostStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostStopped(Activity activity) {
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
    public final void onActivityPreStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
