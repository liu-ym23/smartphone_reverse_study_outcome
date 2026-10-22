package com.baidu.mshield.utility;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.stepos.activeview.utils.Constants;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f8359a = {"On7h9W1_KIkIa50wk9Fnl1friw1cdOsubmr_O-Hrgss=", "73Ry_SRX9WDHPoeAkGWfJbuntGR7RQ3rde1s6KyyCoo=", "iQirV45vitYDQfzxgr68ylBY1DWLBKje2Pl428sE27Q=", "czwe2zUrt14MfnaeH474T5prOCIik3agOnBud_KwFa0=", "JzLix2JtXzSSsVkQFD0Cnf37028Rco5rGb7_-t_C8Qk=", "lUApGLCwwTIqYrpC4ZaqkVItjc8DeoJ5fB_pxizrjnc=", "6PzPHS4JINi0q8yUj180JTMbpq1Q44DuQggknxVmVPA=", "fCbyLrInjq1BOByP4wH4mUGBidquiIKIy6zcJCBuKtk=", "qEeaB7chq_oSIUyWhq_EwETFQIu3w3myIFyGD80p_u8=", "UNzyljxPfmKANfePasqvdfmpLS4aJ1v0S1Aj2BGl75o=", "8aRmj9NoeaLTFLe54rCmNLYIZoWE7hrVdjvM3xBfHQ4=", "WtGvBTWjt2PyMX5rQclkgiNR3aDxFtoBNe1UnNpbL1I="};

    public static Bundle a(Context context, String str, Bundle bundle) {
        return a(context, str, bundle, "mshield");
    }

    public static Bundle a(Context context, String str, Bundle bundle, boolean z4, String str2, boolean z5) {
        ProviderInfo[] providerInfoArr;
        String str3;
        try {
            try {
                providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
            } catch (Throwable th) {
                a.a(th);
                providerInfoArr = null;
            }
        } catch (Throwable th2) {
            a.a(th2);
        }
        if (providerInfoArr != null && providerInfoArr.length > 0) {
            boolean z6 = false;
            for (String str4 : f8359a) {
                try {
                    str3 = new String(com.baidu.mshield.b.f.d.a(Base64.decode(str4, 10), com.baidu.mshield.b.f.a.a(16)), Constants.UTF_8_CODE);
                } catch (Throwable th3) {
                    a.a(th3);
                    str3 = null;
                }
                if (!TextUtils.isEmpty(str3)) {
                    if ("mshield".equals(str3)) {
                        if (!z4) {
                            return null;
                        }
                        z6 = true;
                    }
                    StringBuilder sb = new StringBuilder("content://");
                    sb.append(context.getPackageName());
                    sb.append(".");
                    sb.append(str3);
                    sb.append(".ac.provider");
                    String string = sb.toString();
                    com.baidu.mshield.b.c.a.b("request targetUri=" + string);
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        String str5 = providerInfo.authority;
                        com.baidu.mshield.b.c.a.b("request authority=" + str5);
                        if (string.contains(str5)) {
                            Bundle bundleA = a(context, str, bundle, Uri.parse(sb.toString()));
                            if (!z5) {
                                return bundleA;
                            }
                            boolean z7 = bundleA.getBoolean("handle_flag");
                            String string2 = bundleA.getString("server_version");
                            if (z7) {
                                if (a(string2, str2)) {
                                    return bundleA;
                                }
                            }
                        }
                    }
                    if (z6) {
                        break;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static Bundle a(Context context, String str, Bundle bundle, String str2) {
        try {
            context.getApplicationContext().getContentResolver();
            return a(context, str, bundle, Uri.parse("content://" + context.getPackageName() + "." + str2 + ".ac.provider"));
        } catch (Throwable th) {
            a.a(th);
            return null;
        }
    }

    public static Bundle a(Context context, String str, Bundle bundle, Uri uri) {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        try {
            try {
                contentProviderClientAcquireUnstableContentProviderClient = context.getApplicationContext().getContentResolver().acquireUnstableContentProviderClient(uri);
                try {
                    Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call(str, null, bundle);
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                    return bundleCall;
                } catch (Throwable th) {
                    th = th;
                    try {
                        a.a(th);
                        return null;
                    } finally {
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                contentProviderClientAcquireUnstableContentProviderClient = null;
            }
        } catch (Throwable th3) {
            a.a(th3);
            return null;
        }
    }

    public static boolean a(String str, String str2) {
        try {
            if (str.equals(str2)) {
                return true;
            }
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            for (int i4 = 0; i4 < strArrSplit.length && i4 < strArrSplit2.length; i4++) {
                int iIntValue = Integer.valueOf(strArrSplit[i4]).intValue() - Integer.valueOf(strArrSplit2[i4]).intValue();
                if (iIntValue != 0) {
                    return iIntValue > 0;
                }
            }
            return strArrSplit.length > strArrSplit2.length;
        } catch (Throwable unused) {
            return false;
        }
    }
}
