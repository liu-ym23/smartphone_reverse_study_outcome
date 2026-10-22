package com.baidu.platform.comapi.logstatistics;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public a() {
    }

    public String appendLogTag(String r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() <= 0) goto L16;
        if (r101 != null) goto L7;
        return "";
    L7:
        if (r101.length() <= 0) goto L18;
        if (r102 != null) goto L10;
        return "";
    L10:
        if (r102.length() > 0) goto L13;
        return "";
    L13:
        return r100 + "." + r101 + "." + r102;
    L18:
        return "";
    L16:
        return "";
    }
}
