package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.e6;
import com.bytedance.bdtracker.k5;
import com.bytedance.bdtracker.w5;
import com.bytedance.dr.OaidApi;

/* loaded from: classes.dex */
public final class e implements OaidApi {
    public static final w5<Boolean> b = new a();
    public String a;

    public static class a extends w5<Boolean> {
        @Override // com.bytedance.bdtracker.w5
        public Boolean a(Object[] objArr) {
            Context context = (Context) objArr[0];
            return Boolean.valueOf((k5.a(context, "com.huawei.hwid") || k5.a(context, "com.huawei.hwid.tv")) ? true : k5.a(context, "com.huawei.hms"));
        }
    }

    public static class b extends OaidApi.a {
        public long c = 0;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return b.b(context).booleanValue();
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Huawei";
    }

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        b bVar = new b();
        int i = 0;
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
            if (!TextUtils.isEmpty(string)) {
                bVar.a = string;
                bVar.b = Boolean.parseBoolean(string2);
                bVar.c = 202003021704L;
                return bVar;
            }
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "getOaid failed", th, new Object[0]);
        }
        Pair pair = TextUtils.isEmpty(this.a) ? null : (Pair) new e6(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.a), new f(this)).a();
        if (pair != null) {
            bVar.a = (String) pair.first;
            bVar.b = ((Boolean) pair.second).booleanValue();
            try {
                PackageInfo packageInfoA = k5.a(context, this.a, 0);
                if (packageInfoA != null) {
                    i = packageInfoA.versionCode;
                }
            } catch (Throwable th2) {
                LoggerImpl.global().error(1, "getHwIdVersionCode failed", th2, new Object[0]);
            }
            bVar.c = i;
        }
        return bVar;
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        if (k5.a(context, "com.huawei.hwid")) {
            this.a = "com.huawei.hwid";
            return true;
        }
        if (k5.a(context, "com.huawei.hwid.tv")) {
            this.a = "com.huawei.hwid.tv";
            return true;
        }
        this.a = "com.huawei.hms";
        return k5.a(context, "com.huawei.hms");
    }
}
