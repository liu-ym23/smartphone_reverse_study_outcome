package com.stepos.taskrobot.dictionary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.tencent.mmkv.MMKV;
import com.uxsense.ApexSDK;
import j9.m;
import j9.t;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0012"}, d2 = {"Lcom/stepos/taskrobot/dictionary/utils/DeviceInfo;", "", AppAgent.CONSTRUCT, "()V", "getBrand", "", "getModel", "getLanguage", "getSystemVersion", "getAppVersionName", "context", "Landroid/content/Context;", "getAppVersionCode", "", "getDeviceId", "getPersistUuidApi35", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceInfo {
    public static final DeviceInfo INSTANCE = new DeviceInfo();

    private DeviceInfo() {
    }

    private final PackageInfo getPackageInfo(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        k.e(packageInfo, "getPackageInfo(...)");
        return packageInfo;
    }

    private final String getPersistUuidApi35(Context context) throws RuntimeException {
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV();
        k.e(mmkvDefaultMMKV, "defaultMMKV(...)");
        String string = mmkvDefaultMMKV.getString("KEY_UUID_TOKEN", "");
        if (string == null) {
            string = "";
        }
        if (string.length() != 0) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        k.e(string2, "toString(...)");
        String strC0 = t.c0(string2, "-", "");
        mmkvDefaultMMKV.putString("KEY_UUID_TOKEN", strC0);
        return strC0;
    }

    public final long getAppVersionCode(Context context) {
        k.f(context, "context");
        try {
            return getPackageInfo(context).getLongVersionCode();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 1L;
        }
    }

    public final String getAppVersionName(Context context) {
        k.f(context, "context");
        try {
            String str = getPackageInfo(context).versionName;
            String str2 = null;
            String string = str != null ? m.R0(str).toString() : null;
            if (string != null) {
                if (string.length() > 0) {
                    str2 = string;
                }
            }
            return str2 == null ? ApexSDK.VERSION : str2;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return ApexSDK.VERSION;
        }
    }

    public final String getBrand() {
        String str = Build.BRAND;
        String str2 = null;
        String string = str != null ? m.R0(str).toString() : null;
        if (string != null && string.length() > 0) {
            str2 = string;
        }
        return str2 == null ? EnvironmentCompat.MEDIA_UNKNOWN : str2;
    }

    @SuppressLint({"HardwareIds"})
    public final String getDeviceId(Context context) {
        k.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        try {
            String string = Settings.Secure.getString(applicationContext.getContentResolver(), "android_id");
            String str = null;
            String string2 = string != null ? m.R0(string).toString() : null;
            if (string2 != null && string2.length() > 0 && !k.b(string2, "9774d56d682e549c")) {
                str = string2;
            }
            return str == null ? getPersistUuidApi35(applicationContext) : str;
        } catch (Exception e) {
            e.printStackTrace();
            k.c(applicationContext);
            return this.getPersistUuidApi35(applicationContext);
        }
    }

    public final String getLanguage() {
        Locale locale = LocaleList.getDefault().get(0);
        k.c(locale);
        String language = locale.getLanguage();
        String str = null;
        String string = language != null ? m.R0(language).toString() : null;
        if (string != null && string.length() > 0) {
            str = string;
        }
        return str == null ? "zh" : str;
    }

    public final String getModel() {
        String str = Build.MODEL;
        String str2 = null;
        String string = str != null ? m.R0(str).toString() : null;
        if (string != null && string.length() > 0) {
            str2 = string;
        }
        return str2 == null ? EnvironmentCompat.MEDIA_UNKNOWN : str2;
    }

    public final String getSystemVersion() {
        String str = Build.VERSION.RELEASE;
        String str2 = null;
        String string = str != null ? m.R0(str).toString() : null;
        if (string != null && string.length() > 0) {
            str2 = string;
        }
        return str2 == null ? EnvironmentCompat.MEDIA_UNKNOWN : str2;
    }
}
