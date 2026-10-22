package com.volcengine.tos.comm.common;

/* loaded from: classes3.dex */
public enum StorageClassInheritDirectiveType {
    /* JADX INFO: Fake field, exist only in values array */
    STORAGE_CLASS_ID_DESTINATION_BUCKET("DESTINATION_BUCKET"),
    /* JADX INFO: Fake field, exist only in values array */
    STORAGE_CLASS_ID_SOURCE_OBJECT("SOURCE_OBJECT"),
    /* JADX INFO: Fake field, exist only in values array */
    STORAGE_CLASS_ID_UNKNOWN("UNKNOWN");


    /* renamed from: a, reason: collision with root package name */
    public final String f4229a;

    StorageClassInheritDirectiveType(String str) {
        this.f4229a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4229a;
    }
}
