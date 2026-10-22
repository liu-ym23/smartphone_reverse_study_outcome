package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"ApplySharedPref"})
/* loaded from: classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, k> f19236b = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f19237a;

    public k(String str, int i10) {
        this.f19237a = p.a().getSharedPreferences(str, i10);
    }

    public static k a(String str) {
        return b(str, 0);
    }

    public static k b(String str, int i10) {
        k kVar;
        if (e(str)) {
            str = "spUtils";
        }
        Map<String, k> map = f19236b;
        k kVar2 = map.get(str);
        if (kVar2 != null) {
            return kVar2;
        }
        synchronized (k.class) {
            try {
                kVar = map.get(str);
                if (kVar == null) {
                    kVar = new k(str, i10);
                    map.put(str, kVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }

    public static boolean e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public String c(String str) {
        return d(str, "");
    }

    public String d(String str, String str2) {
        return this.f19237a.getString(str, str2);
    }

    public void f(String str) {
        g(str, false);
    }

    public void g(String str, boolean z10) {
        if (z10) {
            this.f19237a.edit().remove(str).commit();
        } else {
            this.f19237a.edit().remove(str).apply();
        }
    }
}
