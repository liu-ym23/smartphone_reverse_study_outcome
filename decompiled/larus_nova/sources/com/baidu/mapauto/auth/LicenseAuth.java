package com.baidu.mapauto.auth;

import android.content.Context;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.util.LogUtil;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public final class LicenseAuth {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile LicenseAuth f31771b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuthCore f31772a;

    public LicenseAuth() {
        this.f31772a = new AuthCore();
    }

    public static LicenseAuth getInstance() {
        if (f31771b != null) goto L15;
        monitor-enter(LicenseAuth.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f31771b != null) goto L9;
        f31771b = new LicenseAuth();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LicenseAuth.class);     // Catch: Throwable -> L11
    L15:
        return f31771b;
    }

    public void loadAuth(Context r110, String r111, String r112, String r113, String r114, int r115, ILicenseAuthListener r116) {
        loadAuth(r110, r111, r112, r113, r114, null, r115, null, r116);
    }

    public void loadAuth(Context r110, String r111, String r112, String r113, String r114, int r115, Map<String, Object> r116, ILicenseAuthListener r117) {
        loadAuth(r110, r111, r112, r113, r114, null, r115, r116, r117);
    }

    public void loadAuth(Context r110, String r111, String r112, String r113, String r114, String r115, int r116, int r210, Map<String, Object> r211, ILicenseAuthListener r212) {
        this.f31772a.a(r110.getApplicationContext(), new AuthCore.AuthParam(r111, r112, r113, r114, r115, r116, r211), r210, r212);
    }

    public void loadAuth(Context r110, String r111, String r112, String r113, String r114, String r115, int r116, Map<String, Object> r210, ILicenseAuthListener r211) {
        this.f31772a.a(r110.getApplicationContext(), new AuthCore.AuthParam(r111, r112, r113, r114, r115, 1, r210), r116, r211);
    }

    public Map<String, Integer> loadLocalAuth(Context r100, String r110, String r111, int r112) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        return this.f31772a.a(r100, null, null, null, r110, r111, r112);
    }

    public Map<String, Integer> loadLocalAuth(Context r100, String r110, String r111, String r112, int r113) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        return this.f31772a.a(r100, null, null, r110, r111, r112, r113);
    }

    public Map<String, Integer> loadLocalAuth(Context r100, String r110, String r111, String r112, String r113, String r114, int r115) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        return this.f31772a.a(r100, r110, r112, r111, r113, r114, r115);
    }

    public void setDebug(Boolean r100) {
        LogUtil.getInstance().openLog(r100);
    }
}
