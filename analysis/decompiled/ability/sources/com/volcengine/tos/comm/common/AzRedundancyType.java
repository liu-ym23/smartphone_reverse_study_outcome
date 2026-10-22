package com.volcengine.tos.comm.common;

import androidx.core.os.EnvironmentCompat;

/* loaded from: classes3.dex */
public enum AzRedundancyType {
    /* JADX INFO: Fake field, exist only in values array */
    AZ_REDUNDANCY_SINGLE_AZ("single-az"),
    /* JADX INFO: Fake field, exist only in values array */
    AZ_REDUNDANCY_MULTI_AZ("multi-az"),
    /* JADX INFO: Fake field, exist only in values array */
    AZ_REDUNDANCY_UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN);


    /* renamed from: a, reason: collision with root package name */
    public final String f4220a;

    AzRedundancyType(String str) {
        this.f4220a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4220a;
    }
}
