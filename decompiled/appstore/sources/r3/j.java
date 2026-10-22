package r3;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f23730a = 1;

    static {
    }

    public static String a(String r10, Map r11) {
        if (TextUtils.isDigitsOnly(r10) == true) goto L26;
        if (r11 == null) goto L26;
        if (r11.isEmpty() == true) goto L26;
        if (r10.indexOf("?") >= 0) goto L12;
        r10 = r10 + "?";
    L12:
        if (r10.endsWith("?") == false) goto L14;
        r10 = r10 + b(WsConstants.KEY_SDK_VERSION, "UTF-8") + "=" + b(String.valueOf(f23730a), "UTF-8");
    L16:
        if (r11.size() <= 0) goto L26;
        Iterator r12 = r11.entrySet().iterator();
    L19:
        if (r12.hasNext() == false) goto L26;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (r11.get(r13.getKey()) == null) goto L19;
        if (r10.endsWith("?") == true) goto L24;
        r10 = r10 + "&" + b(r13.getKey().toString(), "UTF-8") + "=" + b(((String) r11.get(r13.getKey())).toString(), "UTF-8");
        goto L19
    L24:
        r10 = r10 + b(r13.getKey().toString(), "UTF-8") + "=" + b(((String) r11.get(r13.getKey())).toString(), "UTF-8");
        goto L19
    L14:
        r10 = r10 + "&" + b(WsConstants.KEY_SDK_VERSION, "UTF-8") + "=" + b(String.valueOf(f23730a), "UTF-8");
    L26:
        return r10;
    }

    public static String b(String r10, String r11) {
        if (r11 != null) goto L10;
        r11 = "UTF-8";
    L10:
        return URLEncoder.encode(r10, r11);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
