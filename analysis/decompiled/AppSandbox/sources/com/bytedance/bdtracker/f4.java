package com.bytedance.bdtracker;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.applog.util.SensitiveUtils;
import com.stepos.pps.data.util.Constants;

/* loaded from: classes.dex */
public abstract class f4 {
    public f4 a;
    public Handler b;

    public class a implements h<String> {
        public a() {
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a() {
            return f4.this.b("openudid");
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean b(String str) {
            return r.e(str);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean a(String str, String str2) {
            return r.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a(String str, String str2, f4 f4Var) {
            String str3 = str;
            return f4Var == null ? str3 : f4Var.d(str3, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public void a(String str) {
            f4.this.a("openudid", str);
        }
    }

    public class b implements h<String> {
        public b() {
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a() {
            return f4.this.b("clientudid");
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean b(String str) {
            return r.e(str);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean a(String str, String str2) {
            return r.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a(String str, String str2, f4 f4Var) {
            String str3 = str;
            return f4Var == null ? str3 : f4Var.b(str3, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public void a(String str) {
            f4.this.a("clientudid", str);
        }
    }

    public class c implements h<String> {
        public c() {
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a() {
            return f4.this.b("serial_number");
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean b(String str) {
            String str2 = str;
            return (TextUtils.isEmpty(str2) || TextUtils.equals(str2, Constants.UNKNOWN)) ? false : true;
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean a(String str, String str2) {
            return r.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a(String str, String str2, f4 f4Var) {
            String str3 = str;
            return f4Var == null ? str3 : f4Var.e(str3, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public void a(String str) {
            f4.this.a("serial_number", str);
        }
    }

    public class d implements h<String[]> {
        public d() {
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String[] a() {
            return f4.this.c("sim_serial_number");
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean b(String[] strArr) {
            String[] strArr2 = strArr;
            return strArr2 != null && strArr2.length > 0;
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean a(String[] strArr, String[] strArr2) {
            String[] strArr3 = strArr;
            String[] strArr4 = strArr2;
            if (strArr3 != strArr4) {
                if (strArr3 != null && strArr4 != null && strArr3.length == strArr4.length) {
                    for (String str : strArr3) {
                        boolean z = false;
                        for (String str2 : strArr4) {
                            z = r.a(str2, str) || z;
                        }
                        if (z) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String[] a(String[] strArr, String[] strArr2, f4 f4Var) {
            String[] strArr3 = strArr;
            return f4Var == null ? strArr3 : f4Var.a(strArr3, strArr2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public void a(String[] strArr) {
            f4.this.a("sim_serial_number", strArr);
        }
    }

    public class e implements h<String> {
        public e() {
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a() {
            return f4.this.b("udid");
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean b(String str) {
            return r.e(str);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean a(String str, String str2) {
            return r.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a(String str, String str2, f4 f4Var) {
            String str3 = str;
            return f4Var == null ? str3 : f4Var.f(str3, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public void a(String str) {
            f4.this.a("udid", str);
        }
    }

    public class f implements h<String> {
        public f() {
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a() {
            return f4.this.b("udid_list");
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean b(String str) {
            return SensitiveUtils.validMultiImei(str);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean a(String str, String str2) {
            return r.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a(String str, String str2, f4 f4Var) {
            String str3 = str;
            return f4Var == null ? str3 : f4Var.g(str3, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public void a(String str) {
            f4.this.a("udid_list", str);
        }
    }

    public class g implements h<String> {
        public g() {
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a() {
            return f4.this.b("device_id");
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean b(String str) {
            return !TextUtils.isEmpty(str);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public boolean a(String str, String str2) {
            return r.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public String a(String str, String str2, f4 f4Var) {
            String str3 = str;
            return f4Var == null ? str3 : f4Var.c(str3, str2);
        }

        @Override // com.bytedance.bdtracker.f4.h
        public void a(String str) {
            f4.this.a("device_id", str);
        }
    }

    public interface h<L> {
        L a();

        L a(L l, L l2, f4 f4Var);

        void a(L l);

        boolean a(L l, L l2);

        boolean b(L l);
    }

    public void a(String str) {
        f4 f4Var = this.a;
        if (f4Var != null) {
            f4Var.a(str);
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(String str, String[] strArr);

    public String[] a(String[] strArr, String[] strArr2) {
        return (String[]) a(strArr, strArr2, new d());
    }

    public abstract String b(String str);

    public String b(String str, String str2) {
        return (String) a(str, str2, new b());
    }

    public String c(String str, String str2) {
        return (String) a(str, str2, new g());
    }

    public abstract String[] c(String str);

    public String d(String str, String str2) {
        return (String) a(str, str2, new a());
    }

    public String e(String str, String str2) {
        return (String) a(str, str2, new c());
    }

    public String f(String str, String str2) {
        return (String) a(str, str2, new e());
    }

    public String g(String str, String str2) {
        return (String) a(str, str2, new f());
    }

    public final <T> T a(T t, T t2, h<T> hVar) {
        boolean z;
        if (hVar == null) {
            throw new IllegalArgumentException("agent == null");
        }
        f4 f4Var = this.a;
        T tA = hVar.a();
        boolean zB = hVar.b(t);
        boolean zB2 = hVar.b(tA);
        if (!zB && zB2) {
            t = tA;
        }
        if (f4Var != null) {
            T tA2 = hVar.a(t, t2, f4Var);
            if (!hVar.a(tA2, tA)) {
                hVar.a(tA2);
            }
            return tA2;
        }
        if (zB || zB2) {
            z = false;
            t2 = t;
        } else {
            z = true;
        }
        if ((z && hVar.b(t2)) || (zB && !hVar.a(t2, tA))) {
            hVar.a(t2);
        }
        return t2;
    }

    public void a(Handler handler) {
        f4 f4Var = this.a;
        if (f4Var != null) {
            f4Var.a(handler);
        }
        this.b = handler;
    }
}
