package android.content.res.stepostheme;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class StepOSComponentContextExtImpl implements IStepOSComponentContextExt {
    private static final String TAG = "StepOSComponentContext";
    private static final String THEME_META_DATA_KEY = "com.stepos.theme";
    private final Map<String, Resources> mResourcesCache = new HashMap();
    private final Map<String, ClassLoader> mClassLoaderCache = new HashMap();
    private final Map<String, Class<?>> mRClassCache = new HashMap();

    public Resources createResourcesFromApk(Context context, String apkPath) throws NoSuchMethodException, SecurityException {
        if (context == null || apkPath == null) {
            return null;
        }
        Resources cached = this.mResourcesCache.get(apkPath);
        if (cached != null) {
            return cached;
        }
        File apkFile = new File(apkPath);
        if (!apkFile.exists()) {
            Log.w(TAG, "APK file not found: " + apkPath);
            return null;
        }
        try {
            AssetManager assets = (AssetManager) AssetManager.class.newInstance();
            Method addAssetPath = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            addAssetPath.setAccessible(true);
            int cookie = ((Integer) addAssetPath.invoke(assets, apkPath)).intValue();
            if (cookie == 0) {
                Log.w(TAG, "Failed to add asset path: " + apkPath);
                return null;
            }
            Resources baseRes = context.getResources();
            Resources resources = new Resources(assets, baseRes.getDisplayMetrics(), baseRes.getConfiguration());
            this.mResourcesCache.put(apkPath, resources);
            return resources;
        } catch (Exception e) {
            Log.w(TAG, "Failed to create resources from APK: " + e.getMessage());
            return null;
        }
    }

    public Drawable getDrawableFromPackage(Context context, String packageName, String drawableName) {
        Resources res;
        int resId;
        if (context == null || packageName == null || drawableName == null) {
            return null;
        }
        try {
            String apkPath = getThemeApkPath(context, packageName);
            if (apkPath != null && (res = createResourcesFromApk(context, apkPath)) != null && (resId = getResourceId(packageName, "drawable", drawableName)) != 0) {
                return res.getDrawable(resId, null);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to get drawable from package: " + e.getMessage());
        }
        return null;
    }

    public int getColorFromPackage(Context context, String packageName, String colorName, int defaultColor) {
        Resources res;
        int resId;
        if (context == null || packageName == null || colorName == null) {
            return defaultColor;
        }
        try {
            String apkPath = getThemeApkPath(context, packageName);
            if (apkPath != null && (res = createResourcesFromApk(context, apkPath)) != null && (resId = getResourceId(packageName, "color", colorName)) != 0) {
                return res.getColor(resId, null);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to get color from package: " + e.getMessage());
        }
        return defaultColor;
    }

    public String getStringFromPackage(Context context, String packageName, String stringName) {
        Resources res;
        int resId;
        if (context == null || packageName == null || stringName == null) {
            return null;
        }
        try {
            String apkPath = getThemeApkPath(context, packageName);
            if (apkPath != null && (res = createResourcesFromApk(context, apkPath)) != null && (resId = getResourceId(packageName, "string", stringName)) != 0) {
                return res.getString(resId);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to get string from package: " + e.getMessage());
        }
        return null;
    }

    public ClassLoader createClassLoader(String apkPath, ClassLoader parentLoader) {
        if (apkPath == null) {
            return null;
        }
        ClassLoader cached = this.mClassLoaderCache.get(apkPath);
        if (cached != null) {
            return cached;
        }
        File apkFile = new File(apkPath);
        if (!apkFile.exists()) {
            return null;
        }
        try {
            File cacheDir = new File(apkFile.getParent(), "dex_cache");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            ClassLoader loader = new DexClassLoader(apkPath, cacheDir.getAbsolutePath(), null, parentLoader != null ? parentLoader : getClass().getClassLoader());
            this.mClassLoaderCache.put(apkPath, loader);
            return loader;
        } catch (Exception e) {
            Log.w(TAG, "Failed to create class loader: " + e.getMessage());
            return null;
        }
    }

    public Class<?> getRClass(String packageName) throws ClassNotFoundException {
        if (packageName == null) {
            return null;
        }
        Class<?> cached = this.mRClassCache.get(packageName);
        if (cached != null) {
            return cached;
        }
        try {
            String rClassName = packageName + ".R";
            ClassLoader loader = this.mClassLoaderCache.get(packageName);
            if (loader != null) {
                Class<?> rClass = loader.loadClass(rClassName);
                this.mRClassCache.put(packageName, rClass);
                return rClass;
            }
        } catch (ClassNotFoundException e) {
            Log.w(TAG, "R class not found for package: " + packageName);
        }
        return null;
    }

    public int getResourceId(String packageName, String type, String name) throws NoSuchFieldException {
        Class<?> rClass;
        if (packageName == null || type == null || name == null) {
            return 0;
        }
        try {
            rClass = getRClass(packageName);
        } catch (Exception e) {
        }
        if (rClass == null) {
            return 0;
        }
        Class<?>[] innerClasses = rClass.getDeclaredClasses();
        for (Class<?> innerClass : innerClasses) {
            if (innerClass.getSimpleName().equals(type)) {
                Field field = innerClass.getDeclaredField(name);
                field.setAccessible(true);
                return field.getInt(null);
            }
        }
        return 0;
    }

    public boolean isThemePackage(Context context, String packageName) throws PackageManager.NameNotFoundException {
        if (context == null || packageName == null) {
            return false;
        }
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(packageName, 128);
            if (appInfo.metaData != null) {
                return appInfo.metaData.containsKey(THEME_META_DATA_KEY);
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return false;
    }

    public String getThemeApkPath(Context context, String packageName) throws PackageManager.NameNotFoundException {
        if (context == null || packageName == null) {
            return null;
        }
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(packageName, 0);
            return appInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public void clearCachedResources(String packageName) {
        if (packageName == null) {
            return;
        }
        this.mResourcesCache.remove(packageName);
        this.mClassLoaderCache.remove(packageName);
        this.mRClassCache.remove(packageName);
        StepOSLogUtil.d("Cleared cached resources for: " + packageName);
    }
}
