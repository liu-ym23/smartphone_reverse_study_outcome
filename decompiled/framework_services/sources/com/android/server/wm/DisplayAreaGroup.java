package com.android.server.wm;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class DisplayAreaGroup extends RootDisplayArea {
    DisplayAreaGroup(WindowManagerService wms, String name, int featureId) {
        super(wms, name, featureId);
    }

    @Override // com.android.server.wm.RootDisplayArea
    boolean isOrientationDifferentFromDisplay() {
        return isOrientationDifferentFromDisplay(getBounds());
    }

    private boolean isOrientationDifferentFromDisplay(Rect bounds) {
        if (this.mDisplayContent != null) goto L5;
        return false;
    L5:
        Rect displayBounds = this.mDisplayContent.getBounds();
        if (bounds.width() >= bounds.height()) goto L8;
        boolean r2 = true;
    L10:
        if (displayBounds.width() >= displayBounds.height()) goto L12;
        boolean r3 = true;
    L13:
        if (r2 != r3) goto L15;
        return false;
    L15:
        return true;
    L12:
        r3 = false;
        goto L13
    L8:
        r2 = false;
        goto L10
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    int getOrientation(int candidate) {
        int orientation = super.getOrientation(candidate);
        if (isOrientationDifferentFromDisplay() == false) goto L6;
        return ActivityInfo.reverseOrientation(orientation);
    L6:
        return orientation;
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.ConfigurationContainer
    void resolveOverrideConfiguration(Configuration newParentConfiguration) {
        super.resolveOverrideConfiguration(newParentConfiguration);
        Configuration resolvedConfig = getResolvedOverrideConfiguration();
        if (resolvedConfig.orientation == 0) goto L5;
        return;
    L5:
        Rect overrideBounds = resolvedConfig.windowConfiguration.getBounds();
        if (overrideBounds.isEmpty() == false) goto L8;
        Rect overrideBounds2 = newParentConfiguration.windowConfiguration.getBounds();
    L10:
        if (isOrientationDifferentFromDisplay(overrideBounds2) == true) goto L12;
        return;
    L12:
        if (newParentConfiguration.orientation != 1) goto L15;
        resolvedConfig.orientation = 2;
        return;
    L15:
        if (newParentConfiguration.orientation != 2) goto L20;
        resolvedConfig.orientation = 1;
        return;
    L20:
        return;
    L8:
        overrideBounds2 = overrideBounds;
        goto L10
    }
}
