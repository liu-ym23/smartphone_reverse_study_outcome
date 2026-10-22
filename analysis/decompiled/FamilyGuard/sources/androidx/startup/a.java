package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import f0.C0694b;
import f0.InterfaceC0693a;
import f0.c;
import g0.C0729a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f11339d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f11340e = new Object();

    /* renamed from: c, reason: collision with root package name */
    final Context f11343c;

    /* renamed from: b, reason: collision with root package name */
    final Set<Class<? extends InterfaceC0693a<?>>> f11342b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    final Map<Class<?>, Object> f11341a = new HashMap();

    a(Context context) {
        this.f11343c = context.getApplicationContext();
    }

    private <T> T d(Class<? extends InterfaceC0693a<?>> cls, Set<Class<?>> set) {
        T t5;
        if (C0729a.d()) {
            try {
                C0729a.a(cls.getSimpleName());
            } finally {
                C0729a.b();
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f11341a.containsKey(cls)) {
            t5 = (T) this.f11341a.get(cls);
        } else {
            set.add(cls);
            try {
                InterfaceC0693a<?> interfaceC0693aNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                List<Class<? extends InterfaceC0693a<?>>> listA = interfaceC0693aNewInstance.a();
                if (!listA.isEmpty()) {
                    for (Class<? extends InterfaceC0693a<?>> cls2 : listA) {
                        if (!this.f11341a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                t5 = (T) interfaceC0693aNewInstance.b(this.f11343c);
                set.remove(cls);
                this.f11341a.put(cls, t5);
            } catch (Throwable th) {
                throw new c(th);
            }
        }
        return t5;
    }

    public static a e(Context context) {
        if (f11339d == null) {
            synchronized (f11340e) {
                try {
                    if (f11339d == null) {
                        f11339d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f11339d;
    }

    void a() {
        try {
            try {
                C0729a.a("Startup");
                b(this.f11343c.getPackageManager().getProviderInfo(new ComponentName(this.f11343c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e6) {
                throw new c(e6);
            }
        } finally {
            C0729a.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b(Bundle bundle) throws ClassNotFoundException {
        String string = this.f11343c.getString(C0694b.f16751a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (InterfaceC0693a.class.isAssignableFrom(cls)) {
                            this.f11342b.add(cls);
                        }
                    }
                }
                Iterator<Class<? extends InterfaceC0693a<?>>> it = this.f11342b.iterator();
                while (it.hasNext()) {
                    d(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e6) {
                throw new c(e6);
            }
        }
    }

    <T> T c(Class<? extends InterfaceC0693a<?>> cls) {
        T t5;
        synchronized (f11340e) {
            try {
                t5 = (T) this.f11341a.get(cls);
                if (t5 == null) {
                    t5 = (T) d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t5;
    }

    public <T> T f(Class<? extends InterfaceC0693a<T>> cls) {
        return (T) c(cls);
    }

    public boolean g(Class<? extends InterfaceC0693a<?>> cls) {
        return this.f11342b.contains(cls);
    }
}
