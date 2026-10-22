package android.content.res.stepostheme;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StepOSThemeResourceImpl implements IStepOSThemeResourceExt {
    public Object createStepOSThemeResource(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            return null;
        }
        StepOSThemeResource themeResource = StepOSThemeResourceManager.getInstance().getStepOSThemeResource(packageName);
        if (themeResource == null) {
            StepOSThemeResource themeResource2 = new StepOSThemeResource(packageName);
            StepOSThemeResourceManager.getInstance().setStepOSThemeResource(packageName, themeResource2);
            return themeResource2;
        }
        return themeResource;
    }

    public void resetThemeResource(Object themeResource) {
        if (themeResource instanceof StepOSThemeResource) {
            ((StepOSThemeResource) themeResource).reset();
        }
    }

    public void loadThemeResource(Object themeResource) {
        if (themeResource instanceof StepOSThemeResource) {
            ((StepOSThemeResource) themeResource).load();
        }
    }

    public InputStream getThemeFileStream(Object themeResource, String fileName, int resType, TypedValue value) {
        if (themeResource instanceof StepOSThemeResource) {
            return ((StepOSThemeResource) themeResource).getThemeFileStream(fileName, resType, value);
        }
        return null;
    }

    public Object getThemeColor(Object themeResource, String colorName, int resType) {
        if (themeResource instanceof StepOSThemeResource) {
            return ((StepOSThemeResource) themeResource).getThemeColor(colorName, resType);
        }
        return null;
    }

    public Object getThemeAttrColor(Object themeResource, String colorName, int resType) {
        if (themeResource instanceof StepOSThemeResource) {
            return ((StepOSThemeResource) themeResource).getThemeAttrColor(colorName, resType);
        }
        return null;
    }

    public long getColorValue(Object colorInfo) {
        if (colorInfo instanceof ColorInfo) {
            return ((ColorInfo) colorInfo).getColor();
        }
        return 0L;
    }

    public InputStream get3rdPartThemeIcon(String resPath) {
        return StepOSThemeResource.get3rdPartThemeIcon(resPath);
    }

    public InputStream get3rdPartThemeIconExceptStepOSStyleIcon(String resPath) {
        return StepOSThemeResource.get3rdPartThemeIconExceptStepOSStyleIcon(resPath);
    }

    public InputStream getStepOSStyleIcon(String resPath) {
        return StepOSThemeResource.getStepOSStyleIcon(resPath);
    }

    public InputStream getStepOSStyleIconNight(String resPath) {
        return StepOSThemeResource.getStepOSStyleIconNight(resPath);
    }

    public InputStream getCloudStepOSStyleIcon(String resPath) {
        return StepOSThemeResource.getCloudStepOSStyleIcon(resPath);
    }

    public InputStream getCloudStepOSStyleIconNight(String resPath) {
        return StepOSThemeResource.getCloudStepOSStyleIconNight(resPath);
    }

    public int get3rdPartThemeIconPathType(String resPath) {
        return StepOSThemeResource.get3rdPartThemeIconPathType(resPath);
    }

    public Object getSystemMaskIcon(String iconName) {
        return StepOSThemeResource.getSystemMaskIcon(iconName);
    }

    public Drawable getDefaultPreviewIcon(Resources res, String iconName) {
        return StepOSThemeResource.getDefaultPreviewIcon(res, iconName);
    }

    public Drawable getCloudDefaultPreviewIcon(Resources res, String iconName) {
        return StepOSThemeResource.getCloudDefaultPreviewIcon(res, iconName);
    }
}
