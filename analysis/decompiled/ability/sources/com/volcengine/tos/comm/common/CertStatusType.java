package com.volcengine.tos.comm.common;

/* loaded from: classes3.dex */
public enum CertStatusType {
    /* JADX INFO: Fake field, exist only in values array */
    CERT_STATUS_BOUND("CertBound"),
    /* JADX INFO: Fake field, exist only in values array */
    CERT_STATUS_UNBOUND("CertUnbound"),
    /* JADX INFO: Fake field, exist only in values array */
    CERT_STATUS_EXPIRED("CertExpired"),
    /* JADX INFO: Fake field, exist only in values array */
    CERT_STATUS_UNKNOWN("Unknown");


    /* renamed from: a, reason: collision with root package name */
    public final String f4222a;

    CertStatusType(String str) {
        this.f4222a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4222a;
    }
}
