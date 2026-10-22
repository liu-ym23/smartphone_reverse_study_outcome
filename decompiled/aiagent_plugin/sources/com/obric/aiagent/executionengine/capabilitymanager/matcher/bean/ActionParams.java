package com.obric.aiagent.executionengine.capabilitymanager.matcher.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionParams.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActionParams {
    private final int appSelectType;

    public static /* synthetic */ ActionParams copy$default(ActionParams r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.appSelectType;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.appSelectType;
    }

    public final ActionParams copy(int r1) {
        return new ActionParams(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ActionParams.class) == true) goto L8;
        return false;
    L8:
        ActionParams r6 = (ActionParams) ZeusTransformUtils.preCheckCast(r5, ActionParams.class, "com.obric.aiagent.plugin");
        if (this.appSelectType == r6.appSelectType) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Integer.hashCode(this.appSelectType);
    }

    public String toString() {
        return "ActionParams(appSelectType=" + this.appSelectType + ')';
    }

    public ActionParams(int r1) {
        this.appSelectType = r1;
    }

    public final int getAppSelectType() {
        return this.appSelectType;
    }
}
