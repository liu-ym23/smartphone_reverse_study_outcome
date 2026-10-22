package com.obric.autogui.agents.vlm.models.omni;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;

/* JADX INFO: compiled from: NotifyOptToggle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f28422a = null;

    static {
        f28422a = new k();
    }

    private k() {
    }

    public final boolean a(String r1) {
        d.h.b.o.e(r1, ObricMemoryConstants.KEY_SESSION_ID);
        if (com.obric.autogui.common.a.d.f28974a.c() == true) goto L5;
    L7:
        return false;
    L5:
        if (t.f28523a.a(r1) == null) goto L7;
        return true;
    }
}
