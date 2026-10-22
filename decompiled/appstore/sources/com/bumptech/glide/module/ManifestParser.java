package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context r10) {
        this.context = r10;
    }

    private static GlideModule parseModule(String r10) {
        Class<?> r11 = Class.forName(r10);     // Catch: ClassNotFoundException -> L24
        Object r12 = null;
        r12 = r11.getDeclaredConstructor(null).newInstance(null);     // Catch: InvocationTargetException -> L6 NoSuchMethodException -> L8 IllegalAccessException -> L10 InstantiationException -> L12
    L19:
        if ((r12 instanceof GlideModule) == false) goto L23;
        return (GlideModule) r12;
    L23:
        throw new RuntimeException("Expected instanceof GlideModule, but found: " + r12);
    L10:
        e = move-exception;
        throwInstantiateGlideModuleException(r11, e);
    L12:
        e = move-exception;
        throwInstantiateGlideModuleException(r11, e);
    L8:
        e = move-exception;
        throwInstantiateGlideModuleException(r11, e);
    L6:
        e = move-exception;
        throwInstantiateGlideModuleException(r11, e);
    L24:
        e = move-exception;
        throw new IllegalArgumentException("Unable to find GlideModule implementation", e);
    }

    private static void throwInstantiateGlideModuleException(Class<?> r10, Exception r11) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + r10, r11);
    }

    public List<GlideModule> parse() {
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        Log.d(TAG, "Loading Glide modules");
    L5:
        ArrayList r10 = new ArrayList();
        ApplicationInfo r11 = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L11
        if (r11.metaData != null) goto L15;
        if (Log.isLoggable(TAG, 3) == false) goto L13;
        Log.d(TAG, "Got null app info metadata");     // Catch: PackageManager.NameNotFoundException -> L11
    L13:
        return r10;
    L15:
        if (Log.isLoggable(TAG, 2) == false) goto L17;
        Log.v(TAG, "Got app info metadata: " + r11.metaData);     // Catch: PackageManager.NameNotFoundException -> L11
    L17:
        Iterator<String> r12 = r11.metaData.keySet().iterator();     // Catch: PackageManager.NameNotFoundException -> L11
    L19:
        if (r12.hasNext() == false) goto L27;
        String r13 = r12.next();     // Catch: PackageManager.NameNotFoundException -> L11
        if (GLIDE_MODULE_VALUE.equals(r11.metaData.get(r13)) == false) goto L19;
        r10.add(parseModule(r13));     // Catch: PackageManager.NameNotFoundException -> L11
        if (Log.isLoggable(TAG, 3) == false) goto L19;
        Log.d(TAG, "Loaded Glide module: " + r13);     // Catch: PackageManager.NameNotFoundException -> L11
        goto L19
    L27:
        if (Log.isLoggable(TAG, 3) == false) goto L29;
        Log.d(TAG, "Finished loading Glide modules");
    L29:
        return r10;
    L11:
        e = move-exception;
        throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
    }
}
