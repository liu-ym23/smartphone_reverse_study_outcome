package com.google.protobuf;

/* loaded from: classes.dex */
public final class s3 {

    /* renamed from: a, reason: collision with root package name */
    public final MessageLite f2520a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2521b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f2522c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2523d;

    public s3(MessageLite messageLite, String str, Object[] objArr) {
        this.f2520a = messageLite;
        this.f2521b = str;
        this.f2522c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f2523d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.f2523d = i2 | (cCharAt2 << i10);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            }
        }
    }

    public final int a() {
        int i2 = this.f2523d;
        if ((i2 & 1) != 0) {
            return 1;
        }
        return (i2 & 4) == 4 ? 3 : 2;
    }
}
