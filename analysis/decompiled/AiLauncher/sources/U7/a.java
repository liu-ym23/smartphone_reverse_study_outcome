package U7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f6315a = {"0", "1", "2", "3", UxipConstants.f30661Y, UxipConstants.EVENT_UPLOAD_MIN_VERSION, "6", "7", "8", "9", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "e", "f"};

    /* renamed from: b, reason: collision with root package name */
    public static ThreadLocal<MessageDigest> f6316b = new C0110a();

    /* renamed from: U7.a$a, reason: collision with other inner class name */
    public class C0110a extends ThreadLocal<MessageDigest> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("no md5 algorythm found");
            }
        }
    }

    public static String a(String str) {
        return b(str, null);
    }

    public static String b(String str, String str2) {
        try {
            String str3 = new String(str);
            MessageDigest messageDigest = f6316b.get();
            return str2 == null ? c(messageDigest.digest(str3.getBytes())) : c(messageDigest.digest(str3.getBytes(str2)));
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            stringBuffer.append(d(b10, true));
        }
        return stringBuffer.toString();
    }

    public static String d(byte b10, boolean z10) {
        StringBuilder sb2;
        String str;
        int i10 = b10;
        if (b10 < 0) {
            i10 = b10 + 256;
        }
        int i11 = i10 / 16;
        int i12 = i10 % 16;
        if (z10) {
            sb2 = new StringBuilder();
            String[] strArr = f6315a;
            sb2.append(strArr[i11]);
            str = strArr[i12];
        } else {
            sb2 = new StringBuilder();
            String[] strArr2 = f6315a;
            sb2.append(strArr2[i12]);
            str = strArr2[i11];
        }
        sb2.append(str);
        return sb2.toString();
    }
}
