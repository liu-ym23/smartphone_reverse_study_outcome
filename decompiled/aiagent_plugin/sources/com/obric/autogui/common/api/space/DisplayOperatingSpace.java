package com.obric.autogui.common.api.space;

import android.view.Surface;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: DisplayOperatingSpace.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DisplayOperatingSpace extends AOOperatingSpace {

    /* JADX INFO: compiled from: DisplayOperatingSpace.kt */
    public static final class DefaultImpls {
        public static int getDisplayId(DisplayOperatingSpace r2) {
            return ((DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r2, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayAccessor().getDisplayId();
        }
    }

    Object configureSurface(Surface r1, d<? super x> r2);

    DisplayAccessor getDisplayAccessor();

    int getDisplayId();

    void onDisplaySecureStatusChanged(boolean r1);

    void onDisplayStatusBarAppearanceChanged(int r1);
}
