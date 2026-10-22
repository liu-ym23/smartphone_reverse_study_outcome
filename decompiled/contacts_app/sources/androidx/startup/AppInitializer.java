package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    private static volatile AppInitializer sInstance;
    private static final Object sLock = null;
    final Context mContext;
    final Set<Class<? extends Initializer<?>>> mDiscovered;
    final Map<Class<?>, Object> mInitialized;

    static {
        sLock = new Object();
    }

    AppInitializer(Context r1) {
        this.mContext = r1.getApplicationContext();
        this.mDiscovered = new HashSet();
        this.mInitialized = new HashMap();
    }

    public static AppInitializer getInstance(Context r2) {
        if (sInstance != null) goto L15;
        Object r0 = sLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AppInitializer(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    static void setDelegate(AppInitializer r1) {
        Object r0 = sLock;
        monitor-enter(r0);
        sInstance = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> T initializeComponent(Class<? extends Initializer<T>> r1) {
        return (T) doInitialize(r1);
    }

    public boolean isEagerlyInitialized(Class<? extends Initializer<?>> r1) {
        return this.mDiscovered.contains(r1);
    }

    <T> T doInitialize(Class<? extends Initializer<?>> r3) {
        Object r0 = sLock;
        monitor-enter(r0);
        T r1 = (T) this.mInitialized.get(r3);
        if (r1 != null) goto L7;
        r1 = (T) doInitialize(r3, new HashSet());
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    private <T> T doInitialize(Class<? extends Initializer<?>> r5, Set<Class<?>> r6) {
        if (Trace.isEnabled() == false) goto L6;
        Trace.beginSection(r5.getSimpleName());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Trace.endSection();
        throw th;
    L6:
        if (r6.contains(r5) == true) goto L27;
        if (this.mInitialized.containsKey(r5) == true) goto L23;
        r6.add(r5);     // Catch: Throwable -> L28
        Initializer<?> r0 = r5.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L20
        List<Class<? extends Initializer<?>>> r1 = r0.dependencies();     // Catch: Throwable -> L20
        if (r1.isEmpty() == true) goto L18;
        Iterator<Class<? extends Initializer<?>>> r2 = r1.iterator();     // Catch: Throwable -> L20
    L14:
        if (r2.hasNext() == false) goto L18;
        Class<? extends Initializer<?>> r3 = r2.next();     // Catch: Throwable -> L20
        if (this.mInitialized.containsKey(r3) == true) goto L14;
        doInitialize(r3, r6);     // Catch: Throwable -> L20
    L18:
        T r4 = (T) r0.create(this.mContext);
        r6.remove(r5);     // Catch: Throwable -> L20
        this.mInitialized.put(r5, r4);     // Catch: Throwable -> L20
    L24:
        Trace.endSection();
        return r4;
    L20:
        th = move-exception;
        throw new StartupException(th);     // Catch: Throwable -> L28
    L23:
        r4 = (T) this.mInitialized.get(r5);
        goto L24
    L27:
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{r5.getName()}));     // Catch: Throwable -> L28
    }

    void discoverAndInitialize() {
        Trace.beginSection(SECTION_NAME);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        ComponentName r0 = new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName());     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        discoverAndInitialize(this.mContext.getPackageManager().getProviderInfo(r0, 128).metaData);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        Trace.endSection();
        return;
    L5:
        th = move-exception;
        Trace.endSection();
        throw th;
    L7:
        e = move-exception;
        throw new StartupException(e);     // Catch: Throwable -> L5
    }

    void discoverAndInitialize(Bundle r6) {
        String r0 = this.mContext.getString(R.string.androidx_startup);
        if (r6 != null) goto L21;
        return;
    L21:
        HashSet r1 = new HashSet();     // Catch: ClassNotFoundException -> L17
        Iterator<String> r2 = r6.keySet().iterator();     // Catch: ClassNotFoundException -> L17
    L6:
        if (r2.hasNext() == false) goto L12;
        String r3 = r2.next();     // Catch: ClassNotFoundException -> L17
        if (r0.equals(r6.getString(r3, null)) == false) goto L6;
        Class<?> r4 = Class.forName(r3);     // Catch: ClassNotFoundException -> L17
        if (Initializer.class.isAssignableFrom(r4) == false) goto L6;
        this.mDiscovered.add((Class<? extends Initializer<?>>) r4);     // Catch: ClassNotFoundException -> L17
        goto L6
    L12:
        Iterator<Class<? extends Initializer<?>>> r7 = this.mDiscovered.iterator();     // Catch: ClassNotFoundException -> L17
    L13:
        if (r7.hasNext() == false) goto L31;
        doInitialize(r7.next(), r1);     // Catch: ClassNotFoundException -> L17
        goto L13
    L31:
        return;
    L17:
        e = move-exception;
        throw new StartupException(e);
    }
}
