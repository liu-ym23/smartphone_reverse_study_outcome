package z5;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.lang.reflect.Field;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u000eJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lz5/c;", "", "<init>", "()V", "Landroid/content/Context;", "base", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)Landroid/content/Context;", "Landroid/content/res/Resources;", "resources", "Landroid/content/res/Configuration;", "newConfig", "LY8/t;", "f", "(Landroid/content/res/Resources;Landroid/content/res/Configuration;)V", "e", "(Landroid/content/res/Resources;)V", "Landroid/app/Application;", "app", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/app/Application;)V", "", "fontScale", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/Float;)Landroid/content/Context;", Const.INTENT_KEY_UMID, "Landroid/app/Activity;", "activity", "c", "(Landroid/app/Activity;)V", "", "TAG", "Ljava/lang/String;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final c INSTANCE = new c();
    private static final String TAG = "AILauncher-FontScale";

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"z5/c$a", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onActivityPreCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityCreated", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle savedInstanceState) {
            p.i(activity, "activity");
            if (activity instanceof ActivityC6361a) {
                return;
            }
            c.INSTANCE.c(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            p.i(activity, "activity");
            p.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            p.i(activity, "activity");
        }
    }

    public final Context b(Context base, Float fontScale) {
        Context contextCreateConfigurationContext = base.createConfigurationContext(C6362b.INSTANCE.b(fontScale));
        p.h(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return contextCreateConfigurationContext;
    }

    public final void c(Activity activity) {
        Object objB;
        float f10 = activity.getResources().getConfiguration().fontScale;
        if (f10 <= 1.18f) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            ActivityC6361a.Companion companion2 = ActivityC6361a.INSTANCE;
            Context baseContext = activity.getBaseContext();
            p.h(baseContext, "getBaseContext(...)");
            Context contextA = companion2.a(baseContext);
            Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
            declaredField.setAccessible(true);
            declaredField.set(activity, contextA);
            objB = Result.b(Integer.valueOf(C4148a.k(TAG, "[FontCap] AAR " + activity.getClass().getSimpleName() + " mBase swapped from " + f10 + " to 1.18", false, 4, null)));
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "[FontCap] reflect failed for " + activity.getClass().getSimpleName(), thE, false, 8, null);
        }
    }

    public final void d(Resources resources, Configuration newConfig) {
        float f10 = newConfig.fontScale;
        float fMin = Math.min(f10, 1.18f);
        float f11 = resources.getConfiguration().fontScale;
        if (f11 == fMin) {
            return;
        }
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.fontScale = fMin;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        C4148a.d(TAG, "[FontCap] Application onConfigurationChanged systemScale=" + f10 + " target=" + fMin + " (was=" + f11 + ")", false, 4, null);
    }

    public final void e(Resources resources) {
        p.i(resources, "resources");
        Configuration configuration = new Configuration(resources.getConfiguration());
        int i10 = configuration.uiMode;
        if ((i10 & 48) == 32) {
            return;
        }
        configuration.uiMode = (i10 & (-49)) | 32;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public final void f(Resources resources, Configuration newConfig) {
        p.i(resources, "resources");
        p.i(newConfig, "newConfig");
        e(resources);
        d(resources, newConfig);
    }

    public final void g(Application app) {
        p.i(app, "app");
        app.registerActivityLifecycleCallbacks(new a());
        C4148a.d(TAG, "[FontCap] AAR Activity reflection fallback registered", false, 4, null);
    }

    public final Context h(Context base) {
        p.i(base, "base");
        return b(base, base.getResources().getConfiguration().fontScale > 1.18f ? Float.valueOf(1.18f) : null);
    }
}
