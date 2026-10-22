package com.volcengine.tos.comm.common;

/* loaded from: classes3.dex */
public enum GranteeType {
    GRANTEE_GROUP("Group"),
    GRANTEE_USER("CanonicalUser"),
    GRANTEE_UNKNOWN("Unknown");


    /* renamed from: a, reason: collision with root package name */
    public final String f4223a;

    GranteeType(String str) {
        this.f4223a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4223a;
    }
}
