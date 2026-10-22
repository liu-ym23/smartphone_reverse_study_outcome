package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public final a f1430a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1431b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f1432c;
    public final int d;

    public a1(a aVar, String str, Object[] objArr) {
        this.f1430a = aVar;
        this.f1431b = str;
        this.f1432c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i8 = cCharAt & 8191;
        int i9 = 13;
        int i10 = 1;
        while (true) {
            int i11 = i10 + 1;
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 55296) {
                this.d = i8 | (cCharAt2 << i9);
                return;
            } else {
                i8 |= (cCharAt2 & 8191) << i9;
                i9 += 13;
                i10 = i11;
            }
        }
    }
}
