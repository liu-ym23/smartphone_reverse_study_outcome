package com.stepos.activeview.utils;

import android.content.Context;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ActiveClassLoader extends BaseDexClassLoader {
    private static final String[] USE_HOST_CLASS_LIST = {"com.stepos.activeview.views.IActiveView", "com.listener.activeview.stepos.OnEventListener", "com.listener.activeview.stepos.OnLoadDataListener", "com.listener.activeview.stepos.OnLoadImageListener", "com.listener.activeview.stepos.OnParallaxListener", "com.listener.activeview.stepos.OnLayerAniListener", "com.listener.activeview.stepos.OnUpdateListener", "com.listener.activeview.stepos.OnVersionListener", "com.utils.activeview.stepos.ImageCache", "com.listener.activeview.stepos.OnActiveViewUpgradeListener", "com.listener.activeview.stepos.OnOrientationAnimationListener", "com.listener.activeview.stepos.OnPrintTextAnimationListener"};
    private static Map<String, ActiveClassLoader> sJarClassLoaderCaches = new HashMap();

    public ActiveClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, new File(str2), str3, classLoader);
    }

    public static ActiveClassLoader createNewActiveLoader(Context context, String str) {
        synchronized (sJarClassLoaderCaches) {
            if (sJarClassLoaderCaches.containsKey(str)) {
                return sJarClassLoaderCaches.get(str);
            }
            try {
                ActiveClassLoader activeClassLoader = new ActiveClassLoader(str, context.getDir("dex", 0).getAbsolutePath(), null, context.getClassLoader());
                sJarClassLoaderCaches.put(str, activeClassLoader);
                return activeClassLoader;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static void deleteNewActiveLoader(String str) {
        synchronized (sJarClassLoaderCaches) {
            try {
                if (sJarClassLoaderCaches.containsKey(str)) {
                    sJarClassLoaderCaches.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z4) throws ClassNotFoundException {
        Class<?> clsFindClass;
        boolean z5 = false;
        for (String str2 : USE_HOST_CLASS_LIST) {
            if (str2.equals(str)) {
                z5 = true;
            }
        }
        if (z5) {
            clsFindClass = null;
        } else {
            try {
                clsFindClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return clsFindClass == null ? super.loadClass(str, z4) : clsFindClass;
    }
}
