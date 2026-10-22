package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.col.jmsl.C1569j2;
import com.amap.api.services.core.ServiceSettings;

/* loaded from: classes.dex */
public class T2 {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f16359a = {"com.amap.api.services", "com.amap.api.search.admic"};

    public static C1569j2 a(boolean z10) {
        try {
            return new C1569j2.a("sea", "9.8.1", "AMAP SDK Android Search 9.8.1").c(f16359a).b(z10).a("9.8.1").d();
        } catch (g5 e10) {
            C1631z1.o(e10, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }

    public static String b(Context context) {
        C1532a1 c1532a1C = C1532a1.c(context);
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://" + c1532a1C.a(62);
        }
        return "https://" + c1532a1C.a(62);
    }

    public static String c(Context context) {
        int protocol = ServiceSettings.getInstance().getProtocol();
        C1532a1 c1532a1C = C1532a1.c(context);
        if (protocol == 1) {
            return "http://" + c1532a1C.a(60) + "/v3";
        }
        return "https://" + c1532a1C.a(60) + "/v3";
    }

    public static String d(Context context) {
        C1532a1 c1532a1C = C1532a1.c(context);
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://" + c1532a1C.a(60) + "/v4";
        }
        return "https://" + c1532a1C.a(60) + "/v4";
    }

    public static String e(Context context) {
        ServiceSettings serviceSettings = ServiceSettings.getInstance();
        C1532a1 c1532a1C = C1532a1.c(context);
        if (serviceSettings.getProtocol() == 1) {
            return "http://" + c1532a1C.a(60) + "/v5";
        }
        return "https://" + c1532a1C.a(60) + "/v5";
    }

    public static String f(Context context) {
        C1532a1 c1532a1C = C1532a1.c(context);
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://" + c1532a1C.a(60) + "/rest/me/cpoint";
        }
        return "https://" + c1532a1C.a(60) + "/rest/me/cpoint";
    }

    public static String g(Context context) {
        C1532a1 c1532a1C = C1532a1.c(context);
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://" + c1532a1C.a(61);
        }
        return "https://" + c1532a1C.a(61);
    }
}
