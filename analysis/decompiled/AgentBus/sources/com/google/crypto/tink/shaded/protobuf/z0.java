package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f2298a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2299b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f2300c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2301d;

    public z0(a aVar, String str, Object[] objArr) {
        this.f2298a = aVar;
        this.f2299b = str;
        this.f2300c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f2301d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.f2301d = i2 | (cCharAt2 << i10);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            }
        }
    }
}
