package t7;

import java.math.BigInteger;
import m0.f;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final BigInteger f5606a;

    /* renamed from: b, reason: collision with root package name */
    public final BigInteger f5607b;

    /* renamed from: c, reason: collision with root package name */
    public final BigInteger f5608c;
    public final BigInteger d;

    /* renamed from: e, reason: collision with root package name */
    public final BigInteger f5609e;

    /* renamed from: f, reason: collision with root package name */
    public final BigInteger f5610f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5611g;

    public d(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger, BigInteger bigInteger2, int i8) {
        a(bigIntegerArr, "v1");
        a(bigIntegerArr2, "v2");
        this.f5606a = bigIntegerArr[0];
        this.f5607b = bigIntegerArr[1];
        this.f5608c = bigIntegerArr2[0];
        this.d = bigIntegerArr2[1];
        this.f5609e = bigInteger;
        this.f5610f = bigInteger2;
        this.f5611g = i8;
    }

    public static void a(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException(f.d("'", str, "' must consist of exactly 2 (non-null) values"));
        }
    }
}
