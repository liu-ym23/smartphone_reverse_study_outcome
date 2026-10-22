package f2;

import a6.w;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2586a = 0;

    static {
        Charset.forName("UTF-8");
    }

    public static int a() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i8 = 0;
        while (i8 == 0) {
            secureRandom.nextBytes(bArr);
            i8 = ((bArr[0] & AbstractJsonLexerKt.TC_INVALID) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i8;
    }

    public static final m2.a b(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i8 = 0; i8 < str.length(); i8++) {
            char cCharAt = str.charAt(i8);
            if (cCharAt < '!' || cCharAt > '~') {
                throw new w("Not a printable ASCII character: " + cCharAt);
            }
            bArr[i8] = (byte) cCharAt;
        }
        return m2.a.a(bArr);
    }
}
