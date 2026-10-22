package com.volcengine.tos.comm.common;

/* loaded from: classes3.dex */
public enum MetadataDirectiveType {
    /* JADX INFO: Fake field, exist only in values array */
    METADATA_DIRECTIVE_COPY("COPY"),
    /* JADX INFO: Fake field, exist only in values array */
    METADATA_DIRECTIVE_REPLACE("REPLACE"),
    /* JADX INFO: Fake field, exist only in values array */
    METADATA_DIRECTIVE_UNKNOWN("UNKNOWN");


    /* renamed from: a, reason: collision with root package name */
    public final String f4224a;

    MetadataDirectiveType(String str) {
        this.f4224a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4224a;
    }
}
