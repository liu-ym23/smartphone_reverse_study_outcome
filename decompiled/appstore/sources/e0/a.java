package e0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import androidx.startup.Initializer;
import androidx.startup.R$string;
import androidx.startup.StartupException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f19225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f19226e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f19227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f19228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f19229c;

    static {
        f19226e = new Object();
    }

    public a(Context r10) {
        this.f19229c = r10.getApplicationContext();
        this.f19228b = new HashSet();
        this.f19227a = new HashMap();
    }

    public static a e(Context r10) {
        if (f19225d != null) goto L16;
        Object r11 = f19226e;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19225d != null) goto L11;
        f19225d = new a(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
    L16:
        return f19225d;
    }

    public void a() {
        g0.a.a("Startup");     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        ComponentName r10 = new ComponentName(this.f19229c.getPackageName(), InitializationProvider.class.getName());     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        b(this.f19229c.getPackageManager().getProviderInfo(r10, 128).metaData);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        g0.a.b();
        return;
    L5:
        th = move-exception;
        g0.a.b();
        throw th;
    L7:
        e = move-exception;
        throw new StartupException(e);     // Catch: Throwable -> L5
    }

    public void b(Bundle r10) {
        String r11 = this.f19229c.getString(R$string.androidx_startup);
        if (r10 != null) goto L22;
        return;
    L22:
        HashSet r12 = new HashSet();     // Catch: ClassNotFoundException -> L12
        Iterator<String> r13 = r10.keySet().iterator();     // Catch: ClassNotFoundException -> L12
    L6:
        if (r13.hasNext() == false) goto L14;
        String r14 = r13.next();     // Catch: ClassNotFoundException -> L12
        if (r11.equals(r10.getString(r14, null)) == false) goto L6;
        Class<?> r15 = Class.forName(r14);     // Catch: ClassNotFoundException -> L12
        if (Initializer.class.isAssignableFrom(r15) == false) goto L6;
        this.f19228b.add(r15);     // Catch: ClassNotFoundException -> L12
        goto L6
    L14:
        Iterator r16 = this.f19228b.iterator();     // Catch: ClassNotFoundException -> L12
    L15:
        if (r16.hasNext() == false) goto L32;
        d((Class) r16.next(), r12);     // Catch: ClassNotFoundException -> L12
        goto L15
    L32:
        return;
    L12:
        e = move-exception;
        throw new StartupException(e);
    }

    public Object c(Class r10) {
        Object r11 = f19226e;
        monitor-enter(r11);
        Object r12 = this.f19227a.get(r10);     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        r12 = d(r10, new HashSet());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public final Object d(Class r10, Set r11) {
        if (g0.a.d() == false) goto L8;
        g0.a.a(r10.getSimpleName());     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        g0.a.b();
        throw th;
    L8:
        if (r11.contains(r10) == true) goto L31;
        if (this.f19227a.containsKey(r10) == true) goto L27;
        r11.add(r10);     // Catch: Throwable -> L5
        Initializer r12 = (Initializer) r10.getDeclaredConstructor(null).newInstance(null);     // Catch: Throwable -> L21
        List<Class<? extends Initializer<?>>> r13 = r12.dependencies();     // Catch: Throwable -> L21
        if (r13.isEmpty() == true) goto L23;
        Iterator<Class<? extends Initializer<?>>> r14 = r13.iterator();     // Catch: Throwable -> L21
    L17:
        if (r14.hasNext() == false) goto L23;
        Class<? extends Initializer<?>> r15 = r14.next();     // Catch: Throwable -> L21
        if (this.f19227a.containsKey(r15) == true) goto L17;
        d(r15, r11);     // Catch: Throwable -> L21
    L23:
        Object r16 = r12.create(this.f19229c);     // Catch: Throwable -> L21
        r11.remove(r10);     // Catch: Throwable -> L21
        this.f19227a.put(r10, r16);     // Catch: Throwable -> L21
    L28:
        g0.a.b();
        return r16;
    L21:
        th = move-exception;
        throw new StartupException(th);     // Catch: Throwable -> L5
    L27:
        r16 = this.f19227a.get(r10);     // Catch: Throwable -> L5
        goto L28
    L31:
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{r10.getName()}));     // Catch: Throwable -> L5
    }

    public Object f(Class r10) {
        return c(r10);
    }

    public boolean g(Class r10) {
        return this.f19228b.contains(r10);
    }
}
