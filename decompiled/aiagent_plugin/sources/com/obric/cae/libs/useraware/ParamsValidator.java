package com.obric.cae.libs.useraware;

/* JADX INFO: loaded from: classes3.dex */
public final class ParamsValidator {
    public ParamsValidator() {
    }

    public static boolean validate(HarMonitorParams r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.stateVoteWindowSize > 0) goto L9;
        return false;
    L9:
        if (r2.accStateMonitorWindow > 0) goto L11;
    L15:
        return false;
    L11:
        if (r2.runningStateMonitorWindow <= 0) goto L15;
        return true;
    }
}
