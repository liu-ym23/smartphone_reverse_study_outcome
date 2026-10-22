package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import ch.qos.logback.core.joran.action.Action;
import com.baidu.mshield.utility.g;
import java.util.Set;

/* loaded from: classes.dex */
public class b implements SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences.Editor f8333a;

    /* renamed from: b, reason: collision with root package name */
    public Context f8334b;

    /* renamed from: c, reason: collision with root package name */
    public int f8335c;

    /* renamed from: d, reason: collision with root package name */
    public String f8336d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8337e;

    /* renamed from: f, reason: collision with root package name */
    public String f8338f;

    public b(Context context, SharedPreferences.Editor editor, String str, boolean z4, int i4, String str2) {
        this.f8334b = context;
        this.f8333a = editor;
        this.f8335c = i4;
        this.f8336d = str;
        this.f8337e = z4;
        this.f8338f = str2;
    }

    public final Bundle a(Bundle bundle) {
        try {
            com.baidu.mshield.b.c.a.b("SPT callProviderPut:" + bundle);
            bundle.putString("pref_name", this.f8336d);
            if (this.f8337e && !TextUtils.isEmpty(this.f8338f)) {
                return g.a(this.f8334b, "CallPreferences", bundle, this.f8338f);
            }
            return g.a(this.f8334b, "CallPreferences", bundle);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        SharedPreferences.Editor editor;
        if (this.f8335c == 1) {
            if ((!this.f8337e || TextUtils.isEmpty(this.f8338f)) && (editor = this.f8333a) != null) {
                editor.apply();
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        throw new RuntimeException("This editor not allow to call clear.");
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        SharedPreferences.Editor editor;
        if (this.f8335c != 1 || ((this.f8337e && !TextUtils.isEmpty(this.f8338f)) || (editor = this.f8333a) == null)) {
            return true;
        }
        return editor.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z4) {
        try {
            if (this.f8335c != 1 || (this.f8337e && !TextUtils.isEmpty(this.f8338f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putBoolean");
                bundle.putString(Action.KEY_ATTRIBUTE, str);
                bundle.putBoolean("value", z4);
                a(bundle);
            } else {
                if (this.f8333a == null) {
                    return this;
                }
                com.baidu.mshield.b.c.a.b("SPT putBoolean:put by mBase");
                SharedPreferences.Editor editor = this.f8333a;
                if (editor != null) {
                    editor.putBoolean(str, z4);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f4) {
        try {
            if (this.f8335c != 1 || (this.f8337e && !TextUtils.isEmpty(this.f8338f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putFloat");
                bundle.putString(Action.KEY_ATTRIBUTE, str);
                bundle.putFloat("value", f4);
                a(bundle);
            } else {
                if (this.f8333a == null) {
                    return this;
                }
                com.baidu.mshield.b.c.a.b("SPT putFloat:put by mBase");
                SharedPreferences.Editor editor = this.f8333a;
                if (editor != null) {
                    editor.putFloat(str, f4);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i4) {
        try {
            if (this.f8335c != 1 || (this.f8337e && !TextUtils.isEmpty(this.f8338f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putInt");
                bundle.putString(Action.KEY_ATTRIBUTE, str);
                bundle.putInt("value", i4);
                a(bundle);
            } else {
                if (this.f8333a == null) {
                    return this;
                }
                com.baidu.mshield.b.c.a.b("SPT putInt:put by mBase");
                SharedPreferences.Editor editor = this.f8333a;
                if (editor != null) {
                    editor.putInt(str, i4);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j4) {
        try {
            if (this.f8335c != 1 || (this.f8337e && !TextUtils.isEmpty(this.f8338f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putLong");
                bundle.putString(Action.KEY_ATTRIBUTE, str);
                bundle.putLong("value", j4);
                a(bundle);
            } else {
                if (this.f8333a == null) {
                    return this;
                }
                com.baidu.mshield.b.c.a.b("SPT putLong:put by mBase");
                SharedPreferences.Editor editor = this.f8333a;
                if (editor != null) {
                    editor.putLong(str, j4);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        try {
            if (this.f8335c != 1 || (this.f8337e && !TextUtils.isEmpty(this.f8338f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putString");
                bundle.putString(Action.KEY_ATTRIBUTE, str);
                bundle.putString("value", str2);
                a(bundle);
            } else {
                if (this.f8333a == null) {
                    return this;
                }
                com.baidu.mshield.b.c.a.b("SPT putString:put by mBase");
                SharedPreferences.Editor editor = this.f8333a;
                if (editor != null) {
                    editor.putString(str, str2);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        throw new RuntimeException("This editor not allow to call putStringSet.");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        throw new RuntimeException("This editor not allow to call remove.");
    }
}
