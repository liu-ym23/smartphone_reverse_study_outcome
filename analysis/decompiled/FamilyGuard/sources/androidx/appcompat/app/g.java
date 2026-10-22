package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.g;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import q.C0934b;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    static c f7526a = new c(new d());

    /* renamed from: b, reason: collision with root package name */
    private static int f7527b = -100;

    /* renamed from: c, reason: collision with root package name */
    private static androidx.core.os.d f7528c = null;

    /* renamed from: d, reason: collision with root package name */
    private static androidx.core.os.d f7529d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f7530e = null;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f7531f = false;

    /* renamed from: g, reason: collision with root package name */
    private static final C0934b<WeakReference<g>> f7532g = new C0934b<>();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f7533h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static final Object f7534i = new Object();

    static class a {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    static class b {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    static class c implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Object f7535a = new Object();

        /* renamed from: b, reason: collision with root package name */
        final Queue<Runnable> f7536b = new ArrayDeque();

        /* renamed from: c, reason: collision with root package name */
        final Executor f7537c;

        /* renamed from: d, reason: collision with root package name */
        Runnable f7538d;

        c(Executor executor) {
            this.f7537c = executor;
        }

        public static /* synthetic */ void a(c cVar, Runnable runnable) {
            cVar.getClass();
            try {
                runnable.run();
            } finally {
                cVar.b();
            }
        }

        protected void b() {
            synchronized (this.f7535a) {
                try {
                    Runnable runnablePoll = this.f7536b.poll();
                    this.f7538d = runnablePoll;
                    if (runnablePoll != null) {
                        this.f7537c.execute(runnablePoll);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f7535a) {
                try {
                    this.f7536b.add(new Runnable() { // from class: androidx.appcompat.app.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.c.a(this.f7539a, runnable);
                        }
                    });
                    if (this.f7538d == null) {
                        b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static class d implements Executor {
        d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    g() {
    }

    static void C(g gVar) {
        synchronized (f7533h) {
            D(gVar);
        }
    }

    private static void D(g gVar) {
        synchronized (f7533h) {
            try {
                Iterator<WeakReference<g>> it = f7532g.iterator();
                while (it.hasNext()) {
                    g gVar2 = it.next().get();
                    if (gVar2 == gVar || gVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void L(Context context) {
        ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
        if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
            if (k().d()) {
                String strA = androidx.core.app.d.a(context);
                Object systemService = context.getSystemService("locale");
                if (systemService != null) {
                    b.b(systemService, a.a(strA));
                }
            }
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    static void M(final Context context) {
        if (t(context) && !f7531f) {
            f7526a.execute(new Runnable() { // from class: androidx.appcompat.app.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.c(context);
                }
            });
        }
    }

    public static /* synthetic */ void c(Context context) {
        L(context);
        f7531f = true;
    }

    static void d(g gVar) {
        synchronized (f7533h) {
            D(gVar);
            f7532g.add(new WeakReference<>(gVar));
        }
    }

    public static g h(Activity activity, e eVar) {
        return new i(activity, eVar);
    }

    public static g i(Dialog dialog, e eVar) {
        return new i(dialog, eVar);
    }

    public static androidx.core.os.d k() {
        Object objO = o();
        return objO != null ? androidx.core.os.d.f(b.a(objO)) : androidx.core.os.d.c();
    }

    public static int m() {
        return f7527b;
    }

    static Object o() {
        Context contextL;
        Iterator<WeakReference<g>> it = f7532g.iterator();
        while (it.hasNext()) {
            g gVar = it.next().get();
            if (gVar != null && (contextL = gVar.l()) != null) {
                return contextL.getSystemService("locale");
            }
        }
        return null;
    }

    static boolean t(Context context) {
        if (f7530e == null) {
            try {
                Bundle bundle = n.a(context).metaData;
                if (bundle != null) {
                    f7530e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f7530e = Boolean.FALSE;
            }
        }
        return f7530e.booleanValue();
    }

    public abstract void A();

    public abstract void B();

    public abstract boolean E(int i5);

    public abstract void F(int i5);

    public abstract void G(View view);

    public abstract void H(View view, ViewGroup.LayoutParams layoutParams);

    public void I(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public void J(int i5) {
    }

    public abstract void K(CharSequence charSequence);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    public void f(Context context) {
    }

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract <T extends View> T j(int i5);

    public Context l() {
        return null;
    }

    public int n() {
        return -100;
    }

    public abstract MenuInflater p();

    public abstract androidx.appcompat.app.a q();

    public abstract void r();

    public abstract void s();

    public abstract void u(Configuration configuration);

    public abstract void v(Bundle bundle);

    public abstract void w();

    public abstract void x(Bundle bundle);

    public abstract void y();

    public abstract void z(Bundle bundle);
}
