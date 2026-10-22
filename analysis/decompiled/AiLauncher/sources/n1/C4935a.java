package n1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import androidx.startup.R$string;
import androidx.startup.StartupException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o1.C4996a;

/* renamed from: n1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4935a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile C4935a f37240d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f37241e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f37244c;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Class<? extends b<?>>> f37243b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, Object> f37242a = new HashMap();

    public C4935a(Context context) {
        this.f37244c = context.getApplicationContext();
    }

    public static C4935a e(Context context) {
        if (f37240d == null) {
            synchronized (f37241e) {
                try {
                    if (f37240d == null) {
                        f37240d = new C4935a(context);
                    }
                } finally {
                }
            }
        }
        return f37240d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Bundle bundle) throws ClassNotFoundException {
        String string = this.f37244c.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f37243b.add(cls);
                        }
                    }
                }
                Iterator<Class<? extends b<?>>> it = this.f37243b.iterator();
                while (it.hasNext()) {
                    d(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new StartupException(e10);
            }
        }
    }

    public void b(Class<? extends InitializationProvider> cls) {
        try {
            try {
                C4996a.a("Startup");
                a(this.f37244c.getPackageManager().getProviderInfo(new ComponentName(this.f37244c, cls), 128).metaData);
            } catch (PackageManager.NameNotFoundException e10) {
                throw new StartupException(e10);
            }
        } finally {
            C4996a.b();
        }
    }

    public <T> T c(Class<? extends b<?>> cls) {
        T t10;
        synchronized (f37241e) {
            try {
                t10 = (T) this.f37242a.get(cls);
                if (t10 == null) {
                    t10 = (T) d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t10;
    }

    public final <T> T d(Class<? extends b<?>> cls, Set<Class<?>> set) {
        T t10;
        if (C4996a.c()) {
            try {
                C4996a.a(cls.getSimpleName());
            } finally {
                C4996a.b();
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f37242a.containsKey(cls)) {
            t10 = (T) this.f37242a.get(cls);
        } else {
            set.add(cls);
            try {
                b<?> bVarNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                List<Class<? extends b<?>>> listA = bVarNewInstance.a();
                if (!listA.isEmpty()) {
                    for (Class<? extends b<?>> cls2 : listA) {
                        if (!this.f37242a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                t10 = (T) bVarNewInstance.b(this.f37244c);
                set.remove(cls);
                this.f37242a.put(cls, t10);
            } catch (Throwable th) {
                throw new StartupException(th);
            }
        }
        return t10;
    }

    public <T> T f(Class<? extends b<T>> cls) {
        return (T) c(cls);
    }

    public boolean g(Class<? extends b<?>> cls) {
        return this.f37243b.contains(cls);
    }
}
