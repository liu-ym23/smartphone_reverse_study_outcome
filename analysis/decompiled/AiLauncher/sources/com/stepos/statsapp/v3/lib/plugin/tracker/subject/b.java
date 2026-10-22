package com.stepos.statsapp.v3.lib.plugin.tracker.subject;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.stepos.personal.info.PersonalInfoHelper;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.utils.StepOSUtils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f30993b = "DeviceInfo";

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f30994a;

    /* renamed from: com.stepos.statsapp.v3.lib.plugin.tracker.subject.b$b, reason: collision with other inner class name */
    public static class C0372b {

        /* renamed from: a, reason: collision with root package name */
        private Context f30995a = null;

        public C0372b a(Context context) {
            this.f30995a = context;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private void a(Context context) {
        String country = StepOSUtils.getCountry(context);
        if (!TextUtils.isEmpty(country)) {
            country = country.replace("\n", "").replace("\r", "");
        }
        a("country", country);
    }

    private void b(Context context) {
        a(Parameters.SRE, StepOSUtils.getDisplaySize(context));
    }

    private void c() {
        String buildMask = StepOSUtils.getBuildMask();
        if (!TextUtils.isEmpty(buildMask)) {
            buildMask = buildMask.replace("\n", "").replace("\r", "");
        }
        a(Parameters.BUILD_MASK, buildMask);
    }

    private void d() {
        String strReplace = Build.MODEL;
        if (!TextUtils.isEmpty(strReplace)) {
            strReplace = strReplace.replace("\n", "").replace("\r", "");
        }
        a(Parameters.DEVICE, strReplace);
    }

    private void e() {
        Logger.i(f30993b, "setDevicePersonalInfo start");
        a(Parameters.IMSI1, PersonalInfoHelper.getImsi1());
        a(Parameters.IMSI2, PersonalInfoHelper.getImsi2());
        a(Parameters.ANDROID_ID, PersonalInfoHelper.getAndroidId());
        a(Parameters.ANDROID_AD_ID, PersonalInfoHelper.getAdvertisingId());
        a(Parameters.MAC_ADDRESS, PersonalInfoHelper.getMacAddress());
        a(Parameters.ROOT, Boolean.valueOf(PersonalInfoHelper.isRoot()));
        a(Parameters.UDID, PersonalInfoHelper.getUdid());
        a(Parameters.OAID, PersonalInfoHelper.getOaid());
        a(Parameters.VAID, PersonalInfoHelper.getVaid());
        a(Parameters.AAID, PersonalInfoHelper.getAaid());
    }

    private void f() {
        a(Parameters.INTERNATIONAL, Boolean.valueOf(StepOSUtils.isInternational()));
    }

    private void g() {
        a(Parameters.OS, "StepOS");
    }

    private void h() {
        a(Parameters.OS_TYPE, UxipConstants.f30662a);
    }

    private void i() {
        String strReplace = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(strReplace)) {
            strReplace = strReplace.replace("\n", "").replace("\r", "");
        }
        a(Parameters.OS_VERSION, strReplace);
    }

    private void j() {
        String productModel = StepOSUtils.getProductModel();
        if (!TextUtils.isEmpty(productModel)) {
            productModel = productModel.replace("\n", "").replace("\r", "");
        }
        a(Parameters.PRODUCT_MODEL, productModel);
    }

    private b(C0372b c0372b) throws IllegalArgumentException {
        this.f30994a = new HashMap<>();
        d();
        j();
        c();
        h();
        b();
        i();
        g();
        f();
        e();
        if (c0372b.f30995a != null) {
            a(c0372b.f30995a);
            b(c0372b.f30995a);
            c(c0372b.f30995a);
        }
        Logger.v(f30993b, "DeviceInfo created successfully.");
    }

    private void b() throws IllegalArgumentException {
        String brand = StepOSUtils.getBrand();
        if (!TextUtils.isEmpty(brand)) {
            brand = brand.replace("\n", "").replace("\r", "");
        }
        a(Parameters.BRAND, brand);
    }

    private void a(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null) {
            return;
        }
        this.f30994a.put(str, str2);
    }

    private void c(Context context) {
        if (StepOSUtils.isTablet()) {
            a(Parameters.TER_TYPE, Integer.valueOf(com.stepos.statsapp.v3.lib.plugin.constants.a.PAD.b()));
            return;
        }
        if (StepOSUtils.isBox(context)) {
            a(Parameters.TER_TYPE, Integer.valueOf(com.stepos.statsapp.v3.lib.plugin.constants.a.TV.b()));
        } else if (StepOSUtils.isWearable()) {
            a(Parameters.TER_TYPE, Integer.valueOf(com.stepos.statsapp.v3.lib.plugin.constants.a.WEARABLE.b()));
        } else {
            a(Parameters.TER_TYPE, Integer.valueOf(com.stepos.statsapp.v3.lib.plugin.constants.a.PHONE.b()));
        }
    }

    private void a(String str, Object obj) {
        if (str == null || str.isEmpty() || obj == null) {
            return;
        }
        this.f30994a.put(str, obj);
    }

    public Map<String, Object> a() {
        return this.f30994a;
    }
}
