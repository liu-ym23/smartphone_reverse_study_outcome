package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class d6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w5 f27176a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Map<String, d6> f27177a;

        static {
            f27177a = new HashMap();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f27179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f27180c;

        public static List<b> a(String r100) {
            if (TextUtils.isEmpty(r100) == true) goto L5;
            ArrayList r101 = new ArrayList();
            JSONArray r102 = new JSONArray(r100);     // Catch: Throwable -> L17
            int r103 = 0;
        L9:
            if (r103 >= r102.length()) goto L16;
            JSONObject r104 = r102.getJSONObject(r103);     // Catch: Throwable -> L17
            b r105 = new b(r104.optString(com.heytap.mcssdk.constant.b.C), r104.optString("cpuType"), r104.optString("content"));     // Catch: Throwable -> L13
        L14:
            r101.add(r105);     // Catch: Throwable -> L17
            r103 = r103 + 1;
        L13:
            r105 = null;
            goto L14
        L16:
            return r101;
        L18:
            return new ArrayList();
        L5:
            return new ArrayList();
        }

        public static JSONArray a(List<b> r100) {
            JSONArray r101 = new JSONArray();
            Iterator<b> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L18;
            b r103 = r102.next();
            if (r103 == null) goto L4;
            if ((!TextUtils.isEmpty(r103.f27180c)) == false) goto L4;
            JSONObject r104 = new JSONObject();
            r104.put(com.heytap.mcssdk.constant.b.C, r103.f27178a);     // Catch: Throwable -> L16
            r104.put("cpuType", r103.f27179b);     // Catch: Throwable -> L16
            r104.put("content", r103.f27180c);     // Catch: Throwable -> L16
        L17:
            r101.put(r104);
        L16:
            r104 = new JSONObject();
            goto L17
        L18:
            return r101;
        }

        public static /* synthetic */ String a(b r100) {
            return r100.f27180c;
        }

        public final boolean a(String r100, String r101) {
            if (TextUtils.isEmpty(r100) == false) goto L6;
            r100 = this.f27178a;
        L6:
            if (TextUtils.isEmpty(r101) == false) goto L9;
            r101 = this.f27179b;
        L9:
            if (this.f27178a.equals(r100) == true) goto L11;
            return false;
        L11:
            if (this.f27179b.equals(r101) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public static /* synthetic */ String a(b r100, String r101) {
            r100.f27180c = r101;
            return r101;
        }

        public b(String r100, String r101, String r102) {
            this.f27178a = r100;
            this.f27179b = r101;
            this.f27180c = r102;
        }
    }

    private d6(w5 r100) {
        this.f27176a = r100;
    }

    public static d6 a(w5 r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r100.d()) == false) goto L7;
        return null;
    L7:
        if (a.f27177a.get(r100.d()) != null) goto L10;
        a.f27177a.put(r100.d(), new d6(r100));
    L10:
        return a.f27177a.get(r100.d());
    }

    private static String a(Context r100, String r101, String r102) {
        String r103 = "C7ADB20F22F238708BA5EE26D0401DB9" + t5.c(r101);
        String r104 = "ik".concat(String.valueOf(r102));
        if (TextUtils.isEmpty(r104) == false) goto L6;
        return "";
    L6:
        return x5.c(j5.a(x5.c(r100.getSharedPreferences(r103, 0).getString(r104, ""))));
    }

    private static void b(Context r100, String r101, String r102, String r103) {
        if (r103 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        String r104 = "C7ADB20F22F238708BA5EE26D0401DB9" + t5.c(r101);
        String r105 = "ik".concat(String.valueOf(r102));
        if (TextUtils.isEmpty(r105) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r104) == false) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r103) == true) goto L20;
        String r106 = x5.b(j5.b(x5.e(r103)));
        SharedPreferences.Editor r107 = r100.getSharedPreferences(r104, 0).edit();
        r107.putString(r105, r106);
        r107.commit();
        return;
    L20:
        return;
    }

    public final String a(Context r100, String r101, String r102, String r103) {
        if (r100 == null) goto L21;
        w5 r104 = this.f27176a;
        if (r104 == null) goto L21;
        if (TextUtils.isEmpty(r104.d()) == true) goto L21;
        ArrayList r105 = (ArrayList) b.a(a(r100, this.f27176a.d(), r103));
        if (r105.size() != 0) goto L13;
        return "";
    L13:
        int r106 = 0;
    L15:
        if (r106 >= r105.size()) goto L21;
        b r107 = (b) ListProtector.get(r105, r106);
        if (r107.a(r101, r102) == true) goto L19;
        r106 = r106 + 1;
        goto L15
    L19:
        return b.a(r107);
    L21:
        return null;
    }

    public final void a(Context r100, String r101, String r102, String r103, String r104) {
        if (r100 == null) goto L20;
        w5 r105 = this.f27176a;
        if (r105 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r105.d()) == true) goto L22;
        List<b> r106 = b.a(a(r100, this.f27176a.d(), r103));
        int r107 = 0;
    L9:
        ArrayList r108 = (ArrayList) r106;
        if (r107 >= r108.size()) goto L16;
        b r109 = (b) ListProtector.get(r108, r107);
        if (r109.a(r101, r102) == true) goto L13;
        r107 = r107 + 1;
        goto L9
    L13:
        b.a(r109, r104);
        b(r100, this.f27176a.d(), r103, b.a(r106).toString());
        return;
    L16:
        r108.add(new b(r101, r102, r104));
        b(r100, this.f27176a.d(), r103, b.a(r106).toString());
        return;
    L22:
        return;
    }
}
