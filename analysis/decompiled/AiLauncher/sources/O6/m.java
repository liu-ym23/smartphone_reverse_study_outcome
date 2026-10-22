package O6;

import La.C0953c;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\f\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"LO6/m;", "", "<init>", "()V", "", "origin", "c", "(Ljava/lang/String;)Ljava/lang/String;", "encoding", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "([B)Ljava/lang/String;", "", "", "bigEnding", "(BZ)Ljava/lang/String;", "", "hexDigits", "[Ljava/lang/String;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class m {
    public static final m INSTANCE = new m();
    private static final String[] hexDigits = {"0", "1", "2", "3", UxipConstants.f30661Y, UxipConstants.EVENT_UPLOAD_MIN_VERSION, "6", "7", "8", "9", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "e", "f"};

    public final String a(byte[] b10) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : b10) {
            sb2.append(b(b11, true));
        }
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public final String b(byte b10, boolean bigEnding) {
        StringBuilder sb2;
        int i10 = b10;
        if (b10 < 0) {
            i10 = b10 + 256;
        }
        int i11 = i10 / 16;
        int i12 = i10 % 16;
        if (bigEnding) {
            String[] strArr = hexDigits;
            String str = strArr[i11];
            String str2 = strArr[i12];
            sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
        } else {
            String[] strArr2 = hexDigits;
            String str3 = strArr2[i12];
            String str4 = strArr2[i11];
            sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str4);
        }
        return sb2.toString();
    }

    public final String c(String origin) {
        kotlin.jvm.internal.p.i(origin, "origin");
        return d(origin, null);
    }

    public final String d(String origin, String encoding) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (encoding == null) {
                byte[] bytes = origin.getBytes(C0953c.UTF_8);
                kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
                byte[] bArrDigest = messageDigest.digest(bytes);
                kotlin.jvm.internal.p.h(bArrDigest, "digest(...)");
                return a(bArrDigest);
            }
            Charset charsetForName = Charset.forName(encoding);
            kotlin.jvm.internal.p.h(charsetForName, "forName(...)");
            byte[] bytes2 = origin.getBytes(charsetForName);
            kotlin.jvm.internal.p.h(bytes2, "getBytes(...)");
            byte[] bArrDigest2 = messageDigest.digest(bytes2);
            kotlin.jvm.internal.p.h(bArrDigest2, "digest(...)");
            return a(bArrDigest2);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
