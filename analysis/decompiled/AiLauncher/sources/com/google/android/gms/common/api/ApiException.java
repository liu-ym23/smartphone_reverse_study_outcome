package com.google.android.gms.common.api;

/* loaded from: classes2.dex */
public class ApiException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public final Status f19488a;

    public ApiException(Status status) {
        super(status.getStatusCode() + ": " + (status.getStatusMessage() != null ? status.getStatusMessage() : ""));
        this.f19488a = status;
    }

    public Status a() {
        return this.f19488a;
    }
}
