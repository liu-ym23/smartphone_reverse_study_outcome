package P2;

import B0.g;
import T2.d;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import j.C0622a;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1574a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1575b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(C0622a c0622a, int i4) {
        this(c0622a);
        this.f1574a = 0;
    }

    public final HashMap a() {
        switch (this.f1574a) {
        }
        return this.f1575b;
    }

    public final void b(String str, String str2) {
        switch (this.f1574a) {
            case 0:
                if (!str.isEmpty() && str2 != null) {
                    this.f1575b.put(str, str2);
                    break;
                }
                break;
            default:
                if (!str.isEmpty() && str2 != null) {
                    this.f1575b.put(str, str2);
                    break;
                }
                break;
        }
    }

    public final void c(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str;
        switch (this.f1574a) {
            case 0:
                PackageManager packageManager = context.getPackageManager();
                String strValueOf = "0";
                if (packageManager != null) {
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.get("uxip_channel_num") != null) {
                            strValueOf = String.valueOf(applicationInfo.metaData.get("uxip_channel_num"));
                        }
                    } catch (PackageManager.NameNotFoundException e4) {
                        d.f("AppInfo", "Exception: " + e4.toString() + " - Cause: " + e4.getCause());
                    }
                }
                b("channel_id", strValueOf);
                break;
            default:
                if (TextUtils.isEmpty(Q2.c.f1650c)) {
                    try {
                        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                        if (defaultDisplay != null) {
                            Point point = new Point();
                            defaultDisplay.getSize(point);
                            Q2.c.f1650c = point.x + "." + point.y;
                        }
                    } catch (Exception e5) {
                        d.b("StepOSUtils", "getDisplaySize error, " + e5.getMessage());
                    }
                    str = Q2.c.f1650c;
                } else {
                    str = Q2.c.f1650c;
                }
                b("sre", str);
                break;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(C0622a c0622a, Object obj) {
        this(c0622a, (g) null);
        this.f1574a = 1;
    }

    public a(C0622a c0622a) throws PackageManager.NameNotFoundException {
        boolean z4 = false;
        this.f1574a = 0;
        this.f1575b = new HashMap();
        c(c0622a.f13046b);
        if (c0622a.f13046b != null) {
            switch (z4) {
                case false:
                    break;
                default:
                    this.f1575b.put("ter_type", 1);
                    break;
            }
        }
        d.e("AppInfo", "AppInfo created successfully.");
    }

    public a(C0622a c0622a, g gVar) throws PackageManager.NameNotFoundException {
        String str;
        boolean zBooleanValue;
        String str2;
        this.f1574a = 1;
        this.f1575b = new HashMap();
        String str3 = Build.MODEL;
        b("device", !TextUtils.isEmpty(str3) ? str3.replace("\n", "").replace("\r", "") : str3);
        b("product_model", TextUtils.isEmpty(str3) ? str3 : str3.replace("\n", "").replace("\r", ""));
        if (TextUtils.isEmpty(Q2.c.f1649b)) {
            Q2.c.f1649b = com.stepos.statsrpk.c.t("ro.build.mask.id");
        }
        String str4 = Q2.c.f1649b;
        b("build_mask", TextUtils.isEmpty(str4) ? str4 : str4.replace("\n", "").replace("\r", ""));
        b("os_type", "android");
        if (!TextUtils.isEmpty(Q2.c.f1651d)) {
            str = Q2.c.f1651d;
        } else {
            String strU = com.stepos.statsrpk.c.u("ro.product.other.brand", "unknown");
            if ("unknown".equals(strU)) {
                Q2.c.f1651d = Build.BRAND;
            } else {
                Q2.c.f1651d = strU;
            }
            str = Q2.c.f1651d;
        }
        b("brand", TextUtils.isEmpty(str) ? str : str.replace("\n", "").replace("\r", ""));
        String str5 = Build.VERSION.RELEASE;
        b("os_version", TextUtils.isEmpty(str5) ? str5 : str5.replace("\n", "").replace("\r", ""));
        b("os", "StepOS");
        if (Q2.c.f1656i != null) {
            d.a("StepOSUtils", "isInternational = " + Q2.c.f1656i);
            zBooleanValue = Q2.c.f1656i.booleanValue();
        } else {
            try {
                Q2.c.f1656i = Boolean.valueOf(("zh".equalsIgnoreCase(com.stepos.statsrpk.c.t("ro.product.locale.language")) && "CN".equalsIgnoreCase(com.stepos.statsrpk.c.t("ro.product.locale.region")) && !"zh-CN".equalsIgnoreCase(com.stepos.statsrpk.c.t("ro.product.locale"))) ? false : true);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            zBooleanValue = Q2.c.f1656i.booleanValue();
        }
        this.f1575b.put("international", Boolean.valueOf(zBooleanValue));
        d.d("DeviceInfo", "setDevicePersonalInfo start");
        b("imsi1", "");
        b("imsi2", "");
        b("andro_id", "");
        b("android_ad_id", "");
        b("mac_address", "");
        this.f1575b.put("root", Boolean.FALSE);
        b("udid", "");
        b("oaid", "");
        b("vaid", "");
        b("aaid", "");
        Context context = c0622a.f13046b;
        if (context != null) {
            if (!TextUtils.isEmpty(Q2.c.f1652e)) {
                str2 = Q2.c.f1652e;
            } else {
                try {
                    if (context.getResources().getConfiguration() != null && context.getResources().getConfiguration().locale != null) {
                        Q2.c.f1652e = context.getResources().getConfiguration().locale.getCountry();
                    }
                } catch (Exception e5) {
                    d.b("StepOSUtils", "Exception: " + e5.getMessage() + " - Cause: " + e5.getCause());
                }
                str2 = Q2.c.f1652e;
            }
            b("country", TextUtils.isEmpty(str2) ? str2 : str2.replace("\n", "").replace("\r", ""));
            c(c0622a.f13046b);
            switch (this.f1574a) {
                case 0:
                    break;
                default:
                    this.f1575b.put("ter_type", 1);
                    break;
            }
        }
        d.e("DeviceInfo", "DeviceInfo created successfully.");
    }
}
