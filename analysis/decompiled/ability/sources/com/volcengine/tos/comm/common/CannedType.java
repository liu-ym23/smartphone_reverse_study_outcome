package com.volcengine.tos.comm.common;

/* loaded from: classes3.dex */
public enum CannedType {
    CANNED_ALL_USERS("AllUsers"),
    CANNED_AUTHENTICATED_USERS("AuthenticatedUsers"),
    CANNED_LOG_DELIVERY("LogDelivery"),
    CANNED_UNKNOWN("Unknown");


    /* renamed from: a, reason: collision with root package name */
    public final String f4221a;

    CannedType(String str) {
        this.f4221a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4221a;
    }
}
