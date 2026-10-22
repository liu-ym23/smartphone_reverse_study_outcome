package androidx.camera.core.impl.utils;

import androidx.camera.core.resolutionselector.ResolutionSelector;

/* JADX INFO: loaded from: classes2.dex */
public class ResolutionSelectorUtil {
    private ResolutionSelectorUtil() {
    }

    public static ResolutionSelector overrideResolutionSelectors(ResolutionSelector r100, ResolutionSelector r101) {
        if (r101 != null) goto L4;
        return r100;
    L4:
        if (r100 != null) goto L6;
        return r101;
    L6:
        ResolutionSelector.Builder r102 = ResolutionSelector.Builder.fromResolutionSelector(r100);
        if (r101.getAspectRatioStrategy() == null) goto L10;
        r102.setAspectRatioStrategy(r101.getAspectRatioStrategy());
    L10:
        if (r101.getResolutionStrategy() == null) goto L13;
        r102.setResolutionStrategy(r101.getResolutionStrategy());
    L13:
        if (r101.getResolutionFilter() == null) goto L16;
        r102.setResolutionFilter(r101.getResolutionFilter());
    L16:
        if (r101.getAllowedResolutionMode() == 0) goto L19;
        r102.setAllowedResolutionMode(r101.getAllowedResolutionMode());
    L19:
        return r102.build();
    }
}
