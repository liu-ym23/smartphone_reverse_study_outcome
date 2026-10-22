package com.bytedance.android.ec.core.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class e2 {
    public static String a(String r100, String r101) {
        if (r101 != null) goto L6;
        return URLEncoder.encode(r100, "ISO-8859-1");
    L6:
        if (r101.equals("null_encoding") == false) goto L9;
        return r100;
    L9:
        return URLEncoder.encode(r100, r101);
    L10:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String b(List<? extends z0> r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        Iterator<? extends z0> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        z0 r104 = r103.next();
        String r105 = a(r104.getName(), r101);
        String r106 = r104.getValue();
        if (r106 == null) goto L8;
        String r107 = a(r106, r101);
    L10:
        if (r102.length() <= 0) goto L12;
        r102.append("&");
    L12:
        r102.append(r105);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r107);
        goto L4
    L8:
        r107 = "";
        goto L10
    L14:
        return r102.toString();
    }
}
