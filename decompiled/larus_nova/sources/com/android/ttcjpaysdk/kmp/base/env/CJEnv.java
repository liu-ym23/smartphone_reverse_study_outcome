package com.android.ttcjpaysdk.kmp.base.env;

import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/env/CJEnv;", "", "<init>", "()V", "getHostAid", "", "getDeviceId", "get3DigitSDKVersion", "get4DigitSDKVersion", "isBoeEnv", "", "isLocalTest", "isShowBadge", "getCustomCookie", "isSaasEnv", "getCurrentSaasScene", "getAccessToken", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJEnv {
    public static final int $stable = 0;
    public static final CJEnv INSTANCE = null;

    static {
        INSTANCE = new CJEnv();
    }

    private CJEnv() {
    }

    public final String get3DigitSDKVersion() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 == null) goto L6;
        String r102 = r101.get3DigitSDKVersion();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String get4DigitSDKVersion() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 == null) goto L6;
        String r102 = r101.get4DigitSDKVersion();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getAccessToken() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getAccessToken();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getCurrentSaasScene() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getCurrentSaasScene();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getCustomCookie() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getCustomCookie();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getDeviceId() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getDeviceId();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getHostAid() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getHostAid();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final boolean isBoeEnv() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isBoeEnv();
    }

    public final boolean isLocalTest() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isLocalTest();
    }

    public final boolean isSaasEnv() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isSaasEnv();
    }

    public final boolean isShowBadge() {
        b r100 = c.f528682a;
        IKmpCJEnvService r101 = (IKmpCJEnvService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJEnvService.class));
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isShowBadgeEnv();
    }
}
