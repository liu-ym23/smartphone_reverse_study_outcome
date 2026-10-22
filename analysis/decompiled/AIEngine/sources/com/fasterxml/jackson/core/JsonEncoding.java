package com.fasterxml.jackson.core;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public enum JsonEncoding {
    UTF8(0, false, 8),
    UTF16_BE(1, true, 16),
    UTF16_LE(2, false, 16),
    UTF32_BE(3, true, 32),
    UTF32_LE(4, false, 32);


    /* renamed from: a, reason: collision with root package name */
    public final String f3520a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3521b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3522c;

    JsonEncoding(int i10, boolean z, int i11) {
        this.f3520a = str;
        this.f3521b = z;
        this.f3522c = i11;
    }
}
