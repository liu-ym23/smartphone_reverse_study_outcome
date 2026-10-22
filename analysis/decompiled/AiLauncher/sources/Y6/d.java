package Y6;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "ascii", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)[B", "database_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    public static final byte[] b(String str) {
        if (str.length() != 7) {
            throw new IllegalArgumentException(("ascii segment must be 7 chars, got '" + str.length() + "'").toString());
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (' ' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(("ascii segment must be printable ASCII: " + str).toString());
            }
        }
        byte[] bArr = new byte[8];
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = (byte) str.charAt(i11);
        }
        bArr[7] = 10;
        return bArr;
    }
}
