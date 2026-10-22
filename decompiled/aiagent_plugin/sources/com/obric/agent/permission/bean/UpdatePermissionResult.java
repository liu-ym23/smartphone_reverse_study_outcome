package com.obric.agent.permission.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UpdatePermissionResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UpdatePermissionResult {
    private final boolean success;

    public static /* synthetic */ UpdatePermissionResult copy$default(UpdatePermissionResult r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.success;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.success;
    }

    public final UpdatePermissionResult copy(boolean r1) {
        return new UpdatePermissionResult(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, UpdatePermissionResult.class) == true) goto L8;
        return false;
    L8:
        UpdatePermissionResult r6 = (UpdatePermissionResult) ZeusTransformUtils.preCheckCast(r5, UpdatePermissionResult.class, "com.obric.aiagent.plugin");
        if (this.success == r6.success) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Boolean.hashCode(this.success);
    }

    public String toString() {
        return "UpdatePermissionResult(success=" + this.success + ')';
    }

    public UpdatePermissionResult(boolean r1) {
        this.success = r1;
    }

    public final boolean getSuccess() {
        return this.success;
    }
}
