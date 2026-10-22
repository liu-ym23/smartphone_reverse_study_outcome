package w7;

import com.fasterxml.jackson.core.JsonPointer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final c8.a f15320a = new c8.a(c8.e.JSON_PATH);

    /* renamed from: b, reason: collision with root package name */
    public static final c8.a f15321b = new c8.a(c8.e.JSON_POINTER);

    /* renamed from: c, reason: collision with root package name */
    public static final c8.a f15322c = new c8.a(c8.e.LEGACY);

    public static c8.a a(String str) {
        c8.a aVarB;
        boolean z10 = true;
        if (str.startsWith("#")) {
            str = str.substring(1);
        }
        String[] strArrK = p5.f.K(str);
        if (str.startsWith("/")) {
            aVarB = n.f15336d;
        } else {
            aVarB = n.f15337e;
            z10 = false;
        }
        int i = -1;
        for (int i3 = 0; i3 < strArrK.length; i3++) {
            if (i3 != 0 || !z10) {
                String strDecode = strArrK[i3];
                int i10 = 0;
                while (i10 < strDecode.length()) {
                    char cCharAt = strDecode.charAt(i10);
                    if (cCharAt < '0' || cCharAt > '9') {
                        i = -1;
                        break;
                    }
                    i = (i10 == 0 ? 0 : i * 10) + (cCharAt - '0');
                    i10++;
                }
                if (i != -1) {
                    aVarB = aVarB.a(i);
                } else {
                    if (c8.e.JSON_POINTER.equals(aVarB.f2223c)) {
                        if (strDecode.contains("~")) {
                            strDecode = strDecode.replace(JsonPointer.ESC_SLASH, "/").replace(JsonPointer.ESC_TILDE, "~");
                        }
                        if (strDecode.contains("%")) {
                            try {
                                strDecode = URLDecoder.decode(strDecode, StandardCharsets.UTF_8.toString());
                            } catch (UnsupportedEncodingException unused) {
                            }
                        }
                    }
                    aVarB = aVarB.b(strDecode);
                }
            }
        }
        return aVarB;
    }
}
