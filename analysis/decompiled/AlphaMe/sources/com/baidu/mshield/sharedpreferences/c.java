package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import ch.qos.logback.core.joran.action.Action;
import com.baidu.mshield.utility.g;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class c implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f8339a;

    /* renamed from: b, reason: collision with root package name */
    public Context f8340b;

    /* renamed from: c, reason: collision with root package name */
    public int f8341c;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f8342d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8343e;

    /* renamed from: f, reason: collision with root package name */
    public String f8344f;

    /* renamed from: g, reason: collision with root package name */
    public String f8345g;

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z4, int i4) {
        this(context, sharedPreferences, str, z4, i4, null);
    }

    public final Bundle a(String str, String str2, String str3) {
        try {
            com.baidu.mshield.b.c.a.b("SPT callProviderGet:" + str + "_" + str2 + "_" + str3);
            Bundle bundle = new Bundle();
            bundle.putString("operation", str);
            bundle.putString("pref_name", this.f8344f);
            bundle.putString(Action.KEY_ATTRIBUTE, str2);
            bundle.putString("defult_value", str3);
            if (this.f8343e && !TextUtils.isEmpty(this.f8345g)) {
                return g.a(this.f8340b, "CallPreferences", bundle, this.f8345g);
            }
            return g.a(this.f8340b, "CallPreferences", bundle);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        throw new RuntimeException("This preference not allow to call contains.");
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        SharedPreferences.Editor editor = this.f8342d;
        if (editor != null) {
            return editor;
        }
        SharedPreferences sharedPreferences = this.f8339a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit();
        }
        return null;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new RuntimeException("This preference not allow to call getAll.");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z4) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (this.f8341c != 1 || (this.f8343e && !TextUtils.isEmpty(this.f8345g))) {
            Bundle bundleA = a("getBoolean", str, String.valueOf(z4));
            if (bundleA != null) {
                com.baidu.mshield.b.c.a.b("SPT getBoolean:return by resultBundle");
                return bundleA.getBoolean("result", z4);
            }
            return z4;
        }
        if (this.f8339a == null) {
            return z4;
        }
        com.baidu.mshield.b.c.a.b("SPT getBoolean:return by mBase");
        return this.f8339a.getBoolean(str, z4);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f4) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (this.f8341c != 1 || (this.f8343e && !TextUtils.isEmpty(this.f8345g))) {
            Bundle bundleA = a("getFloat", str, String.valueOf(f4));
            if (bundleA != null) {
                com.baidu.mshield.b.c.a.b("SPT getFloat:return by resultBundle");
                return bundleA.getFloat("result", f4);
            }
            return f4;
        }
        if (this.f8339a == null) {
            return f4;
        }
        com.baidu.mshield.b.c.a.b("SPT getFloat:return by mBase");
        return this.f8339a.getFloat(str, f4);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i4) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (this.f8341c != 1 || (this.f8343e && !TextUtils.isEmpty(this.f8345g))) {
            Bundle bundleA = a("getInt", str, String.valueOf(i4));
            if (bundleA != null) {
                com.baidu.mshield.b.c.a.b("SPT getInt:return by resultBundle");
                return bundleA.getInt("result", i4);
            }
            return i4;
        }
        if (this.f8339a == null) {
            return i4;
        }
        com.baidu.mshield.b.c.a.b("SPT getInt:return by mBase");
        return this.f8339a.getInt(str, i4);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j4) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (this.f8341c != 1 || (this.f8343e && !TextUtils.isEmpty(this.f8345g))) {
            Bundle bundleA = a("getLong", str, String.valueOf(j4));
            if (bundleA != null) {
                com.baidu.mshield.b.c.a.b("SPT getLong:return by resultBundle");
                return bundleA.getLong("result", j4);
            }
            return j4;
        }
        if (this.f8339a == null) {
            return j4;
        }
        com.baidu.mshield.b.c.a.b("SPT getLong:return by mBase");
        return this.f8339a.getLong(str, j4);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (this.f8341c != 1 || (this.f8343e && !TextUtils.isEmpty(this.f8345g))) {
            Bundle bundleA = a("getString", str, str2);
            if (bundleA != null) {
                com.baidu.mshield.b.c.a.b("SPT getString:return by resultBundle");
                return bundleA.getString("result", str2);
            }
            return str2;
        }
        if (this.f8339a == null) {
            return str2;
        }
        com.baidu.mshield.b.c.a.b("SPT getString:return by mBase");
        return this.f8339a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("This preference not allow to call getStringSet.");
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences sharedPreferences = this.f8339a;
            if (sharedPreferences != null) {
                sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences sharedPreferences = this.f8339a;
            if (sharedPreferences != null) {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z4, int i4, String str2) {
        this.f8340b = context;
        this.f8341c = i4;
        this.f8339a = sharedPreferences;
        this.f8342d = new b(context, sharedPreferences != null ? sharedPreferences.edit() : null, str, z4, this.f8341c, str2);
        this.f8343e = z4;
        this.f8344f = str;
        this.f8345g = str2;
    }
}
