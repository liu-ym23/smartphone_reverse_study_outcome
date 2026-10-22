package com.google.android.gms.maps.model;

import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class CustomCap extends Cap {

    /* renamed from: d, reason: collision with root package name */
    public final a f10153d;

    /* renamed from: e, reason: collision with root package name */
    public final float f10154e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCap(a aVar, float f4) {
        super(3, aVar, Float.valueOf(f4));
        com.stepos.statsrpk.c.m(aVar, "bitmapDescriptor must not be null");
        if (f4 <= Property.DEFAULT_FLOAT_VALUE) {
            throw new IllegalArgumentException("refWidth must be positive");
        }
        this.f10153d = aVar;
        this.f10154e = f4;
    }

    @Override // com.google.android.gms.maps.model.Cap
    public final String toString() {
        return "[CustomCap: bitmapDescriptor=" + String.valueOf(this.f10153d) + " refWidth=" + this.f10154e + "]";
    }
}
