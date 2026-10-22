package android.content.res.stepostheme;

import android.content.res.Resources;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class StepOSResourcesExtImpl implements IStepOSResourcesExt {
    private static final WeakHashMap<Resources, ThemeState> sStateMap = new WeakHashMap<>();

    private static class ThemeState {
        boolean isSystem;
        Object steposThemeResource;

        private ThemeState() {
        }
    }

    private ThemeState getOrCreateState(Resources res) {
        ThemeState state;
        synchronized (sStateMap) {
            state = sStateMap.get(res);
            if (state == null) {
                state = new ThemeState();
                sStateMap.put(res, state);
            }
        }
        return state;
    }

    public void onInitSystemResources(Resources res) {
        ThemeState state = getOrCreateState(res);
        state.isSystem = true;
        IStepOSThemeResourceExt themeRes = IStepOSThemeResourceExt.get();
        if (themeRes != null) {
            state.steposThemeResource = themeRes.createStepOSThemeResource("android");
        }
    }

    public Integer onGetThemeColor(Resources res, int id) throws Resources.NotFoundException {
        ThemeState state;
        synchronized (sStateMap) {
            state = sStateMap.get(res);
        }
        if (state == null || state.steposThemeResource == null) {
            return null;
        }
        try {
            String colorName = res.getResourceEntryName(id);
            String packageName = res.getResourcePackageName(id);
            if (colorName == null) {
                return null;
            }
            IStepOSThemeUtilsExt themeUtils = IStepOSThemeUtilsExt.get();
            IStepOSThemeResourceExt themeRes = IStepOSThemeResourceExt.get();
            if (themeUtils == null || themeRes == null) {
                return null;
            }
            int resType = themeUtils.getResType(packageName);
            Object colorInfo = themeRes.getThemeColor(state.steposThemeResource, colorName, resType);
            if (colorInfo == null) {
                return null;
            }
            return Integer.valueOf((int) themeRes.getColorValue(colorInfo));
        } catch (Exception e) {
            return null;
        }
    }

    public void onSetThemeResource(Resources res, String packageName) {
        ThemeState state = getOrCreateState(res);
        IStepOSThemeResourceExt themeRes = IStepOSThemeResourceExt.get();
        if (themeRes != null) {
            state.steposThemeResource = themeRes.createStepOSThemeResource(packageName);
        }
    }

    public Object onGetThemeResource(Resources res) {
        ThemeState state;
        synchronized (sStateMap) {
            state = sStateMap.get(res);
        }
        if (state != null) {
            return state.steposThemeResource;
        }
        return null;
    }
}
