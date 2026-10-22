package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.tracing.Trace;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import el9.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    private static volatile AppInitializer sInstance;
    private static final Object sLock = null;
    final Context mContext;
    final Set<Class<? extends Initializer<?>>> mDiscovered;
    final Map<Class<?>, Object> mInitialized;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sLock = new Object();
    }

    public void discoverAndInitialize() {
        Trace.beginSection(SECTION_NAME);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        ComponentName r100 = new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName());     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        discoverAndInitialize(this.mContext.getPackageManager().getProviderInfo(r100, 128).metaData);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
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

    public AppInitializer(Context r100) {
        this.mContext = r100.getApplicationContext();
        this.mDiscovered = new HashSet();
        this.mInitialized = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_startup_AppInitializer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static AppInitializer getInstance(Context r100) {
        if (sInstance != null) goto L15;
        Object r101 = sLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AppInitializer(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static void setDelegate(AppInitializer r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        sInstance = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void discoverAndInitialize(Bundle r100) {
        String r101 = this.mContext.getString(R.string.androidx_startup);
        if (r100 != null) goto L21;
        return;
    L21:
        HashSet r102 = new HashSet();     // Catch: ClassNotFoundException -> L17
        Iterator<String> r103 = r100.keySet().iterator();     // Catch: ClassNotFoundException -> L17
    L6:
        if (r103.hasNext() == false) goto L12;
        String r104 = r103.next();     // Catch: ClassNotFoundException -> L17
        if (r101.equals(r100.getString(r104, null)) == false) goto L6;
        Class<? extends Initializer<?>> r105 = INVOKESTATIC_androidx_startup_AppInitializer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r104);     // Catch: ClassNotFoundException -> L17
        if (Initializer.class.isAssignableFrom(r105) == false) goto L6;
        this.mDiscovered.add(r105);     // Catch: ClassNotFoundException -> L17
        goto L6
    L12:
        Iterator<Class<? extends Initializer<?>>> r106 = this.mDiscovered.iterator();     // Catch: ClassNotFoundException -> L17
    L13:
        if (r106.hasNext() == false) goto L31;
        doInitialize(r106.next(), r102);     // Catch: ClassNotFoundException -> L17
        goto L13
    L31:
        return;
    L17:
        e = move-exception;
        throw new StartupException(e);
    }

    public <T> T doInitialize(Class<? extends Initializer<?>> r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        T r102 = (T) this.mInitialized.get(r100);
        if (r102 != null) goto L7;
        r102 = (T) doInitialize(r100, new HashSet());
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    public <T> T initializeComponent(Class<? extends Initializer<T>> r100) {
        return (T) doInitialize(r100);
    }

    public boolean isEagerlyInitialized(Class<? extends Initializer<?>> r100) {
        return this.mDiscovered.contains(r100);
    }

    private <T> T doInitialize(Class<? extends Initializer<?>> r100, Set<Class<?>> r101) {
        if (Trace.isEnabled() == false) goto L6;
        Trace.beginSection(r100.getSimpleName());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Trace.endSection();
        throw th;
    L6:
        if (r101.contains(r100) == true) goto L27;
        if (this.mInitialized.containsKey(r100) == true) goto L23;
        r101.add(r100);     // Catch: Throwable -> L28
        Initializer<?> r102 = r100.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L20
        List<Class<? extends Initializer<?>>> r103 = r102.dependencies();     // Catch: Throwable -> L20
        if (r103.isEmpty() == true) goto L18;
        Iterator<Class<? extends Initializer<?>>> r104 = r103.iterator();     // Catch: Throwable -> L20
    L14:
        if (r104.hasNext() == false) goto L18;
        Class<? extends Initializer<?>> r105 = r104.next();     // Catch: Throwable -> L20
        if (this.mInitialized.containsKey(r105) == true) goto L14;
        doInitialize(r105, r101);     // Catch: Throwable -> L20
    L18:
        T r106 = (T) r102.create(this.mContext);
        r101.remove(r100);     // Catch: Throwable -> L20
        this.mInitialized.put(r100, r106);     // Catch: Throwable -> L20
    L24:
        Trace.endSection();
        return r106;
    L20:
        th = move-exception;
        throw new StartupException(th);     // Catch: Throwable -> L28
    L23:
        r106 = (T) this.mInitialized.get(r100);
        goto L24
    L27:
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{r100.getName()}));     // Catch: Throwable -> L28
    }
}
