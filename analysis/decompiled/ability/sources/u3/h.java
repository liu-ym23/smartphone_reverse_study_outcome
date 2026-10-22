package u3;

import ca.AbstractC0897f;
import com.fasterxml.jackson.core.JsonPointer;
import com.networknt.schema.path.PathType;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final A3.a f6701a = new A3.a(PathType.JSON_PATH);
    public static final A3.a b = new A3.a(PathType.JSON_POINTER);
    public static final A3.a c = new A3.a(PathType.LEGACY);

    public static A3.a a(String str) {
        A3.a aVar;
        boolean z10 = true;
        if (str.startsWith("#")) {
            str = str.substring(1);
        }
        String[] strArrL = AbstractC0897f.L(str);
        if (str.startsWith("/")) {
            aVar = j.d;
        } else {
            aVar = j.e;
            z10 = false;
        }
        int i = -1;
        for (int i6 = 0; i6 < strArrL.length; i6++) {
            if (i6 != 0 || !z10) {
                String strDecode = strArrL[i6];
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
                    aVar.getClass();
                    aVar = new A3.a(aVar, i);
                } else {
                    if (PathType.JSON_POINTER.equals(aVar.f92a)) {
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
                    aVar = new A3.a(aVar, strDecode);
                }
            }
        }
        return aVar;
    }
}
