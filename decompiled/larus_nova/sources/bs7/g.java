package bs7;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes22.dex */
public final class g {
    public static String a(String r100) {
        return URLDecoder.decode(r100, XML.CHARSET_UTF8);
    L4:
        e = move-exception;
        throw new RuntimeException("Error decoding url", e);
    }
}
