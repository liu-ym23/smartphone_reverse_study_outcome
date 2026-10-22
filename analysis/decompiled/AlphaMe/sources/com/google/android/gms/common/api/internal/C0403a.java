package com.google.android.gms.common.api.internal;

import java.util.Arrays;

/* renamed from: com.google.android.gms.common.api.internal.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0403a {

    /* renamed from: a, reason: collision with root package name */
    public final int f9628a;

    /* renamed from: b, reason: collision with root package name */
    public final android.support.v4.media.session.c f9629b;

    /* renamed from: c, reason: collision with root package name */
    public final Z0.b f9630c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9631d;

    public C0403a(android.support.v4.media.session.c cVar, String str) {
        com.google.android.gms.common.internal.g gVar = com.google.android.gms.common.internal.g.f9808b;
        this.f9629b = cVar;
        this.f9630c = gVar;
        this.f9631d = str;
        this.f9628a = Arrays.hashCode(new Object[]{cVar, gVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0403a)) {
            return false;
        }
        C0403a c0403a = (C0403a) obj;
        return com.airbnb.lottie.h.m(this.f9629b, c0403a.f9629b) && com.airbnb.lottie.h.m(this.f9630c, c0403a.f9630c) && com.airbnb.lottie.h.m(this.f9631d, c0403a.f9631d);
    }

    public final int hashCode() {
        return this.f9628a;
    }
}
