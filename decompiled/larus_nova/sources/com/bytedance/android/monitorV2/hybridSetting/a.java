package com.bytedance.android.monitorV2.hybridSetting;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.constant.MonitorGlobalSp;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.util.l;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridSettingInitConfig f163059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lz2.b f163060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f163061c;

    public final lz2.b b() {
        lz2.b r100 = null;
    L11:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.a("startup_handle", th);
        return r100;
    L4:
        if (TextUtils.isEmpty(this.f163061c) == false) goto L7;
        return null;
    L7:
        if (this.f163060b != null) goto L9;
        return null;
    L9:
        lz2.b r101 = com.bytedance.android.monitorV2.util.d.f(this.f163061c);     // Catch: Throwable -> L11
        r100 = this.f163060b;     // Catch: Throwable -> L11
        r100.f511346a = r101.f511346a;     // Catch: Throwable -> L11
        return r100;
    }

    public a(HybridSettingInitConfig r100) {
        this.f163059a = r100;
    }

    public final lz2.b c(String r100) {
    L14:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.a("startup_handle", th);
        return null;
    L3:
        if (l.g(new JSONObject(r100), LKBaseResponseModel.ERROR_NO_KEY) != 200) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L20;
        nz2.b.a("ISettingRequestService", "monitor setting request: succeeded");     // Catch: Throwable -> L14
        String r102 = this.f163059a.f163094f;     // Catch: Throwable -> L14
        int r103 = j.f163105a;     // Catch: Throwable -> L14
        lz2.b r104 = com.bytedance.android.monitorV2.util.d.e(r100);     // Catch: Throwable -> L14
        MonitorGlobalSp.f("monitor_setting_response", r100);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r102) == false) goto L10;
    L12:
        this.f163061c = r100;     // Catch: Throwable -> L14
        this.f163060b = r104;     // Catch: Throwable -> L14
        return r104;
    L10:
        if ("0".equals(r102) == true) goto L12;
        MonitorGlobalSp.e("monitor_setting_response_fetch_time", System.currentTimeMillis() / 1000);     // Catch: Throwable -> L14
        goto L12
    L20:
        return null;
    L5:
        r101 = false;
        goto L6
    }
}
