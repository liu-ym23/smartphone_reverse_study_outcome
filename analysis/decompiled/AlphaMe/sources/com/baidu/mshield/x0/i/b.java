package com.baidu.mshield.x0.i;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f8428a;

    /* renamed from: b, reason: collision with root package name */
    public String f8429b = "";

    public b(Context context) {
        this.f8428a = context;
    }

    public static synchronized b a(Context context) {
        return new b(context);
    }

    public String b(String str) {
        StringBuilder sb = new StringBuilder();
        String strC = d.c();
        sb.append(a("p/1/r", str));
        sb.append("&msg_id=" + strC);
        return sb.toString();
    }

    public final String a() {
        if (!TextUtils.isEmpty(this.f8429b)) {
            return this.f8429b;
        }
        String strL = d.l(this.f8428a);
        if (!TextUtils.isEmpty(strL)) {
            this.f8429b = strL;
        }
        return this.f8429b;
    }

    public byte[] a(byte[] bArr, String str) {
        try {
            return com.baidu.mshield.b.f.d.b(com.baidu.mshield.b.a.c.a(str.getBytes("utf-8")), bArr);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public String a(String str) {
        return a("s/5/aio", str);
    }

    public final String a(String str, String str2, String str3) {
        String strA;
        try {
            String strC = d.c(this.f8428a);
            String strD = d.d(this.f8428a);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                strA = d.a(strC, strD, jCurrentTimeMillis);
            } catch (Throwable th) {
                d.a(th);
                strA = "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a());
            stringBuffer.append(str);
            stringBuffer.append("/250");
            stringBuffer.append("/" + strC);
            stringBuffer.append("/" + jCurrentTimeMillis);
            stringBuffer.append("/" + strA);
            stringBuffer.append("?skey=" + str2);
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("&page=" + str3);
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            d.a(th2);
            return "";
        }
    }

    public final String a(String str, String str2) {
        return a(str, str2, "");
    }
}
