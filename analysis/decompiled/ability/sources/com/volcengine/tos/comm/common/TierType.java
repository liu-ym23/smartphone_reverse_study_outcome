package com.volcengine.tos.comm.common;

/* loaded from: classes3.dex */
public enum TierType {
    /* JADX INFO: Fake field, exist only in values array */
    TIER_STANDARD("Standard"),
    /* JADX INFO: Fake field, exist only in values array */
    TIER_EXPEDITED("Expedited"),
    /* JADX INFO: Fake field, exist only in values array */
    TIER_BULK("Bulk"),
    /* JADX INFO: Fake field, exist only in values array */
    RESTORE_TIER_TYPE_UNKNOWN("Unknown");


    /* renamed from: a, reason: collision with root package name */
    public final String f4231a;

    TierType(String str) {
        this.f4231a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4231a;
    }
}
