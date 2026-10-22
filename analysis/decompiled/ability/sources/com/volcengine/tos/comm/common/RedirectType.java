package com.volcengine.tos.comm.common;

/* loaded from: classes3.dex */
public enum RedirectType {
    /* JADX INFO: Fake field, exist only in values array */
    REDIRECT_MIRROR("Mirror"),
    /* JADX INFO: Fake field, exist only in values array */
    REDIRECT_ASYNC("Async"),
    /* JADX INFO: Fake field, exist only in values array */
    REDIRECT_UNKNOWN("Unknown");


    /* renamed from: a, reason: collision with root package name */
    public final String f4227a;

    RedirectType(String str) {
        this.f4227a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4227a;
    }
}
