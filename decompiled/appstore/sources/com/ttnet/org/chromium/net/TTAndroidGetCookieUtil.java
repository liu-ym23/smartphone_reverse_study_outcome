package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("net")
public class TTAndroidGetCookieUtil {
    @CalledByNative
    public static String getCookieHeader(String r10) {
        HashMap r11 = new HashMap();
        StringBuilder r12 = new StringBuilder();
        CookieHandler r13 = CookieHandler.getDefault();     // Catch: Exception -> L27
        if (r13 == null) goto L7;
        Map<String, List<String>> r14 = r13.get(new URI(r10), r11);     // Catch: Exception -> L27
    L8:
        if (r14 == null) goto L26;
        if (r14.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r15 = r14.entrySet().iterator();
    L13:
        if (r15.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r16 = r15.next();
        if ("Cookie".equalsIgnoreCase(r16.getKey()) == false) goto L13;
        if (r16.getValue().isEmpty() == true) goto L13;
        Iterator<String> r17 = r16.getValue().iterator();
        int r18 = 0;
    L20:
        if (r17.hasNext() == false) goto L13;
        String r19 = r17.next();
        if (r18 <= 0) goto L24;
        r12.append("; ");
    L24:
        r12.append(r19);
        r18 = r18 + 1;
    L26:
        return r12.toString();
    L7:
        r14 = null;
    L28:
        return r12.toString();
    }
}
