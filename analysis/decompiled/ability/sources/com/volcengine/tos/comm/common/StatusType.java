package com.volcengine.tos.comm.common;

/* loaded from: classes3.dex */
public enum StatusType {
    /* JADX INFO: Fake field, exist only in values array */
    STATUS_ENABLED("Enabled"),
    /* JADX INFO: Fake field, exist only in values array */
    STATUS_DISABLED("Disabled"),
    /* JADX INFO: Fake field, exist only in values array */
    STATUS_UNKNOWN("Unknown");


    /* renamed from: a, reason: collision with root package name */
    public final String f4228a;

    StatusType(String str) {
        this.f4228a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4228a;
    }
}
