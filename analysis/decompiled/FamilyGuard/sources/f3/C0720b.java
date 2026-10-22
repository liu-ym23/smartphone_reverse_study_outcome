package f3;

import android.content.Context;
import android.content.SharedPreferences;
import g3.C0742e;
import java.util.Map;
import java.util.Set;

/* renamed from: f3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0720b {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f16803a;

    public C0720b(Context context, String str) {
        C0742e.i("SharedPreferencesHelper", "init SharedPreferences, name: " + str);
        this.f16803a = context.getSharedPreferences(str, 0);
        C0742e.c("SharedPreferencesHelper", str + " structure complete");
    }

    public void a(String str, String str2) {
        this.f16803a.edit().putString(str, str2).apply();
    }

    public void b(String str) {
        this.f16803a.edit().remove(str).apply();
    }

    public void c() {
        this.f16803a.edit().clear().commit();
    }

    public void d(String str, long j5) {
        this.f16803a.edit().putLong(str, j5).commit();
    }

    public void e(String str, String str2) {
        this.f16803a.edit().putString(str, str2).commit();
    }

    public void f(String str, boolean z5) {
        this.f16803a.edit().putBoolean(str, z5).commit();
    }

    public void g(String str) {
        this.f16803a.edit().remove(str).commit();
    }

    public SharedPreferences.Editor h() {
        return this.f16803a.edit();
    }

    public Set<? extends Map.Entry<String, ?>> i() {
        return this.f16803a.getAll().entrySet();
    }

    public int j() {
        return this.f16803a.getAll().size();
    }

    public int k(String str, int i5) {
        return this.f16803a.getInt(str, i5);
    }

    public long l(String str, long j5) {
        return this.f16803a.getLong(str, j5);
    }

    public String m(String str, String str2) {
        return this.f16803a.getString(str, str2);
    }

    public boolean n(String str, boolean z5) {
        return this.f16803a.getBoolean(str, z5);
    }
}
