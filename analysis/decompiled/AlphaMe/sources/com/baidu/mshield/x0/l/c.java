package com.baidu.mshield.x0.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.x0.d.d;
import com.stepos.activeview.utils.Constants;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f8446a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f8447b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f8448c;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f8449d;

    public c(Context context) {
        try {
            SharedPreferences platformSharedSharedPreferences = F.getInstance().getPlatformSharedSharedPreferences(context);
            this.f8446a = platformSharedSharedPreferences;
            this.f8447b = platformSharedSharedPreferences.edit();
            SharedPreferences platformPrivateSharedPreferences = F.getInstance().getPlatformPrivateSharedPreferences(context);
            this.f8448c = platformPrivateSharedPreferences;
            this.f8449d = platformPrivateSharedPreferences.edit();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public String a() {
        return this.f8446a.getString("s_h_d_id", "");
    }

    public String b() {
        return this.f8446a.getString("rpnewuid", "");
    }

    public String c() {
        String string = this.f8446a.getString("rpnewuidn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.mshield.b.f.a.a(Base64.decode(string, 10), com.baidu.mshield.b.f.a.a(24)), Constants.UTF_8_CODE);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public String d() {
        return this.f8446a.getString("xytk", "");
    }

    public void e(String str) {
        this.f8447b.putString("xytk2", str);
        this.f8447b.apply();
    }

    public void f(String str) {
        this.f8447b.putString("sgud", str);
        this.f8447b.commit();
    }

    public void a(String str) {
        this.f8447b.putString("rpnewuid", str);
        this.f8447b.commit();
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f8447b.putString("rpnewuidn", "");
            this.f8447b.commit();
            return;
        }
        try {
            this.f8447b.putString("rpnewuidn", new String(Base64.encode(com.baidu.mshield.b.f.a.b(str.getBytes(Constants.UTF_8_CODE), com.baidu.mshield.b.f.a.a(24)), 10), Constants.UTF_8_CODE));
            this.f8447b.commit();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void d(String str) {
        this.f8447b.putString("xytk", str);
        this.f8447b.apply();
    }

    public String e() {
        return this.f8446a.getString("xytk2", "");
    }

    public String f() {
        return this.f8446a.getString("sgud", "");
    }

    public void c(String str) {
        this.f8449d.putString("p_s_p_c", str);
        this.f8449d.commit();
    }
}
