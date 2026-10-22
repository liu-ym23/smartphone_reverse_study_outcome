package com.alipay.sdk.m.r;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f25739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f25741c;

    public a a() {
        return this.f25739a;
    }

    public String b() {
        return this.f25740b;
    }

    public String[] c() {
        return this.f25741c;
    }

    public b(String r100) {
        this.f25740b = r100;
    }

    public static void a(b r100) {
        String[] r101 = r100.c();
        if (r101.length == 3) goto L6;
        return;
    L6:
        if (TextUtils.equals("tid", r101[0]) == false) goto L14;
        com.alipay.sdk.m.t.a r102 = com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b());
        if (TextUtils.isEmpty(r101[1]) == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r101[2]) == true) goto L16;
        r102.a(r101[1], r101[2]);
        return;
    L16:
        return;
    }

    public static String[] b(String r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.indexOf(40);
        int r103 = r100.lastIndexOf(41);
        if (r102 == (-1)) goto L12;
        if (r103 == (-1)) goto L15;
        if (r103 <= r102) goto L16;
        String[] r104 = r100.substring(r102 + 1, r103).split("' *, *'", -1);
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L11;
        r101.add(r104[r106].trim().replaceAll("'", "").replaceAll("\"", ""));
        r106 = r106 + 1;
        goto L8
    L11:
        return (String[]) r101.toArray(new String[0]);
    L16:
        return null;
    L15:
        return null;
    L12:
        return null;
    }

    public static List<b> a(JSONObject r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        String[] r102 = a(r100.optString("name", ""));
        int r103 = 0;
    L7:
        if (r103 >= r102.length) goto L13;
        a r104 = a.a(r102[r103]);
        if (r104 == a.f25731b) goto L12;
        b r105 = new b(r102[r103], r104);
        r105.f25741c = b(r102[r103]);
        r101.add(r105);
    L12:
        r103 = r103 + 1;
        goto L7
    L13:
        return r101;
    }

    public static String[] a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return r100.split(i.f25853b);
    }

    public b(String r100, a r101) {
        this.f25740b = r100;
        this.f25739a = r101;
    }
}
