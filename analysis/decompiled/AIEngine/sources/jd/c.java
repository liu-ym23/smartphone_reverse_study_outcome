package jd;

import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f9770a;

    static {
        ByteString byteString = ByteString.f11312d;
        f9770a = ByteString.a.b("xn--");
    }

    public static int a(int i10, int i11, boolean z) {
        int i12 = z ? i10 / 700 : i10 / 2;
        int i13 = (i12 / i11) + i12;
        int i14 = 0;
        while (i13 > 455) {
            i13 /= 35;
            i14 += 36;
        }
        return ((i13 * 36) / (i13 + 38)) + i14;
    }

    public static int b(int i10) {
        if (i10 < 26) {
            return i10 + 97;
        }
        if (i10 < 36) {
            return i10 + 22;
        }
        throw new IllegalStateException(("unexpected digit: " + i10).toString());
    }
}
