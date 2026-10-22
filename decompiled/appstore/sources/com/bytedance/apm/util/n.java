package com.bytedance.apm.util;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    public static JSONObject a(JSONObject r10, String r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return null;
    L7:
        return r10.optJSONObject(r11);
    }

    public static boolean b(String r10, List r11) {
        if (com.bytedance.apm6.util.ListUtils.b(r11) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        String r12 = Uri.parse(r10).getHost();     // Catch: Throwable -> L15
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L15
    L9:
        if (r13.hasNext() == false) goto L14;
        if (r12.equalsIgnoreCase((String) r13.next()) == false) goto L9;
        return true;
    }

    public static boolean c(String r10, List r11, List r12) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        if (com.bytedance.apm6.util.ListUtils.b(r11) == true) goto L23;
        Iterator r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L23;
        if (r10.contains((String) r13.next()) == false) goto L9;
        return true;
    L23:
        String r14 = new URI(r10).getPath();     // Catch: Throwable -> L22
        if (com.bytedance.apm6.util.ListUtils.b(r12) == true) goto L21;
        Iterator r15 = r12.iterator();     // Catch: Throwable -> L22
    L17:
        if (r15.hasNext() == false) goto L21;
        if (((Pattern) r15.next()).matcher(r14).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    public static List d(JSONObject r10, String r11) {
        JSONArray r12 = r10.optJSONArray(r11);     // Catch: Exception -> L13
        if (r3.e.c(r12) == false) goto L6;
        return null;
    L6:
        int r13 = r12.length();     // Catch: Exception -> L13
        ArrayList r14 = new ArrayList(r13);     // Catch: Exception -> L13
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L12;
        String r16 = r12.getString(r15);     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r16) == true) goto L11;
        r14.add(r16);     // Catch: Exception -> L13
    L11:
        r15 = r15 + 1;
        goto L7
    L12:
        return r14;
    L13:
        return null;
    }

    public static List e(JSONObject r10, String r11) {
        JSONObject r12 = r10.optJSONObject(r11);     // Catch: Exception -> L14
        if (r3.e.d(r12) == false) goto L6;
        return null;
    L6:
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L14
        Iterator<String> r14 = r12.keys();     // Catch: Exception -> L14
    L8:
        if (r14.hasNext() == false) goto L13;
        String r15 = r14.next();     // Catch: Exception -> L14
        if (r12.optInt(r15) != 1) goto L8;
        r13.add(r15);     // Catch: Exception -> L14
        goto L8
    L13:
        return r13;
    L14:
        return null;
    }

    public static List f(JSONObject r10, String r11) {
        JSONObject r12 = r10.optJSONObject(r11);     // Catch: Exception -> L14
        if (r3.e.d(r12) == false) goto L6;
        return null;
    L6:
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L14
        Iterator<String> r14 = r12.keys();     // Catch: Exception -> L14
    L8:
        if (r14.hasNext() == false) goto L13;
        String r15 = r14.next();     // Catch: Exception -> L14
        if (r12.optInt(r15) != 1) goto L8;
        r13.add(Pattern.compile(r15));     // Catch: Exception -> L14
        goto L8
    L13:
        return r13;
    L14:
        return null;
    }

    public static List g(JSONObject r10, String r11) {
        JSONArray r12 = r10.optJSONArray(r11);     // Catch: Exception -> L15
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.length() <= 0) goto L21;
        int r13 = r12.length();     // Catch: Exception -> L15
        ArrayList r14 = new ArrayList(r13);     // Catch: Exception -> L15
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L12;
        String r16 = r12.getString(r15);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r16) == true) goto L11;
        r14.add(Pattern.compile(r16));     // Catch: Exception -> L15
    L11:
        r15 = r15 + 1;
        goto L7
    L12:
        return r14;
    L21:
        return null;
    L22:
        return null;
    }
}
