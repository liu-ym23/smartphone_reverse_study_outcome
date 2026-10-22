package android.content.res.stepostheme;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class StepOSThemeResourceManager {
    private static StepOSThemeResourceManager sInstance;
    private Map<String, StepOSThemeResource> mThemeResources = new HashMap();
    private int mThemeChanged = 0;

    private StepOSThemeResourceManager() {
    }

    public static synchronized StepOSThemeResourceManager getInstance() {
        if (sInstance == null) {
            sInstance = new StepOSThemeResourceManager();
        }
        return sInstance;
    }

    public StepOSThemeResource getStepOSThemeResource(String packageName) {
        return this.mThemeResources.get(packageName);
    }

    public void setStepOSThemeResource(String packageName, StepOSThemeResource resource) {
        this.mThemeResources.put(packageName, resource);
    }

    public void removeStepOSThemeResource(String packageName) {
        this.mThemeResources.remove(packageName);
    }

    public void clear() {
        this.mThemeResources.clear();
    }

    public int getThemeChanged() {
        return this.mThemeChanged;
    }

    public void setThemeChanged(int themeChanged) {
        this.mThemeChanged = themeChanged;
    }
}
