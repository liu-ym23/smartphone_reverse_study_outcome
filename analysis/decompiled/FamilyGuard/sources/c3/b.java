package c3;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import d3.C0671g;
import g3.C0742e;
import java.util.HashMap;
import java.util.Map;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f11964a;

    /* renamed from: c3.b$b, reason: collision with other inner class name */
    public static class C0157b {

        /* renamed from: a, reason: collision with root package name */
        private Context f11965a = null;

        public C0157b b(Context context) {
            this.f11965a = context;
            return this;
        }

        public b c() {
            return new b(this);
        }
    }

    private void b(Context context) {
        String strD = C0671g.d(context);
        if (!TextUtils.isEmpty(strD)) {
            strD = strD.replace("\n", BuildConfig.FLAVOR).replace("\r", BuildConfig.FLAVOR);
        }
        d("country", strD);
    }

    private void c(String str, Object obj) {
        if (str == null || str.isEmpty() || obj == null) {
            return;
        }
        this.f11964a.put(str, obj);
    }

    private void d(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null) {
            return;
        }
        this.f11964a.put(str, str2);
    }

    private void e() {
        String strB = C0671g.b();
        if (!TextUtils.isEmpty(strB)) {
            strB = strB.replace("\n", BuildConfig.FLAVOR).replace("\r", BuildConfig.FLAVOR);
        }
        d("brand", strB);
    }

    private void f(Context context) {
        d("sre", C0671g.e(context));
    }

    private void g() {
        String strC = C0671g.c();
        if (!TextUtils.isEmpty(strC)) {
            strC = strC.replace("\n", BuildConfig.FLAVOR).replace("\r", BuildConfig.FLAVOR);
        }
        d("build_mask", strC);
    }

    private void h(Context context) {
        if (C0671g.m()) {
            c("ter_type", Integer.valueOf(S2.b.PAD.d()));
            return;
        }
        if (C0671g.j(context)) {
            c("ter_type", Integer.valueOf(S2.b.TV.d()));
        } else if (C0671g.n()) {
            c("ter_type", Integer.valueOf(S2.b.WEARABLE.d()));
        } else {
            c("ter_type", Integer.valueOf(S2.b.PHONE.d()));
        }
    }

    private void i() {
        String strReplace = Build.MODEL;
        if (!TextUtils.isEmpty(strReplace)) {
            strReplace = strReplace.replace("\n", BuildConfig.FLAVOR).replace("\r", BuildConfig.FLAVOR);
        }
        d("device", strReplace);
    }

    private void j() {
        C0742e.i("DeviceInfo", "setDevicePersonalInfo start");
        d("imsi1", O2.b.f());
        d("imsi2", O2.b.g());
        d("andro_id", O2.b.c());
        d("android_ad_id", O2.b.b());
        d("mac_address", O2.b.k());
        c("root", Boolean.valueOf(O2.b.q()));
        d("udid", O2.b.o());
        d("oaid", O2.b.l());
        d("vaid", O2.b.p());
        d("aaid", O2.b.a());
    }

    private void k() {
        c("international", Boolean.valueOf(C0671g.k()));
    }

    private void l() {
        d("os", "StepOS");
    }

    private void m() {
        d("os_type", "android");
    }

    private void n() {
        String strReplace = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(strReplace)) {
            strReplace = strReplace.replace("\n", BuildConfig.FLAVOR).replace("\r", BuildConfig.FLAVOR);
        }
        d("os_version", strReplace);
    }

    private void o() {
        String strI = C0671g.i();
        if (!TextUtils.isEmpty(strI)) {
            strI = strI.replace("\n", BuildConfig.FLAVOR).replace("\r", BuildConfig.FLAVOR);
        }
        d("product_model", strI);
    }

    public Map<String, Object> a() {
        return this.f11964a;
    }

    private b(C0157b c0157b) {
        this.f11964a = new HashMap<>();
        i();
        o();
        g();
        m();
        e();
        n();
        l();
        k();
        j();
        if (c0157b.f11965a != null) {
            b(c0157b.f11965a);
            f(c0157b.f11965a);
            h(c0157b.f11965a);
        }
        C0742e.k("DeviceInfo", "DeviceInfo created successfully.");
    }
}
