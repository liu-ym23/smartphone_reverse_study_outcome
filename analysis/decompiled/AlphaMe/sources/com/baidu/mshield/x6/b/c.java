package com.baidu.mshield.x6.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.x6.f.f;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f8476a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f8477b;

    public c(Context context) {
        try {
            SharedPreferences platformSharedSharedPreferences = F.getInstance().getPlatformSharedSharedPreferences(context);
            this.f8476a = platformSharedSharedPreferences;
            this.f8477b = platformSharedSharedPreferences.edit();
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public void a(String str) {
        this.f8477b.putString("xytk", str);
        this.f8477b.commit();
    }

    public String b() {
        return this.f8476a.getString("xytk", "");
    }

    public String c() {
        return this.f8476a.getString("xytk2", "");
    }

    public void d(String str) {
        this.f8477b.putString("xytkrt", str);
        this.f8477b.commit();
    }

    public String e() {
        return this.f8476a.getString("xytk_m", "");
    }

    public String f() {
        return this.f8476a.getString("xytkrt", "");
    }

    public void b(String str) {
        this.f8477b.putString("xytk2", str);
        this.f8477b.commit();
    }

    public void c(String str) {
        this.f8477b.putString("xytkrt2", str);
        this.f8477b.commit();
    }

    public String a() {
        return this.f8476a.getString("wmcudd", "");
    }

    public String d() {
        return this.f8476a.getString("xytkrt2", "");
    }
}
