package com.byted.cast.linkcommon.cybergarage.xml;

/* JADX INFO: loaded from: classes28.dex */
public class XML {
    public static final String CHARSET_UTF8 = "utf-8";
    public static final String DEFAULT_CONTENT_LANGUAGE = "en";
    public static final String DEFAULT_CONTENT_TYPE = "text/xml; charset=\"utf-8\"";

    public XML() {
    }

    public static final String escapeXMLChars(String r100) {
        return escapeXMLChars(r100, true);
    }

    public static final String unescapeXMLChars(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.replace("&amp;", "&").replace("&lt;", "<").replace("&gt;", ">").replace("&apos;", "'").replace("&quot;", "\"");
    }

    private static final String escapeXMLChars(String r100, boolean r110) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuffer r101 = new StringBuffer();
        int r102 = r100.length();
        char[] r103 = new char[r102];
        int r104 = 0;
        r100.getChars(0, r102, r103, 0);
        String r105 = null;
        int r106 = 0;
    L6:
        if (r104 >= r102) goto L28;
        char r107 = r103[r104];
        if (r107 != '\"') goto L10;
    L23:
        if (r110 == false) goto L25;
        r105 = "&quot;";
    L25:
        if (r105 == null) goto L27;
        r101.append(r103, r106, r104 - r106);
        r101.append(r105);
        r106 = r104 + 1;
        r105 = null;
    L27:
        r104 = r104 + 1;
        goto L6
    L10:
        if (r107 != '<') goto L12;
        r105 = "&lt;";
        goto L25
    L12:
        if (r107 != '>') goto L14;
        r105 = "&gt;";
        goto L25
    L14:
        if (r107 != '&') goto L16;
        r105 = "&amp;";
        goto L25
    L16:
        if (r107 != '\'') goto L25;
        if (r110 == false) goto L23;
        r105 = "&apos;";
        goto L25
    L28:
        if (r106 != 0) goto L30;
        return r100;
    L30:
        r101.append(r103, r106, r102 - r106);
        return r101.toString();
    }
}
