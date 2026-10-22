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
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.a0;
import i.AbstractC4156b;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static c f8423a = new c(new d());

    /* renamed from: b, reason: collision with root package name */
    public static int f8424b = -100;

    /* renamed from: c, reason: collision with root package name */
    public static x0.g f8425c = null;

    /* renamed from: d, reason: collision with root package name */
    public static x0.g f8426d = null;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f8427e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f8428f = false;

    /* renamed from: g, reason: collision with root package name */
    public static final androidx.collection.b<WeakReference<g>> f8429g = new androidx.collection.b<>();

    /* renamed from: h, reason: collision with root package name */
    public static final Object f8430h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static final Object f8431i = new Object();

    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    public static class c implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Object f8432a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public final Queue<Runnable> f8433b = new ArrayDeque();

        /* renamed from: c, reason: collision with root package name */
        public final Executor f8434c;

        /* renamed from: d, reason: collision with root package name */
        public Runnable f8435d;

        public c(Executor executor) {
            this.f8434c = executor;
        }

        public static /* synthetic */ void a(c cVar, Runnable runnable) {
            cVar.getClass();
            try {
                runnable.run();
            } finally {
                cVar.b();
            }
        }

        public void b() {
            synchronized (this.f8432a) {
                try {
                    Runnable runnablePoll = this.f8433b.poll();
                    this.f8435d = runnablePoll;
                    if (runnablePoll != null) {
                        this.f8434c.execute(runnablePoll);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f8432a) {
                try {
                    this.f8433b.add(new Runnable() { // from class: androidx.appcompat.app.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.c.a(this.f8436a, runnable);
                        }
                    });
                    if (this.f8435d == null) {
                        b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static class d implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    public static void F(g gVar) {
        synchronized (f8430h) {
            G(gVar);
        }
    }

    public static void G(g gVar) {
        synchronized (f8430h) {
            try {
                Iterator<WeakReference<g>> it = f8429g.iterator();
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

    public static void I(boolean z10) {
        a0.c(z10);
    }

    public static void M(int i10) {
        if (i10 != -1 && i10 != 0 && i10 != 1 && i10 != 2 && i10 != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
        } else if (f8424b != i10) {
            f8424b = i10;
            g();
        }
    }

    public static void T(Context context) {
        ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
        if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
            if (m().e()) {
                String strA = androidx.core.app.d.a(context);
                Object systemService = context.getSystemService("locale");
                if (systemService != null) {
                    b.b(systemService, a.a(strA));
                }
            }
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    public static void U(final Context context) {
        if (w(context) && !f8428f) {
            f8423a.execute(new Runnable() { // from class: androidx.appcompat.app.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.c(context);
                }
            });
        }
    }

    public static /* synthetic */ void c(Context context) {
        T(context);
        f8428f = true;
    }

    public static void d(g gVar) {
        synchronized (f8430h) {
            G(gVar);
            f8429g.add(new WeakReference<>(gVar));
        }
    }

    public static void g() {
        synchronized (f8430h) {
            try {
                Iterator<WeakReference<g>> it = f8429g.iterator();
                while (it.hasNext()) {
                    g gVar = it.next().get();
                    if (gVar != null) {
                        gVar.f();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static g j(Activity activity, e eVar) {
        return new AppCompatDelegateImpl(activity, eVar);
    }

    public static g k(Dialog dialog, e eVar) {
        return new AppCompatDelegateImpl(dialog, eVar);
    }

    public static x0.g m() {
        Object objR = r();
        return objR != null ? x0.g.h(b.a(objR)) : x0.g.d();
    }

    public static int o() {
        return f8424b;
    }

    public static Object r() {
        Context contextN;
        Iterator<WeakReference<g>> it = f8429g.iterator();
        while (it.hasNext()) {
            g gVar = it.next().get();
            if (gVar != null && (contextN = gVar.n()) != null) {
                return contextN.getSystemService("locale");
            }
        }
        return null;
    }

    public static boolean w(Context context) {
        if (f8427e == null) {
            try {
                Bundle bundle = n.a(context).metaData;
                if (bundle != null) {
                    f8427e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f8427e = Boolean.FALSE;
            }
        }
        return f8427e.booleanValue();
    }

    public abstract void A(Bundle bundle);

    public abstract void B();

    public abstract void C(Bundle bundle);

    public abstract void D();

    public abstract void E();

    public abstract boolean H(int i10);

    public abstract void J(int i10);

    public abstract void K(View view);

    public abstract void L(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void N(int i10);

    public void O(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void P(Toolbar toolbar);

    public void Q(int i10) {
    }

    public abstract void R(CharSequence charSequence);

    public abstract AbstractC4156b S(AbstractC4156b.a aVar);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean f();

    @Deprecated
    public void h(Context context) {
    }

    public Context i(Context context) {
        h(context);
        return context;
    }

    public abstract <T extends View> T l(int i10);

    public Context n() {
        return null;
    }

    public abstract androidx.appcompat.app.b p();

    public int q() {
        return -100;
    }

    public abstract MenuInflater s();

    public abstract androidx.appcompat.app.a t();

    public abstract void u();

    public abstract void v();

    public abstract void x(Configuration configuration);

    public abstract void y(Bundle bundle);

    public abstract void z();
}
