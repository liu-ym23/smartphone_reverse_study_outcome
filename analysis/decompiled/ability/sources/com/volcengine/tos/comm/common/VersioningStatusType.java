package com.volcengine.tos.comm.common;

/* loaded from: classes3.dex */
public enum VersioningStatusType {
    /* JADX INFO: Fake field, exist only in values array */
    VERSIONING_STATUS_ENABLED("Enabled"),
    /* JADX INFO: Fake field, exist only in values array */
    VERSIONING_STATUS_SUSPENDED("Suspended"),
    /* JADX INFO: Fake field, exist only in values array */
    VERSIONING_STATUS_UNKNOWN("Unknown");


    /* renamed from: a, reason: collision with root package name */
    public final String f4232a;

    VersioningStatusType(String str) {
        this.f4232a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4232a;
    }
}
