package com.volcengine.tos.comm.common;

import androidx.core.os.EnvironmentCompat;

/* loaded from: classes3.dex */
public enum ProtocolType {
    /* JADX INFO: Fake field, exist only in values array */
    PROTOCOL_HTTP("http"),
    /* JADX INFO: Fake field, exist only in values array */
    PROTOCOL_HTTPS("https"),
    /* JADX INFO: Fake field, exist only in values array */
    PROTOCOL_UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN);


    /* renamed from: a, reason: collision with root package name */
    public final String f4226a;

    ProtocolType(String str) {
        this.f4226a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4226a;
    }
}
