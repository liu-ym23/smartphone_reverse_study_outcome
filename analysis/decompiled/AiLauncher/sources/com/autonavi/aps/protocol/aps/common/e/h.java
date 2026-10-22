package com.autonavi.aps.protocol.aps.common.e;

import java.util.List;

/* loaded from: classes.dex */
public class h {
    public static String a(Object[] objArr, String str) {
        if (objArr == null) {
            return "";
        }
        if (str == null) {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (objArr.length > 0) {
            sb2.append(objArr[0]);
        }
        for (int i10 = 1; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null) {
                obj = "";
            }
            sb2.append(str);
            sb2.append(obj);
        }
        return sb2.toString();
    }

    public static String a(List<String> list, String str) {
        if (list == null) {
            return "";
        }
        if (str == null) {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (list.size() > 0) {
            sb2.append(list.get(0));
        }
        for (int i10 = 1; i10 < list.size(); i10++) {
            String str2 = list.get(i10);
            if (str2 == null) {
                str2 = "";
            }
            sb2.append(str);
            sb2.append(str2);
        }
        return sb2.toString();
    }
}
