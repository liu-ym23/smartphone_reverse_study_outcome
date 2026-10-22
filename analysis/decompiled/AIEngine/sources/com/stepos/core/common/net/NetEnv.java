package com.stepos.core.common.net;

import android.content.Context;
import android.provider.Settings;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NetEnv {
    private static final String DEV_HOST = "d-stepos.com";
    public static final NetEnv INSTANCE = new NetEnv();
    public static final String PROD_HOST = "stepaos.com";
    private static final String STG_HOST = "s-stepos.com";
    private static final String TEST_HOST = "t-stepos.com";

    private NetEnv() {
    }

    public final String host(Context context) {
        g.f(context, "context");
        String strRawNetEnv = rawNetEnv(context);
        switch (strRawNetEnv.hashCode()) {
            case 99349:
                return !strRawNetEnv.equals("dev") ? PROD_HOST : DEV_HOST;
            case 114214:
                return !strRawNetEnv.equals("stg") ? PROD_HOST : STG_HOST;
            case 3449687:
                strRawNetEnv.equals("prod");
                return PROD_HOST;
            case 3556498:
                return !strRawNetEnv.equals("test") ? PROD_HOST : TEST_HOST;
            default:
                return PROD_HOST;
        }
    }

    public final boolean isTest(Context context) {
        g.f(context, "context");
        return g.b(rawNetEnv(context), "test");
    }

    public final String rawNetEnv(Context context) {
        Object objA;
        g.f(context, "context");
        try {
            objA = Settings.Secure.getString(context.getContentResolver(), "net_env");
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str = (String) objA;
        return str == null ? "" : str;
    }
}
