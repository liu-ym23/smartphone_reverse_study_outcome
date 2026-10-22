package com.blankj.utilcode.util;

import android.content.res.Resources;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;

/* loaded from: classes.dex */
public final class d {
    public static int a() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", UxipConstants.f30662a);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int b() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", UxipConstants.f30662a));
    }
}
