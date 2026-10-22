package c3;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import g3.C0742e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: c3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0583a {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f11962a;

    /* renamed from: c3.a$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Context f11963a = null;

        public b b(Context context) {
            this.f11963a = context;
            return this;
        }

        public C0583a c() {
            return new C0583a(this);
        }
    }

    private String a(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                return (applicationInfo == null || (bundle = applicationInfo.metaData) == null || bundle.get("uxip_channel_num") == null) ? "0" : String.valueOf(applicationInfo.metaData.get("uxip_channel_num"));
            } catch (PackageManager.NameNotFoundException e6) {
                C0742e.l("AppInfo", "Exception: " + e6.toString() + " - Cause: " + e6.getCause());
            }
        }
        return "0";
    }

    private void c(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null) {
            return;
        }
        this.f11962a.put(str, str2);
    }

    private void d(Context context) {
        c("channel_id", a(context));
    }

    public Map<String, Object> b() {
        return this.f11962a;
    }

    public void e(Context context) {
    }

    private C0583a(b bVar) {
        this.f11962a = new HashMap<>();
        d(bVar.f11963a);
        if (bVar.f11963a != null) {
            e(bVar.f11963a);
        }
        C0742e.k("AppInfo", "AppInfo created successfully.");
    }
}
