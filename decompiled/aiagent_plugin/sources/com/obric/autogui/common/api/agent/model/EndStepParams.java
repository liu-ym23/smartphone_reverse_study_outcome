package com.obric.autogui.common.api.agent.model;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: EndStepParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EndStepParams {
    private final String action;
    private final boolean modelSuccess;
    private final boolean openApp;

    public EndStepParams() {
        this(null, false, false, 7, null);
    }

    public EndStepParams(String r2, boolean r3, boolean r4) {
        o.e(r2, "action");
        this.action = r2;
        this.openApp = r3;
        this.modelSuccess = r4;
    }

    public /* synthetic */ EndStepParams(String r1, boolean r2, boolean r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = false;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = true;
    L11:
        this(r1, r2, r3);
    }

    public final String getAction() {
        return this.action;
    }

    public final boolean getOpenApp() {
        return this.openApp;
    }

    public final boolean getModelSuccess() {
        return this.modelSuccess;
    }
}
