package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* loaded from: classes.dex */
public class S2 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f16352a = new File("/system/framework/amap.jar").exists();

    public static AssetManager a(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (f16352a) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, "/system/framework/amap.jar");
            } catch (Throwable unused) {
            }
        }
        return assets;
    }
}
