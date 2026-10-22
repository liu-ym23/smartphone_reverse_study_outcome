package com.baidu.b;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public String f4878a;

    /* renamed from: b, reason: collision with root package name */
    public String f4879b;

    /* renamed from: c, reason: collision with root package name */
    public int f4880c = 2;

    /* renamed from: d, reason: collision with root package name */
    private int f4881d = 0;

    public static f a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        f fVar = new f();
        fVar.f4878a = str;
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        fVar.f4881d = length;
        if (length < 14) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            fVar.f4879b = str2;
        }
        return fVar;
    }

    public static f b(String str) {
        return c(e(str));
    }

    private static f c(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            String str2 = "0";
            String strOptString = "0";
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!d("ZGV2aWNlaWQ=").equals(next) && !d("dmVy").equals(next)) {
                    strOptString = jSONObject.optString(next, "0");
                }
            }
            String string = jSONObject.getString(d("ZGV2aWNlaWQ="));
            int i4 = jSONObject.getInt(d("dmVy"));
            int length = TextUtils.isEmpty(strOptString) ? 0 : strOptString.length();
            if (!TextUtils.isEmpty(string)) {
                f fVar = new f();
                fVar.f4878a = string;
                fVar.f4880c = i4;
                fVar.f4881d = length;
                if (length < 14) {
                    if (!TextUtils.isEmpty(strOptString)) {
                        str2 = strOptString;
                    }
                    fVar.f4879b = str2;
                }
                fVar.c();
                return fVar;
            }
        } catch (JSONException e4) {
            com.baidu.b.f.c.a(e4);
        }
        return null;
    }

    private static String d(String str) {
        return new String(com.baidu.b.d.a.a(str.getBytes()));
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrA = com.baidu.b.c.a.g.a();
            return new String(com.baidu.b.c.a.c.a(bArrA, bArrA, com.baidu.b.d.a.a(str.getBytes())));
        } catch (Exception e4) {
            com.baidu.b.f.c.a(e4);
            return "";
        }
    }

    public boolean a() {
        return a(this.f4879b);
    }

    public boolean b() {
        return a(this.f4881d);
    }

    public boolean c() {
        String str;
        if (b()) {
            str = "O";
        } else {
            if (!a()) {
                return false;
            }
            str = "0";
        }
        this.f4879b = str;
        return true;
    }

    public static boolean a(int i4) {
        return i4 >= 14;
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str);
    }
}
