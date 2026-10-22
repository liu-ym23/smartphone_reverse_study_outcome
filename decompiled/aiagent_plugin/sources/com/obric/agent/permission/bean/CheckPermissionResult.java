package com.obric.agent.permission.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: CheckPermissionResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckPermissionResult {
    private final List<Permission> permissions;

    public static /* synthetic */ CheckPermissionResult copy$default(CheckPermissionResult r1, List r2, int r3, Object r4) {
        List<Permission> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.permissions;
    L6:
        return r1.copy(r5);
    }

    public final List<Permission> component1() {
        return this.permissions;
    }

    public final CheckPermissionResult copy(List<Permission> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "permissions");
        return new CheckPermissionResult(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CheckPermissionResult.class) == true) goto L8;
        return false;
    L8:
        CheckPermissionResult r6 = (CheckPermissionResult) ZeusTransformUtils.preCheckCast(r5, CheckPermissionResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.permissions, r6.permissions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.permissions.hashCode();
    }

    public String toString() {
        return "CheckPermissionResult(permissions=" + this.permissions + ')';
    }

    public CheckPermissionResult(List<Permission> r3) {
        List<Permission> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "permissions");
        this.permissions = r4;
    }

    public final List<Permission> getPermissions() {
        return this.permissions;
    }
}
