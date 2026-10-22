package com.android.server.display.plugin;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.os.SystemServerClassLoaderFactory;
import com.android.server.display.feature.DisplayManagerFlags;
import dalvik.system.PathClassLoader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PluginManager {
    private static final String PROVIDER_IMPL_CLASS = "com.android.server.display.plugin.PluginsProviderImpl";
    private static final String TAG = "PluginManager";
    private final PluginStorage mPluginStorage;
    private final List<Plugin> mPlugins;

    static class Injector {
        Injector() {
        }

        Set<PluginType<?>> getEnabledPluginTypes(DisplayManagerFlags flags) {
            Set<PluginType<?>> enabledTypes = new HashSet();
            if (flags.isHdrOverrideEnabled() == false) goto L5;
            enabledTypes.add(PluginType.HDR_BOOST_OVERRIDE);
        L5:
            return enabledTypes;
        }

        PluginStorage getPluginStorage(Set<PluginType<?>> enabledTypes) {
            return new PluginStorage(enabledTypes);
        }

        List<Plugin> loadPlugins(Context context, PluginStorage storage, Set<PluginType<?>> enabledTypes) {
            String providerJarPath = context.getString(R.string.config_usbContaminantActivity);
            Slog.d(PluginManager.TAG, "loading plugins from:" + providerJarPath);
            if (TextUtils.isEmpty(providerJarPath) == true) goto L5;
            PathClassLoader pathClassLoader = SystemServerClassLoaderFactory.getOrCreateClassLoader(providerJarPath, getClass().getClassLoader(), false);     // Catch: Throwable -> L9 ClassNotFoundException -> L11
            Class<? extends PluginsProvider> cp = pathClassLoader.loadClass(PluginManager.PROVIDER_IMPL_CLASS).asSubclass(PluginsProvider.class);     // Catch: Throwable -> L9 ClassNotFoundException -> L11
            PluginsProvider provider = (PluginsProvider) cp.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L9 ClassNotFoundException -> L11
            return provider.getPlugins(context, storage, enabledTypes);
        L11:
            e = move-exception;
            Slog.e(PluginManager.TAG, "loading failed: com.android.server.display.plugin.PluginsProviderImpl is not found in" + providerJarPath, e);
        L16:
            return List.of();
        L9:
            e = move-exception;
            Slog.e(PluginManager.TAG, "Class instantiation failed", e);
            goto L16
        L5:
            return List.of();
        }
    }

    public interface PluginChangeListener<T> {
        void onChanged(T r1);
    }

    public PluginManager(Context context, DisplayManagerFlags flags) {
        this(context, flags, new Injector());
    }

    PluginManager(Context context, DisplayManagerFlags flags, Injector injector) {
        Set<PluginType<?>> enabledTypes = injector.getEnabledPluginTypes(flags);
        this.mPluginStorage = injector.getPluginStorage(enabledTypes);
        if (flags.isPluginManagerEnabled() == false) goto L5;
        this.mPlugins = Collections.unmodifiableList(injector.loadPlugins(context, this.mPluginStorage, enabledTypes));
        Slog.d(TAG, "loaded Plugins:" + this.mPlugins);
        return;
    L5:
        this.mPlugins = List.of();
        Slog.d(TAG, "PluginManager disabled");
    }

    public void onBootCompleted() {
        this.mPlugins.forEach(new PluginManager$$ExternalSyntheticLambda0());
    }

    public <T> void subscribe(PluginType<T> type, String uniqueDisplayId, PluginChangeListener<T> listener) {
        this.mPluginStorage.addListener(type, uniqueDisplayId, listener);
    }

    public <T> void unsubscribe(PluginType<T> type, String uniqueDisplayId, PluginChangeListener<T> listener) {
        this.mPluginStorage.removeListener(type, uniqueDisplayId, listener);
    }

    public void dump(PrintWriter pw) {
        pw.println("PluginManager:");
        this.mPluginStorage.dump(pw);
        Iterator<Plugin> r0 = this.mPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Plugin plugin = r0.next();
        plugin.dump(pw);
        goto L4
    }
}
