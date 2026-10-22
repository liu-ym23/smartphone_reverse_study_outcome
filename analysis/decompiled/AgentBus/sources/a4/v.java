package a4;

import java.nio.charset.Charset;
import java.security.SecureRandom;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f207a = 0;

    static {
        Charset.forName("UTF-8");
    }

    public static int a() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i2 = 0;
        while (i2 == 0) {
            secureRandom.nextBytes(bArr);
            i2 = ((bArr[0] & 127) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i2;
    }

    public static final i4.a b(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '!' || cCharAt > '~') {
                throw new u("Not a printable ASCII character: " + cCharAt);
            }
            bArr[i2] = (byte) cCharAt;
        }
        return i4.a.a(bArr);
    }
}
