package com.bytedance.android.livesdkapi.util.url;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final String ENCODING_NULL = "null_encoding";
    public static final String ENCODING_UTF_8 = "UTF-8";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";

    public URLEncodedUtils() {
    }

    private static String encode(String r100, String r101) {
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

    public static String format(List<? extends NameValuePair> r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        Iterator<? extends NameValuePair> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        NameValuePair r104 = r103.next();
        String r105 = encode(r104.getName(), r101);
        String r106 = r104.getValue();
        if (r106 == null) goto L8;
        String r107 = encode(r106, r101);
    L10:
        if (r102.length() <= 0) goto L12;
        r102.append("&");
    L12:
        r102.append(r105);
        r102.append("=");
        r102.append(r107);
        goto L4
    L8:
        r107 = "";
        goto L10
    L14:
        return r102.toString();
    }
}
