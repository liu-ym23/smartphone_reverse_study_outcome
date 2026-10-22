package h4;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final fb.c f4160a = new fb.c(4);

    public static byte[] a(int i2) {
        byte[] bArr = new byte[i2];
        ((SecureRandom) f4160a.get()).nextBytes(bArr);
        return bArr;
    }
}
