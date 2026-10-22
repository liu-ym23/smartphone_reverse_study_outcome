package com.obric.autogui.agents.vlm.models.impl;

import com.obric.autogui.common.api.space.AOOperatingSpace;

/* JADX INFO: compiled from: StandardModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final boolean a(boolean r0, AOOperatingSpace.SpaceType r1) {
        if (r0 == true) goto L4;
    L6:
        return false;
    L4:
        if (r1 != AOOperatingSpace.SpaceType.VirtualDisplay) goto L6;
        return true;
    }

    public static final Boolean a(Boolean r2, Boolean r3) {
        if (d.h.b.o.a(r2, true) == true) goto L11;
        if (d.h.b.o.a(r3, true) == true) goto L11;
        if (r3 != null) goto L12;
        return r2;
    L12:
        return r3;
    L11:
        return true;
    }
}
