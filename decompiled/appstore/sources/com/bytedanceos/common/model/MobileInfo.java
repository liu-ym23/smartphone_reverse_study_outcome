package com.bytedanceos.common.model;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.DeviceUtil;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.k;
import com.bytedanceos.common.utils.ReflectTool;
import com.bytedanceos.common.utils.m;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class MobileInfo {
    public final boolean fake;
    public String mAndroid_Id;
    public String mCarrier;
    private String mClient_Id;
    public String mCuid;
    public float mDensity;
    public String mDevice;
    public int mDpi;
    public String mImei1;
    public String mImei2;
    public String mMacAdress;
    public String mMcc;
    public int mOs_level;
    public String mOvr;
    public String mResolution;
    public String mSerialno;
    public int mVersionCode;
    public String mVersionName;

    public MobileInfo() {
        this.mCuid = "";
        this.mOvr = "";
        this.mDevice = "";
        this.mResolution = "";
        this.mClient_Id = "";
        this.mMcc = "";
        this.mAndroid_Id = "";
        this.mVersionName = "";
        this.mSerialno = "";
        this.mCarrier = "";
        this.mImei1 = "";
        this.mImei2 = "";
        init();
        this.fake = false;
    }

    private String getAdsParamsCuid() {
        String r10 = b0.n().s("cuid", null, BaseApplication.c());
        if (TextUtils.isEmpty(r10) == false) goto L6;
        r10 = k.f(this.mClient_Id + this.mAndroid_Id + UUID.randomUUID().toString());
        b0.n().H("cuid", r10, null, BaseApplication.c());
    L6:
        return r10.toUpperCase();
    }

    private void init() {
        this.mClient_Id = DeviceUtil.e();
        this.mAndroid_Id = DeviceUtil.a();
        this.mCuid = getAdsParamsCuid();
        this.mOvr = Build.VERSION.RELEASE;
        this.mOs_level = Build.VERSION.SDK_INT;
        this.mDevice = Build.BRAND + "_" + com.bytedanceos.common.toolbox.d.f10009a;
        this.mSerialno = Build.SERIAL;
        this.mCarrier = DeviceUtil.b();
        DisplayMetrics r10 = BaseApplication.c().getResources().getDisplayMetrics();
        this.mResolution = r10.widthPixels + "_" + r10.heightPixels;
        this.mDpi = r10.densityDpi;
        this.mDensity = r10.density;
        this.mMacAdress = "";
        this.mMcc = ReflectTool.getCountryCode();
        PackageInfo r11 = BaseApplication.c().getPackageManager().getPackageInfo(BaseApplication.c().getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L5
        this.mVersionName = r11.versionName;     // Catch: PackageManager.NameNotFoundException -> L5
        this.mVersionCode = r11.versionCode;     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        this.mImei1 = m.a(BaseApplication.c(), 0);
        this.mImei2 = m.a(BaseApplication.c(), 1);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String getClientId() {
        if (TextUtils.isEmpty(this.mClient_Id) == false) goto L6;
        this.mClient_Id = DeviceUtil.e();
    L6:
        return this.mClient_Id;
    }

    public boolean isValid() {
        if (this.fake == false) goto L5;
        return false;
    L5:
        String r10 = this.mImei1;
        if (r10 != null) goto L8;
    L17:
        return false;
    L8:
        if (r10.isEmpty() == true) goto L17;
        String r11 = this.mAndroid_Id;
        if (r11 == null) goto L17;
        if (r11.isEmpty() == true) goto L17;
        return true;
    }

    public MobileInfo(boolean r10) {
        this.mCuid = "";
        this.mOvr = "";
        this.mDevice = "";
        this.mResolution = "";
        this.mClient_Id = "";
        this.mMcc = "";
        this.mAndroid_Id = "";
        this.mVersionName = "";
        this.mSerialno = "";
        this.mCarrier = "";
        this.mImei1 = "";
        this.mImei2 = "";
        if (r10 == true) goto L5;
        init();
    L5:
        this.fake = r10;
    }
}
