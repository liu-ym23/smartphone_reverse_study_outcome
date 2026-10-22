package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

/* loaded from: classes2.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* renamed from: a, reason: collision with root package name */
    public final Feature f19491a;

    public UnsupportedApiCallException(Feature feature) {
        this.f19491a = feature;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f19491a));
    }
}
