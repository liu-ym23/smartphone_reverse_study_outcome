package com.stepos.launcher.assistant.quickstep;

import android.app.ActivityThread;
import android.app.LoadedApk;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent;
import com.stepos.launcher.client.libraries.ILauncherOverlayCallback;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public interface QuickstepObjectFactory {
    public static final String FACTORY_IMPL_CLASS = "com.stepos.launcher.quickstep.assistant.QuickstepObjectFactoryImpl";
    public static final String LAUNCHER_PACKAGE = "com.android.launcher3";
    public static final String TAG = "QuickstepObjectFactory";
    public static final int VERSION = 1;
    public static final Map<String, ClassLoader> sClassLoaders = new HashMap();
    public static final AtomicReference<Optional<QuickstepObjectFactory>> sCachedFactory = new AtomicReference<>();

    static QuickstepObjectFactory getFactory(Context context) throws IllegalAccessException, PackageManager.NameNotFoundException, ClassNotFoundException, IllegalArgumentException {
        AtomicReference<Optional<QuickstepObjectFactory>> atomicReference = sCachedFactory;
        Optional<QuickstepObjectFactory> optional = atomicReference.get();
        if (optional != null) {
            return optional.orElse(null);
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.android.launcher3", 0);
            ClassLoader classLoader = QuickstepObjectFactory.class.getClassLoader();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            LoadedApk.makePaths((ActivityThread) null, true, applicationInfo, arrayList, arrayList2);
            String str = File.pathSeparator;
            PathClassLoader pathClassLoader = new PathClassLoader(TextUtils.join(str, arrayList), TextUtils.join(str, arrayList2), classLoader);
            sClassLoaders.put(applicationInfo.packageName, pathClassLoader);
            Class<?> clsLoadClass = pathClassLoader.loadClass(FACTORY_IMPL_CLASS);
            int i10 = clsLoadClass.getDeclaredField("VERSION").getInt(null);
            if (i10 == 1) {
                QuickstepObjectFactory quickstepObjectFactory = (QuickstepObjectFactory) clsLoadClass.getDeclaredConstructor(null).newInstance(null);
                atomicReference.set(Optional.of(quickstepObjectFactory));
                return quickstepObjectFactory;
            }
            throw new IllegalArgumentException("Incompatible version, impl = " + i10 + ", curr = 1");
        } catch (Exception e10) {
            Log.w(TAG, "Error loading quickstep factory", e10);
            sCachedFactory.set(Optional.empty());
            return null;
        }
    }

    static void invalidateCache() {
        sCachedFactory.set(null);
    }

    Object createInteractionHandler(ILauncherOverlayCallback iLauncherOverlayCallback, Object obj);

    RemoteTransitionDelegate createRemoteTransitionDelegate(ScrollOverlayComponent scrollOverlayComponent);
}
