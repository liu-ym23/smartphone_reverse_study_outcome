package com.volcengine.tos.comm.common;

/* loaded from: classes3.dex */
public enum StorageClassType {
    STORAGE_CLASS_STANDARD("STANDARD"),
    STORAGE_CLASS_IA("IA"),
    STORAGE_CLASS_ARCHIVE_FR("ARCHIVE_FR"),
    STORAGE_CLASS_INTELLIGENT_TIERING("INTELLIGENT_TIERING"),
    STORAGE_CLASS_COLD_ARCHIVE("COLD_ARCHIVE"),
    STORAGE_CLASS_UNKNOWN("UNKNOWN");


    /* renamed from: a, reason: collision with root package name */
    public final String f4230a;

    StorageClassType(String str) {
        this.f4230a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4230a;
    }
}
