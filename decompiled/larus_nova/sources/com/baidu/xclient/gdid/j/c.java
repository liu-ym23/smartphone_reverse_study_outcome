package com.baidu.xclient.gdid.j;

import android.text.TextUtils;
import com.android.ttcjpaysdk.facelive.utils.CJPayUploadVideoUtil;

/* JADX INFO: loaded from: classes39.dex */
public class c {
    public static String a(String r100, String r101, StringBuilder r102) {
        if (a(r101) == false) goto L5;
    L8:
        a(r102, r100, r101);
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return r101;
    }

    public static void a(StringBuilder r100, String r101, String r102) {
        if (r100.length() == 0) goto L5;
        r100.append("_");
    L5:
        r100.append(r101);
        r100.append("*");
        r100.append(r102);
    }

    public static boolean a(String r100) {
        if (CJPayUploadVideoUtil.ERROR_CODE_FILE_SIZE_ZERO.equals(r100) == false) goto L5;
        return true;
    L5:
        if ("-1001".equals(r100) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
