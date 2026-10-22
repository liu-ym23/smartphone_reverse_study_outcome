package androidx.appcompat.app;

import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.t;
import com.stepos.core.common.util.TraceIdKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import p.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final c f328a = new c(new d());

    /* renamed from: b, reason: collision with root package name */
    public static final int f329b = -100;

    /* renamed from: c, reason: collision with root package name */
    public static r0.d f330c = null;

    /* renamed from: d, reason: collision with root package name */
    public static r0.d f331d = null;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f332e = null;
    public static boolean h = false;

    /* renamed from: j, reason: collision with root package name */
    public static final p.b<WeakReference<k>> f333j = new p.b<>(null);

    /* renamed from: k, reason: collision with root package name */
    public static final Object f334k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static final Object f335l = new Object();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Object f336a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayDeque f337b = new ArrayDeque();

        /* renamed from: c, reason: collision with root package name */
        public final d f338c;

        /* renamed from: d, reason: collision with root package name */
        public Runnable f339d;

        public c(d dVar) {
            this.f338c = dVar;
        }

        public final void b() {
            synchronized (this.f336a) {
                try {
                    Runnable runnable = (Runnable) this.f337b.poll();
                    this.f339d = runnable;
                    if (runnable != null) {
                        this.f338c.execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            synchronized (this.f336a) {
                try {
                    this.f337b.add(new l(0, this, runnable));
                    if (this.f339d == null) {
                        b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    public static boolean i(Context context) {
        if (f332e == null) {
            try {
                int i10 = t.f361a;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) t.class), t.a.a() | TraceIdKeys.MAX_LENGTH).metaData;
                if (bundle != null) {
                    f332e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f332e = Boolean.FALSE;
            }
        }
        return f332e.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m(k kVar) {
        synchronized (f334k) {
            try {
                p.b<WeakReference<k>> bVar = f333j;
                bVar.getClass();
                b.a aVar = new b.a();
                while (aVar.hasNext()) {
                    k kVar2 = (k) ((WeakReference) aVar.next()).get();
                    if (kVar2 == kVar || kVar2 == null) {
                        aVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public abstract <T extends View> T d(int i10);

    public Context e() {
        return null;
    }

    public int f() {
        return -100;
    }

    public abstract void g();

    public abstract void h();

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract boolean n(int i10);

    public abstract void o(int i10);

    public abstract void p(View view);

    public abstract void q(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void r(CharSequence charSequence);
}
