package com.bytedance.apm.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public static String b(String r100) {
        return URLEncoder.encode(r100, "UTF-8");
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String a(String r100, Map<String, String> r101) {
        if (TextUtils.isDigitsOnly(r100) == true) goto L26;
        if (r101 == null) goto L26;
        if (r101.isEmpty() == true) goto L26;
        if (r100.indexOf("?") >= 0) goto L12;
        r100 = r100.concat("?");
    L12:
        if (r100.endsWith("?") == false) goto L14;
        r100 = r100 + b("sdk_version") + ContainerUtils.KEY_VALUE_DELIMITER + b(String.valueOf(400));
    L16:
        if (r101.size() <= 0) goto L26;
        Iterator<Map.Entry<String, String>> r102 = r101.entrySet().iterator();
    L19:
        if (r102.hasNext() == false) goto L26;
        Map.Entry<String, String> r103 = r102.next();
        if (r101.get(r103.getKey()) == null) goto L19;
        if (r100.endsWith("?") == true) goto L24;
        r100 = r100 + "&" + b(r103.getKey().toString()) + ContainerUtils.KEY_VALUE_DELIMITER + b(r101.get(r103.getKey()).toString());
        goto L19
    L24:
        r100 = r100 + b(r103.getKey().toString()) + ContainerUtils.KEY_VALUE_DELIMITER + b(r101.get(r103.getKey()).toString());
        goto L19
    L14:
        r100 = r100 + "&" + b("sdk_version") + ContainerUtils.KEY_VALUE_DELIMITER + b(String.valueOf(400));
    L26:
        return r100;
    }
}
