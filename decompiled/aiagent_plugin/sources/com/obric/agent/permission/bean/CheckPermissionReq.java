package com.obric.agent.permission.bean;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: CheckPermissionReq.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckPermissionReq {
    private final String appletId;
    private final List<Permission> permissions;

    public static /* synthetic */ CheckPermissionReq copy$default(CheckPermissionReq r1, String r2, List r3, int r4, Object r5) {
        List<Permission> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.appletId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.permissions;
    L9:
        return r1.copy(r2, r6);
    }

    public final String component1() {
        return this.appletId;
    }

    public final List<Permission> component2() {
        return this.permissions;
    }

    public final CheckPermissionReq copy(String r2, List<Permission> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r2, IFlowAppIntentIDL.PARAM_APPLET_ID);
        o.e(r1, "permissions");
        return new CheckPermissionReq(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CheckPermissionReq.class) == true) goto L8;
        return false;
    L8:
        CheckPermissionReq r6 = (CheckPermissionReq) ZeusTransformUtils.preCheckCast(r5, CheckPermissionReq.class, "com.obric.aiagent.plugin");
        if (o.a(this.appletId, r6.appletId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.permissions, r6.permissions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.appletId.hashCode() * 31) + this.permissions.hashCode();
    }

    public String toString() {
        return "CheckPermissionReq(appletId=" + this.appletId + ", permissions=" + this.permissions + ')';
    }

    public CheckPermissionReq(String r3, List<Permission> r4) {
        List<Permission> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, IFlowAppIntentIDL.PARAM_APPLET_ID);
        o.e(r5, "permissions");
        this.appletId = r3;
        this.permissions = r5;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final List<Permission> getPermissions() {
        return this.permissions;
    }
}
