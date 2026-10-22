package com.obric.autogui.common.api.space;

import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.space.status.SpaceStatus;

/* JADX INFO: compiled from: BaseDisplayOperatingSpace.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BaseDisplayOperatingSpace$mDisplayStatus$1 implements SpaceStatus {
    private boolean isSecure;
    private int statusBarAppearance;
    final /* synthetic */ BaseDisplayOperatingSpace this$0;

    BaseDisplayOperatingSpace$mDisplayStatus$1(BaseDisplayOperatingSpace r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.autogui.common.api.space.status.SpaceStatus
    public boolean isSecure() {
        return this.isSecure;
    }

    public void setSecure(boolean r1) {
        this.isSecure = r1;
    }

    @Override // com.obric.autogui.common.api.space.status.SpaceStatus
    public int getStatusBarAppearance() {
        return this.statusBarAppearance;
    }

    public void setStatusBarAppearance(int r1) {
        this.statusBarAppearance = r1;
    }

    @Override // com.obric.autogui.common.api.space.status.SpaceStatus
    public DisplayAccessor.Rotation getRotation() {
        return this.this$0.getDisplayAccessor().getRotation();
    }
}
