package com.baidu.sec.privacy.e;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;

/* loaded from: classes.dex */
public class a implements com.baidu.sec.privacy.b.a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f9422a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f9423b;

    /* renamed from: c, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<String> f9424c;

    /* renamed from: d, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<Integer> f9425d;

    /* renamed from: e, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<Integer> f9426e;

    /* renamed from: f, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<String> f9427f;

    /* renamed from: g, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<String> f9428g;

    /* renamed from: h, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<String> f9429h;

    /* renamed from: i, reason: collision with root package name */
    public com.baidu.sec.privacy.e.d.a<String> f9430i;

    /* renamed from: com.baidu.sec.privacy.e.a$a, reason: collision with other inner class name */
    public class C0052a implements com.baidu.sec.privacy.e.d.a<String> {
        public C0052a() {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, Object... objArr) {
            return (String) a.this.d(str);
        }
    }

    public class b implements com.baidu.sec.privacy.e.d.a<Integer> {
        public b() {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(String str, Object... objArr) {
            return (Integer) a.this.d(str);
        }
    }

    public class c implements com.baidu.sec.privacy.e.d.a<Integer> {
        public c(a aVar) {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(String str, Object... objArr) {
            return (Integer) a.c(str);
        }
    }

    public class d implements com.baidu.sec.privacy.e.d.a<String> {
        public d() {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, Object... objArr) {
            return a.this.f();
        }
    }

    public class e implements com.baidu.sec.privacy.e.d.a<String> {
        public e() {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, Object... objArr) {
            return a.this.e();
        }
    }

    public class f implements com.baidu.sec.privacy.e.d.a<String> {
        public f() {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, Object... objArr) {
            return a.this.d();
        }
    }

    public class g implements com.baidu.sec.privacy.e.d.a<String> {
        public g(a aVar) {
        }

        @Override // com.baidu.sec.privacy.e.d.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str, Object... objArr) {
            return Build.MANUFACTURER;
        }
    }

    public a(Context context) {
        f9423b = context;
    }

    public final Object d(String str) {
        try {
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("&&");
        if (strArrSplit.length != 2) {
            return null;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        if ("1".equals(str2)) {
            return h(str3);
        }
        if ("2".equals(str2)) {
            return Integer.valueOf(f(str3));
        }
        return null;
    }

    public final int e(String str) {
        try {
            return Settings.Secure.getInt(f9423b.getContentResolver(), str);
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public final int f(String str) {
        try {
            return Settings.System.getInt(f9423b.getContentResolver(), str);
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public boolean g() {
        if (com.baidu.sec.privacy.f.c.d(f9423b)) {
            return true;
        }
        return com.baidu.sec.privacy.d.a.a();
    }

    public final String h(String str) {
        try {
            return Settings.System.getString(f9423b.getContentResolver(), str);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return "";
        }
    }

    public String c(String str, boolean z4) {
        return c(str, z4, false);
    }

    public final String e() {
        return com.baidu.sec.privacy.f.b.a(f9423b);
    }

    public final String f() {
        return com.baidu.sec.privacy.f.b.b(f9423b);
    }

    public static a a(Context context) {
        if (f9422a == null) {
            synchronized (a.class) {
                f9422a = new a(context);
            }
        }
        return f9422a;
    }

    public int b(String str, boolean z4) {
        return b(str, z4, false);
    }

    public String c(String str, boolean z4, boolean z5) {
        if (z4) {
            if (this.f9424c == null) {
                this.f9424c = new C0052a();
            }
            return com.baidu.sec.privacy.f.f.a(f9423b, 42, B0.g.m("1&&", str), z5, this.f9424c, new Object[0]);
        }
        if (com.baidu.sec.privacy.f.f.a(f9423b, 42)) {
            return h(str);
        }
        return com.baidu.sec.privacy.f.f.a(f9423b, z5);
    }

    public final String g(String str) {
        try {
            return Settings.Secure.getString(f9423b.getContentResolver(), str);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return "";
        }
    }

    public int b(String str, boolean z4, boolean z5) {
        if (z4) {
            if (this.f9425d == null) {
                this.f9425d = new b();
            }
            return com.baidu.sec.privacy.f.f.a(f9423b, 42, B0.g.m("2&&", str), -1, z5, this.f9425d, new Object[0]);
        }
        if (com.baidu.sec.privacy.f.f.a(f9423b, 42)) {
            return f(str);
        }
        return com.baidu.sec.privacy.f.f.a(f9423b, -1, z5);
    }

    @Override // com.baidu.sec.privacy.b.a
    public boolean a() {
        return com.baidu.sec.privacy.d.b.b(com.baidu.sec.privacy.d.a.f9412e);
    }

    @Override // com.baidu.sec.privacy.b.a
    public File a(String str) {
        try {
            if (com.baidu.sec.privacy.f.f.a(f9423b, 44)) {
                return new File(str);
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return null;
        }
    }

    public final String d() {
        try {
            return com.baidu.sec.privacy.f.d.b(f9423b);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return "";
        }
    }

    @Override // com.baidu.sec.privacy.b.a
    public Class a(ClassLoader classLoader, String str) throws ClassNotFoundException {
        if (com.baidu.sec.privacy.f.f.a(f9423b, 54)) {
            return classLoader.loadClass(str);
        }
        return null;
    }

    public boolean a(String str, String str2) {
        try {
            if (com.baidu.sec.privacy.f.f.a(f9423b, 42) && com.baidu.sec.privacy.f.e.a(f9423b, new String[]{"android.permission.WRITE_SETTINGS"})) {
                return Settings.System.putString(f9423b.getContentResolver(), str, str2);
            }
            return false;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return false;
        }
    }

    public static Object c(String str) {
        try {
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("&&");
        if (strArrSplit.length != 2) {
            return null;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        if ("1".equals(str2)) {
            return a(com.baidu.sec.privacy.b.b.a()).g(str3);
        }
        if ("2".equals(str2)) {
            return Integer.valueOf(a(com.baidu.sec.privacy.b.b.a()).e(str3));
        }
        return null;
    }

    public String b(boolean z4) {
        if (this.f9427f == null) {
            this.f9427f = new d();
        }
        return com.baidu.sec.privacy.f.f.a(f9423b, 7, z4, this.f9427f, new Object[0]);
    }

    public int a(String str, boolean z4) {
        return a(str, z4, false);
    }

    public int a(String str, boolean z4, boolean z5) {
        if (z4) {
            if (this.f9426e == null) {
                this.f9426e = new c(this);
            }
            return com.baidu.sec.privacy.f.f.a(f9423b, 48, B0.g.m("2&&", str), -1, z5, this.f9426e, new Object[0]);
        }
        if (com.baidu.sec.privacy.f.f.a(f9423b, 48)) {
            return e(str);
        }
        return com.baidu.sec.privacy.f.f.a(f9423b, -1, z5);
    }

    public String b() {
        if (this.f9430i == null) {
            this.f9430i = new g(this);
        }
        return com.baidu.sec.privacy.f.f.a(f9423b, 71, false, this.f9430i, new Object[0]);
    }

    public Pair<String, String> c() {
        if (this.f9429h == null) {
            this.f9429h = new f();
        }
        String strA = com.baidu.sec.privacy.f.f.a(f9423b, 64, false, this.f9429h, new Object[0]);
        String str = "";
        if (com.baidu.sec.privacy.f.f.a("64")) {
            str = "" + com.baidu.sec.privacy.d.a.a("64la_in", 0L);
        }
        return new Pair<>(strA, str);
    }

    public String a(boolean z4) {
        if (this.f9428g == null) {
            this.f9428g = new e();
        }
        return com.baidu.sec.privacy.f.f.a(f9423b, 8, z4, this.f9428g, new Object[0]);
    }
}
