package w7;

import android.content.Context;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {
    public static long a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.stepos.pushservice", 0).getLongVersionCode();
        } catch (Exception e10) {
            s7.a.c("AppUtils", "getAppVersionCode error: " + e10.getMessage());
            return 0L;
        }
    }
}
