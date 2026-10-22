package android.content.res.stepostheme;

import android.content.res.AssetManager;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class StepOSAssetManagerExtImpl implements IStepOSAssetManagerExt {
    private static final String TAG = "StepOSAssetManagerExt";

    public Object onOverlayStepOSThemeColor(AssetManager assetManager, int resId, TypedValue outValue, String resPackageName, String resFullName) {
        ColorInfo colorInfo;
        if (resId == 0) {
            return null;
        }
        try {
            StepOSThemeResource steposThemeResource = StepOSThemeResourceManager.getInstance().getStepOSThemeResource(resPackageName);
            if (steposThemeResource == null) {
                steposThemeResource = new StepOSThemeResource(resPackageName);
                StepOSThemeResourceManager.getInstance().setStepOSThemeResource(resPackageName, steposThemeResource);
            }
            if (steposThemeResource != null && resFullName != null) {
                int index = resFullName.indexOf(47);
                String resName = resFullName.substring(index + 1);
                IStepOSThemeUtilsExt themeUtils = IStepOSThemeUtilsExt.get();
                int resType = themeUtils != null ? themeUtils.getResType(resPackageName) : 0;
                if (index > 4 && "attr".equals(resFullName.substring(index - 4, index))) {
                    colorInfo = steposThemeResource.getThemeAttrColor(resName, resType);
                } else {
                    colorInfo = steposThemeResource.getThemeColor(resName, resType);
                }
                if (colorInfo != null && outValue != null) {
                    outValue.data = (int) colorInfo.getColor();
                }
                return colorInfo;
            }
        } catch (Exception e) {
            StepOSLogUtil.e("overlayStepOSThemeColor exception: " + e.getMessage());
        }
        return null;
    }

    public boolean onOverlayStepOSThemeColorForTheme(AssetManager assetManager, int resId, TypedValue outValue, String resPackageName, String resFullName) {
        Object colorInfo = onOverlayStepOSThemeColor(assetManager, resId, outValue, resPackageName, resFullName);
        return colorInfo != null;
    }
}
