package com.stepos.widget.menu;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuPopupSize;", "", "windowHeight", "", "shrinkToFit", "", "<init>", "(IZ)V", "getWindowHeight$StepOSWidget_release", "()I", "getShrinkToFit$StepOSWidget_release", "()Z", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSMenuPopupSize {
    private final boolean shrinkToFit;
    private final int windowHeight;

    public StepOSMenuPopupSize(int i10, boolean z10) {
        this.windowHeight = i10;
        this.shrinkToFit = z10;
    }

    /* renamed from: getShrinkToFit$StepOSWidget_release, reason: from getter */
    public final boolean getShrinkToFit() {
        return this.shrinkToFit;
    }

    /* renamed from: getWindowHeight$StepOSWidget_release, reason: from getter */
    public final int getWindowHeight() {
        return this.windowHeight;
    }
}
