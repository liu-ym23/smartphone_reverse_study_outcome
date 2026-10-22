package com.baidu.platform.comapi.logstatistics;

/* loaded from: classes.dex */
public class a {
    public String appendLogTag(String str, String str2, String str3) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || str3 == null || str3.length() <= 0) {
            return "";
        }
        return str + "." + str2 + "." + str3;
    }
}
