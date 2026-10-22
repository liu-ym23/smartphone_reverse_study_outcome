package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mshield.utility.g;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes39.dex */
public class c implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f32438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f32439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f32440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f32441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f32442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f32443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f32444g;

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        SharedPreferences.Editor r100 = this.f32441d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        SharedPreferences r101 = this.f32438a;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.edit();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new RuntimeException("This preference not allow to call getAll.");
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r100) {
        throw new RuntimeException("This preference not allow to call contains.");
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        SharedPreferences r101 = this.f32438a;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.registerOnSharedPreferenceChangeListener(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
        SharedPreferences r101 = this.f32438a;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.unregisterOnSharedPreferenceChangeListener(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r100, boolean r101) {
    L18:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L20:
        return r101;
    L3:
        if (this.f32440c != 1) goto L14;
        if (this.f32442e == false) goto L9;
        if (TextUtils.isEmpty(this.f32444g) == false) goto L14;
    L9:
        if (this.f32438a != null) goto L11;
        return r101;
    L11:
        com.baidu.mshield.b.c.a.b("SPT getBoolean:return by mBase");     // Catch: Throwable -> L18
        return this.f32438a.getBoolean(r100, r101);
    L14:
        Bundle r102 = a("getBoolean", r100, String.valueOf(r101));     // Catch: Throwable -> L18
        if (r102 == null) goto L20;
        com.baidu.mshield.b.c.a.b("SPT getBoolean:return by resultBundle");     // Catch: Throwable -> L18
        return r102.getBoolean("result", r101);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r100, float r101) {
    L18:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L20:
        return r101;
    L3:
        if (this.f32440c != 1) goto L14;
        if (this.f32442e == false) goto L9;
        if (TextUtils.isEmpty(this.f32444g) == false) goto L14;
    L9:
        if (this.f32438a != null) goto L11;
        return r101;
    L11:
        com.baidu.mshield.b.c.a.b("SPT getFloat:return by mBase");     // Catch: Throwable -> L18
        return this.f32438a.getFloat(r100, r101);
    L14:
        Bundle r102 = a("getFloat", r100, String.valueOf(r101));     // Catch: Throwable -> L18
        if (r102 == null) goto L20;
        com.baidu.mshield.b.c.a.b("SPT getFloat:return by resultBundle");     // Catch: Throwable -> L18
        return r102.getFloat("result", r101);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r100, int r101) {
    L18:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L20:
        return r101;
    L3:
        if (this.f32440c != 1) goto L14;
        if (this.f32442e == false) goto L9;
        if (TextUtils.isEmpty(this.f32444g) == false) goto L14;
    L9:
        if (this.f32438a != null) goto L11;
        return r101;
    L11:
        com.baidu.mshield.b.c.a.b("SPT getInt:return by mBase");     // Catch: Throwable -> L18
        return this.f32438a.getInt(r100, r101);
    L14:
        Bundle r102 = a("getInt", r100, String.valueOf(r101));     // Catch: Throwable -> L18
        if (r102 == null) goto L20;
        com.baidu.mshield.b.c.a.b("SPT getInt:return by resultBundle");     // Catch: Throwable -> L18
        return r102.getInt("result", r101);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r100, long r101) {
    L18:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L20:
        return r101;
    L3:
        if (this.f32440c != 1) goto L14;
        if (this.f32442e == false) goto L9;
        if (TextUtils.isEmpty(this.f32444g) == false) goto L14;
    L9:
        if (this.f32438a != null) goto L11;
        return r101;
    L11:
        com.baidu.mshield.b.c.a.b("SPT getLong:return by mBase");     // Catch: Throwable -> L18
        return this.f32438a.getLong(r100, r101);
    L14:
        Bundle r102 = a("getLong", r100, String.valueOf(r101));     // Catch: Throwable -> L18
        if (r102 == null) goto L20;
        com.baidu.mshield.b.c.a.b("SPT getLong:return by resultBundle");     // Catch: Throwable -> L18
        return r102.getLong("result", r101);
    }

    @Override // android.content.SharedPreferences
    public String getString(String r100, String r101) {
    L17:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L19:
        return r101;
    L3:
        if (this.f32440c == 1) goto L5;
    L13:
        Bundle r102 = a("getString", r100, r101);     // Catch: Throwable -> L17
        if (r102 == null) goto L19;
        com.baidu.mshield.b.c.a.b("SPT getString:return by resultBundle");     // Catch: Throwable -> L17
        return r102.getString("result", r101);
    L5:
        if (this.f32442e == false) goto L9;
        if (TextUtils.isEmpty(this.f32444g) == false) goto L13;
    L9:
        if (this.f32438a != null) goto L11;
        return r101;
    L11:
        com.baidu.mshield.b.c.a.b("SPT getString:return by mBase");     // Catch: Throwable -> L17
        return this.f32438a.getString(r100, r101);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String r100, Set<String> r101) {
        throw new RuntimeException("This preference not allow to call getStringSet.");
    }

    public final Bundle a(String r100, String r101, String r102) {
        com.baidu.mshield.b.c.a.b("SPT callProviderGet:" + r100 + "_" + r101 + "_" + r102);     // Catch: Throwable -> L16
        Bundle r103 = new Bundle();     // Catch: Throwable -> L16
        r103.putString(WikiFolderPushPlugin.OPT, r100);     // Catch: Throwable -> L16
        r103.putString("pref_name", this.f32443f);     // Catch: Throwable -> L16
        r103.putString("key", r101);     // Catch: Throwable -> L16
        r103.putString("defult_value", r102);     // Catch: Throwable -> L16
        if (this.f32442e == false) goto L15;
        if (TextUtils.isEmpty(this.f32444g) == false) goto L13;
        return g.a(this.f32439b, "CallPreferences", r103);
    L13:
        return g.a(this.f32439b, "CallPreferences", r103, this.f32444g);
    L15:
        return g.a(this.f32439b, "CallPreferences", r103);
    L16:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return null;
    }

    public c(Context r100, SharedPreferences r101, String r110, boolean r111, int r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public c(Context r100, SharedPreferences r101, String r110, boolean r111, int r112, String r113) {
        this.f32439b = r100;
        this.f32440c = r112;
        this.f32438a = r101;
        if (r101 == null) goto L5;
        SharedPreferences.Editor r102 = r101.edit();
    L6:
        this.f32441d = new b(r100, r102, r110, r111, this.f32440c, r113);
        this.f32442e = r111;
        this.f32443f = r110;
        this.f32444g = r113;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
