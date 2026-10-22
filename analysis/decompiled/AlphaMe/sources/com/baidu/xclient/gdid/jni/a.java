package com.baidu.xclient.gdid.jni;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.xclient.gdid.j.d;
import com.stepos.alphame.awareness.AwarenessDataItem;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static Pair<Integer, Integer> a(int i4, int i5, int i6) {
        if (i5 <= i4 || i4 == 0) {
            i4 = 1;
        }
        return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i6));
    }

    public static boolean a(int i4, int i5) {
        String binaryString = Integer.toBinaryString(i5);
        return i4 <= binaryString.length() && binaryString.charAt(i4 - 1) == '1';
    }

    public static boolean a(Context context, JSONObject jSONObject, String str, int i4, int i5, int i6) {
        if (com.baidu.sec.privacy.b.b.a(context).a() || a(i5, i6)) {
            return TextUtils.isEmpty(str) || jSONObject.optInt(str, i4) == 1;
        }
        return false;
    }

    public static String[] a(String str) {
        String[] strArrSplit;
        String[] strArrSplit2;
        String str2;
        String[] strArr = new String[2];
        try {
            strArrSplit = str.split("\n");
        } catch (Throwable th) {
            d.a(th);
        }
        if (strArrSplit == null) {
            return strArr;
        }
        for (String str3 : strArrSplit) {
            if (!TextUtils.isEmpty(str3) && (strArrSplit2 = str3.trim().split(AwarenessDataItem.USERID_SPLITTER)) != null && strArrSplit2.length == 2 && (str2 = strArrSplit2[0]) != null && strArrSplit2[1] != null) {
                String strTrim = str2.trim();
                if (strTrim.equals("Hardware") || strTrim.equals("model name")) {
                    strArr[0] = strArrSplit2[1].trim();
                } else if (strTrim.equals("vendor_id") || strTrim.equals("Processor")) {
                    strArr[1] = strArrSplit2[1].trim();
                }
            }
        }
        return strArr;
    }
}
