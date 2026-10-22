package com.obric.autogui.common.api.space.status;

import com.obric.autogui.common.api.platform.display.DisplayAccessor;

/* JADX INFO: compiled from: SpaceStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface SpaceStatus {
    DisplayAccessor.Rotation getRotation();

    int getStatusBarAppearance();

    boolean isSecure();
}
