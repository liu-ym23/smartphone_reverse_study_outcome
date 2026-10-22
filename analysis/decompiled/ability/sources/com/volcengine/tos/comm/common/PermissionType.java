package com.volcengine.tos.comm.common;

import com.volcengine.tos.model.acl.ACLConst;

/* loaded from: classes3.dex */
public enum PermissionType {
    PERMISSION_READ(ACLConst.PERMISSION_TYPE_READ),
    PERMISSION_WRITE(ACLConst.PERMISSION_TYPE_WRITE),
    PERMISSION_READ_ACP(ACLConst.PERMISSION_TYPE_READ_ACP),
    PERMISSION_WRITE_ACP(ACLConst.PERMISSION_TYPE_WRITE_ACP),
    PERMISSION_FULL_CONTROL(ACLConst.PERMISSION_TYPE_FULL_CONTROL),
    PERMISSION_UNKNOWN("UNKNOWN");


    /* renamed from: a, reason: collision with root package name */
    public final String f4225a;

    PermissionType(String str) {
        this.f4225a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4225a;
    }
}
