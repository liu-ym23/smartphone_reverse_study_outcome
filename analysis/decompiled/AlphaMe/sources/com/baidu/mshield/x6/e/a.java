package com.baidu.mshield.x6.e;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static boolean a(Context context, String str) {
        return b(context, str, true);
    }

    public static boolean b(Context context, String str, boolean z4) {
        try {
            return a(context, str, z4);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
            return z4;
        }
    }

    public static boolean a(Context context, String str, boolean z4) {
        try {
            String strA = new com.baidu.mshield.x6.b.b(context).a(str);
            return TextUtils.isEmpty(strA) ? z4 : new JSONObject(strA).getInt("1") != 0;
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
            return z4;
        }
    }

    public static JSONObject b(Context context, String str) {
        try {
            return new JSONObject(new com.baidu.mshield.x6.b.b(context).a(str)).optJSONObject("2");
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
            return new JSONObject();
        }
    }

    public static int a(Context context) {
        try {
            int iO = new com.baidu.mshield.x6.b.b(context).o();
            if (iO <= 0) {
                iO = 60;
            }
            return iO / 60;
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
            return 1;
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z4) {
        try {
            JSONObject jSONObjectB = b(context, str);
            if (jSONObjectB.has(str2)) {
                return jSONObjectB.optInt(str2, z4 ? 1 : 0) == 1;
            }
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
        return z4;
    }
}
