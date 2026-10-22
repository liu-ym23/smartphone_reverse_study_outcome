package com.baidu.mshield.b.a;

import android.text.TextUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class b {
    public static String[] a(String str) {
        String[] strArr = {"", "", "", ""};
        try {
            File file = new File(str);
            if (file.exists()) {
                String[] strArrSplit = f.a("stat " + file.getAbsolutePath(), false).f8263b.split("\\|");
                int length = strArrSplit.length;
                for (int i4 = 0; i4 < length; i4++) {
                    String str2 = strArrSplit[i4];
                    if (str2.contains("Device")) {
                        String[] strArrSplit2 = str2.split("Inode:");
                        if (strArrSplit2.length > 1) {
                            String[] strArrSplit3 = strArrSplit2[1].split("Links");
                            if (strArrSplit3.length > 0) {
                                strArr[0] = strArrSplit3[0].trim();
                            }
                        }
                    }
                    if (str2.contains("Access") && !str2.contains("Uid")) {
                        com.baidu.mshield.b.c.a.b("access " + str2);
                        String[] strArrSplit4 = str2.split("Access:");
                        if (strArrSplit4.length > 1) {
                            strArr[1] = strArrSplit4[1].trim();
                        }
                    }
                    if (str2.contains("Modify")) {
                        com.baidu.mshield.b.c.a.b("Modify " + str2);
                        String[] strArrSplit5 = str2.split("Modify:");
                        if (strArrSplit5.length > 1) {
                            strArr[2] = strArrSplit5[1].trim();
                        }
                    }
                    if (str2.contains("Change")) {
                        com.baidu.mshield.b.c.a.b("Change " + str2);
                        String[] strArrSplit6 = str2.split("Change:");
                        if (strArrSplit6.length > 1) {
                            strArr[3] = strArrSplit6[1].trim();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
        return strArr;
    }

    public static String a(long j4, String str) {
        if (j4 >= 0) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return new SimpleDateFormat(str).format(new Date(j4));
                }
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
            }
        }
        return "";
    }
}
