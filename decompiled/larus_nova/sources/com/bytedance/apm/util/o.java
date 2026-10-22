package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static List<String> b(JSONObject r100, String r101) {
        JSONArray r102 = r100.optJSONArray(r101);     // Catch: Exception -> L19
        int r103 = 0;
        if (r102 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        return null;
    L12:
        int r105 = r102.length();     // Catch: Exception -> L19
        ArrayList r106 = new ArrayList(r105);     // Catch: Exception -> L19
    L13:
        if (r103 >= r105) goto L18;
        String r107 = JSONArrayProtectorUtils.getString(r102, r103);     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r107) == true) goto L17;
        r106.add(r107);     // Catch: Exception -> L19
    L17:
        r103 = r103 + 1;
        goto L13
    L18:
        return r106;
    L6:
        if (r102.length() == 0) goto L9;
        r104 = false;
    L19:
        return null;
    }

    public static List<String> c(JSONObject r100, String r101) {
        JSONObject r102 = r100.optJSONObject(r101);     // Catch: Exception -> L14
        if (xu3.d.c(r102) == false) goto L6;
        return null;
    L6:
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L14
        Iterator<String> r104 = r102.keys();     // Catch: Exception -> L14
    L8:
        if (r104.hasNext() == false) goto L13;
        String r105 = r104.next();     // Catch: Exception -> L14
        if (r102.optInt(r105) != 1) goto L8;
        r103.add(r105);     // Catch: Exception -> L14
        goto L8
    L13:
        return r103;
    L14:
        return null;
    }

    public static boolean a(String r100, List<String> r101, List<Pattern> r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (xu3.e.b(r101) == true) goto L23;
        Iterator<String> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L23;
        if (r100.contains(r103.next()) == false) goto L9;
        return true;
    L23:
        String r104 = new URI(r100).getPath();     // Catch: Throwable -> L22
        if (xu3.e.b(r102) == true) goto L21;
        Iterator<Pattern> r105 = r102.iterator();     // Catch: Throwable -> L22
    L17:
        if (r105.hasNext() == false) goto L21;
        if (r105.next().matcher(r104).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }
}
