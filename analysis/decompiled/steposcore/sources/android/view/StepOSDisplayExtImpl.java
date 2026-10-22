package android.view;

import android.app.WindowModeHelper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;

/* loaded from: classes.dex */
public class StepOSDisplayExtImpl implements IStepOSDisplayExt {
    private Display mHost;
    private final DisplayInfo mOverrideDisplayInfo = new DisplayInfo();

    public void onAttach(Display host) {
        this.mHost = host;
    }

    public void onDetach() {
        this.mHost = null;
    }

    public boolean displayShouldReportMaxBounds(Resources resources) {
        return WindowModeHelper.needInjectDisplayInfo(resources, false);
    }

    public DisplayInfo computeDisplayForWindowMode(DisplayInfo current, Resources resources, boolean checkPermissions) {
        Rect bound;
        if (current == null || !WindowModeHelper.needInjectDisplayInfo(resources, checkPermissions)) {
            return current;
        }
        Configuration config = resources.getConfiguration();
        boolean magicWindow = config.isStepOSMagicWindow();
        if (magicWindow) {
            bound = config.windowConfiguration.getMaxBounds();
        } else {
            bound = config.windowConfiguration.getBounds();
        }
        if (bound == null || bound.isEmpty()) {
            return current;
        }
        this.mOverrideDisplayInfo.copyFrom(current);
        this.mOverrideDisplayInfo.displayCutout = DisplayCutout.NO_CUTOUT;
        this.mOverrideDisplayInfo.logicalWidth = bound.width();
        this.mOverrideDisplayInfo.logicalHeight = bound.height();
        this.mOverrideDisplayInfo.appWidth = this.mOverrideDisplayInfo.logicalWidth;
        this.mOverrideDisplayInfo.appHeight = this.mOverrideDisplayInfo.logicalHeight;
        if (magicWindow) {
            if (current.logicalWidth > current.logicalHeight && current.logicalWidth == this.mOverrideDisplayInfo.logicalWidth) {
                this.mOverrideDisplayInfo.rotation = 1;
            } else {
                this.mOverrideDisplayInfo.rotation = 0;
            }
        }
        return this.mOverrideDisplayInfo;
    }
}
