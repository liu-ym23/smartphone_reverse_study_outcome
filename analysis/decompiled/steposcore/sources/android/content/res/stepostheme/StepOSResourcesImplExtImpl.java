package android.content.res.stepostheme;

import android.content.IntentExt;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.ResourcesImpl;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class StepOSResourcesImplExtImpl implements IStepOSResourcesImplExt {
    private static final String TAG = "StepOSResourcesImplExt";
    private static final WeakHashMap<ResourcesImpl, ThemeState> sStateMap = new WeakHashMap<>();
    private static final Object sThemeResourceSync = new Object();

    private static class ThemeState {
        boolean isStepOSThemeChange;
        boolean isSystemResource;
        int steposThemeChanges;
        StepOSThemeResource steposThemeResource;

        private ThemeState() {
        }
    }

    private ThemeState getOrCreateState(ResourcesImpl impl) {
        ThemeState state;
        synchronized (sStateMap) {
            state = sStateMap.get(impl);
            if (state == null) {
                state = new ThemeState();
                sStateMap.put(impl, state);
            }
        }
        return state;
    }

    private ThemeState getState(ResourcesImpl impl) {
        ThemeState themeState;
        synchronized (sStateMap) {
            themeState = sStateMap.get(impl);
        }
        return themeState;
    }

    public void onSetSystemStepOSThemeResource(ResourcesImpl impl) {
        onSetStepOSThemeResource(impl, "android");
        ThemeState state = getOrCreateState(impl);
        state.isSystemResource = true;
    }

    public void onInitStepOSThemeResource(ResourcesImpl impl) {
        ThemeState state = getOrCreateState(impl);
        state.steposThemeResource = null;
        state.isStepOSThemeChange = false;
    }

    public Object onGetStepOSThemeColor(ResourcesImpl impl, int id, String resPackageName, String resFullName) {
        if (id == 0) {
            return null;
        }
        try {
        } catch (Exception e) {
            StepOSLogUtil.e("getStepOSThemeColor exception: " + e.getMessage());
        }
        if ("android".equals(resPackageName)) {
            return null;
        }
        onSetStepOSThemeResource(impl, resPackageName);
        ThemeState state = getState(impl);
        if (state != null && state.steposThemeResource != null && resFullName != null) {
            int index = resFullName.indexOf(47);
            String resName = resFullName.substring(index + 1);
            IStepOSThemeUtilsExt themeUtils = IStepOSThemeUtilsExt.get();
            int resType = themeUtils != null ? themeUtils.getResType(resPackageName) : 0;
            if (index > 4 && "attr".equals(resFullName.substring(index - 4, index))) {
                return state.steposThemeResource.getThemeAttrColor(resName, resType);
            }
            return state.steposThemeResource.getThemeColor(resName, resType);
        }
        return null;
    }

    public Integer onGetThemeColorInt(ResourcesImpl impl, int id, String resPackageName, String resFullName) {
        if (id == 0) {
            return null;
        }
        Object colorInfo = onGetStepOSThemeColor(impl, id, resPackageName, resFullName);
        if (!(colorInfo instanceof ColorInfo)) {
            return null;
        }
        return Integer.valueOf((int) ((ColorInfo) colorInfo).getColor());
    }

    public int onOverlayStepOSThemeColor(ResourcesImpl impl, TypedValue value, String resPackageName, String resFullName) {
        Object colorInfo = onGetStepOSThemeColor(impl, value.resourceId, resPackageName, resFullName);
        if (colorInfo instanceof ColorInfo) {
            value.data = (int) ((ColorInfo) colorInfo).getColor();
        }
        return value.data;
    }

    public InputStream onOpenStepOSThemeRawResource(ResourcesImpl impl, int id, TypedValue value, String resPackageName) {
        if (value.string == null) {
            return null;
        }
        return onGetThemeFileStream(impl, id, value.string.toString(), value, resPackageName);
    }

    public void onSetStepOSThemeResource(ResourcesImpl impl, String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            return;
        }
        ThemeState state = getOrCreateState(impl);
        synchronized (sThemeResourceSync) {
            state.steposThemeResource = StepOSThemeResourceManager.getInstance().getStepOSThemeResource(packageName);
            if (state.steposThemeResource == null) {
                state.steposThemeResource = new StepOSThemeResource(packageName);
                StepOSThemeResourceManager.getInstance().setStepOSThemeResource(packageName, state.steposThemeResource);
            }
        }
    }

    public Object onGetStepOSThemeResource(ResourcesImpl impl) {
        ThemeState state = getState(impl);
        if (state != null) {
            return state.steposThemeResource;
        }
        return null;
    }

    public InputStream onGetThemeFileStream(ResourcesImpl impl, int resId, String fileName, TypedValue value, String resPackageName) {
        try {
            IStepOSThemeUtilsExt themeUtils = IStepOSThemeUtilsExt.get();
            int resType = themeUtils != null ? themeUtils.getResType(resPackageName) : 0;
            onSetStepOSThemeResource(impl, resPackageName);
            ThemeState state = getState(impl);
            if (state != null && state.steposThemeResource != null) {
                StepOSThemeResource themeResource = state.steposThemeResource;
                if (resType == 0 && themeResource.getPackageName() != null && !themeResource.getPackageName().equals(resPackageName)) {
                    onSetStepOSThemeResource(impl, resPackageName);
                    themeResource = state.steposThemeResource;
                }
                return themeResource.getThemeFileStream(fileName, resType, value);
            }
            return null;
        } catch (Exception e) {
            StepOSLogUtil.e("getThemeFileStream exception: " + e.getMessage());
            return null;
        }
    }

    public void onClearCachesByStepOSChange(ResourcesImpl impl) {
        ThemeState state = getState(impl);
        if (state == null) {
            return;
        }
        if (state.isStepOSThemeChange) {
            StepOSLogUtil.d("clearCachesByStepOSChange");
            IStepOSIconFilterExt iconFilter = IStepOSIconFilterExt.get();
            if (iconFilter != null) {
                iconFilter.cleanFilter();
            }
            state.isStepOSThemeChange = false;
        }
        boolean isStepOSFontChange = (state.steposThemeChanges & IntentExt.STEPOS_FLAG_PREVIEW_ON_KEYGUARD) != 0;
        if (isStepOSFontChange || state.isStepOSThemeChange) {
            StepOSLogUtil.d("clearCachesByStepOSChange for font");
            IStepOSFontsHelperExt fontsHelper = IStepOSFontsHelperExt.get();
            if (fontsHelper != null) {
                fontsHelper.cleanStepOSTypeface();
            }
        }
    }

    public void onIsStepOSThemeChange(ResourcesImpl impl, int changes, int themeChanged) {
        ThemeState state = getOrCreateState(impl);
        state.steposThemeChanges = changes;
        StepOSLogUtil.d("ResourcesImpl updateConfiguration, configChanges=" + changes);
        if ((65536 & changes) != 0) {
            int currentThemeChanged = StepOSThemeResourceManager.getInstance().getThemeChanged();
            if (themeChanged != currentThemeChanged || themeChanged == 0) {
                StepOSThemeResourceManager.getInstance().setThemeChanged(themeChanged);
            }
            if (state.steposThemeResource != null) {
                state.steposThemeResource.reset();
                if (!state.isSystemResource) {
                    state.steposThemeResource.load();
                }
                state.isStepOSThemeChange = true;
            }
        }
    }

    public Drawable onLoadStepOSThemeDrawable(Resources res, TypedValue value, int id, String file, String resName, String resPackageName) throws IOException {
        ResourcesImpl impl;
        try {
            impl = res.getImpl();
        } catch (Exception e) {
            e = e;
        }
        if (impl == null) {
            return null;
        }
        try {
        } catch (Exception e2) {
            e = e2;
        }
        if ("com.android.calendar:mipmap/ic_launcher_calendar".equals(resName)) {
            Drawable srcDrawable = StepOSThemeHelper.addDateToIcon((Drawable) null);
            return StepOSThemeHelper.makeThemeIcon(res, StepOSThemeHelper.addDayOfWeekToIcon(srcDrawable), (ApplicationInfo) null);
        }
        if (file != null && file.startsWith("res/drawable-night")) {
            return null;
        }
        try {
            InputStream steposThemeInputStream = onGetThemeFileStream(impl, id, file, value, resPackageName);
            if (steposThemeInputStream != null) {
                Drawable steposThemeDrawable = Drawable.createFromResourceStream(res, value, steposThemeInputStream, file, null);
                if (steposThemeDrawable == null && file != null && file.endsWith(".xml")) {
                    steposThemeInputStream.close();
                    steposThemeInputStream = onGetThemeFileStream(impl, id, file, value, resPackageName);
                    IStepOSThemeHelperExt themeHelper = IStepOSThemeHelperExt.get();
                    if (themeHelper != null && steposThemeInputStream != null) {
                        steposThemeDrawable = themeHelper.getVectorDrawable(res, steposThemeInputStream);
                    }
                }
                if (steposThemeInputStream != null) {
                    steposThemeInputStream.close();
                }
                return steposThemeDrawable;
            }
        } catch (Exception e3) {
            e = e3;
            StepOSLogUtil.e("loadStepOSThemeDrawable exception: " + e.getMessage());
            return null;
        }
        return null;
    }
}
