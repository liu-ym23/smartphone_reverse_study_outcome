package com.stepos.widget.menu;

import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\nJ=\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0012J=\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuPopupLayout;", "", "<init>", "()V", "resolvePopupSize", "Lcom/stepos/widget/menu/StepOSMenuPopupSize;", "contentHeight", "", "menuMaxHeight", "visibleHeight", "resolvePopupSize$StepOSWidget_release", "extraDropDownYOffToKeepFullHeight", "visibleTop", "visibleBottom", "anchorScreenY", "anchorHeight", "popupHeight", "yoff", "extraDropDownYOffToKeepFullHeight$StepOSWidget_release", "extraOverlapYOffToKeepFullHeight", "extraOverlapYOffToKeepFullHeight$StepOSWidget_release", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSMenuPopupLayout {
    public static final StepOSMenuPopupLayout INSTANCE = new StepOSMenuPopupLayout();

    private StepOSMenuPopupLayout() {
    }

    public final int extraDropDownYOffToKeepFullHeight$StepOSWidget_release(int visibleTop, int visibleBottom, int anchorScreenY, int anchorHeight, int popupHeight, int yoff) {
        int i10 = anchorHeight + anchorScreenY + yoff;
        int i11 = visibleBottom - i10;
        if (i11 >= popupHeight) {
            return 0;
        }
        int i12 = anchorScreenY + yoff;
        int i13 = i12 - popupHeight;
        int i14 = i12 - visibleTop;
        if (i14 < popupHeight && i14 <= i11) {
            i13 = i10;
        }
        return C5685n.n(i13, visibleTop, C5685n.f(visibleBottom - popupHeight, visibleTop)) - i10;
    }

    public final int extraOverlapYOffToKeepFullHeight$StepOSWidget_release(int visibleTop, int visibleBottom, int anchorScreenY, int anchorHeight, int popupHeight, int yoff) {
        int i10 = anchorScreenY + yoff;
        int i11 = visibleBottom - i10;
        if (i11 >= popupHeight) {
            return 0;
        }
        int i12 = anchorScreenY + anchorHeight + yoff;
        int i13 = i12 - popupHeight;
        int i14 = i12 - visibleTop;
        if (i14 < popupHeight && i14 <= i11) {
            i13 = i10;
        }
        return C5685n.n(i13, visibleTop, C5685n.f(visibleBottom - popupHeight, visibleTop)) - i10;
    }

    public final StepOSMenuPopupSize resolvePopupSize$StepOSWidget_release(int contentHeight, int menuMaxHeight, int visibleHeight) {
        int iF = C5685n.f(visibleHeight, 0);
        boolean z10 = (contentHeight > iF) || (menuMaxHeight > 0 && contentHeight > menuMaxHeight);
        if (z10) {
            contentHeight = menuMaxHeight > 0 ? Math.min(menuMaxHeight, Math.min(contentHeight, iF)) : Math.min(contentHeight, iF);
        }
        return new StepOSMenuPopupSize(contentHeight, z10);
    }
}
