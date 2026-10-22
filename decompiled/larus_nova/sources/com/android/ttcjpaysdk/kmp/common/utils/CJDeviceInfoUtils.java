package com.android.ttcjpaysdk.kmp.common.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/utils/CJDeviceInfoUtils;", "", "<init>", "()V", "getDeviceInfoMapStr", "", "getFullDeviceInfoMapStr", "getRiskInfoStr", "merchantId", "getSDKInfoStr", "getUA", "getNetStatus", "getBioType", "getJailBreak", "currentDPI", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJDeviceInfoUtils {
    public static final int $stable = 0;
    public static final CJDeviceInfoUtils INSTANCE = null;

    static {
        INSTANCE = new CJDeviceInfoUtils();
    }

    private CJDeviceInfoUtils() {
    }

    public final int currentDPI() {
        pd6.b r100 = c.f528682a;
        IKmpCJDeviceInfoService r101 = (IKmpCJDeviceInfoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJDeviceInfoService.class));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.currentDPI();
    }

    public final String getBioType() {
        pd6.b r100 = c.f528682a;
        IKmpCJDeviceInfoService r101 = (IKmpCJDeviceInfoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJDeviceInfoService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getBioType();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getDeviceInfoMapStr() {
        pd6.b r100 = c.f528682a;
        IKmpCJDeviceInfoService r101 = (IKmpCJDeviceInfoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJDeviceInfoService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getDeviceInfoMapStr();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getFullDeviceInfoMapStr() {
        pd6.b r100 = c.f528682a;
        IKmpCJDeviceInfoService r101 = (IKmpCJDeviceInfoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJDeviceInfoService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getFullDeviceInfoMapStr();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getJailBreak() {
        pd6.b r100 = c.f528682a;
        IKmpCJDeviceInfoService r101 = (IKmpCJDeviceInfoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJDeviceInfoService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getJailBreak();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getNetStatus() {
        pd6.b r100 = c.f528682a;
        IKmpCJDeviceInfoService r101 = (IKmpCJDeviceInfoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJDeviceInfoService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getNetStatus();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getSDKInfoStr() {
        pd6.b r100 = c.f528682a;
        IKmpCJDeviceInfoService r101 = (IKmpCJDeviceInfoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJDeviceInfoService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getSDKInfoStr();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getUA() {
        pd6.b r100 = c.f528682a;
        IKmpCJDeviceInfoService r101 = (IKmpCJDeviceInfoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJDeviceInfoService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getUA();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final String getRiskInfoStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "merchantId");
        pd6.b r101 = c.f528682a;
        IKmpCJDeviceInfoService r102 = (IKmpCJDeviceInfoService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJDeviceInfoService.class));
        if (r102 == null) goto L6;
        String r103 = r102.getRiskInfoStr(r100);
        if (r103 == null) goto L6;
        return r103;
    L6:
        return "";
    }
}
