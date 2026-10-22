package com.stepos.statsapp.v3.lib.plugin.tracker.subject;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f30990b = "AppInfo";

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f30991a;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Context f30992a = null;

        public b a(Context context) {
            this.f30992a = context;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    private String a(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                return (applicationInfo == null || (bundle = applicationInfo.metaData) == null || bundle.get("uxip_channel_num") == null) ? "0" : String.valueOf(applicationInfo.metaData.get("uxip_channel_num"));
            } catch (PackageManager.NameNotFoundException e10) {
                Logger.w(f30990b, "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
            }
        }
        return "0";
    }

    private void b(Context context) {
        a(Parameters.CHANNEL_ID, a(context));
    }

    public void c(Context context) {
    }

    private a(b bVar) {
        this.f30991a = new HashMap<>();
        b(bVar.f30992a);
        if (bVar.f30992a != null) {
            c(bVar.f30992a);
        }
        Logger.v(f30990b, "AppInfo created successfully.");
    }

    private void a(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null) {
            return;
        }
        this.f30991a.put(str, str2);
    }

    private void a(String str, Object obj) {
        if (str == null || str.isEmpty() || obj == null) {
            return;
        }
        this.f30991a.put(str, obj);
    }

    public Map<String, Object> a() {
        return this.f30991a;
    }
}
