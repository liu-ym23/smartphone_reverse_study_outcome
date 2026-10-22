package com.google.android.gms.common.internal;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class g implements Z0.b {

    /* renamed from: b, reason: collision with root package name */
    public static final g f9808b = new g(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f9809a;

    public /* synthetic */ g(String str) {
        this.f9809a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return com.airbnb.lottie.h.m(this.f9809a, ((g) obj).f9809a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9809a});
    }
}
